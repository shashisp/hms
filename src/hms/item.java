
package hms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class item {
    public void item(){
    final JFrame f=new JFrame("Hostel Management System");
    f.setVisible(true);
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p=new JPanel(new GridBagLayout());
   // p.setSize(300, 300);
    GridBagConstraints c=new GridBagConstraints();

     JLabel h=new JLabel("Add new item");
    h.setFont(new Font("AmbexHeavy", Font.PLAIN,32));

    JLabel l1 = new JLabel("Item name");
    final JTextField t1 = new JTextField();
    t1.setColumns(12);
    JButton b = new JButton("Submit");

      JButton back = new JButton("Back");

    c.insets=new Insets(10,10,10,10);
 p.add(h);
    c.gridx=0;
    c.gridy=1;
    p.add(l1,c);

     c.gridx=1;
    c.gridy=1;
    p.add(t1,c);

    c.gridx=1;
    c.gridy=8;
    p.add(b,c);

      c.gridx=2;
    c.gridy=8;
    p.add(back,c);

     f.add(p);
    b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
           try{
            String item=new String(t1.getText());

   if(item.equals(""))//|| room.equals("") )
            {
               JOptionPane.showMessageDialog(null,"Please fill details correctly");
            }
    else
        {
            dbconnect connect1=new dbconnect();
            connect1.addItem(item);
            {
             EnterPurchaseDetails m=new EnterPurchaseDetails();
               m.EnterPurchase();
            f.setVisible(false);}
            //else {JOptionPane.showMessageDialog(null,item+" already present");}
        }
           }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Wrong Entry");}
    }
    });

      back.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        EnterPurchaseDetails m=new EnterPurchaseDetails();
               m.EnterPurchase();
       f.setVisible(false);
    }});
    }

}
