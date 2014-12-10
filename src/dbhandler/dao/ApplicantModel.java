package dbhandler.dao;

import controller.Convocapp;
import dbhandler.DBConnector;
import entities.Applicant;
import entities.ApplicantCourse;
import entities.ApplicantDegree;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class ApplicantModel implements Model {

    private Connection conn;
    private DBConnector dbc;

    public ApplicantModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    @Override
    public int create(Object obj) throws SQLException {
        Applicant applicant = (Applicant) obj;

        String insert = String.format("INSERT INTO `applicant` "
                + "( `identification`, `identification_type`, `email`, `firstname`, `lastname`, `birthdate`, `sex`, "
                + "`address`, `phone`, `cellphone`, `company`, `company_city_id`, `company_address`, `company_phone`, "
                + "`working_time`, `active`, `city_id`, `created_by_id`) "
                + "VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, '%s', '%s', '%s', %s, %s, %s);",
                applicant.getIdentification(),
                applicant.getIdentificationType(),
                applicant.getEmail(),
                applicant.getFirstname(),
                applicant.getLastname(),
                applicant.getBirthdate(),
                applicant.getSex(),
                applicant.getAddress(),
                applicant.getPhone(),
                applicant.getCellphone(),
                applicant.getCompany(),
                applicant.getCompanyCityId(),
                applicant.getCompanyAddress(),
                applicant.getCompanyPhone(),
                applicant.getWorkingTime(),
                applicant.getActive(),
                applicant.getCityId(),
                Convocapp.loggedUser.getId()
        );

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
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
        String sql = String.format("SELECT "
                + "a.id as id, identification, identification_type, email, firstname, lastname, birthdate, sex, "
                + "address, phone, cellphone, company, company_city_id, company_address, company_phone, "
                + "working_time, active, city_id, created_by_id, create_time, update_time, totalScore, "
                + "c.name as city_name, cc.name as company_city_name "
                + "FROM applicant as a "
                + "LEFT JOIN ( city as c ) ON ( c.id = a.city_id ) "
                + "LEFT JOIN ( city as cc ) ON ( cc.id = a.company_city_id ) "
                + "WHERE a.id = %s", id);
        Applicant applicant = null;

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        if (rs.first()) {
            applicant = new Applicant(
                    rs.getString("identification"),
                    rs.getString("identification_type"),
                    rs.getString("email"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getTimestamp("birthdate"),
                    rs.getString("sex"),
                    rs.getInt("city_id"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("cellphone"),
                    rs.getString("company"),
                    rs.getInt("company_city_id"),
                    rs.getString("company_address"),
                    rs.getString("company_phone"),
                    rs.getString("working_time"),
                    rs.getInt("created_by_id"),
                    rs.getString("city_name"),
                    rs.getString("company_city_name")
            );
            applicant.setId( rs.getInt("id") );
        }
        //Applicant( Timestamp birthdate, String sex, int cityId, String address, String phone, String 
        //, String company, int companyCityId, String companyAddress, String companyPhone, String workingTime,
        //int createdById, String cityName, String companyCityName)
        return applicant;
    }

    @Override
    public void update(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet getDegreeInformation(int id) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(String.format(
                "SELECT a.id, d.score, d.title as degree_title, a.institution_name, a.graduate_year FROM applicant_has_degree as a "
                + "LEFT JOIN degree as d ON ( d.id = a.degree_id ) WHERE a.applicant_id = %s", id));

        if (rs != null) {
            return rs;
        }

        return null;
    }
    
    public int insertDegreeInformation(ApplicantDegree degree) throws SQLException {
        String insert = String.format("INSERT INTO `convocapp`.`applicant_has_degree` "
                + "(`applicant_id`, `degree_id`, `institution_name`, `institution_city_id`, `title`, `graduate_year`, `notes`) "
                + "VALUES (%s, %s, '%s', %s, '%s', '%s', '%s');",
                degree.getApplicantId(),
                degree.getDegree().getId(),
                degree.getInstitutionName(),
                degree.getInstitutionCity().getId(),
                degree.getTitle(),
                degree.getGraduateYear(),
                degree.getNotes()
        );

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
    }
    
    public ResultSet getCourseInformation(int id) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(String.format(
                "SELECT applicant_id, score, title, institution, graduate_year, hours FROM applicant_has_course as a WHERE a.applicant_id = %s", id));
        
        if (rs != null) {
            return rs;
        }

        return null;
    }
    
    public int insertCourseInformation(ApplicantCourse course) throws SQLException {
        String insert = String.format("INSERT INTO `convocapp`.`applicant_has_course` "
                + "(`applicant_id`, `title`, `institution`, `institution_city_id`, `hours`, `graduate_year`, `score`) "
                + "VALUES (%s, '%s', '%s', %s, %s, '%s', %s);",
                course.getApplicantId(),
                course.getTitle(),
                course.getInstitutionName(),
                course.getInstitutionCity().getId(),
                course.getHours(),
                course.getGraduateYear(),
                course.getScore()
        );

        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
    }

}
