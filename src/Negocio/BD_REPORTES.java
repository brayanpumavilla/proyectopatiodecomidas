/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.Boleta;
import Entidad.Factura;
import Entidad.Facturacompras;
import Entidad.Proveedor;
import Negocio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryan
 */
public class BD_REPORTES {
    private conexion mysql = new conexion();
    private Connection co = mysql.Conectar();
    private String cadena="";
    
    public DefaultTableModel mostrarMeseros(String buscar){
        DefaultTableModel modelo;
        String [] titulos= {"Nombre", "Telefono","Mail", "Contraseña","UserName","N°"};
        String [] registros= new String[6];
        modelo = new DefaultTableModel(null,titulos);
        cadena = "CALL buscarMesero('%"+buscar+"%')"; 
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while(rs.next()){
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("telefono");
                registros[2] = rs.getString("mail");
                registros[3] = rs.getString("contraseña");
                registros[4] = rs.getString("userName");
                registros[5] = rs.getString("numeroMesero");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public DefaultTableModel mostrarClientes(String buscar){
        DefaultTableModel modelo;
        String [] titulos= {"Nombre", "Dni","Ruc", "Telefono","Correo","Ciudad"};
        String [] registros= new String[6];
        modelo = new DefaultTableModel(null,titulos);
        cadena = "CALL buscarCliente('%"+buscar+"%')"; 
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while(rs.next()){
                
             
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("dni");
                registros[2] = rs.getString("ruc");
                registros[3] = rs.getString("telefono");
                registros[4] = rs.getString("correo");
                registros[5] = rs.getString("ciudad");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarAdministradores(String buscar){
        DefaultTableModel modelo;
        String [] titulos= {"Nombre", "Telefono","Mail", "Contraseña","UserName"};
        String [] registros= new String[5];
        modelo = new DefaultTableModel(null,titulos);
        cadena = "CALL buscarAdm('%"+buscar+"%')"; 
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while(rs.next()){
                registros[0] = rs.getString("nombre");
                registros[1] = rs.getString("telefono");
                registros[2] = rs.getString("mail");
                registros[3] = rs.getString("contraseña");
                registros[4] = rs.getString("userName");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
     public DefaultTableModel mostrarBoleta(String buscar){
        DefaultTableModel modelo;
        String [] titulos= {"N°","Fecha","Nombre", "Dni","Telefono","Atendido Por", "SubTotal","MontoTotal"};
        String [] registros= new String[8];
        modelo = new DefaultTableModel(null,titulos);
        cadena = "CALL buscarBoleta('%"+buscar+"%')"; 
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while(rs.next()){
                registros[0] = rs.getString("idboleta");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("dni");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("atendidoPor");
                registros[6] = rs.getString("subTotal");
                registros[7] = rs.getString("montoTotal");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
      public DefaultTableModel mostrarFactura(String buscar){
        DefaultTableModel modelo;
        String [] titulos= {"N°","Fecha","Nombre", "Ciudad","Telefono", "SubTotal","MontoTotal"};
        String [] registros= new String[7];
        modelo = new DefaultTableModel(null,titulos);
        cadena = "CALL buscarFactura('%"+buscar+"%')"; 
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while(rs.next()){
                registros[0] = rs.getString("idfactura");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("ciudad");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("subTotal");
                registros[6] = rs.getString("montoTotal");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /*public DefaultTableModel mostrarboleta(String fechames) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL USP_Buscar(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getCodigo());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }*/

    public ResultSet mostrarboleta(Boleta objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportepordia(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarfactura(Factura objEc2) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportedetafacpordia(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc2.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarboletames(Boleta objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportedetames(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarfacturames(Factura objEc2) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportefacdetames(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc2.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarboletaanio(Boleta objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportedetames(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarfacturaanio(Factura objEc2) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportefacdetames(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc2.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarprov(Proveedor objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL buscarproveedor(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getRazonsocial());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarfaccomp(Facturacompras objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportefaccompmesanio(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }

    public ResultSet mostrarfacomprdia(Facturacompras objEc) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) conexion.Conectar();
        //String sql="SELECT * from tbcargo where codcargo=?;";
        String sql="CALL reportefaccompdiario(?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, objEc.getFecha());
            rs=ps.executeQuery();
            return rs;
        }            
        
        catch (Exception e) {
            rs=null;
            return rs;
            
        }
    }
     
}
