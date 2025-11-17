import java.util.ArrayList;
import java.util.Iterator;

public class Main1 {

        public static void main(String[] args) {

            //ArrayList Declaration
            ArrayList<String> list = new ArrayList<>();

            System.out.println("List = " + list); //Print whole list

            // add(item) function adds item to the end of the list
            list.add("Tom");
            list.add("Jerry");

            System.out.println("List = " + list);

            // add(index,item) function inserts the item at the given index
            // moves all the items from that index to the right of the list
            // index must be within the existing list range
            list.add(0,"Scooby");

            System.out.println("List = " + list);

            // set(index,item) function replaces the item at the given index, similar to arr[index] = item
            list.set(1,"Jimmy");

            System.out.println("List = " + list);

            // For loop to iterate the list, size() function gives the current number of elements in the list
            // get(index) function returns a copy of the item at index i
            System.out.print("For Loop: ");
            for(int i=0; i< list.size(); i++)
            {
                System.out.print(list.get(i) + " ");
            }

            System.out.println();
            System.out.println("List = " + list);

            // remove(index) function removes the element at the given index and returns the element
            // can store the removed element in a variable
            String removedElement = list.remove(2);
            System.out.println("Removed Element = " + removedElement);
            System.out.println("List = " + list);

            list.add("Scooby");
            System.out.println("List = " + list);

            // remove(item) function removes the first occurence of the given item, does not return the item
            list.remove("Scooby");
            System.out.println("List = " + list);

            // Iterator class can also be used to iterate(loop) through a list
            // iterator() function of a list returns a iterator to the list
            // hasNext() function of an iterator checks whether there is a item left in the list or not
            // next() function of an iterator gives the next element
            Iterator<String> itr = list.iterator();
            System.out.print("Iterator: ");
            while(itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }

            System.out.println();
            System.out.println("List = " + list);


        }

    }

