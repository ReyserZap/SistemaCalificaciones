/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Reyser
 */

public class Registrar_calificaciones extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    int xMouse, yMouse;
    int idAlumno = 0;
    String nombreAlumno = "";
    String nombreCurso = "";
    
    public Registrar_calificaciones() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        TextPrompt tarea = new TextPrompt ("Ingrese una tarea", tareaAlumnoTxt);
        TextPrompt calificacion = new TextPrompt ("Ingrese la calificación", calificacionAlumnoTxt);
        
        nombreAlumnoTxt.setEditable(false);
        
        cargarComboCurso(cursoAlumnoCmb);
        
        idAlumno = Gestion_alumnos.idAlumno;
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno='" + idAlumno + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                nombreAlumno = rs.getString("nombre");
            }
                   
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar nombre del alumno... Contacte al administrador");
        }
        
        nombreAlumnoTxt.setText(nombreAlumno);
        
        // ---------------------------
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT id_curso_asignado FROM alumnos WHERE id_alumno='" + idAlumno + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                nombreCurso = rs.getString("id_curso_asignado");
            }
                   
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar nombre del curso... Contacte al administrador");
        }
        
        cursoAlumnoCmb.setSelectedItem(nombreCurso);
    }
    
    public void cargarComboCurso(JComboBox comboCurso){
        try {
            String sql = "SELECT nombre_curso FROM curso";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                comboCurso.addItem(rs.getString("nombre_curso"));
            } 
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de los cursos... Contacte al administrador");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        nombreAlumnoLabel = new javax.swing.JLabel();
        nombreAlumnoTxt = new javax.swing.JTextField();
        linea1 = new javax.swing.JSeparator();
        tareaAlumnoLabel = new javax.swing.JLabel();
        tareaAlumnoTxt = new javax.swing.JTextField();
        linea2 = new javax.swing.JSeparator();
        cursoAlumnoLabel = new javax.swing.JLabel();
        cursoAlumnoCmb = new javax.swing.JComboBox<>();
        calificacionAlumnoLabel = new javax.swing.JLabel();
        calificacionAlumnoTxt = new javax.swing.JTextField();
        linea4 = new javax.swing.JSeparator();
        registrarBtn = new javax.swing.JPanel();
        registrarBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REGISTRAR CALIFICACIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 350, -1));

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
                .addGap(0, 310, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 350, 40));

        volverBtn.setBackground(new java.awt.Color(121, 70, 140));
        volverBtn.setToolTipText("");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, volverBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(volverBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        volverBtnLayout.setVerticalGroup(
            volverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        nombreAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nombreAlumnoLabel.setText("ALUMNO:");
        bg.add(nombreAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 80, 30));

        nombreAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreAlumnoTxt.setBorder(null);
        nombreAlumnoTxt.setPreferredSize(new java.awt.Dimension(64, 20));
        bg.add(nombreAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 210, 20));

        linea1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 210, 7));

        tareaAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        tareaAlumnoLabel.setText("TAREA:");
        bg.add(tareaAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 80, 30));

        tareaAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tareaAlumnoTxt.setBorder(null);
        tareaAlumnoTxt.setPreferredSize(new java.awt.Dimension(64, 20));
        bg.add(tareaAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, 20));

        linea2.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 210, 7));

        cursoAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cursoAlumnoLabel.setText("CURSO:");
        bg.add(cursoAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 80, 30));

        cursoAlumnoCmb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cursoAlumnoCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un curso" }));
        cursoAlumnoCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cursoAlumnoCmb.setEnabled(false);
        cursoAlumnoCmb.setPreferredSize(new java.awt.Dimension(72, 21));
        bg.add(cursoAlumnoCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 210, 24));

        calificacionAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        calificacionAlumnoLabel.setText("CALIFICACIÓN:");
        bg.add(calificacionAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 110, 30));

        calificacionAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        calificacionAlumnoTxt.setBorder(null);
        calificacionAlumnoTxt.setPreferredSize(new java.awt.Dimension(64, 20));
        calificacionAlumnoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calificacionAlumnoTxtKeyTyped(evt);
            }
        });
        bg.add(calificacionAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 210, 20));

        linea4.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 210, 7));

        registrarBtn.setBackground(new java.awt.Color(121, 70, 140));
        registrarBtn.setToolTipText("");
        registrarBtn.setPreferredSize(new java.awt.Dimension(100, 40));

        registrarBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        registrarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        registrarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarIcon.png"))); // NOI18N
        registrarBtnTxt.setText("Registrar");
        registrarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registrarBtnLayout = new javax.swing.GroupLayout(registrarBtn);
        registrarBtn.setLayout(registrarBtnLayout);
        registrarBtnLayout.setHorizontalGroup(
            registrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarBtnLayout.createSequentialGroup()
                .addComponent(registrarBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        registrarBtnLayout.setVerticalGroup(
            registrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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
        Informacion_alumnos informacion_alumnos = new Informacion_alumnos();

        informacion_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void registrarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseClicked
        String curso = cursoAlumnoCmb.getSelectedItem().toString();
        
        try {
            if (tareaAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo Tarea vacío");
            else if (calificacionAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo Calificación vacío");
            else if (Integer.parseInt(calificacionAlumnoTxt.getText()) < 0 || Integer.parseInt(calificacionAlumnoTxt.getText()) > 20)
                JOptionPane.showMessageDialog(null, "No puedes ingresar una nota menor a 0 o mayor a 20");
            else {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO notas (id_alumno_nota, id_curso_nota, tarea, calificacion) "
                        + "VALUES (?, ?, ?, ?)");
                ps.setInt(1, idAlumno);
                ps.setString(2, curso);
                ps.setString(3, tareaAlumnoTxt.getText());
                ps.setString(4, calificacionAlumnoTxt.getText());
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                
                Informacion_alumnos informacion_alumnos = new Informacion_alumnos();
                informacion_alumnos.setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar la calificacion... Contacte al administrador");
        }
    }//GEN-LAST:event_registrarBtnTxtMouseClicked

    private void registrarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseEntered
       registrarBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_registrarBtnTxtMouseEntered

    private void registrarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarBtnTxtMouseExited
        registrarBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_registrarBtnTxtMouseExited

    private void volverBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseEntered
        volverBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_volverBtnTxtMouseEntered

    private void volverBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseExited
        volverBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_volverBtnTxtMouseExited

    private void calificacionAlumnoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calificacionAlumnoTxtKeyTyped
        char c = evt.getKeyChar();
        
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_calificacionAlumnoTxtKeyTyped

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
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel calificacionAlumnoLabel;
    private javax.swing.JTextField calificacionAlumnoTxt;
    private javax.swing.JComboBox<String> cursoAlumnoCmb;
    private javax.swing.JLabel cursoAlumnoLabel;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea4;
    private javax.swing.JLabel nombreAlumnoLabel;
    private javax.swing.JTextField nombreAlumnoTxt;
    private javax.swing.JPanel registrarBtn;
    private javax.swing.JLabel registrarBtnTxt;
    private javax.swing.JLabel tareaAlumnoLabel;
    private javax.swing.JTextField tareaAlumnoTxt;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
