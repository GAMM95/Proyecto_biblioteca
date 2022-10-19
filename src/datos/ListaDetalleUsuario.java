/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.DetalleUsuario;
import entidad.Ejemplar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListaDetalleUsuario {
    private ArrayList<DetalleUsuario> L ;

    public ListaDetalleUsuario()
    {
       L = new ArrayList();
    }

    public void agregar(DetalleUsuario e)
    {
       L.add(e);
    }

    public int buscar(Ejemplar e)
    {
        return L.indexOf(e);
    }

    public void ordenar(Comparator<DetalleUsuario> cs)
    {
        Collections.sort(L,cs);
    }


    public void eliminar(int i)
    {
        L.remove(i);
    }

    public DetalleUsuario getElemento(int i)
    {
        return L.get(i);
    }

    public int getN()
    {
        return L.size();
    }

    public void inserta(int i, DetalleUsuario e)
    {
        L.add(i,e);
    }

    public void reemplaza(int i, DetalleUsuario e)
    {
        L.set(i,e);
    }

    public ArrayList<DetalleUsuario> getL()
    {
        return L;
    }
            
    public void mostrar(DefaultTableModel modelo)
    {        
      String titulos[]={"idjemplar","Localizacion","Fecha Prestamo","Fecha Devolucion"};
      modelo.setColumnIdentifiers(titulos);
      modelo.getDataVector().removeAllElements();

      for(int i=0;i<L.size();i++)
      {
         DetalleUsuario x=L.get(i);
         String idejemplar = x.getEjemplar().getIdejemplar();
         String localizacion=x.getEjemplar().getLocalizacion();
         String fechaPrestamo=x.getFechaPrestamo();
         String fechaDevolucion=x.getFechaDevolucion();
         String fila[]={idejemplar,localizacion,fechaPrestamo,fechaDevolucion};
         modelo.addRow(fila);
      }
    }    
}
