package Fall23;

import java.lang.reflect.Array;

public class SumThread extends Thread{
    int [] arr;
    int sum;

    public SumThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for(int a : arr){
            sum+=a;
        }

    }

    public int getSum() {
        return sum;
    }
}
