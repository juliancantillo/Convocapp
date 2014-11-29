package dbhandler.dao;

import dbhandler.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entities.Role;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class RoleModel {

    private Connection conn;
    private DBConnector dbc;

    public RoleModel() {
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
    
    public Role read(int id) throws SQLException {
    Role rol = null;

    String sql = String.format("SELECT * FROM roles WHERE id=%s AND active = 1", id);

    Statement st;
    st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery(sql);

    rs.first();

    rol = new Role(
            rs.getInt("id"),
            rs.getString("name"));

    return rol;
  }

    public Role[] toArray() throws SQLException{
        ResultSet rs = read();
        rs.last();
        Role roles[] = new Role[rs.getRow()];
        rs.beforeFirst();
        while (rs.next()) {
            roles[rs.getRow() - 1] = new Role(
                    rs.getInt("id"),
                    rs.getString("name")
                );
        }

        return roles;
    }

}
