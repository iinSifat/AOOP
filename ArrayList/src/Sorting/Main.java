package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Sifat",3.5,1));
        list.add(new Student("Mahin",4,2));
        list.add(new Student("Sifat",2.97,3));

        System.out.println("List :");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("Sorted List:"+list);

        Collections.sort(list, new idSorting());
        System.out.println(list);

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            Student p = iterator.next();
            if(p.name.equals("Sifat")){
                iterator.remove();
            }
        }

        System.out.println("List after remove :");
        System.out.println(list);

        


    }
}
