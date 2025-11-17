package week12;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {

    }

    public static void main(String[] args) {
        new MainFrame("20000 홍길동");
    }
}
