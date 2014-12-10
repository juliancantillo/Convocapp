package helpers.validation;

import exceptions.FieldIsNotValidException;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.Border;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ValidationHelper{
        
    public static final String LETTERS_ONLY = "^\\p{L}+(?: \\p{L}+)*$";
    public static final String NUMBERS_ONLY = "^[0-9]+$";
    public static final String EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    public static final String REQUIRED = "REQUIRED";
    private static final ValidationListener validationListener = new ValidationListener();
        
    private static String getMessage(String name, String rule){
        switch(rule){
            case LETTERS_ONLY:
                return String.format(R.VALIDATION_LETTERS_ONLY, name);
            default:
                return String.format(R.VALIDATION_VALUE_NOT_ALLOWED, name);
        }
    }
    
    public static boolean validate(Component comp, String rule) throws FieldIsNotValidException{
        if( comp instanceof JTextField ){
            JTextField field = (JTextField) comp;
            
            if (REQUIRED.equals(rule) && !"".equals(field.getText())) {
                System.out.println(String.format("Validation %s with rule %s is %s", field.getName(), rule, true));
                return true;
            }else if(field.getText().matches(rule)){
                getMessage(field.getName(), rule);
                System.out.println(String.format("Validation %s with rule %s is %s", field.getName(), rule, true));
                return true;
            }else{
                field.addFocusListener(validationListener);
                field.setBorder(BorderFactory.createLineBorder(Color.red));
                field.setToolTipText(getMessage(field.getName(), rule));
                throw new FieldIsNotValidException( getMessage(field.getName(), rule) );
            }
        }
        if( comp instanceof JComboBox ){
            JComboBox field = (JComboBox) comp;
            
            if(rule.equals(ValidationHelper.REQUIRED) && "".equals(field.getSelectedItem().toString()) ){
                field.addFocusListener(validationListener);
                field.setBorder(BorderFactory.createLineBorder(Color.red));
                field.setToolTipText(getMessage(field.getName(), rule));
                throw new FieldIsNotValidException( getMessage(field.getName(), rule) );
            }else{
                System.out.println(String.format("Validation %s with rule %s is %s", field.getName(), rule, true));
                return true;
            }
        }
        
        return false;
    }
    
}

class ValidationListener implements FocusListener{

    @Override
    public void focusGained(FocusEvent e) {
        Component comp = e.getComponent();
        if( comp instanceof JTextField ){
            JTextField field = (JTextField) comp;
            field.setBorder(R.getDefaultBorder());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
}
