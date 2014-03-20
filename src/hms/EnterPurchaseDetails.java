
package hms;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnterPurchaseDetails {
public void EnterPurchase()
{
       final JFrame f=new JFrame("Hostel Management System");
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("ENTER PURCHASE DETAILS");
        h.setFont(new Font("serif", Font.PLAIN,26));

        JLabel l1=new JLabel("bill number");
        final JTextField t1 = new JTextField();
        t1.setColumns(12);


        JLabel l2=new JLabel("Item");
        final JComboBox combo=new JComboBox();
        try{
           dbconnect con=new dbconnect();
           con.dropdownAddItem(combo);
           }catch (Exception ex){
             System.out.println("Exception:"+ex);}

       JLabel l3=new JLabel("Quantity");
       final JTextField t3 = new JTextField();
       t3.setColumns(10);

        JLabel l4=new JLabel("Price");
       final JTextField t4 = new JTextField();
       t4.setColumns(10);

       JLabel l5=new JLabel("Date");
       final JTextField t5 = new JTextField();
       t5.setColumns(10);

       JButton b0=new JButton("Add Item");
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
          p.add(combo,c);

          c.gridx=0;
          c.gridy=3;
          p.add(l3,c);
          c.gridx=1;
          c.gridy=3;
          p.add(t3,c);

          c.gridx=0;
          c.gridy=4;
          p.add(l4,c);
          c.gridx=1;
          c.gridy=4;
          p.add(t4,c);

           c.gridx=1;
          c.gridy=6;
          p.add(b0,c);

          c.gridx=1;
          c.gridy=5;
          p.add(b1,c);

          c.gridx=2;
          c.gridy=5;
          p.add(b2,c);

          f.add(p);



           b0.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          item m=new item();
               m.item();
           f.setVisible(false);
          }});

            b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          try{
            int bill_no= Integer.parseInt(t1.getText());
           String name=(String)combo.getSelectedItem(); 
           int qty= Integer.parseInt(t3.getText());
           float price=Float.parseFloat(t4.getText());

           if(name.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please fill details correctly");
           }
           else
           {
            dbconnect connect1=new dbconnect();
            connect1.putPurchase(bill_no,name,qty,price);
            EnterPurchaseDetails n=new EnterPurchaseDetails();
            n.EnterPurchase();
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
