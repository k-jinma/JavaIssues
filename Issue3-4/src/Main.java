import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Queue<BankTask> queue = new LinkedList<>();

        // 初期口座作成
        for (int i = 0; i < 10; i++) {
            bank.createAccount("名義人" + (i + 1));
        }

        BankTaskProducer producer = new BankTaskProducer(queue, bank);
        BankTaskConsumer consumer = new BankTaskConsumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.printAccounts();
    }
}
