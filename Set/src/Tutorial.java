import java.util.HashSet;
import java.util.Set;

public class Tutorial {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(40);
        set.add(30);
        set.add(20);
        set.add(50);

        System.out.println(set);
        boolean a = set.contains(100);
        System.out.println("Set contains 100? "+a);
        boolean b = set.contains(10);
        System.out.println("Set contains 10? "+b);

        set.remove(10);
        System.out.println("Set after removal 10:");
        System.out.println(set);

        boolean empt = set.isEmpty();
        System.out.println("Is set empty? "+ empt);

        //clearing the set
        set.clear();
        boolean empt1 = set.isEmpty();
        System.out.println("Is set empty? "+ empt1);

    }
}