package com.faculty;

class Students {

    enum Course {
        MATHEMATICS, PHYSICS, ECONOMY, PHILOSOPHY;
    }

    String name;
    Course course;

    public void setName(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }

    public Students(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
