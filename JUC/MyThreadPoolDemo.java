package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程创建方法
 * thread类
 * runnable接口--没有返回值，不抛异常
 * callable接口--有返回值，抛异常
 * 线程池
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i=0;i<10;i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"doing");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
        System.out.println(Integer.MAX_VALUE);
    }
}
