/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.AccountHolder;
import Account.Customer;
import Account.FixedDiscount;
import Account.FlexibleDiscount;
import Account.FlexibleDiscountContainer;
import Account.VariableDiscount;
import Account.Vehicle;
import Core.*;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author jly09
 */
public class CreateCustCardForm extends javax.swing.JFrame {

    Control control = null;
    FranchiseeMenuForm franchiseeMenuForm = null;
    ForepersonMenuForm fpMenuForm = null;
    ReceptionistMenuForm receptionMenuForm = null;
    AddVehicleForm addVehicleForm = null;
    AddFlexibleDiscountForm addFlexibleDiscountForm = null;
    List<Vehicle> vehicleList = null;
    List<FlexibleDiscountContainer> fdContainerList = null;
    Customer cust = null;
    AccountHolder accHolder = null;

    /**
     * Creates new form MenuForm
     */
    public CreateCustCardForm() {
        initComponents();
        this.setSize(new Dimension(770, 685));
        this.setPreferredSize(new Dimension(770, 685));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        customerType_cmbo.addItemListener(new CustomerTypeItemListener());
        discountType_cmbo.addItemListener(new DiscountTypeItemListener());

        vehicleList = new ArrayList<Vehicle>();
        fdContainerList = new ArrayList<>();
        phone_txt.setDocument(new LengthRestrictedDocument(11));
        postcode_txt.setDocument(new LengthRestrictedDocument(8));

        customerType_cmbo.setSelectedItem("Casual");
    }

    public CreateCustCardForm(Control c, FranchiseeMenuForm fmf) {
        initComponents();
        this.setSize(new Dimension(770, 685));
        this.setPreferredSize(new Dimension(770, 685));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        customerType_cmbo.addItemListener(new CustomerTypeItemListener());
        discountType_cmbo.addItemListener(new DiscountTypeItemListener());

        control = c;
        franchiseeMenuForm = fmf;

        control.getWindowList().add(this);

        vehicleList = new ArrayList<Vehicle>();
        fdContainerList = new ArrayList<>();
        phone_txt.setDocument(new LengthRestrictedDocument(11));
        postcode_txt.setDocument(new LengthRestrictedDocument(8));

        customerType_cmbo.setSelectedItem("Casual");
        this.setLocationRelativeTo(null);
    }
    
    public CreateCustCardForm(Control c, ForepersonMenuForm fpmf) {
        initComponents();
        this.setSize(new Dimension(770, 685));
        this.setPreferredSize(new Dimension(770, 685));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        customerType_cmbo.addItemListener(new CustomerTypeItemListener());
        discountType_cmbo.addItemListener(new DiscountTypeItemListener());

        control = c;
        fpMenuForm = fpmf;

        control.getWindowList().add(this);

        vehicleList = new ArrayList<Vehicle>();
        fdContainerList = new ArrayList<>();
        phone_txt.setDocument(new LengthRestrictedDocument(11));
        postcode_txt.setDocument(new LengthRestrictedDocument(8));

        customerType_cmbo.setSelectedItem("Casual");
        this.setLocationRelativeTo(null);
    }
    
    public CreateCustCardForm(Control c, ReceptionistMenuForm rmf) {
        initComponents();
        this.setSize(new Dimension(770, 685));
        this.setPreferredSize(new Dimension(770, 685));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        customerType_cmbo.addItemListener(new CustomerTypeItemListener());
        discountType_cmbo.addItemListener(new DiscountTypeItemListener());

        control = c;
        receptionMenuForm = rmf;

        control.getWindowList().add(this);

        vehicleList = new ArrayList<Vehicle>();
        fdContainerList = new ArrayList<>();
        phone_txt.setDocument(new LengthRestrictedDocument(11));
        postcode_txt.setDocument(new LengthRestrictedDocument(8));

        customerType_cmbo.setSelectedItem("Casual");
        this.setLocationRelativeTo(null);
    }

    @Override
    public void dispose() {
        super.dispose();
        control.terminateThread();
    }

    public void setControl(Control c) {
        control = c;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public JComboBox<String> getVehicleComboBox() {
        return vehicle_cmbo;
    }

    public List<FlexibleDiscountContainer> getFDContainerList() {
        return fdContainerList;
    }

    public JComboBox<String> getFDContainerComboBox() {
        return flexible_discount_cmbo;
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
        createCustomer_lbl = new javax.swing.JLabel();
        create_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        name_lbl = new javax.swing.JLabel();
        email_lbl = new javax.swing.JLabel();
        phone_lbl = new javax.swing.JLabel();
        address_lbl = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        email_txt = new javax.swing.JTextField();
        phone_txt = new javax.swing.JTextField();
        address_txt = new javax.swing.JTextField();
        customerType_lbl = new javax.swing.JLabel();
        customerType_cmbo = new javax.swing.JComboBox<>();
        discountType_lbl = new javax.swing.JLabel();
        discountType_cmbo = new javax.swing.JComboBox<>();
        discount_lbl = new javax.swing.JLabel();
        discountPercent_lbl = new javax.swing.JLabel();
        discountPercent_txt = new javax.swing.JTextField();
        vehicle_lbl = new javax.swing.JLabel();
        vehicle_add_btn = new javax.swing.JButton();
        vehicle_delete_btn = new javax.swing.JButton();
        vehicle_cmbo = new javax.swing.JComboBox<>();
        postcode_lbl = new javax.swing.JLabel();
        postcode_txt = new javax.swing.JTextField();
        motPercent_lbl = new javax.swing.JLabel();
        motPercent_txt = new javax.swing.JTextField();
        spareParts_txt = new javax.swing.JTextField();
        spareParts_lbl = new javax.swing.JLabel();
        individualTask_txt = new javax.swing.JTextField();
        individualTask_lbl = new javax.swing.JLabel();
        payLater_lbl = new javax.swing.JLabel();
        payLater_cmbo = new javax.swing.JComboBox<>();
        postcode_lbl1 = new javax.swing.JLabel();
        contact_txt = new javax.swing.JTextField();
        flexible_discount_cmbo = new javax.swing.JComboBox<>();
        flexible_discount_add_btn = new javax.swing.JButton();
        flexible_discount_delete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Customer");
        setMinimumSize(new java.awt.Dimension(742, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(742, 720));
        getContentPane().setLayout(null);

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        getContentPane().add(logout_btn);
        logout_btn.setBounds(670, 13, 71, 25);

        createCustomer_lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        createCustomer_lbl.setText("Create Customer");
        getContentPane().add(createCustomer_lbl);
        createCustomer_lbl.setBounds(52, 78, 179, 29);

        create_btn.setBackground(new java.awt.Color(255, 0, 51));
        create_btn.setText("Create");
        create_btn.setOpaque(false);
        create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnActionPerformed(evt);
            }
        });
        getContentPane().add(create_btn);
        create_btn.setBounds(580, 594, 102, 44);

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn);
        back_btn.setBounds(593, 13, 70, 25);

        name_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name_lbl.setText("Name");
        getContentPane().add(name_lbl);
        name_lbl.setBounds(52, 209, 45, 22);

        email_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email_lbl.setText("Email");
        getContentPane().add(email_lbl);
        email_lbl.setBounds(52, 262, 42, 22);

        phone_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phone_lbl.setText("Phone");
        getContentPane().add(phone_lbl);
        phone_lbl.setBounds(52, 307, 49, 22);

        address_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        address_lbl.setText("Address");
        getContentPane().add(address_lbl);
        address_lbl.setBounds(52, 353, 62, 22);

        name_txt.setToolTipText("Customer Name");
        getContentPane().add(name_txt);
        name_txt.setBounds(167, 208, 150, 29);

        email_txt.setToolTipText("Customer Email");
        email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
        });
        getContentPane().add(email_txt);
        email_txt.setBounds(167, 259, 150, 29);

        phone_txt.setToolTipText("Customer Telephone number");
        phone_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_txtActionPerformed(evt);
            }
        });
        getContentPane().add(phone_txt);
        phone_txt.setBounds(167, 306, 150, 29);

        address_txt.setToolTipText("Customer Address");
        address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_txtActionPerformed(evt);
            }
        });
        getContentPane().add(address_txt);
        address_txt.setBounds(167, 353, 150, 29);

        customerType_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerType_lbl.setText("Type");
        getContentPane().add(customerType_lbl);
        customerType_lbl.setBounds(52, 163, 39, 22);

        customerType_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Account Holder", "Casual" }));
        customerType_cmbo.setToolTipText("Type of Customer Account. Either Account Holder or Casual."); // NOI18N
        customerType_cmbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerType_cmboItemStateChanged(evt);
            }
        });
        getContentPane().add(customerType_cmbo);
        customerType_cmbo.setBounds(167, 163, 150, 27);

        discountType_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discountType_lbl.setText("Type");
        getContentPane().add(discountType_lbl);
        discountType_lbl.setBounds(395, 163, 39, 22);

        discountType_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fixed Discount", "Variable Discount", "Flexible Discount" }));
        discountType_cmbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                discountType_cmboItemStateChanged(evt);
            }
        });
        getContentPane().add(discountType_cmbo);
        discountType_cmbo.setBounds(532, 163, 150, 27);

        discount_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discount_lbl.setText("Discount Plan");
        getContentPane().add(discount_lbl);
        discount_lbl.setBounds(395, 112, 107, 22);

        discountPercent_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        discountPercent_lbl.setText("Percentage");
        discountPercent_lbl.setToolTipText("");
        getContentPane().add(discountPercent_lbl);
        discountPercent_lbl.setBounds(395, 209, 86, 22);

        discountPercent_txt.setToolTipText("The standard percentage for any applicable discount. Acts as a default percentage for Variable Discount plans.");
        getContentPane().add(discountPercent_txt);
        discountPercent_txt.setBounds(532, 208, 150, 29);

        vehicle_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vehicle_lbl.setText("Vehicle");
        getContentPane().add(vehicle_lbl);
        vehicle_lbl.setBounds(50, 520, 55, 22);

        vehicle_add_btn.setText("Add");
        vehicle_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle_add_btnActionPerformed(evt);
            }
        });
        getContentPane().add(vehicle_add_btn);
        vehicle_add_btn.setBounds(170, 520, 60, 30);

        vehicle_delete_btn.setText("Delete");
        vehicle_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle_delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(vehicle_delete_btn);
        vehicle_delete_btn.setBounds(240, 520, 70, 30);

        getContentPane().add(vehicle_cmbo);
        vehicle_cmbo.setBounds(50, 570, 265, 27);

        postcode_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        postcode_lbl.setText("Postcode");
        getContentPane().add(postcode_lbl);
        postcode_lbl.setBounds(52, 401, 71, 22);

        postcode_txt.setToolTipText("Customer postcode");
        postcode_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postcode_txtActionPerformed(evt);
            }
        });
        getContentPane().add(postcode_txt);
        postcode_txt.setBounds(167, 400, 150, 29);

        motPercent_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        motPercent_lbl.setText("MOT Percent");
        getContentPane().add(motPercent_lbl);
        motPercent_lbl.setBounds(395, 254, 102, 22);

        motPercent_txt.setToolTipText("Only applies to Variable Discount. The discount percentage for Jobs involving MoT checks.");
        getContentPane().add(motPercent_txt);
        motPercent_txt.setBounds(532, 252, 150, 29);

        spareParts_txt.setToolTipText("Only applies to Variable Discount. This applies to Jobs involving Spare Part purchases.");
        getContentPane().add(spareParts_txt);
        spareParts_txt.setBounds(532, 352, 150, 29);

        spareParts_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spareParts_lbl.setText("Spare Parts");
        getContentPane().add(spareParts_lbl);
        spareParts_lbl.setBounds(395, 353, 89, 22);

        individualTask_txt.setToolTipText("Only applies to Variable Discount. This percentage is applied to Jobs involving service types (individual tasks).");
        getContentPane().add(individualTask_txt);
        individualTask_txt.setBounds(532, 302, 150, 29);

        individualTask_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        individualTask_lbl.setText("Individual Tasks");
        getContentPane().add(individualTask_lbl);
        individualTask_lbl.setBounds(395, 304, 128, 22);

        payLater_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payLater_lbl.setText("Pay Later");
        getContentPane().add(payLater_lbl);
        payLater_lbl.setBounds(395, 253, 73, 22);

        payLater_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        getContentPane().add(payLater_cmbo);
        payLater_cmbo.setBounds(532, 250, 150, 27);

        postcode_lbl1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        postcode_lbl1.setText("Contact");
        getContentPane().add(postcode_lbl1);
        postcode_lbl1.setBounds(50, 450, 60, 22);

        contact_txt.setToolTipText("Customer postcode");
        contact_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_txtActionPerformed(evt);
            }
        });
        getContentPane().add(contact_txt);
        contact_txt.setBounds(170, 450, 150, 29);

        getContentPane().add(flexible_discount_cmbo);
        flexible_discount_cmbo.setBounds(530, 450, 150, 27);

        flexible_discount_add_btn.setText("Add");
        flexible_discount_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flexible_discount_add_btnActionPerformed(evt);
            }
        });
        getContentPane().add(flexible_discount_add_btn);
        flexible_discount_add_btn.setBounds(530, 410, 60, 30);

        flexible_discount_delete_btn.setText("Delete");
        flexible_discount_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flexible_discount_delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(flexible_discount_delete_btn);
        flexible_discount_delete_btn.setBounds(610, 410, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_txtActionPerformed

    private void phone_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_txtActionPerformed

    private void address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_txtActionPerformed

    private void customerType_cmboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerType_cmboItemStateChanged

    }//GEN-LAST:event_customerType_cmboItemStateChanged

    private void discountType_cmboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_discountType_cmboItemStateChanged

    }//GEN-LAST:event_discountType_cmboItemStateChanged

    private void vehicle_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle_add_btnActionPerformed
        addVehicleForm = new AddVehicleForm(control, this);
        addVehicleForm.setVisible(true);
    }//GEN-LAST:event_vehicle_add_btnActionPerformed

    private void vehicle_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle_delete_btnActionPerformed
        if (vehicle_cmbo.getSelectedItem() != null) {
            String[] vehicleString = null;
            vehicleString = String.valueOf(vehicle_cmbo.getSelectedItem()).split(",");
            vehicle_cmbo.removeItem(vehicle_cmbo.getSelectedItem());

            if (vehicleList != null) {
                for (int i = 0; i < vehicleList.size(); i++) {
                    if (vehicleList.get(i).getReg_num() == vehicleString[0]) {
                        vehicleList.remove(i);
                    }
                }
            }

            vehicle_cmbo.setSelectedItem(null);
        }
    }//GEN-LAST:event_vehicle_delete_btnActionPerformed

    private void create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnActionPerformed

        if (name_txt.getText() == ""
                || email_txt.getText() == ""
                || !phone_txt.getText().matches("[0-9]{11}")
                || address_txt.getText() == "") {
            JOptionPane.showMessageDialog(new JFrame("Error"), "Incorrect format for text fields.");
        } else {
            try {
                if (customerType_cmbo.getSelectedItem().equals("Account Holder")) {
                    System.out.println("Account Holder");
                    if (accHolder == null) {
                        accHolder = new AccountHolder(name_txt.getText(), email_txt.getText(),
                                phone_txt.getText(), address_txt.getText(), postcode_txt.getText(), contact_txt.getText());

                        if (payLater_cmbo.getSelectedItem().equals("Yes")) {
                            accHolder.setPay_later(true);
                        } else {
                            accHolder.setPay_later(false);
                        }

                        if (discountType_cmbo.getSelectedItem().equals("Fixed Discount")) {
                            accHolder.setDiscount_plan(new FixedDiscount(Float.parseFloat(discountPercent_txt.getText())));
                            System.out.println("Discount");
                        }
                        if (discountType_cmbo.getSelectedItem().equals("Variable Discount")) {
                            VariableDiscount vd = new VariableDiscount(Float.parseFloat(discountPercent_txt.getText()), Float.parseFloat(motPercent_txt.getText()),
                                    Float.parseFloat(individualTask_txt.getText()), Float.parseFloat(spareParts_txt.getText()));
                            accHolder.setDiscount_plan(vd);

                        }
                        if (discountType_cmbo.getSelectedItem().equals("Flexible Discount")) {
                            accHolder.setDiscount_plan(new FlexibleDiscount(fdContainerList));
                        }

                        control.AddCustomer(accHolder, vehicleList);

                    }
                } else {
                    if (cust == null) {
                        cust = new Customer(name_txt.getText(), email_txt.getText(),
                                phone_txt.getText(), address_txt.getText(), postcode_txt.getText(), contact_txt.getText());
                        control.AddCustomer(cust, vehicleList);

                    }
                }
                control.OpenMenu();
                this.dispose();
                JOptionPane.showMessageDialog(new JFrame("Created Customer"), "Customer successfully created.");
                reset();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame("Creating Customer"), "Creation failed.");
            }

        }
    }//GEN-LAST:event_create_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        reset();
        control.logout();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        reset();
        control.OpenMenu();
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void postcode_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postcode_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postcode_txtActionPerformed

    private void contact_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_txtActionPerformed

    private void flexible_discount_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexible_discount_add_btnActionPerformed
        addFlexibleDiscountForm = new AddFlexibleDiscountForm(control, this);
        addFlexibleDiscountForm.setVisible(true);
    }//GEN-LAST:event_flexible_discount_add_btnActionPerformed

    private void flexible_discount_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexible_discount_delete_btnActionPerformed
        if (flexible_discount_cmbo.getSelectedItem() != null) {
            String[] flexibleDiscountString = null;
            flexibleDiscountString = String.valueOf(flexible_discount_cmbo.getSelectedItem()).split(",");
            flexible_discount_cmbo.removeItem(flexible_discount_cmbo.getSelectedItem());

            if (fdContainerList != null) {
                for (int i = 0; i < fdContainerList.size(); i++) {
                    if (fdContainerList.get(i).getStartPrice() == Integer.parseInt(flexibleDiscountString[0])
                            && fdContainerList.get(i).getEndPrice() == Integer.parseInt(flexibleDiscountString[1])
                            && fdContainerList.get(i).getPercentage() == Float.parseFloat(flexibleDiscountString[2])) {
                        fdContainerList.remove(i);
                        System.out.println("Deleted");
                    }
                }
            }

            flexible_discount_cmbo.setSelectedItem(null);
        }
    }//GEN-LAST:event_flexible_discount_delete_btnActionPerformed

    public void reset() {
        name_txt.setText("");
        email_txt.setText("");
        phone_txt.setText("");
        address_txt.setText("");
        postcode_txt.setText("");

        discountPercent_txt.setText("");

        vehicle_cmbo.removeAllItems();
        flexible_discount_cmbo.removeAllItems();

        customerType_cmbo.setSelectedItem("Casual");

        vehicleList.clear();
        fdContainerList.clear();
        cust = null;
        accHolder = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateCustCardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateCustCardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateCustCardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateCustCardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
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
                new CreateCustCardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address_lbl;
    private javax.swing.JTextField address_txt;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField contact_txt;
    private javax.swing.JLabel createCustomer_lbl;
    private javax.swing.JButton create_btn;
    private javax.swing.JComboBox<String> customerType_cmbo;
    private javax.swing.JLabel customerType_lbl;
    private javax.swing.JLabel discountPercent_lbl;
    private javax.swing.JTextField discountPercent_txt;
    private javax.swing.JComboBox<String> discountType_cmbo;
    private javax.swing.JLabel discountType_lbl;
    private javax.swing.JLabel discount_lbl;
    private javax.swing.JLabel email_lbl;
    private javax.swing.JTextField email_txt;
    private javax.swing.JButton flexible_discount_add_btn;
    private javax.swing.JComboBox<String> flexible_discount_cmbo;
    private javax.swing.JButton flexible_discount_delete_btn;
    private javax.swing.JLabel individualTask_lbl;
    private javax.swing.JTextField individualTask_txt;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel motPercent_lbl;
    private javax.swing.JTextField motPercent_txt;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField name_txt;
    private javax.swing.JComboBox<String> payLater_cmbo;
    private javax.swing.JLabel payLater_lbl;
    private javax.swing.JLabel phone_lbl;
    private javax.swing.JTextField phone_txt;
    private javax.swing.JLabel postcode_lbl;
    private javax.swing.JLabel postcode_lbl1;
    private javax.swing.JTextField postcode_txt;
    private javax.swing.JLabel spareParts_lbl;
    private javax.swing.JTextField spareParts_txt;
    private javax.swing.JButton vehicle_add_btn;
    private javax.swing.JComboBox<String> vehicle_cmbo;
    private javax.swing.JButton vehicle_delete_btn;
    private javax.swing.JLabel vehicle_lbl;
    // End of variables declaration//GEN-END:variables

    class CustomerTypeItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object item = e.getItem();
                if (item == "Account Holder") {
                    discount_lbl.setVisible(true);
                    discountType_lbl.setVisible(true);
                    discountPercent_lbl.setVisible(true);
                    payLater_lbl.setVisible(true);

                    discountType_cmbo.setVisible(true);
                    discountPercent_txt.setVisible(true);
                    payLater_cmbo.setVisible(true);

                } else {
                    discount_lbl.setVisible(false);
                    discountType_lbl.setVisible(false);
                    discountPercent_lbl.setVisible(false);
                    motPercent_lbl.setVisible(false);
                    individualTask_lbl.setVisible(false);
                    spareParts_lbl.setVisible(false);
                    payLater_lbl.setVisible(false);

                    discountType_cmbo.setVisible(false);
                    discountPercent_txt.setVisible(false);
                    motPercent_txt.setVisible(false);
                    individualTask_txt.setVisible(false);
                    spareParts_txt.setVisible(false);
                    payLater_cmbo.setVisible(false);
                    
                    flexible_discount_cmbo.setVisible(false);
                    flexible_discount_add_btn.setVisible(false);
                    flexible_discount_delete_btn.setVisible(false);
                }
            }
        }
    }

    class DiscountTypeItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object item = e.getItem();
                if (item == "Fixed Discount" || item == "Variable Discount") {
                    discountPercent_lbl.setVisible(true);
                    discountPercent_txt.setVisible(true);
                } else {
                    discountPercent_lbl.setVisible(false);
                    discountPercent_txt.setVisible(false);
                }

                if (item == "Variable Discount") {
                    motPercent_lbl.setVisible(true);
                    individualTask_lbl.setVisible(true);
                    spareParts_lbl.setVisible(true);
                    motPercent_txt.setVisible(true);
                    individualTask_txt.setVisible(true);
                    spareParts_txt.setVisible(true);

                    payLater_lbl.setLocation(395, 403);
                    payLater_cmbo.setLocation(532, 402);
                } else {
                    motPercent_lbl.setVisible(false);
                    individualTask_lbl.setVisible(false);
                    spareParts_lbl.setVisible(false);
                    motPercent_txt.setVisible(false);
                    individualTask_txt.setVisible(false);
                    spareParts_txt.setVisible(false);

                    payLater_lbl.setLocation(395, 253);
                    payLater_cmbo.setLocation(532, 250);
                }

                if (item == "Flexible Discount") {
                    flexible_discount_add_btn.setLocation(532, 208);
                    flexible_discount_delete_btn.setLocation(612, 208);
                    flexible_discount_cmbo.setLocation(532, 245);
                    flexible_discount_cmbo.setVisible(true);
                    flexible_discount_add_btn.setVisible(true);
                    flexible_discount_delete_btn.setVisible(true);
                    
                    payLater_lbl.setLocation(395, 293);
                    payLater_cmbo.setLocation(532, 290);
                } else {
                    flexible_discount_cmbo.setVisible(false);
                    flexible_discount_add_btn.setVisible(false);
                    flexible_discount_delete_btn.setVisible(false);
                }
            }

        }
    }

    public final class LengthRestrictedDocument extends PlainDocument {

        private final int limit;

        public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offs, str, a);
            }
        }
    }
}
