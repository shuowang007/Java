package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁实现
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();//null

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"    come in...");
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println("我他妈就不给你放锁，你能咋地");
        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"    invoke unlock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
                spinLockDemo.myLock();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    spinLockDemo.myUnlock();
                }

        },"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        },"t2").start();
    }
}
