/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 *
 * @author DeeptoTV
 */
public class Retrieve extends javax.swing.JFrame {

    /**
     * Creates new form Retrieve
     */
    ResultSet rs_archive;
    Connection conn_archive = null;
    CallableStatement stored_pro = null;
    Statement statement_archive = null;
    PreparedStatement pst; 
    String username = "";
    public void create_archive_connection()
    {
        conn_archive = ConnectDB_test.connectDb();
    }
    public Retrieve() {
        initComponents();
        
    }
    public Retrieve(String username) {
        this.username = username;
        initComponents();
        
    }
    public void execRetrieve(String filename)
    {
        String execRetrieveCommand = null;
        
        execRetrieveCommand = "tar xvf /dev/st0 -C /u01/restore archive/"+filename; 
        
        Process proc = null;
        String output = null;
         try {

            ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", execRetrieveCommand);
            builder.redirectErrorStream(true);
            proc = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            output = reader.readLine();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pgmName_textfield = new javax.swing.JTextField();
        Search_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tapeId_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pgmList_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        archive_date_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        archiever_name_label = new javax.swing.JLabel();
        restore_button = new javax.swing.JButton();
        user_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pgmName_textfield.setBackground(new java.awt.Color(51, 51, 51));
        pgmName_textfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pgmName_textfield.setForeground(new java.awt.Color(255, 255, 255));

        Search_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Search_button.setText("search");
        Search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_buttonActionPerformed(evt);
            }
        });

        tapeId_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tape Id"
            }
        ));
        tapeId_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tapeId_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tapeId_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pgmName_textfield)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgmName_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(Search_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pgmList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Program Name", "Size (Bytes)"
            }
        ));
        pgmList_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pgmList_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pgmList_table);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Archive Date :");

        archive_date_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        archive_date_label.setForeground(new java.awt.Color(204, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name : ");

        archiever_name_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        archiever_name_label.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(archive_date_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archiever_name_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(archive_date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archiever_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        restore_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        restore_button.setText("Restore");
        restore_button.setEnabled(false);
        restore_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restore_buttonActionPerformed(evt);
            }
        });

        user_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_label.setForeground(new java.awt.Color(153, 0, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(restore_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restore_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_buttonActionPerformed
        // TODO add your handling code here:
        
        String prog_name_search = pgmName_textfield.getText();
        String sql = "";
        create_archive_connection();
        try
        {
            statement_archive = conn_archive.createStatement();
            sql = "select distinct tape_id from archive where  program_name COLLATE UTF8_GENERAL_CI like '%"+prog_name_search+"%' order by program_name";
            System.out.println(sql);
            rs_archive = statement_archive.executeQuery(sql);
            this.tapeId_table.setModel(DbUtils.resultSetToTableModel(rs_archive));
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                conn_archive.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_Search_buttonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        /*
        user_label.setText(username);
       DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Used", 20);
        dataset.setValue("UnUsed", 80);
        
        
        JFreeChart chart3 = ChartFactory.createPieChart3D("Tape status", dataset, true, true, true);
        PiePlot3D plot3 = (PiePlot3D) chart3.getPlot();
        plot3.setForegroundAlpha(0.6f);
        plot3.setCircular(true);
      
        ChartPanel p = new ChartPanel(chart3);
        jPanel3.add(p);
        p.setSize(310,230);
        p.setVisible(true);
        */
    }//GEN-LAST:event_formWindowOpened

    private void tapeId_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tapeId_tableMouseClicked
        // TODO add your handling code here:
        Vector columnNames = new Vector();
        Vector data = new Vector();
        int columns = 0;
        String tape_id = tapeId_table.getModel().getValueAt(tapeId_table.getSelectedRow(), 0).toString();
        
        String sql = "",archive_date="",archiver_name = "";
        create_archive_connection();
        try
        {
            statement_archive = conn_archive.createStatement();
            sql = "select * from archive where tape_id = '"+tape_id+"'";
            rs_archive = statement_archive.executeQuery(sql);
            columnNames.addElement("File Name"); 
               columnNames.addElement("size(bytes)");
                // Get row data 
                
                while (rs_archive.next()) 
                { 
                     
                    Vector row = new Vector(columns);
                    row.addElement(rs_archive.getString("program_name")); 
                    row.addElement(rs_archive.getString("size"));
                    archive_date = rs_archive.getString("archive_date");
                    archiver_name = rs_archive.getString("archiver_name");
                    data.addElement(row); 
                    
                }
                // populated data into table 
                DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
                pgmList_table.setModel(tableModel);
                
                archive_date_label.setText(archive_date);
                archiever_name_label.setText(archiver_name);
           // this.pgmList_table.setModel(DbUtils.resultSetToTableModel(rs_archive));
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                conn_archive.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_tapeId_tableMouseClicked

    private void pgmList_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pgmList_tableMouseClicked
        // TODO add your handling code here:
        String pgm_name = pgmList_table.getModel().getValueAt(pgmList_table.getSelectedRow(), 0).toString();
        if(!pgm_name.isEmpty())
        {
            restore_button.setEnabled(true);
        }
    }//GEN-LAST:event_pgmList_tableMouseClicked

    private void restore_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restore_buttonActionPerformed
        // TODO add your handling code here:
        String filename = pgmList_table.getModel().getValueAt(pgmList_table.getSelectedRow(), 0).toString();
        execRetrieve(filename);
        //System.out.println(filename);
    }//GEN-LAST:event_restore_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Archive_Form archive_form = new Archive_Form(username);
        archive_form.setDefaultCloseOperation(archive_form.DISPOSE_ON_CLOSE);
        archive_form.setResizable(false);
        archive_form.pack();
        archive_form.setLocationRelativeTo(null);
        archive_form.setLocation(350, 150);
        archive_form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retrieve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search_button;
    private javax.swing.JLabel archiever_name_label;
    private javax.swing.JLabel archive_date_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pgmList_table;
    private javax.swing.JTextField pgmName_textfield;
    private javax.swing.JButton restore_button;
    private javax.swing.JTable tapeId_table;
    private javax.swing.JLabel user_label;
    // End of variables declaration//GEN-END:variables
}