package Singletone;

import java.util.concurrent.*;

public class TestLazyMan2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LazyMan2 lazyMan1 = LazyMan2.getInstance();
        LazyMan2 lazyMan2 = LazyMan2.getInstance();
        System.out.println(lazyMan1==lazyMan2);//是同一个实例

        Callable<LazyMan2> callable = new Callable<LazyMan2>() {
            @Override
            public LazyMan2 call() throws Exception {
                    return LazyMan2.getInstance();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<LazyMan2> submit = executorService.submit(callable);
        Future<LazyMan2> submit1 = executorService.submit(callable);
        LazyMan2 lazyMan11 = submit.get();
        LazyMan2 lazyMan12 = submit1.get();

        System.out.println(lazyMan11==lazyMan12);

    }
}
