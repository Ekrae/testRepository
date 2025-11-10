package week10.example;

import java.util.Objects;

public class Word {
    String eng;
    String kor;

    public Word(String eng, String kor) {
        super();
        this.eng = eng;
        this.kor = kor;
    }

    @Override
    public String toString() {
        return eng + " : " + kor;
    }

    // 마법사가 이렇게 잘 되어있는데 Ai는 써선 안된다고? 흠.......
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Word word)) return false;
        return Objects.equals(eng, word.eng) && Objects.equals(kor, word.kor);
    }
    //오버라이딩 안 하면 주소로 해시코드 만듦
    @Override
    public int hashCode() {
        int result = Objects.hashCode(eng);
        result = 31 * result + Objects.hashCode(kor);
        return result;
    }
}
