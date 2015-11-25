
package com.servicios.dao;

import com.servicios.bean.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends MainDAO {

    public UsuarioBean insertUsuario(UsuarioBean usua) throws SQLException {
        UsuarioBean usuario = null;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (usuaid, usuanomb, usuaapell, usuadocu, usuatipo, usuaemail, usuapass) VALUES (USUARIO_ID.NEXTVAL, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, usua.getUsuanomb());
            ps.setString(2, usua.getUsuaapell());
            ps.setInt(3, usua.getUsuadocu());
            ps.setString(4, usua.getUsuatipo());
            ps.setString(5, usua.getUsuaemail());
            ps.setString(6, usua.getUsuapass());
            ps.executeUpdate();
        } finally {
            desconectarBD(con);
        }
        return usuario;
    } 
    
    public UsuarioBean searchUsuario(String email, String pass) throws SQLException {
        UsuarioBean usuario = null;
        Connection con = conectarBD();
        try (PreparedStatement ps = con.prepareStatement("SELECT usuaid, usuatipo, usuanomb FROM usuario WHERE usuaemail = ? AND usuapass = ?")) {
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioBean();
                usuario.setUsuaemail(email);
                usuario.setUsuaid(rs.getInt("usuaid"));
                usuario.setUsuatipo(rs.getString("usuatipo"));
                usuario.setUsuanomb(rs.getString("usuanomb"));
            }
        } finally {
            desconectarBD(con);
        }
        return usuario;
    }    
    
}
