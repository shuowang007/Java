package Singletone;

public class LazyManMultiThread2 {
    private static volatile LazyManMultiThread2 instance = null;
    private LazyManMultiThread2(){
        System.out.println(Thread.currentThread().getName()+"初始化。。。。。。。");
    }

    //DCL模式  double check lock 双端检锁机制
    public static LazyManMultiThread2 getInstance(){
        if (instance == null) {//但是DCL单例这里的代码也会产生指令重排的问题，所以要加volatile
            synchronized (LazyManMultiThread2.class) {
                if (instance == null){
                    instance = new LazyManMultiThread2();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //LazyManMultiThread1 lazyManMultiThread1 = LazyManMultiThread1.getInstance();
        //LazyManMultiThread1 lazyManMultiThread11 = LazyManMultiThread1.getInstance();

        //System.out.println(lazyManMultiThread1.getInstance()==lazyManMultiThread11.getInstance());

        for (int i = 0; i < 10; i++) {//并发模式下，普通的单例满足不了要求，加sync锁太重，不行
            new Thread(()->{
                LazyManMultiThread2.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
