/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.User;
import gui.forms.CreateApplicantResumeForm;
import gui.forms.CreateUserForm;
import gui.forms.LoginForm;
import gui.forms.UsersForm;
import javax.swing.UIManager;

/**
 *
 * @author kahmos
 */
public class Convocapp {
    
    public LoginForm loginForm;
    public UsersForm usersForm;
    public CreateUserForm adduser;
    public static User loggedUser;


    public Convocapp() {
        loginForm = new LoginForm();
        loginForm.setVisible(true);
//        CreateApplicantResumeForm applicant = new CreateApplicantResumeForm();
//        applicant.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {}
        
        Convocapp app = new Convocapp();
    }
    
}