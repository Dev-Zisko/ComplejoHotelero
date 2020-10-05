/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Dominio.*;
import Data.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Christian D
 */
public class Controladora {

    Data dato = new Data();
    JFrame Ventana;
     Document reporte1 = new Document(PageSize.LETTER, 20, 20, 20, 20); //Crea documento donde se guardara la lista de correos
   
    public Controladora(JFrame Ventana){
        this.Ventana = Ventana;
      
    }
    //Funciones de conversion:
    public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date){
        if(date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    
    public void activarPanel(JPanel panelA, JPanel panelB){
        panelA.setVisible(true);
        panelB.setVisible(false);
    }
    
    public void activarPanel1(JPanel panelA, JPanel panelB, JPanel panelC){
        panelA.setVisible(true);
        panelB.setVisible(false);
        panelC.setVisible(false);
    }
    
    public void activarPanel2(JPanel panelA, JPanel panelB, JPanel panelC, JPanel panelD){
        panelA.setVisible(true);
        panelB.setVisible(false);
        panelC.setVisible(false);
        panelD.setVisible(false);
    }
    
   
     
    public String FormatoTelefono(String s1, String s2){
        s1 = s1+"-"+s2;
        return s1;
        
    }
    // Se debe poner "" los campos y pk que no se vayan a usar
    public String GenerarCondicionConsulta(String tabla, String campo1, String campo2, String campo3, String pk1, String pk2, String pk3){
         String condicion= "";
         String condicion2= "";
         if(pk1.equals(""))
             pk1="";
         else
             pk1 = campo1 + " LIKE '%" + pk1+"%'";
         if(pk2.equals(""))
             pk2="";
         else
             pk2 = campo2 + " LIKE '%" + pk2+"%'";
         if(pk3.equals(""))
             pk3="";
         else
             pk3 = campo3 + " Like '%" + pk3+"%'";
         
         
        if(!pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
            condicion = campo1 + "," + campo2 + "," + campo3;
            condicion2 = pk1 + " AND " + pk2 + " AND " + pk3;
        }
       
        if(pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
            condicion = campo2 + "," + campo3;
            condicion2 =  pk2 + " AND " + pk3;
        }
        if(!pk1.equals("") && pk2.equals("") && !pk3.equals("")){
            condicion = campo1 + "," + campo3;
            condicion2 = pk1 + " AND " + pk3;
        }
        if(!pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            condicion = campo1 + "," + campo2;
            condicion2 = pk1 + " AND " + pk2;
        }
        if(pk1.equals("") && pk2.equals("") && !pk3.equals("")){
            condicion = campo3;
            condicion2 = pk3;
        }
        if(pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            condicion = campo2;
            condicion2 = pk2;
        }
        if(!pk1.equals("") && pk2.equals("") && pk3.equals("")){
            condicion = campo1;
            condicion2 = pk1;
        }
        condicion = "SELECT * FROM " + tabla + " WHERE " + condicion2;
      //  condicion = "SELECT * FROM " + tabla+" A,"+ tabla2 + " B WHERE " + condicion2 + "";
        
        
        if(pk1.equals("") && pk2.equals("") && pk3.equals("")){
            condicion = "Select * from "+ tabla;
           
        }
        System.out.println(condicion);
        return(condicion);  
     }
    // Se debe poner "" los campos y pk que no se vayan a usar
    public String GenerarCondicionDelete(String tabla, String campo1, String campo2, String campo3, String pk1, String pk2, String pk3){
        String condicion;
        String condicion2="";
       if(pk1.equals(""))
             pk1="";
         else
             pk1 = campo1 + "=" + pk1;
         if(pk2.equals(""))
             pk2="";
         else
             pk2 = campo2 + "=" + pk2;
         if(pk3.equals(""))
             pk3="";
         else
             pk3 = campo3 + "=" + pk3;
         
        if(!pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
            condicion2 = pk1 + " AND " + pk2 + " AND " + pk3;
        }
        if(pk1.equals("") && pk2.equals("") && pk3.equals("")){
            condicion2 = "";
        }
        if(pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
            condicion2 =  pk2 + " AND " + pk3;
        }
        if(!pk1.equals("") && pk2.equals("") && !pk3.equals("")){
            condicion2 = pk1 + " AND " + pk3;
        }
        if(!pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            condicion2 = pk1 + " AND " + pk2;
        }
        if(pk1.equals("") && pk2.equals("") && !pk3.equals("")){
            condicion2 = pk3;
        }
        if(pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            condicion2 = pk2;
        }
        if(!pk1.equals("") && pk2.equals("") && pk3.equals("")){
            condicion2 = pk1;
        }
            condicion = "DELETE FROM " + tabla + " WHERE " + condicion2;
            System.out.println(condicion);
            return(condicion);  
    }
     public DefaultTableModel ConsultarCliente(String tabla, String campo1, String campo2, String campo3, String pk1, String pk2, String pk3){
            
            return dato.ConsultaCliente(GenerarCondicionSelect(campo1,campo2,campo3,pk1,pk2,pk3));
        }
  
        public String GenerarCondicionSelect(String campo1, String campo2, String campo3, String pk1, String pk2, String pk3){
       
         String condicion2= "";
         if(pk1.equals(""))
             pk1="";
         else
             pk1 = "A."+campo1 + " LIKE '%" + pk1+"%'";
         if(pk2.equals(""))
             pk2="";
         else
             pk2 =  "A."+campo2 + " LIKE '%" + pk2+"%'";
         if(pk3.equals(""))
             pk3="";
         else
             pk3 = "A."+ campo3 + " Like '%" + pk3+"%'";
         
         
        if(!pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
          
            condicion2 = pk1 + " AND " + pk2 + " AND " + pk3 + " AND";
        }
       
        if(pk1.equals("") && !pk2.equals("") && !pk3.equals("")){
            
            condicion2 =  pk2 + " AND " + pk3+" AND";
        }
        if(!pk1.equals("") && pk2.equals("") && !pk3.equals("")){
           
            condicion2 = pk1 + " AND " + pk3+" AND";
        }
        if(!pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            
            condicion2 = pk1 + " AND " + pk2+" AND";
        }
        if(pk1.equals("") && pk2.equals("") && !pk3.equals("")){
           
            condicion2 = pk3+" AND";
        }
        if(pk1.equals("") && !pk2.equals("") && pk3.equals("")){
            
            condicion2 = pk2+" AND";
        }
        if(!pk1.equals("") && pk2.equals("") && pk3.equals("")){
           
            condicion2 = pk1+" AND";
        }
       
        if(pk1.equals("") && pk2.equals("") && pk3.equals("")){
            condicion2 = "";
           
        }
        System.out.println(condicion2);
        return(condicion2);  
     }
    
    //Funciones de Validacion:

      public void ValidarEntero(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if(((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo debe ingresar números.","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    
    public void ValidarDouble(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if(((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE) && (k !='.')){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo se puede ingresar números o .","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
  
    
    public void ValidarLetras(java.awt.event.KeyEvent evt){
        int k=(int)evt.getKeyChar();
            if ((k < 97 || k > 122) && (k<65 || k>90) && k!=20 && k!=8 && k!=32 && k!=127){
                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                JOptionPane.showMessageDialog(null,"Sólo debe ingresar letras","Error Datos",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public boolean ValidarCantidadDigitos(String s, int digitos){
        
        
        if(s.length()!=digitos){
            JOptionPane.showMessageDialog(null,"Cantidad de digitos invalida, Verifique e intente nuevamente"); 
            return false;
        }
        else
            return true;
           
    }
      public String ValidarMayusculas(String nombre){
     
        char[] modificado = nombre.toCharArray();
       
        modificado[0] = Character.toUpperCase(modificado[0]);
         
        for (int i=0; i<nombre.length()-2; i++){
            if (modificado[i] == ' '){
                  
                 modificado[i + 1] = Character.toUpperCase(modificado[i + 1]); 
            }
        }
        
        String retorno = new String(modificado);
        return retorno;
        
  }
  
    
    // OTRAS FUNCIONES :
    public double CalcularCostoReserva(Double costo){
        
        return costo;
    }
    
    public void GenerarReporteEstadisticas(){
        
    }
    
    public void ComprobarMesInventario(String codigoH){
        dato.ComprobarMesInventario(codigoH);
    }
    
    //Llama al proceso en Data que se encarga de restar la cantidad de cloro utilizada segun las piscinas
    public void LimpiezaPiscina1(){
        int capacidad;
        int valor;
        
        
        
    }
    
    public void LimpiezaPiscina2(){
        
    }
    public void PagoFacturaLimpieza(int codigo, String tipoPago, Date fechaPago){
        FacturaLimpieza fl = new FacturaLimpieza();
        fl.setCodigo(codigo);
        fl.setFechaPago(fechaPago);
        fl.setTipoPago(tipoPago);
        dato.PagoFactura(fl);
    }
    
    public void PagoOrdenCompra(int numero, Date fechaPago){
        OrdenCompra oc = new OrdenCompra();
        oc.setNumero(numero);
        oc.setFechaPago(fechaPago);
        dato.PagoOrdenCompra(oc);
    }
    
        
     public void GenerarReporte1(int codigoH, String nombreH){
         File ruta_destino =null;
         ruta_destino = Colocar_Destino(ruta_destino);
        
         DefaultTableModel modelo = dato.ConsultaInventarioProducto(codigoH);
          System.out.println(modelo.getDataVector());
         JTable jtabla = new JTable(modelo);
          
            try{ 
            PdfWriter writer = PdfWriter.getInstance(reporte1, new FileOutputStream(ruta_destino + ".pdf"));
            if(ruta_destino!=null){
                reporte1.open();          
            // LOGO
                Image foto = Image.getInstance("src/imagenes/Logoshiori.png");
                foto.scaleToFit(100, 100);
                foto.setAlignment(Chunk.ALIGN_LEFT);
                reporte1.add(foto);
            //LOGO
             //Titulo
                Paragraph titulo = (new Paragraph("Reporte: Inventario físico por producto. Complejo Hotelero.",
                FontFactory.getFont("arial",                        // fuente
				18,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));             // color
                reporte1.add(titulo);
            
            //Titulo
           
            //Cuerpo
                Paragraph parrafo = new Paragraph();
                parrafo.add(new Phrase("Nombre del hotel: "+nombreH));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Codigo del hotel: "+codigoH));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                reporte1.add(parrafo);
            //CUERPO
            //Tabla comparativa
             PdfPTable tablaPdf = ConvertirJTablePDF1(jtabla);
             parrafo.add(new Phrase(Chunk.NEWLINE));
             parrafo.add(new Phrase(Chunk.NEWLINE));
             reporte1.add(tablaPdf);
            //Tabla comparativa
             reporte1.close();
            
           
            }
            } catch(DocumentException | IOException e){
                 JOptionPane.showMessageDialog(null,"Fallo Generar reporte de inventario: "+ e); 
            }
           
            
           
        JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en la direccion: "+ruta_destino);
            AbrirPDF(ruta_destino);
    }
//Genera Reporte de la factura de Limpieza   
     public void GenerarReporte2(int codigoF, String fechaI, String fechaF,String fechaE, String nombreH, String nombreC, String tipoPago, String fechaPago,String costo){
         File ruta_destino =null;
         ruta_destino = Colocar_Destino(ruta_destino);
        
      
          
            try{ 
            PdfWriter writer = PdfWriter.getInstance(reporte1, new FileOutputStream(ruta_destino + ".pdf"));
            if(ruta_destino!=null){
                reporte1.open();          
            // LOGO
                Image foto = Image.getInstance("src/imagenes/Logoshiori.png");
                foto.scaleToFit(100, 100);
                foto.setAlignment(Chunk.ALIGN_LEFT);
                reporte1.add(foto);
            //LOGO
             //Titulo
                Paragraph titulo = (new Paragraph("N°de Factura: "+codigoF,
                FontFactory.getFont("arial",                        // fuente
    20,                            // tamaño
    Font.ITALIC,                   // estilo
    BaseColor.BLACK)));             // color
                reporte1.add(titulo);
            
            //Titulo
           
            //Cuerpo
                Paragraph parrafo = new Paragraph();
                parrafo.setFont(FontFactory.getFont("arial",12,Font.ITALIC,BaseColor.BLACK));
                parrafo.setLeading(0,2);
                parrafo.add(new Phrase("Hotel: "+nombreH));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Compañia: "+nombreC));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Periodo a facturar: "+fechaI+" - "+fechaF));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Fecha de Emisión: "+fechaE));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Tipo de Pago: "+tipoPago));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Fecha de PAgo: "+fechaPago));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                reporte1.add(parrafo);
            //CUERPO
            //Titulo
                titulo = (new Paragraph("Costo Total: "+costo+" Bs.",
                FontFactory.getFont("arial",                        // fuente
    15,                            // tamaño
    Font.ITALIC,                   // estilo
    BaseColor.BLACK)));             // color
                reporte1.add(titulo);
             reporte1.close();
            
           
            }
            } catch(DocumentException | IOException e){
                 JOptionPane.showMessageDialog(null,"Fallo Generar Factura de Limpieza: "+ e); 
            }
           
            
           
        JOptionPane.showMessageDialog(null, "Facctura generada exitosamente en la direccion: "+ruta_destino);
            AbrirPDF(ruta_destino);
    }
     
     
 public void GenerarReporte3(int numeroO, String fechaOrden, String cantidad,String fechaPago, String nombreC, String nombreH, String costo){
         File ruta_destino =null;
         ruta_destino = Colocar_Destino(ruta_destino);
        
      
          
            try{ 
            PdfWriter writer = PdfWriter.getInstance(reporte1, new FileOutputStream(ruta_destino + ".pdf"));
            if(ruta_destino!=null){
                reporte1.open();          
            // LOGO
                Image foto = Image.getInstance("src/imagenes/Logoshiori.png");
                foto.scaleToFit(100, 100);
                foto.setAlignment(Chunk.ALIGN_LEFT);
                reporte1.add(foto);
            //LOGO
             //Titulo
                Paragraph titulo = (new Paragraph("N°de Factura: "+numeroO,
                FontFactory.getFont("arial",                        // fuente
				20,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));             // color
                reporte1.add(titulo);
            
            //Titulo
           
            //Cuerpo
                Paragraph parrafo = new Paragraph();
                parrafo.setFont(FontFactory.getFont("arial",12,Font.ITALIC,BaseColor.BLACK));
                parrafo.setLeading(0,4);
                parrafo.add(new Phrase("Hotel: "+nombreH));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Proveedor: "+nombreC));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Fecha de Orden: "+fechaOrden));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                parrafo.add(new Phrase("Fecha de PAgo: "+fechaPago));
                parrafo.add(new Phrase(Chunk.NEWLINE));
                reporte1.add(parrafo);
            //CUERPO
            //Titulo
                titulo = (new Paragraph("Costo Total: "+costo+" Bs.",
                FontFactory.getFont("arial",                        // fuente
				15,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));             // color
                reporte1.add(titulo);
             reporte1.close();
            
           
            }
            } catch(DocumentException | IOException e){
                 JOptionPane.showMessageDialog(null,"Fallo Generar Factura de Limpieza: "+ e); 
            }
           
            
           
        JOptionPane.showMessageDialog(null, "Orden de compra generada exitosamente en la direccion: "+ruta_destino);
            AbrirPDF(ruta_destino);
    }
     
     
      public File Colocar_Destino(File ruta_destino) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
        if(result ==JFileChooser.CANCEL_OPTION)
            ruta_destino = null;
        return ruta_destino;
    }
      
       public void AbrirPDF(File ruta_destino){
        try {
            File path = new File(ruta_destino + ".pdf");
            Desktop.getDesktop().open(path);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       
       
    public  PdfPTable ConvertirJTablePDF1 (JTable tabla){
        
         PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
         PdfPCell celda = new PdfPCell( new Phrase("Codigo de Producto")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Nombre")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Cantidad Teorica")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Cantidad Fisica")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
        for(int i=0;i<tabla.getRowCount();i++){
            
          
        
                for(int j=0;j<tabla.getColumnCount();j++){
                   
                    celda = new PdfPCell( new Phrase((tabla.getValueAt(i, j).toString()))) ;
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaPdf.addCell(celda);  
                }
        }
             
         
         
         return tablaPdf;
     }
    
     public  PdfPTable ConvertirJTablePDF2 (JTable tabla){
        
         PdfPTable tablaPdf = new PdfPTable(tabla.getColumnCount());
         PdfPCell celda = new PdfPCell( new Phrase("Codigo de Producto")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Nombre")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Cantidad Teorica")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
         celda = new PdfPCell( new Phrase("Cantidad Fisica")) ;
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setBackgroundColor(BaseColor.GRAY);
         tablaPdf.addCell(celda);
         
        for(int i=0;i<tabla.getRowCount();i++){
            
          
        
                for(int j=0;j<tabla.getColumnCount();j++){
                   
                    celda = new PdfPCell( new Phrase((tabla.getValueAt(i, j).toString()))) ;
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaPdf.addCell(celda);  
                }
        }
             
         
         
         return tablaPdf;
     }
    
    public ArrayList ObtenerLista(DefaultTableModel modelo, int columna){
        int filas = modelo.getRowCount();
        ArrayList<String> lista;
        lista = new ArrayList();
        for (int i=0;i<filas;i++){
            lista.add(modelo.getValueAt(i, columna).toString());
        }
        return (lista);
    }
    
    
    public DefaultTableModel RevisarPagoFactura(String codigoH){
        
        return dato.RevisarPagoFactura(codigoH);
    }
     
   public DefaultTableModel RevisarPagoOren(String codigoH){
       return dato.RevisarPagoOrden(codigoH);
   }
    //Funciones CRUD: 
    public void InsertarLugar(int codigo, String descripcion, String tipo, int codigo1){
        
        Lugar l = new Lugar(codigo,descripcion,tipo,codigo1);
        dato.InsertarLugar(l);
                
    }
    
    public void ModificarLugar(int codigo, String descripcion, String tipo, int codigo1){
        Lugar l = new Lugar (codigo,descripcion,tipo,codigo1);
        dato.ModificarLugar(l);
                
    }
    
    public DefaultTableModel ConsultarGeneral(String s){
        DefaultTableModel modelo = dato.ConsultarGeneral(s);
        return modelo;
    }
    
    public String ConsultaPrimaria(String campoP, String tabla, String campo, String valor){
        return dato.ConsultaPrimaria(campoP,tabla,campo,valor);
    }
    
    public void EliminarGeneral(String s){
        dato.EliminarGeneral(s); 
    }
    
    public DefaultTableModel ConsultaInventarioProducto(int codigoH){
        return dato.ConsultaInventarioProducto(codigoH);
    }
    
    public void InsertarHotel(int codigo, String nombre, String categoria, String tipoServicio, String calle, String edificio, String urbanizacion,String ciG, int codigoL){
        Hotel h = new Hotel(codigo,nombre,categoria,tipoServicio,calle,edificio,urbanizacion, ciG,codigoL);
        if(!h.getCategoria().equals("***") && !h.getCategoria().equals("****") && !h.getCategoria().equals("*****"))
            JOptionPane.showMessageDialog(null,"Categoria invalida, intente nuevamente"); 
        else
            dato.InsertarHotel(h);
    }
    
    public void ModificarHotel(int codigo, String nombre, String categoria, String tipoServicio, String calle, String edificio, String urbanizacion,String ciG, int codigoL){
        Hotel h = new Hotel(codigo,nombre,categoria,tipoServicio,calle,edificio,urbanizacion, ciG,codigoL);
        if(!h.getCategoria().equals("***") && !h.getCategoria().equals("****") && !h.getCategoria().equals("*****"))
            JOptionPane.showMessageDialog(null,"Categoria invalida, intente nuevamente"); 
        else
        dato.ModificarHotel(h);
    }
    
    public void InsertarPersonal(String ci,String nombre, String apellido, String calle, String edificio, String urbanizacion, char sexo, Date fechaNac, Date fechaInicio, String cargo, String nivelEstudio, int codigoH, int codigoL, String ciSupervisor){
        Personal p = new Personal(ci,nombre,apellido,calle,edificio,urbanizacion,sexo,fechaNac,fechaInicio,cargo,nivelEstudio,codigoH,codigoL,false,ciSupervisor);
        if((p.getSexo()!='M'&& p.getSexo()!='F')){
             JOptionPane.showMessageDialog(null,"Sexo Invalido, Intente nuevamente "); 
        }
        else if(!p.getCargo().equals("Administrador") && !p.getCargo().equals("Gerente") && !p.getCargo().equals("Encargado") && !p.getCargo().equals("Supervisor") && !p.getCargo().equals("Supervisor de Limpieza") && !p.getCargo().equals("Piscinero")){
             JOptionPane.showMessageDialog(null,"Cargo invalido, intente nuevamente"); 
        }
        else
            dato.InsertarPersonal(p);
        
    }
    
    public void ModificarPersonal(String ci,String nombre, String apellido, String calle, String edificio, String urbanizacion, char sexo, Date fechaNac, Date fechaInicio, String cargo, String nivelEstudio, int codigoH, int codigoL,boolean despedido, String ciSupervisor){
        Personal p = new Personal(ci,nombre,apellido,calle,edificio,urbanizacion,sexo,fechaNac,fechaInicio,cargo,nivelEstudio,codigoH,codigoL,despedido,ciSupervisor);
        if((p.getSexo()!='M'&& p.getSexo()!='F')){
             JOptionPane.showMessageDialog(null,"Sexo Invalido, Intente nuevamente "); 
        }
        else if(!p.getCargo().equals("Administrador") && !p.getCargo().equals("Gerente") && !p.getCargo().equals("Encargado") && !p.getCargo().equals("Supervisor") && !p.getCargo().equals("Supervisor de Limpieza") && !p.getCargo().equals("Piscinero")){
             JOptionPane.showMessageDialog(null,"Cargo invalido, intente nuevamente"); 
        }
        else
            dato.ModificarPersonal(p);
    }
    
    public void InsertarCompañia(String rif, String nombre, String calle, String urbanizacion, String edificio, String telefono, String tipoCompañia, int codigoL){
        Compañia c = new Compañia(rif,nombre,calle,urbanizacion,edificio,telefono,tipoCompañia,codigoL);
        if(!c.getTipoCompañia().equals("Limpieza")&& !c.getTipoCompañia().equals("Proveedor")){
             JOptionPane.showMessageDialog(null,"Tipo de Compañia invalido, intente nuevamente"); 
        }
        else
            dato.InsertarCompañia(c);
    }
    public void ModificarCompañia(String rif, String nombre, String calle, String urbanizacion, String edificio, String telefono, String tipoCompañia, int codigoL){
        Compañia c = new Compañia(rif,nombre,calle,urbanizacion,edificio,telefono,tipoCompañia,codigoL);
        if(!c.getTipoCompañia().equals("Limpieza")&& !c.getTipoCompañia().equals("Proveedor")){
             JOptionPane.showMessageDialog(null,"Tipo de Compañia invalido, intente nuevamente"); 
        }
        else
            dato.ModificarCompañia(c);
    }
     
   
    public void InsertarTrabajoLimpieza(int codigo, String descripcion){
        TrabajoLimpieza tl = new TrabajoLimpieza(codigo,descripcion);
        dato.InsertarTrabajoLimpieza(tl);
    }
     
    public void ModificarTrabajoLimpieza(int codigo, String descripcion){
        TrabajoLimpieza tl = new TrabajoLimpieza(codigo,descripcion);
        dato.ModificarTrabajoLimpieza(tl);
    }
    
    public void InsertarTrabajoCompañia(String rif, int codigoTL, double costo){
        TrabajoCompañia tc = new TrabajoCompañia(codigoTL,rif,costo);
        dato.InsertarTrabajoCompañia(tc);
    }
    
    public void ModificarTrabajoCompañia(String rif, int codigoTL, double costo){
        TrabajoCompañia tc = new TrabajoCompañia(codigoTL,rif,costo);
        dato.ModificarTrabajoCompañia(tc);
    }
    
    public void InsertarFacturaTrabajosLimpieza(int codigo, Date fechaInicio, Date fechaFinal, Date fechaEmision, int codigoH, String rif){
        
        FacturaLimpieza fl = new FacturaLimpieza(codigo, fechaInicio, fechaFinal, fechaEmision, null,null, codigoH, rif);
//        if(!fl.getTipoPago().equals("Credito")&&!fl.getTipoPago().equals("Cheque")){
//            JOptionPane.showMessageDialog(null,"Tipo de Pago invalido, intente nuevamente");  
//        } 
        dato.InsertarFacturaTrabajosLimpieza(fl);
    }
    
    public void ModificarFacturaTrabajosLimpieza(int codigo, Date fechaInicio, Date fechaFinal, Date fechaEmision, String tipoPago, Date fechaPago, int codigoH, String rif){
        FacturaLimpieza fl = new FacturaLimpieza(codigo, fechaInicio, fechaFinal, fechaEmision, tipoPago,fechaPago, codigoH, rif);
        if(!fl.getTipoPago().equals("Credito")&&!fl.getTipoPago().equals("Cheque")){
            JOptionPane.showMessageDialog(null,"Tipo de Pago invalido, intente nuevamente");  
        } 
        dato.ModificarFacturaTrabajosLimpieza(fl);
    }
    
  
    public void InsertarDetalleFactura(int codigoFL, int codigoTL, double costo){
        DetalleFactura d = new DetalleFactura(codigoFL,codigoTL,costo);
        dato.InsertarDetalleFactura(d);
    }
    
    public void InsertarDetalleOrdenCompra(int numero, int codigo, int cantidad, double costo){
        DetalleOrdenCompra d = new DetalleOrdenCompra(numero,codigo,cantidad,costo*cantidad);
        dato.InsertarDetalleOrdenCompra(d);
    }
    public void ModificarDetalleFactura(int codigoFL, int codigoTL, double costo){
         DetalleFactura d = new DetalleFactura(codigoFL,codigoTL,costo);
         dato.ModificarDetalleFactura(d);
    }
    
    public void InsertarProducto(int codigo, String nombre, int cantidadMin, int cantidadT, int cantidadF, Date fechaInventario, int codigoH){
        ProductoImplemento p = new ProductoImplemento(codigo,nombre,cantidadMin,cantidadT,cantidadF,fechaInventario,codigoH);
        dato.InsertarProducto(p);
    }
    
    public void ModificarProducto(int codigo, String nombre, int cantidadMin, int cantidadT, int cantidadF, Date fechaInventario, int codigoH){
        ProductoImplemento p = new ProductoImplemento(codigo,nombre,cantidadMin,cantidadT,cantidadF,fechaInventario,codigoH);
        dato.ModificarProducto(p);
    }
    
    public void RegistrarInventario(String codigoH, String cantidadF, Date fecha, String codigoP){
        dato.RegistrarInventario(codigoH, cantidadF, fecha, codigoP);
    }
        
    public void InsertarAjuste(Date fecha, int cantidad, String tipo, int codigoP){
        Ajuste a = new Ajuste(fecha, cantidad, tipo , codigoP);
        dato.InsertarAjuste(a);
        
    }
    
    public void ModificarAjuste(Date fecha, int cantidad, String tipo, int codigoP){
        Ajuste a = new Ajuste(fecha, cantidad, tipo , codigoP);
        dato.ModificarAjuste(a);    
    }
    
    public void InsertarOrdenCompra(int numero, Date fechaOrden, Date fechaPago, String rif, int codigoH){
        OrdenCompra oc = new OrdenCompra(numero,fechaOrden,fechaPago,rif,codigoH);
        dato.InsertarOrdenCompra(oc);
        
    }
    
    public void ModificarOrdenCompra(int numero, Date fechaOrden, int cantidad, Date fechaPago, String rif, int codigoH){
        OrdenCompra oc = new OrdenCompra(numero,fechaOrden,fechaPago,rif,codigoH);
        dato.ModificarOrdenCompra(oc);
    }
    
    public void InsertarCliente(int añoIngreso,int consecutivo,String ciPasaporte, String nombre, String apellido, String tlfLocal, String tlfCelular, String tlfOficina, Date fechaNac, String nacionalidad, char sexo, String profesion, String informacion, int codigoL, int codigoLu, int codigoH, String calle, String edificio, String urbanizacion){
        Cliente c = new Cliente(añoIngreso, consecutivo,ciPasaporte,nombre,apellido,tlfLocal,tlfCelular,tlfOficina,fechaNac,nacionalidad,sexo,profesion,informacion,codigoL,codigoLu,codigoH,calle,edificio,urbanizacion);
        dato.InsertarCliente(c);
    }
      public void ModificarCliente(int consecutivo, int añoIngreso,String ciPasaporte, String nombre, String apellido, String tlfLocal, String tlfCelular, String tlfOficina, Date fechaNac, String nacionalidad, char sexo, String profesion, String informacion, int codigoL, int codigoLu, int codigoH, String calle, String edificio, String urbanizacion){
        Cliente c = new Cliente(consecutivo,añoIngreso,ciPasaporte,nombre,apellido,tlfLocal,tlfCelular,tlfOficina,fechaNac,nacionalidad,sexo,profesion,informacion,codigoL,codigoLu,codigoH,calle,edificio,urbanizacion);
        dato.ModificarCliente(c);
    }
    
    public void InsertarAcompañante(String ci, String nombre, String apellido, Date fechaNac, String parentesco){
        Acompañante a = new Acompañante(ci,nombre,apellido,fechaNac,parentesco);
        dato.InsertarAcompañante(a);
    }
     public void ModificarAcompañante(String ci, String nombre, String apellido, Date fechaNac, String parentesco){
        Acompañante a = new Acompañante(ci,nombre,apellido,fechaNac,parentesco);
        dato.ModificarAcompañante(a);
    }
    
    public void InsertarPP(int codigoP, String rif){
        PP pp = new PP(codigoP,rif);
        dato.InsertarPP(pp);
        
    }

    public void InsertarExperiencia(String compañia, String cargo, Date fechaI, Date fechaF, String ci){
        Experiencia exp = new Experiencia(compañia,cargo,fechaI,fechaF,ci);
        dato.InsertarExperiencia(exp);
    }
    
    public void InsertarLenguaje(String idioma, String ci){
        Lenguaje l = new Lenguaje(idioma,ci);
        dato.InsertarLenguaje(l);
        
    }
    
    public void InsertarAmonestacion(int numero, Date fecha, String razon, String ci){
        Amonestacion a = new Amonestacion(numero,fecha,razon,ci);
        dato.InsertarAmonestacion(a);
    }
    
    public void InsertarHorario(String diaS, String hora, String ci){
        Horario h = new Horario(diaS,hora,ci);
        dato.InsertarHorario(h);
    }
    public void InsertarComodidad(int codigo, String nombre){
        Comodidad c = new Comodidad(codigo,nombre);
        dato.InsertarComodidad(c);
    }
    
    public void InsertarHabitacion(int cantidad, String tipo, int codigoH){
        Habitacion h;
        for (int i = 0; i < cantidad;i++) {
            h = new Habitacion(0,tipo,true,codigoH);
            dato.InsertarHabitacion(h);
            
        }
        JOptionPane.showMessageDialog(null,"Habitaciones insertadas correctamente en el hotel señalado");
    }
    public void InsertarHC(int numero, int codigoC, int codigoH){
        HC h = new HC(numero,codigoC,codigoH);
        dato.InsertarHC(h);
    }
    public void ModificarComodidad(int codigo, String nombre){
        Comodidad c = new Comodidad(codigo,nombre);
        dato.ModificarComodidad(c);
   }   
    
   public void ModificarHabitacion(int numero,String tipo, boolean disponible, int codigoH){
        Habitacion h = new Habitacion(numero,tipo,disponible,codigoH);
        dato.ModificarHabitacion(h);
    }
    
   
 
       public DefaultTableModel ConsultaOrdenCompra(String condicion){
      return dato.ConsultaOrdenCompra(condicion);
    }
       
 public DefaultTableModel ConsultaHotel(String condicion){
      return dato.ConsultaHotel(condicion);
  }
   public DefaultTableModel ConsultaFacturaLimpieza(String condicion){
      return dato.ConsultaFacturaLimpieza(condicion);
   }
   public DefaultTableModel ConsultaProducto(String condicion){
      return dato.ConsultaProducto(condicion);
    }
    public DefaultTableModel ConsultaTrabajoCompañia(String condicion){
      return dato.ConsultaTrabajoCompañia(condicion);
    }
     public DefaultTableModel ConsultaCliente(String condicion){
      return dato.ConsultaCliente(condicion);
    }
    public DefaultTableModel ConsultaPersonal(String condicion){
      return dato.ConsultaPersonal(condicion);
    }
    
    public DefaultTableModel ConsultaCompañiaLimpieza(String condicion){
      return dato.ConsultaCompañiaLimpieza(condicion);
    }
    
   public DefaultTableModel ConsultaProveedor(String condicion){
      return dato.ConsultaProveedor(condicion);
   }
   public DefaultTableModel ConsultaAjuste(String condicion, String hotel){
      return dato.ConsultaAjuste(condicion,hotel);
   }
    public DefaultTableModel ConsultaAcompañante(String condicion){
      return dato.ConsultaAcompañante(condicion);
   }
    public DefaultTableModel ConsultaExperiencia(String condicion, String ciGerente){
      return dato.ConsultaExperiencia(condicion,ciGerente);
   }
   
   public DefaultTableModel ConsultaLenguaje(String condicion, String ciGerente){
      return dato.ConsultaLenguaje(condicion,ciGerente);
   }
  
   
   public DefaultTableModel ConsultaAmonestacion(String condicion, String ciGerente){
       return dato.ConsultaAmonestacion(condicion,ciGerente);
   }
  
    
public DefaultTableModel ConsultaHorario(String condicion, String CI){
       return dato.ConsultaHorario(condicion,CI);
}
public DefaultTableModel ConsultaPP(String condicion){
    return dato.ConsultaPP(condicion);
}
    
public DefaultTableModel ConsultaHabitacion(String condicion, String hotel){
    return dato.ConsultaHabitacion(condicion,hotel);
}
 public DefaultTableModel ConsultaHC(String condicion, String hotel){
     return dato.ConsultaHC(condicion,hotel);
 }
  public DefaultTableModel ConsultaDetalleOrdenCompra(String condicion, String hotel){
      return dato.ConsultaDetalleOrdenCompra(condicion,hotel);
  }
  public boolean ValidarExistencia(String pk, String campo, String tabla){
    return dato.validarExistencia(pk, campo, tabla);
}
    public DefaultTableModel ConsultaDetalleFactura(String condicion, String hotel){
      return dato.ConsultaDetalleFactura(condicion, hotel);
  }
    
    
}
    
    
    
    
    

 