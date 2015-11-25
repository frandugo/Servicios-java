package com.servicios.dao;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.MantenimientoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MantenimientoDAO extends MainDAO {

    public void insertMantenimiento(MantenimientoBean mant) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO mantenimiento (usuaid, emprid, servid, mantid, mantfech, mantdesc, mantestd) VALUES (?, ?, ?, MANTENIMIENTO_ID.NEXTVAL, TO_DATE(?, 'dd/mm/yyyy'), ?, 'P')")) {
            ps.setInt(1, mant.getUsuaid());
            ps.setInt(2, mant.getEmprid());
            ps.setInt(3, mant.getServid());
            ps.setString(4, mant.getMantfech());
            ps.setString(5, mant.getMantdesc());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public void updateMantenimiento(MantenimientoBean mant) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE mantenimiento SET mantfech = TO_DATE(?, 'dd/mm/yyyy'), mantdesc = ? WHERE usuaid = ? AND emprid = ? AND servid = ? AND mantid = ?")) {
            ps.setString(1, mant.getMantfech());
            ps.setString(2, mant.getMantdesc());
            ps.setInt(3, mant.getUsuaid());
            ps.setInt(4, mant.getEmprid());
            ps.setInt(5, mant.getServid());
            ps.setInt(6, mant.getMantid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public void deleteMantenimiento(MantenimientoBean mant) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE mantenimiento SET mantestd = 'E' WHERE usuaid = ? AND emprid = ? AND servid = ? AND mantid = ?")) {
            ps.setInt(1, mant.getUsuaid());
            ps.setInt(2, mant.getEmprid());
            ps.setInt(3, mant.getServid());
            ps.setInt(4, mant.getMantid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public MantenimientoBean searchMantenimientos(MantenimientoBean manto) throws SQLException {
        MantenimientoBean mant = null;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT m.mantid, m.mantdesc, TO_CHAR(m.mantfech, 'dd/mm/yyyy') AS mantfech, m.servid, m.mantestd,s.servnomb, s.emprid, e.emprnomb FROM mantenimiento m INNER JOIN empresa e ON (m.emprid = e.emprid) INNER JOIN servicio s ON (m.emprid = s.emprid AND m.servid = s.servid) WHERE m.usuaid = ? AND m.emprid = ? AND m.servid = ? AND m.mantid = ? AND m.mantestd = 'P'")) {
            ps.setInt(1, manto.getUsuaid());
            ps.setInt(2, manto.getEmprid());
            ps.setInt(3, manto.getServid());
            ps.setInt(4, manto.getMantid());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mant = new MantenimientoBean();
                mant.setMantid(rs.getInt("mantid"));
                mant.setMantdesc(rs.getString("mantdesc"));
                mant.setMantfech(rs.getString("mantfech"));
                mant.setServid(rs.getInt("servid"));
                mant.setMantestd(rs.getString("mantestd"));
                mant.setServnomb(rs.getString("servnomb"));
                mant.setEmprid(rs.getInt("emprid"));
                mant.setEmprnomb(rs.getString("emprnomb"));
            }
        } finally {
            desconectarBD(con);
        }
        return mant;
    }

    public ArrayList<MantenimientoBean> getMantenimientosUsuario(int usuaId) throws SQLException {
        ArrayList<MantenimientoBean> mantenimientos;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT mt.emprid, mt.servid, sv.servnomb, mt.mantid, TO_CHAR(mt.mantfech, 'dd/mm/yyyy') AS mantfech, mt.mantdesc, em.emprnomb FROM usuario_empresa ue INNER JOIN empresa em ON (ue.emprid = em.emprid) INNER JOIN usuario_servicio us ON (ue.usuaid = us.usuaid AND ue.emprid = us.emprid) INNER JOIN mantenimiento mt ON (us.usuaid = mt.usuaid AND us.emprid = mt.emprid AND us.servid = mt.servid) INNER JOIN servicio sv ON (mt.emprid = sv.emprid AND mt.servid = sv.servid) WHERE ue.usuaid = ? AND mt.mantestd = 'P' ORDER BY mt.mantid")) {
            ps.setInt(1, usuaId);
            ResultSet rs = ps.executeQuery();
            mantenimientos = new ArrayList<>();
            while (rs.next()) {
                MantenimientoBean mant = new MantenimientoBean();
                mant.setEmprid(rs.getInt("emprid"));
                mant.setServid(rs.getInt("servid"));
                mant.setMantid(rs.getInt("mantid"));
                mant.setMantfech(rs.getString("mantfech"));
                mant.setMantdesc(rs.getString("mantdesc"));
                mant.setServnomb(rs.getString("servnomb"));
                mant.setEmprnomb(rs.getString("emprnomb"));
                mantenimientos.add(mant);
            }
        } finally {
            desconectarBD(con);
        }
        return mantenimientos;
    }

    public ArrayList<ComboItemBean> getMantenimientos(MantenimientoBean mnto) throws SQLException {
        ArrayList<ComboItemBean> mantenimientos;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT mantid, mantdesc || ', ' || mantfech AS mantdesc FROM mantenimiento WHERE emprid = ? AND servid = ? AND mantestd = 'P' ORDER BY mantid, mantdesc")) {
            ps.setInt(1, mnto.getEmprid());
            ps.setInt(2, mnto.getServid());
            ResultSet rs = ps.executeQuery();
            mantenimientos = new ArrayList<>();
            while (rs.next()) {
                mantenimientos.add(new ComboItemBean(rs.getInt("mantid"), rs.getString("mantdesc")));
            }
        } finally {
            desconectarBD(con);
        }
        return mantenimientos;
    }
    
    public void aprobarMantenimiento(MantenimientoBean mant) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE mantenimiento SET mantestd = 'A' WHERE emprid = ? AND servid = ? AND mantid = ?")) {
            ps.setInt(1, mant.getEmprid());
            ps.setInt(2, mant.getServid());
            ps.setInt(3, mant.getMantid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }    

}
