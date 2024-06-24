package modelo.persistencia.JDBC;

import java.sql.*;

public class Persistencia {

    private static String login = "root";
    private static String password = "1748";

    private static String url = "jdbc:mysql://localhost:3306/facturacion?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=false";
    
    private static Connection conexion=null;
    
    public static Connection createConnection(){
        if (conexion==null){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();                
                //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conexion=DriverManager.getConnection(url,login,password);
            }catch(ClassNotFoundException e){System.out.println(e);
            }catch(SQLException e){System.out.println(e);
            }catch(java.lang.InstantiationException e){System.out.println(e);
            }catch(java.lang.IllegalAccessException e){System.out.println(e);}
        }
        return conexion;
    }
    
    public static void closeConnection(){
        try{
            if(conexion!=null){
                conexion.close();
                conexion=null;
            }
        }catch(SQLException e){System.out.println(e);}
    }
    
}
