import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(23);
        numbers.add(32);
        numbers.add(100);
        numbers.add(45);
        System.out.println(numbers);

        Integer [] arr = new Integer[numbers.size()];
        numbers.toArray(arr);
        for(int s : arr){
            System.out.println(s);
        }

        String[] names = new String[]{"Sifat", "Nashir", "Mahin"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(names));
        for(String s: names){
            System.out.println(s);
        }








    }
}