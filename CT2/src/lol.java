import java.io.*;

public class lol {
    public static void main(String[] args) {
        Student s1 = new Student("Sifat",1,3.55);
        try{
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(s1);

            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            fos.close();
            os.close();
            fis.close();
            ois.close();
            System.out.println(student.name+" "+student.cgpa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
