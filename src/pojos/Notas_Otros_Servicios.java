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
public class Notas_Otros_Servicios {
    String Folio;
    Double Servicio;
    String Nombre;
    Double Precio;
    Double Kilos_Pares_Precios;
    Double Total;
       String  fechaLlegada;
    String  fechaEntrega;
    String Comentario;

    public Notas_Otros_Servicios(String Folio, Double Servicio, String Nombre, Double Precio, Double Kilos_Pares_Precios, Double Total, String fechaLlegada, String fechaEntrega, String Comentario) {
        this.Folio = Folio;
        this.Servicio = Servicio;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Kilos_Pares_Precios = Kilos_Pares_Precios;
        this.Total = Total;
        this.fechaLlegada = fechaLlegada;
        this.fechaEntrega = fechaEntrega;
        this.Comentario = Comentario;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public Double getServicio() {
        return Servicio;
    }

    public void setServicio(Double Servicio) {
        this.Servicio = Servicio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getKilos_Pares_Precios() {
        return Kilos_Pares_Precios;
    }

    public void setKilos_Pares_Precios(Double Kilos_Pares_Precios) {
        this.Kilos_Pares_Precios = Kilos_Pares_Precios;
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
    
    

}