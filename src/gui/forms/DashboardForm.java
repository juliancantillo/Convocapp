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
import javax.swing.JPanel;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class DashboardForm extends JFrame implements ActionListener{

    public DashboardForm() {
        super(R.STR_WELCOME);
        
        setLayout(new BorderLayout(R.GAP, R.GAP));
        
        JButton btnExit = new JButton(R.STR_EXIT);
        btnExit.addActionListener(this);
        btnExit.setIcon(R.ICON_CANCEL_SMALL);
        btnExit.setActionCommand(R.CMD_CANCEL);
        
        add(pnlUserInformation(), BorderLayout.NORTH);
        add(pnlButtons(), BorderLayout.CENTER);
        add(btnExit, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    }
    
    private JPanel pnlButtons(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        
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
        
        JButton btnViewStatistics = new JButton(R.STR_VIEW_STATISTICS);
        btnViewStatistics.addActionListener(this);
        btnViewStatistics.setVerticalTextPosition(JButton.BOTTOM);
        btnViewStatistics.setHorizontalTextPosition(JButton.CENTER);
        btnViewStatistics.setIcon(R.ICON_TACHOMETER);
        btnViewStatistics.setActionCommand(R.CMD_VIEW_STATISTICS);
        
        panel.add(btnManageUsers);
        panel.add(btnManageConvocatory);
        panel.add(btnViewStatistics);
        
        return panel;
    }
    
    private JPanel pnlUserInformation(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JLabel lblUser = new JLabel( Convocapp.loggedUser.getFirstname() );
        
        panel.add(lblUser);
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(R.CMD_NEW_USER)){
            UsersForm form = new UsersForm();
            form.setVisible(true);
        }
    }
}
