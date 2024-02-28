package servicio;

import dao.IDao;
import dao.implementacion.OdontologoDAOH2;
import dao.implementacion.OdontologoDAOMemoria;
import entidades.Odontologo;

import java.util.List;

public class OdontologoServicio {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoServicio(){this.odontologoIDao = new OdontologoDAOH2();}
    //Para ejecutar en MEMORIA cambiar de new OdontologoDAOH2() a new OdontologoDAOMemoria()
    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);

    }
    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

}
