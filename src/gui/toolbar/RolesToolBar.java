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

        JButton btnNewConvocatory = new JButton(R.STR_NEW_CONVOCATORY);
        JButton btnNewUser = new JButton(R.STR_NEW_USER);
        JButton btnNewApplicant = new JButton(R.STR_NEW_APPLICANT);

        btnNewUser.setActionCommand(R.CMD_NEW_USER);
        btnNewUser.setIcon(R.ICON_ADD_USER_SMALL);
        btnNewUser.addActionListener(listener);
//Boton Crear nueva convocatoria
        btnNewConvocatory.setActionCommand(R.CMD_NEW_CONVOCATORY);
        btnNewConvocatory.setIcon(R.ICON_CONVOCATORY_SMALL);
        btnNewConvocatory.addActionListener(listener);

        btnNewApplicant.setActionCommand(R.CMD_NEW_APPLICANT);
        btnNewApplicant.setIcon(R.ICON_APPLICANT_SMALL);
        btnNewApplicant.addActionListener(listener);

        if (rol.equals(R.ROL_ADMINISTRATOR)) {
            this.add(btnNewUser);
            this.add(btnNewConvocatory);
            this.add(btnNewApplicant);
        }

    }

}
