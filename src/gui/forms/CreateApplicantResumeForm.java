package gui.forms;

import gui.steps.PersonalInformationPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class CreateApplicantResumeForm extends JFrame implements KeyListener{

    private PersonalInformationPanel personalInformationPanel;
    private JPanel cards;
    private CardLayout cardsLayout;
    
    public CreateApplicantResumeForm() {
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new BorderLayout(R.H, R.W));
        
        personalInformationPanel = new PersonalInformationPanel(this);
        
        add(cardsPanel(), BorderLayout.CENTER);
        
    }
    
    private JPanel cardsPanel(){
        cards = new JPanel();
        cardsLayout = new CardLayout(R.H, R.W);
        cards.setLayout(cardsLayout);
        
        cards.add( personalInformationPanel );
        
        cardsLayout.first(cards);
        return cards;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
