package dbhandler.dao;

import dbhandler.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ApplicantModel implements Model{
    
    private Connection conn;
    private DBConnector dbc;

    public ApplicantModel() {
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
        ResultSet rs = st.executeQuery(
                "SELECT a.id as id, CONCAT( a.identification_type, ' ', a.identification ) as identification , CONCAT( a.firstname, ' ', a.lastname) as fullname, a.company, c.name as city, u.firstname as created_by "
                + "FROM applicant as a "
                + "LEFT JOIN ( city as c, user as u ) ON ( a.city_id = c.id AND a.created_by_id = u.id )");

        if (rs != null) {
            return rs;
        }

        return null;
    }

    @Override
    public Object read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
