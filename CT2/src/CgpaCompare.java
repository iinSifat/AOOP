import java.util.Comparator;

public class CgpaCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.cgpa>o2.cgpa) return 1;
        else if(o1.cgpa<o2.cgpa) return -1;
        else return 0;
    }
}
