/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Timestamp;

/**
 *
 * @author EEII
 */
public class Convocatory {

    private String name_convocatory;
    private int id_convocatory;
    private boolean state;
    private Timestamp open_time, closet_time,publicacion_time;

    

    public Convocatory(String name_convocatory, int id_convocatory, boolean state, Timestamp open_time, Timestamp closet_time, Timestamp publicacion_time) {
        this.name_convocatory = name_convocatory;
        this.id_convocatory = id_convocatory;
        this.state = state;
        this.open_time = open_time;
        this.closet_time = closet_time;
        this.publicacion_time = publicacion_time;
    }

    
    public boolean isState() {
        return state;
    }

    public Timestamp getPublicacion_time() {
        return publicacion_time;
    }

    
    
    
    public String getName_convocatory() {
        return name_convocatory;
    }

    public void setName_convocatory(String name_convocatory) {
        this.name_convocatory = name_convocatory;
    }

    public int getId_convocatory() {
        return id_convocatory;
    }

    public void setId_convocatory(int id_convocatory) {
        this.id_convocatory = id_convocatory;
    }

    public Timestamp getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Timestamp open_time) {
        this.open_time = open_time;
    }

    public Timestamp getCloset_time() {
        return closet_time;
    }

    public void setCloset_time(Timestamp closet_time) {
        this.closet_time = closet_time;
    }
    
    
    

}
