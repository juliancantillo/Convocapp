package gui.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class UsersForm extends JFrame implements ActionListener{

    public UsersForm() {
        super(R.STR_USERS_MANAGEMENT);
    }
    
    private JToolBar toolBar(){
    JToolBar toolBar = new JToolBar();
    
    JButton btnNewUser = new JButton( R.STR_NEW_USER );
    
    btnNewUser.setActionCommand(R.CMD_NEW_USER);
    
    btnNewUser.addActionListener(this);
    
    toolBar.add(btnNewUser);
    
    
    return toolBar;
  }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
