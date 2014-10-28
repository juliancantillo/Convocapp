package dbhandler.dao;

import dbhandler.DBConnector;
import entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class UserModel implements Model {

    private Connection conn;
    private DBConnector dbc;

    public UserModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    @Override
    public int create(Object obj) throws SQLException {
        User user = (User) obj;
        int id = 0; //st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
        user.setId(id);
        String insert = String.format("INSERT INTO `user` (`identification`, `username`, `password`, `email`, `firstname`, `lastname`, `address`, `phone`, `cellphone`, `active`) VALUES ('%s', '%s', MD5('%s'), '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                user.getIdentification(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getPhone(),
                user.getCellphone(),
                user.Estado_sql()
        );

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
//        Prueba de Mauricio Castillo
//        String test = "INSERT INTO `user` (`identification`, `username`, `password`, `email`, `firstname`, `lastname`, `address`, `phone`, `cellphone`) VALUES\n"
//                + "('14495546', 'pepe', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'pepe@gmail.com', 'Pepe', 'Perez', 'Calle 3 # 13 - 32', '3247598', '3197842535');";
//        System.out.println("Sql con problemas: " + insert);
        
        
        st.executeUpdate(insert);

        return id;

    }

    @Override
    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT id, firstname, lastname, email, active FROM user");

        if (rs != null) {
            return rs;
        }

        return null;
    }

    @Override
    public User read(int id) throws SQLException {
        User user = null;

        String sql = String.format("SELECT * FROM user WHERE users.id = '%s'", id);

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        if (rs.first()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getInt("active"),
                    rs.getString("identification"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("cellphone"),
                    rs.getTimestamp("create_time"),
                    rs.getTimestamp("update_time")
            );
        }

        return user;
    }

    @Override
    public void update(Object obj) throws SQLException {
        User user = (User) obj;

        String sql = String.format("UPDATE user SET identification='%s', firstname='%s', lastname='%s', address='%s' WHERE id = %s;",
                user.getIdentification(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getId()
        );
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(sql);

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = String.format("DELETE FROM user WHERE id = %s", id);

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(sql);

    }

    public User getByCredentials(String username, String password) throws SQLException {
        User user = null;

        String sql = String.format("SELECT * FROM user WHERE user.username = '%s' AND user.password = MD5('%s') AND user.active = 1", username, password);

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        if (rs.first()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getInt("active"),
                    rs.getString("identification"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("cellphone"),
                    rs.getTimestamp("create_time"),
                    rs.getTimestamp("update_time")
            );
        }

        return user;
    }
}
