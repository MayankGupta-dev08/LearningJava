package dev.mayankg.multithreading.executorframework.concept7;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class OnlineOrderProcessing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Step 1: Place an order and receive order ID
        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> placeOrder("Customer123"));

        // Step 2: Process payment once order is placed
        CompletableFuture<String> paymentFuture = orderFuture.thenApplyAsync(orderId -> processPayment(orderId));

        // Step 3: Update inventory only after payment is successful
        CompletableFuture<Void> inventoryFuture = paymentFuture.thenAcceptAsync(orderId -> updateInventory(orderId));

        // Step 4: Send notification once inventory is updated
        CompletableFuture<Void> notificationFuture = inventoryFuture.thenRunAsync(() -> sendNotification("Customer123"));

        // Wait for the notification to complete
        notificationFuture.get();
        System.out.println("Order processing complete!");
    }

    // Place an order and return an order ID
    private static String placeOrder(String customerId) {
        sleep(1000); // Simulate delay
        System.out.println("Order placed for customer: " + customerId);
        return "Order123"; // Simulated order ID
    }

    // Process payment for the given order ID
    private static String processPayment(String orderId) {
        sleep(800); // Simulate delay
        System.out.println("Payment processed for order: " + orderId);
        return orderId;
    }

    // Update inventory based on the given order ID
    private static void updateInventory(String orderId) {
        sleep(500); // Simulate delay
        System.out.println("Inventory updated for order: " + orderId);
    }

    // Send notification to the customer
    private static void sendNotification(String customerId) {
        sleep(300); // Simulate delay
        System.out.println("Notification sent to customer: " + customerId);
    }

    // Helper method to simulate delay
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}