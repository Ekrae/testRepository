package week12.example01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndepClassListener3 extends JFrame {
    IndepClassListener3() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                if (b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");

                setTitle(b.getText());
            }
        });
        c.add(btn);
        setSize(250, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new IndepClassListener3();
    }
}
