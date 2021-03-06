package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import miniproject.DBConnection;
import static miniproject.ViewTimeTable.timetableid;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JasonTan
 */
public class priority extends javax.swing.JFrame {

    /**
     * Creates new form priority
     */
    public priority() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
       

        try {
            System.out.print("GG");
//            ps = conn.prepareStatement("DELETE FROM `priority`");
//            ps.executeUpdate();

            ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE user_id =?");
            ps.setString(1, LoginForm.userID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ps = conn.prepareStatement("DELETE FROM `priority`");
                ps.executeUpdate();
                System.out.println("success");
            }
            do {
                String Subject_code = rs.getString(2);
                String Subject_name = rs.getString(3);
                String Class_type = rs.getString(4);
                String Day = rs.getString(5);
                String Start_time = rs.getString(6);
                String End_time = rs.getString(7);
                String Location = rs.getString(8);

                System.out.println(Subject_name);

                ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location, User_id  ) "
                        + "values(?,?,?,?,?,?,?,?)");
                ps.setString(1, Subject_code);
                ps.setString(2, Subject_name);
                ps.setString(3, Class_type);
                ps.setString(4, Day);
                ps.setString(5, Start_time);
                ps.setString(6, End_time);
                ps.setString(7, Location);
                ps.setString(8, LoginForm.userID);
                System.out.println("success");
                ps.executeUpdate();

            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        fillSubjectTable(userTimetable);
       //  JOptionPane.showMessageDialog(null, "Please click the box for priority selection");
    
    }
    

    public static void fillSubjectTable(JTable table) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement("SELECT * FROM priority WHERE user_id = ?");
            ps.setString(1, LoginForm.userID);

            ResultSet rs = ps.executeQuery(); //set all query result in resultset.

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getString(2); //subject code
                row[1] = rs.getString(3); //subject name
                row[2] = rs.getString(4); //subject name
                row[3] = rs.getString(5); //date
                row[4] = rs.getInt(6); //start time
                row[5] = rs.getInt(7); //end time
                row[6] = rs.getString(8); //venue
                row[7] = rs.getString(9); //lecturer
                // timetableid = rs.getString(1);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddSubjectForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        MonNC = new javax.swing.JCheckBox();
        TueNC = new javax.swing.JCheckBox();
        WedNC = new javax.swing.JCheckBox();
        ThurNC = new javax.swing.JCheckBox();
        FriNC = new javax.swing.JCheckBox();
        PeferL = new javax.swing.JCheckBox();
        PeferE = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTimetable = new javax.swing.JTable();
        exitbtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        MonNC.setText("No classes on mondays");
        MonNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonNCActionPerformed(evt);
            }
        });
        getContentPane().add(MonNC);
        MonNC.setBounds(170, 470, 20, 30);

        TueNC.setText("No classes on Tuesdays");
        TueNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TueNCActionPerformed(evt);
            }
        });
        getContentPane().add(TueNC);
        TueNC.setBounds(170, 530, 20, 23);

        WedNC.setText("No classes on Wednesdays");
        WedNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WedNCActionPerformed(evt);
            }
        });
        getContentPane().add(WedNC);
        WedNC.setBounds(170, 580, 20, 23);

        ThurNC.setText("No class on Thurdays");
        ThurNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThurNCActionPerformed(evt);
            }
        });
        getContentPane().add(ThurNC);
        ThurNC.setBounds(170, 640, 20, 23);

        FriNC.setText("No class on Fridays");
        FriNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriNCActionPerformed(evt);
            }
        });
        getContentPane().add(FriNC);
        FriNC.setBounds(470, 590, 20, 20);

        PeferL.setText("Prefer late classes");
        PeferL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeferLActionPerformed(evt);
            }
        });
        getContentPane().add(PeferL);
        PeferL.setBounds(470, 530, 20, 23);

        PeferE.setText("Prefer early classes");
        PeferE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeferEActionPerformed(evt);
            }
        });
        getContentPane().add(PeferE);
        PeferE.setBounds(470, 480, 20, 23);

        userTimetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Name", "Type", "Date", "Start Time", "End Time", "Venue", "UserID"
            }
        ));
        userTimetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTimetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTimetable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 180, 700, 289);

        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/defaultExit.png"))); // NOI18N
        exitbtn.setText("jLabel2");
        exitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitbtnMouseReleased(evt);
            }
        });
        getContentPane().add(exitbtn);
        exitbtn.setBounds(580, 640, 100, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Priority Page.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MonNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonNCActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        if (MonNC.isSelected()) {

            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` LIKE \"Monday\" AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE `Day` LIKE 'Monday' AND user_id=? ");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location, user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

            /*try { 
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` NOT LIKE \"Monday\" ");
                ps.executeUpdate();
                //ResultSet rs = ps.executeQuery(); 
                
            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_MonNCActionPerformed

    private void TueNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TueNCActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        if (TueNC.isSelected()) {

            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` LIKE \"Tuesday\" AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }

            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE `Day` LIKE 'Tuesday' AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }

            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }
    }//GEN-LAST:event_TueNCActionPerformed

    private void WedNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WedNCActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        if (WedNC.isSelected()) {

            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` LIKE \"Wednesday\" AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE `Day` LIKE 'Wednesday' AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }
    }//GEN-LAST:event_WedNCActionPerformed

    private void ThurNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThurNCActionPerformed
        // TODO add your handling code here:

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        if (ThurNC.isSelected()) {

            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` LIKE \"Thursday\" AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE `Day` LIKE 'Thursday' AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }
    }//GEN-LAST:event_ThurNCActionPerformed

    private void FriNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriNCActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;

        if (FriNC.isSelected()) {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` WHERE `Day` LIKE \"Friday\" AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` WHERE `Day` LIKE 'Friday' AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }

    }//GEN-LAST:event_FriNCActionPerformed

    private void PeferLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeferLActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        if (PeferL.isSelected()) {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` "
                        + "WHERE (`Start_time` = '08:00:00' OR `Start_time` = '09:00:00' OR `Start_time` = '10:00:00') AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` "
                        + "WHERE (`Start_time` = '08:00:00' OR `Start_time` = '09:00:00' OR `Start_time` = '10:00:00') AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }

           userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }
    }//GEN-LAST:event_PeferLActionPerformed

    private void PeferEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeferEActionPerformed
        // TODO add your handling code here:
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        if (PeferE.isSelected()) {

            try {
                System.out.print("GG");
                ps = conn.prepareStatement("DELETE FROM `priority` "
                        + "WHERE (`Start_time` = '15:00:00' or `Start_time` = '16:00:00' or `Start_time` = '17:00:00') AND user_id=?");
                ps.setString(1, LoginForm.userID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);

        } else {
            try {
                System.out.print("GG");
                ps = conn.prepareStatement("SELECT * FROM `filtered` "
                        + "WHERE (`Start_time` = '15:00:00' or `Start_time` = '16:00:00' or `Start_time` = '17:00:00') AND user_id=? ");
                ps.setString(1, LoginForm.userID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) { //check the form
                    System.out.print("Successful");
                }
                do {
                    String Subject_code = rs.getString(2);
                    String Subject_name = rs.getString(3);
                    String Class_type = rs.getString(4);
                    String Day = rs.getString(5);
                    String Start_time = rs.getString(6);
                    String End_time = rs.getString(7);
                    String Location = rs.getString(8);

                    System.out.println(Subject_name);

                    ps = conn.prepareStatement("Insert into priority (Subject_code, Subject_name, Class_type, Day, Start_time, End_time, Location,user_id) "
                            + "values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, Subject_code);
                    ps.setString(2, Subject_name);
                    ps.setString(3, Class_type);
                    ps.setString(4, Day);
                    ps.setString(5, Start_time);
                    ps.setString(6, End_time);
                    ps.setString(7, Location);
                    ps.setString(8, LoginForm.userID);
                    System.out.println("success");
                    ps.executeUpdate();

                } while (rs.next());

            } catch (SQLException ex) {
                Logger.getLogger(priority.class.getName()).log(Level.SEVERE, null, ex);
            }
            userTimetable.setModel(new DefaultTableModel(null, new Object[]{"Subject Code", "Name", "Date",
                "Start Time", "End Time", "Venue", "UserID"}));
            fillSubjectTable(userTimetable);
        }

    }//GEN-LAST:event_PeferEActionPerformed

    private void userTimetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTimetableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_userTimetableMouseClicked

    private void exitbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/hoverExit.png"));
        exitbtn.setIcon(II);
    }//GEN-LAST:event_exitbtnMouseEntered

    private void exitbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseExited
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/defaultExit.png"));
        exitbtn.setIcon(II);
    }//GEN-LAST:event_exitbtnMouseExited

    private void exitbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/pressExit.png"));
        exitbtn.setIcon(II);
    }//GEN-LAST:event_exitbtnMousePressed

    private void exitbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseReleased
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitbtnMouseReleased

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
            java.util.logging.Logger.getLogger(priority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(priority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(priority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(priority.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new priority().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox FriNC;
    private javax.swing.JCheckBox MonNC;
    private javax.swing.JCheckBox PeferE;
    private javax.swing.JCheckBox PeferL;
    private javax.swing.JCheckBox ThurNC;
    private javax.swing.JCheckBox TueNC;
    private javax.swing.JCheckBox WedNC;
    private javax.swing.JLabel exitbtn;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTimetable;
    // End of variables declaration//GEN-END:variables
}
