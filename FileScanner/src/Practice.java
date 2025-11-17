import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write("My program.");
            fw.close();

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
