package Singletone;

public class TestSingleton3 {
    public static void main(String[] args) {
        Singleton3 singleton3 = Singleton3.INSTANCE;
        System.out.println(singleton3);
    }
}
