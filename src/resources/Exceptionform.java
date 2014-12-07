/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author Mauro
 */
public class Exceptionform extends Exception {

    public Exceptionform(String name) {
        super(name);
    }

    public static void campoVacio(JTextField text) throws Exception {
        String test = text.getText();
        if (!test.equals("") && !test.isEmpty()) {
        } else {
            throw new Exception(R.EXCEPTION_EMPETY);
        }
    }

    public static void Fechavacia(Date date) throws Exception {
        if (date == null) {
            throw new Exception(R.EXCEPTION_DATE_EMPETY);
        }
    }

    public static void Fechacorrespondencia(Date mayor, Date menor) throws Exception {
       int test = mayor.compareTo(menor);
        if (test != 1 || test == 0) {
            throw new Exception(R.EXCEPTION_DATE_ERROR);
        }
    }
}
