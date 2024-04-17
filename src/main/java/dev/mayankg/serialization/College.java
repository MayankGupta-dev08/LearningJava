package dev.mayankg.serialization;

import java.util.ArrayList;

public class College {
    private ArrayList<Student> studentsList;

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
}