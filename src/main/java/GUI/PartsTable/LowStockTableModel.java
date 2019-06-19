/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.PartsTable;

import StockControl.Part;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jorda
 */
public class LowStockTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Part Name", "Quantity", "Threshold"};
    private ArrayList<Part> lowStockParts;
    
    public LowStockTableModel() {

    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public ArrayList<Part> getLowStock() {
        return lowStockParts;
    }
    
    public void setLowStock(ArrayList<Part> lowStockParts) {
        this.lowStockParts = lowStockParts;
    }
    
    public int getRowCount() {
        int size;
        if (lowStockParts == null) {
            size = 0;
        }
        else {
            size = lowStockParts.size();
        }
        return size;
    }
    
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = lowStockParts.get(row).getName();
        }
        else if (col == 1) {
            temp = lowStockParts.get(row).getQty();
        }
        else if (col == 2) {
            temp = lowStockParts.get(row).getThreshold();
        }
        return temp;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int col) {
        if (col == 0) {
            return String.class;
        }
        else {
            return Integer.class;
        }
    }
    
}
