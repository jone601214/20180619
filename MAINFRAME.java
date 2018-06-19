import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class MAINFRAME extends JFrame{
    private Container cp;
    private JTextArea jta1=new JTextArea();
    private JTextArea jta2=new JTextArea();
    private JScrollPane jspl=new JScrollPane(jta1);
    private JScrollPane jsp2=new JScrollPane(jta2);
    private JButton jbtnENCRYPT=new JButton("ENCRYPT");
    private JButton jbtnEXIT=new JButton("EXIT");
    private JPasswordField jpf=new JPasswordField();
    private JLabel jlb = new JLabel("PASSWORD");
    public MAINFRAME() {
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(100, 50);
        this.setSize(1800, 1000);
        jspl.setPreferredSize(new Dimension(230,400));
        jsp2.setPreferredSize(new Dimension(230,400));
        cp = this.getContentPane();
        jlb.setBounds(875,10,300,200);
        jlb.setFont(new Font(null,Font.BOLD,30));
        jbtnENCRYPT.setBounds(900,400,150,100);
        jbtnENCRYPT.setFont(new Font(null,Font.BOLD,30));
        jbtnEXIT.setBounds(900,600,150,100);
        jbtnEXIT.setFont(new Font(null,Font.BOLD,30));
        jpf.setBounds(900,200,150,100);
        jpf.setFont(new Font(null,Font.BOLD,30));
        jta1.setBounds(10,10,800,1000);
        jta2.setBounds(1100,10,700,1000);
        this.add(jbtnENCRYPT);
        this.add(jbtnEXIT);
        this.add(jlb);
        this.add(jpf);
        this.add(jta1);
        this.add(jta2);
        jbtnENCRYPT.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char plainDATA[]=jta1.getText().toCharArray();
                int n=plainDATA.length;
                char cipherDATA[]=new char[n];
char KEYDATA[]=(new String(jpf.getPassword())).toCharArray();
int keyLen=KEYDATA.length;
for (int i=0;i<n;i++){
    cipherDATA[i]=(char)((int)plainDATA[i]^(int)KEYDATA[i&keyLen]);
}
jta2.setText(new String(cipherDATA));
            }
        });
        jbtnEXIT.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}