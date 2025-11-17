import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fr = new FileInputStream("img.png");
            FileOutputStream fw = new FileOutputStream("image.png");
            int i;
            while( (i=fr.read())!=-1){
                fw.write(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}