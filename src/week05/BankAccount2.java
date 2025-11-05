package week05;

public class BankAccount2 {


    public static int count=100;


    public int accountNumber;
    public String customerName;
    public double accountBalance;

    {
        this.accountNumber = count++;
    }
    public BankAccount2(String customerName) {
        this.customerName = customerName;
    }

    public BankAccount2(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }
    public BankAccount2(int accountNumber, String customerName) {
        this(accountNumber,customerName,0.0 );
//        this.accountNumber = accountNumber;
//        this.customerName = customerName;
    }

    public BankAccount2(int accountNumber, String customerName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount){
        this.accountBalance += amount;
    }
    public void withdraw(double amount){
        if (this.accountBalance>=amount){
            this.accountBalance -= amount;
        }else{
            System.out.println("잔액부족");
        }
    }

    public void transfer(BankAccount2 account, double amount) {
        if(this.accountBalance >= amount) {
            this.withdraw(amount);
            account.deposit((amount));
        }else{
            System.out.println("출금잔액 부족");
        }
    }
    public void showAccount(){
        System.out.println("고객이름 : "+this.customerName);
        System.out.println("계좌번호 : "+this.accountNumber);
        System.out.println("잔   액 : "+this.accountBalance);
        System.out.println("=".repeat(20));
    }

    @Override
    public String toString() {
        String str = "고객이름 : "+this.customerName+"\n";
        str += "계좌번호 : "+this.accountNumber+"\n";
        str +="잔   액 : "+this.accountBalance +"\n";
        return str;
    }
}

