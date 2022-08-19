/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Frames;

import Clases.Conectar;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Reyser
 */

public class Registrar_curso extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    public TableCellRenderer centerAlight = new CentrarTablas();
    
    int xMouse, yMouse;
    
    public Registrar_curso() {
        initComponents();
        
        tablaRegistroCursos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
        tablaRegistroCursos.getTableHeader().setOpaque(false);
        tablaRegistroCursos.getTableHeader().setBackground(Color.WHITE);
        tablaRegistroCursos.getTableHeader().setForeground(Color.BLACK);
        tablaRegistroCursos.setRowHeight(25);
        
        TextPrompt id = new TextPrompt("ID del Curso", idCursoTxt);
        TextPrompt nombreCurso = new TextPrompt("Ingrese el nombre del curso", nombreCursoTxt);
        
        this.setLocationRelativeTo(null);
        
        mostrarTabla("");
        limpiar();
        idCursoTxt.setEnabled(false);
    }
    
    void limpiar(){
        idCursoTxt.setText("");
        nombreCursoTxt.setText("");
    }
    
    void mostrarTabla(String valor){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas == 2)
                    return true;
                else
                    return false;
            }
        };
        
        modelo.addColumn("ID");
        modelo.addColumn("Curso");
        
        tablaRegistroCursos.setModel(modelo);
        
        String sql = "SELECT * FROM curso";
        String datos[] = new String[2];
        
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                
                modelo.addRow(datos);
            }
            
            tablaRegistroCursos.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar el curso... Contacte al administrador");
                    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popBorrar = new javax.swing.JPopupMenu();
        popEliminar = new javax.swing.JMenuItem();
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        registrarCurso = new javax.swing.JPanel();
        idCursoLabel = new javax.swing.JLabel();
        idCursoTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        nombreCursoLabel = new javax.swing.JLabel();
        nombreCursoTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        guardarBtn = new javax.swing.JPanel();
        guardarBtnTxt = new javax.swing.JLabel();
        actualizarBtn = new javax.swing.JPanel();
        actualizarBtnTxt = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        tablas = new javax.swing.JScrollPane();
        tablaRegistroCursos = new javax.swing.JTable();

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
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REGISTRO DE CURSOS");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, -1));

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

        registrarCurso.setBackground(new java.awt.Color(255, 255, 255));
        registrarCurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR CURSO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Black", 1, 14))); // NOI18N

        idCursoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        idCursoLabel.setText("ID CURSO:");

        idCursoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        idCursoTxt.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        nombreCursoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nombreCursoLabel.setText("NOMBRE:");

        nombreCursoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreCursoTxt.setBorder(null);

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout registrarCursoLayout = new javax.swing.GroupLayout(registrarCurso);
        registrarCurso.setLayout(registrarCursoLayout);
        registrarCursoLayout.setHorizontalGroup(
            registrarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarCursoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(registrarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idCursoLabel)
                    .addComponent(nombreCursoLabel)
                    .addComponent(nombreCursoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(idCursoTxt)
                    .addComponent(jSeparator2))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        registrarCursoLayout.setVerticalGroup(
            registrarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idCursoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idCursoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreCursoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreCursoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bg.add(registrarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 190));

        guardarBtn.setBackground(new java.awt.Color(121, 70, 140));

        guardarBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        guardarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        guardarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarIcon.png"))); // NOI18N
        guardarBtnTxt.setText("Agregar");
        guardarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guardarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout guardarBtnLayout = new javax.swing.GroupLayout(guardarBtn);
        guardarBtn.setLayout(guardarBtnLayout);
        guardarBtnLayout.setHorizontalGroup(
            guardarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guardarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        guardarBtnLayout.setVerticalGroup(
            guardarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guardarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(guardarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 110, 40));

        actualizarBtn.setBackground(new java.awt.Color(121, 70, 140));

        actualizarBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        actualizarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        actualizarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actualizarBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizarIcon.png"))); // NOI18N
        actualizarBtnTxt.setText("Actualizar");
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
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        actualizarBtnLayout.setVerticalGroup(
            actualizarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        volverBtn.setBackground(new java.awt.Color(121, 70, 140));

        volverBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        volverBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        volverBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volverBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volverIcon.png"))); // NOI18N
        volverBtnTxt.setText("Volver");
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
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        tablaRegistroCursos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaRegistroCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRegistroCursos.setToolTipText("");
        tablaRegistroCursos.setComponentPopupMenu(popBorrar);
        tablaRegistroCursos.setGridColor(new java.awt.Color(204, 204, 204));
        tablaRegistroCursos.setRowHeight(25);
        tablaRegistroCursos.getTableHeader().setReorderingAllowed(false);
        tablaRegistroCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRegistroCursosMouseClicked(evt);
            }
        });
        tablas.setViewportView(tablaRegistroCursos);

        bg.add(tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, 370));

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

    private void guardarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBtnTxtMouseClicked
        try {
            if (nombreCursoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar campos vacíos");
            else {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO curso (nombre_curso) VALUES (?)");
                
                ps.setString(1, nombreCursoTxt.getText());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Curso agregado con éxito");
                mostrarTabla("");
                limpiar();
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Problema al guardar el curso... Contacte con el administrador");
        }
    }//GEN-LAST:event_guardarBtnTxtMouseClicked

    private void actualizarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseClicked
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE curso SET nombre_curso='" + nombreCursoTxt.getText() + "' "
                    + "WHERE id_curso='" + idCursoTxt.getText() + "'");
            
            int respuesta = ps.executeUpdate();
            
            if (respuesta > 0){
                JOptionPane.showMessageDialog(null, "Cuso Actualizado");
                limpiar();
                mostrarTabla("");
            } else
                JOptionPane.showMessageDialog(null, "No has seleccionado fila");
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al actualizar el curso... Contacte al administrador");
        }
    }//GEN-LAST:event_actualizarBtnTxtMouseClicked

    private void volverBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseClicked
        Principal principal = new Principal();
        
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void tablaRegistroCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRegistroCursosMouseClicked
        int fila = this.tablaRegistroCursos.getSelectedRow();
        
        this.idCursoTxt.setText(this.tablaRegistroCursos.getValueAt(fila, 0).toString());
        this.nombreCursoTxt.setText(this.tablaRegistroCursos.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tablaRegistroCursosMouseClicked

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed
        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM curso WHERE id_curso='" + idCursoTxt.getText() + "'");
            
            int respuesta = ps.executeUpdate();
            
            if (respuesta > 0){
                JOptionPane.showMessageDialog(null, "Curso eliminado");
                limpiar();
                mostrarTabla("");
            } else
                JOptionPane.showMessageDialog(null, "No se ha seleccionado fila");
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar el curso... Contacte al administrador");
        }
    }//GEN-LAST:event_popEliminarActionPerformed

    private void guardarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBtnTxtMouseEntered
        guardarBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_guardarBtnTxtMouseEntered

    private void guardarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBtnTxtMouseExited
        guardarBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_guardarBtnTxtMouseExited

    private void actualizarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseEntered
        actualizarBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_actualizarBtnTxtMouseEntered

    private void actualizarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseExited
        actualizarBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_actualizarBtnTxtMouseExited

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
                new Registrar_curso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actualizarBtn;
    private javax.swing.JLabel actualizarBtnTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JPanel guardarBtn;
    private javax.swing.JLabel guardarBtnTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel idCursoLabel;
    private javax.swing.JTextField idCursoTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel nombreCursoLabel;
    private javax.swing.JTextField nombreCursoTxt;
    private javax.swing.JPopupMenu popBorrar;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JPanel registrarCurso;
    private javax.swing.JTable tablaRegistroCursos;
    private javax.swing.JScrollPane tablas;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
