package com.servicios.usuario;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.FacturaBean;
import com.servicios.bean.FacturaDetalleBean;
import com.servicios.bean.UsuarioBean;
import com.servicios.dao.EmpresaDAO;
import com.servicios.dao.FacturaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class HistoricoPagos extends javax.swing.JFrame {

    private UsuarioBean usuario;
    private ArrayList<ComboItemBean> empresas;

    /**
     * Creates new form Verservicios
     */
    public HistoricoPagos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbmempresa = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbmfacturas = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histórico de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel6.setText("Empresa:");

        jLabel7.setText("Factura:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbmfacturas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbmempresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbmempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cbmfacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Servicio", "Servicio", "Valor", "Id Mnto.", "Descripcion Mnto.", "Fecha Mnto."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {

            setLocationRelativeTo(null);
            //Listado empresas
            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresas = empresaDAO.getComboEmpresas();
            cbmempresa.addItem(new ComboItemBean(0, "Seleccione..."));
            cbmfacturas.addItem(new ComboItemBean(0, "Seleccione..."));
            for (ComboItemBean empresa : empresas) {
                cbmempresa.addItem(empresa);
            }

            //Listener de empresas para cargar servicios asociados
            cbmempresa.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        cbmfacturas.removeAllItems();
                        cbmfacturas.addItem(new ComboItemBean(0, "Seleccione..."));
                        try {
                            if (cbmempresa.getSelectedIndex() > 0) {
                                ComboItemBean empresa = (ComboItemBean) cbmempresa.getSelectedItem();
                                FacturaDAO dao = new FacturaDAO();
                                ArrayList<ComboItemBean> facturas = dao.getFacturasPagadas(getUsuario().getUsuaid(), empresa.getValue());
                                for (ComboItemBean fact : facturas) {
                                    cbmfacturas.addItem(fact);
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

            //Listener de facturas para cargar servicios asociados
            cbmfacturas.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            if (cbmfacturas.getSelectedIndex() > 0) {
                                ComboItemBean empresa = (ComboItemBean) cbmempresa.getSelectedItem();
                                ComboItemBean factura = (ComboItemBean) cbmfacturas.getSelectedItem();
                                FacturaDAO dao = new FacturaDAO();
                                FacturaBean fact = new FacturaBean();
                                fact.setUsuaid(getUsuario().getUsuaid());
                                fact.setEmprid(empresa.getValue());
                                fact.setFactid(factura.getValue());
                                ArrayList<FacturaDetalleBean> detalles = dao.getDetalleFactura(fact);
                                String col[] = {"Id Servicio", "Servicio", "Valor", "Id Mnto.", "Descripcion Mnto.", "Fecha Mnto."};
                                DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);
                                for (FacturaDetalleBean deta : detalles) {
                                    Object[] data = {deta.getServid(), deta.getServnomb(), deta.getServvlr(), (deta.getMantid() > 0 ? deta.getMantid() : ""), deta.getMantdesc(), deta.getMantfech()};
                                    defaultTableModel.addRow(data);
                                }
                                tblservicios.setModel(defaultTableModel);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(HistoricoPagos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(HistoricoPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HistoricoPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbmempresa;
    private javax.swing.JComboBox cbmfacturas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblservicios;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the usuario
     */
    public UsuarioBean getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
}