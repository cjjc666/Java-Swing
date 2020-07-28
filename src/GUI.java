import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class GUI implements ActionListener{
    JFrame j;
    JPasswordField pswbel;
    JLabel webbel, idbel, desbel, image, psbel, headlinebel,message,allimg;
    JTextField webld, idld, desld;
    JButton okbt, canbt;
    JMenu pswmanagement;
    JMenuBar menuBar;

    GUI() {
        j=new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(650,500);
        j.setSize(650, 500);
        j.setLocationRelativeTo(j);
        j.setTitle("Add/Edit Authentication Record");

        menuBar = new JMenuBar();
        pswmanagement = new JMenu("Password Management");
        pswmanagement.setFont(new Font("Californian FB", Font.BOLD, 15));
        menuBar.add(pswmanagement);
        j.setJMenuBar(menuBar);

        /*firstword=new JLabel("Enetr username,Password and Web Url here...");
        image=new JLabel();
        ImageIcon icon=new ImageIcon("");
        image.setIcon(icon);
        panel.add(firstword);
        panel.add(image);*/

        image = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\31359\\Desktop\\1.jpg");
        image.setIcon(icon);
        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        image.setBounds(50,10,50,50);
        panel.add(image);

        headlinebel = new JLabel("Enter Username,Password and Web URL here...");
        //invalidbel=new JLabel(" ");
        headlinebel.setFont(new Font("Californian FB", Font.BOLD, 21));
        headlinebel.setForeground(Color.black);
        headlinebel.setBounds(120,20,500,30);
        panel.add(headlinebel);
        // panel.add(invalidbel);

        webbel = new JLabel("Web Url/App Name");
        webbel.setForeground(Color.red);
        webbel.setFont(new Font("Californian FB", Font.BOLD, 18));
        webbel.setBounds(100, 100, 200, 50);
        webld = new JTextField();
        webld.setBounds(310, 100, 180, 30);

        idbel = new JLabel("User ID");
        idbel.setForeground(Color.red);
        idbel.setFont(new Font("Californian FB", Font.BOLD, 18));
        idbel.setBounds(100,150,200,50);
        idld = new JTextField();
        idld.setBounds(310, 150, 180, 30);

        psbel = new JLabel("Password");
        psbel.setForeground(Color.red);
        psbel.setFont(new Font("Californian FB", Font.BOLD, 18));
        psbel.setBounds(100, 200, 200, 50);
        pswbel = new JPasswordField();
        pswbel.setBounds(310, 200, 180, 30);

        desbel = new JLabel("Description");
        desbel.setFont(new Font("Californian FB", Font.BOLD, 18));
        desbel.setForeground(Color.red);
        desbel.setBounds(100, 250, 200, 50);
        desld = new JTextField();
        desld.setBounds(310, 250, 180, 30);

        okbt = new JButton("OK");
        okbt.setForeground(Color.black);
        okbt.setBackground(Color.pink);
        okbt.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
        okbt.setBounds(150, 370, 80, 30);
        canbt = new JButton("Cancel");
        canbt.setForeground(Color.black);
        canbt.setBackground(Color.pink);
        canbt.setFont(new Font("Bradley Hand ITC", Font.BOLD, 20));
        canbt.setBounds(350, 370, 150, 30);
        okbt.addActionListener(this::actionPerformed);
        canbt.addActionListener(this::actionPerformed);

        message=new JLabel();
        message.setBounds(100, 300, 250, 35);
        message.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 20));
        panel.add(message,0);

        allimg=new JLabel();
        ImageIcon iconn = new ImageIcon("C:\\Users\\31359\\Desktop\\bj1.jpg");
        allimg.setIcon(iconn);
        iconn.setImage(iconn.getImage().getScaledInstance(650, 500, Image.SCALE_DEFAULT));
        allimg.setBounds(0,0,650,500);
        panel.add(allimg,-1);

        panel.add(webld,0);
        panel.add(idld,0);
        panel.add(pswbel,0);
        panel.add(desld,0);
        panel.add(webbel,0);
        panel.add(idbel,0);
        panel.add(psbel,0);
        panel.add(desbel,0);
        panel.add(okbt,0);
        panel.add(canbt,0);

        j.add(panel);
        j.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e) {
        if ((webld.getText()==null || idld.getText()==null)||((pswbel.getText()==null)||(desld.getText()==null)) ) {
            message.setText("Failed Added!");
            message.setForeground(Color.red);

        }
        if ("OK".equals(e.getActionCommand())) {
            if(webld.getText() == null){
                message.setText("The content filled in cannot be empty!");
                message.setForeground(Color.red);
            }
            else{
                try {
                    String weburl = webld.getText();
                    String username = idld.getText();
                    String userpwd = pswbel.getText();
                    String desc=desld.getText();
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    //System.out.println("good");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/card", "cope", "123");
                    Statement stm = con.createStatement();
                    stm.executeUpdate("insert into tetx"+" values('"+desc+"','"+username+"','"+userpwd+"','"+weburl+"')");
                    //stm.executeUpdate("insert into text"+" values('http://154.com','park','456','QQ')");
                    //System.out.println("successfully");
                    message.setText("Successfuly Added!");
                    message.setForeground(Color.RED);
                    new Menagementgui();
                    j.setVisible(false);
                }
                catch (Exception ex) {
                    message.setText("Failed Added!");
                    message.setForeground(Color.red);
                    System.out.println(ex);
                }
            }
        } else if ("Cancel".equals(e.getActionCommand())) {
            webld.setText("");
            idld.setText("");
            desld.setText("");
            pswbel.setText("");
            message.setText("");

        }
    }
}

