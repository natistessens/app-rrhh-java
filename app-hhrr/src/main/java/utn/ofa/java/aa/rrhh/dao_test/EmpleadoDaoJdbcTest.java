package utn.ofa.java.aa.rrhh.dao_test;

import java.sql.SQLException;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import utn.ofa.java.aa.rrhh.Contratado;
import utn.ofa.java.aa.rrhh.Efectivo;
import utn.ofa.java.aa.rrhh.Empleado;
import utn.ofa.java.aa.rrhh.Empleado;
import utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc;

public class EmpleadoDaoJdbcTest {
    public EmpleadoDaoJdbcTest() {
    }

    /**
     * @see utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc#crear(utn.ofa.java.aa.rrhh.Empleado)
     */
    @Ignore
    public void testCrear() throws ParseException, SQLException {


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Alta Efectivo");

        EmpleadoDaoJdbc eDao = new EmpleadoDaoJdbc();
        Efectivo e = new Efectivo();
        Contratado c = new Contratado();


        e.setNombre("NataliaEfectiva");
        e.setCorreoElectronico("nstessens@justiciasantafe.gov.ar");
        e.setCuil("27-25966609-6");
        e.setFechaIngreso(formatter.parse("17/02/2010"));
        e.setHorasTrabajadas(10);
        e.setSueldoBasico(30000.0);
        e.setComisiones(300.0);
        e.setHorasObligatorias(8);

        assertTrue("Hubo un error al intentar dar de alta el empleado " + e.getNombre(), eDao.crear(e) > 0);


        c.setNombre("NataliaContratada");
        c.setCorreoElectronico("nstessens@justiciasantafe.gov.ar");
        c.setCuil("27-26376517-6");
        c.setFechaIngreso(formatter.parse("05/08/2016"));
        c.setHorasTrabajadas(10);
        c.setCostoHora(100);

        assertTrue("Hubo un error al intentar dar de alta el empleado " + c.getNombre(), eDao.crear(c) > 0);
    }


    /**
     * @see utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc#actualizar(utn.ofa.java.aa.rrhh.Empleado)
     */
    @Ignore
    public void testActualizar() throws ParseException, SQLException {

        EmpleadoDaoJdbc eDao = new EmpleadoDaoJdbc();
        Empleado e = eDao.buscarPorId(15);

        e.setNombre("NataliaContratada2");
        eDao.actualizar(e);

        assertTrue("Hubo un error al intentar actualizar el empleado 15", eDao.actualizar(e) > 0);
    }

    /**
     * @see utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc#eliminar(utn.ofa.java.aa.rrhh.Empleado)
     */
    @Ignore
    public void testEliminar() throws SQLException {
        EmpleadoDaoJdbc eDao = new EmpleadoDaoJdbc();
        Empleado e = eDao.buscarPorId(15);
        assertTrue("Error al eliminar el empleado 15 ", eDao.eliminar(e) > 0);
    }

    /**
     * 
     * @see utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc#buscarPorId(Integer)
     */
    @Ignore
    public void testBuscarPorId() throws SQLException {
        EmpleadoDaoJdbc eDao = new EmpleadoDaoJdbc();
        assertTrue("No se encuetra el empleado 1", eDao.buscarPorId(1) != null);
    }

    /**
     * @see utn.ofa.java.aa.rrhh.dao.EmpleadoDaoJdbc#buscarTodos()
     */
    @Test
    public void testBuscarTodos() throws SQLException {
        EmpleadoDaoJdbc eDao = new EmpleadoDaoJdbc();
        assertTrue("No se encuetran empleados ", eDao.buscarTodos().size() > 0);
    }


}
