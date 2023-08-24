/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nota_venta_beta;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import pojos.Notas_objetos;

/**
 *
 * @author allan
 */
public class ExportarCSV {
    
      public static void exportarCSV(List<Notas_objetos> usuarios) {
         System.out.println("Entre a generar CSV");
         String salidaArchivo = "Usuarios1.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }
        
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Kilos");
            salidaCSV.write("Precio");
            salidaCSV.write("Total");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
            for(Notas_objetos user : usuarios) {
                salidaCSV.write(user.getNombre());
                salidaCSV.write(user.getKilo()+"");
                salidaCSV.write(user.getPrecio()+"");
                salidaCSV.write(user.getTotal()+"");
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
   
    
}
