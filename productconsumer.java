import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) wait();
        queue.add(item);
        System.out.println("Produced: " + item);
        notify(); // Notify consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notify(); // Notify producer
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedQueue buffer = new SharedQueue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
