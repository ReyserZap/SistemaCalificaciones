/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import java.sql.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Reyser
 */

public class Login extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    int xMouse, yMouse;
    String user = "";
    String pass = "";
    
    public static int idAdmin = 0;
    
    public Login() {
        initComponents();
        
        TextPrompt username = new TextPrompt("Ingrese su nombre de usuario", userTxt);
        TextPrompt password = new TextPrompt("********", passwordTxt);
        
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        logoName = new javax.swing.JLabel();
        logoLog = new javax.swing.JLabel();
        fondoLog = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passwordLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        registrarseBtn = new javax.swing.JPanel();
        registrarseBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bg.setPreferredSize(new java.awt.Dimension(800, 500));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoName.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        logoName.setForeground(new java.awt.Color(255, 255, 255));
        logoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoName.setText("<html><center>SISTEMA DE<p>CALIFICACIONES</center></html>");
        bg.add(logoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 280, 60));

        logoLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        bg.add(logoLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 280, 170));

        fondoLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        bg.add(fondoLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 500));

        titulo.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("INICIAR SESIÓN");
        bg.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 500, -1));

        userLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setBorder(null);
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 380, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 380, 20));

        passwordLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        passwordLabel.setText("CONTRASEÑA");
        bg.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 380, 20));

        passwordTxt.setBorder(null);
        bg.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 380, 30));

        loginBtn.setBackground(new java.awt.Color(110, 46, 143));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Cn", 1, 18)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("INGRESAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 130, 50));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitLabel.setBackground(new java.awt.Color(255, 255, 255));
        exitLabel.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("X");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 758, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 798, 40));

        registrarseBtn.setBackground(new java.awt.Color(110, 46, 143));

        registrarseBtnTxt.setFont(new java.awt.Font("Roboto Cn", 1, 14)); // NOI18N
        registrarseBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        registrarseBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarseBtnTxt.setText("REGISTRARSE");
        registrarseBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarseBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarseBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarseBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarseBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registrarseBtnLayout = new javax.swing.GroupLayout(registrarseBtn);
        registrarseBtn.setLayout(registrarseBtnLayout);
        registrarseBtnLayout.setHorizontalGroup(
            registrarseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarseBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        registrarseBtnLayout.setVerticalGroup(
            registrarseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarseBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(registrarseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(124, 52, 163));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(110,46,143));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        user = userTxt.getText();
        pass = passwordTxt.getText();
        
        if (!user.equals("") || !pass.equals("")){
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT tipo_nivel, id_usuario FROM usuarios "
                        + "WHERE username = '" + user + "' AND password = '" + pass + "'");
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()){
                    String tipo_nivel = rs.getString("tipo_nivel");
                    
                    if (tipo_nivel.equalsIgnoreCase("Administrador")){
                        idAdmin = rs.getInt("id_usuario");
                        new Principal().setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectas");
                    userTxt.setText("");
                    passwordTxt.setText("");                    
                }
                
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión... Contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        int valor = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicación?",
            "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (valor == JOptionPane.YES_OPTION)
        System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked

    private void exitLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseEntered
        exitBtn.setBackground(Color.red);
        exitLabel.setForeground(Color.white);
    }//GEN-LAST:event_exitLabelMouseEntered

    private void exitLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseExited
        exitBtn.setBackground(Color.white);
        exitLabel.setForeground(Color.black);
    }//GEN-LAST:event_exitLabelMouseExited

    private void registrarseBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseBtnTxtMouseClicked
        Registro_usuario registro_usuario = new Registro_usuario();
        
        registro_usuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_registrarseBtnTxtMouseClicked

    private void registrarseBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseBtnTxtMouseEntered
        registrarseBtn.setBackground(new Color(124, 52, 163));
    }//GEN-LAST:event_registrarseBtnTxtMouseEntered

    private void registrarseBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseBtnTxtMouseExited
        registrarseBtn.setBackground(new Color(110,46,143));
    }//GEN-LAST:event_registrarseBtnTxtMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel fondoLog;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logoLog;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JPanel registrarseBtn;
    private javax.swing.JLabel registrarseBtnTxt;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
