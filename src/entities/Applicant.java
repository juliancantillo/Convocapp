package entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class Applicant implements Serializable {

    private int id;
    private int active;
    private String identification;
    private String identificationType;
    private String email;
    private String firstname;
    private String lastname;
    private Timestamp birthdate;
    private String sex;
    private int cityId;
    private String address;
    private String phone;
    private String cellphone;
    private String company;
    private int companyCityId;
    private String companyAddress;
    private String companyPhone;
    private String workingTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int createdById;
    
    private String cityName;
    private String companyCityName;

}
