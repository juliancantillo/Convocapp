package gui.forms;

import controller.Convocapp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class DashboardForm extends JFrame implements ActionListener {

    private LoginForm loginWindow;
    
    public DashboardForm(LoginForm loginWindow) {
        super(R.STR_WELCOME);
        this.loginWindow = loginWindow;

        setLayout(new BorderLayout(R.GAP, R.GAP));

        JButton btnExit = new JButton(R.STR_EXIT);
        btnExit.addActionListener(this);
        btnExit.setIcon(R.ICON_CANCEL_SMALL);
        btnExit.setActionCommand(R.CMD_CANCEL);

        add(pnlUserInformation(), BorderLayout.NORTH);
        add(pnlButtons(), BorderLayout.CENTER);
        add(btnExit, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,300);
    }

    private JPanel pnlButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        JButton btnManageUsers = new JButton(R.STR_USERS_MANAGEMENT);
        btnManageUsers.addActionListener(this);
        btnManageUsers.setIcon(R.ICON_USERS);
        btnManageUsers.setVerticalTextPosition(JButton.BOTTOM);
        btnManageUsers.setHorizontalTextPosition(JButton.CENTER);
        btnManageUsers.setActionCommand(R.CMD_NEW_USER);

        JButton btnManageConvocatory = new JButton(R.STR_CONVOCATORY_MANAGEMENT);
        btnManageConvocatory.addActionListener(this);
        btnManageConvocatory.setVerticalTextPosition(JButton.BOTTOM);
        btnManageConvocatory.setHorizontalTextPosition(JButton.CENTER);
        btnManageConvocatory.setIcon(R.ICON_PIN);
        btnManageConvocatory.setActionCommand(R.CMD_NEW_CONVOCATORY);
        
        JButton btnManageApplicants = new JButton(R.STR_APPLICANT_MANAGEMENT);
        btnManageApplicants.addActionListener(this);
        btnManageApplicants.setVerticalTextPosition(JButton.BOTTOM);
        btnManageApplicants.setHorizontalTextPosition(JButton.CENTER);
        btnManageApplicants.setIcon(R.ICON_PIN);
        btnManageApplicants.setActionCommand(R.CMD_MANAGE_APPLICANTS);
        
        JButton btnViewStatistics = new JButton(R.STR_VIEW_STATISTICS);
        btnViewStatistics.addActionListener(this);
        btnViewStatistics.setVerticalTextPosition(JButton.BOTTOM);
        btnViewStatistics.setHorizontalTextPosition(JButton.CENTER);
        btnViewStatistics.setIcon(R.ICON_TACHOMETER);
        btnViewStatistics.setActionCommand(R.CMD_VIEW_STATISTICS);

        panel.add(btnManageUsers);
        panel.add(btnManageConvocatory);
        panel.add(btnManageApplicants);
        panel.add(btnViewStatistics);

        return panel;
    }

    private JPanel pnlUserInformation() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //Comente
        String roleuser = "Rol de usuario";
        //String roleuser = user.getRole();

        JLabel lblUser = new JLabel(String.format("%s %s, ( %s )", R.STR_WELCOME, Convocapp.loggedUser.getFirstname(), Convocapp.loggedUser.getRole()));
        panel.add(lblUser);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(R.CMD_NEW_USER)){
            UsersForm userForm = new UsersForm();
            userForm.setVisible(true);
        }
        if(e.getActionCommand().equals(R.CMD_NEW_CONVOCATORY)){
            ConvocatoryForm convocatoryForm = new ConvocatoryForm();
            convocatoryForm.setVisible(true);
        }
        if (e.getActionCommand().equals(R.CMD_NEW_CONVOCATORY)) {
            CreateConvocatoryForm newConvocatoryForm = new CreateConvocatoryForm();
            newConvocatoryForm.setVisible(true);
        }
        if (e.getActionCommand().equals(R.CMD_CANCEL)) {
            this.setVisible(false);
            loginWindow.cleanForm();
            JOptionPane.showMessageDialog(this,R.STR_SING_OFF);
            loginWindow.setVisible(true);
            
        }
        if(e.getActionCommand().equals(R.CMD_MANAGE_APPLICANTS)){
            ApplicantsForm applicantsForm = new ApplicantsForm();
            applicantsForm.setVisible(true);
        }
    }
}
