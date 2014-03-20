
package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnterGuestMeal {
   public void EnterGuestMeal(){
      String[] guests={ "Student Guest","Faculty Guest","College Guest","Parents","Others"};
     final JFrame f=new JFrame("Hostel Management System");
     f.setVisible(true);
     f.setSize(600, 600);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     JPanel p=new JPanel(new GridBagLayout());
     GridBagConstraints c=new GridBagConstraints();

     JLabel h=new JLabel("GUEST MEALS");
     h.setFont(new Font("serif", Font.PLAIN,26));

     JLabel l1=new JLabel("Type");
      final JComboBox t1 = new JComboBox(guests);
    // final JTextField t1 = new JTextField();
     //t1.setColumns(12);

     JLabel l2=new JLabel("Cost");
     final JTextField t2 = new JTextField();
     t2.setColumns(12);

      JButton b1=new JButton("Done");
      JButton b2=new JButton("Back");

      c.insets=new Insets(5,5,10,10);

     c.gridx=0;
     c.gridy=0;
     p.add(h,c);

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

     c.gridx=1;
     c.gridy=5;
     p.add(b1,c);
     c.gridx=2;
     c.gridy=5;
     p.add(b2,c);

     f.add(p);

  b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          try{
           String type=(String)t1.getSelectedItem();
           float amount=Float.parseFloat(t2.getText());

           if(type.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please fill details correctly");
           }
           else
           {
            dbconnect connect1=new dbconnect();
            connect1.putGuestMeal(type,amount);
            EnterGuestMeal n=new EnterGuestMeal();
            n.EnterGuestMeal();
            f.setVisible(false);

           }
          }catch (Exception ex){
        JOptionPane.showMessageDialog(null,"Please fill details correctly");
    }
          }});



     b2.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
     ManagerInterface m=new ManagerInterface();
      m.ManagerInterface();
     f.setVisible(false);
          }});

   }
}
