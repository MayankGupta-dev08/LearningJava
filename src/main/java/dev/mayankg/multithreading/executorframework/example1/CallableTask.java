package dev.mayankg.multithreading.executorframework.example1;

import java.util.concurrent.Callable;

class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.currentThread().setName("CallableTaskThread");
        Thread.sleep(1000);
        System.out.println("Callable task executed by thread: " + Thread.currentThread().getName());
        return "Callable task executed successfully!";
    }
}