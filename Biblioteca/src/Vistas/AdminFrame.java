package Vistas;

import Logica.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends javax.swing.JFrame {

    Login L;
    Libro[] admin = new Libro[0];
    int contador = 0;
    String[] encabezados = {"Titulo", "Autor", "ISBN", "Cantidad"};
    DefaultTableModel tabla = new DefaultTableModel();

    public AdminFrame() {
        initComponents();
        this.setLocationRelativeTo(this);
        tabla.setColumnIdentifiers(encabezados);
        JBil.setModel(tabla);

    }

    public void setL(Login L) {
        this.L = L;
    }

    public void registrarLibro(String titulo, String autor, String isbn, int stock) {
        redimensionar();
        admin[contador] = new Libro(titulo, autor, isbn, stock);
        contador++;
    }

    public void redimensionar() {
        Libro[] aux = new Libro[admin.length + 1];
        for (int i = 0; i < admin.length; i++) {
            aux[i] = admin[i];
        }
        admin = aux;
    }
    public void mostrar() {
        tabla.setRowCount(0);
        for (int i = 0; i < admin.length; i++) {
            tabla.addRow(new Object[]{admin[i].getTitulo(),
                admin[i].getAutor(),
                admin[i].getIsbn(),
                admin[i].getStock(),});
        }
        limpiar();
        lblContador.setText(contador + " ");
    }

    public void limpiar() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtISBN.setText("");
        txtCantidad.setText("");
        txtTitulo.requestFocus();
    }

    public void editar(int b) {
        txtTitulo.setText(admin[b].getTitulo());
        txtAutor.setText(admin[b].getAutor());
        txtISBN.setText(admin[b].getIsbn());
        txtCantidad.setText(admin[b].getStock() + "");
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnResgistrarse.setEnabled(false);
    }

    public void guardar(Libro l, int b) {
        admin[b] = l;
        JOptionPane.showMessageDialog(this, "registro actualizado ");
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        JBil.setEnabled(false);
        btnResgistrarse.setEnabled(true);
        limpiar();
        mostrar();
    }

    public void eliminar(int b) {
        int y = 0;
        Libro[] aux = new Libro[contador - 1];
        for (int i = 0; i < admin.length; i++) {
            if (i != b) {
                aux[y] = admin[i];
                y++;
            }
        }
        contador--;
        admin = aux;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        btnResgistrarse = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JBil = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Bienvenido a la Biblioteca");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Autor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("ISBN:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Titulo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 60, -1));
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 210, 30));
        jPanel1.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 220, 30));

        btnResgistrarse.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnResgistrarse.setForeground(new java.awt.Color(51, 153, 255));
        btnResgistrarse.setText("Registrarse");
        btnResgistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResgistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnResgistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 40));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 130, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 190, 30));

        JBil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JBil);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 630, 240));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Contador:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblContador.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblContador.setText("0");
        jPanel1.add(lblContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 10, -1));
        jPanel1.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 210, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 51, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 150, 40));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(153, 102, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 130, 40));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 130, 40));

        btnPase.setText("Pase");
        btnPase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnPase, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResgistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResgistrarseActionPerformed
        String titulo, autor, isbn;
        int stock;

        titulo = txtTitulo.getText();
        autor = txtAutor.getText();
        isbn = txtISBN.getText();
        stock = Integer.parseInt(txtCantidad.getText());
        registrarLibro(titulo, autor, isbn, stock);
        JOptionPane.showMessageDialog(this, "Libro registrado con exito broooou");
        lblContador.setText(contador + " ");
        mostrar();

    }//GEN-LAST:event_btnResgistrarseActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        L.setVisible(true);
        L.setD(this);
        this.setVisible(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (JBil.getSelectedRow() != -1) {
            editar(JBil.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un libro para editar ");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String titulo, autor, isbn;
        int stock;
        titulo = txtTitulo.getText();
        autor = txtAutor.getText();
        isbn = txtISBN.getText();
        stock = Integer.parseInt(txtCantidad.getText());
        guardar(new Libro(titulo, autor, isbn, stock), JBil.getSelectedRow());

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JBil.getSelectedRow() != -1) {
            int op = JOptionPane.showConfirmDialog(this, "¿Desea eliminar un libro?", "Confirmar: Eliminar", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                eliminar(JBil.getSelectedRow());
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Su eliminacion ha sido cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un libro para eliminar ");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaseActionPerformed
        UserFrame info = new UserFrame();
        info.setVisible(true);
        info.pack();
        info.setLocationRelativeTo(null);
        info.setDefaultCloseOperation(UserFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnPaseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable JBil;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPase;
    private javax.swing.JButton btnResgistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContador;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
