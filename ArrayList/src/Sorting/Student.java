package Sorting;

public class Student implements Comparable<Student>{
    String name;
    double cgpa;
    int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cgpa=" + cgpa +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(o.cgpa> this.cgpa){
            return -1;
        }
        return 0;
    }

}
