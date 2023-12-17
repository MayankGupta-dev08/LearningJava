package dev.mayankg.serialization_deserialization;

public class Student {
    private int rollNo;
    private String name;
    private String classNSection;

    public Student(int rollNo, String name, String classNSection) {
        this.rollNo = rollNo;
        this.name = name;
        this.classNSection = classNSection;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassNSection() {
        return classNSection;
    }

    public void setClassNSection(String classNSection) {
        this.classNSection = classNSection;
    }
}