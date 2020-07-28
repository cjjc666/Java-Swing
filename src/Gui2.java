import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Gui2 extends JFrame implements ActionListener {
    JLabel baname,message, nameoncard, cardty, cardnum, desbel, secbel, cardpin, cardcvv, image, headbel, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8,allimg;
    JTextField banknameld, nonceld, cnumeld, deseld, cpineld, ccvveld;
    JButton okbt, canbt;
    JMenu pswmanagement;
    JMenuBar menuBar;
    JComboBox ctybox;

    Gui2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4));
        setTitle("Add/Edit Bank Card Details");
        setSize(800, 400);
        setLocation(300, 100);
        setVisible(true);


        menuBar = new JMenuBar();
        pswmanagement = new JMenu("Bank Card");
        pswmanagement.setFont(new Font("Californian FB", Font.BOLD, 15));
        menuBar.add(pswmanagement);
        setJMenuBar(menuBar);

        image = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\31359\\Desktop\\2.jpg");
        image.setIcon(icon);
        icon.setImage(icon.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
        headbel = new JLabel("    Enter bank card det");
        headbel.setFont(new Font("Californian FB", Font.BOLD, 20));
        headbel.setForeground(Color.red);
        iv1 = new JLabel("ails such as Card Numbers");
        iv1.setFont(new Font("Californian FB", Font.BOLD, 20));
        iv1.setForeground(Color.red);
        iv2 = new JLabel("");
        iv2.setFont(new Font("Californian FB", Font.BOLD, 20));
        iv2.setForeground(Color.red);
        panel.add(image);
        panel.add(headbel);
        panel.add(iv1);
        panel.add(iv2);

        baname = new JLabel("                Bnak Name");
        baname.setForeground(Color.red);
        baname.setFont(new Font("Californian FB", Font.BOLD, 15));
        banknameld = new JTextField(20);
        panel.add(baname);
        panel.add(banknameld);

        nameoncard = new JLabel("                Name On Card");
        nameoncard.setForeground(Color.red);
        nameoncard.setFont(new Font("Californian FB", Font.BOLD, 15));
        nonceld = new JTextField(20);
        panel.add(nameoncard);
        panel.add(nonceld);

        cardty = new JLabel("                Card Type");
        cardty.setForeground(Color.red);
        cardty.setFont(new Font("Californian FB", Font.BOLD, 15));
        ctybox = new JComboBox();
        ctybox.addItem("");
        ctybox.addItem("Debit Card");
        ctybox.addItem("Credit Card");
        panel.add(cardty);
        panel.add(ctybox);

        cardnum = new JLabel("                Card Number");
        cardnum.setForeground(Color.red);
        cardnum.setFont(new Font("Californian FB", Font.BOLD, 15));
        cnumeld = new JTextField(20);
        panel.add(cardnum);
        panel.add(cnumeld);

        desbel = new JLabel("                Description");
        desbel.setForeground(Color.red);
        desbel.setFont(new Font("Californian FB", Font.BOLD, 15));
        deseld = new JTextField(20);
        iv3 = new JLabel("");
        iv4 = new JLabel("");
        panel.add(desbel);
        panel.add(deseld);
        panel.add(iv3);
        panel.add(iv4);

        secbel = new JLabel("                Security");
        secbel.setForeground(Color.red);
        secbel.setFont(new Font("Californian FB", Font.BOLD, 15));
        iv5 = new JLabel("____________________________________________________________");
        iv6 = new JLabel("_________________________________________________________");
        iv7 = new JLabel("____________________________________________________________");
        panel.add(secbel);
        panel.add(iv5);
        panel.add(iv6);
        panel.add(iv7);

        cardpin = new JLabel("                Crad Pin");
        cardpin.setForeground(Color.red);
        cardpin.setFont(new Font("Californian FB", Font.BOLD, 15));
        cpineld = new JTextField(20);
        panel.add(cardpin);
        panel.add(cpineld);

        cardcvv = new JLabel("                Card CVV");
        cardcvv.setForeground(Color.red);
        cardcvv.setFont(new Font("Californian FB", Font.BOLD, 15));
        ccvveld = new JTextField(20);
        panel.add(cardcvv);
        panel.add(ccvveld);

        okbt = new JButton("OK");
        okbt.setForeground(Color.black);
        okbt.setBackground(Color.pink);
        okbt.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
        iv8 = new JLabel("");
        canbt = new JButton("Cancel");
        canbt.setForeground(Color.black);
        canbt.setBackground(Color.pink);
        canbt.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
        message=new JLabel();
        panel.add(message);
        panel.add(iv8);
        message.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        message.setForeground(Color.red);
        panel.add(okbt);
        panel.add(canbt);
        okbt.addActionListener(this::actionPerformed);
        canbt.addActionListener(this::actionPerformed);

        /*allimg=new JLabel();
        ImageIcon iconn = new ImageIcon("C:\\Users\\31359\\Desktop\\bj12.jpg");
        allimg.setIcon(iconn);
        iconn.setImage(iconn.getImage().getScaledInstance(1920,1080, Image.SCALE_DEFAULT));
        panel.add(allimg,-1);
        panel.add(allimg);*/

        add(panel);

    }

    public static void main(String[] args) {
        new Gui2();

    }

    public void actionPerformed(ActionEvent e) {

        if ("OK".equals(e.getActionCommand())) {
            try {
                String bname = banknameld.getText();
                String naonc = nonceld.getText();
                String cardnumb =cnumeld.getText();
                String cardtype =ctybox.getToolTipText();
                String cardp =cpineld.getText();
                String des=deseld.getText();

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/card", "cope", "123");
                Statement stm = con.createStatement();
                stm.executeUpdate("insert into bank"+" values('"+bname+"','"+naonc+"','"+cardtype+"','"+cardnumb+"','"+des+"','"+cardp+"')");
                message.setText("Successfuly Added!");

            } catch (ClassNotFoundException | SQLException ex) {
                message.setText("Failed Added");
                System.out.println(ex);
            }
        } else if ("Cancel".equals(e.getActionCommand())) {
            banknameld.setText("");
            nonceld.setText("");
            cnumeld.setText("");
            deseld.setText("");
            deseld.setText("");
            cpineld.setText("");
            ccvveld.setText("");
            ctybox.setSelectedItem("");
            message.setText("");
        }
    }
}

