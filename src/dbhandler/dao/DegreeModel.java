package dbhandler.dao;

import dbhandler.DBConnector;
import entities.ApplicantDegree;
import entities.Degree;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class DegreeModel implements Model{
    
    private final Connection conn;
    private final DBConnector dbc;

    public DegreeModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    @Override
    public int create(Object obj) throws SQLException {
        ApplicantDegree applicantDegree = (ApplicantDegree) obj;
        String insert = String.format("INSERT INTO `applicant_has_degree` "
                + "(`applicant_id`, `degree_id`, `institution_name`, `institution_city_id`, `title`, `graduate_year`, `notes`, `files_id`) "
                + "VALUES (%s, %s, %s, %s, %s, %s, %s, NULL);",
                applicantDegree.getApplicantId(),
                applicantDegree.getDegree().getId(),
                applicantDegree.getInstitutionName(),
                applicantDegree.getInstitutionCity().getId(),
                applicantDegree.getTitle(),
                applicantDegree.getGraduateYear(),
                applicantDegree.getNotes()
                );
        
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
    }

    @Override
    public ResultSet read() throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM applicant_has_degree");

        if (rs != null) {
            return rs;
        }

        return null;
    }
    
    public ResultSet read(String query) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);

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
    
    public Degree[] toArray() throws SQLException{
        ResultSet rs = read("SELECT * FROM degree");
        rs.last();
        Degree degrees[] = new Degree[rs.getRow()];
        rs.beforeFirst();
        while (rs.next()) {
            degrees[rs.getRow() - 1] = new Degree(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("title"),
                    rs.getFloat("score")
                );
        }

        return degrees;
    }
    
    
    
}