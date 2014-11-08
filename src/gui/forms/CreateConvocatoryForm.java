/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.forms;

import dbhandler.dao.UserModel;
import entities.User;
import helpers.GBHelper;
import helpers.Gap;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import org.jdatepicker.JDateComponentFactory;
import resources.R;
import org.jdatepicker.JDatePicker;
import entities.Convocatory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauro
 */
public class CreateConvocatoryForm extends JFrame implements ActionListener, KeyListener {

    private JDatePicker data_inicial, data_final, data_publicacion;
    private JTextField fldUsername;
    private JTextField fldIdentification;
    private JTextField fldEmail;
    private ButtonGroup rardioBtnActive;
    private JRadioButton radioActive;
    private JRadioButton radioInactive;

    private boolean editMode = false;
    private int userId;
    private User user;
    private Convocatory convocatory;
    JDateComponentFactory data = new JDateComponentFactory();

    public CreateConvocatoryForm() {
        user = new User();
        initForm();
    }

    public CreateConvocatoryForm(int userId) {
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
        setTitle(R.STR_NEW_CONVOCATORY);
        setIconImage(R.ICON_CONVOCATORY_SMALL.getImage());

        JPanel pnlContainer = new JPanel();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.setBorder(BorderFactory.createEmptyBorder(R.GAP, R.GAP, R.GAP, R.GAP));

        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(new GridBagLayout());

        JLabel lblIcon = new JLabel(R.ICON_CONVOCATORY);

        fldUsername = new JTextField();
        fldIdentification = new JTextField();
        fldEmail = new JTextField();

        radioActive = new JRadioButton(R.STR_YES);
        radioInactive = new JRadioButton(R.STR_NO);
        rardioBtnActive = new ButtonGroup();

        GBHelper pos = new GBHelper();

        pnlLogin.add(lblIcon, pos.height(4).expandH().align(GBHelper.NORTH));

        pnlLogin.add(new Gap(R.W * 2), pos.nextCol());

        pnlLogin.add(pnlDatosConvocatory(), pos.nextCol().expandW());
        pnlLogin.add(new Gap(R.H * 2), pos.nextRow().nextCol().nextCol());
        pnlLogin.add(new Gap(), pos.nextRow().expandH());

        pnlContainer.add(pnlLogin, BorderLayout.CENTER);
        pnlContainer.add(pnlActionButtons(), BorderLayout.SOUTH);
        add(pnlContainer);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//TODO Delete this line

        setAlwaysOnTop(true);
        setSize(650, 280);
        setLocationRelativeTo(null);
    }

    public final JPanel pnlDatosConvocatory() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_PERSONAL_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        //Fechas de la interface
        data_inicial = data.createJDatePicker();
        data_inicial.setTextEditable(true);
        data_inicial.setShowYearButtons(true);

        data_final = data.createJDatePicker();
        data_final.setTextEditable(true);
        data_final.setShowYearButtons(true);

        data_publicacion = data.createJDatePicker();
        data_publicacion.setTextEditable(true);
        data_publicacion.setShowYearButtons(true);

        JLabel lblNombreConvocatoria = new JLabel(R.STR_NEW_CONVOCATORY);
        JLabel lblFechaInicio = new JLabel(R.STR_FECHA_INICIO_CONVOCATORIA);
        JLabel lblFechaFinal = new JLabel(R.STR_FECHA_FIN_CONVOCATORIA);
        JLabel lblFechaPublicacion = new JLabel(R.STR_FECHA_PUBLICACION_CONVOCATORIA);
        JLabel lblEstado = new JLabel(R.STR_ESTADO_COVOCATORIA);

        ButtonGroup btnActive = new ButtonGroup();
        btnActive.add(radioActive);
        btnActive.add(radioInactive);

        fldUsername.addKeyListener(this);

        fldIdentification.addKeyListener(this);
        fldEmail.addKeyListener(this);

        GBHelper pos = new GBHelper();
        
        panel.add(lblNombreConvocatoria, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldUsername, pos.nextCol().width(5).expandW());

        panel.add(lblFechaInicio, pos);
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add((Component) data_inicial, pos.nextCol().width(5).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblFechaFinal, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add((Component) data_final, pos.nextCol().width(5).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblFechaPublicacion, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add((Component) data_publicacion, pos.nextCol().width(5).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(new Gap(R.H), pos.nextCol());
        panel.add(new Gap(R.H), pos.nextRow());
        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblEstado, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioActive, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioInactive, pos.nextCol());
        panel.add(new Gap(), pos.nextCol().expandW());

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
        btnSaveUser.setActionCommand(editMode ? R.CMD_SAVE : R.CMD_NEW_CONVOCATORY);
        btnSaveUser.addActionListener(this);

        JButton btnCancel = new JButton(R.STR_CANCEL);
        btnCancel.setIcon(R.ICON_CANCEL_SMALL);
        btnCancel.setActionCommand(R.CMD_CANCEL);
        btnCancel.addActionListener(this);

        if (editMode) {
            panel.add(btnDeleteUser);
            panel.add(new Gap());
        }
        panel.add(btnSaveUser);
        panel.add(btnCancel);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(R.CMD_NEW_CONVOCATORY)) {
            UserModel userModel = new UserModel();
            /*Llama a la funcion que toma los nombres del los texfield y los guarda en la base de datos*/
            //Obtener fecha;
            String text = data_inicial.getModel().getYear() + "-" + data_inicial.getModel().getMonth() + "-" + data_inicial.getModel().getDay() + " 18:48:05.123";
            Timestamp inicio = new Timestamp(3);
            inicio = Timestamp.valueOf(text);

            text = data_final.getModel().getYear() + "-" + data_final.getModel().getMonth() + "-" + data_final.getModel().getDay() + " 18:48:05.123";
            Timestamp fin = new Timestamp(3);
            fin = Timestamp.valueOf(text);

            text = data_publicacion.getModel().getYear() + "-" + data_publicacion.getModel().getMonth() + "-" + data_publicacion.getModel().getDay() + " 18:48:05.123";
            Timestamp publicacion = new Timestamp(3);
            publicacion = Timestamp.valueOf(text);
           //creo el objeto convocatoria
            String ConvocatoryNombre = fldUsername.getText();
            convocatory = new Convocatory(ConvocatoryNombre,radioActive.isEnabled(), inicio, fin, publicacion);
            
            try {
                userModel.createConvocatory(convocatory);
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this,"Error al crear Convocatoria" + ex);
            }
             JOptionPane.showMessageDialog(this,"Crear Convocatoria \n" + ConvocatoryNombre );
            

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
    }

    private User createNewUser() {
        /*Agrega al nuevo usuario a la base de datos
         */
        User newUser = user;
        newUser.setUsername(fldUsername.getText());
        newUser.setIdentification(fldIdentification.getText());
        newUser.setEmail(fldEmail.getText());
        newUser.setActive(radioActive.isSelected());

        return newUser;
    }

    public void fillForm() {
        fldUsername.setText(user.getUsername());
        fldIdentification.setText(user.getIdentification());
        fldEmail.setText(user.getEmail());
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
