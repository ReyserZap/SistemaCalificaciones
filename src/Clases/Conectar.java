/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Reyser
 */

public class Conectar {
    Connection cn;
    Statement st;
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "root", "");
            System.out.println("Base de datos conectada con exito");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return cn;
    }
}
