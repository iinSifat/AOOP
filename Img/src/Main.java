import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fr = new FileInputStream("data.txt");
            FileOutputStream fw = new FileOutputStream("out.txt");
            int i;
            while( (i = fr.read()) != -1)
            {
                char c = (char)i;
                System.out.print(c);
                fw.write(i);

            }
            fw.flush();
            fw.close();
            fr.close();
        }
        catch (Exception e){
        }



    }
}