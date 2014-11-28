package helpers;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class ButtonsFactory {

    public static JButton createButton(String text, ImageIcon icon, String command, ActionListener actionListener){
        JButton btn = new JButton(text);
        btn.setIcon(icon);
        btn.setActionCommand(command);
        btn.addActionListener(actionListener);
        
        return btn;
    }
    
    public static JButton addButton(String text, ImageIcon icon, ActionListener actionListener){
        JButton btn = new JButton(text);
        btn.setIcon(icon);
        btn.setActionCommand(text);
        btn.addActionListener(actionListener);
        
        return btn;
    }
    
    public static JButton addButton(String text, String command, ActionListener actionListener){
        JButton btn = new JButton(text);
        btn.setActionCommand(command);
        btn.addActionListener(actionListener);
        
        return btn;
    }
    
    public static JButton addButton(String text, ActionListener actionListener){
        JButton btn = new JButton(text);
        btn.addActionListener(actionListener);
        
        return btn;
    }
    
}
