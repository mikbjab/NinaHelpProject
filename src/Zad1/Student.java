package Zad1;

import java.util.Objects;

public class Student {
    //pola
    private String name;
    private String index;
    public boolean active;
    private int age;

    private boolean nowePole;

    //konstruktory
    public Student(String name, String index, boolean active, int age) {
        this.name = name;
        this.index = index;
        this.active = active;
        this.age = age;
    }

    public Student(String name, String index) {
        this.name = name;
        this.index = index;
        this.active=true;
        this.age=18;
    }


    //gettery i settery
    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name=newName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    //nadpisywanie metod klasy Object
    @Override
    public String toString(){
        return this.name+" "+this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return (this.active == student.active && this.age == student.age && this.name.equals(student.name) && this.index.equals(student.index));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, active, age);
    }
}
