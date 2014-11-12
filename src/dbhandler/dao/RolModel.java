package dbhandler.dao;

import dbhandler.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entities.Rol;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class RolModel {

    private Connection conn;
    private DBConnector dbc;

    public RolModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT id, name FROM roles");

        if (rs != null) {
            return rs;
        }

        return null;
    }
    
    public Rol read(int id) throws SQLException {
    Rol rol = null;

    String sql = String.format("SELECT * FROM roles WHERE id=%s AND active = 1", id);

    Statement st;
    st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery(sql);

    rs.first();

    rol = new Rol(
            rs.getInt("id"),
            rs.getString("name"));

    return rol;
  }

    public Rol[] toArray() throws SQLException{
        ResultSet rs = read();
        rs.last();
        Rol roles[] = new Rol[rs.getRow()];
        rs.beforeFirst();
        while (rs.next()) {
            roles[rs.getRow() - 1] = new Rol(
                    rs.getInt("id"),
                    rs.getString("name")
                );
        }

        return roles;
    }

}
