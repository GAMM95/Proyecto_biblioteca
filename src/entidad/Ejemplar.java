package entidad;

public class Ejemplar {
    private String idejemplar;
    private String localizacion;
    private Libro libro;

    public Ejemplar() {
    }

    public Ejemplar(String idejemplar, String localizacion, Libro libro) {
        this.idejemplar = idejemplar;
        this.localizacion = localizacion;
        this.libro = libro;
    }

    public String getIdejemplar() {
        return idejemplar;
    }

    public void setIdejemplar(String idejemplar) {
        this.idejemplar = idejemplar;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "idejemplar=" + idejemplar + ", localizacion=" + localizacion + ", libro=" + libro + '}';
    }
    
    
}
