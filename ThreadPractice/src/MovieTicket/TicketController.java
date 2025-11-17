package MovieTicket;

public class TicketController {
    public static void main(String[] args) throws Exception{
        TicketCounter counter = new TicketCounter(10);
        TicketThread t1 , t2, t3, t4, t5;
        t1 = new TicketThread(counter,10);
        t2 = new TicketThread(counter,5);
        t3 = new TicketThread(counter,4);
        t4 = new TicketThread(counter,1);
        t5 = new TicketThread(counter,4);
        Thread t7 = new Thread(()->{
            counter.bookTickets(4);
        });

        t1.setName("Buyer-1");
        t2.setName("Buyer-2");
        t3.setName("Buyer-3");
        t4.setName("Buyer-4");
        t5.setName("Buyer-5");
        t7.setName("Buyer-7");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t7.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t7.join();

        System.out.println("Remaining tickets "+ counter.getTicket());


    }
}
