
package hms;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnterInvoice {
public void EnterInvoice(){
     final JFrame f=new JFrame("Hostel Management System");
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("ENTER INVOICE");
        h.setFont(new Font("serif", Font.PLAIN,26));

        JLabel l2=new JLabel("Total price");
        final JTextField t2 = new JTextField();
        t2.setColumns(12);

        JLabel l3=new JLabel("Date");
        final JTextField t3 = new JTextField();
        t3.setColumns(12);

          JButton b1=new JButton("Done");

          JButton b2=new JButton("Back");

           JButton b3=new JButton("Enter Purchase Details");

      c.insets=new Insets(5,5,10,10);

     c.gridx=0;
     c.gridy=0;
     p.add(h,c);

   /*  c.gridx=0;
     c.gridy=1;
     p.add(l1,c);
     c.gridx=1;
     c.gridy=1;
     p.add(t1,c);*/

     c.gridx=0;
     c.gridy=2;
     p.add(l2,c);
     c.gridx=1;
     c.gridy=2;
     p.add(t2,c);

      c.gridx=0;
      c.gridy=3;
      p.add(l3,c);
      c.gridx=1;
      c.gridy=3;
      p.add(t3,c);

     c.gridx=1;
     c.gridy=5;
     p.add(b1,c);
     c.gridx=2;
     c.gridy=5;
     p.add(b2,c);

     c.gridx=0;
      c.gridy=5;
      p.add(b3,c);

     f.add(p);


          b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          try{
         //   int bill_no= Integer.parseInt(t1.getText());
           float price=Float.parseFloat(t2.getText());
           String date=new String(t3.getText());

           if(date.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please fill details correctly");
           }
           else
           {
            dbconnect connect1=new dbconnect();
            connect1.putInvoice(price,date);
            EnterInvoice n=new EnterInvoice();
            n.EnterInvoice();
           
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

          b3.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          EnterPurchaseDetails n=new EnterPurchaseDetails();
            n.EnterPurchase();
           f.setVisible(false);
          }});


}


}
