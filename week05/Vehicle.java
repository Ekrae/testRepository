package week05;

public class Vehicle {
    public String color;
    public int speed;
    public int mileage;
    public char gearStatus;
    public TV tv = new TV(false,3);



    public Vehicle(String color) {
        this(color,0,0,'P');
        //this.color = color;
    }
    public Vehicle(String color, int mileage) {
        this(color,0,mileage,'P');
//        this.color = color;
//        this.mileage = mileage;
    }
    public Vehicle(String color, int speed, int mileage, char gearStatus) {
        this.color = color;
        this.speed = speed;
        this.mileage = mileage;
        this.gearStatus = gearStatus;
    }

    public Vehicle(Vehicle car) {
        this(car.color,car.speed,car.mileage, car.gearStatus);
        this.tv = new TV(car.tv);       //얕은 복사


    }


    public void accelerate(int speed){
        if((this.gearStatus!='P')&&(this.gearStatus!='N')){
            this.speed +=speed;
            this.mileage += speed;
        }
    }
    public void breaker(int speed){
        if((this.gearStatus!='P')&&(this.gearStatus!='N')){
            this.speed -=speed;
            this.mileage += speed;
        }else
            System.out.println("현재 기어 상태는 "+this.gearStatus+"입니다.");
    }
    public void showStatus(){
        System.out.println("차량색상 : "+this.color);
        System.out.println("차량속도 : "+this.speed);
        System.out.println("주행거리 : "+this.mileage);
        System.out.println("기어상태 : "+this.gearStatus);
        tv.showTV();
    }
    public void changeGear(char gearStatus){
        this.gearStatus = gearStatus;
        this.speed = switch (this.gearStatus){
            case 'P','N' -> 0;
            case '1'->20;
            case '2'->30;
            default -> this.speed;
        };
    }
}
