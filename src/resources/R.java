package resources;

import helpers.Item;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class R {

    public static final int GAP = 10, H = 10, W = 10;

    // String constans
    public static final 
            String STR_LOGIN_FORM_TITLE = "Ingreso de Usuarios",
            STR_NEW_CONVOCATORY = "Crear nueva convocatoria",
            STR_USER = "Usuario",
            STR_USERS_MANAGEMENT = "Administración de Usuarios",
            STR_APPLICANT_MANAGEMENT = "Administración de Aspirantes",
            STR_NEW_USER = "Nuevo Usuario",
            STR_EDIT_USER = "Editar Usuario",
            STR_PASSWORD = "Contraseña",
            STR_PASSWORD_CONFIRM = "Confirmar Contraseña",
            STR_LOGIN = "Entrar",
            STR_ERROR = "Error",
            STR_CANCEL = "Cancelar",
            STR_ID = "Id",
            STR_CALL_NAME = "Nombre De la convocatoria",
            STR_START_DATE= "Fecha de inicio",
            STR_END_DATE= "Fecha de finalización",
            STR_PUBLISH_DATE= "Fecha de publiciación",
            STR_STATUS= "Estado",
            STR_IDENTIFICATION = "Cédula",
            STR_FOREING_IDENTIFICATION = "Cédula de Extranjería",
            STR_PASSPORT = "Pasaporte",
            STR_USERNAME = "Usuario",
            STR_EMAIL = "Correo Eléctronico",
            STR_FIRSTNAME = "Nombre",
            STR_NAME = "Nombre",
            STR_LASTNAME = "Apellido",
            STR_ADDRESS = "Dirección",
            STR_PHONE = "Teléfono",
            STR_CELLPHONE = "Celular",
            STR_ACTIVE = "Activo",
            STR_CREATE_TIME = "Fecha de Creación",
            STR_UPDATE_TIME = "Fecha de Actualización",
            STR_PERSONAL_INFO = "Información Personal",
            STR_LOGIN_INFO = "Información de Ingreso",
            STR_INACTIVE = "Inactivo",
            STR_SUCCESS = "Exito",
            STR_SAVE_SUCCESS = "Se guardó un nuevo registro a la Base de Datos.\n\nDetalle: %s",
            STR_UPDATE_SUCCESS = "Se actualizó el registro a la Base de Datos.\n\nDetalle: %s",
            STR_DELETE = "Borrar",
            STR_YES = "Si",
            STR_NO = "No",
            STR_ROLE = "Rol",
            STR_SAVE = "Guardar",
            STR_DELETE_CONFIRMATION = "¿Esta seguro que desea borrar el registro %s ?\n\nESTA ACCIÓN NO SE PUEDE DESHACER",
            STR_CONVOCATORY_MANAGEMENT = "Administración de Convocatorias",
            STR_WELCOME = "Bienvenido",
            STR_EXIT = "Salir",
            STR_DESCRIPTION = "Descripción",
            STR_PUBLISHING_DATE = "Fecha de Publicación",
            STR_IDENTIFICATION_TYPE = "Tipo de Identifiación",
            STR_BIRTHDATE = "Fecha de Nacimiento",
            STR_SEX = "Sexo",
            STR_COMPANY = "Nombre",
            STR_COMPANY_CITY = "Ciudad de Trabajo",
            STR_COMPANY_ADDRESS = "Dirección de Trabajo",
            STR_COMPANY_PHONE = "Teléfono de Trabajo",
            STR_WORKING_TIME = "Jornada de Trabajo",
            STR_CITY = "Ciudad",
            STR_CREATED_BY = "Ingresado por",
            STR_TOTAL_SCORE = "Puntaje Total",
            STR_FULLNAME = "Nombre Completo",
            STR_VERIFIED = "Verificado",
            STR_VIEW_STATISTICS = "Ver Estadisticas",
            STR_NEW_APPLICANT = "Nuevo Aspirante",
            STR_NULL_SELECTION = "-- Sin Selección --",
            STR_MALE = "Masculino",
            STR_FEMME = "Femenino",
            STR_DAY = "Diurno",
            STR_NIGHT = "Nocturno",
            STR_WORK_INFO = "Información Laboral",
            STR_DAY_NIGHT = "Ambos",
            STR_NEXT = "Siguiente",
            STR_PREV = "Anterior";

    // String Errors
    public static final String ERROR_LOAD_DATA_FAILS = "Error al cargar los registros de la base de datos.\n\nDetalles: %s",
            ERROR_LOGIN_FAILS = "Error al iniciar sesión.\n\nDescipción: %s",
            ERROR_SAVE_FAILS = "Ocurrió un error al guadar el registro.\n\nDescipción: %s",
            ERROR_DELETE_DATA_FAILS = "Ocurrió un error al borrar el registro.\n\nDescipción: %s",
            ERROR_LOGIN_FAILS_PASSWORD_OR_USER = "Usuario o contraseña incorrectos, intente de nuevo\n\nSi no recuerda su información de ingreso comuniquese con el Administrador",
            ERROR_LOGIN_NULL_CREDENTIALS = "Usuario o contraseña vacío, por favor ingrese su información de logueo";

    // Columns Names
    public static String[] STR_APPLICANT_COLUMNS = { STR_ID, STR_IDENTIFICATION, STR_FULLNAME, STR_COMPANY, STR_CITY, STR_CREATED_BY, STR_TOTAL_SCORE, STR_VERIFIED };
    public static String[] STR_APPLICANT_COLUMNS_FULL = { STR_ID, STR_IDENTIFICATION, STR_IDENTIFICATION_TYPE, STR_EMAIL, STR_FIRSTNAME, STR_LASTNAME, STR_BIRTHDATE, STR_SEX, STR_ADDRESS, STR_PHONE, STR_CELLPHONE, STR_COMPANY, STR_COMPANY_CITY, STR_COMPANY_ADDRESS, STR_COMPANY_PHONE, STR_WORKING_TIME, STR_ACTIVE, STR_CITY, STR_CREATED_BY, STR_CREATE_TIME, STR_UPDATE_TIME, STR_TOTAL_SCORE, STR_VERIFIED };
    public static String[] SRT_USERS_COLUMNS = {STR_ID, STR_FIRSTNAME, STR_LASTNAME, STR_EMAIL, STR_ACTIVE};
    public static String[] SRT_USERS_COLUMNS_FULL = {STR_ID, STR_IDENTIFICATION, STR_USERNAME, STR_PASSWORD, STR_EMAIL, STR_FIRSTNAME, STR_LASTNAME, STR_ADDRESS, STR_PHONE, STR_CELLPHONE, STR_ACTIVE, STR_CREATE_TIME, STR_UPDATE_TIME};
    public static String[] SRT_CONVOCATORY_COLUMNS = { STR_ID, STR_NAME, STR_START_DATE, STR_END_DATE, STR_ACTIVE };
    public static String[] SRT_CONVOCATORY_COLUMNS_FULL = { STR_ID, STR_NAME, STR_DESCRIPTION, STR_START_DATE, STR_END_DATE, STR_PUBLISHING_DATE, STR_ACTIVE, STR_CREATE_TIME, STR_UPDATE_TIME };
    

    // Commands Constans
    public static final String CMD_NEW_CONVOCATORY = "CMD_NEW_CONVOCATORY";
    public static final String CMD_NEW_USER = "CMD_NEW_USER";
    public static final String CMD_LOGIN = "CMD_LOGIN";
    public static final String CMD_CANCEL = "CMD_CANCEL";
    public static final String CMD_SAVE = "CMD_SAVE";
    public static final String CMD_DELETE = "CMD_DELETE";
    public static final String CMD_VIEW_STATISTICS = "CMD_VIEW_STATISTICS";
    public static final String CMD_MANAGE_APPLICANTS = "CMD_MANAGE_APPLICANTS";
    public static final String CMD_NEW_APPLICANT = "CMD_NEW_APPLICANT";

    // Roles
    public static final String ROL_ADMINISTRATOR = "Administrador";

    // Icons constans
    public static final ImageIcon ICON_CONVOCATORY = getIcon("convocatory.png");
    public static final ImageIcon ICON_CONVOCATORY_SMALL = getIcon("Convocatory-24x24.png");
    public static final ImageIcon ICON_TACHOMETER = getIcon("tachometer.png");
    public static final ImageIcon ICON_TACHOMETER_SMALL = getIcon("tachometer-24x24.png");
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
    public static final ImageIcon ICON_TRASH = getIcon("trashcan.png");
    public static final ImageIcon ICON_TRASH_SMALL = getIcon("trashcan-24x24.png");
    public static final ImageIcon ICON_PIN = getIcon("pin.png");
    public static final ImageIcon ICON_PIN_SMALL = getIcon("pin-24x24.png");
    public static final ImageIcon ICON_APPLICANT = getIcon("applicant.png");
    public static final ImageIcon ICON_APPLICANT_SMALL = getIcon("applicant-24x24.png");
    
    public static String VALIDATION_LETTERS_ONLY = "En %s solo se permiten letras";
    public static String VALIDATION_VALUE_NOT_ALLOWED = "En %s valor no permitido";

    private static ImageIcon getIcon(String path) {
        URL resource = R.class.getResource("icons/" + path);
        if (resource == null) {
            // Log something...
            return null;
        }
        return new ImageIcon(resource);
    }
    
    public static final Object[] LIST_IDENTIFICATION_TYPES = {
        new Item("", R.STR_NULL_SELECTION),
        new Item("C.C.", R.STR_IDENTIFICATION),
        new Item("C.E.", R.STR_FOREING_IDENTIFICATION),
        new Item("P", R.STR_PASSPORT)
    };
    
    public static final Object[] LIST_SEX_VALUES = {
        new Item("", R.STR_NULL_SELECTION),
        new Item("M", R.STR_MALE),
        new Item("F", R.STR_FEMME)
    };
    
        public static final Object[] LIST_WORK_TIME_VALUES = {
        new Item("", R.STR_NULL_SELECTION),
        new Item("DIURNO", R.STR_DAY),
        new Item("NOCTURNO", R.STR_NIGHT),
        new Item("AMBOS", R.STR_DAY_NIGHT)
    };
}
