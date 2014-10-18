package resources;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class R {

    public static final int GAP = 10, H = 10, W = 10;

    // String constans
    public static final String STR_LOGIN_FORM_TITLE = "Ingreso de Usuarios",
            STR_USER = "Usuario",
            STR_USERS_MANAGEMENT = "Administración de Usuarios",
            STR_NEW_USER = "Nuevo Usuario",
            STR_PASSWORD = "Contraseña",
            STR_LOGIN = "Entrar",
            STR_ERROR = "Error",
            STR_CANCEL = "Cancelar",
            STR_ID = "Id",
            STR_IDENTIFICATION = "Cédula",
            STR_USERNAME = "Usuario",
            STR_EMAIL = "Correo Eléctronico",
            STR_FIRSTNAME = "Nombre",
            STR_LASTNAME = "Apellido",
            STR_ADDRESS = "Dirección",
            STR_PHONE = "Teléfono",
            STR_CELLPHONE = "Celular",
            STR_ACTIVE = "Activo",
            STR_CREATE_TIME = "Fecha de Creación",
            STR_UPDATE_TIME = "Fecha de Actualización";

    // String Errors
    public static final String 
            ERROR_LOAD_DATA_FAILS = "Error al cargar los registros de la base de datos",
            ERROR_LOGIN_FAILS = "Error al iniciar sesión.\n\nDescipción: %s",
            ERROR_LOGIN_NULL_CREDENTIALS = "Usuario o contraseña vacío, por favor ingrese su información de logueo";

    // Columns Names
    public static String[] SRT_USERS_COLUMNS = {STR_ID, STR_FIRSTNAME, STR_LASTNAME, STR_EMAIL, STR_ACTIVE};
    public static String[] SRT_USERS_COLUMNS_FULL = {STR_ID, STR_IDENTIFICATION, STR_USERNAME, STR_PASSWORD, STR_EMAIL, STR_FIRSTNAME, STR_LASTNAME, STR_ADDRESS, STR_PHONE, STR_CELLPHONE, STR_ACTIVE, STR_CREATE_TIME, STR_UPDATE_TIME};

    // Commands Constans
    public static final String CMD_NEW_USER = "CMD_NEW_USER";

    // Roles
    public static final String ROL_ADMINISTRATOR = "Administrador";

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
