package entidad;

import datos.ListaDetalleLibro;
import javax.swing.table.DefaultTableModel;


public class Libro {
    private String idlibro;
    private String titulo;
    private String isbn;
    private String editorial;
    private int paginas;
    private ListaDetalleLibro LD;

    public Libro() {
    }

    public Libro(String idlibro, String titulo, String isbn, String editorial, int paginas) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
        LD = new ListaDetalleLibro();
    }

    public String getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(String idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    public void registrarDetalleLibro(DetalleLibro det)
    {
        LD.agregar(det);
    }
    
    public void mostrarListaDetalle(DefaultTableModel modelo){
        LD.mostrar(modelo);
    }

    public ListaDetalleLibro getLD() {
        return LD;
    }

    public void setLD(ListaDetalleLibro LD) {
        this.LD = LD;
    }
}
