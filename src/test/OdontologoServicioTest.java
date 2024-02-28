package test;

import dao.BD;
import entidades.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicio.OdontologoServicio;

import java.util.List;

public class OdontologoServicioTest {

    @Test
    void registrarOdontologo() {
        try {
            BD.createTable();
            OdontologoServicio odontologoServicio = new OdontologoServicio();
            Odontologo odontologo = new Odontologo(12345,"Ileana","Malamud");
            Odontologo odontologoRegistrado = odontologoServicio.registrarOdontologo(odontologo);
            Assertions.assertNotNull(odontologoRegistrado.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void buscarTodos() {

        try {
            BD.createTable();
            OdontologoServicio odontologoServicio = new OdontologoServicio();

            Odontologo odontologo = new Odontologo(12345,"Ileana","Malamud");
            Odontologo odontologo1 = new Odontologo(21245,"Alexia","Tubaro");
            Odontologo odontologo2 = new Odontologo(32345,"Gino","Gozuk");

            odontologoServicio.registrarOdontologo(odontologo);
            odontologoServicio.registrarOdontologo(odontologo1);
            odontologoServicio.registrarOdontologo(odontologo2);

            List<Odontologo> odontologosEncontrados = odontologoServicio.buscarTodos();
            Assertions.assertNotNull(odontologosEncontrados);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
