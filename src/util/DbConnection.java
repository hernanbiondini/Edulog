/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.DatabaseMetaData;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    static String bd = "";
    static String login = "";
    static String password = "";
    static String url = "";  
    static DatabaseMetaData metadatos;
    Connection connection = null;

    public DbConnection() throws SQLException, ClassNotFoundException {
        this.conf();
        this.conectar();
    }

    public static String getBd() {
        return bd;
    }

    public static void setBd(String bd) {
        DbConnection.bd = bd;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        DbConnection.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DbConnection.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DbConnection.url = url;
    }

    public static DatabaseMetaData getMetadatos() {
        return metadatos;
    }

    public static void setMetadatos(DatabaseMetaData metadatos) {
        DbConnection.metadatos = metadatos;
    }

    public List<String> catalogs() throws SQLException {
        List<String> catalogs = null;
        ResultSet catalogos = metadatos.getCatalogs();
        catalogs = new ArrayList<String>();
        while (catalogos.next()) {
            //System.out.println(catalogos.getString(1));
            String cat = catalogos.getString(1);
            if (cat.equals("information_schema") || cat.equals("mysql") || cat.equals("performance_schema")) {
               // nada
            }else{
                 catalogs.add(catalogos.getString(1));
            }
        }
        return catalogs;
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() throws SQLException, SQLException, SQLException, SQLException {
        connection = null;
    }

    public void crearBase(String base) throws SQLException {
            String Query = "CREATE DATABASE " + base;
            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            System.out.println("Se ha creado la base de datos " + bd + " de forma exitosa");
    }

    public void borrarBase(String base) throws SQLException {
            String Query = "DROP DATABASE " + base;
            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            System.out.println("Se ha borrado la base de datos " + bd + " de forma exitosa");
    }
    
    public void conectar() throws SQLException, ClassNotFoundException {
            conf();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            metadatos = (DatabaseMetaData) connection.getMetaData();
            if (connection != null) {
                System.out.println("Conexión a servidor " + " OK\n");
            }
    }   
    
     public void conf() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("conf.ini"));
            setLogin(p.getProperty("Usuario"));
            setPassword(p.getProperty("Password"));
            setBd(p.getProperty("Base"));
            setUrl(p.getProperty("Ruta"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     

}
