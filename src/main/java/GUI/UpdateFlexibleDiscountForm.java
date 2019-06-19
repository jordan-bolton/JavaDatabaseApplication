/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.*;
import Account.FlexibleDiscountContainer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author jly09
 */
public class UpdateFlexibleDiscountForm extends javax.swing.JFrame {

    Control control = null;
    FlexibleDiscountContainer fdContainer = null;
    CreateCustCardForm custForm = null;
    UpdateCustomerForm updateCustForm = null;

    /**
     * Creates new form MenuForm
     */
    public UpdateFlexibleDiscountForm() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateFlexibleDiscountForm(Control c) {
        initComponents();

        control = c;
        control.getWindowList().add(this);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateFlexibleDiscountForm(CreateCustCardForm cForm) {
        initComponents();

        custForm = cForm;
    }

    public UpdateFlexibleDiscountForm(Control c, CreateCustCardForm cForm) {
        initComponents();

        control = c;
        custForm = cForm;

        control = c;

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateFlexibleDiscountForm(Control c, UpdateCustomerForm cForm) {
        initComponents();

        control = c;
        updateCustForm = cForm;

        control = c;

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

    public void setCustForm(CreateCustCardForm cForm) {
        custForm = cForm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addVehicle_lbl = new javax.swing.JLabel();
        add_btn = new javax.swing.JButton();
        regNum_lbl = new javax.swing.JLabel();
        make_lbl = new javax.swing.JLabel();
        startPrice_txt = new javax.swing.JTextField();
        endPrice_txt = new javax.swing.JTextField();
        back_btn = new javax.swing.JButton();
        percent_txt = new javax.swing.JTextField();
        make_lbl1 = new javax.swing.JLabel();
        make_lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addVehicle_lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addVehicle_lbl.setText("Add Flexible Discount");

        add_btn.setText("Add");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        regNum_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        regNum_lbl.setText("Start Price");

        make_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        make_lbl.setText("End Price");

        startPrice_txt.setToolTipText("Vehicle registration number");

        endPrice_txt.setToolTipText("Vehicle make");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        percent_txt.setToolTipText("Vehicle make");

        make_lbl1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        make_lbl1.setText("-");
        make_lbl1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        make_lbl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        make_lbl2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        make_lbl2.setText("Percentage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addVehicle_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(startPrice_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regNum_lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(make_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 181, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(make_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(endPrice_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(percent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(make_lbl2)
                                        .addGap(26, 26, 26)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(addVehicle_lbl))
                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(regNum_lbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startPrice_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(make_lbl1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(make_lbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(endPrice_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(make_lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(percent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        if (fdContainer == null) {
            fdContainer = new FlexibleDiscountContainer();
        }
        
        if (startPrice_txt.getText() != ""
                && endPrice_txt.getText() != ""
                && percent_txt.getText() != "") {

            fdContainer.setStartPrice(Integer.parseInt(startPrice_txt.getText()));
            fdContainer.setEndPrice(Integer.parseInt(endPrice_txt.getText()));
            fdContainer.setPercentage(Float.parseFloat(percent_txt.getText()));

            if (custForm != null && fdContainer != null) {
                custForm.getFDContainerList().add(fdContainer);
                custForm.getFDContainerComboBox().addItem(fdContainer.getStartPrice() + "," + fdContainer.getEndPrice() + "," + fdContainer.getPercentage());
                this.dispose();
            }

            if (updateCustForm != null && fdContainer != null) {
                updateCustForm.updateFixedDiscount(fdContainer);
                this.dispose();
            }

        }

    }//GEN-LAST:event_add_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        this.dispose();
        fdContainer = null;
    }//GEN-LAST:event_back_btnActionPerformed

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        
    }

    public void setValues(FlexibleDiscountContainer fdc) {
        fdContainer = fdc;

        System.out.println(String.valueOf(fdContainer.getStartPrice()));
        System.out.println(fdContainer.getEndPrice());
        System.out.println(fdContainer.getPercentage());

        startPrice_txt.setText(String.valueOf(fdContainer.getStartPrice()));
        endPrice_txt.setText(String.valueOf(fdContainer.getEndPrice()));
        percent_txt.setText(String.valueOf(fdContainer.getPercentage()));
        
        startPrice_txt.validate();
        startPrice_txt.repaint();
    }

    public FlexibleDiscountContainer getFlexibleDiscountContainer() {
        if (fdContainer != null) {
            return fdContainer;
        }
        return null;
    }

    public void resetText() {
        startPrice_txt.setText("");
        endPrice_txt.setText("");
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateFlexibleDiscountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFlexibleDiscountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFlexibleDiscountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFlexibleDiscountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UpdateFlexibleDiscountForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addVehicle_lbl;
    private javax.swing.JButton add_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField endPrice_txt;
    private javax.swing.JLabel make_lbl;
    private javax.swing.JLabel make_lbl1;
    private javax.swing.JLabel make_lbl2;
    private javax.swing.JTextField percent_txt;
    private javax.swing.JLabel regNum_lbl;
    private javax.swing.JTextField startPrice_txt;
    // End of variables declaration//GEN-END:variables

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
