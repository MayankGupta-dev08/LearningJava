package dev.mayankg.multithreading.executorframework.example1;

class RunnableTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.currentThread().setName("RunnableTaskThread");
            Thread.sleep(1000);
            System.out.println("Runnable task executed by thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}