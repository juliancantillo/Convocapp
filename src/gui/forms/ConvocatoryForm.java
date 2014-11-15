package gui.forms;

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

    private JTable tblUsers;
    

    public ConvocatoryForm() {
        super(R.STR_USERS_MANAGEMENT);
        setIconImage(R.ICON_USERS_SMALL.getImage());

        setLayout(new BorderLayout(R.H, R.W));

        RolesToolBar toolBar = new RolesToolBar(R.ROL_ADMINISTRATOR, this);

        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);
        add(users(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    private JPanel users() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        UserModel userModel = new UserModel();

        ResultSet tableData = null;
        try {
            tableData = userModel.read();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        tblUsers = new JTable(new ResultsetTableModel(tableData, R.SRT_USERS_COLUMNS));
        tblUsers.getModel().addTableModelListener(this);
        tblUsers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblUsers.setRowHeight(28);
        tblUsers.addMouseListener(this);

        panel.add(new JScrollPane(tblUsers), BorderLayout.CENTER);

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
            tblUsers.setModel(new ResultsetTableModel(new UserModel().read(), R.SRT_USERS_COLUMNS, this));
            tblUsers.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tblUsers) {
            int row = tblUsers.getSelectedRow();
            Integer id = (Integer) tblUsers.getValueAt(row, 0);
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
            ResultsetTableModel rm = (ResultsetTableModel) tblUsers.getModel();
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
