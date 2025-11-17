package week12.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerEx extends JFrame {
    JPanel contentPane = new JPanel();
    JLabel [] keyMessage;

    KeyListenerEx() {
        setTitle("KeyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        contentPane.addKeyListener(new MyKeyListener());

        keyMessage = new JLabel [3];
        keyMessage[0] = new JLabel("  getKeyCode()  "); //키들에 할당된 값 반환(키보드상 위치만이 중요)
        keyMessage[1] = new JLabel("  getKeyChar()  "); //유니코드인 경우 문자값 리턴
        keyMessage[2] = new JLabel("  getKeyText()  ");

        for(int i=0; i<keyMessage.length; i++) {
            contentPane.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.CYAN);
        }
        setSize(300,150);
        setVisible(true);
        contentPane.requestFocusInWindow();
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) { //누르면 항시 발생
            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();
            keyMessage[0].setText(Integer.toString(keyCode));
            keyMessage[1].setText(Character.toString(keyChar));
            keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
        }
    }

    public static void main(String [] args) {
        new KeyListenerEx();

    }
}

