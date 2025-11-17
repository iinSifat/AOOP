import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    String name;
    int id;
    double cgpa;

    public Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cgpa=" + cgpa +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.id>o.id) return 1;
        else if(this.id<o.id) return -1;
        else return 0;
    }
}
