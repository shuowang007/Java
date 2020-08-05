package pdd;

public class Test {
    public static class A {
        private B ref;
        public void setB(B b) {
            ref = b;
        }
    }
    public static class B {
        private A ref;
        public void setA(A a) {
            ref = a;
        }
    }
    public static void main(String args[]) {
        start();
    }
    public static void start() { A a = new A();
        B b = new B();
        a.setB(b);
        b = null; //
        a = null;
    }
}



