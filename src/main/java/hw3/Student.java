package hw3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Arrays;

@JsonAutoDetect
public class Student implements Serializable {
    private String name;
    private int age;

    private transient double GPA;

    public Student() {
    }

    public Student(String name, int age, double[] array) {
        this.name = name;
        this.age = age;
        this.GPA = Arrays.stream(array).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @JsonIgnore
    public double getGPA() {
        return GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double[] array) {
        this.GPA = Arrays.stream(array).average().getAsDouble();
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Возраст: %d, средний балл: %.2f", this.name, this.age, this.GPA);
    }
}
