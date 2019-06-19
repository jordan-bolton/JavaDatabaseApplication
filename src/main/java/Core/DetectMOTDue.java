/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Account.Customer;
import Account.Vehicle;
import DatabaseConnect.DBConnect;
import GUI.MotRemindersForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author paul
 */
public class DetectMOTDue extends Thread {
    DBConnect dbConnect;
    ArrayList<Customer> motReminders = new ArrayList<Customer>();
    boolean reminderSnoozed = false;
    String motDate;
    Control control;

    public DetectMOTDue(Control c) {
        control = c;
        dbConnect = control.getDatabaseConnector();
    }
    
    public DetectMOTDue() {
        dbConnect = new DBConnect();
    }
    
    
    public void run(){

        // TODO check if user is franchisee
        while(true){
            
            if(!reminderSnoozed) {
                //Adding 5 working days to date
                Date date=new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                date=calendar.getTime();
                int days = 5;
                for(int i=0;i<days;)
                {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    //here even sat and sun are added
                    //but at the end it goes to the correct week day.
                    //because i is only increased if it is week day
                    if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
                    {
                        i++;
                    }

                }            
                date=calendar.getTime();
                motDate = dateFormat.format(date);
                
                
                String motDueQuery = "SELECT * FROM garitsdb.vehicle, "
                        + "garitsdb.customer WHERE garitsdb.customer.customer_account_holder = '1' \n" +
                        "AND garitsdb.vehicle.customer_id =  garitsdb.customer.customer_id\n" +
                        "AND garitsdb.vehicle.purchase_date LIKE '____-%"+motDate.substring(5) + "';";
                ResultSet rs; 
                try {
                    Connection conn = dbConnect.connect();
                    conn.setAutoCommit(false);
                    PreparedStatement statement = conn.prepareStatement(motDueQuery);
                    rs = statement.executeQuery();
                    while(rs.next()) {
                        System.out.println(motDate.substring(5));
                        Customer customer = new Customer();
                        Vehicle vehicle = new Vehicle();
                        List<Vehicle> vehicles = new ArrayList<Vehicle>();
                        vehicle.setReg_num(rs.getString("reg_no"));
                        
                        customer.setName(rs.getString("customer_name"));
                        customer.setAddress(rs.getString("customer_address"));
                        customer.setPostcode(rs.getString("customer_postcode"));
                        vehicles.add(vehicle);
                        customer.setVehicles(vehicles);
                        motReminders.add(customer);
                        
                    }
                    conn.commit();
                    conn.setAutoCommit(true);

                }
                catch (Exception exc) {
                    exc.printStackTrace();
                }

            }
            
            
            //do check for new date here
            if(!motReminders.isEmpty()){
                int reply = JOptionPane.showConfirmDialog(null,
                        "Do you want to MOT reminders?",
                        "MOT reminder", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  MotRemindersForm reminders = new MotRemindersForm(
                          motReminders, motDate,control);
                  reminders.setVisible(true);
                  motReminders.clear();
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
