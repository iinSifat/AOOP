import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hash_Map {
    public static void main(String[] args) {
        HashMap<String,Double> cgpa = new HashMap<>();
        cgpa.put("0112330365", 3.5);
        cgpa.put("0112330363", 3.5);
        cgpa.put("0112330362", 3.95);

        System.out.println(cgpa);
        cgpa.put("0112330365",4.00);
        System.out.println(cgpa);

        cgpa.remove("0112330365",2.36);
        System.out.println(cgpa);

        double a = cgpa.get("0112330365");
        System.out.println(a);

        Set<String> keys = cgpa.keySet();
        for(String s : keys){
            System.out.println(s+" get cgpa "+cgpa.get(s));
        }
    }
}