package dao.implementacion;

import dao.BD;
import dao.IDao;
import entidades.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NROMATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private static final String SQL_SEARCH = "SELECT * FROM ODONTOLOGOS";
    private static final Logger LOGGER = Logger.getLogger(Odontologo.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        LOGGER.info("Estamos guardando un Odontologo llamado "+odontologo.getNombre()+" en la base");
        Connection con = null;

        try {
            con = BD.getConnection();

            PreparedStatement pStmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            pStmt.setInt(1, odontologo.getNroMatricula());
            pStmt.setString(2, odontologo.getNombre());
            pStmt.setString(3, odontologo.getApellido());

            pStmt.execute();

            ResultSet resultSet = pStmt.getGeneratedKeys();
            while (resultSet.next()) {
                odontologo.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("Cuyo ID confirmado por la base es "+ odontologo.getId());
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        LOGGER.info("Vamos a consultar todos los Odontologos en la BD");
        Connection con = null;
        List<Odontologo> listaOdontologo = new ArrayList<>();
        Odontologo nOdontologo = null;

        try {
            con = BD.getConnection();
            Statement stmtBuscar = con.createStatement();
            ResultSet rs = stmtBuscar.executeQuery(SQL_SEARCH);

            while (rs.next()) {
                nOdontologo = new Odontologo();
                nOdontologo.setId(rs.getInt(1));
                nOdontologo.setNroMatricula(rs.getInt(2));
                nOdontologo.setNombre(rs.getString(3));
                nOdontologo.setApellido(rs.getString(4));

                listaOdontologo.add(nOdontologo);
            }

        } catch (Exception e) {
            LOGGER.error("Error:" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return listaOdontologo;
    }
}
