package utn.ofa.java.aa.rrhh;

public class Efectivo extends Empleado{
    
    Double sueldoBasico=null;
    Double comisiones=null;

    Integer horasObligatorias=null;

    
    public Efectivo() {
        super();
    }


    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setComisiones(Double comisiones) {
        this.comisiones = comisiones;
    }

    public Double getComisiones() {
        return comisiones;
    }

    public void setHorasObligatorias(Integer horasObligatorias) {
        this.horasObligatorias = horasObligatorias;
    }

    public Integer getHorasObligatorias() {
        return horasObligatorias;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }



    @Override
    public Double salario() {
        Double salario;
        if (horasTrabajadas > horasObligatorias){ 
         salario= sueldoBasico + comisiones + montoHorasExtras();}
        else{
            salario= sueldoBasico + comisiones;}
       
        return salario;
    }
    
    public Double montoHorasExtras(){
        Double montoHorasExtras= (sueldoBasico/20)*(horasTrabajadas - horasObligatorias);
        return montoHorasExtras;
    }
    
    public boolean esEfectivo() { return true; }

    public boolean esContratado() { return false; } 

}
