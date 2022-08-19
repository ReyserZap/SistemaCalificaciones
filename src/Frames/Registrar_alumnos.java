/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Frames;

import Clases.Conectar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Reyser
 */

public class Registrar_alumnos extends javax.swing.JFrame {
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    public TableCellRenderer centerAlight = new CentrarTablas();
    
    int xMouse, yMouse;
    
    public Registrar_alumnos() {
        initComponents();
        
        tablaRegistroAlumnos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
        tablaRegistroAlumnos.getTableHeader().setOpaque(false);
        tablaRegistroAlumnos.getTableHeader().setBackground(Color.WHITE);
        tablaRegistroAlumnos.getTableHeader().setForeground(Color.BLACK);
        tablaRegistroAlumnos.setRowHeight(25);
        
        TextPrompt id = new TextPrompt("ID del Alumno", idAlumnoTxt);
        TextPrompt nombres = new TextPrompt("Ingrese el nombre del alumno", nombreAlumnoTxt);
        TextPrompt apellidos = new TextPrompt("Ingrese los apellidos del alumno", apellidosAlumnoTxt);
        TextPrompt telefono  = new TextPrompt("Ingrese el teléfono del alumno", telefonoAlumnoTxt);
        TextPrompt buscar = new TextPrompt("Realice una busqueda", buscarTxt);
        TextPrompt cantidad = new TextPrompt("Cantidad encontrada", cantidadTxt);
        
        this.setLocationRelativeTo(null);
        limpiar();
        
        idAlumnoTxt.setEnabled(false);
        cantidadTxt.setEditable(false);
        
        mostrarTabla("");
        cargarComboCurso(materiaAlumnoCmb);
        
        for (int i = 0; i <= tablaRegistroAlumnos.getRowCount(); i++)
                    cantidadTxt.setText(" " + i);
    }
    
    void limpiar(){
        idAlumnoTxt.setText("");
        nombreAlumnoTxt.setText("");
        apellidosAlumnoTxt.setText("");
        telefonoAlumnoTxt.setText("");
        gradoAlumnoCmb.setSelectedIndex(0);
        materiaAlumnoCmb.setSelectedIndex(0);
    }
    
    void mostrarTabla(String valor){
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas == 6)
                    return true;
                else
                    return false;
            }
        }; 
       
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Grado");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Materia");
        
        tablaRegistroAlumnos.setModel(modelo);
        
        String sql = "SELECT * FROM alumnos WHERE CONCAT (nombre, ' ', apellido, ' ', grado, ' ', id_curso_asignado) "
                + "LIKE '%" + valor + "%'";
        
        String datos[] = new String[6];
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            tablaRegistroAlumnos.setModel(modelo);
            tablaRegistroAlumnos.getColumnModel().getColumn(3).setCellRenderer(centerAlight);
            tablaRegistroAlumnos.getColumnModel().getColumn(4).setCellRenderer(centerAlight);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void cargarComboCurso(JComboBox comboCurso){
        try {
            String sql = "SELECT nombre_curso FROM curso";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                comboCurso.addItem(rs.getString("nombre_curso"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popBorrar = new javax.swing.JPopupMenu();
        popEliminar = new javax.swing.JMenuItem();
        bg = new javax.swing.JPanel();
        FormAlumno = new javax.swing.JPanel();
        idAlumnoLabel = new javax.swing.JLabel();
        idAlumnoTxt = new javax.swing.JTextField();
        linea1 = new javax.swing.JSeparator();
        nombreAlumnoLabel = new javax.swing.JLabel();
        nombreAlumnoTxt = new javax.swing.JTextField();
        linea2 = new javax.swing.JSeparator();
        apellidosAlumnoLabel = new javax.swing.JLabel();
        apellidosAlumnoTxt = new javax.swing.JTextField();
        linea3 = new javax.swing.JSeparator();
        gradoAlumnoLabel = new javax.swing.JLabel();
        gradoAlumnoCmb = new javax.swing.JComboBox<>();
        telefonoAlumnoLabel = new javax.swing.JLabel();
        telefonoAlumnoTxt = new javax.swing.JTextField();
        linea4 = new javax.swing.JSeparator();
        materiaAlumnoLabel = new javax.swing.JLabel();
        materiaAlumnoCmb = new javax.swing.JComboBox<>();
        agregarBtn = new javax.swing.JPanel();
        agregarBtnTxt = new javax.swing.JLabel();
        actualizarBtn = new javax.swing.JPanel();
        actualizarBtnTxt = new javax.swing.JLabel();
        volverBtn = new javax.swing.JPanel();
        volverBtnTxt = new javax.swing.JLabel();
        tabla = new javax.swing.JScrollPane();
        tablaRegistroAlumnos = new javax.swing.JTable();
        buscarLabel = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        cantidadLabel = new javax.swing.JLabel();
        cantidadTxt = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitLabel = new javax.swing.JLabel();
        linea5 = new javax.swing.JSeparator();
        linea6 = new javax.swing.JSeparator();

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
        bg.setForeground(new java.awt.Color(51, 51, 51));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FormAlumno.setBackground(new java.awt.Color(255, 255, 255));
        FormAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR ALUMNO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Black", 1, 14))); // NOI18N

        idAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        idAlumnoLabel.setText("ID ALUMNO:");

        idAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        idAlumnoTxt.setBorder(null);

        linea1.setForeground(new java.awt.Color(51, 51, 51));

        nombreAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        nombreAlumnoLabel.setText("NOMBRE:");

        nombreAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nombreAlumnoTxt.setBorder(null);
        nombreAlumnoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreAlumnoTxtKeyTyped(evt);
            }
        });

        linea2.setForeground(new java.awt.Color(51, 51, 51));

        apellidosAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        apellidosAlumnoLabel.setText("APELLIDOS:");

        apellidosAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        apellidosAlumnoTxt.setBorder(null);
        apellidosAlumnoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidosAlumnoTxtKeyTyped(evt);
            }
        });

        linea3.setForeground(new java.awt.Color(51, 51, 51));

        gradoAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        gradoAlumnoLabel.setText("GRADO:");

        gradoAlumnoCmb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gradoAlumnoCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un grado", "1°", "2°", "3°", "4°", "5°", "6°", "7°", "8°", "9°", "10°", "11°", "Univeristario" }));
        gradoAlumnoCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        telefonoAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        telefonoAlumnoLabel.setText("TELEFONO:");

        telefonoAlumnoTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        telefonoAlumnoTxt.setBorder(null);
        telefonoAlumnoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoAlumnoTxtKeyTyped(evt);
            }
        });

        linea4.setForeground(new java.awt.Color(51, 51, 51));

        materiaAlumnoLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        materiaAlumnoLabel.setText("MATERIA:");

        materiaAlumnoCmb.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        materiaAlumnoCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una materia" }));
        materiaAlumnoCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout FormAlumnoLayout = new javax.swing.GroupLayout(FormAlumno);
        FormAlumno.setLayout(FormAlumnoLayout);
        FormAlumnoLayout.setHorizontalGroup(
            FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormAlumnoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormAlumnoLayout.createSequentialGroup()
                        .addGroup(FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materiaAlumnoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidosAlumnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradoAlumnoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(FormAlumnoLayout.createSequentialGroup()
                        .addGroup(FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreAlumnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idAlumnoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreAlumnoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(linea3)
                                .addComponent(materiaAlumnoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefonoAlumnoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idAlumnoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(linea2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gradoAlumnoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(linea4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apellidosAlumnoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonoAlumnoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(linea1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        FormAlumnoLayout.setVerticalGroup(
            FormAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idAlumnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombreAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreAlumnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(linea2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidosAlumnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradoAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradoAlumnoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(telefonoAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefonoAlumnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(materiaAlumnoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materiaAlumnoCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bg.add(FormAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, 440));

        agregarBtn.setBackground(new java.awt.Color(121, 70, 140));

        agregarBtnTxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        agregarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agregarBtnTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardarIcon.png"))); // NOI18N
        agregarBtnTxt.setText("Agregar");
        agregarBtnTxt.setToolTipText("");
        agregarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout agregarBtnLayout = new javax.swing.GroupLayout(agregarBtn);
        agregarBtn.setLayout(agregarBtnLayout);
        agregarBtnLayout.setHorizontalGroup(
            agregarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(agregarBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        agregarBtnLayout.setVerticalGroup(
            agregarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(agregarBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 100, 40));

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
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        actualizarBtnLayout.setVerticalGroup(
            actualizarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actualizarBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 110, 40));

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
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        volverBtnLayout.setVerticalGroup(
            volverBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(volverBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, 110, 40));

        tablaRegistroAlumnos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaRegistroAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRegistroAlumnos.setComponentPopupMenu(popBorrar);
        tablaRegistroAlumnos.setGridColor(new java.awt.Color(204, 204, 204));
        tablaRegistroAlumnos.setRowHeight(25);
        tablaRegistroAlumnos.setShowHorizontalLines(true);
        tablaRegistroAlumnos.getTableHeader().setReorderingAllowed(false);
        tablaRegistroAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRegistroAlumnosMouseClicked(evt);
            }
        });
        tabla.setViewportView(tablaRegistroAlumnos);

        bg.add(tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 560, 430));

        buscarLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        buscarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarLabel.setText("Buscar: ");
        bg.add(buscarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 60, 20));

        buscarTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        buscarTxt.setBorder(null);
        buscarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarTxtMousePressed(evt);
            }
        });
        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
        });
        bg.add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 180, 20));

        cantidadLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cantidadLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cantidadLabel.setText("Cantidad: ");
        bg.add(cantidadLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 70, 20));

        cantidadTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cantidadTxt.setBorder(null);
        cantidadTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cantidadTxtMousePressed(evt);
            }
        });
        bg.add(cantidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 50, 20));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REGISTRAR ALUMNO");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, -1));

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
                .addGap(0, 858, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 898, 40));

        linea5.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 50, 7));

        linea6.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(linea6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 180, 7));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
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

    private void buscarTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTxtMousePressed

    private void cantidadTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadTxtMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadTxtMousePressed

    private void popEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popEliminarActionPerformed
        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM alumnos WHERE id_alumno='" + idAlumnoTxt.getText() + "'");
            
            int respuesta = ps.executeUpdate();
            
            if (respuesta > 0){
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
                limpiar();
                mostrarTabla("");
                
                for (int i = 0; i <= tablaRegistroAlumnos.getRowCount(); i++)
                    cantidadTxt.setText(" " + i);
            } else
                JOptionPane.showMessageDialog(null, "No ha seleccionado a un alumno");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno... Contacte con el administrador");
        }
    }//GEN-LAST:event_popEliminarActionPerformed

    private void agregarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarBtnTxtMouseClicked
        String id_curso_asignado = materiaAlumnoCmb.getSelectedItem().toString();
        String materia = (String) materiaAlumnoCmb.getSelectedItem();
        String grado = (String) gradoAlumnoCmb.getSelectedItem();
        
        try {
            if (nombreAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacío");
            else if (apellidosAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo apellidos vacío");
            else if (telefonoAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo teléfono vacío");
            else if (grado.equals("Seleccione un grado"))
                JOptionPane.showMessageDialog(null, "Debes seleccionar un grado");
            else if (materia.equals("Seleccione una materia"))
                JOptionPane.showMessageDialog(null, "Debes seleccionar una materia");
            else {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO alumnos (nombre, apellido, grado, telefono, id_curso_asignado) "
                        + "VALUES (?, ?, ?, ?, ?)");
                
                ps.setString(1, nombreAlumnoTxt.getText());
                ps.setString(2, apellidosAlumnoTxt.getText());
                ps.setString(3, gradoAlumnoCmb.getSelectedItem().toString());
                ps.setString(4, telefonoAlumnoTxt.getText());
                ps.setString(5, id_curso_asignado);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alumno registrado con éxito");
                limpiar();
                buscarTxt.setText("");
                mostrarTabla("");
                
                for (int i = 0; i <= tablaRegistroAlumnos.getRowCount(); i++)
                    cantidadTxt.setText(" " + i);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al registrar alumno... Contacte con el administrador");
        }
        
    }//GEN-LAST:event_agregarBtnTxtMouseClicked

    private void tablaRegistroAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRegistroAlumnosMouseClicked
        int fila = this.tablaRegistroAlumnos.getSelectedRow();
        
                this.nombreAlumnoTxt.setText(this.tablaRegistroAlumnos.getValueAt(fila, 0).toString());

        this.idAlumnoTxt.setText(this.tablaRegistroAlumnos.getValueAt(fila, 0).toString());
        this.nombreAlumnoTxt.setText(this.tablaRegistroAlumnos.getValueAt(fila, 1).toString());
        this.apellidosAlumnoTxt.setText(this.tablaRegistroAlumnos.getValueAt(fila, 2).toString());
        this.gradoAlumnoCmb.setSelectedItem(this.tablaRegistroAlumnos.getValueAt(fila, 3).toString());
        this.telefonoAlumnoTxt.setText(this.tablaRegistroAlumnos.getValueAt(fila, 4).toString());
        this.materiaAlumnoCmb.setSelectedItem(this.tablaRegistroAlumnos.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_tablaRegistroAlumnosMouseClicked

    private void actualizarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarBtnTxtMouseClicked
        String materia = (String) materiaAlumnoCmb.getSelectedItem();
        String grado = (String) gradoAlumnoCmb.getSelectedItem();
        
        try {
            if (nombreAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacío");
            else if (apellidosAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo apellidos vacío");
            else if (telefonoAlumnoTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo teléfono vacío");
            else if (grado.equals("Seleccione un grado"))
                JOptionPane.showMessageDialog(null, "Debes seleccionar un grado");
            else if (materia.equals("Seleccione una materia"))
                JOptionPane.showMessageDialog(null, "Debes seleccionar una materia");
            else {
                PreparedStatement ps = cn.prepareStatement("UPDATE alumnos SET nombre='" + nombreAlumnoTxt.getText() + "', "
                        + "apellido='" + apellidosAlumnoTxt.getText() + "', " + "grado='" + gradoAlumnoCmb.getSelectedItem() + "', "
                        + "telefono='" + telefonoAlumnoTxt.getText() + "', " + "id_curso_asignado='" + materiaAlumnoCmb.getSelectedItem().toString() + "' "
                        + "WHERE id_alumno='" + idAlumnoTxt.getText() + "'");
                
                int respuesta = ps.executeUpdate();
                
                if (respuesta > 0){
                    JOptionPane.showMessageDialog(null, "Datos del alumno fueron modificados exitosamente");
                    limpiar();
                    buscarTxt.setText("");
                    mostrarTabla("");
                } else
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar datos... Contacte al administrador");
        }
    }//GEN-LAST:event_actualizarBtnTxtMouseClicked

    private void volverBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverBtnTxtMouseClicked
        Principal principal = new Principal();
        
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverBtnTxtMouseClicked

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        mostrarTabla(buscarTxt.getText());
        
        for (int i = 0; i <= tablaRegistroAlumnos.getRowCount(); i++)
                    cantidadTxt.setText(" " + i);
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void nombreAlumnoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreAlumnoTxtKeyTyped
        char c = evt.getKeyChar();
        
        if ((c < 'a' || c > 'z') && (c < 'A') | c > 'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_nombreAlumnoTxtKeyTyped

    private void apellidosAlumnoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosAlumnoTxtKeyTyped
        char c = evt.getKeyChar();
        
        if ((c < 'a' || c > 'z') && (c < 'A') | c > 'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_apellidosAlumnoTxtKeyTyped

    private void telefonoAlumnoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoAlumnoTxtKeyTyped
        char c = evt.getKeyChar();
        
        if (c < '0' || c > '9') evt.consume();
    }//GEN-LAST:event_telefonoAlumnoTxtKeyTyped

    private void agregarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarBtnTxtMouseEntered
        agregarBtn.setBackground(new Color (141, 79, 164));
    }//GEN-LAST:event_agregarBtnTxtMouseEntered

    private void agregarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarBtnTxtMouseExited
        agregarBtn.setBackground(new Color (121,70,140));
    }//GEN-LAST:event_agregarBtnTxtMouseExited

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
                new Registrar_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FormAlumno;
    private javax.swing.JPanel actualizarBtn;
    private javax.swing.JLabel actualizarBtnTxt;
    private javax.swing.JPanel agregarBtn;
    private javax.swing.JLabel agregarBtnTxt;
    private javax.swing.JLabel apellidosAlumnoLabel;
    private javax.swing.JTextField apellidosAlumnoTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel buscarLabel;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JComboBox<String> gradoAlumnoCmb;
    private javax.swing.JLabel gradoAlumnoLabel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel idAlumnoLabel;
    private javax.swing.JTextField idAlumnoTxt;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JComboBox<String> materiaAlumnoCmb;
    private javax.swing.JLabel materiaAlumnoLabel;
    private javax.swing.JLabel nombreAlumnoLabel;
    private javax.swing.JTextField nombreAlumnoTxt;
    private javax.swing.JPopupMenu popBorrar;
    private javax.swing.JMenuItem popEliminar;
    private javax.swing.JScrollPane tabla;
    private javax.swing.JTable tablaRegistroAlumnos;
    private javax.swing.JLabel telefonoAlumnoLabel;
    private javax.swing.JTextField telefonoAlumnoTxt;
    private javax.swing.JLabel title;
    private javax.swing.JPanel volverBtn;
    private javax.swing.JLabel volverBtnTxt;
    // End of variables declaration//GEN-END:variables
}
