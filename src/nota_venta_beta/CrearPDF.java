//sumar las cantidades *
//generar las etiquetas de cada uno de los servicios *
//formato de la fecha por servicio Similar a la del encabezado 
//Reimprimir el servicio mediante una lista para rapido
package nota_venta_beta;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import pojos.Notas_objetos;

public class CrearPDF {

    Double total = 0.0;
    String Comentarios_Nota = "";

    public void crearPDF(Notas_objetos lista, String fecha) throws FileNotFoundException, DocumentException, BadElementException, IOException {

//        CMYKColor BorderColor = new CMYKColor(255, 255, 255, 0);
//        com.itextpdf.text.Font ColorFuenteRenglonPares = FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.BOLD, new CMYKColor(0, 0, 0, 0));
//        CMYKColor BorderRadiusColorRenglonPares = new CMYKColor(183, 183, 174, 0);
//        CMYKColor BackgroundRenglonPares = new CMYKColor(206, 206, 202, 0);
//        com.itextpdf.text.Font Fuente_Color_titulos = FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.BOLD, new CMYKColor(0, 0, 0, 0));
//// Se crea el documento
//        Document documento = new Document();//podemos colocar la ruta a la qqque nos gustaria guardar los archivos.
//
//        // El OutPutStream para el fichero donde crearemos el PDF
//        FileOutputStream ficheroPDF = new FileOutputStream("/Users/allan/Desktop/Nota_Cliente_" + lista.getNombre() + ".pdf");
//
//        // Se asocia el documento de OutPutStream
//        PdfWriter.getInstance(documento, ficheroPDF);
//
//        // Se abre el documento
//        documento.open();
//        //insertar imagen
//
//        //   Image img = Image.getInstance("src/img/nota_v2.png");
//        //Fixed Positioning
//        // img.setAbsolutePosition(20f, 120f);
//        //Scale to new height and new width of image
//        // img.scaleAbsolute(550, 700);
//        //Fin de la imagen
//        // Parrafo
//        Paragraph titulo = new Paragraph("NOTA DE VENTA\nCLIENTE: " + lista.getNombre() + "\nFecha de Llegada:  " + fecha + "\n\n",
//                FontFactory.getFont("Myriad Pro",
//                        18,
//                        Font.BOLD,
//                        BaseColor.BLACK
//                )
//        );
//
//        // Añadimos el titulo al documento
//        documento.add(titulo);
//        // documento.add(img);
////
//        // Creamos una tabla registros
//        PdfPTable tabla = new PdfPTable(4);
//        tabla.setWidthPercentage(100); //Width 100%
//        tabla.setSpacingBefore(4f); //Space before table
//        tabla.setSpacingAfter(4f);
//
//        // Creamos una tabla
//        PdfPTable tabla2 = new PdfPTable(4);
//        tabla2.setWidthPercentage(100); //Width 100%
//        tabla2.setSpacingBefore(4f); //Space before table
//        tabla2.setSpacingAfter(4f);
//
//        //CREAMOS LOS TITULOS
////      //Servicios
//        PdfPCell ServiciosEncabezados = new PdfPCell(new Paragraph("Servicio", Fuente_Color_titulos));
//        ServiciosEncabezados.setBorderColor(BorderColor);
//        ServiciosEncabezados.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        ServiciosEncabezados.setPaddingLeft(10);
//        ServiciosEncabezados.setPaddingBottom(10);
//        ServiciosEncabezados.setPaddingTop(10);
//        ServiciosEncabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
//        ServiciosEncabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);
////
//        //Kilos, Pares, Piezas
//        PdfPCell Cantidad_Kilos_Pares_Piezas_Encabezados = new PdfPCell(new Paragraph("Kilos, Pares, Piezas", Fuente_Color_titulos));
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setBorderColor(BorderColor);
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingLeft(10);
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingBottom(10);
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingTop(10);
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Cantidad_Kilos_Pares_Piezas_Encabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        //Fecha de Entrega
//        PdfPCell fecha_Entrega = new PdfPCell(new Paragraph("Fecha de Entrega", Fuente_Color_titulos));
//        fecha_Entrega.setBorderColor(BorderColor);
//        fecha_Entrega.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        fecha_Entrega.setPaddingLeft(10);
//        fecha_Entrega.setPaddingBottom(10);
//        fecha_Entrega.setPaddingTop(10);
//        fecha_Entrega.setHorizontalAlignment(Element.ALIGN_CENTER);
//        fecha_Entrega.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        //Titulos
//        PdfPCell Precio = new PdfPCell(new Paragraph("Precios", Fuente_Color_titulos));
//        Precio.setBorderColor(BorderColor);
//        Precio.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        Precio.setPaddingLeft(10);
//        Precio.setPaddingBottom(10);
//        Precio.setPaddingTop(10);
//        Precio.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Precio.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        //Encabezados Agregados  
//        tabla.addCell(ServiciosEncabezados);
//        tabla.addCell(Cantidad_Kilos_Pares_Piezas_Encabezados);
//        tabla.addCell(fecha_Entrega);
//        tabla.addCell(Precio);
//
//        // CREAMOS LISTA DE REGISTROS
//        total += lista.getTotal();
//        PdfPCell Data_Precio = new PdfPCell(new Paragraph("$" + lista.getTotal(), ColorFuenteRenglonPares));
//        Data_Precio.setBorderColor(BorderRadiusColorRenglonPares);
//        Data_Precio.setBackgroundColor(BackgroundRenglonPares);
//        Data_Precio.setPaddingLeft(10);
//        Data_Precio.setPaddingBottom(10);
//        Data_Precio.setPaddingTop(10);
//        Data_Precio.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Data_Precio.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        PdfPCell Data_fecha_EntregaEncabezados = new PdfPCell(new Paragraph(lista.getFechaEntrega(), ColorFuenteRenglonPares));
//        Data_fecha_EntregaEncabezados.setBorderColor(BorderRadiusColorRenglonPares);
//        Data_fecha_EntregaEncabezados.setBackgroundColor(BackgroundRenglonPares);
//        Data_fecha_EntregaEncabezados.setPaddingLeft(10);
//        Data_fecha_EntregaEncabezados.setPaddingBottom(10);
//        Data_fecha_EntregaEncabezados.setPaddingTop(10);
//        Data_fecha_EntregaEncabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Data_fecha_EntregaEncabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        PdfPCell DataCantidad_Kilos_Pares_Piezas_Encabezados = new PdfPCell(new Paragraph(lista.getKilo() + "", ColorFuenteRenglonPares));
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setBorderColor(BorderRadiusColorRenglonPares);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setBackgroundColor(BackgroundRenglonPares);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingLeft(10);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingBottom(10);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingTop(10);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
//        DataCantidad_Kilos_Pares_Piezas_Encabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        PdfPCell DataServicio = new PdfPCell(new Paragraph(lista.getServicio(), ColorFuenteRenglonPares));
//        DataServicio.setBorderColor(BorderRadiusColorRenglonPares);
//        DataServicio.setBackgroundColor(BackgroundRenglonPares);
//        DataServicio.setPaddingLeft(10);
//        DataServicio.setPaddingBottom(10);
//        DataServicio.setPaddingTop(10);
//        DataServicio.setHorizontalAlignment(Element.ALIGN_CENTER);
//        DataServicio.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        //tabla.addCell(DataNombre);
//        tabla.addCell(DataServicio);
//        tabla.addCell(DataCantidad_Kilos_Pares_Piezas_Encabezados);
//        tabla.addCell(Data_fecha_EntregaEncabezados);
//        tabla.addCell(Data_Precio);
//
////
////        // Añadimos la tabla al documento
//        documento.add(tabla);
//
//        //Titulos de total
//        PdfPCell Total = new PdfPCell(new Paragraph("Total", Fuente_Color_titulos));
//        Total.setBorderColor(BorderColor);
//        Total.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        Total.setPaddingLeft(10);
//        Total.setPaddingBottom(10);
//        //Total.setPaddingTop(10);
//        Total.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Total.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        //Agregamos encabezados
//        //Apartado de comentarios con tres columnas y una para total.
//        PdfPCell Comentarios = new PdfPCell(new Paragraph("Comentarios", ColorFuenteRenglonPares));
//        Comentarios.setColspan(3);
//        Comentarios.setBorderColor(BorderColor);
//        Comentarios.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
//        Comentarios.setPaddingLeft(10);
//        Comentarios.setPaddingBottom(10);
//        //Total.setPaddingTop(10);
//        Comentarios.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Comentarios.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        tabla2.addCell(Comentarios);
//        tabla2.addCell(Total);
//
//        // CREAMOS LISTA DE REGISTROS
//        PdfPCell Data_Total = new PdfPCell(new Paragraph("$" + total, ColorFuenteRenglonPares));
//        Data_Total.setBorderColor(BorderRadiusColorRenglonPares);
//        Data_Total.setBackgroundColor(BackgroundRenglonPares);
//        Data_Total.setPaddingLeft(10);
//        Data_Total.setPaddingBottom(10);
//        Data_Total.setPaddingTop(10);
//        Data_Total.setHorizontalAlignment(Element.ALIGN_CENTER);
//        Data_Total.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//        PdfPCell Data_Comentarios = new PdfPCell(new Paragraph(lista.getComentario()));
//        Data_Comentarios.setColspan(3);
//        Data_Comentarios.setBorderColor(BorderRadiusColorRenglonPares);
//        Data_Comentarios.setBackgroundColor(BackgroundRenglonPares);
//        Data_Comentarios.setPaddingLeft(10);
//        Data_Comentarios.setPaddingBottom(10);
//        Data_Comentarios.setPaddingTop(10);
//        Data_Comentarios.setHorizontalAlignment(Element.ALIGN_LEFT);
//        Data_Comentarios.setVerticalAlignment(Element.ALIGN_LEFT);
//
//        tabla2.addCell(Data_Comentarios);
//        tabla2.addCell(Data_Total);
//
//        documento.add(tabla2);
////Resultados por columna
//        String footer = "resultados de footer \n\n" + fecha;
//        Paragraph pf = new Paragraph(footer);
//        pf.setAlignment(0x64);
//        // documento.add(p);
//
//        // Se cierra el documento
//        documento.close();

    }

    public void crearPDFLista(List<Notas_objetos> lista, String fecha) throws FileNotFoundException, DocumentException, BadElementException, IOException {

        CMYKColor BorderColor = new CMYKColor(255, 255, 255, 0);
        com.itextpdf.text.Font ColorFuenteRenglonPares = FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.BOLD, new CMYKColor(0, 0, 0, 0));
        CMYKColor BorderRadiusColorRenglonPares = new CMYKColor(183, 183, 174, 0);
        CMYKColor BackgroundRenglonPares = new CMYKColor(206, 206, 202, 0);
        com.itextpdf.text.Font Fuente_Color_titulos = FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.BOLD, new CMYKColor(0, 0, 0, 0));
// Se crea el documento
        Document documento = new Document();//podemos colocar la ruta a la qqque nos gustaria guardar los archivos.

        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("/Users/allan/Desktop/Nota_Cliente_" + lista.get(0).getNombre() + ".pdf");

        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);

        // Se abre el documento
        documento.open();
        //insertar imagen

           Image img = Image.getInstance("src/img/portadaLH.png");
       // Fixed Positioning
        // img.setAbsolutePosition(20f, 120f);
       // Scale to new height and new width of image
        // img.scaleAbsolute(550, 700);
        img.setAbsolutePosition(14f, 120f);
        img.scaleAbsolute(550, 738);
        //Fin de la imagen
        // Parrafo
        Paragraph titulo = new Paragraph("NOTA DE VENTA\nCLIENTE: " + lista.get(0).getNombre() +" / "+ lista.get(0).getFolio()+ "\nFecha de Llegada:  " + fecha + "\n\n",
                FontFactory.getFont("Myriad Pro",
                        16,
                        Font.BOLD,
                        BaseColor.WHITE
                )
        );

        // Añadimos el titulo al documento
        documento.add(titulo);
         documento.add(img);
//
        // Creamos una tabla registros
        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100); //Width 100%
        tabla.setSpacingBefore(4f); //Space before table
        tabla.setSpacingAfter(4f);

        // Creamos una tabla
        PdfPTable tabla2 = new PdfPTable(4);
        tabla2.setWidthPercentage(100); //Width 100%
        tabla2.setSpacingBefore(4f); //Space before table
        tabla2.setSpacingAfter(4f);
        
        
        ////////////////////////////////////////////////////////////////////////////////////  Segunda tabla de registros para PERSONAL      
           PdfPTable tablaBlanca = new PdfPTable(4);
        tablaBlanca.setWidthPercentage(100); //Width 100%
        tablaBlanca.setSpacingBefore(14f); //Space before table
        tablaBlanca.setSpacingAfter(14f);
       // tablaBlanca.setPaddingTop(170f);
        

        // Creamos una tabla registros
        PdfPTable tablaPersonalServicios = new PdfPTable(4);
        tablaPersonalServicios.setWidthPercentage(100); //Width 100%
        tablaPersonalServicios.setSpacingBefore(4f); //Space before table
        tablaPersonalServicios.setSpacingAfter(4f);
        tablaPersonalServicios.setPaddingTop(100f);
        

        // Creamos una tabla
        PdfPTable tablaPersonalCobro = new PdfPTable(4);
        tablaPersonalCobro.setWidthPercentage(100); //Width 100%
        tablaPersonalCobro.setSpacingBefore(4f); //Space before table
        tablaPersonalCobro.setSpacingAfter(4f);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
      
        //CREAMOS LOS TITULOS
//      //Servicios
        PdfPCell ServiciosEncabezados = new PdfPCell(new Paragraph("Servicio", Fuente_Color_titulos));
        ServiciosEncabezados.setBorderColor(BorderColor);
        ServiciosEncabezados.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        ServiciosEncabezados.setPaddingLeft(10);
        ServiciosEncabezados.setPaddingBottom(10);
        ServiciosEncabezados.setPaddingTop(10);
        ServiciosEncabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
        ServiciosEncabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
        //Kilos, Pares, Piezas
        PdfPCell Cantidad_Kilos_Pares_Piezas_Encabezados = new PdfPCell(new Paragraph("Kilos, Pares, Piezas", Fuente_Color_titulos));
        Cantidad_Kilos_Pares_Piezas_Encabezados.setBorderColor(BorderColor);
        Cantidad_Kilos_Pares_Piezas_Encabezados.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingLeft(10);
        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingBottom(10);
        Cantidad_Kilos_Pares_Piezas_Encabezados.setPaddingTop(10);
        Cantidad_Kilos_Pares_Piezas_Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
        Cantidad_Kilos_Pares_Piezas_Encabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);

        //Fecha de Entrega
        PdfPCell fecha_Entrega = new PdfPCell(new Paragraph("Fecha de Entrega", Fuente_Color_titulos));
        fecha_Entrega.setBorderColor(BorderColor);
        fecha_Entrega.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        fecha_Entrega.setPaddingLeft(10);
        fecha_Entrega.setPaddingBottom(10);
        fecha_Entrega.setPaddingTop(10);
        fecha_Entrega.setHorizontalAlignment(Element.ALIGN_CENTER);
        fecha_Entrega.setVerticalAlignment(Element.ALIGN_MIDDLE);

        //Titulos
        PdfPCell Precio = new PdfPCell(new Paragraph("Precios", Fuente_Color_titulos));
        Precio.setBorderColor(BorderColor);
        Precio.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        Precio.setPaddingLeft(10);
        Precio.setPaddingBottom(10);
        Precio.setPaddingTop(10);
        Precio.setHorizontalAlignment(Element.ALIGN_CENTER);
        Precio.setVerticalAlignment(Element.ALIGN_MIDDLE);

        //Encabezados Agregados  
        tabla.addCell(ServiciosEncabezados);
        tabla.addCell(Cantidad_Kilos_Pares_Piezas_Encabezados);
        tabla.addCell(fecha_Entrega);
        tabla.addCell(Precio);
        
                ////////////////////////////////////////////////////////////////////////////////////  Segunda tabla de registros para PERSONAL          
        //Encabezados Agregados 
        tablaBlanca.addCell("");
        tablaBlanca.addCell("");
        tablaBlanca.addCell("");
        tablaBlanca.addCell("");
        tablaPersonalServicios.addCell(ServiciosEncabezados);
        tablaPersonalServicios.addCell(Cantidad_Kilos_Pares_Piezas_Encabezados);
        tablaPersonalServicios.addCell(fecha_Entrega);
        tablaPersonalServicios.addCell(Precio);
//////////////////////////////////////////////////////////////////////////////        
        

        for (int i = 0; i < lista.size(); i++) {

            // CREAMOS LISTA DE REGISTROS
            total += lista.get(i).getTotal();
            PdfPCell Data_Precio = new PdfPCell(new Paragraph("$" + lista.get(i).getTotal(), ColorFuenteRenglonPares));
            Data_Precio.setBorderColor(BorderRadiusColorRenglonPares);
            Data_Precio.setBackgroundColor(BackgroundRenglonPares);
            Data_Precio.setPaddingLeft(10);
            Data_Precio.setPaddingBottom(10);
            Data_Precio.setPaddingTop(10);
            Data_Precio.setHorizontalAlignment(Element.ALIGN_CENTER);
            Data_Precio.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell Data_fecha_EntregaEncabezados = new PdfPCell(new Paragraph(lista.get(i).getFechaEntrega(), ColorFuenteRenglonPares));
            Data_fecha_EntregaEncabezados.setBorderColor(BorderRadiusColorRenglonPares);
            Data_fecha_EntregaEncabezados.setBackgroundColor(BackgroundRenglonPares);
            Data_fecha_EntregaEncabezados.setPaddingLeft(10);
            Data_fecha_EntregaEncabezados.setPaddingBottom(10);
            Data_fecha_EntregaEncabezados.setPaddingTop(10);
            Data_fecha_EntregaEncabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
            Data_fecha_EntregaEncabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell DataCantidad_Kilos_Pares_Piezas_Encabezados = new PdfPCell(new Paragraph(lista.get(i).getKilo() + "", ColorFuenteRenglonPares));
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setBorderColor(BorderRadiusColorRenglonPares);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setBackgroundColor(BackgroundRenglonPares);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingLeft(10);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingBottom(10);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setPaddingTop(10);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setHorizontalAlignment(Element.ALIGN_CENTER);
            DataCantidad_Kilos_Pares_Piezas_Encabezados.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell DataServicio = new PdfPCell(new Paragraph(lista.get(i).getServicio(), ColorFuenteRenglonPares));
            DataServicio.setBorderColor(BorderRadiusColorRenglonPares);
            DataServicio.setBackgroundColor(BackgroundRenglonPares);
            DataServicio.setPaddingLeft(10);
            DataServicio.setPaddingBottom(10);
            DataServicio.setPaddingTop(10);
            DataServicio.setHorizontalAlignment(Element.ALIGN_CENTER);
            DataServicio.setVerticalAlignment(Element.ALIGN_MIDDLE);

            //tabla.addCell(DataNombre);
            tabla.addCell(DataServicio);
            tabla.addCell(DataCantidad_Kilos_Pares_Piezas_Encabezados);
            tabla.addCell(Data_fecha_EntregaEncabezados);
            tabla.addCell(Data_Precio);
            
////// agregamos datos a la tabla del personal   
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");
tablaBlanca.addCell("");

            tablaPersonalServicios.addCell(DataServicio);
            tablaPersonalServicios.addCell(DataCantidad_Kilos_Pares_Piezas_Encabezados);
            tablaPersonalServicios.addCell(Data_fecha_EntregaEncabezados);
            tablaPersonalServicios.addCell(Data_Precio);

            ///untamos todos los comentarios
            Comentarios_Nota +="*"+ lista.get(i).getComentario()+"\n";
//
//        // Añadimos la tabla al documento
            

        }
documento.add(tabla);
        //Titulos de total
        PdfPCell Total = new PdfPCell(new Paragraph("Total", Fuente_Color_titulos));
        Total.setBorderColor(BorderColor);
        Total.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        Total.setPaddingLeft(10);
        Total.setPaddingBottom(10);
        //Total.setPaddingTop(10);
        Total.setHorizontalAlignment(Element.ALIGN_CENTER);
        Total.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //Agregamos encabezados
        //Apartado de comentarios con tres columnas y una para total.
        PdfPCell Comentarios = new PdfPCell(new Paragraph("Comentarios", Fuente_Color_titulos));
        Comentarios.setColspan(3);
        Comentarios.setBorderColor(BorderColor);
        Comentarios.setBackgroundColor(new CMYKColor(165, 165, 160, 0));
        Comentarios.setPaddingLeft(10);
        Comentarios.setPaddingBottom(10);
        //Total.setPaddingTop(10);
        Comentarios.setHorizontalAlignment(Element.ALIGN_CENTER);
        Comentarios.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla2.addCell(Comentarios);
        tabla2.addCell(Total);

        // CREAMOS LISTA DE REGISTROS
        PdfPCell Data_Total = new PdfPCell(new Paragraph("$" + total, ColorFuenteRenglonPares));
        Data_Total.setBorderColor(BorderRadiusColorRenglonPares);
        Data_Total.setBackgroundColor(BackgroundRenglonPares);
        Data_Total.setPaddingLeft(10);
        Data_Total.setPaddingBottom(10);
        Data_Total.setPaddingTop(10);
        Data_Total.setHorizontalAlignment(Element.ALIGN_CENTER);
        Data_Total.setVerticalAlignment(Element.ALIGN_MIDDLE);

        
        PdfPCell Data_Comentarios = new PdfPCell(new Paragraph(Comentarios_Nota, ColorFuenteRenglonPares));
        Data_Comentarios.setColspan(3);
        Data_Comentarios.setBorderColor(BorderRadiusColorRenglonPares);
        Data_Comentarios.setBackgroundColor(BackgroundRenglonPares);
        Data_Comentarios.setPaddingLeft(10);
        Data_Comentarios.setPaddingBottom(10);
        Data_Comentarios.setPaddingTop(10);
        Data_Comentarios.setHorizontalAlignment(Element.ALIGN_LEFT);
        Data_Comentarios.setVerticalAlignment(Element.ALIGN_LEFT);

        tabla2.addCell(Data_Comentarios);
        Comentarios_Nota +="\nCLIENTE:" + lista.get(0).getNombre() +"\nFolio: "+lista.get(0).getFolio()+ "\nFecha de Llegada:" + fecha;
        PdfPCell Data_ComentariosPersonal = new PdfPCell(new Paragraph(Comentarios_Nota, ColorFuenteRenglonPares));
        Data_ComentariosPersonal.setColspan(3);
        Data_ComentariosPersonal.setBorderColor(BorderRadiusColorRenglonPares);
        Data_ComentariosPersonal.setBackgroundColor(BackgroundRenglonPares);
        Data_ComentariosPersonal.setPaddingLeft(10);
        Data_ComentariosPersonal.setPaddingBottom(10);
        Data_ComentariosPersonal.setPaddingTop(10);
        Data_ComentariosPersonal.setHorizontalAlignment(Element.ALIGN_LEFT);
        Data_ComentariosPersonal.setVerticalAlignment(Element.ALIGN_LEFT);
        
        tabla2.addCell(Data_Total);

        documento.add(tabla2);
               
         
 tablaBlanca.addCell(Data_Total);    
 documento.add(tablaBlanca);
 
 tablaPersonalCobro.addCell(Comentarios);
 tablaPersonalCobro.addCell(Total);
 
 documento.add(tablaPersonalServicios);
 tablaPersonalCobro.addCell(Data_ComentariosPersonal);
 tablaPersonalCobro.addCell(Data_Total);
 documento.add(tablaPersonalCobro);

//Resultados por columna
        String footer = "resultados de footer \n\n" + fecha;
        Paragraph pf = new Paragraph(footer);
        pf.setAlignment(0x64);
        // documento.add(p);

        // Se cierra el documento
        documento.close();

    }
}
