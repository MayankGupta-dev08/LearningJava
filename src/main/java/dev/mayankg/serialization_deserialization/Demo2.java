package dev.mayankg.serialization_deserialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Demo2  {
    public static void main(String[] args) {
        Student s1 = new Student(1001, "Chetan", "XA");
        Student s2 = new Student(1006, "Paras", "XB");
        Student s3 = new Student(1021, "Mayank", "XE");

        College iitD = new College();
        ArrayList<Student> list = new ArrayList<>();
        list.add(s3);
        list.add(s2);
        list.add(s1);
        iitD.setStudentsList(list);
        ArrayList<Student> temp = iitD.getStudentsList();
        for (Student val : temp) {
            System.out.println(val.getName() + ": " + val.getRollNo() + " and " + val.getClassNSection());
        }
        //serialization in XML file
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("iitDFile.xml")));
            xmlEncoder.writeObject(iitD);
            xmlEncoder.close();

            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("iitDFile.xml")));
            College c = (College) xmlDecoder.readObject();
            ArrayList<Student> al = c.getStudentsList();
            for (Student val : al) {
                System.out.println(val.getName() + ": " + val.getRollNo() + " and " + val.getClassNSection());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}