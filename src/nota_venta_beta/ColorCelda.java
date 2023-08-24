package nota_venta_beta;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author allan
 */
public class ColorCelda extends DefaultTableCellRenderer {

    Calendar c = new GregorianCalendar(); 
    Date dataFormateada;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, o, isSelected, hasFocus, row, column);
        if (o instanceof String) {
            String Dato = (String) o;

            c.setTime(new Date());

            String fecha = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);

            String a = Dato.substring(0, 4);

            if (Dato.equals("Eliminar")) {
                labelResultado.setBackground(Color.red);
                labelResultado.setForeground(Color.white);
            } else {
                labelResultado.setBackground(Color.GRAY);
                labelResultado.setForeground(Color.white);
            }

            if (a.equals(c.get(Calendar.YEAR) + "")) {

                int dia = Integer.valueOf(Dato.substring(8, 10));
                if (dia < (c.get(Calendar.DATE))) {//dia es antes de la fecha es amarillo
                     labelResultado.setBackground(Color.red);
                labelResultado.setForeground(Color.white);
                }else{//dia es falta de la fecha es verde
                     labelResultado.setBackground(Color.yellow);
                labelResultado.setForeground(Color.black);
                }
       
             
                
               // System.out.println("Datos2 " + Dato.substring(5, 7));
               //System.out.println("Datos3 " + Dato.substring(8, 10));

            }
    //        System.out.println("fecha.equals(Dato) "+fecha+" "+ Dato);
            if (fecha.equals(Dato)) {//es de hoy pintalo verde
                labelResultado.setBackground(Color.green);
                labelResultado.setForeground(Color.black);
            }else{
                
            }

        }

        return labelResultado;
    }

}
