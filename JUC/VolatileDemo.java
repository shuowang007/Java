package JUC;

/**
 * volatile原子性验证
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNum60();
            System.out.println(Thread.currentThread().getName()+" updated num value: "+myData.number);
        },"AAA").start();
        while (myData.number == 0){}
        System.out.println("结束运行，get number value"+myData.number);
    }
}

class MyData{
    volatile int number = 0;//此处的volatile保证可见性，程序能正常结束
    public void addNum60(){
        this.number = 60;
    }
}