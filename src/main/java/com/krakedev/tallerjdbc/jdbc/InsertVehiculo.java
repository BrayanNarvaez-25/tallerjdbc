package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class InsertVehiculo {

    private static final Logger log = LoggerFactory.getLogger(InsertVehiculo.class);

    private static final String SQL =
        "INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

    public void insertar(Vehiculo v) {
        Connection         conn = null;
        PreparedStatement  ps   = null;

        try {
            conn = Conexion.getConexion();
            ps   = conn.prepareStatement(SQL);

            ps.setString (1, v.getPlaca());
            ps.setString (2, v.getMarca());
            ps.setString (3, v.getModelo());
            ps.setInt    (4, v.getAnio());
            ps.setDouble (5, v.getPrecio());
            ps.setString (6, v.getColor());
            ps.setBoolean(7, v.isDisponible());

            int filas = ps.executeUpdate();
            log.info("Vehículo insertado. Filas afectadas: {}", filas);

        } catch (SQLException e) {
            log.error("Error al insertar vehículo: {}", e.getMessage());
        } finally {
            cerrar(ps, conn);
        }
    }

    // ── Llamada rápida de prueba ──────────────────────────────────
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo(
            "ABC-001", "Toyota", "Corolla", 2022, 18500.0, "Blanco", true
        );
        new InsertVehiculo().insertar(v);
    }

    private void cerrar(PreparedStatement ps, Connection conn) {
        try { if (ps   != null) ps.close();   } catch (SQLException e) { log.error(e.getMessage()); }
        try { if (conn != null) conn.close();  } catch (SQLException e) { log.error(e.getMessage()); }
    }
}