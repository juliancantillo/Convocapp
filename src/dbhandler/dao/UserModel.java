package dbhandler.dao;

import dbhandler.DBConnector;
import entities.Convocatory;
import entities.Municipios;
import entities.User;
import entities.Role;
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
        String insert = String.format("INSERT INTO `user` (`identification`, `username`, `password`, `email`, `firstname`, `lastname`, `address`, `phone`, `cellphone`, `active`, `roles_id`) VALUES ('%s', '%s', MD5('%s'), '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s);",
                user.getIdentification(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getPhone(),
                user.getCellphone(),
                user.getActive(),
                user.getRoleId()
        );

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
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

        String sql = String.format("SELECT * FROM user WHERE user.id = '%s'", id);

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        if (rs.first()) {
            
            RoleModel rolModel = new RoleModel();
            Role rol = rolModel.read( rs.getInt("roles_id") );
            
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

//            ResultSet rsRoles = st.executeQuery(rolesSql);
        }

        return user;
    }

    public Vector<Convocatory> readConvocatory(int start_date) throws SQLException {
        Convocatory user = null;
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
            user = new Convocatory(
                    rs.getInt("identificacion"),
                    rs.getString("name"),
                    rs.getBoolean("start_date"),
                    rs.getDate("start_time"),
                    rs.getDate("end_time"),
                    rs.getDate("publishing_date")
            );

            arrayconvocatory.add(user);
        }

        return arrayconvocatory;
    }

    public Vector<Municipios> readMunicipios() throws SQLException {
        Municipios user = null;
        String sql = "";
        /*Si start_date == 3 entoces extrae todas las convocatoria
         Si start_date == 0 entoces extrae todas las convocatoria no activa
         Si start_date == 1 entoces extrae todas las convocatoria activa
         */

        sql = String.format("SELECT * FROM `municipio` ");

        Vector<Municipios> arrayconvocatory = new Vector<>();

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            user = new Municipios(
                    rs.getInt("idmunicipio"),
                    rs.getString("nombreMunicipio")
 
            );

            arrayconvocatory.add(user);
        }

        return arrayconvocatory;
    }

    @Override
    public void update(Object obj) throws SQLException {
        User user = (User) obj;

        String sql = String.format("UPDATE user SET username='%s', identification='%s', email='%s', firstname='%s', lastname='%s', address='%s', phone='%s', cellphone='%s', active='%s' WHERE id = %s;",
                user.getUsername(),
                user.getIdentification(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getPhone(),
                user.getCellphone(),
                user.getActive(),
                user.getId()
        );
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(sql);

    }

    public void update(Object obj, String password) throws SQLException {
        User user = (User) obj;

        String sql = String.format("UPDATE user SET username='%s', identification='%s', email='%s', firstname='%s', lastname='%s', address='%s', phone='%s', cellphone='%s', active='%s', password=MD5('%s') WHERE id = %s;",
                user.getUsername(),
                user.getIdentification(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getPhone(),
                user.getCellphone(),
                user.getActive(),
                user.getPassword(),
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

    public User getByCredentials(String username, String password) throws SQLException, NullPointerException {
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
                    rs.getInt("roles_id"),
                    rs.getTimestamp("create_time"),
                    rs.getTimestamp("update_time")
            );
        }

        return user;
    }
    
    public int createConvocatory(Object obj) throws SQLException {

        //TODO: Remove from this class, this belongs to ConvocatoryModel Class!
        Convocatory convocatory = (Convocatory) obj;

        String sql = String.format("INSERT INTO `convocatory`(`name`,`open_time`,`closet_time`,`state`,`publication_date`) VALUES ('%s', '%s', '%s', '%s', '%s');",
        //String sql = String.format("INSERT INTO `convocatory`(`name`,`start_date`,`end_date`,`active`,`publishing_date`,`description`) VALUES ('%s', '%s', '%s', %s, '%s','%s');",

                convocatory.getName_convocatory(),
                convocatory.getOpen_time(),
                convocatory.getCloset_time(),
                convocatory.isState(),
                convocatory.getPublicacion_time(),
                convocatory.getDescription()
        );
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.executeUpdate(sql);

        return 0;
    }

    /**
     * 
     * @author Mauro Castillo
     * @param usuario
     * @return int rol_id
     * @throws SQLException 
     */
    public int getUserRole(User usuario) throws SQLException {
        /*Mauro Castillo
         Esta funcion recibe un objeto de tipo usuario y retorna su roll en el sistema*/
        int id_usuario = usuario.getId();
        int userRole = 0;
        String sql = String.format("SELECT roles.* FROM roles, user WHERE user.id = %s AND roles.id = user.roles_id", id_usuario);

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);
        if (rs.first()) {
            userRole = rs.getInt("roles_id");
        }
        return userRole;
    }

}
