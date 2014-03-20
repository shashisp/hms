

package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class reportInterface {
public int r;
public void reportInterface(){
     final JFrame f=new JFrame("Hostel Management System");
    f.setVisible(true);
    f.setSize(600,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p1=new JPanel(new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();


     JLabel h=new JLabel("Report Interface");
    h.setFont(new Font("serif", Font.PLAIN,26));

    JButton b1=new JButton("Item");
     b1.setPreferredSize(new Dimension(160, 25));

    JButton b2=new JButton("Invoice");
    b2.setPreferredSize(new Dimension(160, 25));

    JButton b3=new JButton("Consumption");
     b3.setPreferredSize(new Dimension(160, 25));

    JButton b4=new JButton("Guest Meal");
     b4.setPreferredSize(new Dimension(160, 25));

    JButton b5=new JButton("Other Expenses");
     b5.setPreferredSize(new Dimension(160, 25));

     JButton b6=new JButton("Student");
      b6.setPreferredSize(new Dimension(160, 25));


    //  JButton b8=new JButton("Generate Report");
     // b6.setPreferredSize(new Dimension(160, 25));
      JButton b7=new JButton("Back");



      c.insets=new Insets(10,10,10,10);

      p1.add(h);

      c.gridx=0;
      c.gridy=1;
      p1.add(b1,c);
     
      c.gridx=0;
      c.gridy=2;
      p1.add(b2,c);

      c.gridx=0;
      c.gridy=3;
      p1.add(b3,c);

      c.gridx=0;
      c.gridy=4;
      p1.add(b4,c);

      c.gridx=0;
      c.gridy=5;
      p1.add(b5,c);

       c.gridx=0;
      c.gridy=6;
      p1.add(b6,c);

   /*    c.gridx=0;
      c.gridy=7;
      p1.add(b8,c);*/
       c.gridx=3;
      c.gridy=8;
      p1.add(b7,c);

      f.add(p1);

       //display item
      b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=1;
       reportItem s=new reportItem();
       s.reportItem(r);
       f.setVisible(false);
    }
   });

 b2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=2;
       reportItem s=new reportItem();
       s.reportItem(r);
       f.setVisible(false);
    }
   });

 b3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=3;
       reportItem s=new reportItem();
       s.reportItem(r);
       f.setVisible(false);
    }
   });
 b4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=4;
       reportItem s=new reportItem();
       s.reportItem(r);
       f.setVisible(false);
    }
   });

    b5.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=5;
       reportItem s=new reportItem();
       s.reportItem(r);
       f.setVisible(false);
    }
   });

 b6.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
          r=6;
        reportItem s=new reportItem();
       s.reportItem(r);
     //  searchStudent s=new searchStudent();
       //s.searchStudent();
       f.setVisible(false);
    }
   });

    b7.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       ManagerInterface m=new ManagerInterface();
         m.ManagerInterface();
       f.setVisible(false);
    }
   });

  /*  b8.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       Report s=new Report();
       s.Report();
       f.setVisible(false);
    }
   });*/
}
}
