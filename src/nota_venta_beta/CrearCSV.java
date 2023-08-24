



package nota_venta_beta;


import BaseDatos.ConexionMySQL;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojos.Notas_objetos;

/**
 *
 * @author allan
 */
public class CrearCSV {
   
    public Notas_objetos Notas(Notas_objetos Nota, String Fecha){
        crearCsvNotaActual(Nota,Fecha);

        CRUDNotas.insertarMySQL(Nota);
        
        return Nota;// puede return true;
    }
    
     public List<Notas_objetos> NotaLista( List<Notas_objetos> lista, String Fecha){
        crearCsvNotaActualLista(lista,Fecha);

        CRUDNotas.insertarListaMySQL(lista);
        
        return lista;// puede return true;
    }
    
    

   
    public void crearCsvNotaActual(Notas_objetos Nota, String Fecha){
        
         String salidaArchivo = "Nota_"+Fecha.replace('/', '_')+".csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo escribimos sobre el
        if(existe) {
             // Si existe un archivo llamado asi lo borra
          // File archivoUsuarios = new File(salidaArchivo);
          // archivoUsuarios.delete();
          
           try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                salidaCSV.write(Nota.getNombre());
                salidaCSV.write(Nota.getKilo()+" kilos");
                salidaCSV.write("$"+Nota.getPrecio());
                salidaCSV.write("$"+Nota.getTotal());
                salidaCSV.write(Nota.getFechaEntrega());
                salidaCSV.write(Fecha);
                salidaCSV.write(Nota.getComentario());
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }
          
        }else{
            
             try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Kilo");
            salidaCSV.write("Precio");
            salidaCSV.write("Total");
            salidaCSV.write("Fecha_Llegada");
            salidaCSV.write("Fecha_Entrega");
            salidaCSV.write("Comentarios");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
           // for(Usuario user : usuarios) {
               salidaCSV.write(Nota.getNombre());
                salidaCSV.write(Nota.getKilo()+" kilos");
                salidaCSV.write("$"+Nota.getPrecio());
                salidaCSV.write("$"+Nota.getTotal());
                salidaCSV.write(Fecha);
                salidaCSV.write(Nota.getFechaEntrega());
                salidaCSV.write(Nota.getComentario());
                
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            //}
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        } 
            
        }
           
    }
       


 public void crearCsvNotaActualLista(List<Notas_objetos> lista, String Fecha){
        
         String salidaArchivo = "Nota_"+Fecha.replace('/', '_')+".csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo escribimos sobre el
        if(existe) {
             // Si existe un archivo llamado asi lo borra
          // File archivoUsuarios = new File(salidaArchivo);
          // archivoUsuarios.delete();
           for (int i = 0; i < lista.size(); i++) {
               
                 try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                salidaCSV.write(lista.get(i).getNombre());
                salidaCSV.write(lista.get(i).getKilo()+" kilos");
                
                salidaCSV.write("$"+lista.get(i).getPrecio());
                salidaCSV.write("$"+lista.get(i).getTotal());
                salidaCSV.write(lista.get(i).getFechaEntrega());
                salidaCSV.write(Fecha);
                salidaCSV.write(lista.get(i).getComentario());
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }
           }
         
          
        }else{
             for (int i = 0; i < lista.size(); i++) {
             
                       try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Kilo");
            salidaCSV.write("Precio");
            salidaCSV.write("Total");
            salidaCSV.write("Fecha_Llegada");
            salidaCSV.write("Fecha_Entrega");
            salidaCSV.write("Comentarios");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
           // for(Usuario user : usuarios) {
               salidaCSV.write(lista.get(i).getNombre());
                salidaCSV.write(lista.get(i).getKilo()+" kilos");
                salidaCSV.write("$"+lista.get(i).getPrecio());
                salidaCSV.write("$"+lista.get(i).getTotal());
                salidaCSV.write(Fecha);
                salidaCSV.write(lista.get(i).getFechaEntrega());
                salidaCSV.write(lista.get(i).getComentario());
                
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            //}
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        } 
             }
       
            
        }
           
    }
       
}
