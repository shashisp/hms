/*
 *
 * HOSTEL MANAGEMENT SYSTEM
 * ManagerInterface class responsible for creating Manager Interface form
 */
package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ManagerInterface {

   public void ManagerInterface(){
    final JFrame f=new JFrame("Hostel Management System");
    f.setVisible(true);
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p1=new JPanel(new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();

    
     JLabel h=new JLabel("MANGER INTERFACE");
    h.setFont(new Font("serif", Font.PLAIN,26));

    JButton b1=new JButton("Enter Students Details");
     b1.setPreferredSize(new Dimension(200, 25));

   JButton b2=new JButton("Delete Student");
   b2.setPreferredSize(new Dimension(200, 25));

     JButton b10=new JButton("Enter Invoice");
    b10.setPreferredSize(new Dimension(200, 25));

    JButton b3=new JButton("Enter Consumption Details");
     b3.setPreferredSize(new Dimension(200, 25));

    JButton b4=new JButton("Report");
     b4.setPreferredSize(new Dimension(200, 25));

    JButton b5=new JButton("Logout");

    JButton b6=new JButton("Enter Other Expenses details");
     b6.setPreferredSize(new Dimension(200, 25));
    
     JButton b7=new JButton("Enter Guest Meal details");
      b7.setPreferredSize(new Dimension(200, 25));

    JButton b8=new JButton("Grant leave");
     b8.setPreferredSize(new Dimension(200, 25));

     // JButton b9=new JButton("Evaluate");
     //b9.setPreferredSize(new Dimension(200, 25));

      c.insets=new Insets(10,10,10,10);

      p1.add(h);

      c.gridx=0;
      c.gridy=1;
      p1.add(b1,c);

      c.gridx=0;
      c.gridy=2;
      p1.add(b8,c);

      c.gridx=0;
      c.gridy=3;
     p1.add(b2,c);

      c.gridx=0;
      c.gridy=4;
      p1.add(b10,c);

     
      c.gridx=0;
      c.gridy=5;
      p1.add(b3,c);

       c.gridx=0;
      c.gridy=6;
      p1.add(b6,c);

       c.gridx=0;
      c.gridy=7;
      p1.add(b7,c);

       c.gridx=0;
      c.gridy=8;
      p1.add(b4,c);     

       c.gridx=3;
      c.gridy=10;
      p1.add(b5,c);

  //    c.gridx=0;
    //  c.gridy=9;
      //p1.add(b9,c);


      f.add(p1);

     //Enter Student details button action
      b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       EnterStudent s=new EnterStudent();
       s.EnterStudent();
       f.setVisible(false);
    }
   });

  //to enter purchase details of invoices
    b2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       deleteStudent s=new deleteStudent();
       s.deleteStudent();
       f.setVisible(false);
    }
   });

   //to enter invoice details
    b10.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       EnterInvoice s=new EnterInvoice();
       s.EnterInvoice();
       f.setVisible(false);
    }
   });
   //to enter consumption details
    b3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       consumption c=new consumption();
       c.consumption();
       f.setVisible(false);
    }
   });

   //to generate report
    b4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       reportInterface r=new reportInterface();
       r.reportInterface();
       f.setVisible(false);
    }});


    //Logout button action
    b5.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       login l=new login();
       l.login();
       f.setVisible(false);
    }});

    //For entering Other Expenses
     b6.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        EnterOtherExpense e1=new EnterOtherExpense();
         e1.EnterOtherExpense();
       f.setVisible(false);
    }
   });


   //For entering Guest meal
  b7.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        EnterGuestMeal e2=new EnterGuestMeal();
         e2.EnterGuestMeal();
       f.setVisible(false);
    }
   });

   
    //grant leave button action
   b8.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       leave s=new leave();
       s.leave();
       f.setVisible(false);
    }
   });

  
}

}
