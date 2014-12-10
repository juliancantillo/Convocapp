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
    
    private City city;
    private City companyCity;

    public Applicant(String identification, String identificationType, String email, String firstname, String lastname, Timestamp birthdate, String sex, int cityId, String address, String phone, String cellphone, String company, int companyCityId, String companyAddress, String companyPhone, String workingTime, int createdById, String cityName, String companyCityName) {
        this.identification = identification;
        this.identificationType = identificationType;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.cityId = cityId;
        this.address = address;
        this.phone = phone;
        this.cellphone = cellphone;
        this.company = company;
        this.companyCityId = companyCityId;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.workingTime = workingTime;
        this.createdById = createdById;
        this.cityName = cityName;
        this.companyCityName = companyCityName;
        
    }

    public Applicant() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCompanyCityId() {
        return companyCityId;
    }

    public void setCompanyCityId(int companyCityId) {
        this.companyCityId = companyCityId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCompanyCityName() {
        return companyCityName;
    }

    public void setCompanyCityName(String companyCityName) {
        this.companyCityName = companyCityName;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s %s", this.id, this.firstname, this.lastname);
    }
}