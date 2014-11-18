package helpers.validation;

import java.awt.Component;
import javax.swing.JTextField;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ValidationHelper {
        
    public static final String LETTERS_ONLY = "^[\\\\p{L} .'-]+$";
    public static final String NUMBERS_ONLY = "^[0-9]+$";
    public static final String EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    public static boolean validate(Component comp, String rule){
        
        
        boolean validation = false;
        
        if( comp instanceof JTextField ){
            JTextField field = (JTextField) comp;
            
            if(field.getText().matches(rule)){
                getMessage(field.getName(), rule);
                return true;
            }
        }
        
        
        return validation;
    }
    
    private static String getMessage(String name, String rule){
        String message;
        switch(rule){
            case LETTERS_ONLY:
                return String.format(R.VALIDATION_LETTERS_ONLY, name);
            default:
                return String.format(R.VALIDATION_VALUE_NOT_ALLOWED, name);
        }
    }
    
}
