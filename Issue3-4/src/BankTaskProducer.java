import java.util.Queue;
import java.util.Random;

public class BankTaskProducer implements Runnable {
    private Queue<BankTask> queue;
    private Bank bank;
    private Random random = new Random();

    public BankTaskProducer(Queue<BankTask> queue, Bank bank) {
        this.queue = queue;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int operation = random.nextInt(3) + 1;
            int accountId = random.nextInt(10);
            int toAccountId = random.nextInt(10);
            int amount = random.nextInt(10000);

            BankTask task = new BankTask(operation, bank, accountId, toAccountId, amount);
            synchronized (queue) {
                queue.add(task);
                queue.notify();
            }
        }
    }
}
