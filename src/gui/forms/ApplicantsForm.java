package gui.forms;

import controller.Convocapp;
import dbhandler.dao.ApplicantModel;
import dbhandler.dao.UserModel;
import entities.Applicant;
import gui.toolbar.RolesToolBar;
import helpers.ResultsetTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class ApplicantsForm extends JFrame implements ActionListener, TableModelListener, MouseListener, WindowListener {

    private JTable tblApplicants;

    public ApplicantsForm() {
        super(R.STR_APPLICANT_MANAGEMENT);
        setIconImage(R.ICON_USERS_SMALL.getImage());

        setLayout(new BorderLayout(R.H, R.W));

        RolesToolBar toolBar = new RolesToolBar(Convocapp.loggedUser.getRole(), this);

        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);
        add(applicants(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
    }

    private JPanel applicants() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ApplicantModel applicantModel = new ApplicantModel();

        ResultSet tableData = null;
        try {
            tableData = applicantModel.read();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        tblApplicants = new JTable(new ResultsetTableModel(tableData, R.STR_APPLICANT_COLUMNS));
        tblApplicants.getModel().addTableModelListener(this);
        tblApplicants.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblApplicants.setRowHeight(28);
        tblApplicants.addMouseListener(this);

        panel.add(new JScrollPane(tblApplicants), BorderLayout.CENTER);

        return panel;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        //Llama al panel de creacion de usuario
        if (e.getActionCommand().equals(R.CMD_NEW_USER)) {
            CreateUserForm newUserForm = new CreateUserForm();
            newUserForm.addWindowListener(this);
            newUserForm.setVisible(true);
        }
        //Llama al panel de creacion de convocatoria
        if (e.getActionCommand().equals(R.CMD_NEW_CONVOCATORY)) {
            CreateConvocatoryForm newConvocatoryForm = new CreateConvocatoryForm();
            newConvocatoryForm.addWindowListener(this);
            newConvocatoryForm.setVisible(true);
        }
        
        //Llama al panel de creacion de convocatoria
        if (e.getActionCommand().equals(R.CMD_NEW_APPLICANT)) {
            CreateApplicantResumeForm applicantForm = new CreateApplicantResumeForm();
            applicantForm.addWindowListener(this);
            applicantForm.setVisible(true);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        try {
            tblApplicants.setModel(new ResultsetTableModel(new ApplicantModel().read(), R.STR_APPLICANT_COLUMNS, this));
            tblApplicants.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tblApplicants && e.getClickCount() > 1) {
            int row = tblApplicants.getSelectedRow();
            Integer id = (Integer) tblApplicants.getValueAt(row, 0);
            ApplicantModel applicantModel = new ApplicantModel();
            try {
                CreateApplicantResumeForm applicantForm = new CreateApplicantResumeForm( (Applicant) applicantModel.read(id) );
                applicantForm.fillForm();
                applicantForm.addWindowListener(this);
                applicantForm.setVisible(true);
            } catch (SQLException ex) {
                R.showErrorMessage(this, ex.getMessage());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if (e.getSource() instanceof CreateUserForm) {
            ResultsetTableModel rm = (ResultsetTableModel) tblApplicants.getModel();
            rm.fireTableDataChanged();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
