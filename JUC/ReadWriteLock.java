package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在写入： "+key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入完成。。");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwlock.readLock().lock();
        try {
            System.out.printf(Thread.currentThread().getName()+" 正在读取：");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取完成。。。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
    }
}
public class ReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i=0;i<5;i++) {
            final int ii = i;
            new Thread(()->{
                myCache.put(ii+"",ii+"");
            },String.valueOf(i)).start();
        }
        for (int i=0;i<5;i++) {
            final int ii = i;
            new Thread(()->{
                myCache.get(ii+"");
            },String.valueOf(i)).start();
        }
    }
}
