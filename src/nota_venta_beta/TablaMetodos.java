
package nota_venta_beta;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pojos.Notas_objetos;

/**
 *
 * @author allan
 */
public class TablaMetodos {
    DefaultTableModel tb = new DefaultTableModel();

    
        public DefaultTableModel CargarDatos(String buscar){
       // modelo = (DefaultTableModel) jtablaDatos.getModel();
       DefaultTableModel modelo= new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Id", "Folio", "Nombre","Servicios", "Kilo(s)", "Precio $", " Total ", "Comentarios", " Fecha llegada","Fecha_Entrega", "PDF", "Eliminar"});
        try {
           // System.out.println(buscar);
             CRUDNotas objCargarNotas = new CRUDNotas();
            List<Notas_objetos> lista =  objCargarNotas.CargarNotas(buscar);
            for(Notas_objetos nota : lista) {
                modelo.addRow(new Object[]{
                    (modelo.getRowCount() + 1),nota.getFolio(),nota.getNombre(),nota.getServicio(),(nota.getKilo()+ " Kilo(s)"), ("$" + nota.getPrecio()), ("$" + nota.getTotal()), nota.getComentario(),nota.getFechaLlegada(),nota.getFechaEntrega(), "Reimprimir", "Eliminar"
                });
            }
           
        
           // tbRegistros.setModel(modelo);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            System.out.println("renglones "+modelo.getRowCount());
        return modelo;
    }
    
    
        
        
    
}
