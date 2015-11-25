package com.servicios.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDAO {

    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:servicios/qpalwosk10@//localhost:1521/xe";

    public MainDAO() {

    }

    public Connection conectarBD() throws SQLException {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            throw new SQLException("ERROR OBTENIENDO LA CONEXION" + e.getMessage());
        }
        return con;
    }

    public void desconectarBD(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

}
