package entidad;

public class Autor {
    private String idautor;
    private String nombre;

    public Autor() {
    }

    public Autor(String idautor, String nombre) {
        this.idautor = idautor;
        this.nombre = nombre;
    }

    public String getIdautor() {
        return idautor;
    }

    public void setIdautor(String idautor) {
        this.idautor = idautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" + "idautor=" + idautor + ", nombre=" + nombre + '}';
    }
}
