package com.servicios.admin;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.ServicioBean;
import com.servicios.dao.EmpresaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.servicios.dao.ServicioDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminServicio extends javax.swing.JFrame {

    private int servid;
    private ArrayList<ComboItemBean> empresas;

    /**
     * Creates new form Adminservicios
     */
    public AdminServicio() {
        initComponents();
    }

    public void limpiarCampos() {
        cbmempresa.setSelectedIndex(0);
        txtservid.setText("");
        txtservnombre.setText("");
        txtservdesc.setText("");
        txtservnombre.requestFocus();
    }

    public void loadTablaServicios() {
        try {

            ServicioDAO dao = new ServicioDAO();
            ArrayList<ServicioBean> servicios = dao.getServicios();
            String col[] = {"Id", "Servicio", "Descripcion", "Empresa"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);
            for (ServicioBean serv : servicios) {
                Object[] data = {serv.getServid(), serv.getServnomb(), serv.getServdesc(), serv.getEmprnomb()};
                defaultTableModel.addRow(data);
            }
            tblservicios.setModel(defaultTableModel);

        } catch (SQLException sqx) {
            System.out.println("se ha Encontrado el error siguiente -> " + sqx.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        txtservnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtservdesc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtservid = new javax.swing.JTextField();
        cbmempresa = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Buscar por Id:");

        cbmempresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));

        jLabel6.setText("Empresa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(btnbuscar)
                        .addGap(67, 67, 67)
                        .addComponent(btnactualizar)
                        .addGap(65, 65, 65)
                        .addComponent(btneliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbmempresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtservid)
                            .addComponent(txtservdesc)
                            .addComponent(txtservnombre))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtservid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbmempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtservnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtservdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(btnactualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Servicio", "Descripcion", "Empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblservicios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        try {
            if (cbmempresa.getSelectedIndex() > 0 && !txtservnombre.getText().isEmpty() && !txtservdesc.getText().isEmpty()) {
                ComboItemBean empresa = (ComboItemBean) cbmempresa.getSelectedItem();
                ServicioDAO dao = new ServicioDAO();

                ServicioBean serv = new ServicioBean();
                serv.setEmprid(empresa.getValue());
                serv.setServnomb(txtservnombre.getText());
                serv.setServdesc(txtservdesc.getText());
                dao.insertServicio(serv);

                limpiarCampos();
                loadTablaServicios();
                JOptionPane.showMessageDialog(null, "El servicio fue registrado");
            } else {
                JOptionPane.showMessageDialog(null, "Los siguientes campos son obligatorios:\n\n"
                        + "* Empresa\n"
                        + "* Nombre\n"
                        + "* Descripcion\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            setLocationRelativeTo(null);
            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresas = empresaDAO.getComboEmpresas();
            for (ComboItemBean empresa : empresas) {
                cbmempresa.addItem(empresa);
            }
            loadTablaServicios();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        try {
            if (cbmempresa.getSelectedIndex() > 0 && !txtservid.getText().isEmpty()) {
                ServicioDAO dao = new ServicioDAO();
                ComboItemBean empr = (ComboItemBean) cbmempresa.getSelectedItem();
                ServicioBean serv = dao.getServicioById(empr.getValue(), Integer.parseInt(txtservid.getText()));
                if (serv != null) {
                    for (ComboItemBean empresa : empresas) {
                        if (empresa.getValue() == serv.getEmprid()) {
                            cbmempresa.setSelectedItem(empresa);
                            break;
                        }
                    }
                    txtservnombre.setText(serv.getServnomb());
                    txtservdesc.setText(serv.getServdesc());
                    setServid(serv.getServid());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos relacionados al Id");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los siguientes campos son obligatorios:\n\n"
                        + "* Buscar por Id\n"
                        + "* Empresa\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
            if (!txtservid.getText().isEmpty()) {
                ComboItemBean empresa = (ComboItemBean) cbmempresa.getSelectedItem();
                ServicioDAO dao = new ServicioDAO();
                
                ServicioBean serv = new ServicioBean();
                serv.setServnomb(txtservnombre.getText());
                serv.setServdesc(txtservdesc.getText());
                serv.setEmprid(empresa.getValue());
                serv.setServid(getServid());                

                dao.updateServicio(serv);                
                loadTablaServicios();
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "El servicio fue actualizado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
            if (!txtservid.getText().isEmpty()) {
                ComboItemBean empresa = (ComboItemBean) cbmempresa.getSelectedItem();
                ServicioDAO dao = new ServicioDAO();
                
                ServicioBean serv = new ServicioBean();
                serv.setEmprid(empresa.getValue());
                serv.setServid(getServid());
                dao.deleteServicio(serv);
                
                loadTablaServicios();
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "El servicio fue eliminado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(AdminServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox cbmempresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblservicios;
    private javax.swing.JTextField txtservdesc;
    private javax.swing.JTextField txtservid;
    private javax.swing.JTextField txtservnombre;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the servid
     */
    public int getServid() {
        return servid;
    }

    /**
     * @param servid the servid to set
     */
    public void setServid(int servid) {
        this.servid = servid;
    }
}