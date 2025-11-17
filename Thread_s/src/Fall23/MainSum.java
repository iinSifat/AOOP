package Fall23;

public class MainSum {
    public static void main(String[] args) {
        int [] arr1 = new int[]{1,2,3,4,5};
        int [] arr2 = new int[]{1,2,3,4,-5};
        int [] arr3 = new int[]{1,-2,3,4,5};

        Thread t1 = new SumThread(arr1);
        Thread t2 = new SumThread(arr2);
        Thread t3 = new SumThread(arr3);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int a = ((SumThread) t1).getSum();
        int b = ((SumThread) t2).getSum();
        int c = ((SumThread) t3).getSum();

        System.out.println("Sum of array-1:"+a);
        System.out.println("Sum of array-2:"+b);
        System.out.println("Sum of array-3:"+c);


    }
}
