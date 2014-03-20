

package hms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class searchStudent {

    public void searchStudent(final int r)
    {

       final JFrame f=new JFrame("Search");
        
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        JLabel h=new JLabel("Search the record");
        h.setFont(new Font("seriff",Font.PLAIN,20));

        JLabel l1=new JLabel("USN");


         JLabel l2=new JLabel("Name");
            final JTextField t1=new JTextField();
        t1.setColumns(12);

        JButton b1=new JButton("Search");
        JButton b2=new JButton("Back");

        c.insets=new Insets(10,10,10,10);
        c.gridx=0;
        c.gridy=1;

        p.add(h);

        if(r==1)
        {
        c.gridx=0;
        c.gridy=2;
        p.add(l1,c);
        }else
        {
         c.gridx=0;
        c.gridy=2;
        p.add(l2,c);
        }

        c.gridx=1;
        c.gridy=2;
        p.add(t1,c);



        c.gridx=0;
        c.gridy=3;
        p.add(b1,c);

        c.gridx=1;
        c.gridy=3;
        p.add(b2,c);
        f.add(p);
        f.setVisible(true);

        b1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           try{
                String usn=new String(t1.getText());
                reportItem connect5=new reportItem();
                connect5.displaysearch(usn,r);
                f.setVisible(false);

           }catch(Exception e3)
           {
               JOptionPane.showMessageDialog(null,"wrong entry");
           }
       }
      });


b2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           try{
             reportInterface mn=new reportInterface();
                mn.reportInterface();
                f.setVisible(false);
           }catch(Exception e3)
           {
               JOptionPane.showMessageDialog(null,"wrong entry");
           }
       }
      });

     }

};