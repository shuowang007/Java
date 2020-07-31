package JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic {
    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                for (int j=0;j<100;j++) {
                    myData2.addNum();
                    myData2.atomicAddNum();
                }
                System.out.println(Thread.currentThread().getName()+", number: "+myData2.number);
            },String.valueOf(i)).start();
        }//int++是三步操作，从工作内存放回主内存的时候可能被写覆盖，所以不能保证原子性
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("main number= "+myData2.number);
        System.out.println("atomicInteger= "+myData2.atomicInteger);
    }
}
class MyData2{
    volatile int number = 0;//此处加了volatile也是总数不到20000的，乞丐版的synchronized
    public void addNum(){
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicAddNum(){
        atomicInteger.getAndIncrement();
    }
}
