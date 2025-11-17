package week12.example02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerEx extends JFrame {
    JLabel la = new JLabel("Hello"); // "Hello" 출력용 레이블

    MouseListenerEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        //c.addMouseListener(new MyMouseListener());
        //c.addMouseListener(new MyMouseAdapter());
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX(); // 마우스의 클릭 좌표 x
                int y = e.getY(); // 마우스의 클릭 좌표 y
                la.setLocation(x, y); // (x,y) 위치로 레이블 이동
            }
        }); //익명 객체로 이용하기


        c.setLayout(null); //레이아웃 없애는 방법
        la.setSize(50, 20); // 레이블의 크기 50x20 설정
        la.setLocation(30, 30); // 레이블의 위치 (30,30)으로 설정
        c.add(la);

        setSize(200, 200);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {
            int x = e.getX(); // 마우스의 클릭 좌표 x
            int y = e.getY(); // 마우스의 클릭 좌표 y
            la.setLocation(x, y); // (x,y) 위치로 레이블 이동
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {} //안 써도 구현해야함
    }
    //어뎁터 클래스 상속받아서 쓰면 효율적
    class MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }

    public static void main(String [] args) {
        new MouseListenerEx();
    }
}

