package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 队列
 * 阻塞队列
 *
 * 分类：
 * 1. ArrayBkockingQueue：数组结构构成的有界阻塞队列
 * 2. LinkedBlockingQueue：链表结构组成的有界阻塞队列
 * 3. PriorityBlockingQueue：支持优先级排序的无界阻塞队列
 * 4. DelayQueue：优先级队列实现的延迟无界阻塞队列
 * 5. SynchronousQueue：不存储元素的阻塞队列，也就是单个元素的队列
 * 6. LinkedTransferQueue：链表结构构成的无界阻塞队列
 * 7. LinkedBlockigDeque：链表结构组成的双向阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        String[] strings = new String[5];
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("f"));//java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        blockingQueue.put("2");
        blockingQueue.take();
        //System.out.println(blockingQueue.remove());//java.util.NoSuchElementException

        int key = 2;
        key = (key<<1) + 1;
        System.out.println(key);

    }
}
