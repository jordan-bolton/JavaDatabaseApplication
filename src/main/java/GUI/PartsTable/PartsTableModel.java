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
public class PartsTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Part ID", "Part Name", "Part Manufacturer", "Part Supplier", "Vehicle Type"
    , "Year", "Quantity", "Price", "Threshold"};
    private ArrayList<Part> parts;
    
    public PartsTableModel(Part part) {
        part = new Part();
        parts = part.getAllParts();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
    
    
    
    public int getRowCount() {
        int size;
        if (parts == null) {
            size = 0;
        }
        else {
            size = parts.size();
        }
        return size;
    }
    
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = parts.get(row).getPartId();
        }
        else if (col == 1) {
            temp = parts.get(row).getName();
        }
        else if (col == 2) {
            temp = parts.get(row).getManufacturer();
        }
        else if (col == 3) {
            temp = parts.get(row).getSupplier().getName();
        }
        else if (col == 4) {
            temp = parts.get(row).getVehicleType();
        }
        else if (col == 5) {
            temp = parts.get(row).getYear();
        }
        else if (col == 6) {
            temp = parts.get(row).getQty();
        }
        else if (col == 7) {
            temp = parts.get(row).getPrice();
        }
        else if (col == 8) {
            temp = parts.get(row).getThreshold();
        }
        return temp;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int col) {
        if (col == 0 || col == 5 || col == 6 || col == 8) {
            return Integer.class;
        }
        else if (col == 7) {
            return Float.class;
        }
        else {
            return String.class;
        }
    }

}
