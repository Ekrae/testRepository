package week12.LabWork.Week12_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Comparator;
import java.util.List;

public class MainFrame extends JFrame {
    Container frame = getContentPane();

    JPanel northPanel;
    JTextField text;
    JButton searchBtn;
    JRadioButton asc,desc;

    JTable table;
    DefaultTableModel model;
    String[] header = {"영단어","뜻"};

    VocManager manager;
    String filename;

    boolean flag = true; //어센딩 디폴트

    public MainFrame(String filename) {

        this.filename = filename;
        this.setTitle("202511492 이창민");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //화면 중앙에
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
        initNorthPanel();
        initCenterPanel();

        this.manager = new VocManager("이창민");
        String str = this.manager.makeVoc(filename);
        JOptionPane.showMessageDialog(this,str);
        initTableData();
    }

    private void initTableData() {
        removeTableData(); //초기화

        if (flag){
            manager.voc.sort(new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    return o1.eng.compareTo(o2.eng); //compareTo라는 고유 메소드
                }
            });
        }else{
            manager.voc.sort(new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    return o1.eng.compareTo(o2.eng)*-1; //역순으로 비교함
                }
            });
        }

        for (Word W : manager.voc){
            model.addRow(new String[]{W.eng,W.kor});
        }
    }

    private void initCenterPanel() {
        this.model = new DefaultTableModel(header,0);
        this.table = new JTable(model); //model로 실제 테이블 만드는 느낌
        frame.add(new JScrollPane(table),"Center");


    }

    private void initNorthPanel() {
        this.northPanel = new JPanel();
        this.text = new JTextField(10);
        this.text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //검색1
                Word word = manager.searchVoc(text.getText());
                if (word==null){
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "단어장에 등록된 단어가 없습니다.");
                    return;
                }
                removeTableData();//빈 테이블에 추가

                model.addRow(new String[]{word.eng, word.kor});
                text.setText("");
            }
        });

        this.searchBtn = new JButton("검색");
        this.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //searchVoc2
                List<Word> list = manager.searchVoc2(text.getText());
                if (!list.isEmpty()){
                    removeTableData();
                    for (Word w : list){
                        model.addRow(new String[]{w.eng,w.kor});
                    }
                }else{
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "단어장에 등록된 단어가 없습니다.");
                }
                text.setText("");
            }
        });

        this.asc = new JRadioButton("Asc");
        this.asc.setSelected(true);
        this.asc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    flag = true;
                    initTableData();
                }
            }
        });
        this.desc = new JRadioButton("Desc");
        this.desc.setSelected(true);
        this.desc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    flag = false;
                    initTableData();
                }
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(asc);
        group.add(desc);

        this.northPanel.add(new JLabel("검색할 단어"));
        this.northPanel.add(text);
        this.northPanel.add(searchBtn);
        this.northPanel.add(asc);
        this.northPanel.add(desc);

        frame.add(northPanel,"North"); //전부 컨테이너들에 있어야 함

    }

    private void removeTableData() {
        if (model.getRowCount()>0){
            model = new DefaultTableModel(header,0);
            table.setModel(model); //테이블 싹 비우고 단어 하나만.
        }
    }

    public static void main(String[] args) {
        new MainFrame("res/words.txt");
    }
}
