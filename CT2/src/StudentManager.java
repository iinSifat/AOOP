import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1=new Student("Tom",2, 3.44);
        Student s2=new Student("Sam",3, 2.44);

        list.add(s1);
        list.add(s2);
        //list.add(new Student("Tom",1, 1.44));

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list,new CgpaCompare());
        System.out.println("Cgpa Sorting:");
        System.out.println(list);

//        Student student,student2;
        try{
            FileOutputStream fos = new FileOutputStream("Student.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
//            os.writeObject(s1); //if we use serializable we have to read all created object
//            os.writeObject(s2);
            os.writeObject(list);
            FileInputStream fis = new FileInputStream("Student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println("Printed by list:");
            list = (ArrayList<Student>) ois.readObject();
            for(Student s: list){
                System.out.println(s);
            }
//             Student std = (Student) ois.readObject();// must be initialized in try-catch block
//             Student student2 = (Student) ois.readObject();//here we have also read all the object we write prev.

            fis.close();
            ois.close();

            System.out.println("Printed without list:");
//            System.out.println(std.name);
//            System.out.println(student2.name);

//we can not both list console printing and single object printing at the same time
        }
        catch (Exception e){}


    }
}