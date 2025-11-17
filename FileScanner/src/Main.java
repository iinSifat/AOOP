import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File myfile = new File("file.txt");
        try{
            myfile.createNewFile();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            FileWriter fw = new FileWriter(myfile,true);
            fw.write("Hello World!\n");
            fw.close();


        }
        catch (Exception E){

        }

        try {
            Scanner sc = new Scanner(myfile);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);


            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
