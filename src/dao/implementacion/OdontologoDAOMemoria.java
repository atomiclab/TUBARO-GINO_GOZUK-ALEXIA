package dao.implementacion;

import dao.IDao;
import entidades.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOMemoria.class);
    private List<Odontologo> odontologoRepo = new ArrayList<>();
    public List<Odontologo> getOdontologoRepo() {
        return odontologoRepo;
    }

    public void setOdontologoRepo(List<Odontologo> odontologoRepo) {
        this.odontologoRepo = odontologoRepo;
    }


    @Override
    public Odontologo registrar(Odontologo o) {
        int id = odontologoRepo.size() + 1;
        Odontologo odontologoRegistrado = new Odontologo(id, o.getNroMatricula(), o.getNombre(), o.getApellido());
        odontologoRepo.add(odontologoRegistrado);
        LOGGER.info("El odontólogo: " + odontologoRegistrado.getNombre()+ " se registró en memoria");
        return odontologoRegistrado;
    }


    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Los odontólogos encontrados EN MEMORIA son: '\n' " + String.valueOf(odontologoRepo));
        return odontologoRepo;
    }
}
