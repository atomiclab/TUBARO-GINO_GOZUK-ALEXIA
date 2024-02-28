package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NROMATRICULA INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL " +
            ")";
    private static final Logger LOGGER = Logger.getLogger(BD.class);

    public static Connection getConnection() throws SQLException {
        Connection conexion = null;
        try {
            Class.forName("org.h2.Driver");
            conexion = DriverManager.getConnection("jdbc:h2:"+ "./base", "sa", "");
        } catch (Exception e) {
            throw new SQLException();
        }
        return conexion;
    }

    public static void createTable() throws Exception {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);
        } catch (Exception e) {
            LOGGER.warn("No se pudo crear la tabla en al BD");
            throw new Exception("No se pudo crear la tabla en la base de datos");
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.warn("No se pudo cerrar la BD");
                throw new Exception("No se pudo cerrar la base de datos");
            }
        }
    }
}
