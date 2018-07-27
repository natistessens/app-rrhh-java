package utn.ofa.java.aa.rrhh.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionJDBC {
    
    private static final String USUARIO = "cursojava";
    private static final String PASSWORD = "cursojava";
    private static final String URL_CONEXION = "jdbc:mysql://172.16.64.197:3306/app-rrhh?useSSL=false";
    
    private static Connection _CONEXION;
    
    public ConexionJDBC() {
        super();
    }
    
    public static Connection getConexion() throws SQLException {
         if (_CONEXION == null) {
            _CONEXION = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
         }
            return _CONEXION;
     }
    
     public static void liberarConexion() throws SQLException {
         if (_CONEXION != null) {
            _CONEXION.close();
            _CONEXION = null;
         }
     }
}
