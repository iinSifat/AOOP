package Summer23;

public class CalcController {
    public static void main(String[] args) {
        CalcThread t1= new CalcThread(1,5,14,3);
        CalcThread t2= new CalcThread(1,17,26,3);
        CalcThread t3= new CalcThread(1,29,38,3);

        t1.start();
        t2.start();
        t3.start();

        try{
          t1.join();
          t2.join();
          t3.join();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread-1 :"+ t1.getSum());

        double sum = t1.getSum() * t2.getSum() * t3.getSum();
        System.out.println("Final output: "+sum);


    }
}
