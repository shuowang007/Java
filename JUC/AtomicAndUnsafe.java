package JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAndUnsafe {
    AtomicInteger atomicInteger = new AtomicInteger(1);
    public void atimicAdd(){
        atomicInteger.getAndIncrement();
    }
    public static void main(String[] args) {

    }
}
