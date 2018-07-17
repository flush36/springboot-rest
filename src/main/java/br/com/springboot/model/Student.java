package br.com.springboot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {

    private int id;
    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }


    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this(name);
        this.id = id;
    }

    public  Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private static void studentRepository() {
        studentList = new ArrayList<>(Arrays.asList(new Student(1,"Deku"),
                new Student(2,"Todoroki")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
