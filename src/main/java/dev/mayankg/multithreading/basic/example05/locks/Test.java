package dev.mayankg.multithreading.basic.example05.locks;

import java.util.logging.Logger;

/**
 * - Intrinsic Locks: These are built into every java object, we might not be able to see them.
 * When we use the 'synchronized' keyword in a method or block, then these are automatically used. <br>
 * - Explicit Locks: These are advanced locks that can be controlled using the Lock class of 'java.util.concurrent.locks'.
 * Using this, we can explicitly lock and unlock an object according to our own will. <br>
 */
class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        BankAccount sbiAccount = new BankAccount();
        Runnable withdraw50FromSBIAccount = () -> {
            try {
                sbiAccount.withdraw(50.00d);
            } catch (InterruptedException e) {
                LOGGER.severe(e.getLocalizedMessage());
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(withdraw50FromSBIAccount, "t1");
        Thread t2 = new Thread(withdraw50FromSBIAccount, "t2");

        t1.start();
        t2.start();
    }
}