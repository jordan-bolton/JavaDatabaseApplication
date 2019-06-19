/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Account.Administrator;
import Account.Foreperson;
import Account.Franchisee;
import Account.Mechanic;
import Account.Staff;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author jorda
 */
public class Login {
    // objects for all methods to use
    Hashing hash = new Hashing(10);
    DBConnectivity db = new DBConnect();
    
    public boolean validateLogin(String user_name, String password) throws SQLException {
        
        try {
            // check username exists
            Connection conn = db.connect();
            String sql = "SELECT COUNT(user_name) AS counter FROM User WHERE user_name = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                if (rs.getInt("counter") == 0) {
                    System.out.println("Invalid login username");
                    return false;
                }
            }
            
            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Connection conn = db.connect();
            String sql = "SELECT password FROM User WHERE user_name = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                String hashedPass = rs.getString("password");
                if (hash.verifyPassword(password, hashedPass)) {
                    System.out.println("Password matches");                                                           
                    return true;
                    
                }
                else {
                    System.out.println("Incorrect password");
                    return false;
                }
                
            }
            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
               
        return false;
        
        
        
    }
    
    public Staff createStaffObject(String user_name) throws SQLException {
        try {
            Staff staff = null;
            Connection conn = db.connect();
            String sql = "SELECT * FROM User WHERE user_name = ?";
            
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                String db_user_name = rs.getString("user_name"); // login username
                String password = rs.getString("password");
                String user_role = rs.getString("user_role");
                String name = rs.getString("username");
                
                // default pay is 0
            
                if (user_role.equals("Receptionist")) {
                    staff = new Staff(db_user_name, password, user_role, name);
                }
                else if (user_role.equals("Mechanic")) {
                    staff = new Mechanic(db_user_name, password, user_role, name, 105);
                }
                else if (user_role.equals("Foreperson")) {
                    staff = new Foreperson(db_user_name, password, user_role, name, 125);
                }
                else if (user_role.equals("Franchisee")) {
                    staff = new Franchisee(db_user_name, password, user_role, name);
                }
                else if (user_role.equals("Administrator")) {
                    staff = new Administrator(db_user_name, password, user_role, name);
                }
                
            }
            return staff;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // if null is returned, an error has occured
        return null;
    }
    
    public void addUser(String username, String password, String role, String name) throws SQLException {        
        // staff default is receptionist
        Staff userToAdd = new Staff(username, hash.hashPassword(password), role, name);
        //echanic mechanicToAdd = new Mechanic(username, hash.hashPassword(password), role, name, 0);
        Mechanic mechanicToAdd;
        
        // 0 is default user pay
        if (role.equals("Mechanic")) {
            mechanicToAdd = new Mechanic(username, hash.hashPassword(password), role, name, 105);
            
            try {
                Connection conn = db.connect();
                
                // transactions
                conn.setAutoCommit(false);
            // if a mechanic or foreperson, also add their pay to the database
            //if (mechanicToAdd.getRole().equals("Mechanic") || mechanicToAdd.getRole().equals("Foreperson")) {
                String sql = "INSERT INTO User(username, password, user_role, user_pay, user_name) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p =conn.prepareStatement(sql);
                p.setString(1, mechanicToAdd.getName()); // user_name
                p.setString(2, mechanicToAdd.getPassword());
                p.setString(3, mechanicToAdd.getRole());
                p.setFloat(4, mechanicToAdd.getHourly_rate());
                p.setString(5, mechanicToAdd.getUsername()); // username
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                System.out.println("Added " + mechanicToAdd.getName() + " to the database");
                System.out.println("Added user of type class " + mechanicToAdd.getClass() + " to the database");
            //}

            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
        else if (role.equals("Foreperson")) {
            mechanicToAdd = new Foreperson(username, hash.hashPassword(password), role, name, 125);
            
            try {
                Connection conn = db.connect();
                conn.setAutoCommit(false);
            // if a mechanic or foreperson, also add their pay to the database
            //if (mechanicToAdd.getRole().equals("Mechanic") || mechanicToAdd.getRole().equals("Foreperson")) {
                String sql = "INSERT INTO User(username, password, user_role, user_pay, user_name) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p =conn.prepareStatement(sql);
                p.setString(1, mechanicToAdd.getName()); // user_name
                p.setString(2, mechanicToAdd.getPassword());
                p.setString(3, mechanicToAdd.getRole());
                p.setFloat(4, mechanicToAdd.getHourly_rate());
                p.setString(5, mechanicToAdd.getUsername()); // username
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                System.out.println("Added " + mechanicToAdd.getName() + " to the database");
                System.out.println("Added user of type class " + mechanicToAdd.getClass() + " to the database");
            //}

            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
  
        }
        else if (role.equals(("Franchisee"))) {
            userToAdd = new Franchisee(username, hash.hashPassword(password), role, name);
        }
        else if (role.equals("Administrator")) {
            userToAdd = new Administrator(username, hash.hashPassword(password), role, name);
        }
        
        
        // add the user to the database
        // name is now the login username, and username is the uers' full name
        // (forename and surname)
        // had to swap round for other code
        if (userToAdd.getRole().equals("Franchisee") || userToAdd.getRole().equals("Administrator") || userToAdd.getRole().equals("Receptionist")) {
            try {
                Connection conn = db.connect();
                conn.setAutoCommit(false);
                String sql = "INSERT INTO User(username, password, user_role, user_name) VALUES (?, ?, ?, ?)";
                PreparedStatement p =conn.prepareStatement(sql);
                p.setString(1, userToAdd.getName()); // user_name
                p.setString(2, userToAdd.getPassword());
                p.setString(3, userToAdd.getRole());
                p.setString(4, userToAdd.getUsername()); // username
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                System.out.println("Added " + userToAdd.getName() + " to the database");
                System.out.println("Added user of type class " + userToAdd.getClass() + " to the database");
                db.closeConnection();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
