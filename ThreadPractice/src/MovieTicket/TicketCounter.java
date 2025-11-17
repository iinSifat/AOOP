package MovieTicket;

import BankAccount.ThreadA;

public class TicketCounter {
    int ticket;

    public TicketCounter(int ticket) {
        this.ticket = ticket;
    }

    public synchronized void bookTickets(int book_ticket){
        if(book_ticket<=ticket){
            System.out.println(Thread.currentThread().getName()+" trying to buy "+ book_ticket +" tickets.");
            System.out.println(Thread.currentThread().getName()+" successfully bought  "+ book_ticket +" tickets.");
            ticket-=book_ticket;
            System.out.println("Remaining tickets :"+ ticket);
        }
        else {
            System.out.println(Thread.currentThread().getName()+" trying to buy "+ book_ticket +" tickets.");
            System.out.println("Alas! Insufficient tickets");
        }
    }

    public int getTicket(){
        return ticket;
    }
}
