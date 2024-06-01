import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextId = 0;

    public synchronized int createAccount(String ownerName) {
        int id = nextId++;
        accounts.put(id, new BankAccount(id, ownerName));
        System.out.println("口座開設 id:" + id);
        return id;
    }

    public synchronized void deposit(int accountId, int amount) {
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
            System.out.println("預金振込 id:" + accountId + ", 振込金額:" + amount);
        }
    }

    public synchronized void withdraw(int accountId, int amount) {
        BankAccount account = accounts.get(accountId);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("預金引き下ろし id:" + accountId + ", 引き下ろし金額:" + amount);
        }
    }

    public synchronized void transfer(int fromAccountId, int toAccountId, int amount) {
        BankAccount fromAccount = accounts.get(fromAccountId);
        BankAccount toAccount = accounts.get(toAccountId);
        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("預金振込 振込元id:" + fromAccountId + ", 振込先id:" + toAccountId + ", 振込金額:" + amount);
        }
    }

    public synchronized void printAccounts() {
        for (BankAccount account : accounts.values()) {
            System.out.println("口座番号:" + account.getId() + ", 口座名義人:" + account.getOwnerName() + ", 口座残高:" + account.getBalance());
        }
    }
}
