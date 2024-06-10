package gui;

//import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author S.A. Sahan Sachintha (+94768701148) 
 */

public class EmployeeRegistration extends javax.swing.JDialog {

    private final HashMap<String, String> employeeTypeMap = new HashMap<>();
    private final HashMap<String, String> employeeGenderMap = new HashMap<>();

    /**
     * Creates new form EmployeeRegistration
     * @param parent
     * @param modal
     */
    public EmployeeRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("POS");
        loadTypes();
        loadGender();
        loadEmployees();
        jButton2.setEnabled(false);
    }

    private void loadTypes() {
        try {
            String query = "SELECT * FROM `employee_type` ORDER BY `name` ASC";
            ResultSet resultSet = MySQL.execute(query);

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                employeeTypeMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel cModel = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(cModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGender() {
        try {
            String query = "SELECT * FROM `gender` ORDER BY `id` ASC";
            ResultSet resultSet = MySQL.execute(query);

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("name"));
                employeeGenderMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel cModel = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(cModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmployees() {
        try {

            String query = "SELECT * FROM `employee` "
                    + "INNER JOIN `employee_type` ON `employee`.`employee_type_id`=`employee_type`.`id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_id`=`gender`.`id` WHERE `nic`!='200415401542' ORDER BY `first_name` ASC";
            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tModel = (DefaultTableModel) jTable1.getModel();
            tModel.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("gender.name"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("employee_type.name"));
                vector.add(resultSet.getString("date_registered"));

                tModel.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField1.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Email");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("NIC");

        jLabel5.setText("Mobile");

        jLabel6.setText("Gender");

        jLabel7.setText("Password");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel8.setText("Type");

        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Employee Registration");

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type", "Registered Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Update
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Update

        try {

            String email = jTextField1.getText();
            String fname = jTextField2.getText();
            String lname = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());
            String type = String.valueOf(jComboBox2.getSelectedItem());

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee First Name", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField2.requestFocus();
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField3.requestFocus();
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField4.requestFocus();
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Mobile", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
            } else if (!mobile.matches("07[01245678]{1}[0-9]{7}")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Gender", "Warning", JOptionPane.ERROR_MESSAGE);
                jComboBox1.requestFocus();
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Password", "Warning", JOptionPane.ERROR_MESSAGE);
                jPasswordField1.requestFocus();
//            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
//                JOptionPane.showMessageDialog(this, "Password must contain minimum 8 characters, at least one UPPERCASE letter, one lowercase letter and one number", "Warning", JOptionPane.ERROR_MESSAGE);
//                jPasswordField1.requestFocus();
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Employee Type", "Warning", JOptionPane.ERROR_MESSAGE);
                jComboBox2.requestFocus();
            } else {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `nic`='" + nic + "' OR `mobile`='" + mobile + "'");

                boolean canUpdate = true;

                while (resultSet.next()) {

                    if (!resultSet.getString("email").equals(email)) {
                        canUpdate = false;

                        String result = "";

                        if (resultSet.getString("nic").equals(nic)) {
                            result += "NIC ";
                            jTextField4.requestFocus();

                            if (resultSet.getString("mobile").equals(mobile)) {
                                result += "and Mobile ";
                            }

                        } else {
                            result += "Mobile ";
                            jTextField5.requestFocus();
                        }

                        JOptionPane.showMessageDialog(this, result + "already used", "Warning", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }

                if (canUpdate) {
                    String query = "UPDATE `employee` SET `first_name`='" + fname + "', `last_name`='" + lname + "', "
                            + "`mobile`='" + mobile + "', `nic`='" + nic + "', `gender_id`='" + employeeGenderMap.get(gender) + "', "
                            + "`password`='" + password + "', `employee_type_id`='" + employeeTypeMap.get(type) + "' "
                            + "WHERE `email`='" + email + "'";
                    MySQL.execute(query);

                    loadEmployees();
                    reset();
                    jTable1.clearSelection();
                    jButton2.setEnabled(false);
                    jTextField1.setEditable(true);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Register
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Register

        try {

            String email = jTextField1.getText();
            String fname = jTextField2.getText();
            String lname = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());
            String type = String.valueOf(jComboBox2.getSelectedItem());

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Email", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField1.requestFocus();
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_=]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+=]+(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField1.requestFocus();
            } else if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee First Name", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField2.requestFocus();
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Last Name", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField3.requestFocus();
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField4.requestFocus();
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Mobile", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
            } else if (!mobile.matches("07[01245678]{1}[0-9]{7}")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Gender", "Warning", JOptionPane.ERROR_MESSAGE);
                jComboBox1.requestFocus();
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter employee Password", "Warning", JOptionPane.ERROR_MESSAGE);
                jPasswordField1.requestFocus();
//            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
//                JOptionPane.showMessageDialog(this, "Password must contain minimum 8 characters, at least one UPPERCASE letter, one lowercase letter and one number", "Warning", JOptionPane.ERROR_MESSAGE);
//                jPasswordField1.requestFocus();
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Employee Type", "Warning", JOptionPane.ERROR_MESSAGE);
                jComboBox2.requestFocus();
            } else {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `email`='" + email + "' OR `nic`='" + nic + "' OR `mobile`='" + mobile + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Email, Mobile or NIC already used", "Warning", JOptionPane.ERROR_MESSAGE);
                } else {

                    Date date = new Date();
                    SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");

                    String query = "INSERT INTO `employee`(`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`gender_id`,`employee_type_id`,`date_registered`,`status_id`) "
                            + "VALUES ('" + email + "','" + password + "','" + fname + "','" + lname + "','" + nic + "','" + mobile + "','" + employeeGenderMap.get(gender) + "','" + employeeTypeMap.get(type) + "','" + sDF.format(date) + "', '1')";

                    MySQL.execute(query);

                    loadEmployees();
                    reset();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    //Select
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 1) {

            jButton2.setEnabled(true);

            int row = jTable1.getSelectedRow();

            String email = String.valueOf(jTable1.getValueAt(row, 0));
            jTextField1.setText(email);
            jTextField1.setEditable(false);

            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            jTextField2.setText(fname);

            String lname = String.valueOf(jTable1.getValueAt(row, 2));
            jTextField3.setText(lname);

            String nic = String.valueOf(jTable1.getValueAt(row, 3));
            jTextField4.setText(nic);

            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            jTextField5.setText(mobile);

            String gender = String.valueOf(jTable1.getValueAt(row, 5));
            jComboBox1.setSelectedItem(gender);

            String password = String.valueOf(jTable1.getValueAt(row, 6));
            jPasswordField1.setText(password);

            String type = String.valueOf(jTable1.getValueAt(row, 7));
            jComboBox2.setSelectedItem(type);

        } else if (evt.getClickCount() == 2) {

            String email = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            AddressView addressView = new AddressView(this, true, email);
            addressView.setVisible(true);

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
        jTable1.clearSelection();
//        jTable1.setEnabled(true);
        jButton2.setEnabled(false);
        jTextField1.setEditable(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
//                new EmployeeRegistration().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
