/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DatabaseConnect.DBConnect;
import GUI.RemindersForm;
import Processing.Invoice;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author paul
 */
public class DetectLatePayment extends Thread {
    DBConnect dbConnect;
    Control control;
    ArrayList<Invoice> unpaidInvoices = new ArrayList<Invoice>();
    boolean reminderSnoozed = false;

    public DetectLatePayment() {
        dbConnect = new DBConnect();
    }
    
    public DetectLatePayment(Control c) {
        control = c;
        dbConnect = control.getDatabaseConnector();
    }
    
    
    public void run(){

        // TODO check if user is franchisee
        while(true){
            
            if(!reminderSnoozed) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date date = new java.util.Date();
                String currDate = dateFormat.format(date);
                String latePaymentsQuery = "SELECT * FROM garitsdb.Invoice WHERE"
                        + " invoice_paid = '0' AND payment_due_date <= '" 
                        + currDate + "';";
                ResultSet rs; 
                try {
                    rs = dbConnect.read(latePaymentsQuery);

                    while(rs.next()) {
                        Invoice invoice = new Invoice();
                        invoice.setInvoiceId((rs.getInt("invoice_id")));
                        invoice.setJobId(rs.getInt("job_id"));
                        invoice.setJobEnd(rs.getString("invoice_date"));
                        invoice.setPaymentDueDate(rs.getString("payment_due_date"));
                        invoice.setAmountDue(rs.getFloat("invoice_total"));
                        invoice.setReminderSent(rs.getInt("invoice_reminder")+1);
                        unpaidInvoices.add(invoice);
                    }

                }
                catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            
            //do check for user role here
            if(!unpaidInvoices.isEmpty()){
                int reply = JOptionPane.showConfirmDialog(null,
                        "Do you want to view unpaid jobs?",
                        "Unpaid Jobs reminder", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  RemindersForm reminders = new RemindersForm(control, 
                          unpaidInvoices);
                  reminders.setVisible(true);
                  unpaidInvoices.clear();
                  reminderSnoozed = false;
                }
                else {
                   JOptionPane.showMessageDialog(null, "Snoozed for 15 minutes");
                   reminderSnoozed = true;
                }
            }

            // sleep pauses thread execution for 15 minutes below

            try {
                    Thread.sleep(900000);//900000
            }
            catch(InterruptedException e)
            {}
        }

    }
}
