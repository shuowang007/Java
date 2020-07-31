package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ArrList {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        //List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                String substring = UUID.randomUUID().toString().substring(0, 8);
                list.add(substring);
                System.out.println("substring= "+substring);
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * 1.故障现象java.util.ConcurrentModificationException
         * 2.导致原因
         *      并发争抢修改导致：一个人正在写入，另一个线程来争抢，导致数据不一致异常，并发修改异常
         * 3.解决方案
         *      1.用Vector，内部加了锁
         *      2.Collections.synchronizedList(new ArrayList<>());
         *      3.new CopyOnWriteArrayList<>();
         * 4.优化建议
         */
    }
}
