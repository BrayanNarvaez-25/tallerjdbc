package com.krakedev.tallerjdbc.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class UpdateVehiculo {

    private static final Logger log = LoggerFactory.getLogger(UpdateVehiculo.class);

    private static final String SQL =
        "UPDATE vehiculos SET marca=?, modelo=?, anio=?, precio=?, color=?, disponible=? " +
        "WHERE placa=?";

    public void actualizar(String placa, String marca, String modelo,
                           int anio, double precio, String color, boolean disponible) {
        Connection        conn = null;
        PreparedStatement ps   = null;

        try {
            conn = Conexion.getConexion();
            ps   = conn.prepareStatement(SQL);

            ps.setString (1, marca);
            ps.setString (2, modelo);
            ps.setInt    (3, anio);
            ps.setDouble (4, precio);
            ps.setString (5, color);
            ps.setBoolean(6, disponible);
            ps.setString (7, placa);   // WHERE

            int filas = ps.executeUpdate();
            log.info("Vehículo actualizado. Filas afectadas: {}", filas);

        } catch (SQLException e) {
            log.error("Error al actualizar vehículo: {}", e.getMessage());
        } finally {
            try { if (ps   != null) ps.close();  } catch (SQLException e) { log.error(e.getMessage()); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { log.error(e.getMessage()); }
        }
    }

    public static void main(String[] args) {
        new UpdateVehiculo().actualizar(
            "ABC-001", "Toyota", "Corolla GR", 2023, 21000.0, "Rojo", true
        );
    }
}