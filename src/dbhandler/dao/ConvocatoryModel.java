package dbhandler.dao;

import dbhandler.DBConnector;
import entities.Convocatory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class ConvocatoryModel implements Model {

    private final Connection conn;
    private final DBConnector dbc;

    public ConvocatoryModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    @Override
    public int create(Object obj) throws SQLException {
        Convocatory convocatory = (Convocatory) obj;
        String sql = String.format("INSERT INTO `convocatory`(`name`,`start_date`,`end_date`,`active`,`publishing_date`, `description` ) VALUES ('%s', '%s', '%s', '%s', '%s','%s');",
                convocatory.getName_convocatory(),
                convocatory.getOpen_time(),
                convocatory.getCloset_time(),
                convocatory.isState(),
                convocatory.getPublicacion_time(),
                convocatory.getDescription()
        );
    
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        return st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
    }

    @Override
    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT id, name, start_date, end_date, active, description  FROM convocatory");

        if (rs != null) {
            return rs;
        }

        return null;
    }
    /**/

    public Vector<Convocatory> readConvocatory(int start_date) throws SQLException {
        Convocatory convocatory = null;
        String sql = "";
        /*Si start_date == 3 entoces extrae todas las convocatoria
         Si start_date == 0 entoces extrae todas las convocatoria no activa
         Si start_date == 1 entoces extrae todas las convocatoria activa
         */
        if (start_date == 3) {
            sql = String.format("SELECT * FROM `convocatory`");
        }
        if (start_date == 0) {
            sql = String.format("SELECT * FROM `convocatory` WHERE start_date = 0");
        }
        if (start_date == 1) {
            sql = String.format("SELECT * FROM `convocatory` WHERE start_date = 1");
        }

        Vector<Convocatory> arrayconvocatory = new Vector<>();

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            convocatory = new Convocatory(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("active"),
                    rs.getDate("start_time"),
                    rs.getDate("end_time"),
                    rs.getDate("publishing_date"),
                    rs.getString("description")
            );

            arrayconvocatory.add(convocatory);
        }

        return arrayconvocatory;
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
