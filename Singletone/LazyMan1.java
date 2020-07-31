package Singletone;

import java.util.concurrent.TimeUnit;

/**
 * 构造器私有化
 * 用静态变量保存这个唯一的实例
 * 提供一个静态方法获取这个实例对象
 */
public class LazyMan1 {
    private static LazyMan1 instance;
    private LazyMan1(){}
    public static LazyMan1 getInstance() throws InterruptedException {
        if (instance == null){
            Thread.sleep(100);
            instance = new LazyMan1();
        }
        return instance;
    }
}
