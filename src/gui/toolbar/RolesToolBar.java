package gui.toolbar;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToolBar;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class RolesToolBar extends JToolBar {

    public RolesToolBar(String rol, ActionListener listener) {

        JButton btnNewUser = new JButton(R.STR_NEW_USER);
        btnNewUser.setActionCommand(R.CMD_NEW_USER);
        btnNewUser.setIcon(R.ICON_ADD_USER_SMALL);
        btnNewUser.addActionListener(listener);

        if (rol.equals(R.ROL_ADMINISTRATOR)) {
            this.add(btnNewUser);
        }

    }

}
