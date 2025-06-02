
// Bank.java
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;

// Bank class
class Bank {
    private String bankID;
    private String name;
    private String location;
    private List<ATM> atms;

    public void createAccount(Customer customer, Account account) {
        // Implementation
    }

    public void closeAccount(Account account) {
        // Implementation
    }

    public List<ATM> getATMList() {
        return atms;
    }
}

// ATM class
class ATM {
    private String atmID;
    private String location;
    private boolean isOperational;

    public void withdraw(Account account, double amount) {
        // Implementation
    }

    public void deposit(Account account, double amount) {
        // Implementation
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }
}

// Customer class
class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phone;
    private List<Account> accounts;

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

// Account class
class Account {
    private String accountNo;
    private double balance;
    private String accountType;
    private String dateOpened;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("credit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("debit", amount));
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Transaction class
class Transaction {
    private String transactionID;
    private LocalDateTime date;
    private double amount;
    private String type; // "credit" or "debit"

    public Transaction(String type, double amount) {
        this.transactionID = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    public void process() {
        // Implementation (could be logging or updating)
    }
}
