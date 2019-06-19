/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.*;
import Account.Vehicle;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author jly09
 */
public class UpdateVehicleForm extends javax.swing.JFrame {

    Control control = null;
    Vehicle vehicle = null;
    CreateCustCardForm custForm = null;
    UpdateCustomerForm updateCustForm = null;

    /**
     * Creates new form MenuForm
     */
    public UpdateVehicleForm() {
        initComponents();

        regNum_txt.setDocument(new LengthRestrictedDocument(8));
        engine_serial_no_txt.setDocument(new LengthRestrictedDocument(10));
        chassisNo_txt.setDocument(new LengthRestrictedDocument(9));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateVehicleForm(Control c) {
        initComponents();

        control = c;
        regNum_txt.setDocument(new LengthRestrictedDocument(8));
        engine_serial_no_txt.setDocument(new LengthRestrictedDocument(10));
        chassisNo_txt.setDocument(new LengthRestrictedDocument(9));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateVehicleForm(Control c, CreateCustCardForm cForm) {
        initComponents();

        control = c;
        custForm = cForm;

        control.getWindowList().add(this);
        
        regNum_txt.setDocument(new LengthRestrictedDocument(8));
        engine_serial_no_txt.setDocument(new LengthRestrictedDocument(10));
        chassisNo_txt.setDocument(new LengthRestrictedDocument(9));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public UpdateVehicleForm(Control c, UpdateCustomerForm cForm) {
        initComponents();

        control = c;
        updateCustForm = cForm;

        control.getWindowList().add(this);
        regNum_txt.setDocument(new LengthRestrictedDocument(8));
        engine_serial_no_txt.setDocument(new LengthRestrictedDocument(10));
        chassisNo_txt.setDocument(new LengthRestrictedDocument(9));

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
        update_btn = new javax.swing.JButton();
        regNum_lbl = new javax.swing.JLabel();
        make_lbl = new javax.swing.JLabel();
        model_lbl = new javax.swing.JLabel();
        regNum_txt = new javax.swing.JTextField();
        make_txt = new javax.swing.JTextField();
        model_txt = new javax.swing.JTextField();
        colour_txt = new javax.swing.JTextField();
        colour_lbl = new javax.swing.JLabel();
        engine_serial_no_txt = new javax.swing.JTextField();
        engine_serial_no_lbl = new javax.swing.JLabel();
        chassisNo_lbl = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        chassisNo_txt = new javax.swing.JTextField();
        purchaseDate_txt = new javax.swing.JTextField();
        purchaseDate_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addVehicle_lbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addVehicle_lbl.setText("Update Vehicle");

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        regNum_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        regNum_lbl.setText("Reg No.");

        make_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        make_lbl.setText("Make");

        model_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        model_lbl.setText("Model");

        colour_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        colour_lbl.setText("Colour");

        engine_serial_no_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        engine_serial_no_lbl.setText("Engine Serial No.");

        chassisNo_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chassisNo_lbl.setText("Chassis No.");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        chassisNo_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chassisNo_txtActionPerformed(evt);
            }
        });

        purchaseDate_txt.setToolTipText("Vehicle purchase date (dd/mm/yyyy)");

        purchaseDate_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchaseDate_lbl.setText("Purchase Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(addVehicle_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(make_lbl)
                                                .addComponent(model_lbl)
                                                .addComponent(colour_lbl))
                                            .addGap(63, 63, 63)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(model_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                .addComponent(make_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(regNum_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(colour_txt)))
                                        .addComponent(regNum_lbl, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(chassisNo_lbl)
                                        .addComponent(purchaseDate_lbl))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chassisNo_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(purchaseDate_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(engine_serial_no_lbl)
                                .addGap(21, 21, 21)
                                .addComponent(engine_serial_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(addVehicle_lbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNum_lbl)
                    .addComponent(regNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(make_lbl)
                    .addComponent(make_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(model_lbl)
                    .addComponent(model_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colour_lbl)
                    .addComponent(colour_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(engine_serial_no_lbl)
                    .addComponent(engine_serial_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chassisNo_lbl)
                    .addComponent(chassisNo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseDate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseDate_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        vehicle = new Vehicle();
        if (regNum_txt.getText() != ""
                && make_txt.getText() != ""
                && model_txt.getText() != ""
                && engine_serial_no_txt.getText() != ""
                && chassisNo_txt.getText() != ""
                && colour_txt.getText() != ""
                && purchaseDate_txt.getText().matches("[0-9]{2}[0-9]{2}[0-9]{4}")) {

            Date date = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try {
                date = dateFormat.parse(purchaseDate_txt.getText());

            } catch (Exception e) {
                date = null;
            }

            if (date != null) {
                vehicle.setReg_num(regNum_txt.getText());
                vehicle.setMake(make_txt.getText());
                vehicle.setModel(model_txt.getText());
                vehicle.setEngine_serial_no(engine_serial_no_txt.getText());
                vehicle.setChassis_no(chassisNo_txt.getText());
                vehicle.setColour(colour_txt.getText());
                vehicle.setPurchase_date(purchaseDate_txt.getText());

                if (custForm != null && vehicle != null) {
                    custForm.getVehicleList().add(vehicle);
                    custForm.getVehicleComboBox().addItem(vehicle.getReg_num() + "," + vehicle.getMake() + "," + vehicle.getModel());
                    this.dispose();
                }

                if (updateCustForm != null && vehicle != null) {
                    updateCustForm.updateVehicle(vehicle);
                    this.dispose();
                }
            }

        }

    }//GEN-LAST:event_update_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        this.setVisible(false);
        vehicle = null;
    }//GEN-LAST:event_back_btnActionPerformed

    private void chassisNo_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chassisNo_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chassisNo_txtActionPerformed

    public void setValues(Vehicle v) {
        //resetText();
        vehicle = v;
        regNum_txt.setText(v.getReg_num());
        make_txt.setText(v.getMake());
        model_txt.setText(v.getModel());
        engine_serial_no_txt.setText(v.getEngine_serial_no());
        chassisNo_txt.setText(v.getChassis_no());
        colour_txt.setText(v.getColour());
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    public Vehicle getVehicle() {
        if (vehicle != null) {
            return vehicle;
        }
        return null;
    }

    public void resetText() {
        regNum_txt.setText("");
        make_txt.setText("");
        model_txt.setText("");
        engine_serial_no_txt.setText("");
        chassisNo_txt.setText("");
        colour_txt.setText("");
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
            java.util.logging.Logger.getLogger(UpdateVehicleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateVehicleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addVehicle_lbl;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel chassisNo_lbl;
    private javax.swing.JTextField chassisNo_txt;
    private javax.swing.JLabel colour_lbl;
    private javax.swing.JTextField colour_txt;
    private javax.swing.JLabel engine_serial_no_lbl;
    private javax.swing.JTextField engine_serial_no_txt;
    private javax.swing.JLabel make_lbl;
    private javax.swing.JTextField make_txt;
    private javax.swing.JLabel model_lbl;
    private javax.swing.JTextField model_txt;
    private javax.swing.JLabel purchaseDate_lbl;
    private javax.swing.JTextField purchaseDate_txt;
    private javax.swing.JLabel regNum_lbl;
    private javax.swing.JTextField regNum_txt;
    private javax.swing.JButton update_btn;
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
