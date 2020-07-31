package Singletone;

/**
 * 饿汉式：在类初始化的时候直接创建实例对象---不管需不需要都会创建
 * （1）构造器私有化
 * （2）自行创建，并且用静态变量保存
 *  (3)向外提供实例
 * （4）强调这是单例--final
 */
public class Singletone1 {//这就是最简单的单例
    public static final Singletone1 INSTANCE = new Singletone1();
    private  Singletone1(){}
}
