

package hms;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class consumption {
    public void consumption(){

     final JFrame f=new JFrame("Hostel Management System");
     f.setVisible(true);
     f.setSize(600, 600);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     JPanel p=new JPanel(new GridBagLayout());
     GridBagConstraints c=new GridBagConstraints();


     JLabel h=new JLabel("CONSUMPTION DETAILS");
     h.setFont(new Font("serif", Font.PLAIN,26));

      JLabel l1=new JLabel("Item");
     final JComboBox combo=new JComboBox();
     try{
      dbconnect con=new dbconnect();
      con.dropdownAddItem(combo);

       }catch (Exception ex){
       System.out.println("Exception:"+ex);}

     JLabel l2=new JLabel("Date");
         final JTextField t2 = new JTextField();
         t2.setColumns(10);

     JLabel l3=new JLabel("Quantity");
         final JTextField t3 = new JTextField();
         t3.setColumns(10);

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
          p.add(combo,c);

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

          f.add(p);
          
           b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          try{
           String name=(String)combo.getSelectedItem();
           String date= new String(t2.getText());
           int qty= Integer.parseInt(t3.getText());
          

           if(name.equals("") || date.equals("") )
           {
                JOptionPane.showMessageDialog(null,"Please fill details correctly");
           }
           else
           {
            dbconnect connect1=new dbconnect();
            connect1.putConsumption(name,date,qty);
           consumption n=new consumption();
            n.consumption();
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

    
 
