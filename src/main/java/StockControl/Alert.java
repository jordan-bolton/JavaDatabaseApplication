package StockControl;

import GUI.AlertForm;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Alert extends Thread {
    boolean reminderSnoozed = false;
    
    public Alert() {
        
    }
    
    
    public ArrayList<Part> lowStockParts() {
        ArrayList<Part> lowStockPartList = new ArrayList<>();
        ArrayList<Part> allParts;
        Part partObj = new Part();
        
        allParts = partObj.getAllParts();
        
        
        for (Part part : allParts) {
            if (part.getQty() < part.getThreshold()) {
               lowStockPartList.add(part);
            }
        }
        
        // to determine whether to run the low stock alert form or not
        return lowStockPartList;
    }
    @Override
    public void run() {
        ArrayList<Part> lowStockParts = lowStockParts();
        
        while (true) {
            
            if (!reminderSnoozed) {
                lowStockParts = lowStockParts();
            }

            if (!lowStockParts.isEmpty()) {
                
                int reply = JOptionPane.showConfirmDialog(null,
                        "There are low stock parts.  Do you want to view them?",
                        "Low Stock Alert", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  AlertForm alertForm = new AlertForm(lowStockParts);
                  alertForm.setVisible(true);
                  reminderSnoozed = false;
            }
            else {
               JOptionPane.showMessageDialog(null, "Snoozed for 10 minutes");
               reminderSnoozed = true;
            }
            
            
            
            try {
                Thread.sleep(600000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
                
        
        
        }
    }
    }

    
    
}