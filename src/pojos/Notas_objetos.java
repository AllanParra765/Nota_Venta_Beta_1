/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author allan
 */
public class Notas_objetos {
    String Folio;
    String Nombre;
    String servicio;
    Double kilo;
    Double Precio;
    Double Total;
     String  fechaLlegada;
    String  fechaEntrega;
    String Comentario;

     public Notas_objetos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Notas_objetos(String Folio,String Nombre,String Servicio, Double kilo, Double Precio, Double Total,String  fechaEntrega,String Comentario) {
        this.Folio = Folio;
        this.Nombre = Nombre;
        this.servicio = Servicio;
        this.kilo = kilo;
        this.Precio = Precio;
        this.Total = Total;
        this.fechaEntrega = fechaEntrega;
        this.Comentario = Comentario;
        
        
    }

    public Notas_objetos(String Folio, String Nombre,String Servicio, Double Kilo, Double Precio, Double Total, String Comentario, String fechaLlegada, String fechaEntrega) {
          this.Folio = Folio;
        this.Nombre = Nombre;
        this.kilo = Kilo;
        this.servicio = Servicio;
        this.Precio = Precio;
        this.Total = Total;
        this.fechaEntrega = fechaEntrega;
        this.Comentario = Comentario;
        this.fechaLlegada = fechaLlegada;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getKilo() {
        return kilo;
    }

    public void setKilo(Double kilo) {
        this.kilo = kilo;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    

}
