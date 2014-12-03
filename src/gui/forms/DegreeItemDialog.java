package gui.forms;

import dbhandler.dao.DegreeModel;
import dbhandler.dao.LocationModel;
import entities.Applicant;
import entities.ApplicantDegree;
import entities.City;
import entities.Degree;
import helpers.ButtonsFactory;
import helpers.GBHelper;
import helpers.Gap;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class DegreeItemDialog extends JDialog {

    private JTextField fldTitle;
    private JTextField fldGraduateYear;
    private JTextArea fldNotes;
    private JTextField fldInstitutionName;
    private JComboBox slctInstitutionCity;
    private JComboBox slctDegree;
    private final ActionListener actionListener;

    public DegreeItemDialog(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        initFields();
        
        setLayout(new BorderLayout(R.W, R.H));
        
        add(pnlFields(), BorderLayout.CENTER);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
    }

    private void initFields() {

        fldTitle = new JTextField();
        fldGraduateYear = new JTextField();
        fldNotes = new JTextArea();
        fldInstitutionName = new JTextField();

        DegreeModel degreeModel = new DegreeModel();
        LocationModel location = new LocationModel();
        try {
            slctDegree = new JComboBox(degreeModel.toArray());
            slctInstitutionCity = new JComboBox(location.toArray());
        } catch (SQLException ex) {
            R.showErrorMessage(this, ex.getMessage());
        }

    }
    
    private JPanel pnlButtons(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, R.W, R.H));
        
        panel.add(ButtonsFactory.createButton(R.STR_SAVE, R.ICON_CHECK_SMALL, R.CMD_SAVE, this.actionListener));
        panel.add(ButtonsFactory.createButton(R.STR_CANCEL, R.ICON_CANCEL_SMALL, R.CMD_CANCEL, this.actionListener));
        
        return panel;
    }

    private JPanel pnlFields() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_DEGREE_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblTitle = new JLabel(R.STR_TITLE);
        JLabel lblGraduateYear = new JLabel(R.STR_GRADUATE_YEAR);
        JLabel lblNotes = new JLabel(R.STR_NOTES);
        JLabel lblInstitutionName = new JLabel(R.STR_INSTITUTION_NAME);
        JLabel lblInstitutionCity = new JLabel(R.STR_INSTITUTION_CITY);
        JLabel lblDegree = new JLabel(R.STR_DEGREE_TYPE);

        GBHelper pos = new GBHelper();

        panel.add(lblTitle, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldTitle, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblGraduateYear, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldGraduateYear, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblNotes, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldNotes, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblInstitutionName, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldInstitutionName, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblInstitutionCity, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(slctInstitutionCity, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblDegree, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(slctDegree, pos.nextCol().expandW());
        
        panel.add(new Gap(R.H), pos.nextRow().expandH());

        return panel;
    }
    
    public ApplicantDegree getApplicantDegree(Applicant applicant){
        Degree degree = (Degree) slctDegree.getSelectedItem();
        String institutionName = fldInstitutionName.getText();
        City city = (City) slctInstitutionCity.getSelectedItem();
        String degree_title = fldTitle.getText();
        String graduateYear = fldGraduateYear.getText();
        String notes = fldNotes.getText();
        
        return new ApplicantDegree(applicant.getId(), degree, institutionName, city, degree_title, graduateYear, notes);
    }

}
