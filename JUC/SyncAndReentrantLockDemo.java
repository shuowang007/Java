package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AA打印5次，BB10次，CC15次
 */
class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while (number!=1){//等待
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {//干活
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //通知
            number = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while (number!=2){//等待
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {//干活
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //通知
            number = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while (number!=3){//等待
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {//干活
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //通知
            number = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareResource.print15();
            }
        },"C").start();
    }

}
