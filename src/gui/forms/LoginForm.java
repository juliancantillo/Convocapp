package gui.forms;


/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
import helpers.GBHelper;
import helpers.Gap;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import resources.R;

/**
 *
 * @author julianacb
 */
public class LoginForm extends JFrame implements ActionListener, KeyListener{
    
    private JButton btnLogin, btnCancel;
    private JTextField fldUser;
    private JPasswordField fldPass;

    public LoginForm() {
        super(R.STR_LOGIN_FORM_TITLE);

        JPanel pnlContainer = new JPanel();
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.setBorder(BorderFactory.createEmptyBorder(R.GAP, R.GAP, R.GAP, R.GAP));
                
        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(new BorderLayout(5,5));
        
        pnlLogin.add(pnlLoginFields(), BorderLayout.NORTH);
        pnlLogin.add(pnlLoginButtons(), BorderLayout.SOUTH);
        
        pnlContainer.add(pnlLogin, BorderLayout.CENTER);
        add(pnlContainer);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//TODO Delete this line
        
        setAlwaysOnTop(true);
        setSize(400, 210);
        setResizable(false);
        setLocationRelativeTo(null);
                
    }
    
    public final JPanel pnlLoginFields(){
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
        
        panel.add(new Gap(R.GAP) , pos.nextRow());
        
        panel.add(lblPass, pos.nextRow().nextCol().nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPass, pos.nextCol().expandW());
        
        panel.addKeyListener(this);

        return panel;
    }
    
    public final JPanel pnlLoginButtons(){
        JPanel panel = new JPanel();
                
        btnLogin = new JButton(R.STR_LOGIN);
        btnLogin.addActionListener(this);
        
        btnCancel = new JButton(R.STR_CANCEL);
        btnCancel.addActionListener(this);
        
        panel.add(btnLogin);
        panel.add(btnCancel);
        
        return panel;
    }
    
    private boolean validateForm(){
        String user = fldUser.getText();
        String pass = new String(fldPass.getPassword());
        
        if(user.equals("") && pass.equals("")){
            JOptionPane.showMessageDialog(this, "El campo usuario y/o contraseña esta vacio", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void cleanForm(){
        this.fldUser.setText("");
        this.fldPass.setText("");
    }
    
    public void login(){
        validateForm();
    }
        
    public void close(){
        this.setVisible(false);
        this.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            login();
        }
        if(e.getSource() == btnCancel){
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_ENTER ){
            login();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}