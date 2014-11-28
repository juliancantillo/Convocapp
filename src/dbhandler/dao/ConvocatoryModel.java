package dbhandler.dao;

import dbhandler.DBConnector;
import entities.Convocatory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ConvocatoryModel implements Model{

    private final Connection conn;
    private final DBConnector dbc;

    public ConvocatoryModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }
    
    @Override
    public int create(Object obj) throws SQLException {
        Convocatory convocatory = (Convocatory)obj;
        String sql = String.format("INSERT INTO `convocatory`(`name`,`open_time`,`closet_time`,`state`,`publication_date`) VALUES ('%s', '%s', '%s', '%s', '%s');",
                convocatory.getName_convocatory(),
                convocatory.getOpen_time(),
                convocatory.getCloset_time(),
                convocatory.isState(),
                convocatory.getPublicacion_time()
        );
        
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        return st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
    }

    @Override
    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT id, name, start_date, end_date, active FROM convocatory");

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
