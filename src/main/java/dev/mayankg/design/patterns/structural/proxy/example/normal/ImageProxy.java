package dev.mayankg.design.patterns.structural.proxy.example.normal;

import dev.mayankg.design.patterns.structural.proxy.example.common.BitmapImage;
import dev.mayankg.design.patterns.structural.proxy.example.common.Image;
import dev.mayankg.design.patterns.structural.proxy.example.common.Point2D;

//Proxy class.
class ImageProxy implements Image {
    private String name;
    private BitmapImage image;
    private Point2D location;

    public ImageProxy(String name) {
        this.name = name;
    }

    @Override
    public Point2D getLocation() {
        if (image != null) {
            return image.getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(Point2D point2d) {
        if (image != null) {
            image.setLocation(point2d);
        } else {
            location = point2d;
        }
    }

    @Override
    public void render() {
        if (image == null) {
            image = new BitmapImage(name);
            if (location != null) {
                image.setLocation(location);
            }
        }
        image.render();
    }
}