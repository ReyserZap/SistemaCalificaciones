/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.awt.Color;
import javax.swing.*;
import Clases.Conectar;
import java.sql.*;

/**
 *
 * @author Reyser
 */


public class Principal extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    int xMouse, yMouse;
    int idAdmin = 0;
    
    public Principal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        idAdmin = Login.idAdmin;
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM usuarios WHERE id_usuario ='" + idAdmin + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                String nombre = rs.getString("nombre");
                if (nombre.indexOf(" ") != -1)
                    nombre = nombre.substring(0, rs.getString("nombre").indexOf(" "));
                
                nombreTxt.setText(nombre.toUpperCase());
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar su nombre... Contacte al administrador");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JLabel();
        bienvenido = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JPanel();
        logoutBtnTxt = new javax.swing.JLabel();
        alumnosBtn = new javax.swing.JPanel();
        alumnosBtnTxt = new javax.swing.JLabel();
        gestionAlumnosBtn = new javax.swing.JPanel();
        gestionAlumnosBtnTxt = new javax.swing.JLabel();
        cursosBtn = new javax.swing.JPanel();
        cursosBtnTxt = new javax.swing.JLabel();
        gestionCursosBtn = new javax.swing.JPanel();
        gestionCursosBtnTxt = new javax.swing.JLabel();
        gestionCalificacionesBtn = new javax.swing.JPanel();
        gestionCalificacionesBtnTxt = new javax.swing.JLabel();
        borrarDatosBtn = new javax.swing.JPanel();
        borrarDatosBtnTxt = new javax.swing.JLabel();
        fondoLog = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bg.setRequestFocusEnabled(false);
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 43)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("MENÚ PRINCIPAL");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 570, 70));

        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/userIcon.png"))); // NOI18N
        bg.add(userIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 160, 160));

        nombreTxt.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(255, 255, 255));
        nombreTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreTxt.setText("(Nombre)");
        bg.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 50));

        bienvenido.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(255, 255, 255));
        bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenido.setText("Bienvenido(a)");
        bg.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 50));

        logoutBtnTxt.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        logoutBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoutIcon.png"))); // NOI18N
        logoutBtnTxt.setText("Cerrar Sesión");
        logoutBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoutBtnLayout = new javax.swing.GroupLayout(logoutBtn);
        logoutBtn.setLayout(logoutBtnLayout);
        logoutBtnLayout.setHorizontalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoutBtnLayout.setVerticalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 110, 30));

        alumnosBtn.setBackground(new java.awt.Color(110, 46, 143));

        alumnosBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        alumnosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        alumnosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alumnosBtnTxt.setText("ALUMNOS");
        alumnosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alumnosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alumnosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                alumnosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                alumnosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout alumnosBtnLayout = new javax.swing.GroupLayout(alumnosBtn);
        alumnosBtn.setLayout(alumnosBtnLayout);
        alumnosBtnLayout.setHorizontalGroup(
            alumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alumnosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        alumnosBtnLayout.setVerticalGroup(
            alumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alumnosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(alumnosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 170, 60));

        gestionAlumnosBtn.setBackground(new java.awt.Color(110, 46, 143));

        gestionAlumnosBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        gestionAlumnosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        gestionAlumnosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionAlumnosBtnTxt.setText("GESTIÓN DE ALUMNOS");
        gestionAlumnosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionAlumnosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionAlumnosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gestionAlumnosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gestionAlumnosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout gestionAlumnosBtnLayout = new javax.swing.GroupLayout(gestionAlumnosBtn);
        gestionAlumnosBtn.setLayout(gestionAlumnosBtnLayout);
        gestionAlumnosBtnLayout.setHorizontalGroup(
            gestionAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gestionAlumnosBtnLayout.createSequentialGroup()
                .addComponent(gestionAlumnosBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        gestionAlumnosBtnLayout.setVerticalGroup(
            gestionAlumnosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gestionAlumnosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(gestionAlumnosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 280, 60));

        cursosBtn.setBackground(new java.awt.Color(110, 46, 143));

        cursosBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        cursosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        cursosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cursosBtnTxt.setText("CURSOS");
        cursosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cursosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cursosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cursosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cursosBtnLayout = new javax.swing.GroupLayout(cursosBtn);
        cursosBtn.setLayout(cursosBtnLayout);
        cursosBtnLayout.setHorizontalGroup(
            cursosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cursosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        cursosBtnLayout.setVerticalGroup(
            cursosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cursosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(cursosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 170, 60));

        gestionCursosBtn.setBackground(new java.awt.Color(110, 46, 143));

        gestionCursosBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        gestionCursosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        gestionCursosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionCursosBtnTxt.setText("GESTIÓN DE CURSOS");
        gestionCursosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionCursosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionCursosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gestionCursosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gestionCursosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout gestionCursosBtnLayout = new javax.swing.GroupLayout(gestionCursosBtn);
        gestionCursosBtn.setLayout(gestionCursosBtnLayout);
        gestionCursosBtnLayout.setHorizontalGroup(
            gestionCursosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gestionCursosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        gestionCursosBtnLayout.setVerticalGroup(
            gestionCursosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gestionCursosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(gestionCursosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 280, 60));

        gestionCalificacionesBtn.setBackground(new java.awt.Color(110, 46, 143));

        gestionCalificacionesBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        gestionCalificacionesBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        gestionCalificacionesBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestionCalificacionesBtnTxt.setText("GESTIÓN DE CALIFICACIONES");
        gestionCalificacionesBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionCalificacionesBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionCalificacionesBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gestionCalificacionesBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gestionCalificacionesBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout gestionCalificacionesBtnLayout = new javax.swing.GroupLayout(gestionCalificacionesBtn);
        gestionCalificacionesBtn.setLayout(gestionCalificacionesBtnLayout);
        gestionCalificacionesBtnLayout.setHorizontalGroup(
            gestionCalificacionesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gestionCalificacionesBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        gestionCalificacionesBtnLayout.setVerticalGroup(
            gestionCalificacionesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gestionCalificacionesBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(gestionCalificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 470, 60));

        borrarDatosBtn.setBackground(new java.awt.Color(110, 46, 143));

        borrarDatosBtnTxt.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        borrarDatosBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        borrarDatosBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrarDatosBtnTxt.setText("BORRAR DATOS DE TABLAS");
        borrarDatosBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarDatosBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarDatosBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrarDatosBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrarDatosBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout borrarDatosBtnLayout = new javax.swing.GroupLayout(borrarDatosBtn);
        borrarDatosBtn.setLayout(borrarDatosBtnLayout);
        borrarDatosBtnLayout.setHorizontalGroup(
            borrarDatosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borrarDatosBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        borrarDatosBtnLayout.setVerticalGroup(
            borrarDatosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(borrarDatosBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(borrarDatosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 470, 60));

        fondoLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoPrincipal.jpg"))); // NOI18N
        bg.add(fondoLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 500));

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
                .addContainerGap(758, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void alumnosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alumnosBtnTxtMouseClicked
        Registrar_alumnos registrar_alumnos = new Registrar_alumnos();
        
        registrar_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_alumnosBtnTxtMouseClicked

    private void gestionAlumnosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionAlumnosBtnTxtMouseClicked
        Gestion_alumnos gestion_alumnos = new Gestion_alumnos();
        
        gestion_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_gestionAlumnosBtnTxtMouseClicked

    private void cursosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosBtnTxtMouseClicked
        Registrar_curso registrar_curso = new Registrar_curso();
        
        registrar_curso.setVisible(true);
        dispose();
    }//GEN-LAST:event_cursosBtnTxtMouseClicked

    private void gestionCursosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCursosBtnTxtMouseClicked
       Gestion_cursos gestion_cursos = new Gestion_cursos();
        
       gestion_cursos.setVisible(true);
       dispose();
    }//GEN-LAST:event_gestionCursosBtnTxtMouseClicked

    private void gestionCalificacionesBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCalificacionesBtnTxtMouseClicked
       Gestion_calificaciones gestion_calificaciones = new Gestion_calificaciones();
        
       gestion_calificaciones.setVisible(true);
       dispose();
    }//GEN-LAST:event_gestionCalificacionesBtnTxtMouseClicked

    private void borrarDatosBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarDatosBtnTxtMouseClicked
        Eliminar_tareas eliminar_Tareas = new Eliminar_tareas();
        
        eliminar_Tareas.setVisible(true);
        dispose();
    }//GEN-LAST:event_borrarDatosBtnTxtMouseClicked

    private void alumnosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alumnosBtnTxtMouseEntered
        alumnosBtn.setBackground(new Color (124, 52, 163));
    }//GEN-LAST:event_alumnosBtnTxtMouseEntered

    private void alumnosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alumnosBtnTxtMouseExited
        alumnosBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_alumnosBtnTxtMouseExited

    private void gestionAlumnosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionAlumnosBtnTxtMouseEntered
        gestionAlumnosBtn.setBackground(new Color (124, 52, 163));
    }//GEN-LAST:event_gestionAlumnosBtnTxtMouseEntered

    private void gestionAlumnosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionAlumnosBtnTxtMouseExited
        gestionAlumnosBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_gestionAlumnosBtnTxtMouseExited

    private void cursosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosBtnTxtMouseEntered
        cursosBtn.setBackground(new Color (124, 52, 163));
    }//GEN-LAST:event_cursosBtnTxtMouseEntered

    private void cursosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosBtnTxtMouseExited
        cursosBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_cursosBtnTxtMouseExited

    private void gestionCursosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCursosBtnTxtMouseEntered
        gestionCursosBtn.setBackground(new Color (124, 52, 163));

    }//GEN-LAST:event_gestionCursosBtnTxtMouseEntered

    private void gestionCursosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCursosBtnTxtMouseExited
        gestionCursosBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_gestionCursosBtnTxtMouseExited

    private void gestionCalificacionesBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCalificacionesBtnTxtMouseEntered
        gestionCalificacionesBtn.setBackground(new Color (124, 52, 163));
    }//GEN-LAST:event_gestionCalificacionesBtnTxtMouseEntered

    private void gestionCalificacionesBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionCalificacionesBtnTxtMouseExited
        gestionCalificacionesBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_gestionCalificacionesBtnTxtMouseExited

    private void borrarDatosBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarDatosBtnTxtMouseEntered
        borrarDatosBtn.setBackground(new Color (124, 52, 163));
    }//GEN-LAST:event_borrarDatosBtnTxtMouseEntered

    private void borrarDatosBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarDatosBtnTxtMouseExited
        borrarDatosBtn.setBackground(new Color (110,46,143));
    }//GEN-LAST:event_borrarDatosBtnTxtMouseExited

    private void logoutBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnTxtMouseClicked
        Login login = new Login();
        
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutBtnTxtMouseClicked

    private void logoutBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnTxtMouseEntered
        logoutBtn.setBackground(new Color  (230, 230, 230));
    }//GEN-LAST:event_logoutBtnTxtMouseEntered

    private void logoutBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnTxtMouseExited
        logoutBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_logoutBtnTxtMouseExited

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alumnosBtn;
    private javax.swing.JLabel alumnosBtnTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JPanel borrarDatosBtn;
    private javax.swing.JLabel borrarDatosBtnTxt;
    private javax.swing.JPanel cursosBtn;
    private javax.swing.JLabel cursosBtnTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel fondoLog;
    private javax.swing.JPanel gestionAlumnosBtn;
    private javax.swing.JLabel gestionAlumnosBtnTxt;
    private javax.swing.JPanel gestionCalificacionesBtn;
    private javax.swing.JLabel gestionCalificacionesBtnTxt;
    private javax.swing.JPanel gestionCursosBtn;
    private javax.swing.JLabel gestionCursosBtnTxt;
    private javax.swing.JPanel header;
    private javax.swing.JPanel logoutBtn;
    private javax.swing.JLabel logoutBtnTxt;
    private javax.swing.JLabel nombreTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
