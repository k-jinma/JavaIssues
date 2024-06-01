public class BankAccount {
    private int id;
    private String ownerName;
    private int balance;

    public BankAccount(int id, String ownerName) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
