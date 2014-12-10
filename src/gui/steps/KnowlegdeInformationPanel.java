package gui.steps;

import dbhandler.dao.ApplicantModel;
import entities.Applicant;
import helpers.ButtonsFactory;
import helpers.GBHelper;
import helpers.Gap;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class KnowlegdeInformationPanel extends JPanel implements ActionListener, MouseListener{

    private Applicant applicant = null;
    private ApplicantModel applicantModel;
    private JLabel lblApplicantInfo;
    
    public KnowlegdeInformationPanel(Applicant applicant) {
        this.applicant = applicant;
        init();
    }
    
    private void init(){
        setLayout(new GridBagLayout());
        applicantModel = new ApplicantModel();
        
        lblApplicantInfo = new JLabel();
        
        initFields();
        
        GBHelper pos = new GBHelper();
        JLabel icon = new JLabel(R.ICON_APPLICANT);
        
        add(icon, pos.height(3).align(GBHelper.NORTHWEST));
        add(lblApplicantInfo, pos.nextCol().expandW());
        add(new Gap(R.H), pos.nextRow().nextCol());
        add(pnlCourse(), pos.nextRow().nextCol().expandW());
        add(new Gap(), pos.nextRow().nextCol().expandH());
    }
    
    private void initFields(){
        
    }
        
    private JPanel pnlCourse(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_COURSE_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));
                
        GBHelper pos = new GBHelper();
                
        panel.add(new JScrollPane(), pos.expandH().expandW().height(3));
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(ButtonsFactory.addButton(R.STR_ADD, R.ICON_ADD_USER_SMALL, this), pos.nextCol());
        panel.add(ButtonsFactory.addButton(R.STR_REMOVE, R.ICON_CANCEL_SMALL, this), pos.nextRow().nextCol().nextCol());
        panel.add(new Gap(), pos.nextRow().nextCol().nextCol());
        
        return panel;
    }
    
    public void setCurrentApplicant(Applicant currentApplicant){
        this.applicant = currentApplicant;
        lblApplicantInfo.setText( applicant.toString() );
        lblApplicantInfo.updateUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}