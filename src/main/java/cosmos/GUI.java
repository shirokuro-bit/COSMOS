package cosmos;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI implements ActionListener {


    JFrame frame;	// フレーム
    JLabel label1;	// ラベル
    JLabel label2;	// ラベル
    JLabel label3;	// ラベル
    JLabel label4;	// ラベル
    JLabel label5;	// ラベル
    JLabel label6;	// ラベル
    JTable table1;  // テーブル
    String a = "a";

    JButton button1;
    JButton button2;

    String t1 = "1";
    String t2 = "2";
    String t3 = "3";
    String t4 = "4";
    String t5 = "5";
    String t6 = "6";
    String zaiseki = "はいません";
    String iru = "はいます";

    public GUI(){

        // フレームの作成
        frame = new JFrame( "在籍システム" );
        frame.setBounds( 50, 50, 900,900 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //テーブルの作成
        //String[] [] tabledata = new String[200][2];



        //String[] header = {"氏名","在室"};
        //DefaultTableModel model = new DefaultTableModel(header, 0);
        //table1 = new JTable(model);
        //table1.setEnabled(false);






        // ラベルの作成
        label1 = new JLabel(t1+zaiseki);
        label1.setFont(new Font("serif", Font.PLAIN, 30));

        label2 = new JLabel(t2+zaiseki);
        label2.setFont(new Font("serif", Font.PLAIN, 30));

        label3 = new JLabel(t3+zaiseki);
        label3.setFont(new Font("serif", Font.PLAIN, 30));

        label4 = new JLabel(t4+zaiseki);
        label4.setFont(new Font("serif", Font.PLAIN, 30));

        label5 = new JLabel(t5+zaiseki);
        label5.setFont(new Font("serif", Font.PLAIN, 30))
        ;
        label6 = new JLabel(t6+zaiseki);
        label6.setFont(new Font("serif", Font.PLAIN, 30));

        button1 = new JButton(iru);
        button1.addActionListener( this );  // ボタンをアクションリスナーに登録
        button2 = new JButton(zaiseki);
        button2.addActionListener( this );  // ボタンをアクションリスナーに登録
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,2));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));

        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);

        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);

        panel2.add(button1);
        panel2.add(button2);

        Container contentPane = frame.getContentPane();
        frame.setLayout( new GridLayout(2,1) );

        contentPane.add(panel1);
        contentPane.add(panel2);

        // フレームの可視化設定
        frame.setVisible( true );

    }


    public void actionPerformed( ActionEvent e ) {
        if(e.getSource() == button1) {
            label1.setText(t1+iru);
            label2.setText(t2+iru);
            label3.setText(t3+iru);
            label4.setText(t4+iru);
            label5.setText(t5+iru);
            label6.setText(t6+iru);

        }else if(e.getSource() == button2){
            label1.setText(t1+zaiseki);
            label2.setText(t2+zaiseki);
            label3.setText(t3+zaiseki);
            label4.setText(t4+zaiseki);
            label5.setText(t5+zaiseki);
            label6.setText(t6+zaiseki);
        }
    }




}
