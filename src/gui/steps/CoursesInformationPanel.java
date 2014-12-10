package gui.steps;

import dbhandler.dao.ApplicantModel;
import entities.Applicant;
import gui.forms.CourseItemDialog;
import gui.forms.DegreeItemDialog;
import helpers.ButtonsFactory;
import helpers.GBHelper;
import helpers.Gap;
import helpers.ResultsetTableModel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import resources.R;

/**
 * Universidad del Valle
 * Desarrollo de Software 
 * @author kahmos
 */
public class CoursesInformationPanel extends JPanel implements ActionListener, MouseListener, TableModelListener, WindowListener{

    private JTable tblCourse;
    private Applicant applicant = null;
    private ApplicantModel applicantModel;
    private CourseItemDialog dialog;
    private JLabel lblApplicantInfo;
    
    public CoursesInformationPanel(Applicant applicant) {
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
    
    private void initTable(){
        ResultSet tableData;
        try {
            int id = applicant != null ? applicant.getId() : 0;
            tableData = applicantModel.getCourseInformation( id );            
            tblCourse.setModel(new ResultsetTableModel(tableData, R.SRT_COURSE_COLUMNS, this));
            tblCourse.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private JPanel pnlCourse(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_COURSE_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));
                
        GBHelper pos = new GBHelper();

        tblCourse = new JTable();
        initTable();
        tblCourse.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblCourse.setRowHeight(28);
        tblCourse.addMouseListener(this);
        tblCourse.getModel().addTableModelListener(this);
                
        panel.add(new JScrollPane(tblCourse), pos.expandH().expandW().height(3));
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
        String cmd = e.getActionCommand();
        if (cmd.equals(R.STR_ADD)) {
            dialog = new CourseItemDialog(this);
            dialog.addWindowListener(this);
            dialog.setVisible(true);
        }
        if(cmd.equals(R.CMD_SAVE)){
            if (dialog.validateForm()) {
                try {
                    System.out.print(String.format("Adding course info to %s", applicant));
                    applicantModel.insertCourseInformation(dialog.getApplicantCourse(applicant));
                } catch (SQLException ex) {
                    R.showErrorMessage(this, ex.getMessage());
                }
            }
        }
        if(cmd.equals(R.CMD_CANCEL)){
            dialog.dispose();
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
            initTable();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if (e.getSource() instanceof DegreeItemDialog) {
            ResultsetTableModel rm = (ResultsetTableModel) tblCourse.getModel();
            rm.fireTableDataChanged();
        }
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
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}