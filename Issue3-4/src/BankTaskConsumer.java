import java.util.Queue;

public class BankTaskConsumer implements Runnable {
    private Queue<BankTask> queue;

    public BankTaskConsumer(Queue<BankTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            BankTask task;
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                task = queue.poll();
            }
            if (task != null) {
                task.run();
            }
        }
    }
}
