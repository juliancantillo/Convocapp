/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandler.dao;

import dbhandler.DBConnector;
import entities.Municipios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author the tecnology
 */
public class ReportModel {

    private final Connection conn;
    private final DBConnector dbc;

    public ReportModel() {
        dbc = new DBConnector();
        conn = dbc.connect();
    }

    public Vector<String> BestAplicant(int i) throws SQLException {
        String user = null;
        String sql = "";
        sql = String.format("SELECT `firstname`, `lastname`,`identification`,`name` FROM `applicant`,`city` WHERE city.id = city_id ORDER BY totalScore LIMIT %s ;", i);
        System.out.println("report best " + sql);
        Vector<String> arrayAplicant = new Vector<>();

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            user = " Nombre:   " + rs.getString("firstname")
                    + "   Apellido: " + rs.getString("lastname")
                    + "  Identificacion  " + rs.getString("identification") + " "
                    + "   Ciudad:  " + " " + rs.getString("name");
            arrayAplicant.add(user);
        }

        return arrayAplicant;
    }

    public Vector<String> AllAplicant() throws SQLException {
        String user = null;
        String sql = "";
        sql = String.format("SELECT `firstname`, `lastname`,`identification`,`name` FROM `applicant`,`city` WHERE city.id = city_id ORDER BY totalScore");
        System.out.println("report best " + sql);
        Vector<String> arrayAplicant = new Vector<>();

        Statement st;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            user = " Nombre:   " + rs.getString("firstname")
                    + "   Apellido: " + rs.getString("lastname")
                    + "  Identificacion  " + rs.getString("identification") + " "
                    + "   Ciudad:  " + " " + rs.getString("name");
            arrayAplicant.add(user);
        }

        return arrayAplicant;
    }

}
