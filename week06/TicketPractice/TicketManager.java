package week06.TicketPractice;

import java.util.Arrays;

public class TicketManager {
    private Ticket[] tickets;
    private String name;
    private final int NUMBER;
    private int count = 0;

    public TicketManager(String name, int NUMBER) {
        this.name = name;
        this.NUMBER = NUMBER;
        if (this.NUMBER > 0)
            tickets = new Ticket[this.NUMBER];

    }

    public void register(Ticket ticket){
        if (this.count<this.NUMBER)
            this.tickets[this.count++] = ticket;
        else
            System.out.println("티켓 판매 완료");
    }
    public double getTotal(){
        double total =0.0;
        for (Ticket ticket : tickets){
            if (ticket != null){
                total += ticket.getPrice();
            }else
                break;
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "공연명 : " + this.name;
        str += "\n좌석수 : " + this.NUMBER;
        str += "\n 총 판매티켓 수 : "+ this.count + "\n";
        for (Ticket ticket : tickets){
            if (ticket != null){
                str += ticket.toString();
                str += "\n-------------\n";
            }else
                break;
        }
        str += "총 판매 금액 : "+ this.getTotal() + "\n";
        return str;
    }
}
