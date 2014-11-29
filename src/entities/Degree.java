package entities;

import java.io.Serializable;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class Degree implements Serializable{
    
    private int id;
    private String type;
    private String title;
    private float score;

    public Degree() {
    }

    public Degree(int id, String type, String title, float score) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.score = score;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
    
    
    
}
