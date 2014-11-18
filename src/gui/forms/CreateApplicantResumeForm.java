package gui.forms;

import gui.steps.PersonalInformationPanel;
import helpers.ButtonsFactory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CreateApplicantResumeForm extends JFrame implements ActionListener, KeyListener{

    private PersonalInformationPanel personalInformationPanel;
    private JPanel cards;
    private CardLayout cardsLayout;
    private int currentStep = 0;
    
    public CreateApplicantResumeForm() {
        initComponents();
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        //setSize(400,380);
    }
    
    private void initComponents(){
        setLayout(new BorderLayout(R.H, R.W));
        
        personalInformationPanel = new PersonalInformationPanel(this);
        cards = cardsPanel();
        
        
        add(cards, BorderLayout.CENTER);
        add(pnlButtons(), BorderLayout.SOUTH);
        
    }
    
    private JPanel cardsPanel(){
        JPanel pnlCards = new JPanel();
        cardsLayout = new CardLayout(R.H, R.W);
        pnlCards.setLayout(cardsLayout);
        
        pnlCards.add( personalInformationPanel, R.STR_PERSONAL_INFO);
        
        cardsLayout.first(pnlCards);
        return pnlCards;
    }
    
    private JPanel pnlButtons(){
        JPanel panel = new JPanel();
        
        panel.add( ButtonsFactory.addButton(R.STR_PREV, this) );
        panel.add( ButtonsFactory.addButton(R.STR_NEXT, this) );
        
        return panel;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getActionCommand().equals(R.STR_NEXT)){
            System.out.print(personalInformationPanel.validateForm());
        }
    }
    
}
