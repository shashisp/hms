/*
 * HOSTEL MANAGEMENT SYSTEM
 * EnterStudent class responsible for creating student data insert form,allows manager to enter student details
 */
package hms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class EnterStudent {

    public void EnterStudent(){
     Integer[] numbers = {1,2,3,4};
    final JFrame f=new JFrame("Hostel Management System");
    f.setVisible(true);
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p=new JPanel(new GridBagLayout());
   
    GridBagConstraints c=new GridBagConstraints();
    JLabel h=new JLabel("Enter New Student Details");
    h.setFont(new Font("serif", Font.PLAIN,26));

    JLabel l1 = new JLabel("USN");
    final JTextField t1 = new JTextField();
    t1.setColumns(12);

    JLabel l2 = new JLabel("Name");
    final JTextField t2 = new JTextField();
    t2.setColumns(12);

    JLabel l3 = new JLabel("Year");
    final JComboBox combo1 = new JComboBox(numbers);

    JLabel l4 = new JLabel("Room Number");
   // final JTextField t4 = new JTextField();
    //t4.setColumns(12);
     final JComboBox combo=new JComboBox();
     try{
      dbconnect con=new dbconnect();
      con.dropdownAddRoom(combo);

       }catch (Exception ex){
       System.out.println("Exception:"+ex);}

/*    JLabel l5 = new JLabel("No.Of.Days");
    final JTextField t5 = new JTextField();
    t5.setColumns(12);*/

    JLabel l6 = new JLabel("Balance");
    final JTextField t6 = new JTextField();
    t6.setColumns(12);

    JButton b = new JButton("Submit");
    JButton back=new JButton("Back");

    c.insets=new Insets(10,10,10,10);

    p.add(h);

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
    p.add(combo1,c);

    c.gridx=0;
    c.gridy=4;
    p.add(l4,c);

    c.gridx=1;
    c.gridy=4;
    p.add(combo,c);

    c.gridx=0;
    c.gridy=5;
  //  p.add(l5,c);

    c.gridx=1;
    c.gridy=5;
    //p.add(t5,c);
     
    c.gridx=0;
    c.gridy=6;
    p.add(l6,c);

    c.gridx=1;
    c.gridy=6;
    p.add(t6,c);

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
            String usn=new String(t1.getText());
            String name=new String(t2.getText());
            
            int year = (Integer)combo1.getSelectedItem();
              System.out.println("room");
           // int room = Integer.parseInt(t4.getText());
             int room=(Integer)combo.getSelectedItem();
              System.out.println("room");
      //     int noDays = Integer.parseInt(t5.getText());
            float bal=Float.parseFloat(t6.getText());
            System.out.println(room);

           if(usn.equals("") || name.equals(""))
            {
               JOptionPane.showMessageDialog(null,"Please fill details correctly");
            }
        else
        {
            dbconnect connect1=new dbconnect();
            connect1.putData(usn, name,year,room,bal);
            EnterStudent s=new EnterStudent();
            s.EnterStudent();
            f.setVisible(false);
        }
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Please fill details correctly");
    }
    }

    });


    back.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        ManagerInterface m=new ManagerInterface();
               m.ManagerInterface();
       f.setVisible(false);
    }});
  }

}
