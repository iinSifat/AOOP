import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Blank List "+ list);
        list.add("Tom");
        list.add("Jerry");

        System.out.println("Added List"+ list);
        //specific index adding
        list.add(0,"Jerry");
        System.out.println("Index adding"+list);

        list.set(0,"Sifat"); // replace the prev element of this index
        System.out.println("Setting list"+ list);

//        String removeitem = list.remove(0);
//        System.out.println("Remove element : "+ removeitem);
//        System.out.println(list);

        //reverse

        Collections.reverse(list);
        System.out.println("Reverse list"+ list);

        list.add("Sifat");

        //Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            String it = iterator.next();
            if(it.equals("Sifat")){
                iterator.remove();
            }
        }
        System.out.println("Remove repeated items:"+list);






    }
}