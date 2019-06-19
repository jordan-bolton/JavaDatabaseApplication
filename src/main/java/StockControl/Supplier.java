package StockControl;

import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Supplier {

	private String name;
	private String address;
	private int phone;
	private String email;
        private int supplierID;
	/**
	 * 
	 * @param n
	 * @param addr
	 * @param phone
	 * @param email
	 */
	public Supplier(String name, String address, int phone, String email) {
		this.name = name;
                this.address = address;
                this.phone = phone;
                this.email = email;
	}
        
        public Supplier() {}
        
        // constructs a supplier from an id
        public Supplier(int id) {
            this.supplierID = id;
            Connection conn = db.connect();
            
            try {
                conn.setAutoCommit(false);
                String sql = "SELECT supplier_name, supplier_address, supplier_tel, supplier_email FROM Supplier WHERE part_supplier_id = ?";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setInt(1, this.supplierID);
                ResultSet rs = p.executeQuery();
                conn.commit();
                if (rs.next()) {
                    //Supplier newSupplier = new Supplier(rs.getString("supplier_name"), rs.getString("supplier_address"), rs.getInt("supplier_tel"), rs.getString("supplier_email"));
                    this.name = rs.getString("supplier_name");
                    this.address = rs.getString("supplier_address");
                    this.phone = rs.getInt("supplier_tel");
                    this.email = rs.getString("supplier_email");
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    conn.rollback();
                }
               catch (SQLException e2) {
                   System.out.println(e2.getMessage());
               }
                       
               
            }
            finally {
                db.closeConnection();
            }
        }


        DBConnectivity db = new DBConnect();
        
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

        
        // boolean to indicate whether adding supplier to db was successful
        public boolean addSupplierToDB() throws SQLException {
            Connection conn = db.connect();
            try {
                // use of transactions
                conn.setAutoCommit(false);
                String sql = "INSERT INTO Supplier(supplier_name, supplier_address, supplier_tel, supplier_email) VALUES (?, ?, ?, ?)";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, this.name);
                p.setString(2, this.address);
                p.setInt(3, this.phone);
                p.setString(4, this.email);
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                return true;
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                // if an error occurs, roll back the changes made to the db
                conn.rollback();
                return false;
            }
            finally {
                db.closeConnection();
            }
            
            
        }
        
        public int getSupplierID() throws SQLException {
            Connection conn = db.connect();
            try {
                // use of transactions
                conn.setAutoCommit(false);
                String sql = "SELECT part_supplier_id FROM Supplier WHERE supplier_name = ?";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, this.name);
                ResultSet rs = p.executeQuery();
                conn.commit();
                conn.setAutoCommit(true);
                
                if (rs.next()) {
                    this.supplierID = rs.getInt("part_supplier_id");
                }
                
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                // if an error occurs, roll back the changes made to the db
                conn.rollback();
            }
            finally {
                db.closeConnection();
            }
            return this.supplierID;
        }
        
        public ArrayList<Supplier> getAllSuppliers() {
            ArrayList<Supplier> supplierList = new ArrayList<>();
            Connection conn = db.connect();
            try {
                conn.setAutoCommit(false);
                String sql = "SELECT * FROM Supplier";
                PreparedStatement p = conn.prepareStatement(sql);
                ResultSet rs = p.executeQuery();
                conn.commit();
                conn.setAutoCommit(true);
                while (rs.next()) {
                    Supplier supplier = new Supplier(rs.getString("supplier_name"), rs.getString("supplier_address"), rs.getInt("supplier_tel"), rs.getString("supplier_email"));
                    supplierList.add(supplier);
                }
                
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    conn.rollback();
                }
                catch (SQLException e2) {
                    System.out.println(e2.getMessage());
                }
                
            }
            finally {
                db.closeConnection();
            }
            return supplierList;
        }
        
        
        // not used for now
        /*
        // constructor for creating a supplier just from the ID
        public Supplier createSupplierFromID(int id) {
            this.supplierID = id;
            Connection conn = db.connect();
            
            try {
                conn.setAutoCommit(false);
                String sql = "SELECT supplier_name, supplier_address, supplier_tel, supplier_email FROM Supplier WHERE part_supplier_id = ?";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setInt(1, this.supplierID);
                ResultSet rs = p.executeQuery();
                conn.commit();
                if (rs.next()) {
                    Supplier newSupplier = new Supplier(rs.getString("supplier_name"), rs.getString("supplier_address"), rs.getInt("supplier_tel"), rs.getString("supplier_email"));
                    return newSupplier;
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    conn.rollback();
                }
               catch (SQLException e2) {
                   System.out.println(e2.getMessage());
               }
                       
               
            }
            finally {
                db.closeConnection();
            }
            return null;
        }
        */
        
}