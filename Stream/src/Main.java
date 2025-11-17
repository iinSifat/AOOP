import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
    File file = new File("file.txt");
    if(!file.exists()){
    try {
        file.createNewFile();
        System.out.println("Create new file");

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    try{
        FileOutputStream fos = new FileOutputStream(file);
        String output = "Hello Class \nThis is file output stream";
        fos.write(output.getBytes());
        fos.flush();
        fos.close();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    try {
        FileInputStream fis = new FileInputStream(file);
        int i = fis.read();
        while(i!=-1){
            char c = (char)i;
            System.out.print(c);
            i=fis.read();
        }
        fis.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }
}