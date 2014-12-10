package gui.forms;

import dbhandler.dao.DegreeModel;
import dbhandler.dao.LocationModel;
import entities.Applicant;
import entities.ApplicantCourse;
import entities.ApplicantDegree;
import entities.City;
import entities.Degree;
import exceptions.FieldIsNotValidException;
import helpers.ButtonsFactory;
import helpers.GBHelper;
import helpers.Gap;
import helpers.validation.ValidationHelper;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class CourseItemDialog extends JDialog {

    private JTextField fldTitle;
    private JTextField fldGraduateYear;
    private JTextField fldHours;
    private JTextArea fldNotes;
    private JTextField fldInstitutionName;
    private JComboBox slctInstitutionCity;
    private final ActionListener actionListener;

    public CourseItemDialog(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        initFields();
        setIconImage(R.ICON_ADD.getImage());
        setLayout(new BorderLayout(R.W, R.H));
        
        add(pnlFields(), BorderLayout.CENTER);
        add(pnlButtons(), BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
    }

    private void initFields() {

        fldTitle = new JTextField();
        fldGraduateYear = new JTextField();
        fldNotes = new JTextArea();
        fldInstitutionName = new JTextField();
        fldHours = new JTextField();

        LocationModel location = new LocationModel();
        try {
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
        Border border = new TitledBorder(R.STR_COURSE_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblTitle = new JLabel(R.STR_TITLE);
        JLabel lblGraduateYear = new JLabel(R.STR_GRADUATE_YEAR);
        JLabel lblNotes = new JLabel(R.STR_NOTES);
        JLabel lblInstitutionName = new JLabel(R.STR_INSTITUTION_NAME);
        JLabel lblInstitutionCity = new JLabel(R.STR_INSTITUTION_CITY);
        JLabel lblHours = new JLabel(R.STR_HOURS);

        GBHelper pos = new GBHelper();

        panel.add(lblTitle, pos);
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldTitle, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblGraduateYear, pos.nextRow());
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldGraduateYear, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblInstitutionName, pos.nextRow());
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldInstitutionName, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblInstitutionCity, pos.nextRow());
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(slctInstitutionCity, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblHours, pos.nextRow());
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(fldHours, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblNotes, pos.nextRow().align(GBHelper.NORTHWEST));
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(new JScrollPane(fldNotes), pos.nextCol().expandW().expandH());

        return panel;
    }
    
    public ApplicantCourse getApplicantCourse(Applicant applicant){
        
        ApplicantCourse applicantCourse = null;
        
        String institutionName = fldInstitutionName.getText();
        Integer hours = Integer.parseInt(fldHours.getText());
        City city = (City) slctInstitutionCity.getSelectedItem();
        String course_title = fldTitle.getText();
        String graduateYear = fldGraduateYear.getText();
        String notes = fldNotes.getText();
        
        try {
            applicantCourse = new ApplicantCourse(
                    applicant.getId(),
                    institutionName,
                    city, course_title,
                    graduateYear, hours,
                    notes);
        } catch (Exception e) {
            R.showErrorMessage(this, e.getMessage());
        }
        
        return applicantCourse;
    }
    
    public boolean validateForm() {

        try {
            boolean validTitle = ValidationHelper.validate(fldTitle, ValidationHelper.LETTERS_ONLY);
            boolean validGraduateYear = ValidationHelper.validate(fldGraduateYear, ValidationHelper.NUMBERS_ONLY);
            boolean validInstitutionName = ValidationHelper.validate(fldInstitutionName, ValidationHelper.LETTERS_ONLY);
            boolean validHours = ValidationHelper.validate(fldHours, ValidationHelper.NUMBERS_ONLY);

            return validTitle && validGraduateYear && validInstitutionName && validHours;
            
        } catch (FieldIsNotValidException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
