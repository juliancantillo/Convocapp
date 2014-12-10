package entities;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ApplicantDegree {
    
    private int applicantId;
    private Degree degree;
    private String institutionName;
    private City institutionCity;
    private String title;
    private String graduateYear;
    private String notes;

    public ApplicantDegree() {
    }

    public ApplicantDegree(int applicantId, Degree degree, String institutionName, City institutionCity, String title, String graduateYear, String notes) {
        this.applicantId = applicantId;
        this.degree = degree;
        this.institutionName = institutionName;
        this.institutionCity = institutionCity;
        this.title = title;
        this.graduateYear = graduateYear;
        this.notes = notes;
    }
    
    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public City getInstitutionCity() {
        return institutionCity;
    }

    public void setInstitutionCity(City institutionCity) {
        this.institutionCity = institutionCity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    } 
    
}