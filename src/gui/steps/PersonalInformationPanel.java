package gui.steps;

import controller.Convocapp;
import dbhandler.dao.LocationModel;
import entities.Applicant;
import entities.City;
import exceptions.FieldIsNotValidException;
import helpers.GBHelper;
import helpers.Gap;
import helpers.Item;
import helpers.validation.ValidationHelper;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
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
import org.jdatepicker.JDatePicker;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class PersonalInformationPanel extends JPanel {

    private JTextField fldId;
    private JTextField fldIdentification;
    private JTextField fldEmail;
    private JTextField fldFirstname;
    private JTextField fldLastname;
    private JDatePicker fldBirthdate;
    private JTextField fldAddress;
    private JTextField fldPhone;
    private JTextField fldCellphone;
    private JTextField fldCompany;
    private JTextField fldCompanyAddress;
    private JTextField fldCompanyPhone;

    private JComboBox slctSex;
    private JComboBox slctIdentificationType;
    private JComboBox slctCompanyCity;
    private JComboBox slctWorkingTime;
    private JComboBox slctCity;

    private JTextField fldCreateTime;
    private JTextField fldUpdateTime;
    private JTextField fldCreatedBy;
    private JTextField fldActive;
    private JTextField fldTotalScore;
    private JTextField fldVerified;

    private JRadioButton radioActive;
    private JRadioButton radioInactive;

    private KeyListener keyListener;

    private JDateComponentFactory dateFieldFactory;

    public PersonalInformationPanel(KeyListener keyListener) {
        this.keyListener = keyListener;

        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        initFields();

        GBHelper pos = new GBHelper();
        JLabel icon = new JLabel(R.ICON_APPLICANT);

        add(icon, pos.height(3).align(GBHelper.NORTH));
        add(pnlPersonalInfo(), pos.nextCol().expandW());
        add(pnlWorkInfo(), pos.nextRow().nextCol().expandW());
        add(new Gap(), pos.nextRow().nextCol().expandH());
    }

    private void initFields() {

        dateFieldFactory = new JDateComponentFactory();
        fldId = new JTextField();
        fldIdentification = new JTextField();
        fldEmail = new JTextField();
        fldFirstname = new JTextField();
        fldLastname = new JTextField();
        fldBirthdate = dateFieldFactory.createJDatePicker();
        fldAddress = new JTextField();
        fldPhone = new JTextField();
        fldCellphone = new JTextField();
        fldCompany = new JTextField();
        fldCompanyAddress = new JTextField();
        fldCompanyPhone = new JTextField();

        fldIdentification.setName(R.STR_IDENTIFICATION);
        fldEmail.setName(R.STR_EMAIL);
        fldFirstname.setName(R.STR_FIRSTNAME);
        fldLastname.setName(R.STR_LASTNAME);
        fldAddress.setName(R.STR_ADDRESS);
        fldPhone.setName(R.STR_PHONE);
        fldCellphone.setName(R.STR_CELLPHONE);
        fldCompany.setName(R.STR_COMPANY);
        fldCompanyAddress.setName(R.STR_COMPANY_ADDRESS);
        fldCompanyPhone.setName(R.STR_COMPANY_PHONE);

        slctSex = new JComboBox(R.LIST_SEX_VALUES);
        slctIdentificationType = new JComboBox(R.LIST_IDENTIFICATION_TYPES);
        slctWorkingTime = new JComboBox(R.LIST_WORK_TIME_VALUES);

        LocationModel location = new LocationModel();
        City cities[] = {new City(0, 0, R.STR_NULL_SELECTION, null, null)};
        try {
            cities = location.toArray();
            slctCity = new JComboBox(cities);
            slctCompanyCity = new JComboBox(cities);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        slctCity = new JComboBox(cities);
        slctCompanyCity = new JComboBox(cities);

        fldCreateTime = new JTextField();
        fldUpdateTime = new JTextField();
        fldCreatedBy = new JTextField();
        fldActive = new JTextField();
        fldTotalScore = new JTextField();
        fldVerified = new JTextField();

        radioActive = new JRadioButton(R.STR_YES);
        radioInactive = new JRadioButton(R.STR_NO);
    }

    private JPanel pnlWorkInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_WORK_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblId = new JLabel(R.STR_ID);
        JLabel lblCompany = new JLabel(R.STR_COMPANY);
        JLabel lblCompanyAddress = new JLabel(R.STR_COMPANY_ADDRESS);
        JLabel lblCompanyPhone = new JLabel(R.STR_COMPANY_PHONE);
        JLabel lblCompanyCity = new JLabel(R.STR_COMPANY_CITY);
        JLabel lblWorkingTime = new JLabel(R.STR_WORKING_TIME);
        JLabel lblCreateTime = new JLabel(R.STR_CREATE_TIME);
        JLabel lblUpdateTime = new JLabel(R.STR_UPDATE_TIME);
        JLabel lblCreatedBy = new JLabel(R.STR_CREATED_BY);
        JLabel lblActive = new JLabel(R.STR_ACTIVE);
        JLabel lblTotalScore = new JLabel(R.STR_TOTAL_SCORE);
        JLabel lblVerified = new JLabel(R.STR_VERIFIED);

        GBHelper pos = new GBHelper();

        panel.add(lblCompany, pos);
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldCompany, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblWorkingTime, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctWorkingTime, pos.nextCol().expandW());

        panel.add(new Gap(R.GAP), pos.nextCol());

        panel.add(lblCompanyPhone, pos.nextCol().nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldCompanyPhone, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblCompanyAddress, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldCompanyAddress, pos.nextCol().expandW());

        panel.add(new Gap(R.GAP), pos.nextCol());

        panel.add(lblCompanyCity, pos.nextCol().nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctCompanyCity, pos.nextCol().expandW());

        return panel;
    }

    private JPanel pnlPersonalInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_PERSONAL_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));

        JLabel lblIdentification = new JLabel(R.STR_IDENTIFICATION);
        JLabel lblIdentificationType = new JLabel(R.STR_IDENTIFICATION_TYPE);
        JLabel lblFirstname = new JLabel(R.STR_FIRSTNAME);
        JLabel lblLastname = new JLabel(R.STR_LASTNAME);
        JLabel lblBirthdate = new JLabel(R.STR_BIRTHDATE);
        JLabel lblSex = new JLabel(R.STR_SEX);
        JLabel lblCity = new JLabel(R.STR_CITY);
        JLabel lblAddress = new JLabel(R.STR_ADDRESS);
        JLabel lblEmail = new JLabel(R.STR_EMAIL);
        JLabel lblPhone = new JLabel(R.STR_PHONE);
        JLabel lblCellphone = new JLabel(R.STR_CELLPHONE);
        JLabel lblActive = new JLabel(R.STR_ACTIVE);

        ButtonGroup btnActive = new ButtonGroup();
        btnActive.add(radioActive);
        btnActive.add(radioInactive);

        fldIdentification.addKeyListener(keyListener);
        fldEmail.addKeyListener(keyListener);
        fldFirstname.addKeyListener(keyListener);
        fldLastname.addKeyListener(keyListener);
        fldAddress.addKeyListener(keyListener);
        fldPhone.addKeyListener(keyListener);
        fldCellphone.addKeyListener(keyListener);

        GBHelper pos = new GBHelper();

        panel.add(lblIdentification, pos);
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldIdentification, pos.nextCol().width(3).expandW());

        panel.add(new Gap(), pos.nextCol().nextCol().nextCol());

        panel.add(lblIdentificationType, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctIdentificationType, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblFirstname, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldFirstname, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblLastname, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldLastname, pos.nextCol().width(7).expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblBirthdate, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add((Component) fldBirthdate, pos.nextCol().width(3).expandW());

        panel.add(new Gap(), pos.nextCol().nextCol().nextCol());

        panel.add(lblSex, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctSex, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblAddress, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldAddress, pos.nextCol().width(3).expandW());

        panel.add(new Gap(), pos.nextCol().nextCol().nextCol());

        panel.add(lblEmail, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldEmail, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblPhone, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldPhone, pos.nextCol().width(3).expandW());

        panel.add(new Gap(R.GAP), pos.nextCol().nextCol().nextCol());

        panel.add(lblCellphone, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(fldCellphone, pos.nextCol().expandW());

        panel.add(new Gap(R.H), pos.nextRow());

        panel.add(lblActive, pos.nextRow());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioActive, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(radioInactive, pos.nextCol());

        panel.add(new Gap(R.GAP), pos.nextCol());

        panel.add(lblCity, pos.nextCol());
        panel.add(new Gap(R.GAP), pos.nextCol());
        panel.add(slctCity, pos.nextCol().expandW());

        return panel;
    }

    public boolean validateForm() {

        try {
            boolean validIdentification = ValidationHelper.validate(fldIdentification, ValidationHelper.NUMBERS_ONLY);
            boolean validEmail = ValidationHelper.validate(fldEmail, ValidationHelper.EMAIL);
            boolean validFirstname = ValidationHelper.validate(fldFirstname, ValidationHelper.LETTERS_ONLY);
            boolean validLastname = ValidationHelper.validate(fldLastname, ValidationHelper.LETTERS_ONLY);
            boolean validAddress = ValidationHelper.validate(fldAddress, ValidationHelper.REQUIRED);
            boolean validPhone = ValidationHelper.validate(fldPhone, ValidationHelper.NUMBERS_ONLY);
            boolean validCellphone = ValidationHelper.validate(fldCellphone, ValidationHelper.NUMBERS_ONLY);
            boolean validCompany = ValidationHelper.validate(fldCompany, ValidationHelper.LETTERS_ONLY);
            boolean validCompanyAddress = ValidationHelper.validate(fldCompanyAddress, ValidationHelper.REQUIRED);
            boolean validCompanyPhone = ValidationHelper.validate(fldCompanyPhone, ValidationHelper.NUMBERS_ONLY);
            boolean validCity = ValidationHelper.validate(slctCity, ValidationHelper.REQUIRED);
            boolean validCompanyCity = ValidationHelper.validate(slctCompanyCity, ValidationHelper.REQUIRED);
            boolean validSex = ValidationHelper.validate(slctSex, ValidationHelper.REQUIRED);
            boolean validWorkingTime = ValidationHelper.validate(slctWorkingTime, ValidationHelper.REQUIRED);

            return validIdentification && validEmail && validFirstname && validLastname && validAddress && validPhone && validCellphone && validCompany && validCompanyAddress && validCompanyPhone && validCity && validCompanyCity && validSex && validWorkingTime;
        } catch (FieldIsNotValidException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Applicant getApplicant() {

        String text = fldBirthdate.getModel().getYear() + "-" + fldBirthdate.getModel().getMonth() + "-" + fldBirthdate.getModel().getDay() + " 18:48:05.123";
        Timestamp birthdate = Timestamp.valueOf(text);

        City city = (City) slctCity.getSelectedItem();
        City companyCity = (City) slctCompanyCity.getSelectedItem();
        
        Item sex = (Item) slctSex.getSelectedItem();
        Item idType = (Item) slctIdentificationType.getSelectedItem();
        Item workingTime = (Item) slctWorkingTime.getSelectedItem();

        Applicant applicant = new Applicant(
                fldIdentification.getText(),
                idType.getKey(),
                fldEmail.getText(),
                fldFirstname.getText(),
                fldLastname.getText(),
                birthdate,
                sex.getKey(),
                city.getId(),
                fldAddress.getText(),
                fldPhone.getText(),
                fldCellphone.getText(),
                fldCompany.getText(),
                companyCity.getId(),
                fldCompanyAddress.getText(),
                fldCompanyPhone.getText(),
                workingTime.getKey(),
                Convocapp.loggedUser.getId(),
                city.getName(),
                companyCity.getName()
        );

        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        fldIdentification.setText(applicant.getIdentification());
        fldEmail.setText(applicant.getEmail());
        fldFirstname.setText(applicant.getFirstname());
        fldLastname.setText(applicant.getLastname());
        fldAddress.setText(applicant.getAddress());
        fldPhone.setText(applicant.getPhone());
        fldCellphone.setText(applicant.getCellphone());
        fldCompany.setText(applicant.getCompany());
        fldCompanyAddress.setText(applicant.getCompanyAddress());
        fldCompanyPhone.setText(applicant.getCompanyPhone());
        
        LocationModel location = new LocationModel();
        
        try {
            slctCity.setSelectedItem(location.read(applicant.getCityId()));
            slctCompanyCity.setSelectedItem(location.read(applicant.getCompanyCityId()));
        } catch (SQLException ex) {
            R.showErrorMessage(this, ex.getMessage());
        }
        
        slctSex.setSelectedItem( R.getItemFromList(applicant.getSex(), R.LIST_SEX_VALUES) );
        slctIdentificationType.setSelectedItem( R.getItemFromList(applicant.getIdentificationType(), R.LIST_IDENTIFICATION_TYPES) );
        slctWorkingTime.setSelectedItem( R.getItemFromList(applicant.getWorkingTime(), R.LIST_WORK_TIME_VALUES) );
        
        
    }

}