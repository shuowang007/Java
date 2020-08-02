package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo{
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendMSG();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                phone.sendMSG();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(phone,"t3");
        Thread thread1 = new Thread(phone,"t4");
        thread.start();
        thread1.start();
    }



}

class Phone  implements Runnable{
    public synchronized void sendMSG() throws Exception{
        System.out.println(Thread.currentThread().getName()+ "  invoke sendMSG");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"    invoke sendEmail");;
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ "  invoke get");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ "  invoke set");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();;
        }
    }
}
