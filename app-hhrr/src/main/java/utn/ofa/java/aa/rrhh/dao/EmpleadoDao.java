package utn.ofa.java.aa.rrhh.dao;

import java.sql.SQLException;

import java.util.List;

import utn.ofa.java.aa.rrhh.Empleado;

public interface EmpleadoDao{

    public int crear(Empleado e) throws SQLException;

    public int actualizar(Empleado e) throws SQLException;

    public int eliminar(Empleado e) throws SQLException;

    public Empleado buscarPorId(Integer id) throws SQLException;

    public List<Empleado> buscarTodos() throws SQLException;

}
