/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.*;
import Report.*;
import com.itextpdf.layout.Document;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jly09
 */
public class ReportForm extends javax.swing.JFrame {

    Control control;
    FranchiseeMenuForm franchiseeMenuForm = null;
    ForepersonMenuForm fpMenuForm = null;
    ReceptionistMenuForm receptionMenuForm = null;

    String selectedCmbo = null;
    String exSelectedCmbo = null;

    List<ReportFile> fileList = new ArrayList<>();
    NumOfVehicles numVehicle = null;

    /**
     * Creates new form MenuForm
     */
    public ReportForm() {
        initComponents();
    }

    public ReportForm(Control c, FranchiseeMenuForm fmf) {
        initComponents();

        this.setSize(new Dimension(1060, 700));
        this.setPreferredSize(new Dimension(1060, 700));
        this.setMinimumSize(new Dimension(1060, 700));

        control = c;
        franchiseeMenuForm = fmf;

        control.getWindowList().add(this);

        selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
        exSelectedCmbo = String.valueOf(ext_filter_cmbo.getSelectedItem());

        xext_filter_cmbo.setVisible(false);
        filter_txt.setVisible(false);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public ReportForm(Control c, ForepersonMenuForm fpmf) {
        initComponents();

        this.setSize(new Dimension(1060, 700));
        this.setPreferredSize(new Dimension(1060, 700));
        this.setMinimumSize(new Dimension(1060, 700));

        control = c;
        fpMenuForm = fpmf;

        control.getWindowList().add(this);

        selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
        exSelectedCmbo = String.valueOf(ext_filter_cmbo.getSelectedItem());

        xext_filter_cmbo.setVisible(false);
        filter_txt.setVisible(false);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public ReportForm(Control c, ReceptionistMenuForm rmf) {
        initComponents();

        this.setSize(new Dimension(1060, 700));
        this.setPreferredSize(new Dimension(1060, 700));
        this.setMinimumSize(new Dimension(1060, 700));

        control = c;
        receptionMenuForm = rmf;

        control.getWindowList().add(this);

        filter_cmbo.setSelectedItem("Spare Parts");
        filter_cmbo.setEnabled(false);
        ext_filter_cmbo.setVisible(false);

        selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
        exSelectedCmbo = String.valueOf(ext_filter_cmbo.getSelectedItem());

        xext_filter_cmbo.setVisible(false);
        filter_txt.setVisible(false);

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

        logout_btn = new javax.swing.JButton();
        filter_txt = new javax.swing.JTextField();
        displayPrint_btn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        report_tbl = new javax.swing.JTable();
        print_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        report_lbl = new javax.swing.JLabel();
        filter_lbl = new javax.swing.JLabel();
        filter_cmbo = new javax.swing.JComboBox<>();
        ext_filter_cmbo = new javax.swing.JComboBox<>();
        open_btn = new javax.swing.JButton();
        sort_btn = new javax.swing.JButton();
        xext_filter_cmbo = new javax.swing.JComboBox<>();
        generate_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        getContentPane().add(logout_btn);
        logout_btn.setBounds(950, 13, 71, 25);
        getContentPane().add(filter_txt);
        filter_txt.setBounds(377, 154, 88, 25);

        displayPrint_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        displayPrint_btn.setText("Display and Print");
        getContentPane().add(displayPrint_btn);
        displayPrint_btn.setBounds(52, 83, 178, 29);

        report_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "Date Created"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(report_tbl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(52, 198, 937, 326);

        print_btn.setText("Print");
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });
        getContentPane().add(print_btn);
        print_btn.setBounds(887, 542, 102, 44);

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn);
        back_btn.setBounds(884, 13, 59, 25);

        report_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        report_lbl.setText("Report");
        getContentPane().add(report_lbl);
        report_lbl.setBounds(52, 54, 52, 22);

        filter_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filter_lbl.setText("Filter");
        getContentPane().add(filter_lbl);
        filter_lbl.setBounds(52, 155, 38, 22);

        filter_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. of Vehicles", "Spare Parts", "Avg. Time per Job" }));
        filter_cmbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filter_cmboItemStateChanged(evt);
            }
        });
        getContentPane().add(filter_cmbo);
        filter_cmbo.setBounds(120, 156, 122, 22);

        ext_filter_cmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Overall", "By Job Type", "By Month", "By Customer" }));
        ext_filter_cmbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ext_filter_cmboItemStateChanged(evt);
            }
        });
        getContentPane().add(ext_filter_cmbo);
        ext_filter_cmbo.setBounds(260, 156, 99, 22);

        open_btn.setText("Open");
        open_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_btnActionPerformed(evt);
            }
        });
        getContentPane().add(open_btn);
        open_btn.setBounds(52, 542, 102, 44);

        sort_btn.setText("Sort");
        sort_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort_btnActionPerformed(evt);
            }
        });
        getContentPane().add(sort_btn);
        sort_btn.setBounds(377, 155, 57, 25);

        xext_filter_cmbo.setPreferredSize(new java.awt.Dimension(99, 22));
        getContentPane().add(xext_filter_cmbo);
        xext_filter_cmbo.setBounds(377, 156, 99, 22);

        generate_btn.setText("Generate");
        generate_btn.setPreferredSize(new java.awt.Dimension(59, 25));
        generate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_btnActionPerformed(evt);
            }
        });
        getContentPane().add(generate_btn);
        generate_btn.setBounds(770, 542, 102, 44);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sort_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort_btnActionPerformed
        try {
            checkForDirectory();
            if (filter_cmbo.getSelectedItem() == "Spare Parts") {
                File odir = new File("Reports/Spare Parts");
                listFilesFromDirectory(odir);
            }
            if (filter_cmbo.getSelectedItem() == "Avg. Time Per Job") {

            }
            if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
                if (ext_filter_cmbo.getSelectedItem() == "Overall") {
                    File odir = new File("Reports/No. of Vehicles/Overall");
                    listFilesFromDirectory(odir);

                }
                if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {

                }
                if (ext_filter_cmbo.getSelectedItem() == "By Customer") {

                }
                if (ext_filter_cmbo.getSelectedItem() == "By Date") {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_sort_btnActionPerformed

    private void filter_cmboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filter_cmboItemStateChanged
        if (fpMenuForm != null || franchiseeMenuForm != null) {
            if (!selectedCmbo.equals(filter_cmbo.getSelectedItem())) {
                selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
                if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
                    ext_filter_cmbo.removeAllItems();
                    ext_filter_cmbo.addItem("Overall");
                    ext_filter_cmbo.addItem("By Month");
                    ext_filter_cmbo.addItem("By Job Type");
                    ext_filter_cmbo.addItem("By Customer");
                }
                if (filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
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
                xext_filter_cmbo.setVisible(false);
                filter_txt.setVisible(false);
            }
        }

        if (receptionMenuForm != null) {

        }
    }//GEN-LAST:event_filter_cmboItemStateChanged

    private void ext_filter_cmboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ext_filter_cmboItemStateChanged
        if (fpMenuForm != null || franchiseeMenuForm != null) {
            if (!selectedCmbo.equals(ext_filter_cmbo.getSelectedItem())) {
                if (filter_cmbo.getSelectedItem() == "No. of Vehicles") {
                    if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {
                        xext_filter_cmbo.removeAllItems();
                        xext_filter_cmbo.addItem("MOT");
                        xext_filter_cmbo.addItem("Annual Service");
                        xext_filter_cmbo.addItem("Repair");
                        xext_filter_cmbo.setVisible(true);
                    } else if (ext_filter_cmbo.getSelectedItem() == "By Customer") {
                        xext_filter_cmbo.removeAllItems();
                        xext_filter_cmbo.addItem("Casual");
                        xext_filter_cmbo.addItem("Account Holder");
                        xext_filter_cmbo.setVisible(true);
                    } else {
                        xext_filter_cmbo.setVisible(false);
                    }

                }
                if (filter_cmbo.getSelectedItem() == "Avg. Time per Job") {
                    if (ext_filter_cmbo.getSelectedItem() == "By Job Type") {
                        xext_filter_cmbo.removeAllItems();
                        xext_filter_cmbo.addItem("MOT");
                        xext_filter_cmbo.addItem("Annual Service");
                        xext_filter_cmbo.addItem("Repair");
                        xext_filter_cmbo.setVisible(true);
                    }
                    if (ext_filter_cmbo.getSelectedItem() == "Mechanic") {
                        xext_filter_cmbo.setVisible(false);
                        filter_txt.setVisible(true);
                    } else {
                        xext_filter_cmbo.setVisible(true);
                        filter_txt.setVisible(false);
                    }
                    if (ext_filter_cmbo.getSelectedItem() == "Overall") {
                        xext_filter_cmbo.setVisible(false);
                        filter_txt.setVisible(false);
                    }

                }
                selectedCmbo = String.valueOf(filter_cmbo.getSelectedItem());
            }

            if (xext_filter_cmbo.isVisible() || filter_txt.isVisible()) {
                System.out.println("Yes");
                sort_btn.setLocation(490, 154);
            } else {
                System.out.println("No");
                sort_btn.setLocation(375, 154);
            }
        }

    }//GEN-LAST:event_ext_filter_cmboItemStateChanged

    private void generate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_btnActionPerformed
        try {
            checkForDirectory();
            if (filter_cmbo.getSelectedItem().equals("No. of Vehicles")) {
                if (ext_filter_cmbo.getSelectedItem().equals("Overall")) {
                    try {
                        numVehicle = new NumOfVehicles("", new Date(), "Overall", control.NumOfVehicles());
                        File odir = new File("Reports/No. of Vehicles/Overall");
                        listFilesFromDirectory(odir);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
            if (filter_cmbo.getSelectedItem().equals("Spare Parts")) {
                try {
                    GenerateStock generateStock = new GenerateStock("", new Date(), control.GenerateStock());
                    File odir = new File("Reports/Spare Parts");
                    listFilesFromDirectory(odir);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_generate_btnActionPerformed

    private void open_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_btnActionPerformed
        if (!report_tbl.getSelectionModel().isSelectionEmpty()) {
            int selectedRow = report_tbl.getSelectedRow();

            for (int i = 0; i < fileList.size(); i++) {
                if (fileList.get(i).getFileName().equals(report_tbl.getValueAt(selectedRow, 0))) {
                    try {
                        File reportFile = new File(fileList.get(i).getFilePath());
                        Desktop.getDesktop().open(reportFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }//GEN-LAST:event_open_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        control.OpenMenu();
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        control.logout();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed
        if (!report_tbl.getSelectionModel().isSelectionEmpty()) {
            int selectedRow = report_tbl.getSelectedRow();

            for (int i = 0; i < fileList.size(); i++) {
                if (fileList.get(i).getFileName().equals(report_tbl.getValueAt(selectedRow, 0))) {
                    try {
                        File reportFile = new File(fileList.get(i).getFilePath());
                        Desktop.getDesktop().open(reportFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }//GEN-LAST:event_print_btnActionPerformed

    public void listFilesFromDirectory(final File folder) {
        String fileName = null;
        String fileDate = null;
        String subName = null;
        String subDate = null;
        String[] dateSubArray = null;
        String dateFormatted = null;

        DefaultTableModel model = (DefaultTableModel) report_tbl.getModel();
        model.setRowCount(0);

        try {
            for (final File fileEntry : folder.listFiles()) {
                Path p = Paths.get(fileEntry.getPath());

                if (fileEntry.isDirectory()) {
                    listFilesFromDirectory(fileEntry);
                } else {
                    BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
                    fileName = fileEntry.getName();
                    subName = fileName.substring(0, fileName.lastIndexOf("."));

                    fileDate = String.valueOf(attr.creationTime());
                    subDate = fileDate.substring(0, fileDate.indexOf("T"));
                    dateSubArray = subDate.split("[-]");
                    dateFormatted = dateSubArray[2] + "/" + dateSubArray[1] + "/" + dateSubArray[0];

                    fileList.add(new ReportFile(subName, dateFormatted, fileEntry.getAbsolutePath()));

                    model.addRow(new Object[]{subName, dateFormatted});
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkForDirectory() {
        try {
            File f = new File("Reports");
            if (!f.exists()) {
                f.mkdir();
            }

            if (filter_cmbo.getSelectedItem().equals("No. of Vehicles")) {
                File vdir = new File("Reports/No. of Vehicles");
                vdir.mkdir();

                if (ext_filter_cmbo.getSelectedItem().equals("Overall")) {
                    File odir = new File("Reports/No. of Vehicles/Overall");
                    odir.mkdir();

                }

                if (ext_filter_cmbo.getSelectedItem().equals("By Job Type")) {
                    File odir = new File("Reports/No. of Vehicles/By Job Type");
                    odir.mkdir();

                    if (xext_filter_cmbo.getSelectedItem().equals("MOT")) {
                        File mdir = new File("Reports/No. of Vehicles/By Job Type/Mot");
                        mdir.mkdir();
                    }

                    if (xext_filter_cmbo.getSelectedItem().equals("Annual Service")) {
                        File mdir = new File("Reports/No. of Vehicles/By Job Type/Annual Service");
                        mdir.mkdir();
                    }

                    if (xext_filter_cmbo.getSelectedItem().equals("Repair")) {
                        File mdir = new File("Reports/No. of Vehicles/By Job Type/Repair");
                        mdir.mkdir();
                    }

                }

                if (ext_filter_cmbo.getSelectedItem().equals("Customer")) {
                    File odir = new File("Reports/No. of Vehicles/Customer");
                    odir.mkdir();

                    if (xext_filter_cmbo.getSelectedItem().equals("Casual")) {
                        File mdir = new File("Reports/No. of Vehicles/Customer/Casual");
                        mdir.mkdir();
                    }

                    if (xext_filter_cmbo.getSelectedItem().equals("Account Holder")) {
                        File mdir = new File("Reports/No. of Vehicles/Customer/Account Holder");
                        mdir.mkdir();
                    }

                }

            }

            if (filter_cmbo.getSelectedItem().equals("Avg. Time Per Job")) {
                if (!f.exists()) {
                    f.mkdir();
                }

                File vdir = new File("Reports/Avg. Time Per Job");
                vdir.mkdir();

                if (ext_filter_cmbo.getSelectedItem().equals("Overall")) {
                    if (!vdir.exists()) {
                        vdir.mkdir();
                    }

                    File odir = new File("Reports/Avg. Time Per Job/Overall");
                    odir.mkdir();

                }

                if (ext_filter_cmbo.getSelectedItem().equals("By Job Type")) {
                    File odir = new File("Reports/Avg. Time Per Job/By Job Type");
                    odir.mkdir();

                    if (xext_filter_cmbo.getSelectedItem().equals("MOT")) {
                        File mdir = new File("Reports/Avg. Time Per Job/By Job Type/Mot");
                        mdir.mkdir();
                    }

                    if (xext_filter_cmbo.getSelectedItem().equals("Annual Service")) {
                        File mdir = new File("Reports/Avg. Time Per Job/By Job Type/Annual Service");
                        mdir.mkdir();
                    }

                    if (xext_filter_cmbo.getSelectedItem().equals("Repair")) {
                        File mdir = new File("Reports/Avg. Time Per Job/By Job Type/Repair");
                        mdir.mkdir();
                    }

                }

                if (ext_filter_cmbo.getSelectedItem().equals("Mechanic")) {
                    File odir = new File("Reports/Avg. Time Per Job/Mechanic");
                    odir.mkdir();

                    String mechanic = filter_txt.getSelectedText();

                    File mdir = new File("Reports/Avg. Timer Per Job/Mechanic/" + mechanic);
                    mdir.mkdir();

                }

            }

            if (filter_cmbo.getSelectedItem().equals("Spare Parts")) {
                if (!f.exists()) {
                    f.mkdir();
                }

                File vdir = new File("Reports/Spare Parts");
                vdir.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ReportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel displayPrint_btn;
    private javax.swing.JComboBox<String> ext_filter_cmbo;
    private javax.swing.JComboBox<String> filter_cmbo;
    private javax.swing.JLabel filter_lbl;
    private javax.swing.JTextField filter_txt;
    private javax.swing.JButton generate_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton open_btn;
    private javax.swing.JButton print_btn;
    private javax.swing.JLabel report_lbl;
    private javax.swing.JTable report_tbl;
    private javax.swing.JButton sort_btn;
    private javax.swing.JComboBox<String> xext_filter_cmbo;
    // End of variables declaration//GEN-END:variables

    class ReportFile {

        String fileName;
        String fileDate;
        String filePath;

        public ReportFile(String fn, String fd, String fp) {
            fileName = fn;
            fileDate = fd;
            filePath = fp;
        }

        public ReportFile() {

        }

        public void setFileName(String fn) {
            fileName = fn;
        }

        public void setFileDate(String fd) {
            fileDate = fd;
        }

        public void setFilePath(String fp) {
            filePath = fp;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFileDate() {
            return fileDate;
        }

        public String getFilePath() {
            return filePath;
        }

    }
}
