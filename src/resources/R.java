package resources;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class R {
    
    public static final int GAP = 10;

    // String constans
    public static String STR_LOGIN_FORM_TITLE = "Ingreso de Usuarios",
            STR_USER = "Usuario",
            STR_USERS_MANAGEMENT = "Administración de Usuarios",
            STR_NEW_USER = "Nuevo Usuario",
            STR_PASSWORD = "Contraseña",
            STR_LOGIN = "Entrar",
            STR_CANCEL = "Cancelar";
    
    // Commands Constans
    public static String CMD_NEW_USER = "CMD_NEW_USER";
    
    // Icons constans
    public static final Icon ICON_PASSWORD = getIcon("password.png");

    private static Icon getIcon(String path) {
        URL resource = R.class.getResource("icons/" + path);
        if (resource == null) {
            // Log something...
            return null;
        }
        return new ImageIcon(resource);
    }
}
