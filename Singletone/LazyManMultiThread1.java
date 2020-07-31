package Singletone;

public class LazyManMultiThread1 {
    private static LazyManMultiThread1 instance = null;
    private LazyManMultiThread1(){
        System.out.println(Thread.currentThread().getName()+"初始化。。。。。。。");
    }
    public static LazyManMultiThread1 getInstance(){
        if (instance == null){
            instance = new LazyManMultiThread1();
        }
        return instance;
    }

    public static void main(String[] args) {
        //LazyManMultiThread1 lazyManMultiThread1 = LazyManMultiThread1.getInstance();
        //LazyManMultiThread1 lazyManMultiThread11 = LazyManMultiThread1.getInstance();

        //System.out.println(lazyManMultiThread1.getInstance()==lazyManMultiThread11.getInstance());

        for (int i = 0; i < 10; i++) {//并发模式下，普通的单例满足不了要求，加sync锁太重，不行
            new Thread(()->{
                LazyManMultiThread1.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
