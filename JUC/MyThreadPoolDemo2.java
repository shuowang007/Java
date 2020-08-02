package JUC;

import java.util.concurrent.*;

/**
 * 线程创建方法
 * thread类
 * runnable接口--没有返回值，不抛异常
 * callable接口--有返回值，抛异常
 * 线程池
 *
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"running");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
