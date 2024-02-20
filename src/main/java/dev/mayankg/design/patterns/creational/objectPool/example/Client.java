package dev.mayankg.design.patterns.creational.objectPool.example;

class Client {
    //Loading 5 objects of bitmap in the image pool with the same name
    private static final ObjectPool<Bitmap> imagePool =
            new ObjectPool<>(() -> new Bitmap("Logo.bmp"), 5);

    public static void main(String[] args) {
        //Getting objects from objectPool and using them as regular objects
        Bitmap b1 = imagePool.get();
        b1.setLocation(new Point2D(10, 10));
        Bitmap b2 = imagePool.get();
        b2.setLocation(new Point2D(-10, 0));

        b1.draw();
        b2.draw();

        //Putting them back in the objectPool once their work is done!
        imagePool.release(b1);
        imagePool.release(b2);
    }
}