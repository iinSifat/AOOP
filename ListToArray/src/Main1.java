import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "Sifat"));
        list.add(new Student(2, "Mahin"));
        list.add(new Student(3, "Lamim"));

        Student [] arr = new Student[list.size()];
        list.toArray(arr);
        for(Student s : arr){
            System.out.println(s.id+" "+s.name);
        }
    }
}
