import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(5);
        list.add(5);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i==5){
                iterator.remove();
            }

        }
        System.out.println(list);
    }
}
