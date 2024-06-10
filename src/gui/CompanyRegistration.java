package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 * @author S.A. Sahan Sachintha (+94768701148) 
 */

public class CompanyRegistration extends javax.swing.JDialog {

    SupplierRegistration supplierRegistration;

    /**
     * Creates new form CompanyRegistration
     * @param parent
     * @param modal
     */
    public CompanyRegistration(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("POS");
        loadCompanies();
        supplierRegistration = (SupplierRegistration) parent;
        jButton2.setEnabled(false);

    }

    private void loadCompanies() {
        try {

            String query = "SELECT * FROM `company` ORDER BY `name` ASC";
            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tModel = (DefaultTableModel) jTable1.getModel();
            tModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("hotline"));
                tModel.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.requestFocus();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setText("Name");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Hotline");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Add

        String name = jTextField1.getText();
        String hotline = jTextField2.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Company Name", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
        } else if (hotline.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Company Hotline number", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
        } else if (!hotline.matches("^0((11)|(2(1|[3-7])|(3[1-8])|(4[1|5|7])|(5[1|2|4|5|7])|(6[3|[5-7]])|([8-9]1)))[0-9]{7}$")) {
            //} else if (!hotline.matches("^(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|912)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Hotline number", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
        } else {
            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `company` WHERE `name`='" + name + "' OR `hotline`='" + hotline + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Name or Hotline is already registered", "Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    String query = "INSERT INTO `company`(`name`,`hotline`) VALUES ('" + name + "', '" + hotline + "')";
                    MySQL.execute(query);

                    reset();
                    loadCompanies();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Update

        String name = jTextField1.getText();
        String hotline = jTextField2.getText();

        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select Company to update", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {

            int row = jTable1.getSelectedRow();
            String id = String.valueOf(jTable1.getValueAt(row, 0));

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Company Name", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField1.requestFocus();
            } else if (hotline.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Company Hotline number", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField2.requestFocus();
            } else if (!hotline.matches("^0((11)|(2(1|[3-7])|(3[1-8])|(4[1|5|7])|(5[1|2|4|5|7])|(6[3|[5-7]])|([8-9]1)))[0-9]{7}$")) {
                //} else if (!hotline.matches("^(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|912)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Hotline number", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField2.requestFocus();
            } else if (name.equals(String.valueOf(jTable1.getValueAt(row, 1))) && hotline.equals(String.valueOf(jTable1.getValueAt(row, 2)))) {
                JOptionPane.showMessageDialog(this, "Please change Name or Hotline to update", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                try {

                    ResultSet resultSet = MySQL.execute("SELECT * FROM `company` WHERE (`name`='" + name + "' OR `hotline`='" + hotline + "') AND `id`!='" + id + "'");
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Name or Hotline is already registered", "Warning", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String query = "UPDATE `company` SET `name`='" + name + "', `hotline`='" + hotline + "'";
                        MySQL.execute(query);

                        jTable1.clearSelection();
                        reset();
                        loadCompanies();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Select

        jButton2.setEnabled(true);

        int row = jTable1.getSelectedRow();

        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));

        jButton1.setEnabled(false);

        if (evt.getClickCount() == 2) {
            if (supplierRegistration != null) {
                supplierRegistration.setCompanyId(String.valueOf(jTable1.getValueAt(row, 0)));
                supplierRegistration.setCompanyName(String.valueOf(jTable1.getValueAt(row, 1)));
                this.dispose();
                supplierRegistration.mobileFieldFocus();
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CompanyRegistration dialog = new CompanyRegistration(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
