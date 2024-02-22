package dev.mayankg.design.patterns.structural.composite.example;

/**
 * The component base class for a composite pattern
 * defines operations applicable both leaf & composite
 */
abstract class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //main operation method
    public abstract void ls();

    public abstract void addFile(File file);

    public abstract File[] getFiles();

    public abstract boolean removeFile(File file);
}