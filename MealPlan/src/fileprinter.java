/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mealplan;




import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.text.*;
import java.io.*;


/**
* The PrintText application expands on the
* PrintExample application in that it images
* text on to the single page printed.
*/
public class fileprinter implements Printable{
/**
* The text to be printed.
*/
public static String mText = "";
private static  AttributedString mStyledText = new AttributedString(mText);


/**
* Print a single page containing some sample text.
*/
static public void main(String args[]) {

        mText = args[0];
        mStyledText = new AttributedString("test411.txt");


            try {
                //FileWriter outFile = new FileWriter(args[0]);
                PrintWriter out = new PrintWriter("test411.txt");

                out.println(args[0]);

                out.close();
          } catch (IOException e){
              e.printStackTrace();
          }
















/* Get the representation of the current printer and
* the current print job.
*/
        PrinterJob printerJob = PrinterJob.getPrinterJob();
/* Build a book containing pairs of page painters (Printables)
* and PageFormats. This example has a single page containing
* text.
*/
        Book book = new Book();
        book.append(new fileprinter(), new PageFormat());
/* Set the object to be printed (the Book) into the PrinterJob.
* Doing this before bringing up the print dialog allows the
* print dialog to correctly display the page range to be printed
* and to dissallow any print settings not appropriate for the
* pages to be printed.
*/
        printerJob.setPageable(book);
/* Show the print dialog to the user. This is an optional step
* and need not be done if the application wants to perform
* 'quiet' printing. If the user cancels the print dialog then false
* is returned. If true is returned we go ahead and print.
*/
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException exception) {
        System.err.println("Printing error: " + exception);
        }
    }
}










/**
* Print a page of text.
*/




public int print(Graphics g, PageFormat format, int pageIndex) {
/* We'll assume that Jav2D is available.
*/
    Graphics2D g2d = (Graphics2D) g;
/* Move the origin from the corner of the Paper to the corner
* of the imageable area.
*/
    g2d.translate(format.getImageableX(), format.getImageableY());
/* Set the text color.
*/
    g2d.setPaint(Color.black);
/* Use a LineBreakMeasurer instance to break our text into
* lines that fit the imageable area of the page.
*/
    Point2D.Float pen = new Point2D.Float();
    AttributedCharacterIterator charIterator = mStyledText.getIterator();

    LineBreakMeasurer measurer = new LineBreakMeasurer(charIterator, g2d.getFontRenderContext());

    float wrappingWidth = (float) format.getImageableWidth();

    while (measurer.getPosition() < charIterator.getEndIndex()) {

        System.out.println(mText.substring(measurer.getPosition(), measurer.getPosition()+2));



        //if((measurer.getPosition() + 3) < charIterator.getEndIndex() && mText.substring(measurer.getPosition(), measurer.getPosition()+2).equals("\n")){
        //     pen.y++;
        //}

        TextLayout layout = measurer.nextLayout(wrappingWidth);

        pen.y += layout.getAscent();

        float dx = layout.isLeftToRight()? 0 : (wrappingWidth - layout.getAdvance());

        layout.draw(g2d, pen.x + dx, pen.y);

        pen.y += layout.getDescent() + layout.getLeading();
    }
    return Printable.PAGE_EXISTS;
}




protected static final char[] DELIM_LINE =
    System.getProperty("line.separator").toCharArray();



}


























