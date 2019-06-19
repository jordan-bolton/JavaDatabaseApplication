package StockControl;

import Account.*;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Part {

    private int partId;
    private String name;
    private String manufacturer;
    private float price;
    private String vehicleType;
    private int year;
    private int qty;
    private Supplier supplier;
    private int threshold;
    private int supplierId;
    private int partUsedId;

    /**
     *
     * @param partID
     * @param name
     * @param manu
     * @param desc
     * @param sup
     */
    public Part(String name, String manu, Supplier sup, String vehicleType, float price, int year, int qty, int threshold) {
        this.name = name;
        this.manufacturer = manu;
        this.supplier = sup;
        this.vehicleType = vehicleType;
        this.price = price;
        this.year = year;
        this.qty = qty;
        this.threshold = threshold;
    }

    public Part() {
    }

    public Part(int partId, String name, String manufacturer, String description, float price, int qty, int supplierId) {
        this.partId = partId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.qty = qty;
        this.supplierId = supplierId;
    }

    public Part(String name, String manufacturer, String vehicleType, int year, float price, int qty, int threshold) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.year = year;
        this.price = price;
        this.qty = qty;
        this.threshold = threshold;
    }

    public int getPartId() {
        return this.partId;
    }

    /**
     *
     * @param num
     */
    public void setPartId(int partId) {
        this.partId = partId;
    }

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

    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     *
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getPrice() {
        return this.price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     *
     * @param supplierId
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Part{" + "partId=" + partId + ", name=" + name + ", manufacturer=" + manufacturer + ", price=" + price + ", vehicleType=" + vehicleType + ", year=" + year + ", qty=" + qty + ", supplier=" + supplier.getName() + ", threshold=" + threshold + '}';
    }

    public boolean addPart() throws SQLException {
        DBConnectivity db = new DBConnect();
        Connection conn = db.connect();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO Parts(part_name, part_manufacturer, part_supplier_id, vehicle_type, year, part_quantity, part_price, part_threshold) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, this.name);
            p.setString(2, this.manufacturer);
            p.setInt(3, this.supplier.getSupplierID());
            p.setString(4, this.vehicleType);
            p.setInt(5, this.year);
            p.setInt(6, this.qty);
            p.setFloat(7, this.price);
            p.setInt(8, this.threshold);
            p.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            conn.rollback();
            return false;
        } finally {
            db.closeConnection();
        }

    }

    public ArrayList<Part> getAllParts() {
        DBConnectivity db = new DBConnect();
        ArrayList<Part> allParts = new ArrayList<>();
        Connection conn = db.connect();
        try {
            conn.setAutoCommit(false);
            String sql = "SELECT * FROM Parts";
            PreparedStatement partQuery = conn.prepareStatement(sql);
            ResultSet rs = partQuery.executeQuery();

            conn.commit();
            while (rs.next()) {
                Part partToAdd = new Part(rs.getString("part_name"), rs.getString("part_manufacturer"), new Supplier(rs.getInt("part_supplier_id")), rs.getString("vehicle_type"), rs.getFloat("part_price"), rs.getInt("year"), rs.getInt("part_quantity"), rs.getInt("part_threshold"));
                partToAdd.setPartId(rs.getInt("part_id"));
                allParts.add(partToAdd);

            }

            conn.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }

        } finally {

            db.closeConnection();
        }

        return allParts;
    }

    // returns the updated part
    public void updatePart(String columnName, Object updatedField) {
        DBConnectivity db = new DBConnect();
        Connection conn = db.connect();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE Parts SET " + columnName + " = ? WHERE part_id = " + this.getPartId();
            PreparedStatement p = conn.prepareStatement(sql);
            if (updatedField instanceof String) {
                p.setString(1, (String) updatedField);
            } else if (updatedField instanceof Float) {
                p.setFloat(1, (Float) updatedField);
            } else {
                p.setInt(1, (Integer) updatedField);
            }

            p.executeUpdate();
            conn.commit();
            //System.out.println("Part " + this.name + " updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        } finally {
            db.closeConnection();
        }
    }

    public void updateSupplier(String supplierName) {
        DBConnectivity db = new DBConnect();
        Connection conn = db.connect();
        ArrayList<Supplier> allSuppliers = new ArrayList<>();
        try {
            allSuppliers = supplier.getAllSuppliers();
            conn.setAutoCommit(false);
            String sql = "UPDATE Parts SET part_supplier_id = ? WHERE part_id = " + this.getPartId();
            PreparedStatement p = conn.prepareStatement(sql);
            for (Supplier supplier : allSuppliers) {
                if (supplier.getName().equals(supplierName)) {
                    this.setSupplier(supplier);
                }
            }

            p.setInt(1, this.getSupplier().getSupplierID());
            p.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param name
     * @param qty
     * @param role
     */
    public Staff generateAlert(String name, int qty, String role) {
        return null;
    }

    public int getPartUsedId() {
        return partUsedId;
    }

    public void setPartUsedId(int partUsedId) {
        this.partUsedId = partUsedId;
    }

}
