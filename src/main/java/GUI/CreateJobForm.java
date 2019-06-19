/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.Customer;
import Account.Mechanic;
import Account.Vehicle;
import Core.Control;
import java.sql.*;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import Processing.Job;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jly09
 */
public class CreateJobForm extends javax.swing.JFrame {
    Control control;
    ForepersonMenuForm fpMenuForm;
    FranchiseeMenuForm franchiseeMenuForm;
    ReceptionistMenuForm receptionMenuForm;
    
    DBConnect dbConnect;
    Vehicle selectedVehicle;
    Customer selectedCustomer = new Customer();
    int tickedRow = -1;
    int jobId= 0;
    int clearTaskText = 0;
    ArrayList<Mechanic> mechanics = new ArrayList<Mechanic>();
    ArrayList<String> tasks = new ArrayList<String>();
    DefaultListModel listModel = new DefaultListModel<>();
    

    /**
     * Creates new form MenuForm
     */
    public CreateJobForm() {
        initComponents();
        dbConnect = new DBConnect();
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public CreateJobForm(Control c) {
        initComponents();
        
        control = c;
        dbConnect = control.getDatabaseConnector();
        control.getWindowList().add(this);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    CreateJobForm(Control c, ForepersonMenuForm fpmf) {
        initComponents();
        
        control = c;
        fpMenuForm = fpmf;
        
        dbConnect = control.getDatabaseConnector();
        control.getWindowList().add(this);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    CreateJobForm(Control c, FranchiseeMenuForm fmf) {
        initComponents();
        
        control = c;
        franchiseeMenuForm = fmf;
        
        dbConnect = control.getDatabaseConnector();
        control.getWindowList().add(this);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    CreateJobForm(Control c, ReceptionistMenuForm rmf) {
        initComponents();
        
        control = c;
        receptionMenuForm = rmf;
        
        dbConnect = control.getDatabaseConnector();
        control.getWindowList().add(this);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void dispose() {
        super.dispose();
        control.terminateThread();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Create Job");

        jButton5.setText("Create");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Customer Lookup");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOT Car", "Annual Service", "Repair", "MOT Van" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Mechanic");

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Phone", "Address", "Account Holder", "Customer ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel8.setText("Vehicle");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No.", "Make", "Model", "Colour", "Engine Serial No.", "Chassis No.#", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(20);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable2ComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estimated Duration");

        jLabel4.setText("Description of work required");

        jList1.setToolTipText("");
        jScrollPane4.setViewportView(jList1);

        jTextField2.setText("Add Task (use enter key)");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(316, 316, 316)
                                        .addComponent(jButton6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(69, 69, 69)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(50, 50, 50)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(47, 47, 47)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back_btn)
                .addGap(7, 7, 7)
                .addComponent(logout_btn)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_btn)
                            .addComponent(logout_btn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        selectedVehicle = null;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        
        String customerName = jTextField3.getText();

        String customerNameQuery = "SELECT customer_name, customer_email, "
                + "customer_tel, customer_address, customer_account_holder, customer_id FROM"
                + " garitsdb.Customer WHERE customer_name"
                + " LIKE '%" + customerName + "%'";
        
        ResultSet rs;
        
        try {
            rs = dbConnect.read(customerNameQuery);
            
            while(rs.next()) {
                Customer customer = new Customer();
                customer.setName(rs.getString("customer_name"));
                customer.setAddress(rs.getString("customer_address"));
                customer.setEmail(rs.getString("customer_email"));
                customer.setPhone(rs.getString("customer_tel"));
                customer.setAccountHolder(rs.getBoolean("customer_account_holder"));
                customer.setCustomerId(rs.getInt("customer_id"));

                String name = customer.getName();
                String address = customer.getAddress();
                String email = customer.getEmail();
                String phone = customer.getPhone();
                boolean accountHolder = customer.isAccountHolder();;
                
                Object[] row = { name, email, phone, address,
                    accountHolder, customer.getCustomerId() };

                

                model.addRow(row);
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //TODO REWORK GUI FOR WORK REQUIRED
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        jList1.setModel(listModel);
        
        
        jComboBox1.getItemAt(0);
        jComboBox2.getItemAt(0);
        TableColumn idColumn = jTable1.getColumnModel().getColumn(5);
        jTable1.getColumnModel().removeColumn(idColumn);
        String mechanicNamesQuery = "SELECT username, user_id FROM user "
                + "WHERE user_role = 'Mechanic' OR user_role = 'Foreperson';";
        ResultSet rs;
        
        try {
            rs = dbConnect.read(mechanicNamesQuery);
            
            while(rs.next()) {
                Mechanic mechanic = new Mechanic();
                mechanic.setId(rs.getInt("user_id"));
                mechanic.setName(rs.getString("username"));
                mechanics.add(mechanic);
                jComboBox2.addItem(rs.getString("username"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	java.util.Date date = new java.util.Date();
        Mechanic selectedMechanic = new Mechanic();
        for(Mechanic mechanic : mechanics) {
            if(mechanic.getName().equals(jComboBox2.getSelectedItem())){
                selectedMechanic.setId(mechanic.getId());
                selectedMechanic.setName(mechanic.getName());
            }
        }
        
        Job job = new Job();
        job.setCustomerId(selectedCustomer.getCustomerId());
        job.setRegistrationNum(selectedVehicle.getReg_num());
        job.setDate_start(dateFormat.format(date));
        job.setMechanicId(selectedMechanic.getId());
        job.setEstimate_duration(Integer.valueOf(jTextField1.getText()));
        job.setStatus("Pending");
        job.setType(jComboBox1.getSelectedItem().toString());

        String insertJobQuery = "INSERT INTO Job ("
                + "job_date, reg_no, customer_id, mechanic_assigned, "
                + "job_duration, job_status, "
                + "job_type) VALUES ('"+job.getDate_start()+"', "
                + "'"+job.getRegistrationNum()+"', '"+job.getCustomerId()+"', "
                + "'"+job.getMechanicId()+"', "
                + "'"+job.getEstimate_duration()+"', '"+job.getStatus()+"', "
                + "'"+job.getType()+"');";
        
        try { 
            Connection conn = dbConnect.connect();
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement(insertJobQuery,
                    Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    jobId = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
            //TODO use jobId to write out tasks work required
            for(String task : tasks) {
                String insertTaskQuery = "INSERT INTO `garitsdb`.`Job_Tasks`"
                    + " (`job_id`, `task_content`) VALUES ('" + jobId + "', '"
                        + task + "');";
                statement = conn.prepareStatement(insertTaskQuery);
                statement.execute();
            }
            conn.commit();
            conn.setAutoCommit(true);
            
            if (fpMenuForm != null) {
                JobForm jobForm = new JobForm(control, fpMenuForm);
                jobForm.setVisible(true);
                this.dispose();
            }
            
            if (franchiseeMenuForm != null) {
                JobForm jobForm = new JobForm(control, franchiseeMenuForm);
                jobForm.setVisible(true);
                this.dispose();
            }
            
            if (receptionMenuForm != null) {
                JobForm jobForm = new JobForm(control, receptionMenuForm);
                jobForm.setVisible(true);
                this.dispose();
            }
            
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel carTable = (DefaultTableModel) jTable2.getModel();
        carTable.setRowCount(0);
        Object customerId = null;
        if (evt.getClickCount() == 1) {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            int column = target.getSelectedColumn();
            selectedVehicle = null;
            tickedRow = -1;
            // On SELECTING CUSTOMER add necessary information for creating JOB 
            customerId = jTable1.getModel().getValueAt(row, 5);
            selectedCustomer.setCustomerId((int) customerId);
        }
        
        String vehiclesQuery = "SELECT * FROM garitsdb.Vehicle "
                + "WHERE customer_id = " + customerId;
        ResultSet rs;
        
        try {
            rs = dbConnect.read(vehiclesQuery);

            while(rs.next()) {
                Vehicle car = new Vehicle();
                car.setReg_num(rs.getString("reg_no"));
                car.setMake(rs.getString("car_make"));
                car.setModel(rs.getString("car_model"));
                car.setEngine_serial_no(rs.getString("engine_serial"));
                car.setChassis_no(rs.getString("chassis_no"));
                car.setColour(rs.getString("colour"));
                
                String regNum = car.getReg_num();
                String carMake = car.getMake();
                String carModel = car.getModel();
                String engineSerial = car.getEngine_serial_no();
                String chassisNumber = car.getChassis_no();
                String colour = car.getColour();

                Object[] row = { regNum, carMake, carModel, colour,
                    engineSerial, chassisNumber };

                carTable.addRow(row);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jTable2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentShown
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTable2ComponentShown

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        DefaultTableModel carTable = (DefaultTableModel) jTable2.getModel();
        Vector rowData = new Vector();
        Object cellData = null;
        JTable target = (JTable)evt.getSource();
        int row = target.getSelectedRow();
        int col = target.getSelectedColumn(); 
        if(col == 6 && carTable.getValueAt(row, 6).toString() == "true") {
            rowData = (Vector) carTable.getDataVector().elementAt(jTable2.getSelectedRow());
            // do some action if appropriate column
            Vehicle car = new Vehicle(rowData.get(0).toString(),
                    rowData.get(1).toString(), rowData.get(2).toString(),
                    rowData.get(3).toString(), rowData.get(4).toString(),
                    rowData.get(5).toString());
            selectedVehicle = car;
            System.out.println(selectedVehicle.getReg_num()+"REGNNUM");
            if(tickedRow != -1) {
                carTable.setValueAt(false, tickedRow, 6);
            } 
            tickedRow = row;
        } else if(col == 6 && carTable.getValueAt(row, 6).toString() == "false") {
            selectedVehicle = null;
        }
            

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        tasks.add(jTextField2.getText());
        listModel.addElement(jTextField2.getText());
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        clearTaskText++;
        if(clearTaskText==1) {
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        control.OpenMenu();
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        control.logout();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateJobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateJobForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton logout_btn;
    // End of variables declaration//GEN-END:variables
}
