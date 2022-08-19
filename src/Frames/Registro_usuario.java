/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Reyser
 */

public class Registro_usuario extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();

    int xMouse, yMouse;
    
    public Registro_usuario() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        TextPrompt nombreCompleto = new TextPrompt("Ingrese su nombre completo", nombreTxt);
        TextPrompt correo = new TextPrompt("Ingrese su correo electrónico", emailTxt);
        TextPrompt telefono = new TextPrompt("Ingrese su número de teléfono", telefonoTxt);
        TextPrompt username = new TextPrompt("Ingrese su nombre de usuario", usuarioTxt);
        TextPrompt password = new TextPrompt("Ingrese su contraseña", passwordTxt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        logoLog = new javax.swing.JLabel();
        logoName = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        email = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        telefono = new javax.swing.JLabel();
        telefonoTxt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        usuarioTxt = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        password = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        registrarseBtn = new javax.swing.JPanel();
        registrarseBtnTxt = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        fondoLog2 = new javax.swing.JPanel();
        fondoLog = new javax.swing.JLabel();
        header = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REGISTRAR ADMINISTRADOR");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 520, -1));

        logoLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        bg.add(logoLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 280, 170));

        logoName.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        logoName.setForeground(new java.awt.Color(255, 255, 255));
        logoName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoName.setText("<html><center>SISTEMA DE<p>CALIFICACIONES</center></html>");
        bg.add(logoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 280, 60));

        nombre.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nombre.setText("NOMBRE COMPLETO");
        bg.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreTxt.setBorder(null);
        bg.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 380, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 380, 10));

        email.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        email.setText("CORREO ELECTRÓNICO");
        bg.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        emailTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        emailTxt.setBorder(null);
        bg.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 380, 30));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 380, 20));

        telefono.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        telefono.setText("TELÉFONO");
        bg.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        telefonoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        telefonoTxt.setBorder(null);
        bg.add(telefonoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 380, 30));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 380, 20));

        usuarioTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        usuarioTxt.setBorder(null);
        bg.add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 380, 30));

        usuario.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        usuario.setText("USUARIO");
        bg.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 380, 20));

        password.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        password.setText("CONTRASEÑA");
        bg.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        passwordTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        passwordTxt.setBorder(null);
        bg.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 380, 30));

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 380, 10));

        registrarseBtn.setBackground(new java.awt.Color(110, 46, 143));

        registrarseBtnTxt.setFont(new java.awt.Font("Roboto Cn", 1, 18)); // NOI18N
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
            .addComponent(registrarseBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        registrarseBtnLayout.setVerticalGroup(
            registrarseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarseBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(registrarseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 140, 40));

        volverBtn.setBackground(new java.awt.Color(110, 46, 143));

        volverBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        volverBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        volverBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volverBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volverIcon.png"))); // NOI18N
        volverBtnTxt.setText("Volver");
        volverBtnTxt.setToolTipText("");
        volverBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout volverBtnLayout = new javax.swing.GroupLayout(volverBtn);
        volverBtn.setLayout(volverBtnLayout);
        volverBtnLayout.setHorizontalGroup(
            volverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        volverBtnLayout.setVerticalGroup(
            volverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 110, 40));

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
        bg.add(exitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, -1));

        fondoLog2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout fondoLog2Layout = new javax.swing.GroupLayout(fondoLog2);
        fondoLog2.setLayout(fondoLog2Layout);
        fondoLog2Layout.setHorizontalGroup(
            fondoLog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        fondoLog2Layout.setVerticalGroup(
            fondoLog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        bg.add(fondoLog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 519, 498));

        fondoLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        bg.add(fondoLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 798, 498));

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 798, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseClicked
       Login login = new Login();
       
       login.setVisible(true);
       dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void volverBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseEntered
        volverBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_volverBtnTxtMouseEntered

    private void volverBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseExited
        volverBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_volverBtnTxtMouseExited

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        int valor = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicación?",
            "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (valor == JOptionPane.YES_OPTION)
        System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked

    private void exitLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseEntered
        exitLabel.setForeground(Color.white);
    }//GEN-LAST:event_exitLabelMouseEntered

    private void exitLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseExited
        exitLabel.setForeground(Color.black);
    }//GEN-LAST:event_exitLabelMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void registrarseBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseBtnTxtMouseClicked
        if (!nombreTxt.getText().isEmpty() || !emailTxt.getText().isEmpty() || !telefonoTxt.getText().isEmpty()
                || !usuarioTxt.getText().isEmpty() || !passwordTxt.getText().isEmpty()){
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios (nombre, email, telefono, username, password, tipo_nivel) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                
                ps.setString(1, nombreTxt.getText());
                ps.setString(2, emailTxt.getText());
                ps.setString(3, telefonoTxt.getText());
                ps.setString(4, usuarioTxt.getText());
                ps.setString(5, passwordTxt.getText());
                ps.setString(6, "Administrador");
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Administrador registrado correctamente");
                
                Login login = new Login();
                login.setVisible(true);
                dispose();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
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
                new Registro_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel fondoLog;
    private javax.swing.JPanel fondoLog2;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel logoLog;
    private javax.swing.JLabel logoName;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel password;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JPanel registrarseBtn;
    private javax.swing.JLabel registrarseBtnTxt;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField telefonoTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextField usuarioTxt;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
