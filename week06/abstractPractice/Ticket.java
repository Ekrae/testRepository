package week06.abstractPractice;

public abstract class Ticket {
    protected int number;
    protected double price;

//    public Ticket() {
//        this(0,0);
//    }

    public Ticket(int number) {
        this(number,0);
    }

    public Ticket(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber(){
        return number;
    }

    public abstract double getPrice();



    public void setNumber(int number) {
        this.number = number;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "티켓번호 : " + this.getNumber() +
                "\n가격 : " + this.price; //this는 해당 객체를 지칭함. 이에 따라 overriding 되버릴 수도!
    }
}
