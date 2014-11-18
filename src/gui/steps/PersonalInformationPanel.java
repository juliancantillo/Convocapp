package gui.steps;

import helpers.GBHelper;
import helpers.Gap;
import java.awt.GridBagLayout;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
public class PersonalInformationPanel extends JPanel {

    private JTextField fldId;
    private JTextField fldIdentification;
    private JTextField fldEmail;
    private JTextField fldFirstname;
    private JTextField fldLastname;
    private JTextField fldBirthdate;
    private JTextField fldSex;
    private JTextField fldAddress;
    private JTextField fldPhone;
    private JTextField fldCellphone;
    private JTextField fldCompany;
    private JTextField fldCompanyAddress;
    private JTextField fldCompanyPhone;

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

    public PersonalInformationPanel(KeyListener keyListener) {
        this.keyListener = keyListener;
    }
    
    public void init(){
        setLayout(new GridBagLayout());
        
        initFields();
        
        GBHelper pos = new GBHelper();
        JLabel icon = new JLabel(R.ICON_APPLICANT);
        
        add(icon, pos);
        add(pnlPersonalInfo(), pos.nextCol());
    }

    public void initFields() {

        fldId = new JTextField();
        fldIdentification = new JTextField();
        fldEmail = new JTextField();
        fldFirstname = new JTextField();
        fldLastname = new JTextField();
        fldBirthdate = new JTextField();
        fldSex = new JTextField();
        fldAddress = new JTextField();
        fldPhone = new JTextField();
        fldCellphone = new JTextField();
        fldCompany = new JTextField();
        fldCompanyAddress = new JTextField();
        fldCompanyPhone = new JTextField();

        slctIdentificationType = new JComboBox();
        slctCompanyCity = new JComboBox();
        slctWorkingTime = new JComboBox();
        slctCity = new JComboBox();

        fldCreateTime = new JTextField();
        fldUpdateTime = new JTextField();
        fldCreatedBy = new JTextField();
        fldActive = new JTextField();
        fldTotalScore = new JTextField();
        fldVerified = new JTextField();
        
        radioActive = new JRadioButton(R.STR_YES);
        radioInactive = new JRadioButton(R.STR_NO);
    }

    public void buildForm() {
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

    }

    public final JPanel pnlPersonalInfo() {
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
        
        panel.add(lblIdentificationType, pos);
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

}
