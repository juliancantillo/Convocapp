package resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
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
            STR_PASSWORD_CONFIRM = "Confirmar Contraseña",
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
            STR_UPDATE_TIME = "Fecha de Actualización",
            STR_PERSONAL_INFO = "Información Personal",
            STR_LOGIN_INFO = "Información de Ingreso",
            STR_SAVE = "Guardar";

    // String Errors
    public static final String ERROR_LOAD_DATA_FAILS = "Error al cargar los registros de la base de datos",
            ERROR_LOGIN_FAILS = "Error al iniciar sesión.\n\nDescipción: %s",
            ERROR_LOGIN_FAILS_PASSWORD_OR_USER = "Usuario o contraseña incorrectos, intente de nuevo\n\nSi no recuerda su información de ingreso comuniquese con el Administrador",
            ERROR_LOGIN_NULL_CREDENTIALS = "Usuario o contraseña vacío, por favor ingrese su información de logueo";

    // Columns Names
    public static String[] SRT_USERS_COLUMNS = {STR_ID, STR_FIRSTNAME, STR_LASTNAME, STR_EMAIL, STR_ACTIVE};
    public static String[] SRT_USERS_COLUMNS_FULL = {STR_ID, STR_IDENTIFICATION, STR_USERNAME, STR_PASSWORD, STR_EMAIL, STR_FIRSTNAME, STR_LASTNAME, STR_ADDRESS, STR_PHONE, STR_CELLPHONE, STR_ACTIVE, STR_CREATE_TIME, STR_UPDATE_TIME};

    // Commands Constans
    public static final String CMD_NEW_USER = "CMD_NEW_USER";
    public static final String CMD_LOGIN = "CMD_LOGIN";
    public static final String CMD_CANCEL = "CMD_CANCEL";
    public static final String CMD_SAVE = "CMD_SAVE";

    // Roles
    public static final String ROL_ADMINISTRATOR = "Administrador";

    // Icons constans
    public static final ImageIcon ICON_PASSWORD = getIcon("password.png");
    public static final ImageIcon ICON_PASSWORD_SMALL = getIcon("password-24x24.png");
    public static final ImageIcon ICON_UNLOCK = getIcon("lock-open.png");
    public static final ImageIcon ICON_UNLOCK_SMALL = getIcon("lock-open-24x24.png");
    public static final ImageIcon ICON_ADD_USER = getIcon("add-user.png");
    public static final ImageIcon ICON_ADD_USER_SMALL = getIcon("add-user-24x24.png");
    public static final ImageIcon ICON_USERS = getIcon("users.png");
    public static final ImageIcon ICON_USERS_SMALL = getIcon("users-24x24.png");
    public static final ImageIcon ICON_SAVE = getIcon("save.png");
    public static final ImageIcon ICON_SAVE_SMALL = getIcon("save-24x24.png");
    public static final ImageIcon ICON_CANCEL = getIcon("error.png");
    public static final ImageIcon ICON_CANCEL_SMALL = getIcon("error-24x24.png");
    public static final ImageIcon ICON_CHECK = getIcon("check.png");
    public static final ImageIcon ICON_CHECK_SMALL = getIcon("check-24x24.png");

    private static ImageIcon getIcon(String path) {
        URL resource = R.class.getResource("icons/" + path);
        if (resource == null) {
            // Log something...
            return null;
        }
        return new ImageIcon(resource);
    }
}
