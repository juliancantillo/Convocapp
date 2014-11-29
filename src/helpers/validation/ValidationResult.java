package helpers.validation;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ValidationResult {
    private final boolean valid;
    private final String message;

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }
    
    
}
