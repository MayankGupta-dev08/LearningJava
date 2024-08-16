package dev.mayankg.multithreading.basic.example05.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
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

        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            if (balance >= amount) {
                try {
                    System.out.println(currThreadName + " proceeding with the withdrawal.");
                    balance -= amount;
                    Thread.sleep(3000); // Simulate the time taken to process the withdrawal
                    System.out.println(currThreadName + " completed withdrawal. Remaining balance=" + getBalance() + "/-");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(currThreadName + " couldn't withdraw amount=" + amount + " due to insufficient balance!");
            }
        } else {
            System.out.println(currThreadName + " couldn't acquire lock, will once again in 1 second.");
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
