package com.yhz.mybatis.po;

import java.util.List;

/**
 * @author yanhuanzhan
 * @date 2023/3/14 - 17:21
 */
public class Teacher {
    String name;
    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Student {
        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
