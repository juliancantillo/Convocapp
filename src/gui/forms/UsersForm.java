package gui.forms;

import dbhandler.dao.UserModel;
import gui.toolbar.RolesToolBar;
import helpers.ResultsetTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class UsersForm extends JFrame implements ActionListener, TableModelListener, MouseListener {
    
    private JTable tblUsers;

    public UsersForm() {
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
        if(e.getActionCommand().equals(R.CMD_NEW_USER)){
            CreateUserForm newUserForm = new CreateUserForm();
            newUserForm.setVisible(true);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
}
