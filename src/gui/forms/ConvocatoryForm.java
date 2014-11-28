package gui.forms;

import controller.Convocapp;
import dbhandler.dao.ConvocatoryModel;
import dbhandler.dao.UserModel;
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
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class ConvocatoryForm extends JFrame implements ActionListener, TableModelListener, MouseListener, WindowListener {

    private JTable tblConvocatory;

    public ConvocatoryForm() {
        super(R.STR_CONVOCATORY_MANAGEMENT);
        setIconImage(R.ICON_USERS_SMALL.getImage());

        setLayout(new BorderLayout(R.H, R.W));

        RolesToolBar toolBar = new RolesToolBar(Convocapp.loggedUser.getRole(), this);

        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);
        add(convocatory(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
    }

    private JPanel convocatory() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ConvocatoryModel convocatoryModel = new ConvocatoryModel();

        ResultSet tableData = null;
        try {
            tableData = convocatoryModel.read();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        tblConvocatory = new JTable(new ResultsetTableModel(tableData, R.SRT_CONVOCATORY_COLUMNS));
        tblConvocatory.getModel().addTableModelListener(this);
        tblConvocatory.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblConvocatory.setRowHeight(28);
        tblConvocatory.addMouseListener(this);

        panel.add(new JScrollPane(tblConvocatory), BorderLayout.CENTER);

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
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        try {
            tblConvocatory.setModel(new ResultsetTableModel(new UserModel().read(), R.SRT_USERS_COLUMNS, this));
            tblConvocatory.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tblConvocatory) {
            int row = tblConvocatory.getSelectedRow();
            Integer id = (Integer) tblConvocatory.getValueAt(row, 0);
            CreateUserForm userForm = new CreateUserForm(id);
            userForm.fillForm();
            userForm.addWindowListener(this);
            userForm.setVisible(true);
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
            ResultsetTableModel rm = (ResultsetTableModel) tblConvocatory.getModel();
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
