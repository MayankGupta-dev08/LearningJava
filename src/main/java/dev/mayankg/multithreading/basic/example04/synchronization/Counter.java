package dev.mayankg.multithreading.basic.example04.synchronization;

class Counter {
    private int count = 0;

    /**
     * Use 'synchronized' before method 'return type' making full method thread safe. <br>
     * If we want to make only a specific part of the method thread safe, then we can use 'synchronized' with a block. <br>
     * The part of the code, which is affected by multiple thread access simultaneously, is called 'critical section'. <br>
     * Before synchronization, this condition is called 'Race Condition'. <br>
     * After using 'synchronized' keyword, we achieve 'Mutual Exclusion'.
     */
    public synchronized void increment() {
//        synchronized (this) {
            count++;
//        }
    }

    public int getCount() {
        return count;
    }
}