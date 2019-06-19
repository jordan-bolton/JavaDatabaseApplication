/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.Control;
import GUI.PartsTable.PartsTableModel;
import StockControl.Part;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jorda
 */
public class DisplayAllParts extends javax.swing.JFrame {

    Control control;
    ForepersonMenuForm fpMenuForm;
    FranchiseeMenuForm franchiseeMenuForm;
    ReceptionistMenuForm receptionMenuForm;
    UpdatePartForm updatePartForm;
    private PartsTableModel tableModel;
    private Part part;

    /**
     * Creates new form DisplayAllParts
     */
    public DisplayAllParts() {
        initComponents();
        tableModel = new PartsTableModel(part);
        partsTable.setModel(tableModel);
        // to search through parts
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });

    }

    public DisplayAllParts(Control c) {
        initComponents();

        control = c;
        control.getWindowList().add(this);

        tableModel = new PartsTableModel(part);
        partsTable.setModel(tableModel);
        // to search through parts
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });

    }

    DisplayAllParts(Control c, ForepersonMenuForm fpmf) {
        initComponents();

        control = c;
        fpMenuForm = fpmf;
        
        control.getWindowList().add(this);

        tableModel = new PartsTableModel(part);
        partsTable.setModel(tableModel);
        // to search through parts
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });
    }
    
    DisplayAllParts(Control c, FranchiseeMenuForm fmf) {
        initComponents();

        control = c;
        franchiseeMenuForm = fmf;
        
        control.getWindowList().add(this);

        tableModel = new PartsTableModel(part);
        partsTable.setModel(tableModel);
        // to search through parts
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });
    }
    
    DisplayAllParts(Control c, ReceptionistMenuForm rmf) {
        initComponents();

        control = c;
        receptionMenuForm = rmf;
        
        control.getWindowList().add(this);

        tableModel = new PartsTableModel(part);
        partsTable.setModel(tableModel);
        // to search through parts
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });
    }

    @Override
    public void dispose() {
        super.dispose();
        control.terminateThread();
    }

    // refreshes the table with the updated part fields
    private void populateTable() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(partsTable.getModel());
        partsTable.setRowSorter(rowSorter);

        //code that allows for parts to be searched and updated in real time
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = searchField.getText();

                if (input.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet");
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        partsTable = new javax.swing.JTable();
        updatePartButton = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display All Parts");
        setMinimumSize(new java.awt.Dimension(800, 640));
        setPreferredSize(new java.awt.Dimension(986, 698));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 640));

        partsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(partsTable);

        updatePartButton.setText("Update Selected Part");
        updatePartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePartButtonActionPerformed(evt);
            }
        });

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Search");

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Display and Update Parts");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Stock");

        logout_btn.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(updatePartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout_btn)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(logout_btn))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updatePartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePartButtonActionPerformed
        int selectedRow = partsTable.getSelectedRow();
        // gets the part object at the selected row
        Part selectedPart = tableModel.getParts().get(partsTable.convertRowIndexToModel(selectedRow));
        //System.out.println(selectedPart.toString());
        updatePartForm = new UpdatePartForm(control, this, selectedPart);
        //updatePartForm.setPart(selectedPart);
        updatePartForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        updatePartForm.setVisible(true);
        updatePartForm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                populateTable();

            }
        });


    }//GEN-LAST:event_updatePartButtonActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        control.OpenMenu();
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        control.logout();
        this.dispose();
    }//GEN-LAST:event_searchFieldActionPerformed

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
            java.util.logging.Logger.getLogger(DisplayAllParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayAllParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayAllParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayAllParts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayAllParts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTable partsTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updatePartButton;
    // End of variables declaration//GEN-END:variables
}
