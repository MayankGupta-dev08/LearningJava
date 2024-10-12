package dev.mayankg.generics.other;

class Person implements Child {
    private String name;
    private String className;

    public Person(String name, String className) {
        this.name = name;
        this.className = className;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
