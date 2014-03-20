

package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class deleteStudent {
public void deleteStudent(){
     final JFrame f=new JFrame("Hostel Management System");
    f.setVisible(true);
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p=new JPanel(new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();

     JLabel h=new JLabel("Delete Student");
        h.setFont(new Font("serif", Font.PLAIN,26));

    JLabel l1 = new JLabel("USN");
    final JTextField t1 = new JTextField();
    t1.setColumns(12);

      JButton b = new JButton("Submit");

     JButton b2= new JButton("Back");
c.insets=new Insets(10,10,10,10);

 c.gridx=0;
    c.gridy=0;
    p.add(h,c);


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
    p.add(b2,c);
    f.add(p);


     b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
           try{
            String usn=new String(t1.getText());
           //int noDays = Integer.parseInt(t5.getText());
   if(usn.equals(""))
            {
               JOptionPane.showMessageDialog(null,"Please fill details correctly");
            }
    else
         {
             dbconnect connect1=new dbconnect();
             connect1.deleteStud(usn);
             deleteStudent m=new deleteStudent();
             m.deleteStudent();
             f.setVisible(false);
         }
           }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Wrong Entry");}
    }
    });

     b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        ManagerInterface m=new ManagerInterface();
               m.ManagerInterface();
       f.setVisible(false);
    }});
}

}
