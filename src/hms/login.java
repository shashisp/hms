/*
 * HOSTEL MANAGEMENT SYSTEM
 * login class is responsible for creation of login form,validating manger
 */
package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class login {

    public void login(){

    final JFrame f=new JFrame("Hostel Management System");
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   

    JPanel p = new JPanel(new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();
    // f.getContentPane().setBackground(Color.YELLOW);
     ImageIcon icon = new ImageIcon("C:\\Users\\Harshith\\Desktop\\logo (1).png");
     JLabel l = new JLabel();
     l.setSize(new Dimension(100, 100));
  
    l.setIcon(icon);

    JLabel h=new JLabel("MANAGER LOGIN");
    h.setFont(new Font("serif", Font.PLAIN,26));
    h.setVisible(true);

    JLabel l1 = new JLabel("Username");
    final JTextField t1 = new JTextField();
    t1.setColumns(12);

    JLabel l2= new JLabel("Password");
    final JPasswordField t2 = new JPasswordField();
    t2.setColumns(12);

    JButton b = new JButton("Login");

    p.add(l);
    p.add(h);
    c.insets=new Insets(10,10,10,10);

    c.gridx=0;
    c.gridy=1;
    p.add(l1,c);

    c.gridx=1;
    c.gridy=1;
    p.add(t1,c);

    c.gridx=0;
    c.gridy=2;
    p.add(l2,c);

     c.gridx=1;
    c.gridy=2;
    p.add(t2,c);

    c.gridx=0;
    c.gridy=3;
    p.add(b,c);

    f.add(p);
    f.setVisible(true);

    //login button action performed
    b.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){
             String name=new String(t1.getText());
             String pw=new String(t2.getText());

            
            if(name.equals("") && pw.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"UserName name and password not entered");    
             }else
             if(name.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"UserName name not entered");
             }else
             
             if(pw.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Password not entered");      
             }
           
             else if(!(name.equals("admin") && pw.equals("admin")))
             {
             dbconnect connect=new dbconnect();
             connect.getData(name,pw);
             f.setVisible(false);           
             }
               else
             {
              adminInterface a=new adminInterface();
              a.adminInterface();
              f.setVisible(false);

             }
        }


    });
    }
  
}
