package utn.ofa.java.aa.rrhh_test;

import static org.junit.Assert.*;
import org.junit.Test;

import utn.ofa.java.aa.rrhh.Efectivo;

public class EfectivoTest {
    public EfectivoTest() {
    }
    /**
     * Test of salario method, of class Efectivo.
     */
     @Test
     public void testSalarioSinHorasExtras() {
     System.out.println("salario");
     Efectivo empleado = new Efectivo();
     empleado.setHorasTrabajadas(40);
     empleado.setHorasObligatorias(40);
     empleado.setComisiones(2000.0);
     empleado.setSueldoBasico(30000.0);
     Double expResult = 30000.0+2000.0;
     Double result = empleado.salario();
     assertEquals(expResult, result);
     }

     /**
     * Test of salario method, of class Efectivo.
     */
     @Test
     public void testSalario2HorasExtras() {
     System.out.println("salario");
     Efectivo empleado = new Efectivo();
     empleado.setHorasTrabajadas(42);
     empleado.setHorasObligatorias(40);
     empleado.setComisiones(2000.0);
     empleado.setSueldoBasico(30000.0);
     Double expResult = 30000.0+2000.0+3000.0;
     Double result = empleado.salario();
     assertEquals(expResult, result);
     }


}
