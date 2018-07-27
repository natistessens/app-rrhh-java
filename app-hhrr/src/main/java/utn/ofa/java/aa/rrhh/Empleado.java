package utn.ofa.java.aa.rrhh;

import java.util.Date;
import java.util.Deque;
import java.util.NavigableMap;

public abstract class Empleado{
    Integer id;
    String nombre;
    String correoElectronico;
    String cuil;
    Date fechaIngreso;
    Integer horasTrabajadas;
    
    public Empleado() {
        super();
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getCuil() {
        return cuil;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public abstract Double salario();
    
    public abstract boolean esEfectivo();
    
    public abstract boolean esContratado();
    
    
    public static void main(String[] args) {
    }
}
