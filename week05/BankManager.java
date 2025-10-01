package week05;

import java.util.Arrays;
import java.util.Scanner;

public class BankManager {
    public String branchName;
    public final int SIZE;
    public BankAccount2[] bankAccount =null;
    public int count = 0;

    public static Scanner scanner = new Scanner(System.in);


    public BankManager(int SIZE, String branchName) {
        this.SIZE = SIZE;
        this.branchName = branchName;
        if (this.SIZE>0)
            this.bankAccount = new BankAccount2[this.SIZE];
    }

    public void createAccount(){
        System.out.println("----------계좌개설----------");
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("초기 금액 : ");
        int amount = scanner.nextInt();

        if (this.count < this.SIZE){
            bankAccount[this.count++] = new BankAccount2(name,amount);
        }else
            System.out.println("더이상 계좌 개설 불가능");

    }
    public void deposit(){
        System.out.println("----------입금----------");
        System.out.println("계좌번호 : ");
        int accountNumber = scanner.nextInt();
        BankAccount2 foundAccount = this.findAccount(accountNumber);
        if (foundAccount!=null){
            System.out.println("입금할 금액 : ");
            int amount = scanner.nextInt();
            foundAccount.deposit(amount);
        }else
            System.out.println("계좌번호 확인 요망");


    }
    public void withdraw(){
        System.out.println("----------출금----------");
        System.out.print("계좌번호 : ");
        int accountNumber = scanner.nextInt();
        BankAccount2 foundAccount = this.findAccount(accountNumber);

        if (foundAccount!=null){
            System.out.print("출금할 금액 : ");
            int amount = scanner.nextInt();
            foundAccount.withdraw(amount);
        }else
            System.out.println("계좌번호 확인 요망");

    }
    public void transfer(){
        System.out.println("----------계좌이체----------");
        System.out.print("송금할 계좌번호 입력 : ");
        int acc1Num = scanner.nextInt();
        BankAccount2 acc1 = findAccount(acc1Num);

        System.out.print("송금받을 계좌번호 입력 : ");
        int acc2Num = scanner.nextInt();
        BankAccount2 acc2 = findAccount(acc2Num);

        System.out.print("출금할 금액 : ");
        double amount = scanner.nextDouble();

        if (acc1 !=null && acc2!=null){
            acc1.transfer(acc2,amount);
        }else{
            System.out.println("계좌번호 확인");
        }

    }
    public BankAccount2 findAccount(int target){
        System.out.println("----------계좌검색----------");
        for (BankAccount2 acc: bankAccount){
            if ((acc!=null)&&(acc.accountNumber == target)){
                return acc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str ="지점 명 : " + branchName + "\n";
        str += "개설된 계좌 수 : " + count +"\n";
        for (int i=0; i<this.count;i++){
            str += ("=".repeat(20));
            str += bankAccount[i].toString();
        }
        return str;
//        return "BankManager{" +
//                "branchName='" + branchName + '\'' +
//                ", SIZE=" + SIZE +
//                ", bankAccount=" + Arrays.toString(bankAccount) +
//                ", count=" + count +
//                '}';
    }
}
