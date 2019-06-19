/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.*;

/**
 *
 * @author jly09
 */
public class GenerateReportForm extends javax.swing.JFrame {

    Control control;
    FranchiseeMenuForm franchiseeMenuForm = null;

    String selectedCmbo = null;
    String exSelectedCmbo = null;

    /**
     * Creates new form MenuForm
     */
    public GenerateReportForm() {
        initComponents();

        selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
        exSelectedCmbo = String.valueOf(ext_filter_cmbo.getSelectedItem());
    }

    public GenerateReportForm(Control c, FranchiseeMenuForm fmf) {
        initComponents();

        control = c;
        franchiseeMenuForm = fmf;
        
        control.getWindowList().add(this);
        
        selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
        exSelectedCmbo = String.valueOf(ext_filter_cmbo.getSelectedItem());
    }

    public void setControl(Control c) {
        control = c;
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
        generateReport_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        report_tbl = new javax.swing.JTable();
        print_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        filter_lbl = new javax.swing.JLabel();
        filter_cmbo = new javax.swing.JComboBox<>();
        ext_filter_cmbo = new javax.swing.JComboBox<>();
        generate_btn = new javax.swing.JButton();
        sort_btn = new javax.swing.JButton();
        xext_filter_cmbo = new javax.swing.JComboBox<>();
        filter_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        logout_btn.setText("Logout");
        getContentPane().add(logout_btn);
        logout_btn.setBounds(880, 13, 71, 25);

        generateReport_lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        generateReport_lbl.setText("Generate Report");
        getContentPane().add(generateReport_lbl);
        generateReport_lbl.setBounds(52, 83, 177, 29);

        report_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(report_tbl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(52, 198, 869, 326);

        print_btn.setText("Print");
        getContentPane().add(print_btn);
        print_btn.setBounds(819, 542, 102, 44);

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn);
        back_btn.setBounds(814, 13, 59, 25);

        filter_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filter_lbl.setText("Filter");
        getContentPane().add(filter_lbl);
        filter_lbl.setBounds(52, 155, 38, 22);

        filter_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. of Vehicles", "Stock", "Avg. Time per Job" }));
        filter_cmbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_cmboActionPerformed(evt);
            }
        });
        getContentPane().add(filter_cmbo);
        filter_cmbo.setBounds(120, 156, 122, 22);

        ext_filter_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By Job Type", "By Month", "By Customer" }));
        ext_filter_cmbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ext_filter_cmboActionPerformed(evt);
            }
        });
        getContentPane().add(ext_filter_cmbo);
        ext_filter_cmbo.setBounds(260, 156, 99, 22);

        generate_btn.setText("Generate");
        getContentPane().add(generate_btn);
        generate_btn.setBounds(699, 542, 102, 44);

        sort_btn.setText("Sort");
        sort_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort_btnActionPerformed(evt);
            }
        });
        getContentPane().add(sort_btn);
        sort_btn.setBounds(426, 155, 57, 25);

        xext_filter_cmbo.setPreferredSize(new java.awt.Dimension(99, 22));
        getContentPane().add(xext_filter_cmbo);
        xext_filter_cmbo.setBounds(377, 156, 99, 22);
        getContentPane().add(filter_txt);
        filter_txt.setBounds(380, 155, 88, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sort_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_btnActionPerformed
        if (filter_cmbo.getSelectedItem() == "Stock") {

        }
        if (filter_cmbo.getSelectedItem() == "Avg. Time Per Job") {

        }
        if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
            if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {

            }
            if (ext_filter_cmbo.getSelectedItem() == "By Customer") {

            }
            if (ext_filter_cmbo.getSelectedItem() == "By Date") {

            }
        }
    }//GEN-LAST:event_sort_btnActionPerformed

    private void filter_cmboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_cmboActionPerformed
        if (!selectedCmbo.equals(filter_cmbo.getSelectedItem())) {
            if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
                selectedCmbo = "No. of Vehicles";
                ext_filter_cmbo.removeAllItems();
                ext_filter_cmbo.addItem("Overall");
                ext_filter_cmbo.addItem("By Month");
                ext_filter_cmbo.addItem("By Job Type");
                ext_filter_cmbo.addItem("By Customer");
            }
            if (filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
                selectedCmbo = "Avg. Time per Job";
                ext_filter_cmbo.removeAllItems();
                ext_filter_cmbo.addItem("Overall");
                ext_filter_cmbo.addItem("By Job Type");
                ext_filter_cmbo.addItem("Mechanic");
            }
        }

        if (filter_cmbo.getSelectedItem() == "No. of Vehicles" || filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
            ext_filter_cmbo.setVisible(true);
            if (filter_cmbo.getSelectedItem() == "Avg. Time Per Job") {
                if (ext_filter_cmbo.getSelectedItem() == "Mechanic") {
                    xext_filter_cmbo.setVisible(false);
                    filter_txt.setVisible(true);
                } else {
                    xext_filter_cmbo.setVisible(true);
                    filter_txt.setVisible(false);
                }
            }
        } else {
            ext_filter_cmbo.setVisible(false);
        }

    }//GEN-LAST:event_filter_cmboActionPerformed

    private void ext_filter_cmboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ext_filter_cmboActionPerformed
        if (!selectedCmbo.equals(ext_filter_cmbo.getSelectedItem())) {
            if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
                if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {
                    xext_filter_cmbo.removeAllItems();
                    xext_filter_cmbo.addItem("MOT");
                    xext_filter_cmbo.addItem("Annual Service");
                    xext_filter_cmbo.addItem("Repair");
                }
                if (ext_filter_cmbo.getSelectedItem() == "By Customer") {
                    xext_filter_cmbo.removeAllItems();
                    xext_filter_cmbo.addItem("Casual");
                    xext_filter_cmbo.addItem("Account Holder");
                }
            }
            if (filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
                if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {
                    xext_filter_cmbo.removeAllItems();
                    xext_filter_cmbo.addItem("MOT");
                    xext_filter_cmbo.addItem("Annual Service");
                    xext_filter_cmbo.addItem("Repair");
                }
                
            }
            
        }
        if (filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
            if (ext_filter_cmbo.getSelectedItem() == "Mechanic") {
                xext_filter_cmbo.setVisible(false);
                filter_txt.setVisible(true);
            } else {
                xext_filter_cmbo.setVisible(true);
                filter_txt.setVisible(false);
            }
        }
        if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
            if (ext_filter_cmbo.getSelectedItem() == "") {
                
            }
        }
    }//GEN-LAST:event_ext_filter_cmboActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GenerateReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JComboBox<String> ext_filter_cmbo;
    private javax.swing.JComboBox<String> filter_cmbo;
    private javax.swing.JLabel filter_lbl;
    private javax.swing.JTextField filter_txt;
    private javax.swing.JLabel generateReport_lbl;
    private javax.swing.JButton generate_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton print_btn;
    private javax.swing.JTable report_tbl;
    private javax.swing.JButton sort_btn;
    private javax.swing.JComboBox<String> xext_filter_cmbo;
    // End of variables declaration//GEN-END:variables


}
