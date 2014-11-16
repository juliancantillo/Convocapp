package entities;

import java.io.Serializable;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class Role implements Serializable{
    
    private Integer id, active;
    private String name;

    public Role(Integer id, Integer active, String name) {
        this.id = id;
        this.active = active;
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}