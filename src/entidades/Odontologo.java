package entidades;

public class Odontologo {

    private int id;
    private int nroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(int id, int nroMatricula, String nombre, String apellido) {
        this.id = id;
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int nroMatricula, String nombre, String apellido) {
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "----------------------- Los datos del Odontologo son: --------------" +'\n'+
                "id= " + id +
                ", Numero de Matricula= " + nroMatricula +
                ", Nombre= '" + nombre + '\'' +
                ", Apellido= '" + apellido + '\'' +
                '\n';
    }
}
