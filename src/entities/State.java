package entities;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class State{
    
    private final int id;
    private final String name;
    private final String code;

    public State(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.name;
    }
}