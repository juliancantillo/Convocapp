package dbhandler.dao;

import dbhandler.DBConnector;
import entities.City;
import entities.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class LocationModel implements Model{
    
private final Connection conn;
    private final DBConnector dbc;

    public LocationModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }
    
    @Override
    public int create(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM city");

        if (rs != null) {
            return rs;
        }

        return null;
    }

    @Override
    public Object read(int id) throws SQLException {
        City city = null;

        String sql = String.format("SELECT city.*, s.name as state_name, s.id as state_id, s.code as state_code FROM city, state as s WHERE city.id = '%s' AND city.state_id = s.id", id);

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        if (rs.first()) {          
            city = new City(
                    rs.getInt("id"),
                    rs.getInt("state_id"),
                    rs.getString("name"),
                    rs.getString("code"),
                    new State( rs.getInt("state_id"), rs.getString("state_name"), rs.getString("state_code") )
                );
        }

        return city;
    }

    @Override
    public void update(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
