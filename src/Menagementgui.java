
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Menagementgui{
    JFrame j;
    JTable jt;
    JMenu file, edit, about;
    JMenuBar  menuBar;
    JScrollPane sp;
    JLabel im1, im2, im3, im4, cateel,authdetailsel,cardel, titlel, usrenamel, accountel, urlel,message,allimg;
    JLabel authon;

    Menagementgui() {
        j=new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1000,500);
        j.setTitle("Card && Password Management System");
        j.setSize(1000, 500);
        j.setLocationRelativeTo(j);
        j.setVisible(true);

        menuBar = new JMenuBar();
        file = new JMenu("File");
        file.setFont(new Font("Californian FB", Font.BOLD, 15));
        edit = new JMenu("Edit");
        edit.setFont(new Font("Californian FB", Font.BOLD, 15));
        about = new JMenu("About");
        about.setFont(new Font("Californian FB", Font.BOLD, 15));
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(about);
        j.setJMenuBar(menuBar);

        allimg=new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\31359\\Desktop\\dl.jpg");
        allimg.setIcon(icon);
        icon.setImage(icon.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
        allimg.setBounds(0,0,1000,500);
        panel.add(allimg,-1);

        im1 = new JLabel();
        ImageIcon iconn = new ImageIcon("C:\\Users\\31359\\Desktop\\1.jpg");
        im1.setIcon(iconn);
        iconn.setImage(iconn.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        im1.setBounds(0,10,30,30);
        im2 = new JLabel();
        ImageIcon icon1 = new ImageIcon("C:\\Users\\31359\\Desktop\\3.jpg");
        im2.setIcon(icon1);
        im2.setBounds(40,10,30,30);
        icon1.setImage(icon1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        im3 = new JLabel();
        ImageIcon icon2 = new ImageIcon("C:\\Users\\31359\\Desktop\\2.jpg");
        im3.setIcon(icon2);
        icon2.setImage(icon2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        im3.setBounds(80,10,30,30);
        im4 = new JLabel();
        ImageIcon icon3 = new ImageIcon("C:\\Users\\31359\\Desktop\\4.jpg");
        im4.setIcon(icon3);
        icon3.setImage(icon3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        im4.setBounds(120,10,30,30);
        panel.add(im1,0);
        panel.add(im2,0);
        panel.add(im3,0);
        panel.add(im4,0);

        cateel = new JLabel("Category");
        cateel.setForeground(Color.red);
        cateel.setFont(new Font("Californian FB", Font.BOLD, 25));
        cateel.setBounds(100, 80, 200, 30);
        authdetailsel = new JLabel("Authentication Details");
        authdetailsel.setForeground(Color.red);
        authdetailsel.setFont(new Font("Californian FB", Font.BOLD, 25));
        authdetailsel.setBounds(310, 80, 280, 30);
        panel.add(cateel,0);
        panel.add(authdetailsel,0);

        cardel = new JLabel("Card Details");
        cardel.setForeground(Color.red);
        cardel.setFont(new Font("Californian FB", Font.BOLD,20));
        cardel.setBounds(100, 150, 200, 50);
        panel.add(cardel,0);

        authon = new JLabel("Authentication Details");
        authon.setForeground(Color.red);
        authon.setFont(new Font("Californian FB", Font.BOLD, 20));
        authon.setBounds(60, 250, 150, 50);
        panel.add(authon,0);

        String head[]={"Tilte","User name","Account","URL"};
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("successly");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/card", "cope", "123");
            Statement stm = con.createStatement();
            String sql;
            sql = "select * from tetx";
            ResultSet rs = stm.executeQuery(sql);
            Object obj[][]=new Object[20][20];
            int i=0;
            while (rs.next()) {
                int j=0;
                obj[i][j++]=rs.getString("DES");
                obj[i][j++]=rs.getString("USERNAME");
                obj[i][j++]=rs.getString("USERPWD");
                obj[i][j++]=rs.getString("WEBURL");
                i++;
            }
            jt=new JTable(obj,head);
            jt.setBackground(Color.white);
            sp=new JScrollPane(jt);
            sp.setBounds(310,150,600,300);
            panel.add(sp,0);
            j.add(panel);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
    }
}
