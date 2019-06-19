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
public class FranchiseeMenuForm extends javax.swing.JFrame {
    Control control;
    CreateCustCardForm createCustomerForm;
    CustomerForm customerForm;
    ReportForm reportForm;
    CreateJobForm createJobForm;
    JobForm jobForm;
    DisplayReminderForm displayReminderForm;
    AddPartForm addPartForm;
    DisplayAllParts displayAllParts;
    OrderPartForm orderPartForm;
    AddSupplierForm addSupplierForm;
    DisplayInvoiceForm displayInvoiceForm;
    DisplayAlertForm displayAlertForm;
    AlertForm alertForm;
    MotRemindersForm motRemindersForm;
    RemindersForm remindersForm;
    CreateSparePartJobForm createSparePartForm;

    /**
     * Creates new form MenuForm
     */
    public FranchiseeMenuForm() {
        initComponents();
        
        this.setSize(new Dimension(1570, 680));
        this.setPreferredSize(new Dimension(1570, 680));

        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public FranchiseeMenuForm(Control c) {
        initComponents();
        
        this.setSize(new Dimension(1570, 680));
        this.setPreferredSize(new Dimension(1570, 680));

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
    
    public void hideGUI() {
        createCustomerForm.setVisible(false);
        customerForm.setVisible(false);
        reportForm.setVisible(false);
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
        logout_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        createCust_btn = new javax.swing.JButton();
        customer_suad_btn = new javax.swing.JButton();
        createJob_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        displayUpdateJobs_btn = new javax.swing.JButton();
        jobReminders_btn = new javax.swing.JButton();
        displayUpdateParts_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        orderParts_btn = new javax.swing.JButton();
        addSupplier_btn = new javax.swing.JButton();
        reports_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        displayAlerts_btn = new javax.swing.JButton();
        displayPrintInvoice_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addParts_btn = new javax.swing.JButton();
        paymentReminders_btn = new javax.swing.JButton();
        createSparePart_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Customer");

        createCust_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createCust_btn.setText("Create Customer");
        createCust_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCust_btnActionPerformed(evt);
            }
        });

        customer_suad_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customer_suad_btn.setText("Search, Update and Delete");
        customer_suad_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_suad_btnActionPerformed(evt);
            }
        });

        createJob_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createJob_btn.setText("Create Job");
        createJob_btn.setMaximumSize(new java.awt.Dimension(163, 31));
        createJob_btn.setMinimumSize(new java.awt.Dimension(163, 31));
        createJob_btn.setPreferredSize(new java.awt.Dimension(163, 31));
        createJob_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJob_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Job");

        displayUpdateJobs_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayUpdateJobs_btn.setText("Display and Update Jobs");
        displayUpdateJobs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayUpdateJobs_btnActionPerformed(evt);
            }
        });

        jobReminders_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jobReminders_btn.setText("Job Reminders");
        jobReminders_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobReminders_btnActionPerformed(evt);
            }
        });

        displayUpdateParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayUpdateParts_btn.setText("Display and Update Parts");
        displayUpdateParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayUpdateParts_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Stock");

        orderParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderParts_btn.setText("Order Parts");
        orderParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderParts_btnActionPerformed(evt);
            }
        });

        addSupplier_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addSupplier_btn.setText("Add Supplier");
        addSupplier_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplier_btnActionPerformed(evt);
            }
        });

        reports_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reports_btn.setText("Display, Generate, Print");
        reports_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reports_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Reports");

        displayAlerts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayAlerts_btn.setText("Display Alerts");
        displayAlerts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAlerts_btnActionPerformed(evt);
            }
        });

        displayPrintInvoice_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        displayPrintInvoice_btn.setText("Display and Print Invoices");
        displayPrintInvoice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayPrintInvoice_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Invoice/Alerts");

        addParts_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addParts_btn.setText("Add Parts");
        addParts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParts_btnActionPerformed(evt);
            }
        });

        paymentReminders_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        paymentReminders_btn.setText("Payment Reminders");
        paymentReminders_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentReminders_btnActionPerformed(evt);
            }
        });

        createSparePart_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createSparePart_btn.setText("Create Spare Parts Job");
        createSparePart_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSparePart_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(logout_btn)
                .addGap(78, 78, 78))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(customer_suad_btn)
                                .addGap(29, 29, 29)
                                .addComponent(displayUpdateJobs_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(createCust_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(createJob_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(390, 390, 390)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createSparePart_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobReminders_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSupplier_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayUpdateParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orderParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(displayPrintInvoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayAlerts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentReminders_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(reports_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel4)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel2)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel3)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel5))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_btn)
                .addGap(52, 52, 52)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createCust_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(createJob_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customer_suad_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayUpdateJobs_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jobReminders_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createSparePart_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(displayUpdateParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(orderParts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(addSupplier_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayPrintInvoice_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reports_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentReminders_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(displayAlerts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(panel);
        panel.setBounds(0, 0, 1560, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCust_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCust_btnActionPerformed
        createCustomerForm = new CreateCustCardForm(control, this);
        createCustomerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createCust_btnActionPerformed

    private void customer_suad_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_suad_btnActionPerformed
        customerForm = new CustomerForm(control, this);
        customerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customer_suad_btnActionPerformed

    private void addParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParts_btnActionPerformed
        addPartForm = new AddPartForm(control, this);
        addPartForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addParts_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        control.logout();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

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

    private void jobReminders_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobReminders_btnActionPerformed
        motRemindersForm = new MotRemindersForm(control, this);
        motRemindersForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jobReminders_btnActionPerformed

    private void displayUpdateParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayUpdateParts_btnActionPerformed
        displayAllParts = new DisplayAllParts(control, this);
        displayAllParts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayUpdateParts_btnActionPerformed

    private void orderParts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderParts_btnActionPerformed
        
    }//GEN-LAST:event_orderParts_btnActionPerformed

    private void addSupplier_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplier_btnActionPerformed
        addSupplierForm = new AddSupplierForm(control, this);
        addSupplierForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addSupplier_btnActionPerformed

    private void reports_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reports_btnActionPerformed
        reportForm = new ReportForm(control, this);
        reportForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reports_btnActionPerformed

    private void displayPrintInvoice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayPrintInvoice_btnActionPerformed
        displayInvoiceForm = new DisplayInvoiceForm(control, this);
        displayInvoiceForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayPrintInvoice_btnActionPerformed

    private void displayAlerts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAlerts_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayAlerts_btnActionPerformed

    private void paymentReminders_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentReminders_btnActionPerformed
       remindersForm = new RemindersForm(control, this);
       remindersForm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_paymentReminders_btnActionPerformed

    private void createSparePart_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSparePart_btnActionPerformed
        createSparePartForm = new CreateSparePartJobForm(control, this);
        createSparePartForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createSparePart_btnActionPerformed

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
            java.util.logging.Logger.getLogger(FranchiseeMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FranchiseeMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FranchiseeMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FranchiseeMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FranchiseeMenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addParts_btn;
    private javax.swing.JButton addSupplier_btn;
    private javax.swing.JButton createCust_btn;
    private javax.swing.JButton createJob_btn;
    private javax.swing.JButton createSparePart_btn;
    private javax.swing.JButton customer_suad_btn;
    private javax.swing.JButton displayAlerts_btn;
    private javax.swing.JButton displayPrintInvoice_btn;
    private javax.swing.JButton displayUpdateJobs_btn;
    private javax.swing.JButton displayUpdateParts_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jobReminders_btn;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton orderParts_btn;
    private javax.swing.JPanel panel;
    private javax.swing.JButton paymentReminders_btn;
    private javax.swing.JButton reports_btn;
    // End of variables declaration//GEN-END:variables
}