package week05;

public class BankAccount {
    public int accountNumber;
    public String customerName;
    public double accountBalance;


    public BankAccount(int accountNumber, String customerName) {
        this(accountNumber,customerName,0.0 );
//        this.accountNumber = accountNumber;
//        this.customerName = customerName;
    }

    public BankAccount(int accountNumber, String customerName, double accountBalance) {
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

    public void transfer(BankAccount account, double amount) {
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
}