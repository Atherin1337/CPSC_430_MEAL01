/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mealplan;
    import java.io.*;
    import java.awt.*;
    import java.awt.print.*;





/**
 *
 * @author Isaac Erickson
 */

public class OutputPrinter implements Printable {

    private String printData;

    public OutputPrinter(String printDataIn){
        this.printData = printDataIn;
    }

@Override
public int print(Graphics g, PageFormat pf, int page) throws PrinterException
{
    // Should only have one page, and page # is zero-based.
    if (page > 0){
        return NO_SUCH_PAGE;
    }

    // Adding the "Imageable" to the x and y puts the margins on the page.
    // To make it safe for printing.
    Graphics2D g2d = (Graphics2D)g;
    int x = (int) pf.getImageableX();
    int y = (int) pf.getImageableY();
    g2d.translate(x, y);

    // Calculate the line height
    Font font = new Font("Serif", Font.PLAIN, 12);
    FontMetrics metrics = g.getFontMetrics(font);
    int lineHeight = metrics.getHeight();

    BufferedReader br = new BufferedReader(new StringReader(printData));

    // Draw the page:
    try{
        String line;

       


        // Just a safety net in case no margin was added.
        x += 50;
        y += 50;
        while ((line = br.readLine()) != null){
            y += lineHeight;
            g2d.drawString(line, x, y);
        }
    }
    catch (IOException e)
    {
        //
    }

    return PAGE_EXISTS;
}
}

