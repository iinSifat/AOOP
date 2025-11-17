import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Sifat",1);
        Student student2 = new Student("Tamim",2);
    try{
        FileOutputStream fis = new FileOutputStream("file.txt");
        ObjectOutputStream obj = new ObjectOutputStream(fis);
        obj.writeObject(student1);
        obj.writeObject(student2);
        fis.close();
        obj.close();
    }
    catch (Exception e){

    }

    try {
        FileInputStream fr = new FileInputStream("file.txt");
        ObjectInputStream obi = new ObjectInputStream(fr);
        Student stdnew = (Student) obi.readObject();
        Student std1new = (Student) obi.readObject();
        fr.close();
        obi.close();

        System.out.println(stdnew.name+" "+ stdnew.id);

    } catch (Exception e) {
        throw new RuntimeException(e);
    }


    }
}