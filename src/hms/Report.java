
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hms;






import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
public class Report {

    public void Report(){
        Reportgen();
        return;
    }
    public void Reportgen(){
        dbconnect con1=new dbconnect();
        con1.getOtherExpenses();
        return;
    }

}
