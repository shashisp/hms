/*
 /*
 * HOSTEL MANAGEMENT SYSTEM
 * dbconnect() establishes connecction to database
 * getData() retreives data from database
 * putData() inserts data into database
 */

package hms;

import java.sql.*;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;


public class dbconnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int rs1;
    private ResultSetMetaData md;
    String mgr;
    int s_no;
    java.util.Date date;
    int i;
    int nd=0;
    int nm=0;
int day;

public dbconnect(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
       // con=DriverManager.getConnection("jdbc:mysql://192.168.24.148:3306/hms","Sudeep","ok");
        st=con.createStatement();

        rs=st.executeQuery("SELECT COUNT(usn) FROM student");
        if(rs.next())
        s_no=rs.getInt(1);
                  date=new java.util.Date();
        
       }catch(Exception ex){
        System.out.println("Error"+ex);
    }
}


public void getData(String name,String pw){
     try{
        //public static String mgr;
         int flag=0;
         System.out.println("connection success");
         String query= "SELECT * FROM manager" ;
         rs=st.executeQuery(query);
         System.out.println("Records from database");
         while(rs.next())
         {
            String mgrid=rs.getString("mgr_id");
            String username=rs.getString("name");
            String password=rs.getString("password");
 
           if(username.equals(name) && password.equals(pw))
           {
               
               //  System.out.println(mgr);
               mgr=mgrid;
                System.out.println(mgr);
               System.out.println("Login Success");
               rs1=st.executeUpdate("update temp set mgr_id='"+mgr+"' ");
              
              Calendar cal=Calendar.getInstance();
              cal.setTime(date);
              System.out.println("connection success");
              int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
               day = cal.get(Calendar.DAY_OF_MONTH);

              System.out.println("connection success"+day+month+year);
              System.out.println("connection success");
               rs=st.executeQuery("select nextd,nextm from temp");
               System.out.println("connection success");
               if(rs.next()){
                nd=rs.getInt("nextd");
                nm=rs.getInt("nextm");
               }


              System.out.println("connection success");
              if(day==nd&&month==nm){evaluate(nd,nm,year);}
              else{ ManagerInterface m=new ManagerInterface();
               m.ManagerInterface();
               flag=1;}


           }
          }
   
         if(flag==0){
         JOptionPane.showMessageDialog(null,"LOGIN FAILED");
         login l=new login();
         l.login();
         }

     }catch(Exception ex){
     // System.out.println(ex);
    }
   }



public void putData(String usn,String name,int year,int room,float bal){
     try{
         s_no++;
         System.out.println("connection success");
        rs1=st.executeUpdate("INSERT INTO student VALUES ('"+s_no+"','"+usn+"','"+name+"','"+year+"','"+room+"',30,1,'"+bal+"')");
        // rs1=st.executeUpdate("INSERT INTO student VALUES (18,'"+usn+"','"+name+"',2,2,'"+noDays+"',1,'"+bal+"')");
         
         JOptionPane.showMessageDialog(null,"Data Added successfully");
         return;
       }catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
}



public void putLeave(String usn, int noDays){
try{
    rs1=st.executeUpdate("update student set no_of_days=no_of_days-'"+noDays+"' where usn='"+usn+"'");

   if(rs1==0){JOptionPane.showMessageDialog(null,"Wrong Entry");
    return;}
   JOptionPane.showMessageDialog(null,"Updated successfully");
    return;
   }
    catch(Exception ex){JOptionPane.showMessageDialog(null,"Wrong Entry");}
}


void putOtherExpense(String type, int month, int year, float amount) {
   try{
        int temp=0;
         rs = st.executeQuery("SELECT type,month FROM other_expenses");
         while(rs.next()){
                String name=rs.getString("type");
                int mon=rs.getInt("month");
               if(name.equals(type) && mon==month){
                   temp=1;
               }
         }
         System.out.println(temp);
         if(temp==1)
         {
         rs1=st.executeUpdate("UPDATE other_expenses set cost=cost+'"+amount+"' WHERE type='"+type+"' and month='"+month+"'");
         }else
         {
         rs1=st.executeUpdate("INSERT INTO other_expenses VALUES ('"+type+"','"+month+"','"+year+"','"+amount+"',1)");
         }JOptionPane.showMessageDialog(null,"Data Added successfully");
         return;
       }catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
 }

void putGuestMeal(String type,float amount) {
   try{
        int temp=0;
         rs = st.executeQuery("SELECT name FROM guest_meal");
         while(rs.next()){
                String name=rs.getString("name");
               if(type.equals(name)){
                   temp=1;
               }
         }
         System.out.println(temp);
         if(temp==1)
         {
         rs1=st.executeUpdate("UPDATE guest_meal set cost=cost+'"+amount+"' WHERE name='"+type+"'");
         }else
         {
         rs1=st.executeUpdate("INSERT INTO guest_meal VALUES ('"+type+"','"+amount+"',1)");
         }JOptionPane.showMessageDialog(null,"Data Added successfully");
         return;
       }catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
 }

void dispalyItem(Vector data,Vector columnName,int r){
        try {
            switch(r){
                case 1:
                rs = st.executeQuery("SELECT * FROM item");
                break;
                case 2:
                rs= st.executeQuery("SELECT inv_no,inv_date,total_cost,name FROM invoice,manager where invoice.mgr_id=manager.mgr_id");
                break;
                 case 3:
                rs= st.executeQuery("SELECT item_no,cdate,price,qty,name FROM consumption,manager where consumption.mgr_id=manager.mgr_id");
                break;
                 case 4:
                rs= st.executeQuery("SELECT name,cost FROM guest_meal");
                break;
                 case 5:
                rs= st.executeQuery("SELECT type,month,year,cost FROM other_expenses");
                break;
                 case 6:
                rs= st.executeQuery("SELECT * FROM student");
                break;
            }
            md=rs.getMetaData();
            int col=md.getColumnCount();
            for(int i=1;i<=col;i++){
                columnName.addElement(md.getColumnName(i));
            }
            while (rs.next()){
             Vector row=new Vector(col);
             for(int i=1;i<=col;i++){
                 row.addElement(rs.getObject(i));
             }
             data.addElement(row);
            }
            rs.close();
            st.close();
          } catch (SQLException ex) {
          System.out.println(ex);

        }

  }

void dropdownAddItem(JComboBox combo){
    //final JComboBox combo=new JComboBox();
        try {
            rs=st.executeQuery("SELECT name from item");

            while(rs.next()){
                String name=rs.getString("name");
                if(name.equals("")){
                   combo.addItem("");
                   combo.setVisible(false);
                }else{
                    combo.addItem(rs.getString("name"));
                    //System.out.println(rs.getString("name"));
                    combo.setVisible(true);
                }
            }
        } catch (SQLException ex) {
      }
}

void dropdownAddRoom(JComboBox combo){
    //final JComboBox combo=new JComboBox();
        try {
            rs=st.executeQuery("SELECT room_no from room");

            while(rs.next()){
                int room_no=rs.getInt("room_no");
                if(room_no==0){
                   combo.addItem("");
                   combo.setVisible(false);
                }else{
                    combo.addItem(rs.getInt("room_no"));
                    //System.out.println(rs.getString("name"));
                    combo.setVisible(true);
                }
            }
        } catch (SQLException ex) {
      }
}



public void putConsumption(String name,String date,int qty){
     try{
         int item_no=0;
         float temp=0;
         float price=0;
         int stock_qty=0;

          rs= st.executeQuery("SELECT mgr_id from temp");
              while(rs.next()){
             mgr=rs.getString("mgr_id");
              }
          rs = st.executeQuery("SELECT item_no FROM item WHERE name='"+name+"'");
         while(rs.next()){
          item_no=rs.getInt("item_no");
          }

          System.out.println(item_no);
           rs=st.executeQuery("SELECT tot_qty FROM stock WHERE item_no='"+item_no+"'");
          while(rs.next())
          {
           stock_qty=rs.getInt("tot_qty");
          }
          stock_qty=stock_qty-qty;
          if(stock_qty < 0)
          {
          JOptionPane.showMessageDialog(null,"Not enough stock to consume");
          return;
          }

          rs=st.executeQuery("SELECT unit_price FROM item WHERE item_no='"+item_no+"'");
           while(rs.next()){
          temp=rs.getFloat("unit_price");
           }
          price=qty*temp;
          System.out.println(price);
        rs1=st.executeUpdate("INSERT INTO consumption VALUES ('"+item_no+"','"+date+"','"+qty+"','"+price+"','"+mgr+"',1)");
         JOptionPane.showMessageDialog(null,"Data Added successfully");
         return;
       
         }
         catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
}



    void putPurchase(int bill_no, String name,int qty,float price) {
      try{
         int item_no=0;
          rs = st.executeQuery("SELECT item_no FROM item WHERE name='"+name+"'");
         while(rs.next()){
          item_no=rs.getInt("item_no");
          }
          System.out.println(item_no);

           rs1=st.executeUpdate("INSERT INTO invoice_item VALUES ('"+bill_no+"','"+item_no+"','"+qty+"','"+price+"')");
           JOptionPane.showMessageDialog(null,"Data Added successfully");
           }
         catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
    }
  }


    
    void putInvoice(float price, String date) {
        try {
            int bill=0;
             rs=st.executeQuery("SELECT COUNT(inv_no) FROM invoice");
             while(rs.next())
             {
               bill=rs.getInt(1);
             }
             bill++;
              rs= st.executeQuery("SELECT mgr_id from temp");
              while(rs.next()){
             mgr=rs.getString("mgr_id");
              }
             rs1 = st.executeUpdate("INSERT INTO invoice VALUES ('"+bill+"','"+date+"','"+price+"','"+mgr+"')");
             JOptionPane.showMessageDialog(null,"Data Added successfully.Bill number generated is "+bill);
             return;
             } catch (SQLException ex) {
                  System.out.println(ex);
                JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
     }



    void displaysearch(Vector data,Vector columnName,String usn,int r){
        try {
            if(r==1){
            rs = st.executeQuery("SELECT usn,name,year,no_of_days,balance,room.room_no,type,hostel FROM student,room WHERE (student.room_no=room.room_no and usn='"+usn+"')");
            }else{
             rs = st.executeQuery("SELECT usn,name,year,no_of_days,balance,room.room_no,type,hostel FROM student,room WHERE (student.room_no=room.room_no and name='"+usn+"')");

            }
            md=rs.getMetaData();
            int col=md.getColumnCount();
            for(int i=1;i<=col;i++){
                columnName.addElement(md.getColumnName(i));
            }
            while (rs.next()){
             Vector row=new Vector(col);
             for(int i=1;i<=col;i++){
                 row.addElement(rs.getObject(i));
             }
             data.addElement(row);
            }
            rs.close();
            st.close();
          } catch (SQLException ex) {
          System.out.println(ex);

        }
}

  public void evaluate(int nd,int nm,int ny)
    {
    try{
     rs=st.executeQuery("select total_amt from bill where bill_no=1");

     float r=0;
     if(rs.next())
     r=rs.getFloat("total_amt");

     rs=st.executeQuery("select count(usn) from student");

    int c=0;
    if(rs.next())
    c=rs.getInt(1);
    float cps=r/c/nd;
/*
    for(int ro=0;ro<s_no;ro++){
    rs1=st.executeUpdate("update student set balance=balance-"+cps+" where slno="+i+"");
     }
 * */int n=0;
 //nm=(nm++)%11;
 nm=(nm+1)%12;
 if(nm==0||nm==2||nm==4||nm==6||nm==7||nm==9||nm==11){n=31;}
 else if(nm==3||nm==5||nm==8||nm==10){n=30;}
 else
     if(ny%4==0){n=29;}
     else n=28;

    JOptionPane.showMessageDialog(null,"end of month balance deduction going on....."+"\n"+" please wait");
rs=st.executeQuery("select * from student");
rs1=st.executeUpdate("update student set balance=balance-(no_of_days*'"+cps+"')");
rs1=st.executeUpdate("update student set no_of_days='"+n+"'");
rs1=st.executeUpdate("update temp set nextd='"+n+"', nextm='"+nm+"'");
 Report conn=new Report();
 conn.Report();
rs1=st.executeUpdate("update bill set total_amt=0 where bill_no=1");
rs1=st.executeUpdate("delete from guest_meal");
rs1=st.executeUpdate("delete from other_expenses");
rs1=st.executeUpdate("delete from consumption");
rs1=st.executeUpdate("delete from invoice_item");
rs1=st.executeUpdate("delete from invoice");
JOptionPane.showMessageDialog(null,"Done successfully");
     ManagerInterface m=new ManagerInterface();
     m.ManagerInterface();
    }catch(SQLException ex){JOptionPane.showMessageDialog(null,"Error");
   }

 }


    void putManager(String name, String password) {
        try{int mgrid=0;
             rs=st.executeQuery("SELECT COUNT(mgr_id) FROM manager");
             if(rs.next())
             {
               mgrid=rs.getInt(1);
             }
             mgrid++;
             rs1=st.executeUpdate("INSERT INTO manager VALUES ('"+mgrid+"','"+name+"','"+password+"')");
           JOptionPane.showMessageDialog(null,"Data Added successfully.New Manager ID is "+mgrid);
            return;
    }catch(SQLException ex){JOptionPane.showMessageDialog(null,"Error");
   }

}



    public void addItem(String item){

try{
    rs1=st.executeUpdate("insert into item values (NULL,'"+item+"',0)");
   JOptionPane.showMessageDialog(null,item+" added");
            return;}
catch(Exception ex){
JOptionPane.showMessageDialog(null,"Wrong Entry or "+item+" present");}


    }

    void deleteStud(String usn) {
     try{
    rs1=st.executeUpdate("DELETE FROM student where usn='"+usn+"'");

   if(rs1==0){JOptionPane.showMessageDialog(null,"Wrong Entry");
    return;}
   JOptionPane.showMessageDialog(null,"Deleted successfully");
    return;
   }
    catch(Exception ex){JOptionPane.showMessageDialog(null,"Wrong Entry");}
}

void getOtherExpenses() {

    try{Workbook workbook = new HSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("Report");


         Cell cell[]= new Cell[100];
         cell[0] = sheet1.createRow(0).createCell(0);
        cell[0].setCellValue("Opening Stock");


        cell[1] = sheet1.createRow(1).createCell(0);
        cell[2] = sheet1.createRow(1).createCell(1);
        cell[1].setCellValue("Type");

        cell[2].setCellValue("Cost");





        int temp=2,r=2;
         rs = st.executeQuery("SELECT * FROM other_expenses");

         while(rs.next() ){
                String type=rs.getString("type");




         int cost=rs.getInt("cost");
         temp+=2;r++;
         cell[temp]= sheet1.createRow(r).createCell(0);
         cell[temp+1]= sheet1.createRow(r).createCell(1);
         cell[temp].setCellValue(type);
         cell[temp+1].setCellValue(cost);

         //cell[temp].setCellValue(ans);


        }
         //guest meals
       rs =st.executeQuery("SELECT * FROM guest_meal");
         while(rs.next() ){
                String name=rs.getString("name");



         int x=15;
         int cost=rs.getInt("cost");
         temp+=2;x++;
         cell[temp]= sheet1.createRow(x).createCell(0);
         cell[temp+1]= sheet1.createRow(x).createCell(1);
         cell[temp].setCellValue(name);
         cell[temp+1].setCellValue(cost);

         //cell[temp].setCellValue(ans);


        }
         //guest meals end

       //bill report
        rs =st.executeQuery("SELECT * FROM bill");
         while(rs.next() ){
               // String name=rs.getString("name");



         int x=20;
         int bill=rs.getInt("total_amt");
         temp+=2;x++;
         cell[temp]= sheet1.createRow(x).createCell(0);
         cell[temp+1]= sheet1.createRow(x).createCell(1);
         //cell[temp].setCellValue(name);
         cell[temp+1].setCellValue(bill);

         //cell[temp].setCellValue(ans);


        }

       //bill report ends

        try{

            FileOutputStream output = new FileOutputStream("Report.xls");

            workbook.write(output);
            JOptionPane.showMessageDialog(null,"Report Succesfully Report Generated");
            output.close();
            return;

        }catch(Exception e){
        }

         return;
       }catch(Exception ex){
         System.out.println(ex);
         JOptionPane.showMessageDialog(null,"Wrong Entry");
         }
 }



}

