package week04;

public class TV {
    public boolean power;
    public int channel;
    public int volume;

    public final int MIN_CHANNEL_VOLUME = 0;
    //public int[] hopeChannels = {5,7,9,11,15,22}; 얘는 원하는채널들
    public final int MAX_CHANNEL = 5;
    public final int MAX_VOLUME = 10;

    public void powerOnOff() {
        power = !power;  //바뀌는 식!
        showTV();
    }

    public void channelUP() {
        if (power)
            channel++;
        channel = channelTrans(channel);
        showTV();
    }

    public void channelDown() {
        if (power)
            channel--;
        channel = channelTrans(channel);
        showTV();
    }

    public void showTV() {
        if (power) {
            System.out.println(channel + "번 시청중입니다. 볼륨은 "+volume+"입니다.");
        } else {
            System.out.println("전원 꺼져있습니다.");
        }
    }

    public int channelTrans(int channel) {
        if (channel > MAX_CHANNEL) {
            channel = MIN_CHANNEL_VOLUME;
        } else if (channel < MIN_CHANNEL_VOLUME) {
            channel = MAX_CHANNEL;
        }
        return channel;
    }

    public int volumeTrans(int volume) {
        if (volume > MAX_VOLUME) {
            volume = MAX_VOLUME;
        } else if (volume < MIN_CHANNEL_VOLUME) {
            volume = MIN_CHANNEL_VOLUME;
        }
        return volume;
    }

    public void volumeUp() {
        if (power)
            volume++;
        volume = volumeTrans(volume);
        showTV();
    }

    public void volumeDown() {
        if (power)
            volume--;
        volume = volumeTrans(volume);
        showTV();

    }
}
