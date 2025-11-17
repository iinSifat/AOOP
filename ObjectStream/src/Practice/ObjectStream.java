package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectStream {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("Dog",4,10.5));
        list.add(new Animal("Cow",4,1.5));
        list.add(new Animal("Elephant",4,20.5));

        try{
            FileOutputStream fw = new FileOutputStream("file.txt");
            ObjectOutputStream ot = new ObjectOutputStream(fw);
            ot.writeObject(list);

            fw.close();
            ot.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        for(Animal a : list){
//            System.out.println(a);
//        }

        //reading from the arraylist


        try{ 
            FileInputStream fis =  new FileInputStream("file.txt");
            ObjectInputStream Oin = new ObjectInputStream(fis);
            list= (ArrayList<Animal>) Oin.readObject();
            fis.close();
            Oin.close();
            System.out.println(list);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
