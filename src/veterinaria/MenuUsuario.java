/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

import java.awt.Color;
import javax.swing.*;
import java.net.URI;
import AppPackage.AnimationClass;
import java.awt.Component;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static veterinaria.IngresarAdmin.esEmail;

/**
 *
 * @author Armando
 */
public class MenuUsuario extends javax.swing.JFrame {
    //Para Los Clientes
    HashMap global = new HashMap();
    HashMap mascotaCli = new HashMap();
    HashMap empleadosHas = new HashMap();
    HashMap especieHas = new HashMap();
    HashMap servicioHas = new HashMap();
    HashMap tratamientoHas = new HashMap();
    HashMap medicamentoHas = new HashMap();
    ConexionBD cox = new ConexionBD();
    Connection cx;
    DefaultComboBoxModel combo = new DefaultComboBoxModel();
    DefaultComboBoxModel comboT = new DefaultComboBoxModel();
    DefaultComboBoxModel comboFCliente = new DefaultComboBoxModel();
    DefaultComboBoxModel comboMascotaAC= new DefaultComboBoxModel();
    DefaultComboBoxModel comboEmpleado= new DefaultComboBoxModel();
    DefaultComboBoxModel comboEspecie= new DefaultComboBoxModel();
    DefaultComboBoxModel comboServicio= new DefaultComboBoxModel();
    DefaultComboBoxModel comboTratamiento= new DefaultComboBoxModel();
    DefaultComboBoxModel comboMedicamento= new DefaultComboBoxModel();
    AnimationClass internet = new AnimationClass();
    boolean administrador;
    /**
     * Creates new form MenuUsuario
     */
    public MenuUsuario() throws ClassNotFoundException {
        this.cx = cox.conexion();
        this.cox = new ConexionBD();
        administrador = true;
        initComponents();
        this.setLocationRelativeTo(null);
        frameATratamiento.setLocationRelativeTo(null);
        frameAMedicamento.setLocationRelativeTo(null);
        frameAPuesto.setLocationRelativeTo(null);
        frameAServicio.setLocationRelativeTo(null);
        frameACita.setLocationRelativeTo(null);
        paneles(false);
        comboConsulta();
        btnActive();
    }
    
    public void paneles(boolean bandera){
        
        panelAMascota.setVisible(bandera);
        panelCMascota.setVisible(bandera);
        panelACliente.setVisible(bandera);
        panelCCliente.setVisible(bandera);
        panelMCliente.setVisible(bandera);
        panelMMascota.setVisible(bandera);
        panelACita.setVisible(bandera);
        panelCCita.setVisible(bandera);
        panelCTratamiento.setVisible(bandera);
        panelCMedicamento.setVisible(bandera);
        panelCServicio.setVisible(bandera);
        panelCPuesto.setVisible(bandera);
        panelMEmpleado.setVisible(bandera);
        panelCEmpleado.setVisible(bandera);
    }
    
    public void comboConsulta(){
        
        String sql = "SELECT Especie FROM Especie";
        String sql1 = "SELECT Tratamiento FROM Tratamientos";
        String datos[] = new String[4];
        
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                combo.addElement(datos[0]);
                    
            }
            comEspecieAM.setModel(combo);
            //Tratamientos
            st = null;
            st = cx.createStatement();
            resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                comboT.addElement(datos[0]);
                    
            }
            //comTratamientoACit.setModel(comboT);
        
        } catch (SQLException ex) {
            Logger.getLogger(IngresarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAdmin(boolean admin){
        
        administrador = admin;
    }
    
    public void btnActive(){
        
        if(!(administrador)){
            
            toBtnPuestos.setBackground(new java.awt.Color(64, 64, 64));
            toBtnEmpleado.setBackground(new java.awt.Color(64, 64, 64));
            btnAgregarMedicamento.setBackground(new java.awt.Color(64, 64, 64));
            btnAgregarTratamiento.setBackground(new java.awt.Color(64, 64, 64));
            btnAgragarServicio.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarServicio.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarMedicamento.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarTratamiento.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarCita.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarMascota.setBackground(new java.awt.Color(64, 64, 64));
            btnEliminarCliente.setBackground(new java.awt.Color(64, 64, 64));
        }
    }
    
    public void empleadohash(){
        
        empleadosHas.clear();
        comboEmpleado.removeAllElements();
        String sql2 = "SELECT idEmpleados, Nombre FROM Empleados";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                empleadosHas.put(datos[1], datos[0] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboEmpleado.addElement(datos[1]);
            }
        comEmpleadoACita.setModel(comboEmpleado);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }
    public void serviciohash(){
        
        servicioHas.clear();
        comboServicio.removeAllElements();
        String sql2 = "SELECT Servicio, Precio FROM Servicios";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                servicioHas.put(datos[0], datos[1] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboServicio.addElement(datos[0]);
            }
        comServicioVen.setModel(comboServicio);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }
    public void tratamientohash(){
        
        tratamientoHas.clear();
        comboTratamiento.removeAllElements();
        String sql2 = "SELECT Tratamiento, Precio FROM Tratamientos";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                tratamientoHas.put(datos[0], datos[1] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboTratamiento.addElement(datos[0]);
            }
        comTratamientoVen.setModel(comboTratamiento);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }
    public void medicamentohash(){
        
        comboMedicamento.removeAllElements();
        medicamentoHas.clear();
        String sql2 = "SELECT Medicamento, Precio FROM Medicamentos";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                medicamentoHas.put(datos[0], datos[1] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboMedicamento.addElement(datos[0]);
            }
        comMedicamentoVen.setModel(comboMedicamento);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }
    
    public void especiehash(){
        
        especieHas.clear();
        comboEspecie.removeAllElements();
        String sql2 = "SELECT idEspecie, Especie FROM Especie";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                especieHas.put(datos[1], datos[0] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboEspecie.addElement(datos[1]);
            }
        comEspecieAM.setModel(comboEspecie);
        comEspecieModMas.setModel(comboEspecie);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        frameATratamiento = new javax.swing.JFrame();
        pestaña6 = new javax.swing.JPanel();
        labMaximizar6 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCostoNT = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtNewTratamiento = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        btnAgregarNewTratamiento = new javax.swing.JButton();
        frameACita = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        pestaña5 = new javax.swing.JPanel();
        labMaximizar5 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        txtNombre26 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel81 = new javax.swing.JLabel();
        frameAMedicamento = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        pestaña7 = new javax.swing.JPanel();
        labMaximizar7 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btnAgregarAMed = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        txtMetodoAMed = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txtNombreAMed = new javax.swing.JTextField();
        spnCantidadAMed = new javax.swing.JSpinner();
        jLabel99 = new javax.swing.JLabel();
        txtCostoAMed = new javax.swing.JTextField();
        frameAServicio = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        pestaña8 = new javax.swing.JPanel();
        labMaximizar8 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        btnAgregarAS = new javax.swing.JButton();
        jLabel104 = new javax.swing.JLabel();
        txtNombreServicioAS = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtCostoAS = new javax.swing.JTextField();
        frameAPuesto = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        pestaña9 = new javax.swing.JPanel();
        labMaximizar9 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        btnAgregarPuesto = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        txtNombreNewPuesto = new javax.swing.JTextField();
        radMEmp = new javax.swing.ButtonGroup();
        radMCli = new javax.swing.ButtonGroup();
        radModMas = new javax.swing.ButtonGroup();
        frameCalendario = new javax.swing.JFrame();
        jPanelCalendar = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JCalendar();
        btnAceptar = new javax.swing.JButton();
        radMMasc = new javax.swing.ButtonGroup();
        frameVentas = new javax.swing.JFrame();
        jPanel11 = new javax.swing.JPanel();
        pestaña10 = new javax.swing.JPanel();
        labMaximizar10 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        btnAgregarPuesto1 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        txtNombreNewPuesto1 = new javax.swing.JTextField();
        comEmpleadoACita1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comServicioVen = new javax.swing.JComboBox<>();
        comMedicamentoVen = new javax.swing.JComboBox<>();
        comTratamientoVen = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnAgregarPuesto2 = new javax.swing.JButton();
        txtNombreNewPuesto2 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pestaña = new javax.swing.JPanel();
        labMinimizar = new javax.swing.JLabel();
        labMaximizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        toBtnAyuda = new javax.swing.JToggleButton();
        toBtnMascota = new javax.swing.JToggleButton();
        toBtnMedicamento = new javax.swing.JToggleButton();
        toBtnTratamiento = new javax.swing.JToggleButton();
        toBtnServicio = new javax.swing.JToggleButton();
        toBtnCitas = new javax.swing.JToggleButton();
        toBtnEmpleado = new javax.swing.JToggleButton();
        toBtnCliente = new javax.swing.JToggleButton();
        toBtnPuestos = new javax.swing.JToggleButton();
        panelMEmpleado = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        AMCerrar4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnAgregarMEmp = new javax.swing.JButton();
        spnEdadMEmp = new javax.swing.JSpinner();
        jLabel125 = new javax.swing.JLabel();
        txtNombreMEmp = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        txtPaternoMEmp = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        boxMasculinoMEmp = new javax.swing.JRadioButton();
        jLabel128 = new javax.swing.JLabel();
        boxFemeninoMEmp = new javax.swing.JRadioButton();
        txtMaternoMEmp = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txtEmailMEmp = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        itemPuestoMEmp = new javax.swing.JComboBox<>();
        txtContraseñaMEmp = new javax.swing.JTextField();
        txtIdBusquedaMEmp = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        panelMCliente = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        AMCerrar2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        spnEdadMCli = new javax.swing.JSpinner();
        jLabel41 = new javax.swing.JLabel();
        txtNombreMCli = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtApeMatMCli = new javax.swing.JTextField();
        txtApePatMCli = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtEmailMCli = new javax.swing.JTextField();
        txtTelefonoMCli = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        boxMasculinoMCli = new javax.swing.JRadioButton();
        boxFemeninoMCli = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtIdBusquedaMCli = new javax.swing.JTextField();
        btnActualizarMCli = new javax.swing.JButton();
        labBusquedaMCli = new javax.swing.JLabel();
        panelACita = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        CMCerrar3 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAMotivoCACit = new javax.swing.JTextArea();
        jLabel64 = new javax.swing.JLabel();
        comClienteACit = new javax.swing.JComboBox<>();
        btnAgregarACit = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtFiltroACit = new javax.swing.JTextField();
        comMascotaACit = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        txtFechaCitaACit = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        comEmpleadoACita = new javax.swing.JComboBox<>();
        panelMMascota = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtIdModMasc = new javax.swing.JTextField();
        AMCerrar3 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        spnEdadModMas = new javax.swing.JSpinner();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        comEspecieModMas = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        comMasculinoModMas = new javax.swing.JRadioButton();
        boxFemeninoModMas = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableConsultaModMas = new javax.swing.JTable();
        txtNombreDueñoModMas = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtNombreModMas = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        panelCMascota = new javax.swing.JPanel();
        btnEliminarMascota = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtFiltroConMasco = new javax.swing.JTextField();
        CMCerrar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultaMascotaCM = new javax.swing.JTable();
        panelAMascota = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarAMasc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombreMascotaAM = new javax.swing.JTextField();
        AMCerrar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnEdadAM = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comEspecieAM = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        boxMascotaMasculinoAM = new javax.swing.JRadioButton();
        boxMascotaFemeninoAM = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableConsultaDuenoAM = new javax.swing.JTable();
        txtNombreDueñoAM = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        labBuscarDueñoAM = new javax.swing.JLabel();
        panelACliente = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        AMCerrar1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spnEdadAC = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        txtNombreAC = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtApeMatAC = new javax.swing.JTextField();
        txtApePatAC = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtEmailAC = new javax.swing.JTextField();
        txtTelefonoAC = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        boxMasculinoAC = new javax.swing.JRadioButton();
        boxFemeninoAC = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        panelCCliente = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtFiltroCoClie = new javax.swing.JTextField();
        CMCerrar1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCoClie = new javax.swing.JTable();
        btnEliminarCliente = new javax.swing.JButton();
        panelCCita = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtFiltroConCitas = new javax.swing.JTextField();
        CMCerrar2 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableConsultaCitasCC = new javax.swing.JTable();
        btnEliminarCita = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        panelCTratamiento = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtFiltroConTrat = new javax.swing.JTextField();
        CMCerrar5 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableConTrata = new javax.swing.JTable();
        btnEliminarTratamiento = new javax.swing.JButton();
        btnAgregarTratamiento = new javax.swing.JButton();
        panelCMedicamento = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtFiltroConMed = new javax.swing.JTextField();
        CMCerrar6 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableConsultaMedi = new javax.swing.JTable();
        btnEliminarMedicamento = new javax.swing.JButton();
        btnAgregarMedicamento = new javax.swing.JButton();
        panelCPuesto = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        txtFiltroConPuesto = new javax.swing.JTextField();
        CMCerrar10 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton32 = new javax.swing.JButton();
        btnEliminarPuesto = new javax.swing.JButton();
        panelCServicio = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        txtFiltroConSer = new javax.swing.JTextField();
        CMCerrar9 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableConsultaServ = new javax.swing.JTable();
        btnEliminarServicio = new javax.swing.JButton();
        btnAgragarServicio = new javax.swing.JButton();
        panelCEmpleado = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        txtFiltroCoEmp = new javax.swing.JTextField();
        CMCerrar11 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableConsultaEmp = new javax.swing.JTable();
        jButton34 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labAMascota = new javax.swing.JLabel();
        labCMascota = new javax.swing.JLabel();
        labMMascota = new javax.swing.JLabel();
        labACliente = new javax.swing.JLabel();
        labCCliente = new javax.swing.JLabel();
        labMCliente = new javax.swing.JLabel();
        labCMedicamento = new javax.swing.JLabel();
        labCTratamiento = new javax.swing.JLabel();
        labCServicio = new javax.swing.JLabel();
        labACitas = new javax.swing.JLabel();
        labCCitas = new javax.swing.JLabel();
        labCPuestos = new javax.swing.JLabel();
        labCEmpleado = new javax.swing.JLabel();
        labMEmpleado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        frameATratamiento.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameATratamiento.setMinimumSize(new java.awt.Dimension(340, 190));
        frameATratamiento.setUndecorated(true);
        frameATratamiento.setResizable(false);
        frameATratamiento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña6.setBackground(new java.awt.Color(255, 255, 255));
        pestaña6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar6labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar6labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar6labMaximizar1MouseExited(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel82.setText("Nuevo Tratamiento");

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña6Layout = new javax.swing.GroupLayout(pestaña6);
        pestaña6.setLayout(pestaña6Layout);
        pestaña6Layout.setHorizontalGroup(
            pestaña6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(labMaximizar6))
        );
        pestaña6Layout.setVerticalGroup(
            pestaña6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña6Layout.createSequentialGroup()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        frameATratamiento.getContentPane().add(pestaña6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 40));

        jPanel3.setBackground(new java.awt.Color(236, 244, 227));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCostoNT.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel3.add(txtCostoNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, -1));

        jLabel68.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(26, 188, 156));
        jLabel68.setText("Costo:");
        jPanel3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtNewTratamiento.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel3.add(txtNewTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 260, -1));

        jLabel71.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(26, 188, 156));
        jLabel71.setText("Tratamiento:");
        jPanel3.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btnAgregarNewTratamiento.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarNewTratamiento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarNewTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarNewTratamiento.setText("Agregar");
        btnAgregarNewTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNewTratamientoActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregarNewTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 100, 30));

        frameATratamiento.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 200));

        frameACita.setMinimumSize(new java.awt.Dimension(570, 390));
        frameACita.setUndecorated(true);
        frameACita.setResizable(false);
        frameACita.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(236, 244, 227));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel7.setMaximumSize(new java.awt.Dimension(572, 385));
        jPanel7.setMinimumSize(new java.awt.Dimension(572, 385));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña5.setBackground(new java.awt.Color(255, 255, 255));
        pestaña5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar5labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar5labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar5labMaximizar1MouseExited(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("Veterinaria Citas");

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña5Layout = new javax.swing.GroupLayout(pestaña5);
        pestaña5.setLayout(pestaña5Layout);
        pestaña5Layout.setHorizontalGroup(
            pestaña5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(labMaximizar5))
        );
        pestaña5Layout.setVerticalGroup(
            pestaña5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña5Layout.createSequentialGroup()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(pestaña5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 40));

        jButton23.setBackground(new java.awt.Color(26, 188, 156));
        jButton23.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Agregar");
        jPanel7.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 40));

        jLabel79.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(26, 188, 156));
        jLabel79.setText("Tratamiento:");
        jPanel7.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        txtNombre26.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel7.add(txtNombre26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        jComboBox4.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(26, 188, 156));
        jPanel7.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 240, -1));

        jLabel80.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(26, 188, 156));
        jLabel80.setText("Motivo de la cita:");
        jPanel7.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane9.setViewportView(jTextArea3);

        jPanel7.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, 140));

        jLabel81.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(26, 188, 156));
        jLabel81.setText("Fecha Cita:");
        jPanel7.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        frameACita.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 572, 400));

        frameAMedicamento.setMinimumSize(new java.awt.Dimension(480, 271));
        frameAMedicamento.setUndecorated(true);
        frameAMedicamento.setResizable(false);
        frameAMedicamento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(236, 244, 227));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel8.setMaximumSize(new java.awt.Dimension(572, 385));
        jPanel8.setMinimumSize(new java.awt.Dimension(572, 385));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña7.setBackground(new java.awt.Color(255, 255, 255));
        pestaña7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar7labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar7labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar7labMaximizar1MouseExited(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("Veterinaria Medicamento");

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña7Layout = new javax.swing.GroupLayout(pestaña7);
        pestaña7.setLayout(pestaña7Layout);
        pestaña7Layout.setHorizontalGroup(
            pestaña7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(labMaximizar7))
        );
        pestaña7Layout.setVerticalGroup(
            pestaña7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña7Layout.createSequentialGroup()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.add(pestaña7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 40));

        btnAgregarAMed.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarAMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarAMed.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAMed.setText("Agregar");
        btnAgregarAMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAMedActionPerformed(evt);
            }
        });
        jPanel8.add(btnAgregarAMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 110, 40));

        jLabel91.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(26, 188, 156));
        jLabel91.setText("Cantidad:");
        jPanel8.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        txtMetodoAMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel8.add(txtMetodoAMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 230, -1));

        jLabel92.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(26, 188, 156));
        jLabel92.setText("Metodo de admición:");
        jPanel8.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel93.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(26, 188, 156));
        jLabel93.setText("Nombre:");
        jPanel8.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtNombreAMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel8.add(txtNombreAMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        spnCantidadAMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        spnCantidadAMed.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        jPanel8.add(spnCantidadAMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 110, -1));

        jLabel99.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(26, 188, 156));
        jLabel99.setText("Costo:");
        jPanel8.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        txtCostoAMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel8.add(txtCostoAMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 120, -1));

        frameAMedicamento.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 270));

        frameAServicio.setMinimumSize(new java.awt.Dimension(480, 201));
        frameAServicio.setUndecorated(true);
        frameAServicio.setResizable(false);
        frameAServicio.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(236, 244, 227));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel9.setMaximumSize(new java.awt.Dimension(572, 385));
        jPanel9.setMinimumSize(new java.awt.Dimension(572, 385));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña8.setBackground(new java.awt.Color(255, 255, 255));
        pestaña8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar8labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar8labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar8labMaximizar1MouseExited(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel100.setText("Veterinaria Servicio");

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña8Layout = new javax.swing.GroupLayout(pestaña8);
        pestaña8.setLayout(pestaña8Layout);
        pestaña8Layout.setHorizontalGroup(
            pestaña8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(labMaximizar8))
        );
        pestaña8Layout.setVerticalGroup(
            pestaña8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña8Layout.createSequentialGroup()
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.add(pestaña8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 40));

        btnAgregarAS.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarAS.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarAS.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAS.setText("Agregar");
        btnAgregarAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarASActionPerformed(evt);
            }
        });
        jPanel9.add(btnAgregarAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 110, 40));

        jLabel104.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(26, 188, 156));
        jLabel104.setText("Nombre:");
        jPanel9.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtNombreServicioAS.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel9.add(txtNombreServicioAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        jLabel105.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(26, 188, 156));
        jLabel105.setText("Costo:");
        jPanel9.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        txtCostoAS.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel9.add(txtCostoAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 120, -1));

        frameAServicio.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 200));

        frameAPuesto.setMinimumSize(new java.awt.Dimension(370, 200));
        frameAPuesto.setUndecorated(true);
        frameAPuesto.setResizable(false);
        frameAPuesto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(236, 244, 227));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel10.setMaximumSize(new java.awt.Dimension(572, 385));
        jPanel10.setMinimumSize(new java.awt.Dimension(572, 385));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña9.setBackground(new java.awt.Color(255, 255, 255));
        pestaña9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar9labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar9labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar9labMaximizar1MouseExited(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel107.setText("Veterinaria Puesto");

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña9Layout = new javax.swing.GroupLayout(pestaña9);
        pestaña9.setLayout(pestaña9Layout);
        pestaña9Layout.setHorizontalGroup(
            pestaña9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(labMaximizar9))
        );
        pestaña9Layout.setVerticalGroup(
            pestaña9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña9Layout.createSequentialGroup()
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.add(pestaña9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 40));

        btnAgregarPuesto.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarPuesto.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarPuesto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPuesto.setText("Agregar");
        btnAgregarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPuestoActionPerformed(evt);
            }
        });
        jPanel10.add(btnAgregarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, 40));

        jLabel109.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(26, 188, 156));
        jLabel109.setText("Nombre:");
        jPanel10.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtNombreNewPuesto.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel10.add(txtNombreNewPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        frameAPuesto.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 200));

        frameCalendario.setMinimumSize(new java.awt.Dimension(445, 350));
        frameCalendario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCalendar.setMinimumSize(new java.awt.Dimension(445, 350));
        jPanelCalendar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendario.setBackground(new java.awt.Color(219, 235, 203));
        calendario.setDecorationBackgroundColor(new java.awt.Color(143, 197, 80));
        calendario.setWeekdayForeground(new java.awt.Color(255, 255, 255));
        jPanelCalendar.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 425, 273));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanelCalendar.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 428, 38));

        frameCalendario.getContentPane().add(jPanelCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 360));

        frameVentas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frameVentas.setUndecorated(true);
        frameVentas.setSize(new java.awt.Dimension(830, 450));
        frameVentas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(236, 244, 227));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel11.setMaximumSize(new java.awt.Dimension(830, 450));
        jPanel11.setMinimumSize(new java.awt.Dimension(830, 450));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pestaña10.setBackground(new java.awt.Color(255, 255, 255));
        pestaña10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMaximizar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizar10labMaximizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizar10labMaximizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizar10labMaximizar1MouseExited(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel110.setText("Veterinaria Ventas");

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestaña10Layout = new javax.swing.GroupLayout(pestaña10);
        pestaña10.setLayout(pestaña10Layout);
        pestaña10Layout.setHorizontalGroup(
            pestaña10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestaña10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 613, Short.MAX_VALUE)
                .addComponent(labMaximizar10))
        );
        pestaña10Layout.setVerticalGroup(
            pestaña10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestaña10Layout.createSequentialGroup()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestaña10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labMaximizar10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.add(pestaña10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 40));

        btnAgregarPuesto1.setBackground(new java.awt.Color(220, 77, 65));
        btnAgregarPuesto1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarPuesto1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPuesto1.setText("Cancelar");
        btnAgregarPuesto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPuesto1ActionPerformed(evt);
            }
        });
        jPanel11.add(btnAgregarPuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 110, 40));

        jLabel112.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(26, 188, 156));
        jLabel112.setText("Nombre:");
        jPanel11.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtNombreNewPuesto1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel11.add(txtNombreNewPuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, -1));

        comEmpleadoACita1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comEmpleadoACita1.setForeground(new java.awt.Color(26, 188, 156));
        jPanel11.add(comEmpleadoACita1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 240, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 620, 220));

        comServicioVen.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comServicioVen.setForeground(new java.awt.Color(26, 188, 156));
        jPanel11.add(comServicioVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 240, -1));

        comMedicamentoVen.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comMedicamentoVen.setForeground(new java.awt.Color(26, 188, 156));
        jPanel11.add(comMedicamentoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 240, -1));

        comTratamientoVen.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comTratamientoVen.setForeground(new java.awt.Color(26, 188, 156));
        jPanel11.add(comTratamientoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 240, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-agregar-a-carrito-de-compras-30.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 30, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-agregar-a-carrito-de-compras-30.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 30, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-agregar-a-carrito-de-compras-30.png"))); // NOI18N
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 30, 30));

        btnAgregarPuesto2.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarPuesto2.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarPuesto2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPuesto2.setText("Agregar");
        btnAgregarPuesto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPuesto2ActionPerformed(evt);
            }
        });
        jPanel11.add(btnAgregarPuesto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 110, 40));

        txtNombreNewPuesto2.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel11.add(txtNombreNewPuesto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 140, -1));

        jLabel113.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(26, 188, 156));
        jLabel113.setText("Total:");
        jPanel11.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        frameVentas.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(236, 244, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 570));
        jPanel1.setLayout(null);

        pestaña.setBackground(new java.awt.Color(255, 255, 255));
        pestaña.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-minimizar-la-ventana-40.png"))); // NOI18N
        labMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMinimizar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-minimizar-la-ventana-40 (1).png"))); // NOI18N
        labMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMinimizarMouseExited(evt);
            }
        });

        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        labMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMaximizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labMaximizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labMaximizarMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Veterinaria Menú Principal");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-huella-de-perro-30.png"))); // NOI18N

        javax.swing.GroupLayout pestañaLayout = new javax.swing.GroupLayout(pestaña);
        pestaña.setLayout(pestañaLayout);
        pestañaLayout.setHorizontalGroup(
            pestañaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestañaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 660, Short.MAX_VALUE)
                .addComponent(labMinimizar)
                .addGap(0, 0, 0)
                .addComponent(labMaximizar))
        );
        pestañaLayout.setVerticalGroup(
            pestañaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pestañaLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestañaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pestañaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labMinimizar)))
        );

        jPanel1.add(pestaña);
        pestaña.setBounds(0, 0, 1160, 40);

        panelMenu.setBackground(new java.awt.Color(26, 188, 156));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toBtnAyuda.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnAyuda);
        toBtnAyuda.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        toBtnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-ayuda-40.png"))); // NOI18N
        toBtnAyuda.setText("Ayuda");
        toBtnAyuda.setBorder(null);
        toBtnAyuda.setBorderPainted(false);
        toBtnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnAyuda.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnAyudaStateChanged(evt);
            }
        });
        toBtnAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnAyudaMouseClicked(evt);
            }
        });
        toBtnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBtnAyudaActionPerformed(evt);
            }
        });
        panelMenu.add(toBtnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 120, 50));

        toBtnMascota.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnMascota);
        toBtnMascota.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnMascota.setForeground(new java.awt.Color(255, 255, 255));
        toBtnMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-perro-40 (1).png"))); // NOI18N
        toBtnMascota.setText("Mascota");
        toBtnMascota.setBorder(null);
        toBtnMascota.setBorderPainted(false);
        toBtnMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnMascota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnMascotaStateChanged(evt);
            }
        });
        toBtnMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnMascotaMouseClicked(evt);
            }
        });
        toBtnMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBtnMascotaActionPerformed(evt);
            }
        });
        panelMenu.add(toBtnMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 120, 50));

        toBtnMedicamento.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnMedicamento);
        toBtnMedicamento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        toBtnMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-mano-con-una-píldora-40.png"))); // NOI18N
        toBtnMedicamento.setText("Medicamento");
        toBtnMedicamento.setBorder(null);
        toBtnMedicamento.setBorderPainted(false);
        toBtnMedicamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnMedicamento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnMedicamentoStateChanged(evt);
            }
        });
        toBtnMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnMedicamentoMouseClicked(evt);
            }
        });
        panelMenu.add(toBtnMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 150, 50));

        toBtnTratamiento.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnTratamiento);
        toBtnTratamiento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        toBtnTratamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-lista-con-viñetas-40.png"))); // NOI18N
        toBtnTratamiento.setText("Tratamiento");
        toBtnTratamiento.setBorder(null);
        toBtnTratamiento.setBorderPainted(false);
        toBtnTratamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnTratamiento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnTratamientoStateChanged(evt);
            }
        });
        toBtnTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnTratamientoMouseClicked(evt);
            }
        });
        panelMenu.add(toBtnTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 140, 50));

        toBtnServicio.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnServicio);
        toBtnServicio.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnServicio.setForeground(new java.awt.Color(255, 255, 255));
        toBtnServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maletín-médico-40.png"))); // NOI18N
        toBtnServicio.setText("Servicio");
        toBtnServicio.setBorder(null);
        toBtnServicio.setBorderPainted(false);
        toBtnServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnServicio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnServicioStateChanged(evt);
            }
        });
        toBtnServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnServicioMouseClicked(evt);
            }
        });
        panelMenu.add(toBtnServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 120, 50));

        toBtnCitas.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnCitas);
        toBtnCitas.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnCitas.setForeground(new java.awt.Color(255, 255, 255));
        toBtnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-calendario-40.png"))); // NOI18N
        toBtnCitas.setText("Citas");
        toBtnCitas.setBorder(null);
        toBtnCitas.setBorderPainted(false);
        toBtnCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnCitas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnCitasStateChanged(evt);
            }
        });
        toBtnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnCitasMouseClicked(evt);
            }
        });
        panelMenu.add(toBtnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 120, 50));

        toBtnEmpleado.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnEmpleado);
        toBtnEmpleado.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        toBtnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-colaborador-hombre-40 (1).png"))); // NOI18N
        toBtnEmpleado.setText("Empleado");
        toBtnEmpleado.setBorder(null);
        toBtnEmpleado.setBorderPainted(false);
        toBtnEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnEmpleado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnEmpleadoStateChanged(evt);
            }
        });
        toBtnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnEmpleadoMouseClicked(evt);
            }
        });
        toBtnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBtnEmpleadoActionPerformed(evt);
            }
        });
        panelMenu.add(toBtnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 130, 50));

        toBtnCliente.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnCliente);
        toBtnCliente.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnCliente.setForeground(new java.awt.Color(255, 255, 255));
        toBtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-administrador-del-hombre-40 (1).png"))); // NOI18N
        toBtnCliente.setText("Cliente");
        toBtnCliente.setBorder(null);
        toBtnCliente.setBorderPainted(false);
        toBtnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnCliente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnClienteStateChanged(evt);
            }
        });
        toBtnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnClienteMouseClicked(evt);
            }
        });
        toBtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBtnClienteActionPerformed(evt);
            }
        });
        panelMenu.add(toBtnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 50));

        toBtnPuestos.setBackground(new java.awt.Color(26, 188, 156));
        buttonGroup1.add(toBtnPuestos);
        toBtnPuestos.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        toBtnPuestos.setForeground(new java.awt.Color(255, 255, 255));
        toBtnPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maletín-40.png"))); // NOI18N
        toBtnPuestos.setText("Puestos");
        toBtnPuestos.setBorder(null);
        toBtnPuestos.setBorderPainted(false);
        toBtnPuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toBtnPuestos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toBtnPuestosStateChanged(evt);
            }
        });
        toBtnPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toBtnPuestosMouseClicked(evt);
            }
        });
        toBtnPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBtnPuestosActionPerformed(evt);
            }
        });
        panelMenu.add(toBtnPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 120, 50));

        jPanel1.add(panelMenu);
        panelMenu.setBounds(0, 40, 1160, 60);

        panelMEmpleado.setBackground(new java.awt.Color(219, 235, 203));
        panelMEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelMEmpleado.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        AMCerrar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        AMCerrar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AMCerrar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AMCerrar4MouseClicked(evt);
            }
        });
        panelMEmpleado.add(AMCerrar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(26, 188, 156));
        jLabel31.setText("Empleado");
        panelMEmpleado.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        btnAgregarMEmp.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarMEmp.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMEmp.setText("Agregar");
        btnAgregarMEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMEmpActionPerformed(evt);
            }
        });
        panelMEmpleado.add(btnAgregarMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 140, 40));

        spnEdadMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMEmpleado.add(spnEdadMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 110, -1));

        jLabel125.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(26, 188, 156));
        jLabel125.setText("Email:");
        panelMEmpleado.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        txtNombreMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtNombreMEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreMEmpKeyPressed(evt);
            }
        });
        panelMEmpleado.add(txtNombreMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 310, -1));

        jLabel126.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(26, 188, 156));
        jLabel126.setText("Contraseña:");
        panelMEmpleado.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        txtPaternoMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtPaternoMEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaternoMEmpKeyPressed(evt);
            }
        });
        panelMEmpleado.add(txtPaternoMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, -1));

        jLabel127.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(26, 188, 156));
        jLabel127.setText("Sexo:");
        panelMEmpleado.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        radMEmp.add(boxMasculinoMEmp);
        boxMasculinoMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMasculinoMEmp.setForeground(new java.awt.Color(26, 188, 156));
        boxMasculinoMEmp.setText("Masculino");
        boxMasculinoMEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMasculinoMEmpMouseClicked(evt);
            }
        });
        panelMEmpleado.add(boxMasculinoMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jLabel128.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(26, 188, 156));
        jLabel128.setText("Nombre:");
        panelMEmpleado.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        radMEmp.add(boxFemeninoMEmp);
        boxFemeninoMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxFemeninoMEmp.setForeground(new java.awt.Color(26, 188, 156));
        boxFemeninoMEmp.setText("Femenino");
        boxFemeninoMEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxFemeninoMEmpMouseClicked(evt);
            }
        });
        panelMEmpleado.add(boxFemeninoMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        txtMaternoMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtMaternoMEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaternoMEmpKeyPressed(evt);
            }
        });
        panelMEmpleado.add(txtMaternoMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, -1));

        jLabel129.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(26, 188, 156));
        jLabel129.setText("Edad:");
        panelMEmpleado.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        txtEmailMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtEmailMEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailMEmpKeyPressed(evt);
            }
        });
        panelMEmpleado.add(txtEmailMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 250, -1));

        jLabel130.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(26, 188, 156));
        jLabel130.setText("Puesto:");
        panelMEmpleado.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel131.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(26, 188, 156));
        jLabel131.setText("Apellidos:");
        panelMEmpleado.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        itemPuestoMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        itemPuestoMEmp.setForeground(new java.awt.Color(26, 188, 156));
        panelMEmpleado.add(itemPuestoMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, -1));

        txtContraseñaMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtContraseñaMEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaMEmpKeyPressed(evt);
            }
        });
        panelMEmpleado.add(txtContraseñaMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 200, -1));

        txtIdBusquedaMEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMEmpleado.add(txtIdBusquedaMEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 110, -1));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-25.png"))); // NOI18N
        jLabel132.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel132MouseClicked(evt);
            }
        });
        panelMEmpleado.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 30, 30));

        jLabel133.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(26, 188, 156));
        jLabel133.setText("ID:");
        panelMEmpleado.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel1.add(panelMEmpleado);
        panelMEmpleado.setBounds(300, 110, 810, 470);

        panelMCliente.setBackground(new java.awt.Color(219, 235, 203));
        panelMCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelMCliente.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        AMCerrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        AMCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AMCerrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AMCerrar2MouseClicked(evt);
            }
        });
        panelMCliente.add(AMCerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel37.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(26, 188, 156));
        jLabel37.setText("Cliente");
        panelMCliente.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        spnEdadMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        spnEdadMCli.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        panelMCliente.add(spnEdadMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 120, -1));

        jLabel41.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(26, 188, 156));
        jLabel41.setText("Nombre:");
        panelMCliente.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtNombreMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtNombreMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 400, -1));

        jLabel42.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(26, 188, 156));
        jLabel42.setText("Apellidos:");
        panelMCliente.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtApeMatMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtApeMatMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 190, -1));

        txtApePatMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtApePatMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, -1));

        jLabel43.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(26, 188, 156));
        jLabel43.setText("Email:");
        panelMCliente.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtEmailMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtEmailMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 400, -1));

        txtTelefonoMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtTelefonoMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, -1));

        jLabel45.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(26, 188, 156));
        jLabel45.setText("Edad:");
        panelMCliente.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 100, -1));

        radMCli.add(boxMasculinoMCli);
        boxMasculinoMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMasculinoMCli.setForeground(new java.awt.Color(26, 188, 156));
        boxMasculinoMCli.setText("Masculino");
        panelMCliente.add(boxMasculinoMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        radMCli.add(boxFemeninoMCli);
        boxFemeninoMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxFemeninoMCli.setForeground(new java.awt.Color(26, 188, 156));
        boxFemeninoMCli.setText("Femenino");
        panelMCliente.add(boxFemeninoMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        jLabel46.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(26, 188, 156));
        jLabel46.setText("Sexo:");
        panelMCliente.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-hombre-25.png"))); // NOI18N
        panelMCliente.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 30));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-mujer-25.png"))); // NOI18N
        panelMCliente.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, 30));

        jLabel52.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(26, 188, 156));
        jLabel52.setText("Numero de Telefono:");
        panelMCliente.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel53.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(26, 188, 156));
        jLabel53.setText("ID:");
        panelMCliente.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtIdBusquedaMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMCliente.add(txtIdBusquedaMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        btnActualizarMCli.setBackground(new java.awt.Color(255, 205, 66));
        btnActualizarMCli.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnActualizarMCli.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarMCli.setText("Actualizar");
        btnActualizarMCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMCliActionPerformed(evt);
            }
        });
        panelMCliente.add(btnActualizarMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 140, 40));

        labBusquedaMCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-25.png"))); // NOI18N
        labBusquedaMCli.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labBusquedaMCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBusquedaMCliMouseClicked(evt);
            }
        });
        panelMCliente.add(labBusquedaMCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 30, 30));

        jPanel1.add(panelMCliente);
        panelMCliente.setBounds(300, 110, 810, 470);

        panelACita.setBackground(new java.awt.Color(219, 235, 203));
        panelACita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelACita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelACita.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        CMCerrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar3MouseClicked(evt);
            }
        });
        panelACita.add(CMCerrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel61.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(26, 188, 156));
        jLabel61.setText("Citas");
        panelACita.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        jLabel63.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(26, 188, 156));
        jLabel63.setText("Motivo de la cita:");
        panelACita.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtAMotivoCACit.setColumns(20);
        txtAMotivoCACit.setRows(5);
        jScrollPane8.setViewportView(txtAMotivoCACit);

        panelACita.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, 140));

        jLabel64.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(26, 188, 156));
        jLabel64.setText("Fecha Cita:");
        panelACita.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        comClienteACit.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comClienteACit.setForeground(new java.awt.Color(26, 188, 156));
        comClienteACit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comClienteACitActionPerformed(evt);
            }
        });
        panelACita.add(comClienteACit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 240, -1));

        btnAgregarACit.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarACit.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarACit.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarACit.setText("Agregar");
        btnAgregarACit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarACitActionPerformed(evt);
            }
        });
        panelACita.add(btnAgregarACit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 140, 40));

        jLabel65.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(26, 188, 156));
        jLabel65.setText("Cliente:");
        panelACita.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jLabel60.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(26, 188, 156));
        jLabel60.setText("Filtro:");
        panelACita.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        txtFiltroACit.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroACit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroACitActionPerformed(evt);
            }
        });
        txtFiltroACit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroACitKeyPressed(evt);
            }
        });
        panelACita.add(txtFiltroACit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 150, -1));

        comMascotaACit.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comMascotaACit.setForeground(new java.awt.Color(26, 188, 156));
        panelACita.add(comMascotaACit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 240, -1));

        jLabel84.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(26, 188, 156));
        jLabel84.setText("Mascota de la cita:");
        panelACita.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        txtFechaCitaACit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaCitaACit.setText("DD/MM/YY");
        txtFechaCitaACit.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        panelACita.add(txtFechaCitaACit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-calendario-40.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        panelACita.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel86.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(26, 188, 156));
        jLabel86.setText("Empleado:");
        panelACita.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        comEmpleadoACita.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comEmpleadoACita.setForeground(new java.awt.Color(26, 188, 156));
        panelACita.add(comEmpleadoACita, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 240, -1));

        jPanel1.add(panelACita);
        panelACita.setBounds(300, 110, 810, 470);

        panelMMascota.setBackground(new java.awt.Color(219, 235, 203));
        panelMMascota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(26, 188, 156));
        jLabel40.setText("ID:");
        panelMMascota.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelMMascota.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtIdModMasc.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMMascota.add(txtIdModMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        AMCerrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        AMCerrar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AMCerrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AMCerrar3MouseClicked(evt);
            }
        });
        panelMMascota.add(AMCerrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel44.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(26, 188, 156));
        jLabel44.setText("Mascota");
        panelMMascota.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        jButton11.setBackground(new java.awt.Color(26, 188, 156));
        jButton11.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Agregar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        panelMMascota.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 140, 40));

        spnEdadModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        spnEdadModMas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        panelMMascota.add(spnEdadModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 120, -1));

        jLabel49.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(26, 188, 156));
        jLabel49.setText("Especie:");
        panelMMascota.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel50.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(26, 188, 156));
        jLabel50.setText("Sexo:");
        panelMMascota.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        comEspecieModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comEspecieModMas.setForeground(new java.awt.Color(26, 188, 156));
        panelMMascota.add(comEspecieModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 180, -1));

        jLabel51.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(26, 188, 156));
        jLabel51.setText("Edad:");
        panelMMascota.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        radModMas.add(comMasculinoModMas);
        comMasculinoModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comMasculinoModMas.setForeground(new java.awt.Color(26, 188, 156));
        comMasculinoModMas.setText("Masculino");
        panelMMascota.add(comMasculinoModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        radModMas.add(boxFemeninoModMas);
        boxFemeninoModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxFemeninoModMas.setForeground(new java.awt.Color(26, 188, 156));
        boxFemeninoModMas.setText("Femenino");
        panelMMascota.add(boxFemeninoModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        tableConsultaModMas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tableConsultaModMas);

        panelMMascota.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 780, 210));

        txtNombreDueñoModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtNombreDueñoModMas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDueñoModMasKeyPressed(evt);
            }
        });
        panelMMascota.add(txtNombreDueñoModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, -1));

        jLabel54.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(26, 188, 156));
        jLabel54.setText("Dueño:");
        panelMMascota.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-25.png"))); // NOI18N
        jLabel55.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        jLabel55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel55KeyPressed(evt);
            }
        });
        panelMMascota.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 30, 30));

        txtNombreModMas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelMMascota.add(txtNombreModMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 260, -1));

        jLabel56.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(26, 188, 156));
        jLabel56.setText("Nombre:");
        panelMMascota.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-25.png"))); // NOI18N
        jLabel57.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMMascota.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 30, 30));

        jPanel1.add(panelMMascota);
        panelMMascota.setBounds(300, 110, 810, 470);

        panelCMascota.setBackground(new java.awt.Color(219, 235, 203));
        panelCMascota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarMascota.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarMascota.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarMascota.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-perro-40 (4).png"))); // NOI18N
        btnEliminarMascota.setText("Eliminar");
        btnEliminarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMascotaActionPerformed(evt);
            }
        });
        panelCMascota.add(btnEliminarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(26, 188, 156));
        jLabel7.setText("Filtro:");
        panelCMascota.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCMascota.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConMasco.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroConMasco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroConMascoKeyPressed(evt);
            }
        });
        panelCMascota.add(txtFiltroConMasco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrarMouseClicked(evt);
            }
        });
        panelCMascota.add(CMCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(26, 188, 156));
        jLabel8.setText("Mascota");
        panelCMascota.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConsultaMascotaCM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableConsultaMascotaCM);

        panelCMascota.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 310));

        jPanel1.add(panelCMascota);
        panelCMascota.setBounds(300, 110, 810, 470);

        panelAMascota.setBackground(new java.awt.Color(219, 235, 203));
        panelAMascota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAMascota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(26, 188, 156));
        jLabel5.setText("Nombre:");
        panelAMascota.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnAgregarAMasc.setBackground(new java.awt.Color(26, 188, 156));
        btnAgregarAMasc.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarAMasc.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAMasc.setText("Agregar");
        btnAgregarAMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAMascActionPerformed(evt);
            }
        });
        panelAMascota.add(btnAgregarAMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 140, 40));
        panelAMascota.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtNombreMascotaAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelAMascota.add(txtNombreMascotaAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        AMCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        AMCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AMCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AMCerrarMouseClicked(evt);
            }
        });
        panelAMascota.add(AMCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(26, 188, 156));
        jLabel6.setText("Mascota");
        panelAMascota.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        spnEdadAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        spnEdadAM.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        panelAMascota.add(spnEdadAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 120, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(26, 188, 156));
        jLabel10.setText("Especie:");
        panelAMascota.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(26, 188, 156));
        jLabel11.setText("Sexo:");
        panelAMascota.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        comEspecieAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        comEspecieAM.setForeground(new java.awt.Color(26, 188, 156));
        panelAMascota.add(comEspecieAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 180, -1));

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(26, 188, 156));
        jLabel12.setText("Edad:");
        panelAMascota.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        radMMasc.add(boxMascotaMasculinoAM);
        boxMascotaMasculinoAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMascotaMasculinoAM.setForeground(new java.awt.Color(26, 188, 156));
        boxMascotaMasculinoAM.setText("Masculino");
        panelAMascota.add(boxMascotaMasculinoAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        radMMasc.add(boxMascotaFemeninoAM);
        boxMascotaFemeninoAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMascotaFemeninoAM.setForeground(new java.awt.Color(26, 188, 156));
        boxMascotaFemeninoAM.setText("Femenino");
        panelAMascota.add(boxMascotaFemeninoAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        tableConsultaDuenoAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableConsultaDuenoAM);

        panelAMascota.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 780, 210));

        txtNombreDueñoAM.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtNombreDueñoAM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDueñoAMKeyPressed(evt);
            }
        });
        panelAMascota.add(txtNombreDueñoAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 190, -1));

        jLabel38.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(26, 188, 156));
        jLabel38.setText("ID Dueño:");
        panelAMascota.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        labBuscarDueñoAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-25.png"))); // NOI18N
        labBuscarDueñoAM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAMascota.add(labBuscarDueñoAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 30, 30));

        jPanel1.add(panelAMascota);
        panelAMascota.setBounds(300, 110, 810, 470);

        panelACliente.setBackground(new java.awt.Color(219, 235, 203));
        panelACliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelACliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelACliente.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        AMCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        AMCerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AMCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AMCerrar1MouseClicked(evt);
            }
        });
        panelACliente.add(AMCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(26, 188, 156));
        jLabel13.setText("Cliente");
        panelACliente.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        spnEdadAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        spnEdadAC.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        panelACliente.add(spnEdadAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 120, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(26, 188, 156));
        jLabel17.setText("Nombre:");
        panelACliente.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtNombreAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelACliente.add(txtNombreAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 320, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(26, 188, 156));
        jLabel18.setText("Apellidos:");
        panelACliente.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtApeMatAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelACliente.add(txtApeMatAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, -1));

        txtApePatAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelACliente.add(txtApePatAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(26, 188, 156));
        jLabel19.setText("Email:");
        panelACliente.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtEmailAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelACliente.add(txtEmailAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 320, -1));

        txtTelefonoAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelACliente.add(txtTelefonoAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 190, -1));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(26, 188, 156));
        jLabel21.setText("Edad:");
        panelACliente.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 100, -1));

        buttonGroup2.add(boxMasculinoAC);
        boxMasculinoAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMasculinoAC.setForeground(new java.awt.Color(26, 188, 156));
        boxMasculinoAC.setText("Masculino");
        panelACliente.add(boxMasculinoAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        buttonGroup2.add(boxFemeninoAC);
        boxFemeninoAC.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxFemeninoAC.setForeground(new java.awt.Color(26, 188, 156));
        boxFemeninoAC.setText("Femenino");
        panelACliente.add(boxFemeninoAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(26, 188, 156));
        jLabel22.setText("Sexo:");
        panelACliente.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-hombre-25.png"))); // NOI18N
        panelACliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-mujer-25.png"))); // NOI18N
        panelACliente.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, 30));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(26, 188, 156));
        jLabel27.setText("Numero de Telefono:");
        panelACliente.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jButton15.setBackground(new java.awt.Color(26, 188, 156));
        jButton15.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Agregar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        panelACliente.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 140, 40));

        jPanel1.add(panelACliente);
        panelACliente.setBounds(300, 110, 810, 420);

        panelCCliente.setBackground(new java.awt.Color(219, 235, 203));
        panelCCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(26, 188, 156));
        jLabel34.setText("Filtro:");
        panelCCliente.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCCliente.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroCoClie.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroCoClie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroCoClieKeyPressed(evt);
            }
        });
        panelCCliente.add(txtFiltroCoClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar1MouseClicked(evt);
            }
        });
        panelCCliente.add(CMCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel35.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(26, 188, 156));
        jLabel35.setText("Cliente");
        panelCCliente.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableCoClie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableCoClie);

        panelCCliente.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 310));

        btnEliminarCliente.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarCliente.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-colaborador-hombre-40 (5).png"))); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        panelCCliente.add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        jPanel1.add(panelCCliente);
        panelCCliente.setBounds(300, 110, 810, 470);

        panelCCita.setBackground(new java.awt.Color(219, 235, 203));
        panelCCita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCCita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(26, 188, 156));
        jLabel58.setText("Filtro:");
        panelCCita.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCCita.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConCitas.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroConCitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroConCitasKeyPressed(evt);
            }
        });
        panelCCita.add(txtFiltroConCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar2MouseClicked(evt);
            }
        });
        panelCCita.add(CMCerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel59.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(26, 188, 156));
        jLabel59.setText("Citas");
        panelCCita.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConsultaCitasCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tableConsultaCitasCC);

        panelCCita.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 300));

        btnEliminarCita.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarCita.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-calendario-40 (2).png"))); // NOI18N
        btnEliminarCita.setText("Eliminar");
        btnEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCitaActionPerformed(evt);
            }
        });
        panelCCita.add(btnEliminarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-recordatorios-de-citas-30.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        panelCCita.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 30));

        jPanel1.add(panelCCita);
        panelCCita.setBounds(300, 110, 810, 470);

        panelCTratamiento.setBackground(new java.awt.Color(219, 235, 203));
        panelCTratamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCTratamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(26, 188, 156));
        jLabel69.setText("Filtro:");
        panelCTratamiento.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCTratamiento.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConTrat.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroConTrat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroConTratKeyPressed(evt);
            }
        });
        panelCTratamiento.add(txtFiltroConTrat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar5MouseClicked(evt);
            }
        });
        panelCTratamiento.add(CMCerrar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel70.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(26, 188, 156));
        jLabel70.setText("Tratamientos");
        panelCTratamiento.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConTrata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tableConTrata);

        panelCTratamiento.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 300));

        btnEliminarTratamiento.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarTratamiento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarTratamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-lista-con-viñetas-40 (2).png"))); // NOI18N
        btnEliminarTratamiento.setText("Eliminar");
        btnEliminarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTratamientoActionPerformed(evt);
            }
        });
        panelCTratamiento.add(btnEliminarTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        btnAgregarTratamiento.setBackground(new java.awt.Color(59, 205, 121));
        btnAgregarTratamiento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarTratamiento.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarTratamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-lista-con-viñetas-40 (1).png"))); // NOI18N
        btnAgregarTratamiento.setText("Nuevo");
        btnAgregarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTratamientoActionPerformed(evt);
            }
        });
        panelCTratamiento.add(btnAgregarTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 140, 40));

        jPanel1.add(panelCTratamiento);
        panelCTratamiento.setBounds(300, 110, 810, 470);

        panelCMedicamento.setBackground(new java.awt.Color(219, 235, 203));
        panelCMedicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCMedicamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(26, 188, 156));
        jLabel76.setText("Filtro:");
        panelCMedicamento.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCMedicamento.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConMed.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroConMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroConMedKeyPressed(evt);
            }
        });
        panelCMedicamento.add(txtFiltroConMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar6MouseClicked(evt);
            }
        });
        panelCMedicamento.add(CMCerrar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel85.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(26, 188, 156));
        jLabel85.setText("Medicamento");
        panelCMedicamento.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConsultaMedi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tableConsultaMedi);

        panelCMedicamento.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 290));

        btnEliminarMedicamento.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarMedicamento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pastillas-40 (2).png"))); // NOI18N
        btnEliminarMedicamento.setText("Eliminar");
        btnEliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMedicamentoActionPerformed(evt);
            }
        });
        panelCMedicamento.add(btnEliminarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        btnAgregarMedicamento.setBackground(new java.awt.Color(59, 205, 121));
        btnAgregarMedicamento.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgregarMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pastillas-40 (1).png"))); // NOI18N
        btnAgregarMedicamento.setText("Nuevo");
        btnAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedicamentoActionPerformed(evt);
            }
        });
        panelCMedicamento.add(btnAgregarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 140, 40));

        jPanel1.add(panelCMedicamento);
        panelCMedicamento.setBounds(300, 110, 810, 470);

        panelCPuesto.setBackground(new java.awt.Color(219, 235, 203));
        panelCPuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCPuesto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(26, 188, 156));
        jLabel103.setText("Filtro:");
        panelCPuesto.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCPuesto.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConPuesto.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        panelCPuesto.add(txtFiltroConPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar10MouseClicked(evt);
            }
        });
        panelCPuesto.add(CMCerrar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel106.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(26, 188, 156));
        jLabel106.setText("Puestos");
        panelCPuesto.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane15.setViewportView(jTable12);

        panelCPuesto.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 290));

        jButton32.setBackground(new java.awt.Color(59, 205, 121));
        jButton32.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-trabajo-correspondiente-40 (1).png"))); // NOI18N
        jButton32.setText("Nuevo");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        panelCPuesto.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 140, 40));

        btnEliminarPuesto.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarPuesto.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarPuesto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-trabajo-correspondiente-40 (2).png"))); // NOI18N
        btnEliminarPuesto.setText("Eliminar");
        btnEliminarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPuestoActionPerformed(evt);
            }
        });
        panelCPuesto.add(btnEliminarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        jPanel1.add(panelCPuesto);
        panelCPuesto.setBounds(300, 110, 810, 470);

        panelCServicio.setBackground(new java.awt.Color(219, 235, 203));
        panelCServicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(26, 188, 156));
        jLabel97.setText("ID:");
        panelCServicio.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCServicio.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroConSer.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroConSer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroConSerKeyPressed(evt);
            }
        });
        panelCServicio.add(txtFiltroConSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar9MouseClicked(evt);
            }
        });
        panelCServicio.add(CMCerrar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel98.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(26, 188, 156));
        jLabel98.setText("Servicios");
        panelCServicio.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConsultaServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(tableConsultaServ);

        panelCServicio.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 290));

        btnEliminarServicio.setBackground(new java.awt.Color(221, 79, 64));
        btnEliminarServicio.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnEliminarServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maletín-médico-40 (3).png"))); // NOI18N
        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });
        panelCServicio.add(btnEliminarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        btnAgragarServicio.setBackground(new java.awt.Color(59, 205, 121));
        btnAgragarServicio.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAgragarServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAgragarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maletín-médico-40 (2).png"))); // NOI18N
        btnAgragarServicio.setText("Nuevo");
        btnAgragarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgragarServicioActionPerformed(evt);
            }
        });
        panelCServicio.add(btnAgragarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 140, 40));

        jPanel1.add(panelCServicio);
        panelCServicio.setBounds(300, 110, 810, 470);

        panelCEmpleado.setBackground(new java.awt.Color(219, 235, 203));
        panelCEmpleado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(26, 188, 156));
        jLabel123.setText("Filtro:");
        panelCEmpleado.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        panelCEmpleado.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 10));

        txtFiltroCoEmp.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtFiltroCoEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroCoEmpKeyPressed(evt);
            }
        });
        panelCEmpleado.add(txtFiltroCoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, -1));

        CMCerrar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-24.png"))); // NOI18N
        CMCerrar11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CMCerrar11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMCerrar11MouseClicked(evt);
            }
        });
        panelCEmpleado.add(CMCerrar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        jLabel124.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(26, 188, 156));
        jLabel124.setText("Empleado");
        panelCEmpleado.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        tableConsultaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane16.setViewportView(tableConsultaEmp);

        panelCEmpleado.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 310));

        jButton34.setBackground(new java.awt.Color(221, 79, 64));
        jButton34.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Eliminar");
        panelCEmpleado.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 40));

        jPanel1.add(panelCEmpleado);
        panelCEmpleado.setBounds(300, 110, 810, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 200, 350, 261);

        labAMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-perro-40 (3).png"))); // NOI18N
        labAMascota.setText("Agragar Mascota");
        labAMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labAMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labAMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labAMascotaMouseClicked(evt);
            }
        });
        jPanel1.add(labAMascota);
        labAMascota.setBounds(-180, 150, 180, 60);

        labCMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-perro-40 (2).png"))); // NOI18N
        labCMascota.setText("Consultar Mascota");
        labCMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCMascotaMouseClicked(evt);
            }
        });
        jPanel1.add(labCMascota);
        labCMascota.setBounds(-180, 220, 180, 60);

        labMMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-perro-40 (5).png"))); // NOI18N
        labMMascota.setText("Modificar Mascota");
        labMMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labMMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMMascotaMouseClicked(evt);
            }
        });
        jPanel1.add(labMMascota);
        labMMascota.setBounds(-180, 290, 180, 60);

        labACliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-administrador-del-hombre-40 (2).png"))); // NOI18N
        labACliente.setText("Agragar Cliente");
        labACliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labACliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labACliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labAClienteMouseClicked(evt);
            }
        });
        jPanel1.add(labACliente);
        labACliente.setBounds(-180, 150, 180, 60);

        labCCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-administrador-del-hombre-40 (5).png"))); // NOI18N
        labCCliente.setText("Consultar Cliente");
        labCCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCClienteMouseClicked(evt);
            }
        });
        jPanel1.add(labCCliente);
        labCCliente.setBounds(-180, 220, 180, 60);

        labMCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-administrador-del-hombre-40 (4).png"))); // NOI18N
        labMCliente.setText("Modificar Cliente");
        labMCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labMCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMClienteMouseClicked(evt);
            }
        });
        jPanel1.add(labMCliente);
        labMCliente.setBounds(-180, 290, 180, 60);

        labCMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-pastillas-40 (3).png"))); // NOI18N
        labCMedicamento.setText("Consultar Medicamento");
        labCMedicamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCMedicamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCMedicamentoMouseClicked(evt);
            }
        });
        jPanel1.add(labCMedicamento);
        labCMedicamento.setBounds(-180, 220, 180, 60);

        labCTratamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-lista-con-viñetas-40 (3).png"))); // NOI18N
        labCTratamiento.setText("Consultar Tratamiento");
        labCTratamiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCTratamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCTratamientoMouseClicked(evt);
            }
        });
        jPanel1.add(labCTratamiento);
        labCTratamiento.setBounds(-180, 220, 180, 60);

        labCServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maletín-médico-40 (4).png"))); // NOI18N
        labCServicio.setText("Consultar Tratamiento");
        labCServicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCServicioMouseClicked(evt);
            }
        });
        jPanel1.add(labCServicio);
        labCServicio.setBounds(-180, 220, 180, 60);

        labACitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-calendario-40 (1).png"))); // NOI18N
        labACitas.setText("Agegar Cita");
        labACitas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labACitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labACitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labACitasMouseClicked(evt);
            }
        });
        jPanel1.add(labACitas);
        labACitas.setBounds(-180, 220, 180, 60);

        labCCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-calendario-40 (4).png"))); // NOI18N
        labCCitas.setText("Consulta Citas");
        labCCitas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCCitasMouseClicked(evt);
            }
        });
        jPanel1.add(labCCitas);
        labCCitas.setBounds(-180, 150, 180, 60);

        labCPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-buscar-trabajo-correspondiente-40.png"))); // NOI18N
        labCPuestos.setText("Consultar Puestos");
        labCPuestos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCPuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCPuestosMouseClicked(evt);
            }
        });
        jPanel1.add(labCPuestos);
        labCPuestos.setBounds(-180, 220, 180, 60);

        labCEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-colaborador-hombre-40 (2).png"))); // NOI18N
        labCEmpleado.setText("Consultar Empleado");
        labCEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labCEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCEmpleadoMouseClicked(evt);
            }
        });
        jPanel1.add(labCEmpleado);
        labCEmpleado.setBounds(-180, 220, 180, 60);

        labMEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-colaborador-hombre-40 (7).png"))); // NOI18N
        labMEmpleado.setText("Modificar Empleado");
        labMEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labMEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMEmpleadoMouseClicked(evt);
            }
        });
        jPanel1.add(labMEmpleado);
        labMEmpleado.setBounds(-180, 150, 180, 60);

        jButton1.setBackground(new java.awt.Color(26, 188, 156));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 530, 100, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMinimizarMouseClicked
        // TODO add your handling code here:

        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_labMinimizarMouseClicked

    private void labMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMinimizarMouseEntered
        // TODO add your handling code here:
        labMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-minimizar-la-ventana-40 (2).png")));
    }//GEN-LAST:event_labMinimizarMouseEntered

    private void labMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMinimizarMouseExited
        // TODO add your handling code here:
        labMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-minimizar-la-ventana-40.png")));
    }//GEN-LAST:event_labMinimizarMouseExited

    private void labMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizarMouseClicked
        // TODO add your handling code here:

        int dialog = JOptionPane.showConfirmDialog(null, "Deceas cerrar la ventana?", "Salir",  JOptionPane.YES_NO_OPTION);
        if( dialog == 0 ){

            dispose();
        }
    }//GEN-LAST:event_labMaximizarMouseClicked

    private void labMaximizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizarMouseEntered
        // TODO add your handling code here:
        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40 (2).png")));
    }//GEN-LAST:event_labMaximizarMouseEntered

    private void labMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizarMouseExited
        // TODO add your handling code here:

        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png")));
    }//GEN-LAST:event_labMaximizarMouseExited

    private void toBtnAyudaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnAyudaStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_toBtnAyudaStateChanged

    private void toBtnAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnAyudaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_toBtnAyudaMouseClicked

    private void toBtnClienteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnClienteStateChanged
        // TODO add your handling code here:
        if(toBtnCliente.isSelected()){
            
            internet.jLabelXRight(-180, 20, 10, 5, labACliente);
            internet.jLabelXRight(-180, 20, 10, 7, labCCliente);
            internet.jLabelXRight(-180, 20, 10, 9, labMCliente);
            //internet.jLabelXRight(-180, 20, 10, 10, labECliente);
        }else{
            
            internet.jLabelXLeft(20, -180, 10, 5, labACliente);
            internet.jLabelXLeft(20, -180, 10, 5, labCCliente);
            internet.jLabelXLeft(20, -180, 10, 5, labMCliente);
            //internet.jLabelXLeft(20, -180, 10, 5, labECliente);
            //JOptionPane.showMessageDialog(null, "Click");
        }
    }//GEN-LAST:event_toBtnClienteStateChanged

    private void toBtnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnClienteMouseClicked

    private void toBtnMascotaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnMascotaStateChanged
        // TODO add your handling code here:
        if(toBtnMascota.isSelected()){
            
            internet.jLabelXRight(-180, 20, 10, 5, labAMascota);
            internet.jLabelXRight(-180, 20, 10, 7, labCMascota);
            internet.jLabelXRight(-180, 20, 10, 9, labMMascota);
            //internet.jLabelXRight(-180, 20, 10, 10, labEMascota);
        }else{
            
            internet.jLabelXLeft(20, -180, 10, 5, labAMascota);
            internet.jLabelXLeft(20, -180, 10, 5, labCMascota);
            internet.jLabelXLeft(20, -180, 10, 5, labMMascota);
            //internet.jLabelXLeft(20, -180, 10, 5, labEMascota);
            //JOptionPane.showMessageDialog(null, "Click");
        }
    }//GEN-LAST:event_toBtnMascotaStateChanged

    private void toBtnMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnMascotaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnMascotaMouseClicked

    private void toBtnMedicamentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnMedicamentoStateChanged
        // TODO add your handling code here:
        
        if(toBtnMedicamento.isSelected()){
            
            internet.jLabelXRight(-180, 20, 10, 7, labCMedicamento);

        }else{
            
            internet.jLabelXLeft(20, -180, 10, 5, labCMedicamento);

        }
    }//GEN-LAST:event_toBtnMedicamentoStateChanged

    private void toBtnMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnMedicamentoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnMedicamentoMouseClicked

    private void toBtnTratamientoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnTratamientoStateChanged
        // TODO add your handling code here:
        
        if(toBtnTratamiento.isSelected()){
            
            internet.jLabelXRight(-180, 20, 10, 7, labCTratamiento);
        }else{
            
            internet.jLabelXLeft(20, -180, 10, 5, labCTratamiento);
        }
    }//GEN-LAST:event_toBtnTratamientoStateChanged

    private void toBtnTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnTratamientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnTratamientoMouseClicked

    private void toBtnServicioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnServicioStateChanged
        // TODO add your handling code here:
        
        if(toBtnServicio.isSelected()){

            internet.jLabelXRight(-180, 20, 10, 7, labCServicio);
        }else{

            internet.jLabelXLeft(20, -180, 10, 5, labCServicio);
            //JOptionPane.showMessageDialog(null, "Click");
        }
    }//GEN-LAST:event_toBtnServicioStateChanged

    private void toBtnServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnServicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnServicioMouseClicked

    private void toBtnCitasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnCitasStateChanged
        // TODO add your handling code here:
        
        if(toBtnCitas.isSelected()){
            
            internet.jLabelXRight(-180, 20, 10, 5, labCCitas);
            internet.jLabelXRight(-180, 20, 10, 5, labACitas);
        }else{
            
            internet.jLabelXLeft(20, -180, 10, 5, labCCitas);
            internet.jLabelXLeft(20, -180, 10, 5, labACitas);
            //JOptionPane.showMessageDialog(null, "Click");
        }
    }//GEN-LAST:event_toBtnCitasStateChanged

    private void toBtnCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnCitasMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_toBtnCitasMouseClicked

    private void toBtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBtnClienteActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_toBtnClienteActionPerformed

    private void toBtnMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBtnMascotaActionPerformed
        // TODO add your handling code here:
        
        especiehash();
    }//GEN-LAST:event_toBtnMascotaActionPerformed

    private void AMCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMCerrarMouseClicked
        // TODO add your handling code here:
        panelAMascota.setVisible(false);
    }//GEN-LAST:event_AMCerrarMouseClicked

    private void labAMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labAMascotaMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelAMascota.setVisible(true);
    }//GEN-LAST:event_labAMascotaMouseClicked

    private void labAClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labAClienteMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelACliente.setVisible(true);
    }//GEN-LAST:event_labAClienteMouseClicked

    private void CMCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrarMouseClicked
        // TODO add your handling code here:
        panelCMascota.setVisible(false);
    }//GEN-LAST:event_CMCerrarMouseClicked

    private void labCMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCMascotaMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCMascota.setVisible(true);
    }//GEN-LAST:event_labCMascotaMouseClicked

    private void toBtnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBtnAyudaActionPerformed
        // TODO add your handling code here:
        
        if(toBtnAyuda.isSelected()){
        JOptionPane.showMessageDialog(null,"Verción: beta 1.0.0.-a \n Sistema desarrollado por The Developers \n Sitio web www.Veterinaria.com","Ayuda",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_toBtnAyudaActionPerformed

    private void AMCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMCerrar1MouseClicked
        // TODO add your handling code here:
        
        panelACliente.setVisible(false);
    }//GEN-LAST:event_AMCerrar1MouseClicked

    private void CMCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar1MouseClicked
        // TODO add your handling code here:
        
        panelCCliente.setVisible(false);
    }//GEN-LAST:event_CMCerrar1MouseClicked

    private void labCClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCClienteMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCCliente.setVisible(true);
        //panelCCliente.preferredSize();
    }//GEN-LAST:event_labCClienteMouseClicked

    private void AMCerrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMCerrar2MouseClicked
        // TODO add your handling code here:
        
        panelMCliente.setVisible(false);
    }//GEN-LAST:event_AMCerrar2MouseClicked

    private void labMClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMClienteMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelMCliente.setVisible(true);
    }//GEN-LAST:event_labMClienteMouseClicked

    private void AMCerrar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMCerrar3MouseClicked
        // TODO add your handling code here:
        panelMMascota.setVisible(false);
    }//GEN-LAST:event_AMCerrar3MouseClicked

    private void labMMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMMascotaMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelMMascota.setVisible(true);
    }//GEN-LAST:event_labMMascotaMouseClicked

    private void CMCerrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar2MouseClicked
        // TODO add your handling code here:
        panelCCita.setVisible(false);
    }//GEN-LAST:event_CMCerrar2MouseClicked

    private void CMCerrar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar3MouseClicked
        // TODO add your handling code here:
        
        panelACita.setVisible(false);
    }//GEN-LAST:event_CMCerrar3MouseClicked

    private void labACitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labACitasMouseClicked
        // TODO add your handling code here:
        paneles(false);
        empleadohash();
        panelACita.setVisible(true);
    }//GEN-LAST:event_labACitasMouseClicked

    private void labCCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCCitasMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCCita.setVisible(true);
    }//GEN-LAST:event_labCCitasMouseClicked

    private void CMCerrar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar5MouseClicked
        // TODO add your handling code here:
        
        panelCTratamiento.setVisible(false);
    }//GEN-LAST:event_CMCerrar5MouseClicked

    private void labCTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCTratamientoMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCTratamiento.setVisible(true);
    }//GEN-LAST:event_labCTratamientoMouseClicked

    private void toBtnPuestosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnPuestosStateChanged
        // TODO add your handling code here:
        
        if(administrador){
        
            if(toBtnPuestos.isSelected()){

                internet.jLabelXRight(-180, 20, 10, 5, labCPuestos);
                //internet.jLabelXRight(-180, 20, 10, 5, labAPuestos);
            }else{

                internet.jLabelXLeft(20, -180, 10, 5, labCPuestos);
                //internet.jLabelXLeft(20, -180, 10, 5, labAPuestos);
                //JOptionPane.showMessageDialog(null, "Click");
            }
        }
    }//GEN-LAST:event_toBtnPuestosStateChanged

    private void toBtnPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnPuestosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnPuestosMouseClicked

    private void toBtnPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBtnPuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnPuestosActionPerformed

    private void toBtnEmpleadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_toBtnEmpleadoStateChanged
        // TODO add your handling code here:
        
        if(administrador){
        
            if(toBtnEmpleado.isSelected()){

                internet.jLabelXRight(-180, 20, 10, 5, labCEmpleado);
                internet.jLabelXRight(-180, 20, 10, 5, labMEmpleado);
            }else{

                internet.jLabelXLeft(20, -180, 10, 5, labCEmpleado);
                internet.jLabelXLeft(20, -180, 10, 5, labMEmpleado);
                //JOptionPane.showMessageDialog(null, "Click");
            }
        }
    }//GEN-LAST:event_toBtnEmpleadoStateChanged

    private void toBtnEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toBtnEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnEmpleadoMouseClicked

    private void toBtnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBtnEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toBtnEmpleadoActionPerformed

    private void labCPuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCPuestosMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCPuesto.setVisible(true);
    }//GEN-LAST:event_labCPuestosMouseClicked

    private void labCEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCEmpleadoMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCEmpleado.setVisible(true);
    }//GEN-LAST:event_labCEmpleadoMouseClicked

    private void labMEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMEmpleadoMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelMEmpleado.setVisible(true);
    }//GEN-LAST:event_labMEmpleadoMouseClicked

    private void labMaximizar5labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar5labMaximizar1MouseClicked
        // TODO add your handling code here:
        frameACita.setVisible(false);
    }//GEN-LAST:event_labMaximizar5labMaximizar1MouseClicked

    private void labMaximizar5labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar5labMaximizar1MouseEntered
        // TODO add your handling code here:
        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40 (2).png")));
        
    }//GEN-LAST:event_labMaximizar5labMaximizar1MouseEntered

    private void labMaximizar5labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar5labMaximizar1MouseExited
        // TODO add your handling code here:
        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png")));
    }//GEN-LAST:event_labMaximizar5labMaximizar1MouseExited

    private void labMaximizar6labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar6labMaximizar1MouseClicked
        // TODO add your handling code here:
        
        frameATratamiento.setVisible(false);
    }//GEN-LAST:event_labMaximizar6labMaximizar1MouseClicked

    private void labMaximizar6labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar6labMaximizar1MouseEntered
        // TODO add your handling code here:
        
        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40 (2).png")));
        
    }//GEN-LAST:event_labMaximizar6labMaximizar1MouseEntered

    private void labMaximizar6labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar6labMaximizar1MouseExited
        // TODO add your handling code here:
        labMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-ventana-40.png")));
    }//GEN-LAST:event_labMaximizar6labMaximizar1MouseExited

    private void CMCerrar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar6MouseClicked
        // TODO add your handling code here:
        
        panelCMedicamento.setVisible(false);
    }//GEN-LAST:event_CMCerrar6MouseClicked

    private void labCMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCMedicamentoMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCMedicamento.setVisible(true);
    }//GEN-LAST:event_labCMedicamentoMouseClicked

    private void labMaximizar7labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar7labMaximizar1MouseClicked
        // TODO add your handling code here:
        
        frameAMedicamento.setVisible(false);
    }//GEN-LAST:event_labMaximizar7labMaximizar1MouseClicked

    private void labMaximizar7labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar7labMaximizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar7labMaximizar1MouseEntered

    private void labMaximizar7labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar7labMaximizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar7labMaximizar1MouseExited

    private void CMCerrar9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar9MouseClicked
        // TODO add your handling code here:
        
        panelCServicio.setVisible(false);
    }//GEN-LAST:event_CMCerrar9MouseClicked

    private void labMaximizar8labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar8labMaximizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar8labMaximizar1MouseExited

    private void labMaximizar8labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar8labMaximizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar8labMaximizar1MouseEntered

    private void labMaximizar8labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar8labMaximizar1MouseClicked
        // TODO add your handling code here:
        
        frameAServicio.setVisible(false);
    }//GEN-LAST:event_labMaximizar8labMaximizar1MouseClicked

    private void labCServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCServicioMouseClicked
        // TODO add your handling code here:
        paneles(false);
        panelCServicio.setVisible(true);
    }//GEN-LAST:event_labCServicioMouseClicked

    private void CMCerrar10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar10MouseClicked
        // TODO add your handling code here:
        
        panelCPuesto.setVisible(false);
    }//GEN-LAST:event_CMCerrar10MouseClicked

    private void labMaximizar9labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar9labMaximizar1MouseClicked
        // TODO add your handling code here:
        
        frameAPuesto.setVisible(false);
    }//GEN-LAST:event_labMaximizar9labMaximizar1MouseClicked

    private void labMaximizar9labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar9labMaximizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar9labMaximizar1MouseEntered

    private void labMaximizar9labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar9labMaximizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar9labMaximizar1MouseExited

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        
        frameAPuesto.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void AMCerrar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMCerrar4MouseClicked
        // TODO add your handling code here:
        
        panelMEmpleado.setVisible(false);
    }//GEN-LAST:event_AMCerrar4MouseClicked

    private void CMCerrar11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMCerrar11MouseClicked
        // TODO add your handling code here:
        
        panelCEmpleado.setVisible(false);
    }//GEN-LAST:event_CMCerrar11MouseClicked

    private void txtNombreMEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMEmpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMEmpKeyPressed

    private void txtPaternoMEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoMEmpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoMEmpKeyPressed

    private void boxMasculinoMEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMasculinoMEmpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMasculinoMEmpMouseClicked

    private void boxFemeninoMEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxFemeninoMEmpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFemeninoMEmpMouseClicked

    private void txtMaternoMEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoMEmpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaternoMEmpKeyPressed

    private void txtEmailMEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailMEmpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMEmpKeyPressed

    private void txtContraseñaMEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaMEmpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaMEmpKeyPressed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
        if ( esEmail(txtEmailAC.getText())== false){
              
            JOptionPane.showMessageDialog(null,"Email no valido"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{

            if(txtNombreAC.getText().isEmpty()||(txtApePatAC.getText().isEmpty())){


                JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);

            }else{
       
                if(txtApeMatAC.getText().isEmpty()||(txtTelefonoAC.getText().isEmpty())){


                    JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);

                }else{
                    
                    if(txtApeMatAC.getText().isEmpty()||(txtTelefonoAC.getText().isEmpty())){


                        JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);

                    }else{
                        
                    
        
                        try{
                            PreparedStatement psql = cx.prepareStatement("INSERT INTO clientes(nombre, apePat, apeMat, Email, Telefono, edad, Sexo) " + "VALUES(?, ?, ?, ?, ?, ?, ?)");
                            psql.setString(1, txtNombreAC.getText());
                            psql.setString(2, txtApePatAC.getText());
                            psql.setString(3, txtApeMatAC.getText());
                            psql.setString(4, txtEmailAC.getText());
                            psql.setString(5, txtTelefonoAC.getText());
                            psql.setInt(6, (int) spnEdadAC.getValue());
                            if((boxMasculinoAC.isSelected())){
                                psql.setString(7, boxMasculinoAC.getText());
                                boxMasculinoAC.setBackground(Color.GREEN);
                            }else{
                                if((boxFemeninoAC.isSelected())){

                                    psql.setString(7, boxFemeninoAC.getText());
                                    boxMasculinoAC.setBackground(Color.RED);
                                }
                            }
                            
                            //System.out.println(psql);
                            psql.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Datos Guardados");
                            panelACliente.setVisible(false);
                        }catch (SQLException ex ){

                            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
                        }
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void btnAgregarAMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAMascActionPerformed
        // TODO add your handling code here:
        
        if (txtNombreMascotaAM.getText().isEmpty()||(txtNombreDueñoAM.getText().isEmpty())){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
                        
                    
        
                        try{
                            int especie = Integer.parseInt((String)especieHas.get(comEspecieAM.getSelectedItem()));
                            PreparedStatement psql = cx.prepareStatement("INSERT INTO mascotas(nombre, idEspecieMascota, sexo, edad, idClienteMascota) " + "VALUES( ?, ?, ?, ?, ?)");
                            psql.setString(1, txtNombreMascotaAM.getText());
                            psql.setInt(2, especie);
                            if((boxMascotaMasculinoAM.isSelected())){
                                psql.setString(3, boxMascotaMasculinoAM.getText());
                                boxMascotaMasculinoAM.setBackground(Color.GREEN);
                            }else{
                                if((boxMascotaFemeninoAM.isSelected())){

                                    psql.setString(3, boxMascotaFemeninoAM.getText());
                                    boxMascotaFemeninoAM.setBackground(Color.RED);
                                }
                            }
                            psql.setInt(4, (int) spnEdadAM.getValue());
                            psql.setInt(5, Integer.parseInt(txtNombreDueñoAM.getText()));
                            //System.out.println(psql);
                            psql.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Datos Guardados");
                            panelAMascota.setVisible(false);
                        }catch (SQLException ex ){

                            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
                        }
                
        }
    }//GEN-LAST:event_btnAgregarAMascActionPerformed

    private void btnAgregarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPuestoActionPerformed
        // TODO add your handling code here:
        
        if (txtNombreNewPuesto.getText().isEmpty()){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
                        
                    
        
            try{
                PreparedStatement psql = cx.prepareStatement("INSERT INTO puestos(puesto) " + "VALUES( ? )");
                psql.setString(1, txtNombreNewPuesto.getText());
                //System.out.println(psql);
                psql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                frameAPuesto.setVisible(false);
            }catch (SQLException ex ){

                Logger.getLogger(IngresarAdmin.class.getName()).log(Level.SEVERE, null, ex );
            }
                
        }
    }//GEN-LAST:event_btnAgregarPuestoActionPerformed

    private void btnAgregarNewTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNewTratamientoActionPerformed
        // TODO add your handling code here:
        
        if (txtNewTratamiento.getText().isEmpty()||txtCostoNT.getText().isEmpty()){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
                        
                    
        
            try{
                PreparedStatement psql = cx.prepareStatement("INSERT INTO tratamientos(tratamiento, Precio) " + "VALUES( ?, ? )");
                psql.setString(1, txtNewTratamiento.getText());
                psql.setString(2, txtCostoNT.getText());
                //System.out.println(psql);
                psql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                frameATratamiento.setVisible(false);
            }catch (SQLException ex ){

                Logger.getLogger(IngresarAdmin.class.getName()).log(Level.SEVERE, null, ex );
            }
                
        }
    }//GEN-LAST:event_btnAgregarNewTratamientoActionPerformed

    private void btnAgregarAMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAMedActionPerformed
        // TODO add your handling code here:
        
        if (txtNombreAMed.getText().isEmpty()||txtCostoAMed.getText().isEmpty()){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
             
            if (txtMetodoAMed.getText().isEmpty()){
              
                JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
            }else{
                    
        
                try{
                    PreparedStatement psql = cx.prepareStatement("INSERT INTO Medicamentos(medicamento, Precio, Metodo, Cantidad) " + "VALUES( ?, ?, ?, ? )");
                    psql.setString(1, txtNombreAMed.getText());
                    psql.setString(2, txtCostoAMed.getText());
                    psql.setString(3, txtMetodoAMed.getText());
                    psql.setInt(4, (int) spnCantidadAMed.getValue());
                    //System.out.println(psql);
                    psql.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos Guardados");
                    frameAMedicamento.setVisible(false);
                }catch (SQLException ex ){

                    Logger.getLogger(IngresarAdmin.class.getName()).log(Level.SEVERE, null, ex );
                }
            
            }    
        }
    }//GEN-LAST:event_btnAgregarAMedActionPerformed

    private void btnAgregarASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarASActionPerformed
        // TODO add your handling code here:
        
        if (txtNombreServicioAS.getText().isEmpty()||txtCostoAS.getText().isEmpty()){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
                        
                    
        
            try{
                PreparedStatement psql = cx.prepareStatement("INSERT INTO Servicios(Servicio, Precio) " + "VALUES( ?, ? )");
                psql.setString(1, txtNombreServicioAS.getText());
                psql.setString(2, txtCostoAS.getText());
                //System.out.println(psql);
                psql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                frameAServicio.setVisible(false);
            }catch (SQLException ex ){

                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex );
            }
                
        }
    }//GEN-LAST:event_btnAgregarASActionPerformed

    private void btnAgregarACitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarACitActionPerformed
        // TODO add your handling code here:
        
        if (txtFechaCitaACit.getText().isEmpty()||txtFiltroACit.getText().isEmpty()){
              
            JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{
                        
            int cliente = Integer.parseInt((String)global.get(comClienteACit.getSelectedItem()));
            int mascota = Integer.parseInt((String)mascotaCli.get(comMascotaACit.getSelectedItem()));
            int empleado = Integer.parseInt((String)empleadosHas.get(comEmpleadoACita.getSelectedItem()));
        
            try{
                PreparedStatement psql = cx.prepareStatement("INSERT INTO Citas(Fecha, Motivos, idClienteCita, idMascotaCita, idEmpleadosCita ) " + "VALUES( ?, ?, ?, ?, ? )");
                
                psql.setString(1, txtFechaCitaACit.getText());
                psql.setString(2, txtAMotivoCACit.getText());
                psql.setInt(3, cliente );
                psql.setInt(4, mascota );
                psql.setInt(5, empleado );
                psql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                panelACita.setVisible(false);
            }catch (SQLException ex ){

                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex );
            }
                
        }
    }//GEN-LAST:event_btnAgregarACitActionPerformed

    private void txtFiltroACitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroACitKeyPressed
        // TODO add your handling code here:
        
        //global.clear();
        comboFCliente.removeAllElements();
        String idd = (String) txtFiltroACit.getText();
        String sql2 = "SELECT idCliente, Nombre FROM clientes WHERE Nombre LIKE '%" + idd + "%'";
        String datos[] = new String[2];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql2);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                global.put(datos[1], datos[0] );
                //JOptionPane.showMessageDialog(null,datos[0]," ventana de Error",JOptionPane.WARNING_MESSAGE);
                comboFCliente.addElement(datos[1]);
            }
        comClienteACit.setModel(comboFCliente);
        
        } catch (SQLException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtFiltroACitKeyPressed

    private void comClienteACitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comClienteACitActionPerformed

        comboMascotaAC.removeAllElements();
        String s1 = "";
        s1 = (String)global.get(comClienteACit.getSelectedItem());
        String sql2 = "SELECT idMascota, Nombre FROM Mascotas WHERE idClienteMascota = " + s1;
        //System.out.println(sql2);
        String datos[] = new String[2];
            
            try{
                Statement st = null;
                
                st = cx.createStatement();
                ResultSet resp = st.executeQuery(sql2);
                
                while(resp.next()){
                    
                        datos[0] = resp.getString(1);
                        datos[1] = resp.getString(2);
                        mascotaCli.put(datos[1], datos[0]);
                        comboMascotaAC.addElement(datos[1]);
                    
                }
            comMascotaACit.setModel(comboMascotaAC);

            } catch (SQLException ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_comClienteACitActionPerformed

    private void txtFiltroACitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroACitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroACitActionPerformed

    private void btnAgregarMEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMEmpActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnAgregarMEmpActionPerformed

    private void jLabel132MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel132MouseClicked
        // TODO add your handling code here:
        itemPuestoMEmp.removeAllItems();
        String dato = txtIdBusquedaMEmp.getText();
        String sql3 = "SELECT * FROM empleados WHERE idEmpleados = '"+dato+"'";
        //System.out.println(sql3);
        Statement st = null;
        String sexo = "";
        try{
            
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql3);
            resp.first();
            txtNombreMEmp.setText(resp.getString(2));
            txtPaternoMEmp.setText(resp.getString(3));
            txtMaternoMEmp.setText(resp.getString(4));
            txtEmailMEmp.setText(resp.getString(5));
            txtContraseñaMEmp.setText(resp.getString(6));
            if(Objects.equals(resp.getString(7), new String("Masculino"))){
                boxMasculinoMEmp.setSelected(true);
                sexo = "Masculino";
            }else{
                if(Objects.equals(resp.getString(7), new String("Femenino"))){
                    
                    boxFemeninoMEmp.setSelected(true);
                    sexo = "Femenino";
                }
            }
            spnEdadMEmp.setValue(Integer.parseInt(resp.getString(8)));
            itemPuestoMEmp.addItem(resp.getString(9));
            //añadirElementos(itemPuesto);
            //String sql4 = "UPDATE empleado SET Nombre = '"+txtNombreMEmp.getText()+"', ApePat = '"+txtPaternoMEmp.getText()+"', ApeMat = '"+txtMaternoMEmp.getText()+"', Email = '"+txtEmailMEmp.getText()+"', Contrasena = '"+txtContraseñaMEmp.getText()+"', Sexo = '"+sexo+"', Edad = '"+spnEdadMEmp.getValue()+"', idPuestoEmp = '"+ itemPuestoMEmp.getSelectedItem()+"' WHERE id'"+dato+'"';
            //System.out.println(sql4);
        }catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_jLabel132MouseClicked

    private void btnActualizarMCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMCliActionPerformed
        // TODO add your handling code here:
        int ids = Integer.parseInt(txtIdBusquedaMCli.getText());
        String sql4 = "UPDATE Clientes SET Nombre = ?, ApePat = ?, ApeMat = ?, Email = ?, Telefono = ?, Edad = ?, Sexo = ? WHERE idCliente = '"+ids+"'";
        
        try{
            PreparedStatement pstm = cx.prepareStatement(sql4);
            pstm.setString(1, txtNombreMCli.getText());
            pstm.setString(2, txtApePatMCli.getText());
            pstm.setString(3, txtApeMatMCli.getText());
            pstm.setString(4, txtEmailMCli.getText());
            pstm.setString(5, txtTelefonoMCli.getText());
            pstm.setInt(6, (int) spnEdadMCli.getValue());
            if((boxMasculinoMCli.isSelected())){
                pstm.setString(7, boxMasculinoMCli.getText());
            }else{
                if((boxFemeninoMCli.isSelected())){
                    
                    pstm.setString(7, boxFemeninoMCli.getText());
                }
            }
            //System.out.println(sql4);
            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos Modificados");
        }catch(SQLException e){
            
           JOptionPane.showMessageDialog(null, "Error al consultar Datos"); 
        }
    }//GEN-LAST:event_btnActualizarMCliActionPerformed

    private void labBusquedaMCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBusquedaMCliMouseClicked
        // TODO add your handling code here:
        String dato = txtIdBusquedaMCli.getText();
        String sql3 = "SELECT * FROM clientes WHERE idCliente = '"+dato+"'";
        //System.out.println(sql3);
        Statement st = null;
        String sexo = "";
        try{
            
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql3);
            resp.first();
            txtNombreMCli.setText(resp.getString(2));
            txtApePatMCli.setText(resp.getString(3));
            txtApeMatMCli.setText(resp.getString(4));
            txtEmailMCli.setText(resp.getString(5));
            txtTelefonoMCli.setText(resp.getString(6));
            spnEdadMCli.setValue(Integer.parseInt(resp.getString(7)));
            if(Objects.equals(resp.getString(8), new String("Masculino"))){
                boxMasculinoMCli.setSelected(true);
                sexo = "Masculino";
            }else{
                if(Objects.equals(resp.getString(8), new String("Femenino"))){
                    
                    boxFemeninoMCli.setSelected(true);
                    sexo = "Femenino";
                }
            }
            
            //añadirElementos(itemPuesto);
            //String sql4 = "UPDATE empleado SET Nombre = '"+txtNombreMEmp.getText()+"', ApePat = '"+txtPaternoMEmp.getText()+"', ApeMat = '"+txtMaternoMEmp.getText()+"', Email = '"+txtEmailMEmp.getText()+"', Contrasena = '"+txtContraseñaMEmp.getText()+"', Sexo = '"+sexo+"', Edad = '"+spnEdadMEmp.getValue()+"', idPuestoEmp = '"+ itemPuestoMEmp.getSelectedItem()+"' WHERE id'"+dato+'"';
            //System.out.println(sql4);
        }catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_labBusquedaMCliMouseClicked

    private void txtFiltroCoEmpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCoEmpKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Sexo");
        modelo.addColumn("Edad");
        modelo.addColumn("Puesto");
        tableConsultaEmp.setModel(modelo);
        String sql1 = "SELECT * FROM empleados WHERE idEmpleados LIKE '%" + txtFiltroCoEmp.getText() + "%' OR Nombre LIKE '%" + txtFiltroCoEmp.getText() + "%' OR ApePat LIKE '%" + txtFiltroCoEmp.getText() + "%' OR ApeMat LIKE '%" + txtFiltroCoEmp.getText() + "%'";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                datos[6] = resp.getString(7);
                datos[7] = resp.getString(8);
                datos[8] = resp.getString(9);
                modelo.addRow(datos);
            }
        tableConsultaEmp.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroCoEmpKeyPressed

    private void txtFiltroCoClieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroCoClieKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        tableCoClie.setModel(modelo);
        String sql1 = "SELECT * FROM clientes WHERE idCliente LIKE '%" + txtFiltroCoClie.getText() + "%' OR Nombre LIKE '%" + txtFiltroCoClie.getText() + "%' OR ApePat LIKE '%" + txtFiltroCoClie.getText() + "%' OR ApeMat LIKE '%" + txtFiltroCoClie.getText() + "%'";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                datos[6] = resp.getString(7);
                datos[7] = resp.getString(8);
                modelo.addRow(datos);
            }
        tableCoClie.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroCoClieKeyPressed

    private void txtNombreDueñoAMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDueñoAMKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        tableConsultaDuenoAM.setModel(modelo);
        String sql1 = "SELECT * FROM clientes WHERE idCliente LIKE '%" + txtNombreDueñoAM.getText() + "%' ";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                datos[6] = resp.getString(7);
                datos[7] = resp.getString(8);
                modelo.addRow(datos);
            }
        tableConsultaDuenoAM.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtNombreDueñoAMKeyPressed

    private void txtNombreDueñoModMasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDueñoModMasKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Edad");
        modelo.addColumn("Sexo");
        tableConsultaModMas.setModel(modelo);
        String sql1 = "SELECT * FROM clientes WHERE idCliente LIKE '%" + txtNombreDueñoModMas.getText() + "%' ";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                datos[6] = resp.getString(7);
                datos[7] = resp.getString(8);
                modelo.addRow(datos);
            }
        tableConsultaModMas.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtNombreDueñoModMasKeyPressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        int ids = Integer.parseInt(txtIdModMasc.getText());
        int especie = Integer.parseInt((String)especieHas.get(comEspecieModMas.getSelectedItem()));
        String sql4 = "UPDATE Mascotas SET Nombre = ?, idEspecieMascota = ?, Sexo = ?, Edad = ?, idClienteMascota = ? WHERE idCliente = '"+ids+"'";
        
        try{
            PreparedStatement pstm = cx.prepareStatement(sql4);
            pstm.setString(1, txtNombreModMas.getText());
            pstm.setInt(2, especie);
            if((comMasculinoModMas.isSelected())){
                pstm.setString(3, comMasculinoModMas.getText());
            }else{
                if((boxFemeninoModMas.isSelected())){
                    
                    pstm.setString(3, boxFemeninoModMas.getText());
                }
            }
            pstm.setInt(4, (int) spnEdadModMas.getValue());
            pstm.setString(4, txtNombreDueñoModMas.getText());
            //System.out.println(sql4);
            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos Modificados");
        }catch(SQLException e){
            
           JOptionPane.showMessageDialog(null, "Error al consultar Datos"); 
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel55KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel55KeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jLabel55KeyPressed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
        
        String dato = txtIdModMasc.getText();
        String sql3 = "SELECT * FROM Mascotas WHERE idMascota = '"+dato+"'";
        //System.out.println(sql3);
        Statement st = null;
        String sexo = "";
        try{
            
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql3);
            resp.first();
            txtNombreModMas.setText(resp.getString(2));
            comEspecieModMas.addItem(resp.getString(3));
            if(Objects.equals(resp.getString(4), new String("Masculino"))){
                comMasculinoModMas.setSelected(true);
                sexo = "Masculino";
            }else{
                if(Objects.equals(resp.getString(4), new String("Femenino"))){
                    
                    boxFemeninoModMas.setSelected(true);
                    sexo = "Femenino";
                }
            }
            spnEdadModMas.setValue(Integer.parseInt(resp.getString(5)));
            txtNombreDueñoModMas.setText(resp.getString(6));
            
            //añadirElementos(itemPuesto);
            //String sql4 = "UPDATE empleado SET Nombre = '"+txtNombreMEmp.getText()+"', ApePat = '"+txtPaternoMEmp.getText()+"', ApeMat = '"+txtMaternoMEmp.getText()+"', Email = '"+txtEmailMEmp.getText()+"', Contrasena = '"+txtContraseñaMEmp.getText()+"', Sexo = '"+sexo+"', Edad = '"+spnEdadMEmp.getValue()+"', idPuestoEmp = '"+ itemPuestoMEmp.getSelectedItem()+"' WHERE id'"+dato+'"';
            //System.out.println(sql4);
        }catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_jLabel55MouseClicked

    private void txtFiltroConMascoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroConMascoKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Sexo");
        modelo.addColumn("Edad");
        modelo.addColumn("Dueño");
        tableConsultaMascotaCM.setModel(modelo);
        String sql1 = "SELECT * FROM Mascotas WHERE idMascota LIKE '%" + txtFiltroConMasco.getText() + "%' OR Nombre LIKE '%" + txtFiltroConMasco.getText() + "%' ";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                modelo.addRow(datos);
            }
        tableConsultaMascotaCM.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroConMascoKeyPressed

    private void txtFiltroConMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroConMedKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Medicamento");
        modelo.addColumn("Precio");
        modelo.addColumn("Metodo");
        modelo.addColumn("Cantidad");
        tableConsultaMedi.setModel(modelo);
        String sql1 = "SELECT * FROM Medicamentos WHERE idMedicamento LIKE '%" + txtFiltroConMed.getText() + "%'";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                modelo.addRow(datos);
            }
        tableConsultaMedi.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroConMedKeyPressed

    private void txtFiltroConTratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroConTratKeyPressed
        // TODO add your handling code here:
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Precio");
        tableConTrata.setModel(modelo);
        String sql1 = "SELECT * FROM Tratamientos WHERE idTratamiento LIKE '%" + txtFiltroConTrat.getText() + "%'";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                modelo.addRow(datos);
            }
        tableConTrata.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroConTratKeyPressed

    private void txtFiltroConSerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroConSerKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Servicio");
        modelo.addColumn("Precio");
        tableConsultaServ.setModel(modelo);
        String sql1 = "SELECT * FROM servicios WHERE idServicio LIKE '%" + txtFiltroConSer.getText() + "%'";
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                modelo.addRow(datos);
            }
        tableConsultaServ.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroConSerKeyPressed

    private void btnAgregarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTratamientoActionPerformed
        // TODO add your handling code here:
        if(administrador){
            
            frameATratamiento.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarTratamientoActionPerformed

    private void btnAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicamentoActionPerformed
        // TODO add your handling code here:
        if(administrador){
            
            frameAMedicamento.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarMedicamentoActionPerformed

    private void btnAgragarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgragarServicioActionPerformed
        // TODO add your handling code here:
        if(administrador){
            
            frameAServicio.setVisible(true);
        }
    }//GEN-LAST:event_btnAgragarServicioActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        // TODO add your handling code here:
        if(administrador){
            
            String sql4 = "DELETE FROM Servicios WHERE idServicio = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConSer.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if(i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConSer.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");;
            }
        }
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void btnEliminarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPuestoActionPerformed
        // TODO add your handling code here:
        
        if(administrador){
            
            String sql4 = "DELETE FROM Puestos WHERE idServicio = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConPuesto.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if(i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConPuesto.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");;
            }
        }
    }//GEN-LAST:event_btnEliminarPuestoActionPerformed

    private void btnEliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMedicamentoActionPerformed
        // TODO add your handling code here:
        
        if(administrador){
            
            String sql4 = "DELETE FROM Medicamentos WHERE idMedicamento = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConMed.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if(i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConMed.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");
            }
        }
    }//GEN-LAST:event_btnEliminarMedicamentoActionPerformed

    private void btnEliminarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTratamientoActionPerformed
        // TODO add your handling code here:
        
        if(administrador){
            
            String sql4 = "DELETE FROM Tratamientos WHERE idTratamiento = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConTrat.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if(i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConTrat.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");;
            }
        }
    }//GEN-LAST:event_btnEliminarTratamientoActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        String date = ano+"/"+mes+"/"+dia;
        System.out.println(date);
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Motivos");
        modelo.addColumn("Cliente");
        modelo.addColumn("Mascota");
        modelo.addColumn("Empleado");
        tableConsultaCitasCC.setModel(modelo);
        String sql1 = "SELECT * FROM Citas WHERE Fecha = '" + date + "'" ;
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                modelo.addRow(datos);
            }
        tableConsultaCitasCC.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        frameCalendario.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String fechaActual="";
        String año = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
        String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
        String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));

        txtFechaCitaACit.setText(año+"/"+mes+"/"+dia);

        frameCalendario.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtFiltroConCitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroConCitasKeyPressed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Motivos");
        modelo.addColumn("Cliente");
        modelo.addColumn("Mascota");
        modelo.addColumn("Empleado");
        tableConsultaCitasCC.setModel(modelo);
        String sql1 = "SELECT * FROM Citas WHERE Fecha LIKE '%"+txtFiltroConCitas.getText()+"%'" ;
        String datos[] = new String[9];
        try{
            Statement st = null;
            st = cx.createStatement();
            ResultSet resp = st.executeQuery(sql1);
            while(resp.next()){
                
                datos[0] = resp.getString(1);
                datos[1] = resp.getString(2);
                datos[2] = resp.getString(3);
                datos[3] = resp.getString(4);
                datos[4] = resp.getString(5);
                datos[5] = resp.getString(6);
                modelo.addRow(datos);
            }
        tableConsultaCitasCC.setModel(modelo);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar Datos");
        }
    }//GEN-LAST:event_txtFiltroConCitasKeyPressed

    private void btnEliminarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMascotaActionPerformed
        // TODO add your handling code here:
        //tableConsultaMascotaCM.get
        if(administrador){
            
            String sql4 = "DELETE FROM Mascotas WHERE idMascota = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConMasco.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if( i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConMasco.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");
            }
        }
    }//GEN-LAST:event_btnEliminarMascotaActionPerformed

    private void btnEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitaActionPerformed
        // TODO add your handling code here:
        
        if(administrador){
            
            String sql4 = "DELETE FROM Citas WHERE idCita = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroConCitas.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if( i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroConCitas.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");
            }
        }
    }//GEN-LAST:event_btnEliminarCitaActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        
        if(administrador){
            
            String sql4 = "DELETE FROM Cliente WHERE idCliente = ? ";
            int i = 0;
            i = JOptionPane.showConfirmDialog(null, "Seguro deceas eliminar este ID = "+txtFiltroCoClie.getText(), "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            try{

                if( i == 0 ){

                    PreparedStatement pst = cx.prepareStatement(sql4);
                    pst.setString(1, txtFiltroCoClie.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    //tabla();
                }else{

                    JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro");
                }
            }catch(SQLException ex){

                JOptionPane.showMessageDialog(null, "Error al consultar Datos");
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void labMaximizar10labMaximizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar10labMaximizar1MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.showConfirmDialog(null, "Deceas cerrar la ventana?", "Salir",  JOptionPane.YES_NO_OPTION);
        if( dialog == 0 ){

            frameVentas.dispose();
        }
    }//GEN-LAST:event_labMaximizar10labMaximizar1MouseClicked

    private void labMaximizar10labMaximizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar10labMaximizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar10labMaximizar1MouseEntered

    private void labMaximizar10labMaximizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMaximizar10labMaximizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_labMaximizar10labMaximizar1MouseExited

    private void btnAgregarPuesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPuesto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPuesto1ActionPerformed

    private void btnAgregarPuesto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPuesto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPuesto2ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frameVentas.setVisible(true);
        frameVentas.setLocationRelativeTo(this);
        serviciohash();
        tratamientohash();
        medicamentohash();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuUsuario().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AMCerrar;
    private javax.swing.JLabel AMCerrar1;
    private javax.swing.JLabel AMCerrar2;
    private javax.swing.JLabel AMCerrar3;
    private javax.swing.JLabel AMCerrar4;
    private javax.swing.JLabel CMCerrar;
    private javax.swing.JLabel CMCerrar1;
    private javax.swing.JLabel CMCerrar10;
    private javax.swing.JLabel CMCerrar11;
    private javax.swing.JLabel CMCerrar2;
    private javax.swing.JLabel CMCerrar3;
    private javax.swing.JLabel CMCerrar5;
    private javax.swing.JLabel CMCerrar6;
    private javax.swing.JLabel CMCerrar9;
    private javax.swing.JRadioButton boxFemeninoAC;
    private javax.swing.JRadioButton boxFemeninoMCli;
    private javax.swing.JRadioButton boxFemeninoMEmp;
    private javax.swing.JRadioButton boxFemeninoModMas;
    private javax.swing.JRadioButton boxMascotaFemeninoAM;
    private javax.swing.JRadioButton boxMascotaMasculinoAM;
    private javax.swing.JRadioButton boxMasculinoAC;
    private javax.swing.JRadioButton boxMasculinoMCli;
    private javax.swing.JRadioButton boxMasculinoMEmp;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizarMCli;
    private javax.swing.JButton btnAgragarServicio;
    private javax.swing.JButton btnAgregarACit;
    private javax.swing.JButton btnAgregarAMasc;
    private javax.swing.JButton btnAgregarAMed;
    private javax.swing.JButton btnAgregarAS;
    private javax.swing.JButton btnAgregarMEmp;
    private javax.swing.JButton btnAgregarMedicamento;
    private javax.swing.JButton btnAgregarNewTratamiento;
    private javax.swing.JButton btnAgregarPuesto;
    private javax.swing.JButton btnAgregarPuesto1;
    private javax.swing.JButton btnAgregarPuesto2;
    private javax.swing.JButton btnAgregarTratamiento;
    private javax.swing.JButton btnEliminarCita;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarMascota;
    private javax.swing.JButton btnEliminarMedicamento;
    private javax.swing.JButton btnEliminarPuesto;
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnEliminarTratamiento;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JComboBox<String> comClienteACit;
    private javax.swing.JComboBox<String> comEmpleadoACita;
    private javax.swing.JComboBox<String> comEmpleadoACita1;
    private javax.swing.JComboBox<String> comEspecieAM;
    private javax.swing.JComboBox<String> comEspecieModMas;
    private javax.swing.JComboBox<String> comMascotaACit;
    private javax.swing.JRadioButton comMasculinoModMas;
    private javax.swing.JComboBox<String> comMedicamentoVen;
    private javax.swing.JComboBox<String> comServicioVen;
    private javax.swing.JComboBox<String> comTratamientoVen;
    private javax.swing.JFrame frameACita;
    private javax.swing.JFrame frameAMedicamento;
    private javax.swing.JFrame frameAPuesto;
    private javax.swing.JFrame frameAServicio;
    private javax.swing.JFrame frameATratamiento;
    private javax.swing.JFrame frameCalendario;
    private javax.swing.JFrame frameVentas;
    private javax.swing.JComboBox<String> itemPuestoMEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton34;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable12;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labACitas;
    private javax.swing.JLabel labACliente;
    private javax.swing.JLabel labAMascota;
    private javax.swing.JLabel labBuscarDueñoAM;
    private javax.swing.JLabel labBusquedaMCli;
    private javax.swing.JLabel labCCitas;
    private javax.swing.JLabel labCCliente;
    private javax.swing.JLabel labCEmpleado;
    private javax.swing.JLabel labCMascota;
    private javax.swing.JLabel labCMedicamento;
    private javax.swing.JLabel labCPuestos;
    private javax.swing.JLabel labCServicio;
    private javax.swing.JLabel labCTratamiento;
    private javax.swing.JLabel labMCliente;
    private javax.swing.JLabel labMEmpleado;
    private javax.swing.JLabel labMMascota;
    private javax.swing.JLabel labMaximizar;
    private javax.swing.JLabel labMaximizar10;
    private javax.swing.JLabel labMaximizar5;
    private javax.swing.JLabel labMaximizar6;
    private javax.swing.JLabel labMaximizar7;
    private javax.swing.JLabel labMaximizar8;
    private javax.swing.JLabel labMaximizar9;
    private javax.swing.JLabel labMinimizar;
    private javax.swing.JPanel panelACita;
    private javax.swing.JPanel panelACliente;
    private javax.swing.JPanel panelAMascota;
    private javax.swing.JPanel panelCCita;
    private javax.swing.JPanel panelCCliente;
    private javax.swing.JPanel panelCEmpleado;
    private javax.swing.JPanel panelCMascota;
    private javax.swing.JPanel panelCMedicamento;
    private javax.swing.JPanel panelCPuesto;
    private javax.swing.JPanel panelCServicio;
    private javax.swing.JPanel panelCTratamiento;
    private javax.swing.JPanel panelMCliente;
    private javax.swing.JPanel panelMEmpleado;
    private javax.swing.JPanel panelMMascota;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel pestaña;
    private javax.swing.JPanel pestaña10;
    private javax.swing.JPanel pestaña5;
    private javax.swing.JPanel pestaña6;
    private javax.swing.JPanel pestaña7;
    private javax.swing.JPanel pestaña8;
    private javax.swing.JPanel pestaña9;
    private javax.swing.ButtonGroup radMCli;
    private javax.swing.ButtonGroup radMEmp;
    private javax.swing.ButtonGroup radMMasc;
    private javax.swing.ButtonGroup radModMas;
    private javax.swing.JSpinner spnCantidadAMed;
    private javax.swing.JSpinner spnEdadAC;
    private javax.swing.JSpinner spnEdadAM;
    private javax.swing.JSpinner spnEdadMCli;
    private javax.swing.JSpinner spnEdadMEmp;
    private javax.swing.JSpinner spnEdadModMas;
    private javax.swing.JTable tableCoClie;
    private javax.swing.JTable tableConTrata;
    private javax.swing.JTable tableConsultaCitasCC;
    private javax.swing.JTable tableConsultaDuenoAM;
    private javax.swing.JTable tableConsultaEmp;
    private javax.swing.JTable tableConsultaMascotaCM;
    private javax.swing.JTable tableConsultaMedi;
    private javax.swing.JTable tableConsultaModMas;
    private javax.swing.JTable tableConsultaServ;
    private javax.swing.JToggleButton toBtnAyuda;
    private javax.swing.JToggleButton toBtnCitas;
    private javax.swing.JToggleButton toBtnCliente;
    private javax.swing.JToggleButton toBtnEmpleado;
    private javax.swing.JToggleButton toBtnMascota;
    private javax.swing.JToggleButton toBtnMedicamento;
    private javax.swing.JToggleButton toBtnPuestos;
    private javax.swing.JToggleButton toBtnServicio;
    private javax.swing.JToggleButton toBtnTratamiento;
    private javax.swing.JTextArea txtAMotivoCACit;
    private javax.swing.JTextField txtApeMatAC;
    private javax.swing.JTextField txtApeMatMCli;
    private javax.swing.JTextField txtApePatAC;
    private javax.swing.JTextField txtApePatMCli;
    private javax.swing.JTextField txtContraseñaMEmp;
    private javax.swing.JTextField txtCostoAMed;
    private javax.swing.JTextField txtCostoAS;
    private javax.swing.JTextField txtCostoNT;
    private javax.swing.JTextField txtEmailAC;
    private javax.swing.JTextField txtEmailMCli;
    private javax.swing.JTextField txtEmailMEmp;
    private javax.swing.JFormattedTextField txtFechaCitaACit;
    private javax.swing.JTextField txtFiltroACit;
    private javax.swing.JTextField txtFiltroCoClie;
    private javax.swing.JTextField txtFiltroCoEmp;
    private javax.swing.JTextField txtFiltroConCitas;
    private javax.swing.JTextField txtFiltroConMasco;
    private javax.swing.JTextField txtFiltroConMed;
    private javax.swing.JTextField txtFiltroConPuesto;
    private javax.swing.JTextField txtFiltroConSer;
    private javax.swing.JTextField txtFiltroConTrat;
    private javax.swing.JTextField txtIdBusquedaMCli;
    private javax.swing.JTextField txtIdBusquedaMEmp;
    private javax.swing.JTextField txtIdModMasc;
    private javax.swing.JTextField txtMaternoMEmp;
    private javax.swing.JTextField txtMetodoAMed;
    private javax.swing.JTextField txtNewTratamiento;
    private javax.swing.JTextField txtNombre26;
    private javax.swing.JTextField txtNombreAC;
    private javax.swing.JTextField txtNombreAMed;
    private javax.swing.JTextField txtNombreDueñoAM;
    private javax.swing.JTextField txtNombreDueñoModMas;
    private javax.swing.JTextField txtNombreMCli;
    private javax.swing.JTextField txtNombreMEmp;
    private javax.swing.JTextField txtNombreMascotaAM;
    private javax.swing.JTextField txtNombreModMas;
    private javax.swing.JTextField txtNombreNewPuesto;
    private javax.swing.JTextField txtNombreNewPuesto1;
    private javax.swing.JTextField txtNombreNewPuesto2;
    private javax.swing.JTextField txtNombreServicioAS;
    private javax.swing.JTextField txtPaternoMEmp;
    private javax.swing.JTextField txtTelefonoAC;
    private javax.swing.JTextField txtTelefonoMCli;
    // End of variables declaration//GEN-END:variables
}
