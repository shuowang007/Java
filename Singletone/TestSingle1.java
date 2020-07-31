package Singletone;

public class TestSingle1 {
    public static void main(String[] args) {
        Singletone1 s = Singletone1.INSTANCE;
        System.out.println(s);
    }
}
