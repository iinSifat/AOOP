import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();

        names.push("AOOP");
        names.push("Collections");
        names.push("Project");
        names.push("JavaFX");

        System.out.println("Name Stacks:");
        System.out.println(names);
        System.out.println("Top Elements:"+names.peek());
        //peek
        //just shows the top element
        //Does not remove any element
        String pop_elm = names.pop();
        System.out.println("Popping the last element: "+pop_elm);
        System.out.println("New Stack :");
        System.out.println(names);



    }
}