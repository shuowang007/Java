package pdd;

public class recur {
        public static void main(String args[]) {
            float f[][] = new float[5][];
            System.out.println(f);
            split(12);
        }
        public static int split(int number) {
            if (number > 1) {
                if (number % 2 != 0) System.out.print(split((number + 1) / 2));
                System.out.print(split(number / 2));
            }
            return number;
        }
}
class A{
    public A foo(){return this;}
}
class B extends A{
    public A foo(){
        return this;
    }
}
class C extends B

{
    public A foo(B b){return b;}

}