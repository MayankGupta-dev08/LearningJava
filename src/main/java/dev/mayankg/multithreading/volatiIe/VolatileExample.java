package dev.mayankg.multithreading.volatiIe;

class SharedResource {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Setting flag to true...");
        this.flag = true;
    }

    public void isFlagTrue() {
        long startTime = System.currentTimeMillis();
        while (!flag) {
//            System.out.println("Waiting for flag to be set to true...");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to read flag as true: " + (endTime - startTime) + "ms");
        System.out.println("Flag is true!");
    }
}

class VolatileExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread writerThread = new Thread(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Writer thread interrupted.");
                        Thread.currentThread().interrupt();
                    }
                    sharedResource.setFlagTrue();
                },
                "Writer Thread"
        );

        Thread readerThread = new Thread(
                () -> sharedResource.isFlagTrue(),
                "Reader Thread"
        );

        writerThread.start();
        readerThread.start();
    }
}