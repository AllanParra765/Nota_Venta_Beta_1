/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nota_venta_beta;

import BaseDatos.ConexionMySQL;
import com.mysql.cj.xdevapi.Statement;
import static java.lang.Double.parseDouble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Notas_objetos;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author allan
 */
public class CRUDNotas {
      List<Notas_objetos> Notas = new ArrayList<Notas_objetos>();
      
           public static void insertarMySQL(Notas_objetos NotaRegistro) {
              
        ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();
        
        String query = "INSERT INTO Notas(Folio, NombreCliente, KilosRopa, Precio, Total, Comentario, FechaEntrega) VALUES(?,?,?,?,?,?,?)";
        //INSERT INTO `Notas3` (`Id_Nota`, `Folio`, `NombreCliente`, `KilosRopa`, `Precio`, `Total`, `Comentario`, `FechaLlegada`, `FechaEntrega`) VALUES (NULL, '12ddd', 'Lin', '12.90', '15.98', '1112.89', '2222222222', current_timestamp(), '2022-10-31 10:01:40');
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            
                ps.setString(1, NotaRegistro.getFolio());
                ps.setString(2, NotaRegistro.getNombre());
                ps.setDouble(3, NotaRegistro.getKilo());
                ps.setDouble(4, NotaRegistro.getPrecio());
                ps.setDouble(5, NotaRegistro.getTotal());
                ps.setString(6, NotaRegistro.getComentario());
       //         ps.setString(7, "2022-10-24");//NotaRegistro.getFechaEntrega());
                ps.setString(7, NotaRegistro.getFechaEntrega());
                
                ps.executeUpdate();
                
                System.out.println("Se inserto el elemento "+ NotaRegistro.getNombre());
            
            
            ps.close();
            con.close();
        } catch(SQLException e) {
            System.out.println("ALGO ANDA MAL ");
        }
    }
           
           
          
    public  List<Notas_objetos> CargarNotas(String buscar) throws SQLException {
        ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();

        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        String fecha = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
           System.out.println("cargar todo lo del día ");
         String query;
     
        if (buscar.contains("F_") ) {
          //  System.out.println("entre en folio");
            query= "SELECT * FROM Notas WHERE Entregado = 0  and Eliminado = 0 and Folio LIKE '"+buscar+"%'";
            //query= "SELECT * FROM Notas3 WHERE Entregado = 0  and Eliminado = 0 and Folio LIKE '?%'";
        }else{
                if (buscar.length()==0 ) {
                query= "SELECT * FROM `Notas` WHERE Entregado = 0  and Eliminado = 0";
               // query= "SELECT * FROM `Notas3` WHERE `FechaLlegada`='" +fecha+"' and Entregado = 0 ";
                }else{
                System.out.println("buscar nombre");
                query= "SELECT * FROM Notas WHERE NombreCliente LIKE '"+buscar+"%' and `Entregado` = 0  and Eliminado = 0";
               //query= "SELECT * FROM Notas3 WHERE NombreCliente LIKE '?%' and `Entregado` = 0  and Eliminado = 0";
             }
                
      
        }
        
               java.sql.Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); 
        
          while(rs.next()) {
              
    String Folio = rs.getString(2);
    String Nombre = rs.getString(3);
    String servicios = rs.getString(12);
    Double Kilo =parseDouble(rs.getString(4));
    Double Precio  = parseDouble(rs.getString(5));
    Double Total = parseDouble(rs.getString(6));
    String Comentario = rs.getString(7); 
    String  fechaLlegada = rs.getString(8)+"";
    String  fechaEntrega = rs.getString(9)+"";
                
                Notas.add(new Notas_objetos(Folio,Nombre,servicios,Kilo,Precio,Total,Comentario,fechaLlegada,fechaEntrega));
            }
          st.close();
            return Notas;
          
        
    }
    
      
    public boolean EliminarRegistro(String folio,String servicios) throws SQLException{
         boolean resp = false;
           ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();
        String query = "UPDATE `Notas` SET`Eliminado`=1 WHERE Folio=? And Servicios =? ";//"DELETE FROM articulos WHERE ID=?";//UPDATE `Notas3` SET`Entregado`=1,`Eliminado`=1 WHERE `Folio`="F_Licha08"
        PreparedStatement statement = con.prepareStatement(query);
	statement.setString(1, folio);
        statement.setString(2, servicios);

      
            resp = statement.executeUpdate() > 0;
		statement.close();
		con.close();
            return resp;
            
        }
    
      public boolean EntregarPedido(String Entregado) throws SQLException{
         boolean resp = false;
           ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();
        String query = "UPDATE `Notas` SET`Entregado`=1 WHERE Folio=?";//"DELETE FROM articulos WHERE ID=?";//UPDATE `Notas3` SET`Entregado`=1,`Eliminado`=1 WHERE `Folio`="F_Licha08"
        PreparedStatement statement = con.prepareStatement(query);
	statement.setString(1, Entregado);

      
            resp = statement.executeUpdate() > 0;
		statement.close();
		con.close();
            return resp;
            
        }
      
          public static void insertarListaMySQL(List<Notas_objetos> lista) {
              
        ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();
        

                      //    String query = "INSERT INTO Notas3(Folio, NombreCliente, KilosRopa, Precio, Total, Comentario, FechaEntrega, Servicios) VALUES(?,?,?,?,?,?,?,?)";
        //INSERT INTO `Notas3` (`Id_Nota`, `Folio`, `NombreCliente`, `KilosRopa`, `Precio`, `Total`, `Comentario`, `FechaLlegada`, `FechaEntrega`, `Entregado`, `Eliminado`, `Servicios`) VALUES (NULL, 'F_Sofia001', 'Yulay', '12.90', '15.98', '1112.89', 'hdbhscbdbcdscbjhsbchjhcdbjds', '2022-12-28', '2022-12-29', '0', '0', 'Colchoneta');
        try {
            for (int i = 0; i < lista.size(); i++) {
                 String query = "INSERT INTO Notas(Folio, NombreCliente, KilosRopa, Precio, Total, Comentario, FechaEntrega, Servicios) VALUES(?,?,?,?,?,?,?,?)";
       
                  System.out.println("entre en insert i vale "+ i + "y lista "+lista.size() );
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            
                ps.setString(1, lista.get(i).getFolio());
                ps.setString(2, lista.get(i).getNombre());
                ps.setDouble(3, lista.get(i).getKilo());
                ps.setDouble(4, lista.get(i).getPrecio());
                ps.setDouble(5, lista.get(i).getTotal());
                ps.setString(6, lista.get(i).getComentario());
       //       ps.setString(7, "2022-10-24");//NotaRegistro.getFechaEntrega());
                ps.setString(7, lista.get(i).getFechaEntrega());
                ps.setString(8, lista.get(i).getServicio());
                
                ps.executeUpdate();
                
                System.out.println("Se inserto el elemento "+ lista.get(i).getNombre());
             
        
            
            ps.close();
            
            }
            con.close();
        } catch(SQLException e) {
            System.out.println("ALGO ANDA MAL " + e);
        }
                  
             
        

    }
           
         
    
}
