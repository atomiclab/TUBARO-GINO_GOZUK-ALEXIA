import dao.BD;
import entidades.Odontologo;
import servicio.OdontologoServicio;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {



        try {
            BD.createTable();
            OdontologoServicio odontologoServicio = new OdontologoServicio();

            Odontologo odontologo = new Odontologo(12345,"Ileana","Malamud");
            Odontologo odontologo1 = new Odontologo(21245,"Alexia","Gozuk");
            Odontologo odontologo2 = new Odontologo(32345,"Gino","Tubaro");

            odontologoServicio.registrarOdontologo(odontologo);
            odontologoServicio.registrarOdontologo(odontologo1);
            odontologoServicio.registrarOdontologo(odontologo2);

            List<Odontologo> odontologosEncontrados = odontologoServicio.buscarTodos();
            System.out.println(odontologosEncontrados.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}