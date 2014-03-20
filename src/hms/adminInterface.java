

package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class adminInterface {

 public void adminInterface(){
        
        final JFrame f=new JFrame("Hostel Management System");
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("ADMIN PANEL");
        h.setFont(new Font("seriff",Font.PLAIN,20));

         JButton b1 = new JButton("Add Manager");
         //JButton b2 = new JButton("Delete Manager");
         JButton b3=new JButton("Logout");

        c.insets=new Insets(10,10,10,10);
        c.gridx=0;
        c.gridy=1;
        p.add(h);

        c.gridx=0;
        c.gridy=2;
        p.add(b1,c);

        c.gridx=1;
        c.gridy=3;
        p.add(b3,c);

        f.add(p);
        
         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        addManager();
       f.setVisible(false);
    }});
      
         b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        login m=new login();
               m.login();
       f.setVisible(false);
    }});
 }

 public void addManager(){
  final JFrame f=new JFrame("Hostel Management System");
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("Add Manager");
        h.setFont(new Font("seriff",Font.PLAIN,20));

        JLabel l1 = new JLabel("Name");
    final JTextField t1 = new JTextField();
    t1.setColumns(12);

    JLabel l2 = new JLabel("Password");
    final JTextField t2 = new JTextField();
    t2.setColumns(12);

    JButton b1 = new JButton("Submit");

        JButton b2= new JButton("Logout");
     c.insets=new Insets(10,10,10,10);
        c.gridx=0;
        c.gridy=1;
        p.add(h);

        c.gridx=0;
        c.gridy=2;
        p.add(l1,c);
        
         c.gridx=1;
        c.gridy=2;
        p.add(t1,c);
        
        
         c.gridx=0;
        c.gridy=3;
        p.add(l2,c);
        
         c.gridx=1;
        c.gridy=3;
        p.add(t2,c);
        

        c.gridx=1;
        c.gridy=4;
        p.add(b1,c);

       c.gridx=2;
        c.gridy=4;
        p.add(b2,c);


        f.add(p);



  b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         try{
            String name=new String(t1.getText());
         String password=new String(t2.getText());

         if(name.equals("") || password.equals(""))
            {
               JOptionPane.showMessageDialog(null,"Please fill details correctly");
            }
        else
        {
            dbconnect connect1=new dbconnect();
            connect1.putManager(name,password);
            adminInterface();
            f.setVisible(false);
        }
       f.setVisible(false);
         }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Please fill details correctly");
    }
    }});
 b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        login m=new login();
               m.login();
       f.setVisible(false);
    }});

 }



}
