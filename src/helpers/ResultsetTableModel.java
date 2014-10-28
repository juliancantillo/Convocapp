package helpers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import resources.R;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class ResultsetTableModel extends AbstractTableModel {

    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private String colNames[];

    /**
     * Constructs the table model.
     *
     * @param aResultSet the result set to display.
     */
    public ResultsetTableModel(ResultSet aResultSet) {

        rs = aResultSet;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultsetTableModel(ResultSet aResultSet, String[] cNames) {
        colNames = cNames;
        rs = aResultSet;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public ResultsetTableModel(ResultSet rs, TableModelListener listener) {
        this(rs);
        this.addTableModelListener(listener);
    }

    public ResultsetTableModel(ResultSet rs, String[] cNames, TableModelListener listener) {
        this(rs, cNames);
        this.addTableModelListener(listener);
    }

    @Override
    public String getColumnName(int c) {
        try {
            if (colNames != null) {
                return colNames[c];
            } else {
                return rsmd.getColumnName(c + 1);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public Object getValueAt(int r, int c) {
        try {
            rs.absolute(r + 1);
            
            if(rsmd.getColumnName(c + 1).equals("active") && (Integer) rs.getObject(c + 1) == 1 ){
                return R.ICON_CHECK_SMALL;
            }else if(rsmd.getColumnName(c + 1).equals("active") && (Integer) rs.getObject(c + 1) == 0 ){
                return R.ICON_CANCEL_SMALL;
            }
            
            return rs.getObject(c + 1);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }
    
    @Override
    public Class getColumnClass(int column){
        return getValueAt(0, column).getClass();
    }
}
