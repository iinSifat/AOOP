package Summer23;

public class CalcThread extends Thread{
    int st_value;
    int end_value;
    int id;
    int icr;
    double sum;


    public CalcThread(int id,int st_value, int end_value,int icr ) {
        sum=1.0;

        this.st_value = st_value;
        this.end_value = end_value;
        this.id = id;
        this.icr = icr;
    }

    @Override
    public void run() {
        for(int i =st_value; i<=end_value; i+=icr){
            sum*=1.0/i;
        }

    }

    public double getSum() {
        return sum;
    }
}
