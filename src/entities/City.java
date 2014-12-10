package entities;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class City {

    private final int id, state_id;
    private final String name;
    private final String code;
    private final State state;

    public City(int id, int state_id, String name, String code, State state) {
        this.id = id;
        this.state_id = state_id;
        this.name = name;
        this.code = code;
        this.state = state;
    }
    
    public int getId() {
        return id;
    }

    public int getState_id() {
        return state_id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.getState().getName() + ')';
    } 
}