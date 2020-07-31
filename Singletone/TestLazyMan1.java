package Singletone;

import java.util.concurrent.*;

public class TestLazyMan1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LazyMan1 lazyMan1 = LazyMan1.getInstance();
        LazyMan1 lazyMan2 = LazyMan1.getInstance();
        System.out.println(lazyMan1==lazyMan2);//是同一个实例

        Callable<LazyMan1> callable = new Callable<LazyMan1>() {
            @Override
            public LazyMan1 call() throws Exception {
                    return LazyMan1.getInstance();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<LazyMan1> submit = executorService.submit(callable);
        Future<LazyMan1> submit1 = executorService.submit(callable);
        LazyMan1 lazyMan11 = submit.get();
        LazyMan1 lazyMan12 = submit1.get();

        System.out.println(lazyMan11==lazyMan12);

    }
}
