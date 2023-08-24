/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nota_venta_beta;

import java.awt.event.KeyEvent;
import static java.lang.Double.parseDouble;

/**
 *
 * @author allan
 */
public class Validacion {
    
    
    
    public String validacionNumeros(String texto) {
        if (texto.length()>0) {
            try {
            String cadena = String.format("%.2f", parseDouble(texto));
            return cadena;
        } catch (NumberFormatException e) {
            return "No";
        }
            
    }
        return "Vacio";
        }
            
        
        

    public String validacionTextos(String texto) {
if (texto.length()>0) {
    char[] Cadena = texto.toCharArray();
            for (char c : Cadena) {
                if (!Character.isAlphabetic(c) && c!=' ') {
                return "No"; 
                }
            }
          return texto;
}
    return texto;       
    }    
}
