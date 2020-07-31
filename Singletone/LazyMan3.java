package Singletone;

/**
 * 在内部类被加载和初始化的时候，才创建这个instance实例对象
 * 内部类不会随着外部类的加载和初始化而初始化，他是单独需要加载初始化的
 * 因为是在内部类初始化，所有它是安全的
 */
public class LazyMan3 {
    private LazyMan3(){}

    private static class InnerClass{
        private static final LazyMan3 INSTANCE = new LazyMan3();
    }
    public static LazyMan3 getInstance(){
        return InnerClass.INSTANCE;
    }
}
