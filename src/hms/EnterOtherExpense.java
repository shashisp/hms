
package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class EnterOtherExpense {
    public void EnterOtherExpense(){
        String[] types={"Fuel","Repair","Utesils","Pretty Expenditures"};
        Integer[] months = { 1,2,3,4,5,6,7,8,9,10,11,12};
        final JFrame f=new JFrame("Hostel Management System");
        f.setVisible(true);
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("OTHER EXPENSES DETAILS");
        h.setFont(new Font("serif", Font.PLAIN,26));

        JLabel l1=new JLabel("Type");
          final JComboBox t1= new JComboBox(types);

        JLabel l2=new JLabel("Month");
        final JComboBox t2= new JComboBox(months);
  

         JLabel l3=new JLabel("Year");
         final JTextField t3 = new JTextField();
         t3.setColumns(5);

         JLabel l4=new JLabel("Amount");
         final JTextField t4 = new JTextField();
         t4.setColumns(12);

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
           int month= (Integer)t2.getSelectedItem();
           int year= Integer.parseInt(t3.getText());
           float amount=Float.parseFloat(t4.getText());

           if(type.equals(""))
           {
                JOptionPane.showMessageDialog(null,"Please fill details correctly");
           }
           else
           {
            dbconnect connect1=new dbconnect();
            connect1.putOtherExpense(type,month,year,amount);
            EnterOtherExpense n=new EnterOtherExpense();
            n.EnterOtherExpense();
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

    // public static void main(String[] args){
      //   EnterOtherExpense e=new EnterOtherExpense();
        // e.EnterOtherExpense();
     //}
}
