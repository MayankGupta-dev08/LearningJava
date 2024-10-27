package dev.mayankg.multithreading.executorframework.concept4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Example1 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executed at every 5 seconds"),
                0,
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