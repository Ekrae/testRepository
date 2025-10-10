package week06.TicketPractice;

public class AdvanceTicket extends Ticket{
    private int advanceDays;

    public AdvanceTicket(int number, double price, int advanceDays) {
        super(number, price);
        this.advanceDays = advanceDays;
    }

    public int getAdvanceDays() {
        return advanceDays;
    }

    public void setAdvanceDays(int advanceDays) {
        this.advanceDays = advanceDays;
    }

    @Override
    public double getPrice() {
        if (this.advanceDays>=30)
            return super.getPrice() * 0.7;
        else if (this.advanceDays>=20)
            return super.getPrice() * 0.8;
        else if (this.advanceDays>=10)
            return super.getPrice() * 0.9;
        else
            return super.getPrice();
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\n예약일 : " + this.getAdvanceDays() + "일 전";
        str += "\n결제금액 : " + this.getPrice() + "\n";
        return str;
    }
}
