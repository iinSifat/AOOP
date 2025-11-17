import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fr = new FileInputStream("Sample1.doc");
            FileOutputStream fw = new FileOutputStream("output1.docx");

            int i ;
            while((i=fr.read())!= -1){
                fw.write(i);
            }
            fw.flush();
            fr.close();
            fw.close();
        }
        catch (Exception e){

        }
    }
}