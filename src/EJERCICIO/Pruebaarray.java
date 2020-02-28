package EJERCICIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pruebaarray {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Android?user=root&password=mysqladmin";
            Connection conect = DriverManager.getConnection(url);
            Statement statement = conect.createStatement();
            String query = "select * from Dispositivo";
            ResultSet resulset = statement.executeQuery(query);
            while (resulset.next()) {
                //int idproducto = resulset.getInt("id_producto");
                String des_dispositivo = resulset.getString("des_dispositivo");
                int precio = resulset.getInt("precio");
               // System.out.println("id"+idproducto);
                System.out.println("des_dispositivo"+des_dispositivo);
                System.out.println("precio"+precio);
                System.out.println("------------------------------");
            }
            resulset.close();
            statement.close();
            conect.close();
        } catch (Exception e) {
        }

    }
}
