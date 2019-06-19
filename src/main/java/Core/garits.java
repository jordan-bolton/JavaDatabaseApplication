/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.*;
import DatabaseConnect.DBConnect;
import java.sql.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author jly09
 */
public class garits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        new Control();
    }

}
