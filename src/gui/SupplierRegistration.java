package gui;

//import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 * @author S.A. Sahan Sachintha (+94768701148) 
 */

public class SupplierRegistration extends javax.swing.JDialog {

    private String companyId;

    private GRN grn;
    public void setGrn(GRN grn) {
        this.grn = grn;
    }
    
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * Creates new form SupplierRegistration
     * @param parent
     * @param modal
     */
    public SupplierRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("POS");
        loadSuppliers("first_name", "ASC", "");
        jTextField1.setEditable(false);
        jButton3.setEnabled(false);
    }

    private void search() {
        String search = jTextField2.getText();
        switch (jComboBox1.getSelectedIndex()) {
            case 0 ->
                loadSuppliers("first_name", "ASC", search);
            case 1 ->
                loadSuppliers("first_name", "DESC", search);
            case 2 ->
                loadSuppliers("company`.`name", "ASC", search);
            case 3 ->
                loadSuppliers("company`.`name", "DESC", search);
            case 4 ->
                loadSuppliers("mobile", "ASC", search);
            case 5 ->
                loadSuppliers("mobile", "DESC", search);
        }
    }

    private void loadSuppliers(String column, String method, String mobile) {
        try {

            String query = "SELECT * FROM `supplier` INNER JOIN `company` ON `supplier`.`company_id`=`company`.`id` WHERE `mobile` LIKE '%" + mobile + "%' ORDER BY `" + column + "` " + method + "";
            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tModel = (DefaultTableModel) jTable1.getModel();
            tModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("company.name"));

                tModel.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        companyId = null;
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jLabel7.setText("0");
        jLabel8.setText("0");
        jComboBox1.setSelectedIndex(0);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jTable1.clearSelection();
        jButton1.requestFocus();
    }

    //public JTextField getNameField() {
    //    return jTextField1;
    //}
    //public JTextField getMobileField() {
    //    return jTextField2;
    //}
    public void setCompanyName(String name) {
        jTextField1.setText(name);
    }

    public void mobileFieldFocus() {
        jTextField2.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Email", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jButton1.setText("Select Company");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Suppliers");

        jLabel2.setText("Mobile");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Email");

        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Total GRN");

        jLabel9.setText("Pending Payment");

        jLabel10.setText("Sort By");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Company ASC", "Company DESC", "Mobile ASC", "Mobile DESC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CompanyRegistration companyRegistration = new CompanyRegistration(this, true);
        companyRegistration.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Update

        String mobile = jTextField2.getText();
        String fname = jTextField3.getText();
        String lname = jTextField4.getText();
        String email = jTextField5.getText();

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier First Name", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Email", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_=]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+=]+(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` WHERE `email`='" + email + "' AND `mobile`!='" + mobile + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Email already used", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField5.requestFocus();
                } else {

                    String x;
                    if (String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 4)).equals(jTextField1.getText())) {
                        // company update not required
                        x = "";
                    } else {
                        // company update required
                        x = ", `company_id`='" + companyId + "'";
                    }

                    String query = "UPDATE `supplier` SET "
                            + "`first_name`='" + fname + "', `last_name`='" + lname + "', `email`='" + email + "'" + x + " WHERE `mobile`='" + mobile + "'";
                    MySQL.execute(query);

                    jTextField2.setEditable(true);
                    loadSuppliers("first_name", "ASC", "");
                    reset();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Register

        String mobile = jTextField2.getText();
        String fname = jTextField3.getText();
        String lname = jTextField4.getText();
        String email = jTextField5.getText();

        if (companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select Company", "Warning", JOptionPane.ERROR_MESSAGE);
            jButton1.requestFocus();
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Mobile", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
        } else if (!mobile.matches("07[[0-2]|[4-8]]{1}[0-9]{7}")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier First Name", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Supplier Email", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_=]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+=]+(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`='" + mobile + "' OR `email`='" + email + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier already registered (Mobile or Email already exists)", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField2.requestFocus();
                } else {
                    String query = "INSERT INTO `supplier`(`mobile`,`first_name`,`last_name`,`email`,`company_id`) "
                            + "VALUES ('" + mobile + "','" + fname + "','" + lname + "','" + email + "','" + companyId + "')";
                    MySQL.execute(query);

                    loadSuppliers("first_name", "ASC", "");
                    reset();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        //Sort
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Reset
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        //Search
        search();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Select

        int row = jTable1.getSelectedRow();

        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 0)));
        jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 2)));
        jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 3)));
        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 4)));

        jTextField2.setEditable(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);
        
        if (evt.getClickCount() == 2) {
            if (grn != null) {
                grn.getjTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                grn.getjLabel3().setText(String.valueOf(jTable1.getValueAt(row, 1))+" "+String.valueOf(jTable1.getValueAt(row, 2)));
                this.dispose();
            }
        }

        try {

            String query = "SELECT *FROM `grn` INNER JOIN `grn_item` ON `grn`.`id`=`grn_item`.`grn_id` WHERE `supplier_mobile`='" + String.valueOf(jTable1.getValueAt(row, 0)) + "'";
            ResultSet resultSet = MySQL.execute(query);

            double total = 0;

            //String currentId = "";
            //int count = 0;
            //double totalPaidAmount = 0;

            HashMap<Long, Double> grns = new HashMap<>();

            while (resultSet.next()) {
                double qty = resultSet.getDouble("qty");
                double buying_price = resultSet.getDouble("buying_price");

                double itemTotal = qty * buying_price;

                total += itemTotal;

                //if (!currentId.equals(resultSet.getString("grn.id"))) {
                    //currentId = resultSet.getString("grn.id");
                    //count++;
                    //totalPaidAmount += resultSet.getDouble("grn.paid_amount");
                //}

                grns.put(resultSet.getLong("grn.id"), resultSet.getDouble("grn.paid_amount"));

            }
            
            int totalGrns = grns.size();
            double totalPaid = 0;
            for (Double paid : grns.values()) {
                totalPaid += paid;
            }
            
            //double pending = total - totalPaidAmount;
            double pending = total - totalPaid;
                        
            //System.out.println("Total Bought: "+ total);
            //System.out.println("Total Paid: "+ totalPaidAmount);
            //System.out.println("Total Paid: "+ totalPaid);
            jLabel8.setText(String.valueOf(pending));
            //System.out.println("Pending Payment: "+ pending);
            //System.out.println("Count: "+ count);
            jLabel7.setText(String.valueOf(totalGrns));
            //System.out.println("Count: "+ totalGrns);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //if (evt.getClickCount()) {}

    }//GEN-LAST:event_jTable1MouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//
//        FlatDarkPurpleIJTheme.setup();
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SupplierRegistration().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
