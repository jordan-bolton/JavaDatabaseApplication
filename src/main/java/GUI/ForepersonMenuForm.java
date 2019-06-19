/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.Control;
import java.awt.Dimension;

/**
 *
 * @author jly09
 */
public class ForepersonMenuForm extends javax.swing.JFrame {
    Control control = null;
    CreateJobForm createJobForm;
    JobForm jobForm;
    DisplayInvoiceForm displayInvoiceForm;
    DisplayAllParts displayAllParts;
    OrderPartForm orderPartForm;
    AddSupplierForm addSupplierForm;
    ReportForm reportForm;
    AddPartForm addPartForm;
    MotRemindersForm motRemindersForm;
    RemindersForm remindersForm;
    CreateCustCardForm createCustomerForm;
    CustomerForm customerForm;
    
    /**
     * Creates new form MenuForm
     */
    public ForepersonMenuForm() {
        initComponents();
        
        this.setSize(new Dimension(1520, 850));
        this.setPreferredSize(new Dimension(1520, 850));
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public ForepersonMenuForm(Control c) {
        initComponents();
        
        this.setSize(new Dimension(1520, 850));
        this.setPreferredSize(new Dimension(1520, 850));
        
        control = c;
        control.getWindowList().add(this);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void dispose() {
        super.dispose();
        control.terminateThread();
    }
    
    public void setControl(Control c) {
        control = c;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        displayUpdateJobs_btn = new javax.swing.JButton();
        orderParts_btn = new javax.swing.JButton();
        generateStockReport_btn = new javax.swing.JButton();
        addSupplier_btn = new javax.swing.JButton();
        displayPrintInvoice_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        createJob_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        displayUpdateParts_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addParts_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jobReminder_btn = new javax.swing.JButton();
        paymentReminder_btn = new javax.swing.JButton();
        createCustomer_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        customer_suad_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1130, 725));
        setSize(new java.awt.Dimension(1130, 725));
        getContentPane().setLayout(null);

        panel.setPreferredSize(new java.awt.Dimension(961, 811));

        displayUpdateJobs_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayUpdateJobs_btn.setText("Display and Update Jobs");
        displayUpdateJobs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayUpdateJobs_btnActionPerformed(evt);
            }
        });

        orderParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderParts_btn.setText("Order Parts");
        orderParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderParts_btnActionPerformed(evt);
            }
        });

        generateStockReport_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generateStockReport_btn.setText("Generate Stock Report");
        generateStockReport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateStockReport_btnActionPerformed(evt);
            }
        });

        addSupplier_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addSupplier_btn.setText("Add Supplier");
        addSupplier_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplier_btnActionPerformed(evt);
            }
        });

        displayPrintInvoice_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayPrintInvoice_btn.setText("Display and Print Invoice");
        displayPrintInvoice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayPrintInvoice_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Job");

        createJob_btn.setBackground(new java.awt.Color(255, 255, 255));
        createJob_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createJob_btn.setText("Create Job");
        createJob_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createJob_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJob_btnActionPerformed(evt);
            }
        });

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Invoice");

        displayUpdateParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayUpdateParts_btn.setText("Display and Update Parts");
        displayUpdateParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayUpdateParts_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Stock");

        addParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addParts_btn.setText("Add Parts");
        addParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParts_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Report");

        jobReminder_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jobReminder_btn.setText("Job Reminders");
        jobReminder_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobReminder_btnActionPerformed(evt);
            }
        });

        paymentReminder_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        paymentReminder_btn.setText("Payment Reminders");
        paymentReminder_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentReminder_btnActionPerformed(evt);
            }
        });

        createCustomer_btn.setBackground(new java.awt.Color(255, 255, 255));
        createCustomer_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createCustomer_btn.setText("Create Customer");
        createCustomer_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createCustomer_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCustomer_btnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Customer");

        customer_suad_btn.setBackground(new java.awt.Color(255, 255, 255));
        customer_suad_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customer_suad_btn.setText("Search, Update and Delete");
        customer_suad_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customer_suad_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_suad_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createCustomer_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_suad_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayUpdateJobs_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createJob_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobReminder_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addSupplier_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayUpdateParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paymentReminder_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(displayPrintInvoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(generateStockReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout_btn)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(223, 223, 223)
                .addComponent(jLabel3)
                .addGap(200, 200, 200)
                .addComponent(jLabel4)
                .addGap(190, 190, 190)
                .addComponent(jLabel5)
                .addGap(159, 159, 159))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_btn)
                .addGap(53, 53, 53)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(addParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(displayUpdateParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(displayPrintInvoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(generateStockReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(paymentReminder_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(orderParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(addSupplier_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createJob_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createCustomer_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customer_suad_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jobReminder_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(displayUpdateJobs_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        getContentPane().add(panel);
        panel.setBounds(0, 0, 1520, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateStockReport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateStockReport_btnActionPerformed
        reportForm = new ReportForm(control, this);
        reportForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_generateStockReport_btnActionPerformed

    private void addSupplier_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplier_btnActionPerformed
        addSupplierForm = new AddSupplierForm(control, this);
        addSupplierForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addSupplier_btnActionPerformed

    private void createJob_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createJob_btnActionPerformed
        createJobForm = new CreateJobForm(control, this);
        createJobForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createJob_btnActionPerformed

    private void displayUpdateJobs_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayUpdateJobs_btnActionPerformed
        jobForm = new JobForm(control, this);
        jobForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayUpdateJobs_btnActionPerformed

    private void displayPrintInvoice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayPrintInvoice_btnActionPerformed
        displayInvoiceForm = new DisplayInvoiceForm(control, this);
        displayInvoiceForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayPrintInvoice_btnActionPerformed

    private void displayUpdateParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayUpdateParts_btnActionPerformed
        displayAllParts = new DisplayAllParts(control, this);
        displayAllParts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayUpdateParts_btnActionPerformed

    private void orderParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderParts_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderParts_btnActionPerformed

    private void addParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParts_btnActionPerformed
        addPartForm = new AddPartForm(control, this);
        addPartForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addParts_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        control.logout();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void jobReminder_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobReminder_btnActionPerformed
        motRemindersForm = new MotRemindersForm(control, this);
        motRemindersForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jobReminder_btnActionPerformed

    private void paymentReminder_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentReminder_btnActionPerformed
        remindersForm = new RemindersForm(control, this);
        remindersForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_paymentReminder_btnActionPerformed

    private void createCustomer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCustomer_btnActionPerformed
        createCustomerForm = new CreateCustCardForm(control, this);
        createCustomerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createCustomer_btnActionPerformed

    private void customer_suad_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_suad_btnActionPerformed
        customerForm = new CustomerForm(control, this);
        customerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customer_suad_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ForepersonMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForepersonMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForepersonMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForepersonMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ForepersonMenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addParts_btn;
    private javax.swing.JButton addSupplier_btn;
    private javax.swing.JButton createCustomer_btn;
    private javax.swing.JButton createJob_btn;
    private javax.swing.JButton customer_suad_btn;
    private javax.swing.JButton displayPrintInvoice_btn;
    private javax.swing.JButton displayUpdateJobs_btn;
    private javax.swing.JButton displayUpdateParts_btn;
    private javax.swing.JButton generateStockReport_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jobReminder_btn;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton orderParts_btn;
    private javax.swing.JPanel panel;
    private javax.swing.JButton paymentReminder_btn;
    // End of variables declaration//GEN-END:variables
}