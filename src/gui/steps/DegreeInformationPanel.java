package gui.steps;

import dbhandler.dao.ApplicantModel;
import dbhandler.dao.UserModel;
import entities.Applicant;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DegreeInformationPanel extends JPanel implements ActionListener, MouseListener, TableModelListener{

    private JTable tblDegree;
    private Applicant applicant = null;
    private ApplicantModel applicantModel;
    private DegreeItemDialog dialog;
    
    public DegreeInformationPanel() {
        init();
    }

    public DegreeInformationPanel(Applicant applicant) {
        this.applicant = applicant;
        init();
    }
    
    private void init(){
        setLayout(new GridBagLayout());
        applicantModel = new ApplicantModel();
        
        initFields();
        
        GBHelper pos = new GBHelper();
        JLabel icon = new JLabel(R.ICON_APPLICANT);
        
        add(icon, pos.height(3).align(GBHelper.NORTH));
        add(pnlDegree(), pos.nextCol().expandW());
        add(new Gap(), pos.nextRow().nextCol().expandH());
    }
    
    private void initFields(){
        
    }
    
    private JPanel pnlDegree(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Border border = new TitledBorder(R.STR_DEGREE_INFO);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(new CompoundBorder(border, margin));
                
        GBHelper pos = new GBHelper();

        ResultSet tableData = null;
        try {
            int id = applicant != null ? applicant.getId() : 0;
            tableData = applicantModel.getDegreeInformation( id );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, String.format(R.ERROR_LOAD_DATA_FAILS, ex.getMessage()), R.STR_ERROR, JOptionPane.ERROR_MESSAGE);
        }

        tblDegree = new JTable(new ResultsetTableModel(tableData, R.SRT_DEGREE_COLUMNS));
        tblDegree.getModel().addTableModelListener(this);
        tblDegree.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDegree.setRowHeight(28);
        tblDegree.addMouseListener(this);
        
        panel.add(new JScrollPane(tblDegree), pos.expandH().expandW().height(3));
        panel.add(new Gap(R.W), pos.nextCol());
        panel.add(ButtonsFactory.addButton(R.STR_ADD, R.ICON_ADD_USER_SMALL, this), pos.nextCol());
        panel.add(ButtonsFactory.addButton(R.STR_REMOVE, R.ICON_CANCEL_SMALL, this), pos.nextRow().nextCol().nextCol());
        panel.add(new Gap(), pos.nextRow().nextCol().nextCol());
        
        return panel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(R.STR_ADD)) {
            dialog = new DegreeItemDialog(this);
            dialog.setVisible(true);
        }
        if(cmd.equals(R.CMD_SAVE)){
            try {
                applicantModel.insertDegreeInformation( dialog.getApplicantDegree(applicant) );
            } catch (SQLException ex) {
                R.showErrorMessage(this, ex.getMessage());
            }
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
    public void tableChanged(TableModelEvent e) {}
}