package entidad;

public class DetalleLibro {
    private Autor autor;
    

    public DetalleLibro() {
    }

    public DetalleLibro(Autor autor) {
        this.autor = autor;
    }
    
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
