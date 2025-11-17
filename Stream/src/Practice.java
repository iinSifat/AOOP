import java.io.*;

public class Practice {
    public static void main(String[] args) {
        File myfile = new File("file2.txt");
        try{
            myfile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileOutputStream fis = new FileOutputStream(myfile);
            String s = "Helle gello mello.";

            fis.write(s.getBytes());
            fis.flush();
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            FileInputStream fis = new FileInputStream(myfile);
            int i = fis.read();
            while(i!=-1){
                char c = (char) i;
                System.out.print(c);
                i = fis.read();

            }
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
