package com.servicios.dao;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.FacturaBean;
import com.servicios.bean.FacturaDetalleBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaDAO extends MainDAO {

    public ArrayList<ComboItemBean> getFacturasPagadas(int usuaId, int emprId) throws SQLException {
        ArrayList<ComboItemBean> facturas;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT fa.factid, fa.factdesc FROM factura fa WHERE fa.usuaid = ? AND fa.emprid = ? AND fa.factfepa IS NOT NULL AND fa.factestd = 'A' ORDER BY fa.factid")) {
            ps.setInt(1, usuaId);
            ps.setInt(2, emprId);
            ResultSet rs = ps.executeQuery();
            facturas = new ArrayList<>();
            while (rs.next()) {
                facturas.add(new ComboItemBean(rs.getInt("factid"), rs.getString("factdesc")));
            }
        } finally {
            desconectarBD(con);
        }
        return facturas;
    }

    public ArrayList<ComboItemBean> getFacturasPendientes(int usuaId, int emprId) throws SQLException {
        ArrayList<ComboItemBean> facturas;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT fa.factid, fa.factdesc FROM factura fa WHERE fa.usuaid = ? AND fa.emprid = ? AND fa.factfepa IS NULL AND fa.factestd = 'A' ORDER BY fa.factid")) {
            ps.setInt(1, usuaId);
            ps.setInt(2, emprId);
            ResultSet rs = ps.executeQuery();
            facturas = new ArrayList<>();
            while (rs.next()) {
                facturas.add(new ComboItemBean(rs.getInt("factid"), rs.getString("factdesc")));
            }
        } finally {
            desconectarBD(con);
        }
        return facturas;
    }

    public ArrayList<FacturaDetalleBean> getDetalleFactura(FacturaBean fact) throws SQLException {
        ArrayList<FacturaDetalleBean> detalles;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT fd.servid, sv.servnomb, fd.servvlr, mt.mantid, mt.mantdesc, mt.mantfech FROM factura fa INNER JOIN factura_detalle fd ON (fa.usuaid = fd.usuaid AND fa.emprid = fd.emprid AND fa.factid = fd.factid) LEFT JOIN mantenimiento mt ON (fd.usuaid = mt.usuaid AND fd.emprid = mt.emprid AND fd.servid = mt.servid AND fd.mantid = mt.mantid AND mt.mantestd = 'A') INNER JOIN servicio sv ON (fd.servid = sv.servid) WHERE fd.usuaid = ? AND fd.emprid = ? AND fd.factid = ? AND fa.factfepa IS NOT NULL AND fa.factestd = 'A' ORDER BY fd.servid, sv.servnomb")) {
            ps.setInt(1, fact.getUsuaid());
            ps.setInt(2, fact.getEmprid());
            ps.setInt(3, fact.getFactid());
            ResultSet rs = ps.executeQuery();
            detalles = new ArrayList<>();
            while (rs.next()) {
                FacturaDetalleBean detalle = new FacturaDetalleBean();
                detalle.setServid(rs.getInt("servid"));
                detalle.setServnomb(rs.getString("servnomb"));
                detalle.setServvlr(rs.getDouble("servvlr"));
                detalle.setMantid(rs.getInt("mantid"));
                detalle.setMantdesc(rs.getString("mantdesc"));
                detalle.setMantfech(rs.getString("mantfech"));                
                detalles.add(detalle);
            }
        } finally {
            desconectarBD(con);
        }
        return detalles;
    }

    public void pagarFactura(FacturaBean fact) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE factura SET factfepa = TO_DATE(CURRENT_DATE, 'dd/mm/yyyy') WHERE usuaid = ? AND emprid = ? AND factid = ?")) {
            ps.setInt(1, fact.getUsuaid());
            ps.setInt(2, fact.getEmprid());
            ps.setInt(3, fact.getFactid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

}
