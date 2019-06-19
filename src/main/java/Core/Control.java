package Core;

import Account.*;
import Processing.*;
import StockControl.*;
import GUI.*;

import DatabaseConnect.DBConnect;
import Report.GenerateStock;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Control {

    //Temporary staff for quick referencing
    Staff staff = null;

    //Database Connection
    DBConnect dbConnect;

    //GUI Forms
    LoginForm loginForm;

    AdminMenuForm adminMenuForm;
    ForepersonMenuForm fpMenuForm;
    FranchiseeMenuForm franchiseeMenuForm;
    MechanicMenuForm mechanicMenuForm;
    ReceptionistMenuForm receptionMenuForm;

    List<JFrame> windowList;

    Thread getTime;
    Thread getMot;

    public Control() {
        dbConnect = new DBConnect();

        windowList = new ArrayList<>();

        loginForm = new LoginForm(this);
        loginForm.setVisible(true);

        if (checkEndOfMonth()) {
            if (AutomaticReportGenerated()) {

            }
        }

    }

    /**
     *
     * @param id
     * @param pass
     */
    //Checks the text in both the username and password textbozes in the LoginForm to the existing users in the database
    public boolean checkLogin(String n) {
        // TODO - implement Control.checkLogin
        throw new UnsupportedOperationException();
    }

    public void checkLogin() {

    }

    //Checks the role of the current person logged in and returns the value
    public String CheckRole() {
        if (staff != null) {
            return staff.getRole();
        }

        return null;
    }

    /**
     *
     * @param cust
     * @param vList
     * @param accholder
     */
    public void AddCustomer(Customer cust, List<Vehicle> vList) {
        String sql = "INSERT INTO Customer (customer_name,customer_address,customer_postcode,customer_tel,customer_email,customer_contact,customer_account_holder) "
                + "VALUES (?,?,?,?,?,?,?)";

        ResultSet rs = null;
        int id = -1;

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), sql);

            ps.setString(1, cust.getName());
            ps.setString(2, cust.getAddress());
            ps.setString(3, cust.getPostcode());
            ps.setString(4, cust.getPhone());
            ps.setString(5, cust.getEmail());
            ps.setString(6, cust.getCustomerContact());
            ps.setInt(7, 0);

            dbConnect.executeWriteQuery(ps);
            ps.close();

            if (vList != null) {

                PreparedStatement ps1 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM customer WHERE customer_name=?");
                ps1.setString(1, cust.getName());

                rs = dbConnect.executeReadQuery(ps1);
                if (rs != null) {
                    while (rs.next()) {
                        id = rs.getInt("customer_id");
                    }

                    ps1.close();

                    for (int i = 0; i < vList.size(); i++) {
                        PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO vehicle (reg_no,car_make,car_model,engine_serial,chassis_no,colour,purchase_date,customer_id) VALUES "
                                + "(?,?,?,?,?,?,?,?)");

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date purchase_date = dateFormat.parse(vList.get(i).getPurchase_date());
                        java.sql.Date sqlDate = new java.sql.Date(purchase_date.getTime());

                        ps2.setString(1, vList.get(i).getReg_num());
                        ps2.setString(2, vList.get(i).getMake());
                        ps2.setString(3, vList.get(i).getModel());
                        ps2.setString(4, vList.get(i).getEngine_serial_no());
                        ps2.setString(5, vList.get(i).getChassis_no());
                        ps2.setString(6, vList.get(i).getColour());
                        ps2.setDate(7, sqlDate);
                        ps2.setInt(8, id);

                        dbConnect.executeWriteQuery(ps2);
                        ps2.close();
                    }

                } else {
                    //error message
                }
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void AddCustomer(AccountHolder cust, List<Vehicle> vList) {
        String sql = "INSERT INTO Customer (customer_name,customer_address,customer_postcode,customer_tel,customer_email,customer_contact,customer_account_holder) "
                + "VALUES (?,?,?,?,?,?,?)";

        ResultSet rs;
        int id = -1;
        int rowid = -1;
        int discountID = -1;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        try {
            PreparedStatement ps = dbConnect.setIDPreparedStatement(dbConnect.connect(), sql);
            ps.setString(1, cust.getName());
            ps.setString(2, cust.getAddress());
            ps.setString(3, cust.getPostcode());
            ps.setString(4, cust.getPhone());
            ps.setString(5, cust.getEmail());
            ps.setString(6, cust.getCustomerContact());
            ps.setInt(7, 1);

            ResultSet rid = dbConnect.executeGetIDQuery(ps);
            if (rid.next()) {
                id = rid.getInt(1);
            }

            ps.close();

            if (vList != null) {

                for (int i = 0; i < vList.size(); i++) {
                    PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO vehicle (reg_no,car_make,car_model,engine_serial,chassis_no,colour,purchase_date,customer_id) VALUES "
                            + "(?,?,?,?,?,?,?,?)");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date purchase_date = dateFormat.parse(vList.get(i).getPurchase_date());
                    java.sql.Date sqlDate = new java.sql.Date(purchase_date.getTime());

                    ps2.setString(1, vList.get(i).getReg_num());
                    ps2.setString(2, vList.get(i).getMake());
                    ps2.setString(3, vList.get(i).getModel());
                    ps2.setString(4, vList.get(i).getEngine_serial_no());
                    ps2.setString(5, vList.get(i).getChassis_no());
                    ps2.setString(6, vList.get(i).getColour());
                    ps2.setDate(7, sqlDate);
                    ps2.setInt(8, id);

                    dbConnect.executeWriteQuery(ps2);
                    ps2.close();
                }

            }

            PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO account_holder (discount_plan,customer_id,pay_later) VALUES (?,?,?)");
            PreparedStatement ps4 = dbConnect.setIDPreparedStatement(dbConnect.connect(), "INSERT INTO discount (discount_type,customer_id) VALUES (?,?)");

            if (cust.getDiscount_plan() instanceof FixedDiscount) {
                FixedDiscount fd = (FixedDiscount) cust.getDiscount_plan();

                ps3.setString(1, "Fixed Discount");
                ps3.setInt(2, id);
                if (cust.getPay_later()) {
                    ps3.setInt(3, 1);
                } else {
                    ps3.setInt(3, 0);
                }

                dbConnect.executeWriteQuery(ps3);
                ps3.close();

                ps4.setString(1, "Fixed Discount");
                ps4.setInt(2, id);
                ResultSet dRS = dbConnect.executeGetIDQuery(ps4);

                if (dRS != null) {
                    while (dRS.next()) {
                        discountID = dRS.getInt(1);
                    }
                    ps4.close();
                }

                PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO fixed_discount (discount_id,discount_type,customer_id,discount_percentage) VALUES (?,?,?,?)");
                ps5.setInt(1, discountID);
                ps5.setString(2, "Fixed Discount");
                ps5.setInt(3, id);
                ps5.setFloat(4, fd.getPercentage());

                dbConnect.executeWriteQuery(ps5);
                ps5.close();
            }
            if (cust.getDiscount_plan() instanceof VariableDiscount) {
                VariableDiscount vd = (VariableDiscount) cust.getDiscount_plan();

                ps3.setString(1, "Variable Discount");
                ps3.setInt(2, id);
                
                if (cust.getPay_later()) {
                    ps3.setInt(3, 1);
                } else {
                    ps3.setInt(3, 0);
                }
                dbConnect.executeWriteQuery(ps3);
                ps3.close();


                ps4.setString(1, "Variable Discount");
                ps4.setInt(2, id);
                
                ResultSet dRS = dbConnect.executeGetIDQuery(ps4);

                if (dRS != null) {
                    while (dRS.next()) {
                        discountID = dRS.getInt(1);
                    }
                    
                }

                PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO variable_discount (discount_id,discount_type,customer_id,business_type,discount_percentage) VALUES (?,?,?,?,?)");
                ps5.setInt(1, discountID);
                ps5.setString(2, "Variable Discount");
                ps5.setInt(3, id);
                ps5.setString(4, "Default");
                ps5.setFloat(5, vd.getPercentage());

                dbConnect.executeWriteQuery(ps5);

                ResultSet eRS = dbConnect.executeGetIDQuery(ps4);

                if (eRS != null) {
                    while (eRS.next()) {
                        discountID = eRS.getInt(1);
                    }
                    
                }

                ps5.setInt(1, discountID);
                ps5.setString(2, "Variable Discount");
                ps5.setInt(3, id);
                ps5.setString(4, "MOT");
                ps5.setFloat(5, vd.getMOTPercentage());

                dbConnect.executeWriteQuery(ps5);

                ResultSet fRS = dbConnect.executeGetIDQuery(ps4);

                if (fRS != null) {
                    while (fRS.next()) {
                        discountID = fRS.getInt(1);
                    }
                    
                }

                ps5.setInt(1, discountID);
                ps5.setString(2, "Variable Discount");
                ps5.setInt(3, id);
                ps5.setString(4, "Individual Tasks");
                ps5.setFloat(5, vd.getIndividualPercentage());

                dbConnect.executeWriteQuery(ps5);

                ResultSet gRS = dbConnect.executeGetIDQuery(ps4);

                if (gRS != null) {
                    while (gRS.next()) {
                        discountID = gRS.getInt(1);
                    }
                    
                }

                ps5.setInt(1, discountID);
                ps5.setString(2, "Variable Discount");
                ps5.setInt(3, id);
                ps5.setString(4, "Spare Parts");
                ps5.setFloat(5, vd.getSparePartsPercentage());

                dbConnect.executeWriteQuery(ps5);
                ps5.close();
            }
            if (cust.getDiscount_plan() instanceof FlexibleDiscount) {
                FlexibleDiscount fd = (FlexibleDiscount) cust.getDiscount_plan();

                ps3.setString(1, "Flexible Discount");
                ps3.setInt(2, id);
                ps3.setInt(2, id);
                if (cust.getPay_later()) {
                    ps3.setInt(3, 1);
                } else {
                    ps3.setInt(3, 0);
                }
                dbConnect.executeWriteQuery(ps3);
                ps3.close();
                ps4.close();

                for (int i = 0; i < fd.getFDContainer().size(); i++) {
                    ps4 = dbConnect.setIDPreparedStatement(dbConnect.connect(), "INSERT INTO discount (discount_type,customer_id) VALUES (?,?)");
                    ps4.setString(1, "Flexible Discount");
                    ps4.setInt(2, id);
                    ResultSet dRS = dbConnect.executeGetIDQuery(ps4);

                    if (dRS != null) {
                        while (dRS.next()) {
                            discountID = dRS.getInt(1);
                        }
                        ps4.close();
                    }

                    PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO flexible_discount (discount_id,discount_type,customer_id,discount_value,start_price,end_price,current_month) VALUES (?,?,?,?,?,?,?)");
                    ps5.setInt(1, discountID);
                    ps5.setString(2, "Flexible Discount");
                    ps5.setInt(3, id);
                    ps5.setFloat(4, fd.getFDContainer().get(i).getPercentage());
                    ps5.setFloat(5, fd.getFDContainer().get(i).getStartPrice());
                    ps5.setFloat(6, fd.getFDContainer().get(i).getEndPrice());
                    ps5.setDate(7, date);

                    dbConnect.executeWriteQuery(ps5);

                    ps5.close();
                }

            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void DeleteCustomer(int id, List<Vehicle> vehicles, String discountPlan) {
        try {
            if (discountPlan != "None") {
                if (discountPlan == "Fixed Discount") {
                    PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM fixed_discount WHERE customer_id=?");
                    ps.setInt(1, id);
                    dbConnect.executeWriteQuery(ps);
                    ps.close();
                }
                if (discountPlan == "Flexible Discount") {
                    PreparedStatement ps1 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM flexible_discount WHERE customer_id=?");
                    ps1.setInt(1, id);
                    dbConnect.executeWriteQuery(ps1);
                    ps1.close();
                }
                if (discountPlan == "Variable Discount") {
                    PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM variable_discount WHERE customer_id=?");
                    ps2.setInt(1, id);
                    dbConnect.executeWriteQuery(ps2);
                    ps2.close();
                }

                PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM discount WHERE customer_id=?");
                ps3.setInt(1, id);
                dbConnect.executeWriteQuery(ps3);
                ps3.close();

                PreparedStatement ps4 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM account_holder WHERE customer_id=?");
                ps4.setInt(1, id);
                dbConnect.executeWriteQuery(ps4);
                ps4.close();
            }

            PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM customer WHERE customer_id=?");
            ps5.setInt(1, id);
            dbConnect.executeWriteQuery(ps5);
            ps5.close();

            if (vehicles != null) {
                PreparedStatement ps6 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM customer WHERE customer_id=?");
                ps6.setInt(1, id);
                dbConnect.executeWriteQuery(ps6);
                ps6.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateCustomer(AccountHolder acc) throws SQLException {
        ResultSet rs = null;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        java.sql.Date oldDate = null;

        int accountHolder = 0;
        int discountID = -1;
        String discountPlan = null;

        if (acc.getDiscount_plan() != null) {
            accountHolder = 1;
        }

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "UPDATE Customer SET customer_name=?,customer_address=?,customer_postcode=?,customer_tel=?,"
                    + "customer_email=?,customer_contact=?,customer_account_holder=? WHERE customer_id=?");
            ps.setString(1, acc.getName());
            ps.setString(2, acc.getAddress());
            ps.setString(3, acc.getPostcode());
            ps.setString(4, acc.getPhone());
            ps.setString(5, acc.getEmail());
            ps.setString(6, acc.getCustomerContact());
            ps.setInt(7, accountHolder);
            ps.setInt(8, acc.getCustomerId());

            dbConnect.executeWriteQuery(ps);
            ps.close();

            PreparedStatement ps1 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM vehicle WHERE customer_id=?");
            ps1.setInt(1, acc.getCustomerId());

            dbConnect.executeWriteQuery(ps1);
            ps1.close();

            if (acc.getVehicles() != null) {

                for (int i = 0; i < acc.getVehicles().size(); i++) {
                    PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO vehicle (reg_no,car_make,car_model,engine_serial,chassis_no,colour,purchase_date,customer_id) VALUES "
                            + "(?,?,?,?,?,?,?,?)");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(acc.getVehicles().get(i).getPurchase_date());
                    Date purchase_date = dateFormat.parse(acc.getVehicles().get(i).getPurchase_date());
                    java.sql.Date sqlDate = new java.sql.Date(purchase_date.getTime());

                    ps2.setString(1, acc.getVehicles().get(i).getReg_num());
                    ps2.setString(2, acc.getVehicles().get(i).getMake());
                    ps2.setString(3, acc.getVehicles().get(i).getModel());
                    ps2.setString(4, acc.getVehicles().get(i).getEngine_serial_no());
                    ps2.setString(5, acc.getVehicles().get(i).getChassis_no());
                    ps2.setString(6, acc.getVehicles().get(i).getColour());
                    ps2.setDate(7, sqlDate);
                    ps2.setInt(8, acc.getCustomerId());

                    dbConnect.executeWriteQuery(ps2);
                    ps2.close();
                }
            }
            if (acc.getDiscount_plan() != null) {

                PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM account_holder  WHERE customer_id=?");
                ps3.setInt(1, acc.getCustomerId());

                rs = dbConnect.executeReadQuery(ps3);

                if (rs != null) {
                    while (rs.next()) {
                        discountPlan = rs.getString("discount_plan");
                    }

                    ps3.close();
                }

                ps3.close();

                if (discountPlan != null) {

                    if (discountPlan.equals("Fixed Discount")) {

                        PreparedStatement ps4 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM fixed_discount WHERE customer_id=?");
                        ps4.setInt(1, acc.getCustomerId());

                        dbConnect.executeWriteQuery(ps4);
                        ps4.close();
                    }
                    if (discountPlan.equals("Flexible Discount")) {
                        PreparedStatement ps4 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM flexible_discount WHERE customer_id=?");
                        ps4.setInt(1, acc.getCustomerId());

                        dbConnect.executeWriteQuery(ps4);
                        ps4.close();
                    }
                    if (discountPlan.equals("Variable Discount")) {
                        PreparedStatement ps19 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM variable_discount WHERE customer_id");
                        ps19.setInt(1, acc.getCustomerId());

                        ResultSet dRS = dbConnect.executeReadQuery(ps19);

                        if (dRS != null) {
                            while (dRS.next()) {
                                oldDate = dRS.getDate("current_month");
                            }
                        }

                        ps19.close();

                        PreparedStatement ps4 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM variable_discount WHERE customer_id=?");
                        ps4.setInt(1, acc.getCustomerId());

                        dbConnect.executeWriteQuery(ps4);
                        ps4.close();
                    }

                    PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM discount WHERE customer_id=?");
                    ps5.setInt(1, acc.getCustomerId());

                    dbConnect.executeWriteQuery(ps5);
                    ps5.close();

                    PreparedStatement ps6 = dbConnect.setPreparedStatement(dbConnect.connect(), "DELETE FROM account_holder WHERE customer_id=?");
                    ps6.setInt(1, acc.getCustomerId());

                    dbConnect.executeWriteQuery(ps6);
                    ps6.close();
                }

                PreparedStatement ps5 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO account_holder (discount_plan,customer_id,pay_later) VALUES (?,?,?)");
                PreparedStatement ps6 = dbConnect.setIDPreparedStatement(dbConnect.connect(), "INSERT INTO discount (discount_type,customer_id) VALUES (?,?)");

                if (acc.getDiscount_plan() instanceof FixedDiscount) {
                    FixedDiscount fd = (FixedDiscount) acc.getDiscount_plan();

                    ps5.setString(1, "Fixed Discount");
                    ps5.setInt(2, acc.getCustomerId());
                    if (acc.getPay_later()) {
                        ps5.setInt(3, 1);
                    } else {
                        ps5.setInt(3, 0);
                    }

                    dbConnect.executeWriteQuery(ps5);
                    ps5.close();

                    ps6.setString(1, "Fixed Discount");
                    ps6.setInt(2, acc.getCustomerId());
                    ResultSet dRS = dbConnect.executeGetIDQuery(ps6);

                    if (dRS != null) {
                        while (dRS.next()) {
                            discountID = dRS.getInt(1);
                        }
                        ps6.close();
                    }

                    PreparedStatement ps7 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO fixed_discount (discount_id,discount_type,customer_id,discount_percentage) VALUES (?,?,?,?)");
                    ps7.setInt(1, discountID);
                    ps7.setString(2, "Fixed Discount");
                    ps7.setInt(3, acc.getCustomerId());
                    ps7.setFloat(4, fd.getPercentage());

                    dbConnect.executeWriteQuery(ps7);
                    ps7.close();
                }
                if (acc.getDiscount_plan() instanceof VariableDiscount) {
                    VariableDiscount vd = (VariableDiscount) acc.getDiscount_plan();

                    ps5.setString(1, "Variable Discount");
                    ps5.setInt(2, acc.getCustomerId());
                    ps5.setInt(2, acc.getCustomerId());
                    if (acc.getPay_later()) {
                        ps5.setInt(3, 1);
                    } else {
                        ps5.setInt(3, 0);
                    }
                    dbConnect.executeWriteQuery(ps5);
                    ps5.close();

                    ps6.setString(1, "Variable Discount");
                    ps6.setInt(2, acc.getCustomerId());
                    ResultSet dRS = dbConnect.executeGetIDQuery(ps6);

                    if (dRS != null) {
                        while (dRS.next()) {
                            discountID = dRS.getInt(1);
                        }
                        ps6.close();
                    }

                    PreparedStatement ps7 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO variable_discount (discount_id,discount_type,customer_id,business_type,discount_percentage) VALUES (?,?,?,?,?)");
                    ps7.setInt(1, discountID);
                    ps7.setString(2, "Variable Discount");
                    ps7.setInt(3, acc.getCustomerId());
                    ps7.setString(3, "Default");
                    ps7.setFloat(4, vd.getPercentage());

                    dbConnect.executeWriteQuery(ps7);

                    ps7.setInt(1, discountID);
                    ps7.setString(2, "Variable Discount");
                    ps7.setInt(3, acc.getCustomerId());
                    ps7.setString(4, "MOT");
                    ps7.setFloat(5, vd.getMOTPercentage());

                    dbConnect.executeWriteQuery(ps7);

                    ps7.setInt(1, discountID);
                    ps7.setString(2, "Variable Discount");
                    ps7.setInt(3, acc.getCustomerId());
                    ps7.setString(5, "Individual Tasks");
                    ps7.setFloat(6, vd.getIndividualPercentage());

                    dbConnect.executeWriteQuery(ps7);

                    ps7.setInt(1, discountID);
                    ps7.setString(2, "Variable Discount");
                    ps7.setInt(3, acc.getCustomerId());
                    ps7.setString(5, "Spare Parts");
                    ps7.setFloat(6, vd.getSparePartsPercentage());

                    dbConnect.executeWriteQuery(ps7);
                    ps7.close();
                }
                if (acc.getDiscount_plan() instanceof FlexibleDiscount) {
                    FlexibleDiscount fd = (FlexibleDiscount) acc.getDiscount_plan();
                    ps5.setString(1, "Flexible Discount");
                    ps5.setInt(2, acc.getCustomerId());

                    if (acc.getPay_later()) {
                        ps5.setInt(3, 1);
                    } else {
                        ps5.setInt(3, 0);
                    }
                    dbConnect.executeWriteQuery(ps5);
                    ps5.close();

                    ps6.close();

                    for (int i = 0; i < fd.getFDContainer().size(); i++) {
                        ps6 = dbConnect.setIDPreparedStatement(dbConnect.connect(), "INSERT INTO discount (discount_type,customer_id) VALUES (?,?)");
                        ps6.setString(1, "Flexible Discount");
                        ps6.setInt(2, acc.getCustomerId());
                        ResultSet dRS = dbConnect.executeGetIDQuery(ps6);

                        if (dRS != null) {
                            while (dRS.next()) {
                                discountID = dRS.getInt(1);
                            }
                            ps6.close();
                        }

                        PreparedStatement ps7 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO flexible_discount (discount_id,discount_type,customer_id,discount_value,start_price,end_price,current_month) VALUES (?,?,?,?,?,?,?)");
                        ps7.setInt(1, discountID);
                        ps7.setString(2, "Flexible Discount");
                        ps7.setInt(3, acc.getCustomerId());
                        ps7.setFloat(4, fd.getFDContainer().get(i).getPercentage());
                        ps7.setFloat(5, fd.getFDContainer().get(i).getStartPrice());
                        ps7.setFloat(6, fd.getFDContainer().get(i).getEndPrice());

                        if (oldDate != null) {
                            ps7.setDate(7, oldDate);
                        } else {
                            ps7.setDate(7, date);
                        }

                        dbConnect.executeWriteQuery(ps7);
                        ps7.close();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<AccountHolder> SearchCustomerByName(String n) {
        ResultSet rs = null;
        ResultSet aRs = null;
        ResultSet dRs = null;
        ResultSet vrs = null;
        int id = 0;
        int accountHolder = 0;
        List<AccountHolder> accList = new ArrayList<AccountHolder>();
        AccountHolder acc = null;
        List<Vehicle> vList = new ArrayList<Vehicle>();

        if (n.equals("") || n == null) {
            return SearchCustomer();
        }

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM customer WHERE customer_name=?");
            ps.setString(1, n);

            rs = dbConnect.executeReadQuery(ps);
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("customer_id");
                    accountHolder = rs.getInt("customer_account_holder");

                    PreparedStatement ps1 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM vehicle WHERE customer_id=?");
                    ps1.setInt(1, id);

                    vrs = dbConnect.executeReadQuery(ps1);
                    if (vrs != null) {
                        while (vrs.next()) {
                            vList.add(new Vehicle(vrs.getString("reg_no"), vrs.getString("car_make"), vrs.getString("car_model"), vrs.getString("colour"), vrs.getString("engine_serial"), vrs.getString("chassis_no"), vrs.getString("purchase_date")));
                        }
                        vrs.close();

                    }

                    if (accountHolder == 1) {
                        acc = new AccountHolder(rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_tel"), rs.getString("customer_address"), rs.getString("customer_postcode"), rs.getInt("customer_id"));
                        acc.setVehicles(vList);
                        PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM account_holder WHERE customer_id=i?");
                        ps2.setInt(1, id);

                        aRs = dbConnect.executeReadQuery(ps2);

                        if (aRs.getString("discount_type") == "Fixed Discount") {
                            PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM fixed_discount WHERE customer_id=?");
                            ps3.setInt(1, id);

                            dRs = dbConnect.executeReadQuery(ps3);

                            acc.setDiscount_plan(new FixedDiscount(dRs.getFloat("discount_percentage")));
                            dRs.close();
                        }
                        if (aRs.getString("discount_type") == "Variable Discount") {
                            PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM variable_discount WHERE customer_id=?");
                            ps3.setInt(1, id);

                            dRs = dbConnect.executeReadQuery(ps3);
                            VariableDiscount vd = new VariableDiscount();

                            while (dRs.next()) {
                                if (dRs.getString("business_type") == "Default") {
                                    vd.setPercentage(dRs.getFloat("discount_percentage"));
                                }
                                if (dRs.getString("business_type") == "MOT") {
                                    vd.setMOTPercentage(dRs.getFloat("discount_percentage"));
                                }
                                if (dRs.getString("business_type") == "Individual Tasks") {
                                    vd.setIndividualPercentage(dRs.getFloat("discount_percentage"));
                                }
                                if (dRs.getString("business_type") == "Spare Parts") {
                                    vd.setSparePartsPercentage(dRs.getFloat("discount_percentage"));
                                }
                            }

                            acc.setDiscount_plan(vd);
                            dRs.close();
                        }
                        if (aRs.getString("discount_type") == "Flexible Discount") {
                            List<FlexibleDiscountContainer> fdContainerList = new ArrayList<>();
                            String currentMonth = "";

                            PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM flexible_discount WHERE customer_id=?");
                            ps3.setInt(1, id);

                            dRs = dbConnect.executeReadQuery(ps3);

                            while (dRs.next()) {
                                fdContainerList.add(new FlexibleDiscountContainer(dRs.getFloat("discount_value"), dRs.getInt("start_price"), dRs.getInt("end_price"), dRs.getInt("discount_id")));
                                currentMonth = dRs.getString("current_month");

                            }

                            acc.setDiscount_plan(new FlexibleDiscount(fdContainerList, currentMonth));
                            dRs.close();
                        }

                        ps2.close();

                        accList.add(acc);
                    } else {
                        acc = new AccountHolder(rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_tel"), rs.getString("customer_address"), rs.getString("customer_postcode"), rs.getInt("customer_id"));
                        acc.setVehicles(vList);

                        accList.add(acc);
                    }

                    acc = null;
                    vList.clear();
                }
            }

            return accList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<AccountHolder> SearchCustomer() {
        ResultSet rs = null;
        ResultSet aRs = null;
        ResultSet dRs = null;
        ResultSet vrs = null;
        int id;
        int accountHolder;
        List<AccountHolder> accList = new ArrayList<>();
        AccountHolder acc = null;
        List<Vehicle> vList = new ArrayList<>();

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM customer");

            rs = dbConnect.executeReadQuery(ps);
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("customer_id");
                    accountHolder = rs.getInt("customer_account_holder");

                    PreparedStatement ps1 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM vehicle WHERE customer_id=?");
                    ps1.setInt(1, id);

                    vrs = dbConnect.executeReadQuery(ps1);
                    if (vrs != null) {
                        while (vrs.next()) {
                            vList.add(new Vehicle(vrs.getString("reg_no"), vrs.getString("car_make"), vrs.getString("car_model"), vrs.getString("colour"), vrs.getString("engine_serial"), vrs.getString("chassis_no"), vrs.getString("purchase_date")));
                        }
                        ps1.close();

                    }

                    if (accountHolder == 1) {
                        acc = new AccountHolder(rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_tel"), rs.getString("customer_address"), rs.getString("customer_postcode"), rs.getInt("customer_id"));
                        acc.setVehicles(vList);
                        PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM discount WHERE customer_id=?");
                        ps2.setInt(1, id);

                        String discount = null;

                        aRs = dbConnect.executeReadQuery(ps2);
                        if (aRs != null) {
                            while (aRs.next()) {
                                discount = aRs.getString("discount_type");
                                if (discount.equals("Fixed Discount")) {
                                    PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM fixed_discount WHERE customer_id=?");
                                    ps3.setInt(1, id);

                                    dRs = dbConnect.executeReadQuery(ps3);

                                    while (dRs.next()) {
                                        acc.setDiscount_plan(new FixedDiscount(dRs.getFloat("discount_percentage")));
                                    }

                                    dRs.close();
                                }

                                if (discount.equals("Variable Discount")) {
                                    PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM variable_discount WHERE customer_id=?");
                                    ps3.setInt(1, id);

                                    dRs = dbConnect.executeReadQuery(ps3);
                                    VariableDiscount vd = new VariableDiscount();
                                    String businessType = null;

                                    while (dRs.next()) {
                                        businessType = dRs.getString("business_type");
                                        if (businessType.equals("Default")) {
                                            vd.setPercentage(dRs.getFloat("discount_percentage"));
                                        }
                                        if (businessType.equals("MOT")) {
                                            vd.setMOTPercentage(dRs.getFloat("discount_percentage"));
                                        }
                                        if (businessType.equals("Individual Tasks")) {
                                            vd.setIndividualPercentage(dRs.getFloat("discount_percentage"));
                                        }
                                        if (businessType.equals("Spare Parts")) {
                                            vd.setSparePartsPercentage(dRs.getFloat("discount_percentage"));
                                        }
                                    }

                                    acc.setDiscount_plan(vd);
                                    dRs.close();
                                }

                                if (discount.equals("Flexible Discount")) {
                                    List<FlexibleDiscountContainer> fdContainerList = new ArrayList<>();
                                    String currentMonth = "";

                                    PreparedStatement ps3 = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM flexible_discount WHERE customer_id=?");
                                    ps3.setInt(1, id);

                                    dRs = dbConnect.executeReadQuery(ps3);

                                    while (dRs.next()) {
                                        fdContainerList.add(new FlexibleDiscountContainer(dRs.getFloat("discount_value"), dRs.getInt("start_price"), dRs.getInt("end_price"), dRs.getInt("discount_id")));
                                        currentMonth = dRs.getString("current_month");

                                    }

                                    acc.setDiscount_plan(new FlexibleDiscount(fdContainerList, currentMonth));
                                    dRs.close();
                                }
                            }

                            ps2.close();

                            accList.add(acc);
                        }

                    } else {
                        acc = new AccountHolder(rs.getString("customer_name"), rs.getString("customer_email"), rs.getString("customer_tel"), rs.getString("customer_address"), rs.getString("customer_postcode"), rs.getInt("customer_id"));
                        acc.setVehicles(vList);

                        accList.add(acc);
                    }

                    acc = null;

                    vList = new ArrayList<>();
                }
            }

            return accList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void ReorderStock() {
        // TODO - implement Control.ReorderStock
        throw new UnsupportedOperationException();
    }

    public void PrintReminders() {
        // TODO - implement Control.PrintReminders
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param n
     */
    public void PrintRemindersByName(String n) {
        // TODO - implement Control.PrintRemindersByName
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param job
     */
    public void AddJobs(Job job) {
        // TODO - implement Control.AddJobs
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param no
     * @param status
     */
    public void ChangeJobStatus(int no, String status) {
        // TODO - implement Control.ChangeJobStatus
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param num
     */
    public Job SearchForJobByCarNum(int num) {
        // TODO - implement Control.SearchForJobByCarNum
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param no
     */
    public Job SearchForJobByJobNum(int no) {
        // TODO - implement Control.SearchForJobByJobNum
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param name
     */
    public Part FindPartsByName(String name) {
        // TODO - implement Control.FindPartsByName
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param part
     */
    public void AddPart(Part part) {
        // TODO - implement Control.AddPart
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param part
     */
    public void RemovePart(Part part) {
        // TODO - implement Control.RemovePart
        throw new UnsupportedOperationException();
    }

    public void NumOfVehiclesPerMonth() {
        // TODO - implement Control.NumOfVehiclesPerMonth
        throw new UnsupportedOperationException();
    }

    public List<Vehicle> NumOfVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM vehicle");
            ResultSet rs = dbConnect.executeReadQuery(ps);

            if (rs != null) {
                while (rs.next()) {
                    String[] dateArray = rs.getString("purchase_date").split("-");
                    String dateFormat = dateArray[2] + "-" + dateArray[1] + "-" + dateArray[0];

                    vehicleList.add(new Vehicle(rs.getString("reg_no"), rs.getString("car_make"), rs.getString("car_model"), rs.getString("colour"),
                            rs.getString("engine_serial"), rs.getString("chassis_no"), dateFormat));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return vehicleList;
    }

    public boolean checkEndOfMonth() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int noOfLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (cal.get(Calendar.DAY_OF_MONTH) == noOfLastDay) {
            return true;
        }

        return false;
    }

    /**
     *
     * @param type
     */
    public void NumOfVehiclesByJobType(String type) {
        // TODO - implement Control.NumOfVehiclesByJobType
        throw new UnsupportedOperationException();
    }

    public void GenerateCustomers() {
        // TODO - implement Control.GenerateCustomers
        throw new UnsupportedOperationException();
    }

    public void AverageTimePerJob() {
        // TODO - implement Control.AverageTimePerJob
        throw new UnsupportedOperationException();
    }

    public List<Part> GenerateStock() {
        List<Part> partsList = new ArrayList<>();

        try {
            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT * FROM parts");
            ResultSet rs = dbConnect.executeReadQuery(ps);

            if (rs != null) {
                while (rs.next()) {
                    partsList.add(new Part(rs.getString("part_name"), rs.getString("part_manufacturer"), rs.getString("vehicle_type"), rs.getInt("year"), rs.getFloat("part_price"), rs.getInt("part_quantity"), rs.getInt("part_threshold")));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return partsList;
    }

    public boolean AutomaticReportGenerated() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int noOfLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int counter = 0;

        date.setDate(noOfLastDay);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            PreparedStatement ps = dbConnect.setPreparedStatement(dbConnect.connect(), "SELECT COUNT(*) AS total FROM automated_report WHERE report_date=?");
            ps.setDate(1, sqlDate);

            ResultSet rs = dbConnect.executeReadQuery(ps);

            if (rs != null) {
                while (rs.next()) {
                    counter = rs.getInt("total");
                }
            }

            ps.close();

            if (counter < 1) {
                File f = new File("Reports");
                if (!f.exists()) {
                    f.mkdir();
                }

                File vdir = new File("Reports/Spare Parts");
                if (!vdir.exists()) {
                    vdir.mkdir();
                }

                GenerateStock generateStock = new GenerateStock("", date, GenerateStock());

                PreparedStatement ps2 = dbConnect.setPreparedStatement(dbConnect.connect(), "INSERT INTO automated_report (report_name,report_date) VALUES (?,?)");
                ps2.setString(1, "Spare Parts");
                ps2.setDate(2, sqlDate);

                dbConnect.executeWriteQuery(ps2);
                ps2.close();

                JOptionPane.showMessageDialog(new JFrame("Automated Reports"), "Automated Reports generated");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(dateFormat.format(date));
        return false;
    }

    public void DisplayAlerts() {
        // TODO - implement Control.DisplayAlerts
        throw new UnsupportedOperationException();
    }

    public void AddUser() {
        // TODO - implement Control.AddUser
        throw new UnsupportedOperationException();
    }

    public void DeleteUser() {
        // TODO - implement Control.DeleteUser
        throw new UnsupportedOperationException();
    }

    public void UpdateUser() {

    }

    //logouts out
    public void logout() {
        if (getTime != null) {
            getTime.stop();
            getTime = null;
        }
        
        if (getMot != null) {
            getMot.stop();
            getMot = null;
        }

        loginForm = new LoginForm(this);
        loginForm.setVisible(true);

        if (staff != null) {
            staff = null;
        }
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    //Opens the menu and delegates which menu buttons are available by checking the role
    public void OpenMenu() {
        Alert alert = new Alert();
        //disposeForms();
        switch (CheckRole()) {
            case "Administrator":
                adminMenuForm = new AdminMenuForm(this);
                adminMenuForm.setVisible(true);
                break;
            case "Franchisee":
                //Starting thread which checks for late payments
                if (getTime == null) {
                    getTime = new DetectLatePayment(this);
                    getTime.start();
                }

                if (getMot == null) {
                    getMot = new DetectMOTDue(this);
                    getMot.start();
                }
                
                alert.start();
                franchiseeMenuForm = new FranchiseeMenuForm(this);
                franchiseeMenuForm.setVisible(true);
                break;
            case "Receptionist":
                alert.start();
                receptionMenuForm = new ReceptionistMenuForm(this);
                receptionMenuForm.setVisible(true);
                break;
            case "Mechanic":
                mechanicMenuForm = new MechanicMenuForm(this);
                mechanicMenuForm.setVisible(true);
                break;
            case "Foreperson":
                alert.start();
                fpMenuForm = new ForepersonMenuForm(this);
                fpMenuForm.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void disposeForms() {
        loginForm.dispose();
        adminMenuForm.dispose();
        fpMenuForm.dispose();
        franchiseeMenuForm.dispose();
        mechanicMenuForm.dispose();
        receptionMenuForm.dispose();
    }

    public void hideForms() {
        loginForm.setVisible(false);
        adminMenuForm.setVisible(false);
        fpMenuForm.setVisible(false);
        franchiseeMenuForm.setVisible(false);
        mechanicMenuForm.setVisible(false);
        receptionMenuForm.setVisible(false);
    }

    public DBConnect getDatabaseConnector() {
        return dbConnect;
    }

    public void terminateThread() {

        if (windowList.isEmpty()) {
            getTime.stop();
        } else {
            boolean exists = false;
            for (JFrame frame : windowList) {
                if (frame.isDisplayable()) {
                    //System.out.println("Not Disposed");
                    exists = true;
                } else {
                    //System.out.println("Disposed");
                }
            }

            if (!exists) {
                if (getTime != null) {
                    getTime.stop();
                    getTime = null;
                }
                
                if (getMot != null) {
                    getMot.stop();
                    getMot = null;
                }
            }
        }
    }

    public void setAdminMenuForm(AdminMenuForm amf) {
        adminMenuForm = amf;
    }

    public void setForepersonMenuForm(ForepersonMenuForm fpmf) {
        fpMenuForm = fpmf;
    }

    public void setFranchiseeMenuForm(FranchiseeMenuForm fmf) {
        franchiseeMenuForm = fmf;
    }

    public void setReceptionMenuForm(ReceptionistMenuForm rmf) {
        receptionMenuForm = rmf;
    }

    public void setMechanicMenuForm(MechanicMenuForm mmf) {
        mechanicMenuForm = mmf;
    }

    public void setLoginForm(LoginForm lf) {
        loginForm = lf;
    }

    public List<JFrame> getWindowList() {
        return windowList;
    }
}
