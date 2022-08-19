/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Frames;

import Clases.Conectar;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Reyser
 */

public class Informacion_calificaciones extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    public TableCellRenderer centerAlight = new CentrarTablas();
    
    int xMouse, yMouse;
    int idAlumno = 0, idCalificacion = 0;
    String nombreAlumno = "";
    
    public Informacion_calificaciones() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        tablaInformacionCalificacion.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
        tablaInformacionCalificacion.getTableHeader().setOpaque(false);
        tablaInformacionCalificacion.getTableHeader().setBackground(Color.WHITE);
        tablaInformacionCalificacion.getTableHeader().setForeground(Color.BLACK);
        tablaInformacionCalificacion.setRowHeight(25);
        
        TextPrompt tarea = new TextPrompt ("Actualizar una tarea", tareaAlumnoTxt);
        TextPrompt calificacion = new TextPrompt("Actualizar una calificación", calificacionAlumnoTxt);
        
        nombreAlumnoTxt.setEditable(false);
        
        idCalificacion = Informacion_alumnos.idCalificacion;
        idAlumno = Gestion_alumnos.idAlumno;
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno='" + idAlumno + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                nombreAlumno = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar el nombre del alumno... Contacte al administrador");
        }
        
        
        //----------------------------
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT tarea, calificacion FROM notas WHERE id_nota='" + idCalificacion + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                tareaAlumnoTxt.setText(rs.getString("tarea"));
                calificacionAlumnoTxt.setText(rs.getString("calificacion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la información de la calificación... Contacte al administrador");
        }
        
        nombreAlumnoTxt.setText(nombreAlumno);
        
        //--------------------------
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas == 3)
                    return true;
                else
                    return false;
            }
        };
        
        modelo.addColumn("ID Nota");
        modelo.addColumn("Tarea");
        modelo.addColumn("Calificación");
        
        tablaInformacionCalificacion.setModel(modelo);
        
        String sql = "SELECT id_nota, tarea, calificacion FROM notas WHERE id_alumno_nota='" + idAlumno + "'";
        String datos[] = new String[3];
        
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString("id_nota");
                datos[1] = rs.getString("tarea");
                datos[2] = rs.getString("calificacion");
                
                modelo.addRow(datos);
            }
            
            tablaInformacionCalificacion.setModel(modelo);
            tablaInformacionCalificacion.getColumnModel().getColumn(2).setCellRenderer(centerAlight);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de calificaciones... Contacte al administrador");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popBorrar = new javax.swing.JPopupMenu();
        popEliminar = new javax.swing.JMenuItem();
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        nombreAlumnoLabel = new javax.swing.JLabel();
        nombreAlumnoTxt = new javax.swing.JTextField();
        linea1 = new javax.swing.JSeparator();
        tareaAlumnoLabel = new javax.swing.JLabel();
        tareaAlumnoTxt = new javax.swing.JTextField();
        linea2 = new javax.swing.JSeparator();
        calificacionAlumnoLabel = new javax.swing.JLabel();
        calificacionAlumnoTxt = new javax.swing.JTextField();
        linea3 = new javax.swing.JSeparator();
        actualizarBtn = new javax.swing.JPanel();
        actualizarBtnTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInformacionCalificacion = new javax.swing.JTable();

        popEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        popEliminar.setText("Eliminar");
        popEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popEliminarActionPerformed(evt);
            }
        });
        popBorrar.add(popEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("INFORMACIÓN DE CALIFICACIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, -1));

        volverBtn.setBackground(new java.awt.Color(121, 70, 140));

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

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, -1, -1));

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

        nombreAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nombreAlumnoLabel.setText("ALUMNO:");
        bg.add(nombreAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 80, 30));

        nombreAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreAlumnoTxt.setBorder(null);
        bg.add(nombreAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 210, 20));

        linea1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 210, 7));

        tareaAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        tareaAlumnoLabel.setText("TAREA:");
        bg.add(tareaAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 80, 30));

        tareaAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tareaAlumnoTxt.setBorder(null);
        bg.add(tareaAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 210, 20));

        linea2.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 210, 7));

        calificacionAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        calificacionAlumnoLabel.setText("CALIFICACIÓN:");
        bg.add(calificacionAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 130, 30));

        calificacionAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        calificacionAlumnoTxt.setBorder(null);
        calificacionAlumnoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calificacionAlumnoTxtKeyTyped(evt);
            }
        });
        bg.add(calificacionAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 210, 20));

        linea3.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 210, 7));

        actualizarBtn.setBackground(new java.awt.Color(121, 70, 140));

        actualizarBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        actualizarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        actualizarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actualizarBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizarIcon.png"))); // NOI18N
        actualizarBtnTxt.setText("Actualizar");
        actualizarBtnTxt.setToolTipText("");
        actualizarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout actualizarBtnLayout = new javax.swing.GroupLayout(actualizarBtn);
        actualizarBtn.setLayout(actualizarBtnLayout);
        actualizarBtnLayout.setHorizontalGroup(
            actualizarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        actualizarBtnLayout.setVerticalGroup(
            actualizarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 120, 50));

        tablaInformacionCalificacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaInformacionCalificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInformacionCalificacion.setComponentPopupMenu(popBorrar);
        tablaInformacionCalificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaInformacionCalificacion.setGridColor(new java.awt.Color(204, 204, 204));
        tablaInformacionCalificacion.setRowHeight(25);
        tablaInformacionCalificacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaInformacionCalificacion);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 440, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void actualizarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseClicked
        try {
            if (tareaAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo tarea vacío");
            else if (calificacionAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo calificación vacío");
            else {
                PreparedStatement ps = cn.prepareStatement("UPDATE notas SET tarea='" + tareaAlumnoTxt.getText() + "', "
                        + "calificacion='" + calificacionAlumnoTxt.getText() + "' WHERE id_nota='" + idCalificacion + "'");
                
                int respuesta = ps.executeUpdate();
                
                if (respuesta > 0)
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                
                Informacion_alumnos informacion_alumnos = new Informacion_alumnos();
                informacion_alumnos.setVisible(true);
                dispose();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos de calificaciones... Contacte al administrador");
        }
    }//GEN-LAST:event_actualizarBtnTxtMouseClicked

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed
        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM notas WHERE id_nota='" + idCalificacion + "'");
            int respuesta = ps.executeUpdate();
            
            if (respuesta > 0)
                JOptionPane.showMessageDialog(null, "Datos borrados correctamente");
            else
                JOptionPane.showMessageDialog(null, "No ha seleccionado uno fila");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_popEliminarActionPerformed

    private void actualizarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseEntered
        actualizarBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_actualizarBtnTxtMouseEntered

    private void actualizarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseExited
        actualizarBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_actualizarBtnTxtMouseExited

    private void volverBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseEntered
        actualizarBtn.setBackground(new Color (121,70,140));
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actualizarBtn;
    private javax.swing.JLabel actualizarBtnTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel calificacionAlumnoLabel;
    private javax.swing.JTextField calificacionAlumnoTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JLabel nombreAlumnoLabel;
    private javax.swing.JTextField nombreAlumnoTxt;
    private javax.swing.JPopupMenu popBorrar;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JTable tablaInformacionCalificacion;
    private javax.swing.JLabel tareaAlumnoLabel;
    private javax.swing.JTextField tareaAlumnoTxt;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
