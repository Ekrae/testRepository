package week12.LabWork.Week12_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 메인프레임 클래스
 */
public class MainFrame extends JFrame {
    /**
     *frame이란 이름으로 contentPane 가져오기
     */
    Container frame = this.getContentPane();
    /**
     * 이미지들의 주소 필드. 아래,왼쪽,오른쪽,위 순서. 불변.
     */
    final String[] imgPath = {"img/Down.png", "img/Left.png", "img/Right.png", "img/Up.png"};
    /**
     * 보여줄 실제 이미지들
     */
    ImageIcon[] icons;
    /**
     * 라벨.코드상 통제할 객체
     */
    JLabel player;
    /**
     * 이미지 크기
     */
    int imgWidth, imgHeight;
    /**
     * 그림의 좌표(point로 처리). 기본값 100,100
     */
    Point pos = new Point(100, 100);

    public MainFrame(String title) {
        super(title);
        //사이즈, 위치 등 기본세팅
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        initLayout();
        //보이게하기
        this.setVisible(true);
    }

    private void initLayout() {
        this.frame.setLayout(null);
        //케이스 생성
        this.icons = new ImageIcon[imgPath.length];
        for (int i = 0; i < icons.length; i++) {
            this.icons[i] = new ImageIcon(imgPath[i]);
        }//이미지들 케이스에 저장

        //크기 값 대입(크기는 전부 동일)
        this.imgWidth = icons[0].getIconWidth();
        this.imgHeight = icons[0].getIconHeight();
        //객체 설정들 해서 넣기(이미지,크기,처음위치)
        this.player = new JLabel(icons[0]);
        this.player.setSize(imgWidth, imgHeight);
        this.player.setLocation(pos);
        //프레임에 플레이어 추가
        this.frame.add(player);
        //배경색 설정
        this.frame.setBackground(Color.WHITE);
        //키보드 리스너 설정
        initKeyListener();
    }

    private void initKeyListener() {
        //커스텀 키 이벤트 추가하기
        this.addKeyListener(new KeyAdapter() {
            //키 눌렸을때
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);



                //입력받은 키값에 따라 위치 변경. 좌표계 basis:(1 0) (0 -1)
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN -> {//아래
                        //조건은 프레임 세로크기-이미지 세로크기-이동거리10>좌표 일때만
                        if (pos.y<=frame.getHeight()-player.getHeight()-10){
                            //하 이동, 아래 이미지 대입
                            pos.y += 10;
                            player.setIcon(icons[0]);
                        }
                    }
                    case KeyEvent.VK_LEFT -> {//왼쪽
                        //왼쪽 기준은 늘 0. 여유거리만 확인
                        if (pos.x>=10){
                            //좌 이동, 왼 이미지 대입
                            pos.x -= 10;
                            player.setIcon(icons[1]);
                        }

                    }
                    case KeyEvent.VK_RIGHT -> {//오른쪽
                        //조건은 프레임 가로크기-이미지 가로크기-이동거리10>좌표 일때만
                        if (pos.x<=frame.getWidth()-player.getWidth()-10){
                            //우 이동, 오른 이미지 대입
                            pos.x += 10;
                            player.setIcon(icons[2]);
                        }
                    }
                    case KeyEvent.VK_UP -> {//위
                        //위 기준은 늘 0. 여유거리만 확인
                        if (pos.y>=10){
                            //상 이동, 위 이미지 대입
                            pos.y -= 10;
                            player.setIcon(icons[3]);
                        }
                    }
                }
                //플레이어 위치 설정
                player.setLocation(pos);
            }
        });
    }

    public static void main(String[] args) {
        //메인프레임 생성
        new MainFrame("202511492 이창민");
    }
}
