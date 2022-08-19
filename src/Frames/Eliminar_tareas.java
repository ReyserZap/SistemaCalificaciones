/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Reyser
 */

public class Eliminar_tareas extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    int xMouse, yMouse;
    
    public Eliminar_tareas() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        eliminarTareasBtn = new javax.swing.JPanel();
        eliminarTareasBtnTxt = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        eliminarAlumnosBtn = new javax.swing.JPanel();
        eliminarAlumnosBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("ELIMINAR DATOS");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, -1));

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
                .addGap(0, 390, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 430, 40));

        eliminarTareasBtn.setBackground(new java.awt.Color(121, 70, 140));
        eliminarTareasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        eliminarTareasBtnTxt.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        eliminarTareasBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        eliminarTareasBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarTareasBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrarIcon.png"))); // NOI18N
        eliminarTareasBtnTxt.setText(" ELIMINAR TODAS LA TAREAS");
        eliminarTareasBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarTareasBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarTareasBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarTareasBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout eliminarTareasBtnLayout = new javax.swing.GroupLayout(eliminarTareasBtn);
        eliminarTareasBtn.setLayout(eliminarTareasBtnLayout);
        eliminarTareasBtnLayout.setHorizontalGroup(
            eliminarTareasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminarTareasBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        eliminarTareasBtnLayout.setVerticalGroup(
            eliminarTareasBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminarTareasBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(eliminarTareasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 340, 60));

        volverBtn.setBackground(new java.awt.Color(121, 70, 140));
        volverBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        volverBtnLayout.setVerticalGroup(
            volverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 100, 40));

        eliminarAlumnosBtn.setBackground(new java.awt.Color(121, 70, 140));
        eliminarAlumnosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        eliminarAlumnosBtnTxt.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        eliminarAlumnosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        eliminarAlumnosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarAlumnosBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrarIcon.png"))); // NOI18N
        eliminarAlumnosBtnTxt.setText(" ELIMINAR TODOS LOS ALUMNOS");
        eliminarAlumnosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarAlumnosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarAlumnosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarAlumnosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout eliminarAlumnosBtnLayout = new javax.swing.GroupLayout(eliminarAlumnosBtn);
        eliminarAlumnosBtn.setLayout(eliminarAlumnosBtnLayout);
        eliminarAlumnosBtnLayout.setHorizontalGroup(
            eliminarAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminarAlumnosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        eliminarAlumnosBtnLayout.setVerticalGroup(
            eliminarAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminarAlumnosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(eliminarAlumnosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 340, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void volverBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseClicked
        Principal principal = new Principal();

        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void eliminarTareasBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTareasBtnTxtMouseClicked
        try {
            int valor = JOptionPane.showConfirmDialog(null, "¿Desea borrar de forma permanente las tareas de los alumnos?", 
                    "ADVENTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (valor == JOptionPane.YES_OPTION){
                PreparedStatement ps = cn.prepareStatement("TRUNCATE TABLE notas");
                ps.execute();
                ps.close();
                
                JOptionPane.showMessageDialog(null, "Ha eliminado todas las tareas de forma permanente", 
                        "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar las tareas... Contacte el administrador");
        }
    }//GEN-LAST:event_eliminarTareasBtnTxtMouseClicked

    private void eliminarAlumnosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarAlumnosBtnTxtMouseClicked
        try {
            int valor = JOptionPane.showConfirmDialog(null, "¿Desea borrar de forma permanente a los Alumnos?", 
                    "ADVENTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (valor == JOptionPane.YES_OPTION){
                PreparedStatement ps = cn.prepareStatement("TRUNCATE TABLE alumnos");
                ps.execute();
                ps.close();
                
                JOptionPane.showMessageDialog(null, "Ha eliminado a todos los alumnos de forma permanente", 
                        "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar a los Alumnos... Contacte el administrador");
        }
    }//GEN-LAST:event_eliminarAlumnosBtnTxtMouseClicked

    private void eliminarAlumnosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarAlumnosBtnTxtMouseEntered
        eliminarAlumnosBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_eliminarAlumnosBtnTxtMouseEntered

    private void eliminarAlumnosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarAlumnosBtnTxtMouseExited
        eliminarAlumnosBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_eliminarAlumnosBtnTxtMouseExited

    private void eliminarTareasBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTareasBtnTxtMouseEntered
        eliminarTareasBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_eliminarTareasBtnTxtMouseEntered

    private void eliminarTareasBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTareasBtnTxtMouseExited
        eliminarTareasBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_eliminarTareasBtnTxtMouseExited

    private void volverBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseEntered
        volverBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_volverBtnTxtMouseEntered

    private void volverBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseExited
        volverBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_volverBtnTxtMouseExited

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_tareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel eliminarAlumnosBtn;
    private javax.swing.JLabel eliminarAlumnosBtnTxt;
    private javax.swing.JPanel eliminarTareasBtn;
    private javax.swing.JLabel eliminarTareasBtnTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
