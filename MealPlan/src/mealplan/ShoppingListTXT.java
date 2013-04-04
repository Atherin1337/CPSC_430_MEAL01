
/*
 * ShoppingListTXT.java
 *
 * Created on Mar 30, 2013, 12:08:09 PM
 */

package mealplan;

import java.io.*;
import java.awt.print.*;











/**
 *
 * @author Isaac Erickson
 */
public class ShoppingListTXT extends javax.swing.JFrame {

    private String thislist[][] = new String[200][10];
    /** Creates new form ShoppingListTXT */

    public ShoppingListTXT() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setmainText(String plan[][]){


        thislist = mealplan.Version.getOPENdata("Select * from ingredients where CRN = " + plan[0][0] +
                " or CRN = " + plan[1][0] +
                " or CRN = " + plan[2][0] +
                " or CRN = " + plan[3][0] +
                " or CRN = " + plan[4][0] +
                " or CRN = " + plan[5][0] +
                " or CRN = " + plan[6][0] +
                " order by Ingre_Type, Ingre_Name;");

        int x = 0;

        jTextArea1.setText(" \t\t === SHOPPING LIST === \n");


        jTextArea1.setText(jTextArea1.getText() +
                    "Sunday\n     " + plan[0][1] +
                    "\nMonday\n     " + plan[1][1] +
                    "\nTuesday\n     " + plan[2][1] +
                    "\nWednsday\n     " + plan[3][1] +
                    "\nThursday\n     " + plan[4][1] +
                    "\nFriday\n      " + plan[5][1] +
                    "\nSaturday\n      " + plan[6][1] + "\n\n\n");












        while(thislist[x][0] != null){
            
            for(int y = 1; y < 3; y++){
                jTextArea1.setText(jTextArea1.getText() + thislist[x][y] + ", \t");
                if(y == 1 && thislist[x][y].length() < 14)jTextArea1.setText(jTextArea1.getText() + "\t");
            }
            if(thislist[x][2].length() < 14)jTextArea1.setText(jTextArea1.getText() + "\t");

            jTextArea1.setText(jTextArea1.getText() + thislist[x][3] + " - " + thislist[x][4] + " \n");
            x++;
        }





    }















    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meal Planner!");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("GO BACK");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Help");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        this.setVisible(false);
        MealPlan.mealplan.setVisible(true);




    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed


        
        String printData = jTextArea1.getText();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new OutputPrinter(printData));
        boolean doPrint = job.printDialog();
        if (doPrint){
        try{
            job.print();
        }
        catch (PrinterException e){
            // Print job did not complete.
        }

         


    }
         












    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
    * @param args the command line arguments
    */

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingListTXT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}