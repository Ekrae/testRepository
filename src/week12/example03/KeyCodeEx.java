package week12.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



//키보드 이벤트
public class KeyCodeEx extends JFrame {
    JPanel contentPane = new JPanel();
    JLabel la = new JLabel();

    KeyCodeEx() {
        setTitle("Key Code 예제 : F1키:초록색, % 키 노란색");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);

        contentPane.addKeyListener(new MyKeyListener());
        contentPane.add(la);
        setSize(1300,1150);
        setVisible(true);
        contentPane.requestFocusInWindow();
        // 기본적으로 컨테이너들은 포커스 받을 수 없음. 그래서 저 메소드로 강제로 포커스 주는거.
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            la.setText(KeyEvent.getKeyText(e.getKeyCode()));
            //System.out.println(e.getKeyCode());
            if(e.getKeyChar() == '%')
                contentPane.setBackground(Color.YELLOW);
            else if(e.getKeyCode() == KeyEvent.VK_F1)
                contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String [] args) {
        new KeyCodeEx();

    }
}

