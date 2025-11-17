import java.util.HashSet;
import java.util.Set;

public class Union {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        System.out.println("Set-1: ");
        System.out.println(set1);

        Set<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(40);
        set2.add(50);
        System.out.println("Set-2: ");
        System.out.println(set2);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union set :");
        System.out.println(union);


    }
}
