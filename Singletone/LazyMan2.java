package Singletone;

public class LazyMan2 {
    private static LazyMan2 instance;
    private LazyMan2(){}
    public static LazyMan2 getInstance(){
        if (instance == null) {//这一步为了提升效率
            synchronized (LazyMan2.class) {
                if (instance == null){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    instance = new LazyMan2();
                }
            }
        }
        return instance;
    }
}
