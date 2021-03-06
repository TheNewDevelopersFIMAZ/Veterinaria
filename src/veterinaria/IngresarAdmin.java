/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Armando
 */
public class IngresarAdmin extends javax.swing.JFrame {

    ConexionBD cox = new ConexionBD();
    Connection cx;
    PlaceHolder holder;
    
    public IngresarAdmin() throws ClassNotFoundException {
        
        this.cx = cox.conexion();
        this.cox = new ConexionBD();
        initComponents();
        this.setLocationRelativeTo(null);
        holder = new PlaceHolder(txtNombre, "Please! enter your name");
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
        labMaximizar = new javax.swing.JLabel();
        labMinimizar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApePat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtContra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApeMat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        boxMasculino = new javax.swing.JRadioButton();
        boxFemenino = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        spnEdad = new javax.swing.JSpinner();
        btnAgregarAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(labMaximizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

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
        getContentPane().add(labMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(236, 244, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 188, 156)));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 188, 156));
        jLabel4.setText("Registro de Administrador");

        jSeparator1.setForeground(new java.awt.Color(26, 188, 156));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(26, 188, 156));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(26, 188, 156));
        jLabel5.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        txtApePat.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtApePat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApePatActionPerformed(evt);
            }
        });
        txtApePat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApePatKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(26, 188, 156));
        jLabel6.setText("Apellidos:");

        txtEmail.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(26, 188, 156));
        jLabel7.setText("Email:");

        txtContra.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(26, 188, 156));
        jLabel8.setText("Contraseña:");

        txtApeMat.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        txtApeMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeMatActionPerformed(evt);
            }
        });
        txtApeMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeMatKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(26, 188, 156));
        jLabel9.setText("Sexo:");

        buttonGroup1.add(boxMasculino);
        boxMasculino.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxMasculino.setForeground(new java.awt.Color(26, 188, 156));
        boxMasculino.setText("Masculino");
        boxMasculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMasculinoMouseClicked(evt);
            }
        });
        boxMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMasculinoActionPerformed(evt);
            }
        });

        buttonGroup1.add(boxFemenino);
        boxFemenino.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        boxFemenino.setForeground(new java.awt.Color(26, 188, 156));
        boxFemenino.setText("Femenino");
        boxFemenino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxFemeninoMouseClicked(evt);
            }
        });
        boxFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxFemeninoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(26, 188, 156));
        jLabel10.setText("Edad:");

        spnEdad.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N

        btnAgregarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AGREGAR_ON.png"))); // NOI18N
        btnAgregarAdmin.setBorderPainted(false);
        btnAgregarAdmin.setContentAreaFilled(false);
        btnAgregarAdmin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AGREGAR_OFF.png"))); // NOI18N
        btnAgregarAdmin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AGREGAR_OFF.png"))); // NOI18N
        btnAgregarAdmin.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AGREGAR_OFF.png"))); // NOI18N
        btnAgregarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                                    .addComponent(txtApePat))
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addComponent(boxMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8)
                                            .addComponent(txtContra, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                            .addComponent(txtApeMat)
                                            .addComponent(boxFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApeMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(boxFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(btnAgregarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApePatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApePatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApePatActionPerformed

    private void txtApeMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeMatActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void boxMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMasculinoActionPerformed

    private void boxFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxFemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFemeninoActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
                
        char num = evt.getKeyChar();
        if (((num < 'a')||(num > 'z')&&((num < 'A')||(num > 'Z')))){
            
            if ((num != '_')){
                
                evt.consume();

            }
            
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtApePatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePatKeyPressed
            
        char num = evt.getKeyChar();
        if (((num < 'a')||(num > 'z')&&((num < 'A')||(num > 'Z')))){
            
            if ((num != '_')){
                
                evt.consume();

            }
            
        }
    }//GEN-LAST:event_txtApePatKeyPressed

    private void txtApeMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMatKeyPressed
               
        char num = evt.getKeyChar();
        if (((num < 'a')||(num > 'z')&&((num < 'A')||(num > 'Z')))){
            
            if ((num != '_')){
                
                evt.consume();

            }
            
        }
    }//GEN-LAST:event_txtApeMatKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
       
  
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraKeyPressed

    private void boxMasculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMasculinoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMasculinoMouseClicked

    private void boxFemeninoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxFemeninoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxFemeninoMouseClicked

    private void btnAgregarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAdminActionPerformed
        
        if ( esEmail(txtEmail.getText())== false){
              
            JOptionPane.showMessageDialog(null,"Email no valido"," ventana de Error",JOptionPane.WARNING_MESSAGE);
        }else{

            if(txtNombre.getText().isEmpty()||(txtApePat.getText().isEmpty())){


                JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);

            }else{
       
                if(txtApeMat.getText().isEmpty()||(txtContra.getText().isEmpty())){


                    JOptionPane.showMessageDialog(null,"No es posible dejar cajas vacias"," ventana de Error",JOptionPane.WARNING_MESSAGE);

                }else{
        
                    try{
                        PreparedStatement psql = cx.prepareStatement("INSERT INTO empleados(nombre, apePat, apeMat, Email, Contrasena, sexo, edad, idPuestoEmp, idCitasEmp) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        psql.setString(1, txtNombre.getText());
                        psql.setString(2, txtApePat.getText());
                        psql.setString(3, txtApeMat.getText());
                        psql.setString(4, txtEmail.getText());
                        psql.setString(5, txtContra.getText());
                        if((boxMasculino.isSelected())){
                            psql.setString(6, boxMasculino.getText());
                            boxMasculino.setBackground(Color.GREEN);
                        }else{
                            if((boxFemenino.isSelected())){

                                psql.setString(6, boxFemenino.getText());
                                boxMasculino.setBackground(Color.RED);
                            }
                        }
                        psql.setInt(7, (int) spnEdad.getValue());
                        psql.setInt(8, 2);
                        psql.setInt(9, 4);
                        System.out.println(psql);
                        psql.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Datos Guardados");
                        this.setVisible(false);
                    }catch (SQLException ex ){

                        Logger.getLogger(IngresarAdmin.class.getName()).log(Level.SEVERE, null, ex );
                    }
        
                }
            }
        }
        
    }//GEN-LAST:event_btnAgregarAdminActionPerformed

    
    static boolean esEmail(String cadena){
    
    boolean bandera = false;
    
    bandera = cadena.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    return bandera;
    }
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
            java.util.logging.Logger.getLogger(IngresarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IngresarAdmin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(IngresarAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton boxFemenino;
    private javax.swing.JRadioButton boxMasculino;
    private javax.swing.JButton btnAgregarAdmin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labMaximizar;
    private javax.swing.JLabel labMinimizar;
    private javax.swing.JSpinner spnEdad;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
