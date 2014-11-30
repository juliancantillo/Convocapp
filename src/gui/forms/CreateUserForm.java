/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.forms;

import dbhandler.dao.RoleModel;
import dbhandler.dao.UserModel;
import entities.User;
import helpers.GBHelper;
import helpers.Gap;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import resources.Exceptionform;
import resources.R;

/**
 *
 * @author Mauro
 */
public class CreateUserForm extends JFrame implements ActionListener, KeyListener {

    private JTextField fldUsername;
    private JPasswordField fldPassword, fldPasswordConfirm;
    private JTextField fldIdentification;
    private JTextField fldEmail;
    private JTextField fldFirstname;
    private JTextField fldLastname;
    private JTextField fldAddress;
    private JTextField fldPhone;
    private JTextField fldCellphone;
    private JComboBox slctRol;
    private ButtonGroup rardioBtnActive;
    private JRadioButton radioActive;
    private JRadioButton radioInactive;
    private boolean editMode = false;
    private int userId;
    private User user;

    public CreateUserForm() {
        setTitle(R.STR_NEW_USER);
        user = new User();
        initForm();
    }

    public CreateUserForm(int userId) {
        setTitle(R.STR_EDIT_USER);
        this.editMode = true;
        this.userId = userId;

        try {
            UserModel userModel = new UserModel();
            user = userModel.read(userId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        initForm();
    }

    private void initForm() {
        setIconImage(R.ICON_ADD_USER_SMALL.getImage());

        JPanel pnlContainer = new JPanel();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.setBorder(BorderFactory.createEmptyBorder(R.GAP, R.GAP, R.GAP, R.GAP));

        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(new GridBagLayout());

        JLabel lblIcon = new JLabel(R.ICON_ADD_USER);

        fldUsername = new JTextField();
        fldPassword = new JPasswordField();
        fldPasswordConfirm = new JPasswordField();
        fldIdentification = new JTextField();
        fldEmail = new JTextField();
        fldFirstname = new JTextField();
        fldLastname = new JTextField();
        fldAddress = new JTextField();
        fldPhone = new JTextField();
        fldCellphone = new JTextField();

        try {
            slctRol = new JComboBox<>(new RoleModel().toArray());
        } catch (SQLException ex) {
            slctRol = new JComboBox<>();
        }

        radioActive = new JRadioButton(R.STR_YES);
        radioInactive = new JRadioButton(R.STR_NO);
        rardioBtnActive = new ButtonGroup();

        GBHelper pos = new GBHelper();

        pnlLogin.add(lblIcon, pos.height(4).expandH().align(GBHelper.NORTH));

        pnlLogin.add(new Gap(R.W * 2), pos.nextCol());

        pnlLogin.add(pnlPersonalInfo(), pos.nextCol().expandW());
        pnlLogin.add(new Gap(R.H * 2), pos.nextRow().nextCol().nextCol());
        pnlLogin.add(pnlLoginFields(), pos.nextRow().nextCol().nextCol().expandW());
        pnlLogin.add(new Gap(), pos.nextRow().expandH());

        pnlContainer.add(pnlLogin, BorderLayout.CENTER);
        pnlContainer.add(pnlActionButtons(), BorderLayout.SOUTH);
        add(pnlContainer);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//TODO Delete this line

        setAlwaysOnTop(true);
        setSize(750, 480);
        setLocationRelativeTo(null);
    }

    public final JPanel pnlPersonalInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_PERSONAL_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblIdentification = new JLabel(R.STR_IDENTIFICATION);
        JLabel lblFirstname = new JLabel(R.STR_FIRSTNAME);
        JLabel lblLastname = new JLabel(R.STR_LASTNAME);
        JLabel lblAddress = new JLabel(R.STR_ADDRESS);
        JLabel lblEmail = new JLabel(R.STR_EMAIL);
        JLabel lblPhone = new JLabel(R.STR_PHONE);
        JLabel lblCellphone = new JLabel(R.STR_CELLPHONE);
        JLabel lblActive = new JLabel(R.STR_ACTIVE);
        JLabel lblRole = new JLabel(R.STR_ROLE);

        ButtonGroup btnActive = new ButtonGroup();
        btnActive.add(radioActive);
        btnActive.add(radioInactive);

        fldUsername.addKeyListener(this);
        fldPassword.addKeyListener(this);
        fldPasswordConfirm.addKeyListener(this);
        fldIdentification.addKeyListener(this);
        fldEmail.addKeyListener(this);
        fldFirstname.addKeyListener(this);
        fldLastname.addKeyListener(this);
        fldAddress.addKeyListener(this);
        fldPhone.addKeyListener(this);
        fldCellphone.addKeyListener(this);

        GBHelper pos = new GBHelper();

        panel.add(lblIdentification, pos);
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldIdentification, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblFirstname, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldFirstname, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblLastname, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldLastname, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblAddress, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldAddress, pos.nextCol().width(3).expandW());

        panel.add(new Gap(), pos.nextCol().nextCol().nextCol());

        panel.add(lblEmail, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldEmail, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblPhone, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPhone, pos.nextCol().width(3).expandW());

        panel.add(new Gap(R.GAP), pos.nextCol().nextCol().nextCol());

        panel.add(lblCellphone, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldCellphone, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblActive, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioActive, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioInactive, pos.nextCol());

        panel.add(new Gap(R.GAP), pos.nextCol());

        panel.add(lblRole, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctRol, pos.nextCol().expandW());

        return panel;
    }

    public final JPanel pnlLoginFields() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_LOGIN_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblUsername = new JLabel(R.STR_USERNAME);
        JLabel lblPassword = new JLabel(R.STR_PASSWORD);
        JLabel lblPasswordConfirm = new JLabel(R.STR_PASSWORD_CONFIRM);

        GBHelper pos = new GBHelper();

        panel.add(lblUsername, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldUsername, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblPassword, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPassword, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblPasswordConfirm, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPasswordConfirm, pos.nextCol().expandW());

        panel.addKeyListener(this);

        return panel;

    }

    private JPanel pnlActionButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnDeleteUser = new JButton(R.STR_DELETE);
        btnDeleteUser.setIcon(R.ICON_TRASH_SMALL);
        btnDeleteUser.setActionCommand(R.CMD_DELETE);
        btnDeleteUser.addActionListener(this);

        JButton btnSaveUser = new JButton(R.STR_SAVE);
        btnSaveUser.setIcon(R.ICON_SAVE_SMALL);
        btnSaveUser.setMnemonic('G');
        btnSaveUser.setActionCommand(editMode ? R.CMD_SAVE : R.CMD_NEW_USER);
        btnSaveUser.addActionListener(this);

        JButton btnCancel = new JButton(R.STR_CANCEL);
        btnCancel.setIcon(R.ICON_CANCEL_SMALL);
        btnCancel.setActionCommand(R.CMD_CANCEL);
        btnCancel.addActionListener(this);

        if (editMode) {
            panel.add(btnDeleteUser);
        }
        panel.add(btnSaveUser);
        panel.add(btnCancel);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Bloque de excepciones

            Exceptionform.fieldEmpty(fldAddress);
            Exceptionform.fieldEmpty(fldLastname);
            Exceptionform.fieldEmpty(fldFirstname);
            Exceptionform.fieldEmpty(fldUsername);
            Exceptionform.fieldEmpty(fldIdentification);

            //Bloque de excepciones
            if (e.getActionCommand().equals(R.CMD_NEW_USER)) {
                /*Llama a la funcion que toma los nombres del los texfield y los guarda en la base de datos*/
                UserModel userModel = new UserModel();
                User newUser = createNewUser();

                try {
                    userModel.create(newUser);
                    JOptionPane.showMessageDialog(this, String.format(R.STR_SAVE_SUCCESS, newUser.toString()), R.STR_SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, String.format(R.ERROR_SAVE_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getActionCommand().equals(R.CMD_SAVE)) {
                UserModel userModel = new UserModel();
                user = createNewUser();

                try {
                    userModel.update(user);
                    JOptionPane.showMessageDialog(this, String.format(R.STR_UPDATE_SUCCESS, user.toString()), R.STR_SUCCESS, JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getActionCommand().equals(R.CMD_DELETE)) {
                UserModel userModel = new UserModel();

                int confirm = JOptionPane.showConfirmDialog(this, String.format(R.STR_DELETE_CONFIRMATION, user.toString()), R.STR_DELETE, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        userModel.delete(userId);
                        dispose();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, String.format(R.ERROR_DELETE_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            if (e.getActionCommand().equals(R.CMD_CANCEL)) {
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private User createNewUser() {
        /*Agrega al nuevo usuario a la base de datos
         */
        User newUser = new User();

            newUser.setUsername(fldUsername.getText());
            newUser.setPassword(String.valueOf(fldPassword.getPassword()));
            newUser.setIdentification(fldIdentification.getText());
            newUser.setEmail(fldEmail.getText());
            newUser.setFirstname(fldFirstname.getText());
            newUser.setLastname(fldLastname.getText());
            newUser.setAddress(fldAddress.getText());
            newUser.setPhone(fldPhone.getText());
            newUser.setCellphone(fldCellphone.getText());
            newUser.setActive(radioActive.isSelected());
        
        return newUser;
    }

    public void fillForm() {
        fldUsername.setText(user.getUsername());
        fldIdentification.setText(user.getIdentification());
        fldEmail.setText(user.getEmail());
        fldFirstname.setText(user.getFirstname());
        fldLastname.setText(user.getLastname());
        fldAddress.setText(user.getAddress());
        fldPhone.setText(user.getPhone());
        fldCellphone.setText(user.getCellphone());
        radioActive.setSelected(user.isActive());
        radioInactive.setSelected(!user.isActive());
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }
}
