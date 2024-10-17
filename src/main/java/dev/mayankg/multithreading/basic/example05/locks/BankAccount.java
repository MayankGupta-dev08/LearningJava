package dev.mayankg.multithreading.basic.example05.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

@SuppressWarnings("unused")
class BankAccount {
    private static final Logger TRACE_LOGGER = Logger.getLogger(BankAccount.class.getName());
    private final ReentrantLock lock = new ReentrantLock();
    private double balance;

    public BankAccount() {
        this.balance = 100.00d;
    }

    public void withdraw(double amount) throws InterruptedException {
        if (amount <= 0)
            throw new IllegalArgumentException("Please withdraw a valid amount");

        String currThreadName = Thread.currentThread().getName();
        System.out.println(currThreadName + " attempting to withdraw " + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {    // Try to acquire lock for 1 second
                try {
                    if (balance >= amount) {
                        System.out.println(currThreadName + " proceeding with the withdrawal.");
                        balance -= amount;
                        Thread.sleep(3000); // Simulate the time taken to process the withdrawal
                        System.out.println(currThreadName + " completed withdrawal. Remaining balance=" + getBalance() + "/-");
                    } else {
                        System.out.println(currThreadName + " couldn't withdraw amount=" + amount + " due to insufficient balance!");
                    }
                } finally {
                    lock.unlock();  // Release the lock
                }
            } else {
                System.out.println(currThreadName + " couldn't acquire lock, try once again in 1 second.");
            }
        } catch (InterruptedException e) {
            TRACE_LOGGER.severe(e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Please deposit a valid amount");

        synchronized (this) {   // Implicit Lock is used
            System.out.println(Thread.currentThread().getName() + " depositing " + amount);
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
