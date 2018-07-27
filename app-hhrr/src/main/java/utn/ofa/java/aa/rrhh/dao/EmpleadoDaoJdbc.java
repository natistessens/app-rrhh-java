package utn.ofa.java.aa.rrhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date;
import java.sql.ResultSet;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import utn.ofa.java.aa.rrhh.Contratado;
import utn.ofa.java.aa.rrhh.Efectivo;
import utn.ofa.java.aa.rrhh.Empleado;

public class EmpleadoDaoJdbc implements EmpleadoDao {
    
   private final String INSERT_EMPLEADO = "INSERT INTO EMPLEADOS (NOMBRE, CORREO, CUIL, FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO,"
        + "COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private final String UPDATE_EMPLEADO ="UPDATE EMPLEADOS SET NOMBRE = ?, CORREO = ?, CUIL = ?, FECHA_INGRESO = ?, HS_TRABAJADAS = ?, SUELDO_BASICO = ?," +
" COMISIONES = ?, HS_MINIMAS = ?, COSTO_HORA = ? WHERE ID = ?";
    
    private final String DELETE_EMPLEADO = "DELETE FROM EMPLEADOS WHERE ID=?";
    
    private final String SELECT_EMPLEADO = "SELECT * FROM EMPLEADOS WHERE ID=?";
    
    private final String SELECT_ALL_EMPLEADO = "SELECT * FROM EMPLEADOS";


    public int crear(Empleado e) throws SQLException {
        Connection conn = ConexionJDBC.getConexion();
       
        try(PreparedStatement ps = conn.prepareStatement(INSERT_EMPLEADO)){
             ps.setString(1, e.getNombre());
             ps.setString(2, e.getCorreoElectronico());
             ps.setString(3, e.getCuil());
             ps.setDate(4, new Date(e.getFechaIngreso().getTime()));
             ps.setInt(5, e.getHorasTrabajadas());
                     if(e.esEfectivo()){
                         Efectivo empEf = (Efectivo) e;
                         ps.setDouble(6, empEf.getSueldoBasico());
                         ps.setDouble(7, empEf.getComisiones());
                         ps.setInt(8, empEf.getHorasObligatorias());
                         ps.setNull(9, Types.SQLXML);
                         ps.setInt(10, 1);
                     }
                     if(e.esContratado()){
                         Contratado c = (Contratado) e;
                         ps.setNull(6, Types.SQLXML);
                         ps.setNull(7, Types.SQLXML);
                         ps.setNull(8, Types.SQLXML);
                         ps.setDouble(9, c.getCostoHora());
                         ps.setInt(10, 2);
                     }
           return ps.executeUpdate();
            
        }catch(SQLException ex){
         ex.printStackTrace();
         return -1;
        }
        finally {
        ConexionJDBC.liberarConexion();
        }
    }

    public int actualizar(Empleado e) throws SQLException{
         Connection conn = ConexionJDBC.getConexion();
         
         try(PreparedStatement ps = conn.prepareStatement(UPDATE_EMPLEADO)){
              ps.setString(1, e.getNombre());
              ps.setString(2, e.getCorreoElectronico());
              ps.setString(3, e.getCuil());
              ps.setDate(4, new Date(e.getFechaIngreso().getTime()));
              ps.setInt(5, e.getHorasTrabajadas());
                      if(e.esEfectivo()){
                          Efectivo empEf = (Efectivo) e;
                          ps.setDouble(6, empEf.getSueldoBasico());
                          ps.setDouble(7, empEf.getComisiones());
                          ps.setInt(8, empEf.getHorasObligatorias());
                        
                      }
                      if(e.esContratado()){
                          Contratado c = (Contratado) e;
                          ps.setNull(6, Types.DOUBLE);
                          ps.setNull(7, Types.DOUBLE);
                          ps.setNull(8, Types.INTEGER);
                          ps.setDouble(9, c.getCostoHora());
                      }
             ps.setInt(10, e.getId());
             return ps.executeUpdate();
         }catch(SQLException ex){
          ex.printStackTrace();
             return -1;
         }
         finally {
         ConexionJDBC.liberarConexion();
         }
    
     }

    public int eliminar(Empleado e) throws SQLException {
         Connection conn = ConexionJDBC.getConexion();
         
         try(PreparedStatement ps = conn.prepareStatement(DELETE_EMPLEADO)){     
             ps.setInt(1, e.getId());
              return ps.executeUpdate();
         }catch(SQLException ex){
          ex.printStackTrace();
         }
         return -1;
     }

    public Empleado buscarPorId(Integer id) throws SQLException {
        Empleado retorno = null;
        Connection conn = ConexionJDBC.getConexion();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_EMPLEADO)) {
            ps.setInt(1, id.intValue());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {               

                Double costoHora = rs.getDouble("COSTO_HORA");

                if (costoHora != null) {
                    retorno = new Contratado();
                    ((Contratado) retorno).setCostoHora(rs.getInt("COSTO_HORA"));
                } else {
                    retorno = new Efectivo();
                    ((Efectivo) retorno).setSueldoBasico(rs.getDouble("SUELDO_BASICO"));
                    ((Efectivo) retorno).setComisiones(rs.getDouble("COMISIONES"));
                    ((Efectivo) retorno).setHorasObligatorias(rs.getInt("HS_MINIMAS"));
                } //Retrieve by column name
                retorno.setNombre(rs.getString("NOMBRE"));
                retorno.setCorreoElectronico(rs.getString("CORREO"));
                retorno.setCuil(rs.getString("CUIL"));
                retorno.setFechaIngreso(rs.getDate("FECHA_INGRESO"));
                retorno.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS"));
                retorno.setId(id);
  
            }
            
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    public List<Empleado> buscarTodos() throws SQLException {
        Empleado retorno = null;
        List<Empleado> listaEmpleados = null;
        Connection conn = ConexionJDBC.getConexion();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPLEADO)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (listaEmpleados == null) {
                    listaEmpleados = new ArrayList();
                }
                //Retrieve by column name
                Double costoHora = rs.getDouble("COSTO_HORA");

                if (costoHora != null) {
                    retorno = new Contratado();
                    ((Contratado) retorno).setCostoHora(rs.getInt("COSTO_HORA"));
                } else {
                    retorno = new Efectivo();
                    ((Efectivo) retorno).setSueldoBasico(rs.getDouble("SUELDO_BASICO"));
                    ((Efectivo) retorno).setComisiones(rs.getDouble("COMISIONES"));
                    ((Efectivo) retorno).setHorasObligatorias(rs.getInt("HS_MINIMAS"));
                }
                retorno.setNombre(rs.getString("NOMBRE"));
                retorno.setCorreoElectronico(rs.getString("CORREO"));
                retorno.setCuil(rs.getString("CUIL"));
                retorno.setFechaIngreso(rs.getDate("FECHA_INGRESO"));
                retorno.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS"));

                

                listaEmpleados.add(retorno);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return listaEmpleados;
    }
}
