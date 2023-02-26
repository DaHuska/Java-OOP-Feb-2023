package com.company._03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.studentMap;
    }

    public void addStudent(String name, Student student) {
        this.studentMap.put(name, student);
    }
}
