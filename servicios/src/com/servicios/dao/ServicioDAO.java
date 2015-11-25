package com.servicios.dao;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.ServicioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioDAO extends MainDAO {

    public void insertServicio(ServicioBean serv) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO servicio (emprid, servid, servnomb, servdesc, servestd) VALUES (?, servicio_id.NEXTVAL, ?, ?, 'A')")) {
            ps.setInt(1, serv.getEmprid());
            ps.setString(2, serv.getServnomb());
            ps.setString(3, serv.getServdesc());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public ArrayList<ServicioBean> getServicios() throws SQLException {
        ArrayList<ServicioBean> servicios;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT s.servid, s.servnomb, s.servdesc, e.emprnomb FROM servicio s INNER JOIN empresa e ON (s.emprid = e.emprid) WHERE s.servestd = 'A' ORDER BY e.emprnomb, s.servnomb")) {
            ResultSet rs = ps.executeQuery();
            servicios = new ArrayList<>();
            while (rs.next()) {
                ServicioBean serv = new ServicioBean();
                serv.setServid(rs.getInt("servid"));
                serv.setServnomb(rs.getString("servnomb"));
                serv.setServdesc(rs.getString("servdesc"));
                serv.setEmprnomb(rs.getString("emprnomb"));
                servicios.add(serv);
            }
        } finally {
            desconectarBD(con);
        }
        return servicios;
    }

    public ServicioBean getServicioById(int emprId, int servId) throws SQLException {
        ServicioBean servicio = null;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT emprid, servid, servnomb, servdesc FROM servicio WHERE emprid = ? AND servid = ?")) {
            ps.setInt(1, emprId);
            ps.setInt(2, servId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servicio = new ServicioBean();
                servicio.setEmprid(rs.getInt("emprid"));
                servicio.setServid(rs.getInt("servid"));
                servicio.setServnomb(rs.getString("servnomb"));
                servicio.setServdesc(rs.getString("servdesc"));
            }
        } finally {
            desconectarBD(con);
        }
        return servicio;
    }

    public ArrayList<ComboItemBean> getServiciosContratados(int userId, int emprId) throws SQLException {
        ArrayList<ComboItemBean> servicios;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT sv.servid, sv.servnomb, sv.servdesc, em.emprnomb FROM usuario_empresa ue INNER JOIN usuario_servicio us ON (ue.usuaid = us.usuaid AND ue.emprid = us.emprid) INNER JOIN servicio sv ON (us.emprid = sv.emprid AND us.servid = sv.servid) INNER JOIN empresa em ON (sv.emprid = em.emprid) WHERE ue.usuaid = ? AND em.emprid = ? AND em.emprestd = 'A' AND ue.usuaestd = 'A' AND us.usuaestd = 'A' AND sv.servestd = 'A' ORDER BY em.emprnomb, sv.servnomb")) {
            ps.setInt(1, userId);
            ps.setInt(2, emprId);
            ResultSet rs = ps.executeQuery();
            servicios = new ArrayList<>();
            while (rs.next()) {
                servicios.add(new ComboItemBean(rs.getInt("servid"), rs.getString("servnomb")));
            }
        } finally {
            desconectarBD(con);
        }
        return servicios;
    }

    public void updateServicio(ServicioBean serv) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE servicio SET servnomb = ?, servdesc = ? WHERE emprid = ? AND servid = ?")) {
            ps.setString(1, serv.getServnomb());
            ps.setString(2, serv.getServdesc());
            ps.setInt(3, serv.getEmprid());
            ps.setInt(4, serv.getServid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public void deleteServicio(ServicioBean serv) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE servicio SET servestd = 'E' WHERE emprid = ? AND servid = ?")) {
            ps.setInt(1, serv.getEmprid());
            ps.setInt(2, serv.getServid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public void precindirServicio(ServicioBean serv) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE usuario_servicio SET usuaestd = 'P' WHERE usuaid = ? AND emprid = ? AND servid = ?")) {
            ps.setInt(1, serv.getUserid());
            ps.setInt(2, serv.getEmprid());
            ps.setInt(3, serv.getServid());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }

    public ArrayList<ServicioBean> getServiciosUsuario(int userId) throws SQLException {
        ArrayList<ServicioBean> servicios;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT sv.servid, sv.servnomb, sv.servdesc, em.emprnomb FROM usuario_empresa ue INNER JOIN usuario_servicio us ON (ue.usuaid = us.usuaid AND ue.emprid = us.emprid) INNER JOIN servicio sv ON (us.emprid = sv.emprid AND us.servid = sv.servid) INNER JOIN empresa em ON (sv.emprid = em.emprid) WHERE ue.usuaid = ? AND em.emprestd = 'A' AND ue.usuaestd = 'A' AND us.usuaestd = 'A' AND sv.servestd = 'A' ORDER BY em.emprnomb, sv.servnomb")) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            servicios = new ArrayList<>();
            while (rs.next()) {
                ServicioBean serv = new ServicioBean();
                serv.setServid(rs.getInt("servid"));
                serv.setServnomb(rs.getString("servnomb"));
                serv.setServdesc(rs.getString("servdesc"));
                serv.setEmprnomb(rs.getString("emprnomb"));
                servicios.add(serv);
            }
        } finally {
            desconectarBD(con);
        }
        return servicios;
    }

    public ArrayList<ServicioBean> getServiciosUsuarioEmpresa(int userId, int emprId) throws SQLException {
        ArrayList<ServicioBean> servicios;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT sv.servid, sv.servnomb, sv.servdesc, em.emprnomb FROM usuario_empresa ue INNER JOIN usuario_servicio us ON (ue.usuaid = us.usuaid AND ue.emprid = us.emprid) INNER JOIN servicio sv ON (us.emprid = sv.emprid AND us.servid = sv.servid) INNER JOIN empresa em ON (sv.emprid = em.emprid) WHERE ue.usuaid = ? AND em.emprid = ? AND em.emprestd = 'A' AND ue.usuaestd = 'A' AND us.usuaestd = 'A' AND sv.servestd = 'A' ORDER BY em.emprnomb, sv.servnomb")) {
            ps.setInt(1, userId);
            ps.setInt(2, emprId);
            ResultSet rs = ps.executeQuery();
            servicios = new ArrayList<>();
            while (rs.next()) {
                ServicioBean serv = new ServicioBean();
                serv.setServid(rs.getInt("servid"));
                serv.setServnomb(rs.getString("servnomb"));
                serv.setServdesc(rs.getString("servdesc"));
                serv.setEmprnomb(rs.getString("emprnomb"));
                servicios.add(serv);
            }
        } finally {
            desconectarBD(con);
        }
        return servicios;
    }

    public ArrayList<ComboItemBean> getServiciosEmpresa(int emprId) throws SQLException {
        ArrayList<ComboItemBean> servicios;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT sv.servid, sv.servnomb FROM empresa em INNER JOIN servicio sv ON (em.emprid = sv.emprid) WHERE em.emprid = ? AND em.emprestd = 'A' AND sv.servestd = 'A' ORDER BY sv.servid, sv.servnomb")) {
            ps.setInt(1, emprId);
            ResultSet rs = ps.executeQuery();
            servicios = new ArrayList<>();
            while (rs.next()) {
                servicios.add(new ComboItemBean(rs.getInt("servid"), rs.getString("servnomb")));
            }
        } finally {
            desconectarBD(con);
        }
        return servicios;
    }

}
