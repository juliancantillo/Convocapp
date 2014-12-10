package entities;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ApplicantCourse {
    
    private int applicantId;
    private String institutionName;
    private City institutionCity;
    private String title;
    private String graduateYear;
    private int hours;
    private String notes;

    public ApplicantCourse() {
    }

    public ApplicantCourse(int applicantId, String institutionName, City institutionCity, String title, String graduateYear, int hours, String notes) {
        this.applicantId = applicantId;
        this.institutionName = institutionName;
        this.institutionCity = institutionCity;
        this.title = title;
        this.graduateYear = graduateYear;
        this.notes = notes;
        this.hours = hours;
    }
    
    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public float getScore(){
        float score = 0;
        
        if (this.hours <= 40 && this.hours > 0) {
            score = 4;
        }
        else if (this.hours <= 90 && this.hours > 40) {
            score = 6;
        }
        else if (this.hours <= 140 && this.hours > 90) {
            score = 8;
        }
        else if (this.hours > 140) {
            score = 10;
        }
        
        return score;
    }
    
    
}
