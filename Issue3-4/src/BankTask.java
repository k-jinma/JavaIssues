public class BankTask implements Runnable {
    public static final int DEPOSIT = 1;
    public static final int WITHDRAW = 2;
    public static final int TRANSFER = 3;

    private int operation;
    private Bank bank;
    private int accountId;
    private int toAccountId;
    private int amount;

    public BankTask(int operation, Bank bank, int accountId, int toAccountId, int amount) {
        this.operation = operation;
        this.bank = bank;
        this.accountId = accountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    @Override
    public void run() {
        switch (operation) {
            case DEPOSIT:
                bank.deposit(accountId, amount);
                break;
            case WITHDRAW:
                bank.withdraw(accountId, amount);
                break;
            case TRANSFER:
                bank.transfer(accountId, toAccountId, amount);
                break;
        }
    }
}
