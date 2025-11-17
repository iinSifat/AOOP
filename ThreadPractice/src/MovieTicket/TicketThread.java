package MovieTicket;

public class TicketThread extends Thread{
    private TicketCounter counter;
    int booked_ticket;

    public TicketThread(TicketCounter counter, int booked_ticket) {
        this.counter = counter;
        this.booked_ticket = booked_ticket;
    }

    @Override
    public void run() {
        counter.bookTickets(booked_ticket);
    }
}
