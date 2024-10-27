package dev.mayankg.multithreading.executorframework.concept4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Example2 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> scheduledFuture = scheduler.scheduleWithFixedDelay(
                () -> {
                    try {
                        System.out.println("Task execution started...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                },
                5,
                5,
                TimeUnit.SECONDS
        );

        ScheduledFuture<?> scheduleFuture = scheduler.schedule(
                () -> {
                    System.out.println("Initiating shutdown...");
                    scheduler.shutdown();
                },
                20,
                TimeUnit.SECONDS
        );
    }
}