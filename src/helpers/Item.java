package helpers;

import java.io.Serializable;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class Item implements Serializable{
    
    private String key;
    private Object value;

    public Item(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
