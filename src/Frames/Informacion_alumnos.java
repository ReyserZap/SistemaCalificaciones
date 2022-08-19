/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.Conectar;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Reyser
 */

public class Informacion_alumnos extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    public TableCellRenderer centerAlight = new CentrarTablas();
    
    int xMouse, yMouse;
    int idAlumno = 0;
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public static int idCalificacion = 0;
    
    public Informacion_alumnos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        nombreAlumnoTxt.setEditable(false);
        apellidosAlumnoTxt.setEditable(false);
        telefonoAlumnoTxt.setEditable(false);
        promedioAlumnoTxt.setEditable(false);
        gradoAlumnoCmb.setEnabled(false);
        estatusAlumnoTxt.setEditable(false);
        
        idAlumno = Gestion_alumnos.idAlumno;
        
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='" + idAlumno + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                title.setText("INFORMACIÓN DEL ALUMNO " + rs.getString("nombre").toUpperCase());
                
                nombreAlumnoTxt.setText(rs.getString("nombre"));
                apellidosAlumnoTxt.setText(rs.getString("apellido"));
                gradoAlumnoCmb.setSelectedItem(rs.getString("grado"));
                telefonoAlumnoTxt.setText(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar el alumno... Contacte al administrador");
        }
        
        try {
            PreparedStatement pst = cn.prepareStatement("SELECT id_nota, tarea, calificacion FROM notas "
                    + "WHERE id_alumno_nota='" + idAlumno + "'");
            ResultSet rs = pst.executeQuery();
            
            tablaCalificaciones = new JTable(modelo);
            
            tablaCalificaciones.getTableHeader().setFont(new java.awt.Font("Roboto", java.awt.Font.BOLD, 12));
            tablaCalificaciones.getTableHeader().setOpaque(false);
            tablaCalificaciones.getTableHeader().setBackground(Color.WHITE);
            tablaCalificaciones.getTableHeader().setForeground(Color.BLACK);
            tablaCalificaciones.setRowHeight(25);
            tablaCalificaciones.getTableHeader().setReorderingAllowed(false);
            
            jScrollPane1.setViewportView(tablaCalificaciones);
            
            modelo.addColumn("ID Nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Calificación");
            
            while (rs.next()){
                Object[] fila = new Object[3];
                
                for (int i = 0; i < 3; i++)
                    fila[i] = rs.getObject(i+1);
                
                modelo.addRow(fila);
                
                tablaCalificaciones.getColumnModel().getColumn(2).setCellRenderer(centerAlight);
                
                int filax = 0;
                double total = 0;
                
                for (int i = 0; i < tablaCalificaciones.getRowCount(); i++) {
                    filax = Integer.parseInt(tablaCalificaciones.getValueAt(i, 2).toString());
                    total += filax;
                }
                
                int promedio = (int) (Math.round(total/tablaCalificaciones.getRowCount()));
                promedioAlumnoTxt.setText("  " + promedio);
                
                if (promedio >= 11){
                    estatusAlumnoTxt.setText(String.valueOf("Aprobado"));
                    promedioAlumnoTxt.setBackground(Color.green);
                } else {
                    estatusAlumnoTxt.setText(String.valueOf("Desaprobado"));
                    promedioAlumnoTxt.setBackground(Color.red);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el llenado de la tabla de calificaciones");
        }
        
        tablaCalificaciones.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int filaPoint = tablaCalificaciones.rowAtPoint(e.getPoint());
                int columnaPoint = 0;
                
                if (filaPoint > -1){
                    idCalificacion = (int) modelo.getValueAt(filaPoint, columnaPoint);
                    Informacion_calificaciones informacion_calificaciones = new Informacion_calificaciones();
                    informacion_calificaciones.setVisible(true);
                    dispose();
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        nombreAlumnoLabel = new javax.swing.JLabel();
        nombreAlumnoTxt = new javax.swing.JTextField();
        linea1 = new javax.swing.JSeparator();
        apellidosAlumnoLabel = new javax.swing.JLabel();
        apellidosAlumnoTxt = new javax.swing.JTextField();
        linea2 = new javax.swing.JSeparator();
        gradoAlumnoLabel = new javax.swing.JLabel();
        gradoAlumnoCmb = new javax.swing.JComboBox<>();
        telefonoAlumnoLabel = new javax.swing.JLabel();
        telefonoAlumnoTxt = new javax.swing.JTextField();
        linea3 = new javax.swing.JSeparator();
        estatusAlumnoLabel = new javax.swing.JLabel();
        estatusAlumnoTxt = new javax.swing.JTextField();
        linea4 = new javax.swing.JSeparator();
        promedioAlumnoLabel = new javax.swing.JLabel();
        promedioAlumnoTxt = new javax.swing.JTextField();
        linea5 = new javax.swing.JSeparator();
        registrarCalificacionBtn = new javax.swing.JPanel();
        registrarCalificacionBtnTxt = new javax.swing.JLabel();
        imprimirBtn = new javax.swing.JPanel();
        imprimirBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("(Nombre)");
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

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        tablaCalificaciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCalificaciones.setGridColor(new java.awt.Color(204, 204, 204));
        tablaCalificaciones.setRowHeight(25);
        tablaCalificaciones.setShowHorizontalLines(true);
        tablaCalificaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCalificaciones);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 440, 270));

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
        nombreAlumnoLabel.setText("NOMBRE:");
        bg.add(nombreAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, -1));

        nombreAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreAlumnoTxt.setBorder(null);
        bg.add(nombreAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 210, 20));

        linea1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 210, 7));

        apellidosAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        apellidosAlumnoLabel.setText("APELLIDOS:");
        bg.add(apellidosAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        apellidosAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        apellidosAlumnoTxt.setBorder(null);
        bg.add(apellidosAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 210, 20));

        linea2.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 210, 7));

        gradoAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        gradoAlumnoLabel.setText("GRADO:");
        bg.add(gradoAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 90, -1));

        gradoAlumnoCmb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gradoAlumnoCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1°", "2°", "3°", "4°", "5°", "6°", "7°", "8°", "9°", "10°", "11°" }));
        bg.add(gradoAlumnoCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 210, 24));

        telefonoAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        telefonoAlumnoLabel.setText("TELÉFONO:");
        bg.add(telefonoAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 90, -1));

        telefonoAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        telefonoAlumnoTxt.setBorder(null);
        bg.add(telefonoAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 210, 20));

        linea3.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 80, 7));

        estatusAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        estatusAlumnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estatusAlumnoLabel.setText("ESTATUS: ");
        bg.add(estatusAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 80, 20));

        estatusAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estatusAlumnoTxt.setBorder(null);
        bg.add(estatusAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 80, 20));

        linea4.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 30, 10));

        promedioAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        promedioAlumnoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        promedioAlumnoLabel.setText("PROMEDIO: ");
        bg.add(promedioAlumnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 80, 20));

        promedioAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        promedioAlumnoTxt.setBorder(null);
        bg.add(promedioAlumnoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 30, 20));

        linea5.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 210, 7));

        registrarCalificacionBtn.setBackground(new java.awt.Color(121, 70, 140));

        registrarCalificacionBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        registrarCalificacionBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        registrarCalificacionBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarCalificacionBtnTxt.setText("Registrar Calificación");
        registrarCalificacionBtnTxt.setToolTipText("");
        registrarCalificacionBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarCalificacionBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarCalificacionBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarCalificacionBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarCalificacionBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registrarCalificacionBtnLayout = new javax.swing.GroupLayout(registrarCalificacionBtn);
        registrarCalificacionBtn.setLayout(registrarCalificacionBtnLayout);
        registrarCalificacionBtnLayout.setHorizontalGroup(
            registrarCalificacionBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarCalificacionBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        registrarCalificacionBtnLayout.setVerticalGroup(
            registrarCalificacionBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarCalificacionBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(registrarCalificacionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 160, 30));

        imprimirBtn.setBackground(new java.awt.Color(121, 70, 140));

        imprimirBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        imprimirBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        imprimirBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imprimirBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimirIcon.png"))); // NOI18N
        imprimirBtnTxt.setText(" IMPRIMIR");
        imprimirBtnTxt.setToolTipText("");
        imprimirBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imprimirBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imprimirBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imprimirBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imprimirBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout imprimirBtnLayout = new javax.swing.GroupLayout(imprimirBtn);
        imprimirBtn.setLayout(imprimirBtnLayout);
        imprimirBtnLayout.setHorizontalGroup(
            imprimirBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imprimirBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        imprimirBtnLayout.setVerticalGroup(
            imprimirBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imprimirBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(imprimirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 130, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Gestion_alumnos gestion_alumnos = new Gestion_alumnos();

        gestion_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void registrarCalificacionBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarCalificacionBtnTxtMouseClicked
        Registrar_calificaciones registrar_calificaciones = new Registrar_calificaciones();
        
        registrar_calificaciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_registrarCalificacionBtnTxtMouseClicked

    private void imprimirBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imprimirBtnTxtMouseClicked
        Document documento = new Document();
        
        Calendar calendario = Calendar.getInstance();
        Date fecha = new Date(calendario.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YY");
        
        String verFecha = formato.format(fecha);
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombreAlumnoTxt.getText() + ".pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
            parrafo.add(title.getText() + "\n\n");
            
            Paragraph ponerFecha = new Paragraph();
            ponerFecha.setAlignment(Paragraph.ALIGN_LEFT);
            ponerFecha.add("Fecha: " + verFecha + "\n\n");
            
            documento.open();
            documento.add(parrafo);
            documento.add(ponerFecha);
            
            PdfPTable tablaAlumno = new PdfPTable(4);
            
            tablaAlumno.addCell("Nombre");
            tablaAlumno.addCell("Apellidos");
            tablaAlumno.addCell("Grado");
            tablaAlumno.addCell("Materia");
            
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='" + idAlumno + "'");
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()){
                    do {
                        tablaAlumno.addCell(rs.getString(2));
                        tablaAlumno.addCell(rs.getString(3));
                        tablaAlumno.addCell(rs.getString(4));
                        tablaAlumno.addCell(rs.getString(5));
                    } while (rs.next()); {
                        documento.add(tablaAlumno);
                    }
                    
                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
                    parrafo2.add("\n\nTareas registradas\n\n");
                    
                    documento.add(parrafo2);
                    PdfPTable tablaTareas = new PdfPTable(2);
                    
                    tablaTareas.addCell("Tarea");
                    tablaTareas.addCell("Calificación");
                    
                    try {
                        Connection cn2 = con.conexion();
                        PreparedStatement ps2 = cn2.prepareStatement("SELECT tarea, calificacion FROM notas "
                                + "WHERE id_alumno_nota='" + idAlumno + "'");
                        
                        ResultSet rs2 = ps2.executeQuery();
                        
                        if (rs2.next()){
                            do {
                                tablaTareas.addCell(rs2.getString(1));
                                tablaTareas.addCell(rs2.getString(2));
                            } while (rs2.next()); {
                                documento.add(tablaTareas);
                            }
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al cargar tareas " + e);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener datos del alumno " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado con éxito");
            
        } catch (DocumentException | IOException e) {
            System.err.println("Error en el pdf o en la ruta " + e);
            JOptionPane.showMessageDialog(null, "Error al generar el PDF... contacte al administrador");
        }
    }//GEN-LAST:event_imprimirBtnTxtMouseClicked

    private void imprimirBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imprimirBtnTxtMouseEntered
        imprimirBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_imprimirBtnTxtMouseEntered

    private void imprimirBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imprimirBtnTxtMouseExited
        imprimirBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_imprimirBtnTxtMouseExited

    private void registrarCalificacionBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarCalificacionBtnTxtMouseEntered
        registrarCalificacionBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_registrarCalificacionBtnTxtMouseEntered

    private void registrarCalificacionBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarCalificacionBtnTxtMouseExited
        registrarCalificacionBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_registrarCalificacionBtnTxtMouseExited

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
                new Informacion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidosAlumnoLabel;
    private javax.swing.JTextField apellidosAlumnoTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel estatusAlumnoLabel;
    private javax.swing.JTextField estatusAlumnoTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JComboBox<String> gradoAlumnoCmb;
    private javax.swing.JLabel gradoAlumnoLabel;
    private javax.swing.JPanel header;
    private javax.swing.JPanel imprimirBtn;
    private javax.swing.JLabel imprimirBtnTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JLabel nombreAlumnoLabel;
    private javax.swing.JTextField nombreAlumnoTxt;
    private javax.swing.JLabel promedioAlumnoLabel;
    private javax.swing.JTextField promedioAlumnoTxt;
    private javax.swing.JPanel registrarCalificacionBtn;
    private javax.swing.JLabel registrarCalificacionBtnTxt;
    private javax.swing.JTable tablaCalificaciones;
    private javax.swing.JLabel telefonoAlumnoLabel;
    private javax.swing.JTextField telefonoAlumnoTxt;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
