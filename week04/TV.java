package week04;

public class TV {
    public boolean power;
    public int channel;

    public final int MIN_CHANNEL = 0;
    public int[] hopeChannels = {5,7,9,11,15,22};
    public final int MAX_CHANNEL = hopeChannels.length-1;
    public void powerOnOff(){
        power = !power;  //바뀌는 식!
        showTV();
    }
    public void channelUP(){
        if (power)
            channel++;
        channel = channelTrans(channel);
        showTV();
    }
    public void channelDown(){
        if (power)
            channel--;
        channel = channelTrans(channel);
        showTV();
    }
    public void showTV(){
        if (power){
            System.out.println(hopeChannels[channel]+"번 시청중입니다.");
        }else{
            System.out.println("전원 꺼져있습니다.");
        }
    }
    public int channelTrans(int channel){
        if (channel> MAX_CHANNEL){
            channel = MIN_CHANNEL;
        } else if (channel<MIN_CHANNEL) {
            channel = MAX_CHANNEL;
        }
        return channel;
    }
}
