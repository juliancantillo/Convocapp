/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.forms;

import helpers.GBHelper;
import helpers.Gap;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import resources.R;

/**
 *
 * @author Mauro
 */
public class Adduser extends JFrame implements ActionListener, KeyListener {

    private JButton bt_ingresar, btnCancel;
    private JTextField fldUser;
    private JPasswordField fldPass;

    public Adduser() {
        super(R.STR_NEW_USER);

        JPanel pnlContainer = new JPanel();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.setBorder(BorderFactory.createEmptyBorder(R.GAP, R.GAP, R.GAP, R.GAP));

        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(new BorderLayout(15, 15));

        pnlLogin.add(pnlLoginFields(), BorderLayout.NORTH);
        pnlLogin.add(pnlLoginButtons(), BorderLayout.SOUTH);

        pnlContainer.add(pnlLogin, BorderLayout.CENTER);
        add(pnlContainer);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//TODO Delete this line

        setAlwaysOnTop(true);
        setSize(800, 310);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public final JPanel pnlLoginFields() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(R.GAP, R.GAP, R.GAP, R.GAP));

        JLabel lblIcon = new JLabel(R.ICON_PASSWORD);

        JLabel lblUser = new JLabel(R.STR_USER);
        JLabel lblPass = new JLabel(R.STR_PASSWORD);

        fldUser = new JTextField();
        fldPass = new JPasswordField();

        fldUser.addKeyListener(this);
        fldPass.addKeyListener(this);

        GBHelper pos = new GBHelper();

        panel.add(lblIcon, pos.height(3).expandH());

        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(lblUser, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldUser, pos.nextCol().expandW());

        panel.add(new Gap(R.GAP), pos.nextRow());

        panel.add(lblPass, pos.nextRow().nextCol().nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPass, pos.nextCol().expandW());

        panel.addKeyListener(this);

        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt_ingresar) {
            /*Llama a la funcion que toma los nombres del los texfield y los guarda en la base de datos*/
            Add_new_user();
        }
        if (ae.getSource() == btnCancel) {
            System.exit(0);
        }
    }

    public void Add_new_user(){
    /*Agrega al nuevo usurio a la base de datos
        */
        JOptionPane.showMessageDialog(this,R.CMD_NEW_USER);
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component pnlLoginButtons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
