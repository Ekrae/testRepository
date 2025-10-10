package week05;

public class TestMain {
    public static void main(String[] args) {
        //example01();
        example02();
    }

    private static void example02() {
        BankManager bank = new BankManager(10,"건국은행");
        bank.createAccount();
        System.out.println("=".repeat(20));
        bank.createAccount();
        System.out.println("=".repeat(20));
        bank.createAccount();
        System.out.println("=".repeat(20));


        bank.transfer();

        System.out.println(bank);

        bank.transfer();

        System.out.println(bank);
    }

    private static void example01() {
        BankAccount2 acc1 = new BankAccount2("홍길동",100);
        BankAccount2 acc2 = new BankAccount2("김길동",1000);

        acc1.showAccount();
        acc2.showAccount();
    }
}
