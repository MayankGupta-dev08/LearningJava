package dev.mayankg.clean_coding.unit3Refactoring.menuAccess;

public class Role {
    String name;

    public Role(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}