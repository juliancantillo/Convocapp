package dbhandler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public interface Model {
    
  public int create( Object obj ) throws SQLException;
  public ResultSet read() throws SQLException;
  public Object read( int id ) throws SQLException;
  public void update( Object obj ) throws SQLException;
  public void delete( int id ) throws SQLException;
  
}