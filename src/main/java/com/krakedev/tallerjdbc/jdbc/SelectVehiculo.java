package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krakedev.tallerjdbc.entidades.Vehiculo;

public class SelectVehiculo {

    private static final Logger log = LoggerFactory.getLogger(SelectVehiculo.class);

    private static final String SQL = "SELECT * FROM vehiculos";

    public List<Vehiculo> listar() {
        List<Vehiculo>    lista = new ArrayList<>();
        Connection        conn  = null;
        PreparedStatement ps    = null;
        ResultSet         rs    = null;

        try {
            conn = Conexion.getConexion();
            ps   = conn.prepareStatement(SQL);
            rs   = ps.executeQuery();

            while (rs.next()) {
                Vehiculo v = new Vehiculo(
                    rs.getString ("placa"),
                    rs.getString ("marca"),
                    rs.getString ("modelo"),
                    rs.getInt    ("anio"),
                    rs.getDouble ("precio"),
                    rs.getString ("color"),
                    rs.getBoolean("disponible"),
                    rs.getInt("kilometraje")
                );
                lista.add(v);
                System.out.println(v);
            }
            log.info("Total de vehículos listados: {}", lista.size());

        } catch (SQLException e) {
            log.error("Error al listar vehículos: {}", e.getMessage());
        } finally {
            try { if (rs   != null) rs.close();   } catch (SQLException e) { log.error(e.getMessage()); }
            try { if (ps   != null) ps.close();   } catch (SQLException e) { log.error(e.getMessage()); }
            try { if (conn != null) conn.close();  } catch (SQLException e) { log.error(e.getMessage()); }
        }
        return lista;
    }

    public static void main(String[] args) {
        new SelectVehiculo().listar();
    }
}