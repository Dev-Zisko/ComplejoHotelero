/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Dominio.*;
import java.sql.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Christian D
 */
public class Data {

    Conexion conex = new Conexion();
    //Constructor
    public Data() {
    }
    
    //Metodos:
    
    public void InsertarLugar(Lugar objeto) {
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm;
        if(objeto.codigo1==0)
             stm = con.prepareStatement("INSERT INTO Lugar_7 VALUES ("+objeto.getCodigo()+",'"+objeto.getDescripcion()+"','"+objeto.getTipo()+"',NULL)");
        else
             stm = con.prepareStatement("INSERT INTO Lugar_7 VALUES ("+objeto.getCodigo()+",'"+objeto.getDescripcion()+"','"+objeto.getTipo()+"',"+objeto.getCodigo1()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarLugar"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Insert Lugar "+ e); 
        }
        
    }
    
    public void ModificarLugar(Lugar objeto){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Lugar_7 set Codigo="+objeto.getCodigo()+",Descripcion='"+objeto.getDescripcion()+"',Tipo='"+objeto.getTipo()+"',Codigo1="+objeto.getCodigo1()+" where Codigo="+objeto.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Lugar"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Lugar "+ e); 
        }
    }
    
    //Consula para la mayoria de las tablas por 3 campos menos las M:N
    public DefaultTableModel ConsultarGeneral(String condicion){ 
        DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement(condicion);
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
            System.out.println(modelo.getDataVector());
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar General: "+e); 
             return null;
        }  
    }

    
    public void InsertarHotel(Hotel objeto){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Hotel_7 VALUES ("+objeto.getCodigo()+",'"+objeto.getNombre()+"','"+objeto.getCategoria()+"','"+objeto.getTipoServicio()+"','"+objeto.getCalle()+"','"+objeto.getEdificio()+"','"+objeto.getUrbanizacion()+"',"+objeto.getCiG()+","+objeto.getCodigoL()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Hotel"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Hotel:  "+ e); 
        }
    }
    
    public void ModificarHotel(Hotel objeto){
       
       try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Hotel_7 set Nombre='"+objeto.getNombre()+"',Categoria='"+objeto.getCategoria()+"',Tipo_Servicio='"+objeto.getTipoServicio()+"',Calle='"+objeto.getCalle()+"',Edificio='"+objeto.getEdificio()+"',Urbanizacion='"+objeto.getUrbanizacion()+"',CI_Gerente='"+objeto.getCiG()+"',CodigoL="+objeto.getCodigoL()+" Where Codigo="+objeto.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Hotel"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Hotel:  "+ e); 
        }
   } 
    
    
    public void InsertarPersonal(Personal objeto){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Personal_7 VALUES ('"+objeto.getCi()+"','"+objeto.getNombre()+"','"+objeto.getApellido()+"','"+objeto.getCalle()+"','"+objeto.getEdificio()+"','"+objeto.getUrbanizacion()+"','"+objeto.getSexo()+"','"+objeto.getFechaNac()+"','"+objeto.getFechaInicio()+"','"+objeto.getCargo()+"',"+objeto.getNivelEstudio()+","+objeto.getCodigoH()+","+objeto.getCodigoL()+","+objeto.isDespedido()+","+objeto.getCiSupervisor()+")");

       stm.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Personal"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Personal:  "+ e); 
        }
        
        
    }
    
    public void ModificarPersonal(Personal objeto){ //Cuando se modifica cargo, multievalados deben borrarse
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Personal_7 set Nombre='"+objeto.getNombre()+"',Apellido='"+objeto.getApellido()+"',Calle='"+objeto.getCalle()+"',Edificio='"+objeto.getEdificio()+"',Urbanizacion='"+objeto.getUrbanizacion()+"',Sexo='"+objeto.getSexo()+"',Cargo='"+objeto.getCargo()+"',Nivel_Estudio="+objeto.getNivelEstudio()+",CodigoH="+objeto.getCodigoH()+",CodigoL="+objeto.getCodigoL()+",CI_Supervisor="+objeto.getCiSupervisor()+", Despedido="+objeto.isDespedido()+" Where CI='"+objeto.getCi()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Personal"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Personal:  "+ e); 
        }
    }
    
    public void InsertarExperiencia(Experiencia obj){
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Experiencia_7 VALUES ('"+obj.getNombreCompañia()+"','"+obj.getCargo()+"','"+obj.getFechaInicio()+"','"+obj.getFechaFin()+"','"+obj.getCi()+"')");
       stm.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Experiencia"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Experiencia:  "+ e); 
        }
    }
    
   /* public void ModificarExperiencia(Experiencia obj){ PREGUNTAR CLAVE PRIMARIA
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Experiencia_7 set Compañia='"+obj.getNombreCompañia()+"',Cargo='"+obj.getCargo()+"',Fecha_Inicio='"+obj.getFechaInicio()+"',Fecha_Final'"+obj.getFechaFin()+"',CI='"+obj.getCi()+"' where ");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Personal"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Personal:  "+ e); 
        }
    }*/
    
    public void InsertarLenguaje(Lenguaje obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Lenguaje_7 VALUES ('"+obj.getIdioma()+"','"+obj.getCi()+"')");
       stm.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Lenguaje"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Lenguaje:  "+ e); 
        }
    }
    
    public void ModificarLenguaje(){ //Preguntar Primaria Modificar?
        
    }
    
    public void InsertarAmonestacion(Amonestacion obj){
        try{
            int count =0;
            Connection con = conex.getConnection();
            PreparedStatement stm ;
            ResultSet set;
           
            stm = con.prepareStatement("Select MAX(numero) from Amonestacion_7 where CI='"+obj.getCi()+"'"); //Seleccona la cantidad maxima de amonestacion para un piscinero
            set = stm.executeQuery();
            
            if(set.next()){
                count = set.getInt(1)+1; //Maximo +1 por piscinero
            }
                
            if(count<=3){
                stm = con.prepareStatement("INSERT INTO Amonestacion_7 (Numero,Fecha, Razon,CI) VALUES ("+count+",'"+obj.getFecha()+"','"+obj.getRazon()+"','"+obj.getCi()+"')");
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Amonestacion"); 
                
                if(count==3){
                    stm = con.prepareStatement("Update Personal_7 set Despedido = True where CI='"+obj.getCi()+"'"); //Update de Personal Despedido
                    stm.executeUpdate();
                   
                    JOptionPane.showMessageDialog(null,"El Piscinero indicado tiene 3 amonestaciones. Será despedido!! ");
                }
            }
            else
                 JOptionPane.showMessageDialog(null,"El Piscinero indicado YA habia sido despedido. ");
            
         
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Amonestacion:  "+ e); 
        }
        
        
    }
    
    public void ModificarAmonestacion(Amonestacion obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Amonestacion_7 set Fecha='"+obj.getFecha()+"',Razon='"+obj.getRazon()+"' where Numero='"+obj.getNumero()+"' AND CI='"+obj.getCi()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Amonestacion"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Amonestacion:  "+ e); 
        }
    }
    
    public void InsertarHorario(Horario obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Horario_7 VALUES ('"+obj.getDiaSemana()+"','"+obj.getHora()+"','"+obj.getCi()+"')");
        stm.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Horario"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Horario:  "+ e); 
        }
         //Pendiente si >7 entonces no se pueden introducir mas dias.
    }
    
    public void ModificarHorario(Horario obj){
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Horario_7 set Hora='"+obj.getHora()+" where Dia_Semana='"+obj.getDiaSemana()+"' AND CI='"+obj.getCi());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Horario"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Horario:  "+ e); 
        }
    }
    
    
    
    
    
    
    
    
    
    public void InsertarCompañia(Compañia objeto){ //Limpieza y proveedor
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Compañia_7 VALUES ('"+objeto.getRif()+"','"+objeto.getNombre()+"','"+objeto.getCalle()+"','"+objeto.getUrbanizacion()+"','"+objeto.getEdificio()+"','"+objeto.getTelefono()+"','"+objeto.getTipoCompañia()+"',"+objeto.getCodigoL()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Compañia"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Compañia:  "+ e); 
        }       
    }
    
     public void ModificarCompañia(Compañia objeto){
           try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Compañia_7 set Nombre='"+objeto.getNombre()+"',Calle='"+objeto.getCalle()+"',Urbanizacion='"+objeto.getUrbanizacion()+"',Edificio='"+objeto.getEdificio()+"',Telefono='"+objeto.getTelefono()+"',CodigoL="+objeto.getCodigoL()+" Where RIF='"+objeto.getRif()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Compañia"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Compañia:  "+ e); 
        }
     }
     
     public void InsertarTrabajoLimpieza(TrabajoLimpieza objeto){
     
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Trabajo_Limpieza_7 VALUES ("+objeto.getCodigo()+",'"+objeto.getDescripcion()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa : Insertar TrabajoLimpieza"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert TrabajoLimpieza:  "+ e); 
        }       
    }
     
     public void ModificarTrabajoLimpieza(TrabajoLimpieza objeto){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Trabajo_Limpieza_7 set Descripcion='"+objeto.getDescripcion()+"' Where Codigo="+objeto.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar TrabajoLimpieza"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update TrabajoLimpieza:  "+ e); 
        }        
    }
     
    public void InsertarTrabajoCompañia(TrabajoCompañia objeto){
           try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Trabajo_Compañia_7 VALUES ("+objeto.getCodigoTL()+",'"+objeto.getRif()+"',"+objeto.getCosto()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar TrabajoCompañia"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert trabajoCompañia:  "+ e); 
        }     
    }
    
    public void ModificarTrabajoCompañia(TrabajoCompañia obj){
          try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Trabajo_Compañia_7 set Costo="+obj.getCosto()+" where CodigoTL="+obj.getCodigoTL()+" AND RIF='"+obj.getRif()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar TrabajoLimpieza"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update TrabajoLimpieza:  "+ e); 
        }        
    }
    public void InsertarFacturaTrabajosLimpieza(FacturaLimpieza objeto){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Factura_Limpieza_7 VALUES ("+objeto.getCodigo()+",'"+objeto.getFechaInicio()+"','"+objeto.getFechaFinal()+"',CURDATE(),"+objeto.getCodigoH()+",'"+objeto.getRif()+"',null,null)");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarFactura"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert FacturaLimpieza:  "+ e); 
        }     
    }
    
    public void ModificarFacturaTrabajosLimpieza(FacturaLimpieza objeto){
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Factura_Limpieza_7 set Fecha_Inicio='"+objeto.getFechaInicio()+"',Fecha_Final='"+objeto.getFechaFinal()+"',Fecha_Emision='"+objeto.getFechaEmision()+"',CodigoH="+objeto.getCodigoH()+",RIF='"+objeto.getRif()+"' where Codigo="+objeto.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Factura"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Factura:  "+ e); 
        } 
    }
    
    
    public void InsertarDetalleFactura(DetalleFactura obj){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Detalle_Factura_7 VALUES ("+obj.getCodigoFL()+","+obj.getCodigoTL()+","+obj.getCosto()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarFactura"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Detalle FacturaLimpieza:  "+ e); 
        }     
    }
    
    public void ModificarDetalleFactura(DetalleFactura obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Detalle_Factura_7 set Costo="+obj.getCosto()+" where CodigoFL="+obj.getCodigoFL()+" AND CodigoTL="+obj.getCodigoTL());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Detalle Factura"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Factura:  "+ e); 
        } 
    }
    
    
    
    public void InsertarProducto(ProductoImplemento obj){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO Producto_Implemento_7 VALUES ("+obj.getCodigo()+",'"+obj.getNombre()+"',"+obj.getCantidadMin()+","+obj.getCantidadT()+","+obj.getCantidadF()+",null,"+obj.getCodigoH()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarProducto"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Producto:  "+ e); 
        }     
    }
    
    public void ModificarProducto(ProductoImplemento obj){
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Producto_Implemento_7 set Nombre='"+obj.getNombre()+"', Cantidad_Minima="+obj.getCantidadMin()+",Cantidad_Teorica="+obj.getCantidadT()+",CodigoH="+obj.getCodigoH()+" where Codigo="+obj.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Producto"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Producto:  "+ e); 
        } 
    }
    
    public void RegistrarInventario(String codigoH ,String cantidadF, Date fecha, String codigoP){
          try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Producto_Implemento_7 set Cantidad_Fisica="+cantidadF+",Fecha_Inventario='"+fecha+"' where CodigoH="+codigoH+" and Codigo="+codigoP);
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Registro Inventario"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Registro Inventario:  "+ e); 
        } 
    }
    
    public void InsertarPP(PP obj){
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO PP_7 VALUES ("+obj.getCodigoP()+",'"+obj.getRif()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarProducto"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Producto:  "+ e); 
        }     
    }
    
    public void InsertarAjuste(Ajuste obj){
        PreparedStatement stm; 
        Connection con = conex.getConnection();
        int count=0;
        try{
             
             
            stm = con.prepareStatement("Select Cantidad_Teorica from Producto_Implemento_7 where Codigo="+obj.getCodigoP());
            ResultSet set = stm.executeQuery();
            if(set.next()){
            count = set.getInt(1); 
            }
            
        
           // Nota: En Logica, al crear el obj se coloca la fecha del sistema y cantidad será el registro de cantidad fisica.
            if((obj.getCantidad() - count) < 0)
                obj.setTipo("Faltante");
            else
                obj.setTipo("Sobrante");
                
            
            
           
            stm = con.prepareStatement("INSERT INTO Ajuste_7 VALUES (CURDATE(),"+obj.getCantidad()+",'"+obj.getTipo()+"',"+obj.getCodigoP()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: InsertarAjuste"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Ajuste:  "+ e); 
        }  
    }
    
    public void ModificarAjuste(Ajuste obj){
          try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Ajuste_7 set Cantidad="+obj.getCantidad()+",Tipo='"+obj.getTipo()+"' where Fecha='"+obj.getFecha()+"' And CodigoP="+obj.getCodigoP());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Ajuste"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Ajuste:  "+ e); 
        } 
    }
    
    public void InsertarOrdenCompra (OrdenCompra obj){
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Orden_Compra_7 (Fecha_Orden,Fecha_Pago,RIF,CodigoH) Values(CURDATE(),null,'"+obj.getRif()+"',"+obj.getCodigoH()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar OrdenCompra"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Orden Compra:  "+ e); 
        }  
    }
    
    public void ModificarOrdenCompra(OrdenCompra obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Orden_Compra_7 set Fecha_Orden='"+obj.getFechaOrden()+"',Fecha_Pago='"+obj.getFechaPago()+"',RIF='"+obj.getRif()+"',CodigoH="+obj.getCodigoH()+" where Numero="+obj.getNumero());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar OrdenCompra"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update OrdenCompra:  "+ e); 
        } 
    }
    
    public void InsertarDetalleOrdenCompra(DetalleOrdenCompra obj){
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Detalle_Orden_Compra_7 Values("+obj.getNumero()+","+obj.getCodigo()+","+obj.getCantidad()+","+obj.getCosto()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Detalle Orden Compra"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Detalle Orden Compra:  "+ e); 
        }  
    }
    
    public void ModificarDetalleOrdenCompra(DetalleOrdenCompra obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Detalle_Orden_Compra_7 set Costo="+obj.getCosto()+" where Numero="+obj.getNumero()+" AND Codigo="+obj.getCodigo());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Detalle OrdenCompra"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Detalle Orden Compra:  "+ e); 
        } 
    }
    public void InsertarCliente(Cliente obj){
          PreparedStatement stm;
          int count = 0 ;
        try{
            Connection con = conex.getConnection();
            
            stm = con.prepareStatement("Select MAX(Consecutivo) from Cliente_7 where Año_Ingreso="+obj.getAñoIngreso()); //Seleccona la cantidad maxima de consecutivo para un Cliente
            ResultSet set = stm.executeQuery();
            
            if(set.next()){
                count = set.getInt(1)+1; //Maximo +1 por piscinero
            }
            
                System.out.println(count);
                stm = con.prepareStatement("Insert  INTO Cliente_7(Año_Ingreso,Consecutivo,CI_Pasaporte,Nombre,Apellido,Telefono_Local,Telefono_Celular,Telefono_Oficina,Fecha_Nacimiento,Nacionalidad,Sexo,Profesion,Informacion_General,CodigoL,CodigoLu,CodigoH,Calle,Edificio,Urbanizacion) Values("+obj.getAñoIngreso()+","+count+",'"+obj.getCiPasaporte()+"','"+obj.getNombre()+"','"+obj.getApellido()+"','"+obj.getTelefonoLocal()+"','"+obj.getTelefonoCelular()+"','"+obj.getTelefonoOficina()+"','"+obj.getFechaNac()+"','"+obj.getNacionalidad()+"','"+obj.getSexo()+"','"+obj.getProfesion()+"','"+obj.getInformacionGeneral()+"',"+obj.getCodigoL()+","+obj.getCodigoLu()+","+obj.getCodigoH()+",'"+obj.getCalle()+"','"+obj.getEdificio()+"','"+obj.getUrbanizacion()+"')");
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Cliente");
                conex.dropConnection();
            
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Cliente:  "+ e); 
        }  
    }
    
    public void ModificarCliente(Cliente obj){
        try{
      Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Cliente_7 set Nombre='"+obj.getNombre()+"',Apellido='"+obj.getApellido()+"',Telefono_Local='"+obj.getTelefonoLocal()+"',Telefono_Celular='"+obj.getTelefonoCelular()+"',Telefono_Oficina='"+obj.getTelefonoOficina()+"',Nacionalidad='"+obj.getNacionalidad()+"',Sexo='"+obj.getSexo()+"',Profesion='"+obj.getProfesion()+"',Informacion_General='"+obj.getInformacionGeneral()+"',CodigoL="+obj.getCodigoL()+",CodigoLu="+obj.getCodigoLu()+",CodigoH="+obj.getCodigoH()+",Calle='"+obj.getCalle()+"',Edificio='"+obj.getEdificio()+"',Urbanizacion='"+obj.getUrbanizacion()+"' where CI_Pasaporte='"+obj.getCiPasaporte()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Cliente"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Cliente:  "+ e); 
        }   
    }
    
    public void InsertarAcompañante(Acompañante obj){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Acompañante_7 Values('"+obj.getCi()+"','"+obj.getNombre()+"','"+obj.getApellido()+"','"+obj.getFechaNac()+"','"+obj.getParentesco()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Acompañante"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Acompañante:  "+ e); 
        }  
    }
    
    public void ModificarAcompañante(Acompañante obj){
          try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Acompañante_7 set Nombre='"+obj.getNombre()+"',Apellido='"+obj.getApellido()+"',Parentesco='"+obj.getParentesco()+"' where CI='"+obj.getCi()+"'");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Acompañante"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Acompañante:  "+ e); 
        } 
    }
    
    public DefaultTableModel RevisarPagoFactura(String codigoH){
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Select A.Codigo,A.Fecha_Emision, B.Nombre Hotel, C.Nombre Compañia_Limpieza from Factura_Limpieza_7 A, Hotel_7 B, Compañia_7 C where (A.CodigoH="+codigoH+" AND ((CURDATE() - A.Fecha_Emision)>=30 ) AND (Tipo_Pago IS NULL OR Fecha_Pago IS NULL) And A.CodigoH = B.Codigo And A.RIF=C.RIF)"); // AND ((sysdate - A.Fecha_Emision)<=30)
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Facturas por pagar: "+e); 
             return null;
        } 
        
    }
   
    public DefaultTableModel RevisarPagoOrden(String codigoH){ //Orden Compra
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Select A.Numero, A.Fecha_Orden f_Emision , C.Nombre Producto, B.Cantidad from Orden_Compra_7 A, Detalle_Orden_Compra_7 B, Producto_Implemento_7 C where (A.CodigoH="+codigoH+" AND ((CURDATE() - A.Fecha_Orden)>=15 ) AND (Fecha_Pago IS NULL)) and B.Numero =A.Numero and C.codigo=B.Codigo "); // AND ((sysdate - A.Fecha_Emision)<=30)
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Facturas por pagar: "+e); 
             return null;
        } 
        
    }
    
    
    public void EliminarGeneral(String condicion){
       
         try{
        Connection con = conex.getConnection();
        System.out.println(condicion);
        PreparedStatement stm = con.prepareStatement(condicion);
        stm.executeUpdate();
        
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al Eliminar, asegurese de que no existen otras entidades que dependan de este elemento. "); 
            System.out.println(e);
        }
    }
  
      
    public void InsertarLimpiezaPiscina(LimpiezaPiscina obj){
         try{
            int cant=0;
            ResultSet set;
            PreparedStatement stm;
            Connection con = conex.getConnection();
            
            
            //Verificar que haya mas de un piscinero
            stm = con.prepareStatement("Select A.CI from Limpieza_Piscina_7 A where A.Fecha=CURDATE()-7 and A.CI = '"+obj.getCi()+"'");
            set = stm.executeQuery();
            if(set.next()){
                cant=set.getInt(0);
            }
            //Verificar Que no haya limpiado la ultima vez
            stm = con.prepareStatement("Select A.CI from Limpieza_Piscina_7 A where A.Fecha=DATE_FORMAT(CURDATE()-7,'%Y-%m-%d') and A.CI = '"+obj.getCi()+"'");
            set = stm.executeQuery();
            if(set.next()){
                if(!set.getString(0).equals(obj.getCi()) || cant==1){ //Si no limpio la semana anterior o solo hay un piscinero
                   
                    //Verificar que hay productos y eliminarlos
                    stm = con.prepareStatement("Update from Producto_Implemento_7 where ");
                    set = stm.executeQuery();
                    //Insertar
                    stm = con.prepareStatement("Insert  INTO Limpieza_Piscina_7 Values("+obj.getFecha()+","+obj.getCi()+","+obj.getHora()+","+obj.getCodigoS()+","+obj.getCodigoHS()+")");
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Limpieza Pisicna");
                }
                else{
                     JOptionPane.showMessageDialog(null,"Operacion Fallida: El piscinero seleccionado realizo la ultima limpieza");
                }
            }
       
            conex.dropConnection();
            
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Limpieza Piscina:  "+ e); 
        }   
    }
    
    public DefaultTableModel ConsultaLimpiezaPiscina(String condicion, String hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Fecha, A.CI CI_Piscinero, concat(B.Nombre,' ',B.Apellido) Piscinero, A.Hora, C.Capacidad Piscina from Limpieza_Piscina_7 A, Personal_7 B, Hotel_Servicio_7 C where "+condicion+" A.CodigoHS=C.CodigoH and A.CodigoS = C.CodigoS and A.CI=B.CI and B.Cargo = 'Piscinero' ");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Ajuste:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    public void LimpiezaPiscina1(){ //  Pendiente
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Producto_Implemento_7 set ");
        stm.executeUpdate();
       
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Restar Productos 1:  "+ e); 
        }
    }
    public void LimpiezaPiscina2(){ //Pendiente
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Producto_Implemento_7 set ");
        stm.executeUpdate();
       
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Restar Productos 1:  "+ e); 
        }
    
    }
    
    public void PagoFactura(FacturaLimpieza obj){ 
         try{
        Connection con = conex.getConnection();
        
        PreparedStatement stm;
        stm = con.prepareStatement("Select Tipo_Pago, Fecha_Pago from Factura_Limpieza_7 where Codigo="+obj.getCodigo());
        ResultSet set = stm.executeQuery();
            
            if(set.next()){
                
                if(set.getString(1)!=null || set.getString(2)!=null)
                    JOptionPane.showMessageDialog(null,"Operacion Fallida: La factura ya ha sido pagada."); 
                else{
                    stm = con.prepareStatement("UPDATE Factura_Limpieza_7 set Tipo_Pago='"+obj.getTipoPago()+"',Fecha_Pago='"+obj.getFechaPago()+"' where Codigo="+obj.getCodigo());
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Operacion exitosa: Pago Factura"); 
                    conex.dropConnection();
                }
        
            }
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Pago factura:  "+ e); 
        }  
    }

    public void PagoOrdenCompra(OrdenCompra obj){
        try{
        Connection con = conex.getConnection();
        
        PreparedStatement stm;
        stm = con.prepareStatement("Select Fecha_Pago from Orden_Compra_7 where Numero="+obj.getNumero());
        ResultSet set = stm.executeQuery();
            
            if(set.next()){
                
                if(set.getString(1)!=null)
                    JOptionPane.showMessageDialog(null,"Operacion Fallida: La Orden ya ha sido pagada."); 
                else{
                    stm = con.prepareStatement( "UPDATE Orden_Compra_7 set Fecha_Pago='"+obj.getFechaPago()+"' where Numero="+obj.getNumero());
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Operacion exitosa: Pago Orden Compra"); 
                    conex.dropConnection();
                }
        
            }
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Pago OrdenCompra:  "+ e); 
        } 
    }
    
       public DefaultTableModel ConsultaInventarioProducto(int codigoH){
            DefaultTableModel modelo = new DefaultTableModel();
            
            try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Select Codigo, Nombre,Cantidad_Teorica, Cantidad_Fisica from Producto_Implemento_7 where CodigoH="+codigoH+" Group by Codigo");
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
            System.out.println(modelo.getDataVector());
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar cantidad fisica por producto: "+e); 
             return null;
        }  
    }
      
  
      public void ComprobarMesInventario(String codigoH){
        PreparedStatement stm; 
        Connection con = conex.getConnection();
        int count =0;
        try{
             
             
            stm = con.prepareStatement("SELECT TIMESTAMPDIFF(MONTH,(Select Fecha_Inventario from Producto_Implemento_7 where CodigoH ="+codigoH+" LIMIT 1),CURDATE())");
            ResultSet set = stm.executeQuery();
            if(set.next())
                count = set.getInt(1); 
            
            if(count>=1)
              JOptionPane.showMessageDialog(null,"Ha pasado "+count+" mes(es) Actualice los registros de inventario.  ");    
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo al calcular fecha necesaria para registro inventario:  "+ e); 
        }
    }
            
     public String ConsultaPrimaria(String campoP, String tabla, String campo, String valor){
          String pk;
          try{
            Connection con = conex.getConnection();
             
            PreparedStatement stm = con.prepareStatement("Select "+campoP+" from "+tabla+" where "+campo+" LIKE '%"+valor+"%'");
            ResultSet set =stm.executeQuery();
           
            if(set.next()){
                
            pk = set.getString(1);
             set.close();
            conex.dropConnection();
             System.out.println(pk);
            return (pk);
            }
            System.out.println("hola2");
           return "";
          
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consulta Primaria: "+e); 
            return null;
        }  
     }   
    
    public void InsertarComodidad(Comodidad obj){
          try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Comodidad_7 Values("+obj.getCodigo()+",'"+obj.getNombre()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Comodidad"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Comodidad:  "+ e); 
        }  
    }
    
    public DefaultTableModel ConsultaCliente(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select Concat_WS('',A.Año_Ingreso,A.Consecutivo) Codigo, A.CI_Pasaporte,CONCAT_WS (' ',A.Nombre,A.Apellido) Nombre,A.Telefono_Local,A.Telefono_Celular,A.Telefono_Oficina, A.Fecha_Nacimiento, A.Nacionalidad,Pais.Descripcion Pais,A.Sexo, A.Informacion_General,D.Nombre Hotel, Concat_WS(' ','Ciudad',Ciudad.Descripcion, A.Calle, A.Edificio,'urb', A.Urbanizacion) Direccion from Cliente_7 A, Lugar_7 Pais, Lugar_7 Ciudad, Hotel_7 D where "+condicion+" A.CodigoH=D.Codigo and A.CodigoLu = Pais.Codigo  AND A.CodigoL=Ciudad.Codigo");
            
            System.out.println("Select Concat_WS('',A.Año_Ingreso,A.Consecutivo) Codigo, A.CI_Pasaporte, A.Nombre, A.Apellido,A.Telefono_Local,A.Telefono_Celular,A.Telefono_Oficina, A.Fecha_Nacimiento A.Nacionalidad, A.Sexo, A.Profesion, A.Informacion_General, B.Descripcion, C.Descripcion, D.Nombre, A.Calle, A.Edificio, A.Urbanizacion from Cliente_7 A, Lugar_7 B, Lugar_7 C, Hotel_7 D where "+condicion+" A.CodigoL=B.Codigo AND A.CodigoLu=C.Codigo AND A.CodigoH=D.Codigo");
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Clientel: "+e); 
             return null;
        }  
    }
    
      public DefaultTableModel ConsultaHotel(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Codigo, A.Nombre, A.Categoria, A.Tipo_Servicio, CONCAT_WS(' ','Ciudad',B.Descripcion, A.Calle, A.Edificio,'urb.', A.Urbanizacion) Direccion, Concat(C.Nombre,' ',C.Apellido) Gerente from Hotel_7 A, Lugar_7 B, Personal_7 C where "+condicion+" A.codigoL=B.Codigo and B.Tipo='Ciudad' and A.CI_Gerente=C.CI");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Clientel: "+e); 
             return null;
        }  
    }
    
      
       public DefaultTableModel ConsultaCompañiaLimpieza(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.RIF, A.Nombre Compañia,CONCAT_WS(' ','Ciudad',B.Descripcion, A.Calle, A.Edificio,'urb.', A.urbanizacion)Direccion,A.Telefono from Compañia_7 A, Lugar_7 B where "+condicion+" A.codigoL=B.Codigo and B.Tipo='Ciudad' and A.Tipo_Compañia='Limpieza'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Compañia Limpieza: "+e); 
             return null;
        }  
    }
       
       public DefaultTableModel ConsultaProveedor(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.RIF, A.Nombre Proveedor,CONCAT_WS(' ','Ciudad',B.Descripcion, A.Calle, A.Edificio,'urb.',A.urbanizacion) Direccion,A.Telefono from Compañia_7 A, Lugar_7 B where "+condicion+" A.codigoL=B.Codigo and  A.Tipo_Compañia='Proveedor'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Proveedor: "+e); 
             return null;
        }  
    }
       
    public DefaultTableModel ConsultaFacturaLimpieza(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Codigo, A.Fecha_Inicio, A.Fecha_Final,A.Fecha_Emision,B.Nombre Hotel,C.Nombre Compañia, IFNULL(A.Tipo_Pago,'NO PAGADO') Tipo_Pago, IFNULL(A.Fecha_Pago,'NO PAGADO') Fecha_Pago  from Factura_Limpieza_7 A, Hotel_7 B, Compañia_7 C where "+condicion+" A.CodigoH=B.Codigo and A.RIF=C.RIF");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Facturas de Limpieza: "+e); 
             return null;
        }  
    }
     
    public DefaultTableModel ConsultaProducto(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Codigo, A.Nombre Producto,A.Cantidad_Minima,A.Cantidad_Teorica,IFNULL(A.Cantidad_Fisica,'Pendiente') Cantidad_Fisica,IFNULL(A.Fecha_Inventario,'Pendiente') Fecha_Inventario,B.Nombre Hotel from Producto_Implemento_7 A, Hotel_7 B  where "+condicion+" A.CodigoH=B.Codigo");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Productos: "+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaOrdenCompra(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Numero, C.Nombre Compañia,A.Fecha_Orden,IFNULL(A.Fecha_Pago,'NO PAGADO') Fecha_Pago,B.Nombre Hotel from Orden_Compra_7 A, Hotel_7 B, compañia_7 C  where "+condicion+" A.CodigoH=B.Codigo and A.RIF = C.RIF");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Orden de Compra:"+System.getProperty("line.separator")); 
             return null;
        }  
    }
    
     public DefaultTableModel ConsultaTrabajoCompañia(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.CodigoTL Codigo_Trabajo,B.Descripcion Descripcion_Trabajo,C.Nombre Compañia, A.Costo Costo_en_Bs from Trabajo_Compañia_7 A, Trabajo_Limpieza_7 B, Compañia_7 C where "+condicion+" A.CodigoTL=B.Codigo and A.RIF=C.RIF");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
    }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Trabajo por Compañia:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
     
    public DefaultTableModel ConsultaPersonal(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.CI,CONCAT(A.Nombre,' ',A.Apellido) Nombre, CONCAT_WS(' ','Ciudad',B.Descripcion,A.Calle,A.Edificio,'urb',A.Urbanizacion) Direccion,A.Sexo,A.Fecha_Nacimiento,A.Fecha_Inicio,A.Cargo,IFNULL(A.Nivel_Estudio,'No corresponde') Nivel_Estudio,C.Nombre Hotel,D.Nombre Supervisor  from Personal_7 A, Lugar_7 B, Hotel_7 C, Personal_7 D where "+condicion+" A.CodigoH=C.Codigo and A.codigoL=B.Codigo and A.CI_Supervisor=D.CI"); //*
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Personal:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    


 public DefaultTableModel ConsultaAjuste(String condicion, String hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Fecha,A.Cantidad,A.Tipo,B.Nombre Producto, A.CodigoP Codigo_Producto  from Ajuste_7 A, Producto_Implemento_7 B, Hotel_7 C where "+condicion+" A.CodigoP=B.Codigo and B.CodigoH=C.Codigo and C.Nombre LIKE'%"+hotel+"%'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Ajuste:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
     public DefaultTableModel ConsultaAcompañante(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.CI,CONCAT_WS(' ',A.Nombre,A.Apellido) Nombre,A.Fecha_Nacimiento,A.Parentesco from Acompañante_7 A where "+condicion+" CI");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Ajuste:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    
       public DefaultTableModel ConsultaExperiencia(String condicion, String CI){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.compañia, A.Cargo, A.Fecha_Inicio,A.Fecha_Fin, Concat(B.Nombre,' ',B.Apellido) Nombre, A.CI  from Experiencia_7 A, Personal_7 B where "+condicion+" A.CI=B.CI AND B.Cargo='Gerente' And B.CI='"+CI+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Ajuste:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
        
        public void InsertarHabitacion(Habitacion obj){
           PreparedStatement stm;
           ResultSet set;
           int count=0;
           try{
            Connection con = conex.getConnection();
               
            stm = con.prepareStatement("Select MAX(numero) from Habitacion_7 where CodigoH="+obj.getCodigoH()); //Seleccona la cantidad maxima de amonestacion para un piscinero
            set = stm.executeQuery();
            
            if(set.next()){
                count = set.getInt(1)+1; //Maximo +1 por piscinero
            }
          
            stm = con.prepareStatement("INSERT INTO Habitacion_7 VALUES ("+count+",'"+obj.getTipo()+"',"+obj.isDisponible()+","+obj.getCodigoH()+","+obj.getCosto()+","+obj.getCantidad()+")");
            stm.executeUpdate();
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al insertar habitaciones en el hotel señalado:  "+ e); 
        }     
    
    }
        
    public void InsertarHC(HC obj){
        try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO HC_7 Values("+obj.getNumero()+","+obj.getCodigoC()+","+obj.getCodigoH()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Comodidades en hoteles"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al insertar Comodidades en hoteles:  "+ e); 
        }  
    }
    
    public void ModificarComodidad(Comodidad obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Comodidad_7 set Nombre='"+obj.getNombre()+"' Where Codigo="+obj.getCodigo());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Comodidad"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Comodidad "+ e); 
        }
    }
    public void ModificarHabitacion(Habitacion obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Habitacion_7 set Tipo="+obj.getTipo()+", Disponible="+obj.isDisponible()+" where Numero="+obj.getNumero()+" AND CodigoH="+obj.getCodigoH());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Comodidad"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Comodidad "+ e); 
        }
    }
    
    public DefaultTableModel ConsultaLenguaje(String condicion, String CI){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Idioma from Lenguaje_7 A, Personal_7 B where "+condicion+" A.CI=B.CI AND B.Cargo='Encargado' And B.CI='"+CI+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Lenguaje:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
         
    public DefaultTableModel ConsultaAmonestacion(String condicion, String CI){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Numero, A.Fecha, A.Razon  from Amonestacion_7 A, Personal_7 B where "+condicion+" A.CI=B.CI AND B.Cargo='Piscinero' And B.CI='"+CI+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Amonestacion:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
         
    public DefaultTableModel ConsultaHorario(String condicion, String CI){
        DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Dia_Semana, A.Hora from Horario_7 A, Personal_7 B where "+condicion+" A.CI=B.CI AND B.CI='"+CI+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Horario:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
         
    public DefaultTableModel ConsultaPP(String condicion){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.CodigoP, B.Nombre Producto, A.RIF, C.Nombre Proveedor from PP_7 A, Producto_implemento_7 B, Compañia_7 C where "+condicion+" A.RIF=C.RIF AND A.CodigoP=B.Codigo ");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
          
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Productos ofrecidos por Proveedor:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
         
    public DefaultTableModel ConsultaHabitacion(String condicion, String Hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Numero, A.Tipo, A.Disponible, A.Costo, A.Cantidad_Personas from Habitacion_7 A, Hotel_7 B where "+condicion+" A.CodigoH=B.Codigo AND B.Nombre='"+Hotel+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Habtición:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
        
    public DefaultTableModel ConsultaHC(String condicion, String Hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Numero Numero_Comodidad, B.Nombre ,C.Numero N°_Hab ,D.Codigo Hotel from HC_7 A, Comodidad_7 B, Habitacion_7 C , Hotel_7 D where "+condicion+" A.CodigoC=B.Codigo AND A.Numero=C.Numero AND A.CodigoH=D.Codigo and A.CodigoH=C.CodigoH AND D.Nombre='"+Hotel+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Comodidades contenidas en Habitación:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
         
    public DefaultTableModel ConsultaDetalleOrdenCompra(String condicion, String Hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Numero, B.Nombre ,A.Cantidad , A.Costo from Detalle_Orden_Compra_7 A, Producto_Implemento_7 B, Orden_Compra_7 C, Hotel_7 D where "+condicion+" A.Numero=C.Numero AND A.Codigo=B.Codigo AND C.CodigoH=D.Codigo AND D.Nombre='"+Hotel+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
           
            return modelo;
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Detalle de la Orden de Compra:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    public DefaultTableModel ConsultaDetalleFactura(String condicion, String Hotel){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.CodigoFL Codigo_Factura, B.Descripcion Trabajo_Limpieza , A.Costo from Detalle_Factura_7 A, Trabajo_Limpieza_7 B, Factura_Limpieza_7 C where "+condicion+" A.CodigoFL = B.Codigo and A.CodigoTL=C.Codigo");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
        
            return modelo;
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Detalle de la Orden de Compra:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaReserva(String condicion)
    {
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Codigo,concat_ws(' ',B.Nombre,B.Apellido) Cliente ,concat_ws('-',A.Año_Ingreso,A.Consecutivo) Codigo_Cliente, A.Fecha_Reserva,A.Fecha_Inicio, Fecha_final, Monto_Total,A.Estatus Activa from Reserva_7 A, Cliente_7 B, Hotel_7 C where "+condicion+" A.Consecutivo=B.Consecutivo and A.Año_Ingreso=B.Año_Ingreso");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Reservas:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaCompra(String condicion)
    {
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Codigo Codigo_Compra,concat_ws(' ',B.Nombre,B.Apellido) Cliente ,concat_ws('-',A.Año_Ingreso,A.Consecutivo) Codigo_Cliente, A.Fecha_Compra,A.Fecha_Inicio, A.Fecha_final, A.Monto_Total,A.Tipo_Pago,C.Codigo Codigo_Reserva from Compra_7 A, Cliente_7 B, Reserva_7 C where "+condicion+" A.Consecutivo=B.Consecutivo and A.Año_Ingreso=B.Año_Ingreso and A.CodigoR=C.Codigo" );
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Reservas:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaPaqueteHotel(String condicion, String hotel){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            // PreparedStatement stm = con.prepareStatement("Select B.Nombre Hotel, C.Codigo Codigo_Paquete, C.Nombre Paquete, C.Descripcion Descr_Paquete, A.Costo Costo_Paquete, A.Cupos from HP_7 A, Hotel_7 B, Paquete_7 C where "+condicion+"A.CodigoP=C.Codigo and A.CodigoH=B.Codigo and B.Nombre ='"+hotel+"'");
            PreparedStatement stm = con.prepareStatement("Select C.Nombre Paquete, C.Codigo Codigo_Paquete, C.Descripcion Descr_Paquete, A.Costo Costo_Paquete, A.Cupos from HP_7 A, Hotel_7 B, Paquete_7 C where "+condicion+" A.CodigoP=C.Codigo and A.CodigoH=B.Codigo and B.Nombre ='"+hotel+"'");
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Paquetes por hotel:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaServicioHotel(String condicion, String hotel){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select C.Codigo Codigo_Servicio, C.Descripcion Servicio, Concat(D.Nombre,' ' ,D.Apellido)Encargado, A.Costo from Hotel_Servicio_7 A, Hotel_7 B, Servicio_7 C, Personal_7 D where "+condicion+" A.CodigoS=C.Codigo and A.CodigoH=B.Codigo and A.CI=D.CI and B.Nombre ='"+hotel+"'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Servicios por hotel:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    public boolean validarExistencia(String pk, String campo, String tabla){
            int count; 
            try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Select COUNT("+campo+") from "+tabla+" where "+campo+"="+pk+"");
            ResultSet set =stm.executeQuery();
            if(set.next()){
                count = set.getInt(1);
                System.out.println(count);
                return count>0;
            }
            set.close();
            conex.dropConnection();
             }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error Al Verificar Existencia:"+System.getProperty("line.separator")+e); 
            }  
            return false;
    }

    public void InsertarPaquete(Paquete obj){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Paquete_7 Values("+obj.getCodigo()+",'"+obj.getNombre()+"','"+obj.getDescripcion()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Paquete"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Paquete:  "+ e); 
        }  
    }
    
    public void ModificarPaquete(Paquete obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Paquete_7 set Nombre='"+obj.getNombre()+"',Descripcion='"+obj.getDescripcion()+"' where Codigo="+obj.getCodigo());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Paquete"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Paquete "+ e); 
        }
    }

    public void InsertarHP(HP obj){
         try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO HP_7 Values("+obj.getCodigoP()+","+obj.getCodigoH()+","+obj.getCosto()+","+obj.getCupos()+")");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Paquete por Hotel"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Paquete por Hotel:  "+ e); 
        }  
    }
    
    public void ModificarHP(HP obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE HP_7 set Costo="+obj.getCosto()+",Cupos="+obj.getCupos()+" Where CodigoH="+obj.getCodigoH()+" and CodigoP="+obj.getCodigoP());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Paquete en el hotel"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Paquete en el Hotel:  "+ e); 
        }
    }
    
    public void InsertarServicio(Servicio obj){
    try{
        int es;
        if(obj.isEquipoEspecial())
            es = 1;
        else
            es = 0;
        
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Servicio_7 Values('"+obj.getDescripcion()+"',"+es+",'"+obj.getTarifa()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Servicio"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Servicio:  "+ e); 
        }  
    }
 public void ModificarServicio(Servicio obj){
        try{
             int es;
        if(obj.isEquipoEspecial())
            es = 1;
        else
            es = 0;
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Servicio_7 set Descripcion='"+obj.getDescripcion()+"',Equipo_Especial="+es+",Tarifa="+obj.getTarifa()+"where Codigo="+obj.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Servicio"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Servicio "+ e); 
        }
    }
    
    public void InsertarHotelServicio(HotelServicio obj){
    try{
            Connection con = conex.getConnection();
            PreparedStatement stm = con.prepareStatement("Insert  INTO Hotel_Servicio_7 Values("+obj.getCosto()+",'"+obj.getTipo()+"',"+obj.getCodigoH()+",'"+obj.getTipoServicio()+"',"+obj.getCapacidad()+",'"+obj.getCi()+"')");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Servicio de Hotel"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Servicio de Hotel:  "+ e); 
        }
    }
    
    public void ModificarHotelServicio(HotelServicio obj){ //Falta comprobar como agregar piscina
         try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Hotel_Servicio_7 set Costo = "+obj.getCosto()+" where CodigoH="+obj.getCodigoH()+"and CodigoS="+obj.getCodigoS());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Servicio en Hotel"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update Servicio en Hotel "+ e); 
        }
    }
    
    public void InsertarPaqueteReserva(PaqueteReserva obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Paquete_Reserva_7 Values("+obj.getCosto()+","+obj.getCodigoR()+","+obj.getCodigoP()+","+obj.getCodigoH()+")");
        stm.executeUpdate();
        stm = con.prepareStatement("UPDATE HP_7 set Cupos=Cupos-1 where CodigoP="+obj.getCodigoP()+" and CodigoH="+obj.getCodigoH());
        stm.executeUpdate(); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Paquete de Reserva:  "+ e); 
        }
    }
    public void InsertarPaqueteCompra(PaqueteCompra obj, int tipo){ 
        PreparedStatement stm;
      
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO Paquete_Compra_7 Values("+obj.getCodigoC()+","+obj.getCodigoHPH()+","+obj.getCodigoHPP()+","+obj.getCosto()+")");
        stm.executeUpdate();
        if (tipo==1){ //Si no proviene de reserva (Compra nueva)
             stm = con.prepareStatement("UPDATE HP_7 set Cupos=Cupos-1 where CodigoP="+obj.getCodigoHPP()+" and CodigoH="+obj.getCodigoHPH());
            stm.executeUpdate(); 
        }
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Paquete por Compra:  "+ e); 
        }
    }
    
    public void InsertarServicioReserva(ServicioReserva obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Servicio_Reserva_7 Values("+obj.getCosto()+","+obj.getCodigoS()+","+obj.getCodigoH()+","+obj.getCodigoR()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Servicio de Reserva"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Insert Servicio de Reserva:  "+ e); 
        }   
    }
    
    public void InsertarServicioCompra(ServicioCompra obj){ 
        PreparedStatement stm;
      
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO Servicio_Compra_7 Values("+obj.getCodigoC()+","+obj.getCodigoHS()+","+obj.getCodigoS()+","+obj.getCosto()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Servicio por Compra"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Servicio por Compra:  "+ e); 
        }
    }
    
    public void InsertarCompra(Compra obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Compra_7 Values("+obj.getCodigo()+",'"+obj.getFechaCompra()+"','"+obj.getFechaInicio()+"','"+obj.getFechaFinal()+"',"+obj.getMontoTotal()+","+obj.getCodigoR()+","+obj.getAñoIngreso()+","+obj.getConsecutivo()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Compra"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Insert Compra:  "+ e); 
        }   
    }
    
    public void ModificarCompra(Compra obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("UPDATE Compra_7 set Fecha_Inicio='"+obj.getFechaInicio()+"', Fecha__Final='"+obj.getFechaFinal()+"',Monto_Total="+obj.getMontoTotal()+" where Codigo="+obj.getCodigo()+"");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Modificar Compra"); 
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update de Compra "+ e); 
        }
    }
    
    
    
    public void InsertarPago(Pago obj){
        try{
        Connection con = conex.getConnection();
        PreparedStatement stm = con.prepareStatement("INSERT INTO Pago_7 Values('"+obj.getMonto()+","+obj.getTipoPago()+","+obj.getFechaPago()+","+obj.getCodigoC()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Pago"); 
            conex.dropConnection();
        }
        
        //Escribir para verificar y modificar compra fecha
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Insert Pago:  "+ e); 
        }   
    }
    
    public DefaultTableModel ConsultaPago(String condicion, int codigoC){
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select A.Monto, A.Tipo_Pago, A.Fecha_Pago from Pago_7 A, Compra_7 B where "+condicion+" A.CodigoC=B.CodigoC'");
            
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error Al Consultar Pago:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public void InsertarReserva(Reserva obj){
        PreparedStatement stm;
      
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO Reserva_7 Values("+obj.getCodigo()+","+obj.getConsecutivo()+",CURDATE(),'"+obj.getFechaInicio()+"','"+obj.getFechaFinal()+"',"+obj.getMontoTotal()+",1,"+obj.getAñoIngreso()+")");
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Operacion exitosa: Insertar Reserva"); 
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert Reserva:  "+ e); 
        }
    }
    
    public void CalcularMontoTotalReserva(int codigoR){
        double costoP=0, costoS=0, costoH=0, costoT=0;
        PreparedStatement stm;  
        ResultSet set;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("Select SUM(Costo) from Paquete_Reserva_7 where CodigoR ="+codigoR);
        set = stm.executeQuery();
        if (set.next()){
            costoP = set.getDouble(1);
        }
        stm = con.prepareStatement("Select SUM(Costo) from Servicio_Reserva_7 where CodigoR ="+codigoR);
        set = stm.executeQuery();
        if (set.next()){
            costoS = set.getDouble(1);
        }
        stm = con.prepareStatement("Select SUM(Costo) from HR_7 where CodigoR ="+codigoR);
        set = stm.executeQuery();
        if (set.next()){
            costoH = set.getDouble(1);
        }
        
        costoT=costoP+costoH+costoS;
        stm = con.prepareStatement("Update Reserva_7 set Monto_Total="+costoT+" where Codigo="+codigoR);
        stm.executeUpdate();
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Calculo monto de Reserva:  "+ e); 
        }
    }
    
     public void CalcularMontoTotalCompra(int codigoC){
        double costoP=0, costoS=0, costoH=0, costoT=0;
        PreparedStatement stm;  
        ResultSet set;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("Select SUM(Costo) from Paquete_Compra_7 where CodigoC ="+codigoC);
        set = stm.executeQuery();
        if (set.next()){
            costoP = set.getDouble(1);
        }
        stm = con.prepareStatement("Select SUM(Costo) from Servicio_Compra_7 where CodigoC ="+codigoC);
        set = stm.executeQuery();
        if (set.next()){
            costoS = set.getDouble(1);
        }
        stm = con.prepareStatement("Select SUM(Costo) from CH_7 where CodigoC ="+codigoC);
        set = stm.executeQuery();
        if (set.next()){
            costoH = set.getDouble(1);
        }
        
        costoT=costoP+costoH+costoS;
        stm = con.prepareStatement("Update Reserva_7 set Monto_Total="+costoT+" where Codigo="+codigoC);
        stm.executeUpdate();
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Calculo monto de Compra:  "+ e); 
        }
    }
     
    public void AgregarCompra(int codigoR){ //Trae de reserva los paquetes, servicios , habitaciones y acompañantes correspondientes a la reserva
        PreparedStatement stm; 
        ResultSet set;
        int codigoC=0;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("  select * from Compra_7 order by id desc limit 1");
        set =stm.executeQuery();
        if(set.next()){
            codigoC=set.getInt(1);
        }
      
        stm = con.prepareStatement("Insert Into Paquete_Compra_7(CodigoHPH,CodigoHPP,Costo)(Select A.CodigoH,A.CodigoP,A.Costo from Paquete_Reserva_7 A, Compra_7 B where CodigoR = "+codigoR+")");
        stm.executeUpdate();
        stm = con.prepareStatement("Insert Into Servicio_Compra_7(CodigoHS,CodigoS,Costo)(Select CodigoH,CodigoS,Costo from Servicio_Reserva_7 where CodigoR = "+codigoR+")");
        
        stm.executeUpdate();
        stm = con.prepareStatement("Insert Into CH_7(Numero,CodigoHH,Costo)(Select Numero,Costo from Servicio_Reserva_7 where CodigoR = "+codigoR+")");
        
        stm.executeUpdate();
        stm = con.prepareStatement("");
        stm.executeUpdate();
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Calculo monto de Compra:  "+ e); 
        }
    }
    
    public void InsertarHR(HR obj){
        PreparedStatement stm;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO HR_7 Values("+obj.getNumero()+","+obj.getCodigoR()+","+obj.getCodigoH()+","+obj.getCosto()+")");
        stm.executeUpdate();
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert HR:  "+ e); 
        }
    }
    
    public void InsertarRA(RA obj){
        PreparedStatement stm;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO RA_7 Values("+obj.getCodigoR()+",'"+obj.getCi()+"')");
        stm.executeUpdate();
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert RA:  "+ e); 
        }
    }
    public void InsertarCH(CH obj){
        PreparedStatement stm;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO CH_7 Values("+obj.getNumero()+","+obj.getCodigoC()+","+obj.getCodigoHH()+","+obj.getCosto()+")");
        stm.executeUpdate();
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert CH:  "+ e); 
        }
    }
    
      public void InsertarCA(CA obj){
        PreparedStatement stm;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("INSERT INTO CA_7 Values("+obj.getCodigoC()+",'"+obj.getCi()+"')");
        stm.executeUpdate();
            conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar insert CA:  "+ e); 
        }   
    }
      
    public void DescontarCupos(){
        PreparedStatement stm;
        try{
        Connection con = conex.getConnection();
        stm = con.prepareStatement("UPDATE HP_7 set Cupos=Cupos-1 ");
        stm.executeUpdate();
        conex.dropConnection();
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Fallo Al realizar Update de Cupos en HP "+ e); 
        }
    }
    
    public DefaultTableModel ConsultaPaqueteReserva(String condicion, String codigoR){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select B.Nombre paquete, C.Nombre hotel, A.Costo from Paquete_Reserva_7 A, Paquete_7 B, Hotel_7 C where "+condicion+" A.CodigoP=B.Codigo and A.CodigoH=C.codigo and A.CodigoR="+codigoR);
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Paquetes en la reserva:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaPaqueteCompra(String condicion, String codigoC){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select B.Nombre paquete, C.Nombre hotel, A.Costo from Paquete_Compra_7 A, Paquete_7 B, Hotel_7 C where "+condicion+" A.CodigoHPP=B.Codigo and A.CodigoHPH=C.codigo and A.CodigoC="+codigoC);
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Paquetes en la compra:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaServicioReserva(String condicion, String codigoR){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select B.Descripcion Servicio, C.Nombre hotel, A.Costo from Servicio_Reserva_7 A, Servicio_7 B, Hotel_7 C where "+condicion+" A.CodigoS=B.Codigo and A.CodigoH=C.codigo and A.CodigoR="+codigoR);
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Servicios en la reserva:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
    
    public DefaultTableModel ConsultaServicioCompra(String condicion, String codigoC){
         
         DefaultTableModel modelo = new DefaultTableModel();
  
        try{
            Connection con = conex.getConnection();
            System.out.println(condicion);
            PreparedStatement stm = con.prepareStatement("Select B.Descripcion Servicio, C.Nombre hotel, A.Costo from Servicio_Compra_7 A, Servicio_7 B, Hotel_7 C where "+condicion+" A.CodigoS=B.Codigo and A.CodigoHS=C.codigo and A.CodigoC="+codigoC);
            ResultSet set =stm.executeQuery();
            ResultSetMetaData setm = set.getMetaData();
            int cantidadColumnas = setm.getColumnCount();
            
            for(int i=1;i<=cantidadColumnas;i++){
                modelo.addColumn(setm.getColumnLabel(i));
            }
            while (set.next()) {
                String fila[] = new String [cantidadColumnas];
                for (int j = 0; j < cantidadColumnas;j++) {
                    fila[j]=set.getString(j+1);
                }
                modelo.addRow(fila);
            }
           
            set.close();
            conex.dropConnection();
            
            return modelo;
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error Al Consultar Servicios en la compra:"+System.getProperty("line.separator")+e); 
             return null;
        }  
    }
}