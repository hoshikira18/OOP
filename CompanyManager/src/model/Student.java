package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Override toString for easy printing of Student objects
    @Override
    public String toString() {
        return name;
    }

}
