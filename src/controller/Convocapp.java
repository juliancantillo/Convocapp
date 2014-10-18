/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import gui.forms.LoginForm;
import gui.forms.UsersForm;

/**
 *
 * @author kahmos
 */
public class Convocapp {
    
    public LoginForm loginForm;
    public UsersForm usersForm;

    public Convocapp() {
        loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convocapp app = new Convocapp();
    }
    
}
