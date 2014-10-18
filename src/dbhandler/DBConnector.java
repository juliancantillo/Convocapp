package dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class DBConnector {

  private final String host;
  private final String user;
  private final String password;
  private final String port;
  private final String database;
  private final String url;

  public DBConnector() {
    this.host = "localhost";
    this.database = "convocapp";
    this.password = "";
    this.user = "root";
    this.port =  "3306";
    
    this.url = String.format("jdbc:mysql://%s:%s/%s", this.host, this.port, this.database);
  }

  public DBConnector(String host, String port, String database, String user, String password) {
    this.host = host;
    this.user = user;
    this.password = password;
    this.port = port;
    this.database = database;
    
    this.url = String.format("jdbc:mysql://%s:%s/%s", this.host, this.port, this.database);
  }
  
  public Connection connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("MySQL driver not found");
      return null;
    }

    Connection connection;

    try {
      connection = DriverManager.getConnection(this.url, this.user,this.password);
    } catch (SQLException e) {

      System.out.println("Connection Failed! Check output console " + e.getMessage());
      return null;

    }
    
    return connection;
  }
  
  public void close(Connection con){
    try {
      con.close();
    } catch (SQLException ex) {
      System.out.println("Closing connection failed " + ex.getMessage());
    }
  }

}