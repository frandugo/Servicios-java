package com.servicios.dao;

import com.servicios.bean.ComboItemBean;
import com.servicios.bean.EmpresaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends MainDAO {

    public void insertEmpresa(EmpresaBean empr) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO empresa (emprid, emprnomb, emprdesc, emprpais, emprciud, emprestd) VALUES (empresa_id.NEXTVAL, ?, ?, ?, ?, 'A')")) {
            ps.setString(1, empr.getEmprnomb());
            ps.setString(2, empr.getEmprdesc());
            ps.setString(3, empr.getEmprpais());
            ps.setString(4, empr.getEmprciud());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }
    
    public void updateEmpresa(EmpresaBean empr) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE empresa SET emprnomb = ?, emprdesc = ?, emprpais = ?, emprciud = ? WHERE emprid = ?")) {
            ps.setString(1, empr.getEmprnomb());
            ps.setString(2, empr.getEmprdesc());
            ps.setString(3, empr.getEmprpais());
            ps.setString(4, empr.getEmprciud());  
            ps.setInt(5, empr.getEmprid()); 
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }    
    
   public void deleteEmpresa(int emprId) throws SQLException {
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("UPDATE empresa SET emprestd = 'E' WHERE emprid = ?")) {
            ps.setInt(1, emprId);
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
    }  
    public ArrayList<ComboItemBean> getComboEmpresas() throws SQLException {
        ArrayList<ComboItemBean> empresas;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT emprid, emprnomb FROM empresa WHERE emprestd = 'A' ORDER BY emprnomb ASC")) {
            ResultSet rs = ps.executeQuery();
            empresas = new ArrayList<>();
            while (rs.next()) {
                empresas.add(new ComboItemBean(rs.getInt("emprid"), rs.getString("emprnomb")));
            }
        } finally {
            desconectarBD(con);
        }
        return empresas;
    }

    public ArrayList<EmpresaBean> getEmpresas() throws SQLException {
        ArrayList<EmpresaBean> empresas;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT emprid, emprnomb, emprdesc, emprciud, emprpais FROM empresa WHERE emprestd = 'A' ORDER BY emprid ASC")) {
            ResultSet rs = ps.executeQuery();
            empresas = new ArrayList<>();
            while (rs.next()) {
                EmpresaBean empr = new EmpresaBean();
                empr.setEmprid(rs.getInt("emprid"));
                empr.setEmprnomb(rs.getString("emprnomb"));
                empr.setEmprdesc(rs.getString("emprdesc"));
                empr.setEmprciud(rs.getString("emprciud"));
                empr.setEmprpais(rs.getString("emprpais"));
                empresas.add(empr);
            }
        } finally {
            desconectarBD(con);
        }
        return empresas;
    }

    public EmpresaBean getEmpresaById(int emprId) throws SQLException {
        EmpresaBean empr = null;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT emprid, emprnomb, emprdesc, emprciud, emprpais FROM empresa WHERE emprid = ? AND emprestd = 'A'")) {
            ps.setInt(1, emprId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empr = new EmpresaBean();
                empr.setEmprid(rs.getInt("emprid"));
                empr.setEmprnomb(rs.getString("emprnomb"));
                empr.setEmprdesc(rs.getString("emprdesc"));
                empr.setEmprciud(rs.getString("emprciud"));
                empr.setEmprpais(rs.getString("emprpais"));
            }
        } finally {
            desconectarBD(con);
        }
        return empr;
    }

}
