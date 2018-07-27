package utn.ofa.java.aa.rrhh;

public class Contratado extends Empleado{
    
    Integer costoHora;
    
    public Contratado() {
        super();
    }


    @Override
    public Double salario() {
        Double salario=costoHora.doubleValue()*horasTrabajadas;
        return salario;
    }

    public void setCostoHora(Integer costoHora) {
        this.costoHora = costoHora;
    }

    public Integer getCostoHora() {
        return costoHora;
    }
    @Override
    public boolean esContratado() { return true; } 

    @Override
    public boolean esEfectivo() { return false; } 

}
