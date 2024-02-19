package dev.mayankg.design.patterns.creational.objectPool.example;

class Client {
    private static final ObjectPool<Bitmap> imagePool =
            new ObjectPool<>(() -> new Bitmap("Logo.bmp"), 5);

    public static void main(String[] args) {
        Bitmap b1 = imagePool.get();
        b1.setLocation(new Point2D(10, 10));
        Bitmap b2 = imagePool.get();
        b2.setLocation(new Point2D(-10, 0));

        b1.draw();
        b2.draw();

        imagePool.release(b1);
        imagePool.release(b2);
    }
}