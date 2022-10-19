package entidad;

import datos.ListaDetalleUsuario;
import javax.swing.table.DefaultTableModel;

public class Usuario {
    private String idusuario;
    private String nombre;
    private String telefono;
    private String direccion;
    private ListaDetalleUsuario LD;

    public Usuario() {
    }

    public Usuario(String idusuario, String nombre, String telefono, String direccion) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        LD= new ListaDetalleUsuario();
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaDetalleUsuario getLD() {
        return LD;
    }

    public void setLD(ListaDetalleUsuario LD) {
        this.LD = LD;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    public void registrarDetalleUsuario(DetalleUsuario det)
    {
        LD.agregar(det);
    }
    
    public void mostrarListaDetalle(DefaultTableModel modelo){
        LD.mostrar(modelo);
    }
    
}
