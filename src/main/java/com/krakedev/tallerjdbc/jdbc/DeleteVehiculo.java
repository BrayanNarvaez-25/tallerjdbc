package com.krakedev.tallerjdbc.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DeleteVehiculo {

    private static final Logger log = LoggerFactory.getLogger(DeleteVehiculo.class);

    private static final String SQL = "DELETE FROM vehiculos WHERE placa = ?";

    public void eliminar(String placa) {
        Connection        conn = null;
        PreparedStatement ps   = null;

        try {
            conn = Conexion.getConexion();
            ps   = conn.prepareStatement(SQL);
            ps.setString(1, placa);

            int filas = ps.executeUpdate();
            log.info("Vehículo eliminado. Filas afectadas: {}", filas);

        } catch (SQLException e) {
            log.error("Error al eliminar vehículo: {}", e.getMessage());
        } finally {
            try { if (ps   != null) ps.close();  } catch (SQLException e) { log.error(e.getMessage()); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { log.error(e.getMessage()); }
        }
    }

    public static void main(String[] args) {
        new DeleteVehiculo().eliminar("ABC-001");
    }
}