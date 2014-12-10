package gui.forms;

import dbhandler.dao.ApplicantModel;
import entities.Applicant;
import gui.steps.CoursesInformationPanel;
import gui.steps.DegreeInformationPanel;
import gui.steps.PersonalInformationPanel;
import helpers.ButtonsFactory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class CreateApplicantResumeForm extends JFrame implements ActionListener, KeyListener{

    private PersonalInformationPanel personalInformationPanel;
    private DegreeInformationPanel degreeInformationPanel;
    private CoursesInformationPanel coursesInformationPanel;
    private JPanel cards;
    private CardLayout cardsLayout;
    private int currentStep = 0;
    private Applicant currentApplicant = null;
    
    public CreateApplicantResumeForm() {
        initComponents();
    }
    
    public CreateApplicantResumeForm(Applicant applicant){
        this.currentApplicant = applicant;
        System.out.print(String.format("Editing %s", applicant));
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new BorderLayout(R.H, R.W));
        
        personalInformationPanel = new PersonalInformationPanel(this);
        degreeInformationPanel = new DegreeInformationPanel(currentApplicant);
        coursesInformationPanel = new CoursesInformationPanel(currentApplicant);
        
        cards = cardsPanel();
        
        add(cards, BorderLayout.CENTER);
        add(pnlButtons(), BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
    
    private JPanel cardsPanel(){
        JPanel pnlCards = new JPanel();
        cardsLayout = new CardLayout(R.H, R.W);
        pnlCards.setLayout(cardsLayout);
        
        pnlCards.add( personalInformationPanel, R.STR_PERSONAL_INFO);
        pnlCards.add( degreeInformationPanel, R.STR_DEGREE_INFO);
        pnlCards.add( coursesInformationPanel, R.STR_COURSE_INFO);
        
        cardsLayout.first(pnlCards);
        return pnlCards;
    }
    
    private JPanel pnlButtons(){
        JPanel panel = new JPanel();
        
        panel.add( ButtonsFactory.addButton(R.STR_PREV, this) );
        panel.add( ButtonsFactory.addButton(R.STR_NEXT, this) );
        
        return panel;
    }
    
    public void fillForm() throws NullPointerException{
        personalInformationPanel.setApplicant(currentApplicant);
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
            
            switch(currentStep){
                case 1:
                    if (degreeInformationPanel.hasItems()) {
                        coursesInformationPanel.setCurrentApplicant(currentApplicant);
                        cardsLayout.next(cards);
                        currentStep++;
                    }
                    break;
                default:
                    if( personalInformationPanel.validateForm() ){
                        if(currentApplicant != null){
                            cardsLayout.next(cards);
                            currentStep++;
                        }else{        
                            currentApplicant = personalInformationPanel.getApplicant();
                            ApplicantModel applicantModel = new ApplicantModel();
                            try {
                                // Create the new applicant in the database
                                int id = applicantModel.create(currentApplicant);
                                currentApplicant.setId(id);
                                degreeInformationPanel.setCurrentApplicant(currentApplicant);
                                // Next step
                                cardsLayout.next(cards);
                                currentStep++;
                            } catch (SQLException ex) {
                                R.showErrorMessage(this, ex.getMessage());
                            }
                        }
                    }
                    break;
            }
        }
        if( e.getActionCommand().equals(R.STR_PREV) ){
            if(currentStep > 0){
                cardsLayout.previous(cards);
                currentStep--;
            }
        }
    }
    
}
