package EJERCICIO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JavaMysql {

    public static void main(String[] args) {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Android?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(url);
            Statement statement = connect.createStatement();
            String query = "SELECT * FROM Dispositivo";
            ResultSet resultSet = statement.executeQuery(query);
            String format = "|%1$-3d|%2$-17s|%3$-5d\n";
            while(resultSet.next()) {
                String des_dispositivo = resultSet.getString("des_dispositivo");
                int precio = resultSet.getInt("precio");
                String tipo=resultSet.getString("tipo");
                System.out.format(format,des_dispositivo, precio,tipo);
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("¿Qué deseas hacer: INSERTAR / BORRAR / CONSULTAR / ACTUALIZAR ?");
            String accion = scan.nextLine();
            if(accion.equals("INSERTAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el des_dispositivo");
                String id_dispositivo = scan.nextLine();
               
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                int precio = scan.nextInt();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String tipo = scan.nextLine();
                
                query = "{call insertar_dispositivo(?, ?, ?, ?)}";
                CallableStatement stmt = connect.prepareCall(query);
                stmt.setInt(1,Integer.parseInt(id_dispositivo));
                stmt.setInt(3, precio);
                stmt.setString(4, tipo); 
                stmt.execute();

            } else if (accion.equals("BORRAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el id_dispositivo");
                String des_dispositivo = scan.nextLine();
                
                query = "{call eliminar_dispositivo(?)}";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(des_dispositivo));
                ps.executeUpdate();
            } else if (accion.equals("ACTUALIZAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el des_dispositivo");
                String  des_dispositivo = scan.nextLine();
                
   
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                int precio = scan.nextInt();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String tipo = scan.nextLine();
                
                query = "{call actualizar_dispositivo(?,?,?,?)}";
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setInt(1,Integer.parseInt(des_dispositivo));
                stmt.setInt(2, precio);
                stmt.setString(3, tipo); 
                stmt.execute();
            }
            resultSet.close();
            statement.close();
            connect.close();
            System.err.println(e);
                
            } catch (Exception e) {
            }
        }
      }
    }
}