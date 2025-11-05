package week06.TicketPractice;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("202511492 이창민");
        TicketManager ticketManager = new TicketManager("방탄콘서트",100);
        ticketManager.register(new Ticket(1,1000));
        ticketManager.register(new GeneralTicket(2,2000,true));
        ticketManager.register(new GeneralTicket(3,3000,false));
        ticketManager.register(new AdvanceTicket(4,3000,35));
        ticketManager.register(new GeneralTicket(5,2000,true));
        ticketManager.register(new AdvanceTicket(6,3000,15));
        //System.out.println(ticketManager);
        ticketManager.showGeneralTicket(true);
        ticketManager.showAdvanceTicket(20);



//        GeneralTicket ticket1 = new GeneralTicket(1,1000,false);
//        GeneralTicket ticket2 = new GeneralTicket(2,2000,true);
//        System.out.println(ticket1);
//
//        System.out.println(ticket2);
//        AdvanceTicket ticket1 = new AdvanceTicket(1,
//                1000,32);
//        AdvanceTicket ticket2 = new AdvanceTicket(2,
//                1000,15);
//        System.out.println(ticket1);
//        System.out.println(ticket2);
    }
}
