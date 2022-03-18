/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Entidad.Boleta;
import Entidad.Factura;
import Presentacion.*;
import Negocio.BD_REPORTES;
import Negocio.bd_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicra
 */
public class frm_reportetotal extends javax.swing.JFrame {

    /**
     * Creates new form frm_reportetotal
     */
    public static String f="";
    DefaultTableModel  modelo=new DefaultTableModel();
    public frm_reportetotal() {
        initComponents();
        setResizable(false);
        setTitle("Reportes");
        setLocationRelativeTo(null);
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        txt_fecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaboleta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel_Wallpaper1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("AÑO");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 100, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("DIA");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("MES");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 100, -1));
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, 30));

        tablaboleta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaboleta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 530, 220));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REPORTE DE VENTAS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 30));

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setEnabled(false);
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 190, 30));

        jLabel_Wallpaper1.setIcon(new javax.swing.ImageIcon("E:\\2021-II\\lp3\\u2\\proyec\\TooQTooQ\\src\\imagenes\\fondoformulario.png")); // NOI18N
        getContentPane().add(jLabel_Wallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        MtdEliminarTodo();
        String fechames;
        DateFormat df1= new SimpleDateFormat("dd-MM-yyyy");
        fechames=df1.format(txt_fecha.getDate());        
        
        ResultSet rs; //iniciando nuestro contenedor
        Boleta objEc=new Boleta();
        BD_REPORTES objNc= new BD_REPORTES();
        objEc.setFecha(fechames);
        rs=objNc.mostrarboleta(objEc); //rs contiene el resultado
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idboleta"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);           
        }        
        
        Factura objEc2=new Factura();
        BD_REPORTES objNc2= new BD_REPORTES();
        objEc2.setFecha(fechames);
        rs=objNc2.mostrarfactura(objEc2);        
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idFactura"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);            
        }        
        txttotal.setText(String.valueOf(suma()));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        MtdEliminarTodo();
        String fechames;
        DateFormat df1= new SimpleDateFormat("MM-yyyy");
        fechames=df1.format(txt_fecha.getDate());        
        
        ResultSet rs; //iniciando nuestro contenedor
        Boleta objEc=new Boleta();
        BD_REPORTES objNc= new BD_REPORTES();
        objEc.setFecha(fechames);
        rs=objNc.mostrarboletames(objEc); //rs contiene el resultado
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idboleta"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);           
        }        
        
        Factura objEc2=new Factura();
        BD_REPORTES objNc2= new BD_REPORTES();
        objEc2.setFecha(fechames);
        rs=objNc2.mostrarfacturames(objEc2);        
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idFactura"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);            
        }        
        txttotal.setText(String.valueOf(suma()));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        MtdEliminarTodo();
        String fechames;
        DateFormat df1= new SimpleDateFormat("yyyy");
        fechames=df1.format(txt_fecha.getDate());        
        
        ResultSet rs; //iniciando nuestro contenedor
        Boleta objEc=new Boleta();
        BD_REPORTES objNc= new BD_REPORTES();
        objEc.setFecha(fechames);
        rs=objNc.mostrarboletaanio(objEc); //rs contiene el resultado
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idboleta"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);           
        }        
        
        Factura objEc2=new Factura();
        BD_REPORTES objNc2= new BD_REPORTES();
        objEc2.setFecha(fechames);
        rs=objNc2.mostrarfacturaanio(objEc2);        
        modelo.setColumnIdentifiers(new Object[] {"ID","fecha","monto"} );
        try {
            while (rs.next()) //inicia desde el primer elemento hasta el ultimo
            {
                modelo.addRow(new Object[]{rs.getString("idFactura"),rs.getString("fecha"),rs.getString("montoTotal")});
            }
            tablaboleta.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);            
        }        
        txttotal.setText(String.valueOf(suma()));
    }//GEN-LAST:event_jRadioButton1ActionPerformed
    
    
        /*public void mostrar(String fechames){
        try {
            DefaultTableModel modelo;
            BD_REPORTES fun = new BD_REPORTES();
            modelo= fun.mostrarboleta(fechames);
            tablaboleta.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e);
        }
    }*/
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
            java.util.logging.Logger.getLogger(frm_reportetotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_reportetotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_reportetotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_reportetotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_reportetotal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Wallpaper1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaboleta;
    private com.toedter.calendar.JDateChooser txt_fecha;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

    public double suma(){
        int contar=tablaboleta.getRowCount();
        double suma=0;
        for(int i=0; i<contar;i++)
        {
            suma=suma+Double.valueOf(tablaboleta.getValueAt(i, 2).toString());
        }
        return suma;
    }
    private void MtdEliminarTodo() {
        DefaultTableModel temp= (DefaultTableModel) tablaboleta.getModel();
        int filas= tablaboleta.getRowCount();
        for(int a=0;filas>a;a++)
        {
            temp.removeRow(0);
        }        
    }
}
