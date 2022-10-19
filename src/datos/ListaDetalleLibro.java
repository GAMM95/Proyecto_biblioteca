package datos;

import entidad.Autor;
import entidad.DetalleLibro;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ListaDetalleLibro {
    private ArrayList<DetalleLibro> L ;

    public ListaDetalleLibro(){
        L = new ArrayList();
    }

    public void agregar(DetalleLibro e){
        L.add(e);
    }

    public int buscar(Autor e){
        return L.indexOf(e);
    }

    public void eliminar(int i){
        L.remove(i);
    }

    public DetalleLibro getElemento(int i){
        return L.get(i);
    }

    public int getN(){
        return L.size();
    }

    public ArrayList<DetalleLibro> getL(){
                return L;
    }
            
    public void mostrar(DefaultTableModel modelo)
    {        
        Object datos[][]=new Object[L.size()][5];
        String titulos[]={"IDAUTOR","NOMBRE"};

        for(int i=0;i<L.size();i++){
            DetalleLibro x=L.get(i);
            datos[i][0]=x.getAutor().getIdautor();
            datos[i][1]=x.getAutor().getNombre();
       }
       modelo.setDataVector(datos, titulos);
    }
}
