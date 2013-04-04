/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mealplan;

/**
 *
 * @author Isaac Erickson
 */

    import java.io.*;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;





    public class fileprinting {
     public static void main(String[] args) {


                   try {
                //FileWriter outFile = new FileWriter(args[0]);
                PrintWriter out = new PrintWriter("test411.txt");

                out.println(args[0]);

                out.close();
          } catch (IOException e){
              e.printStackTrace();
          }












DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

/* locate a print service that can handle it */

PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);

/* create a print job for the chosen service */

int printnbr = 0;
DocPrintJob pj = pservices[printnbr].createPrintJob();

try {
FileInputStream fis = new FileInputStream("test411.txt");
Doc doc = new SimpleDoc(fis, flavor, null);
//PrintJobWatcher pjDone = new PrintJobWatcher(pj);

/* print the doc as specified */
pj.print(doc, aset);

}
catch (Exception ex){

ex.printStackTrace();
}
}
}







