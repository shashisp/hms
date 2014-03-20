

package hms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class reportItem {
 public void reportItem(int r){
     Vector columnName=new Vector();
    Vector data=new Vector();
     dbconnect con1=new dbconnect();
     con1.dispalyItem(data,columnName,r);

      JPanel p=new JPanel(new GridBagLayout());
      GridBagConstraints c=new GridBagConstraints();

    JTable table = new JTable(data, columnName);
    TableColumn col;
    for (int i = 0; i < table.getColumnCount(); i++) {
    col = table.getColumnModel().getColumn(i);
    col.setMaxWidth(250);
    }

   
    JScrollPane scrollPane = new JScrollPane( table );

   
    final JFrame f=new JFrame("REPORT");
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    JLabel h=new JLabel("REPORT");
    h.setFont(new Font("serif", Font.PLAIN,26));

    JButton b=new JButton("back");

      JButton b2=new JButton("Search by USN");

       JButton b3=new JButton("Search by Name");
     c.insets=new Insets(5,5,10,10);
    c.gridx=0;
    c.gridy=1;
    p.add(h,c);

    c.gridx=0;
    c.gridy=2;
    p.add(scrollPane,c);

    c.gridx=0;
    c.gridy=3;
    p.add(b,c);

    if(r==6)
    {
        c.gridx=1;
        c.gridy=3;
        p.add(b2,c);

        c.gridx=2;
        c.gridy=3;
        p.add(b3,c);
    }

    f.add(p);

    f.setSize(800,600);
    f.setVisible(true);

     b.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          reportInterface m=new reportInterface();
               m.reportInterface();
           f.setVisible(false);
          }});

       b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              int r=1;
          searchStudent s=new searchStudent();
           s.searchStudent(r);
           f.setVisible(false);
          }});

           b3.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              int r=2;
          searchStudent s=new searchStudent();
           s.searchStudent(r);
           f.setVisible(false);
          }});
 }




 public void displaysearch(String usn,int r){
     Vector columnName=new Vector();
    Vector data=new Vector();
     dbconnect con1=new dbconnect();
     con1.displaysearch(data,columnName,usn,r);

      JPanel p=new JPanel(new GridBagLayout());
      GridBagConstraints c=new GridBagConstraints();

    JTable table = new JTable(data, columnName);
    table.setSize(300,300);
    TableColumn col;
    for (int i = 0; i < table.getColumnCount(); i++) {
    col = table.getColumnModel().getColumn(i);
    col.setMaxWidth(250);
    }
    JScrollPane scrollPane = new JScrollPane( table );
    scrollPane.setSize(300,300);
    final JFrame f=new JFrame("REPORT");
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    JLabel h=new JLabel("REPORT");
    h.setFont(new Font("serif", Font.PLAIN,26));

    JButton b=new JButton("back");

     c.insets=new Insets(5,5,10,10);
    c.gridx=0;
    c.gridy=1;
    p.add(h,c);

    c.gridx=0;
    c.gridy=2;
    p.add(scrollPane,c);

    c.gridx=0;
    c.gridy=3;
    p.add(b,c);

    f.add(p);

    f.setSize(600,600);
    f.setVisible(true);

     b.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
          reportInterface m=new reportInterface();
          m.reportInterface();
          f.setVisible(false);
          }});
 }

}
