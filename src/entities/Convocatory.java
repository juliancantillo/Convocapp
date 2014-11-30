/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author EEII
 */
public class Convocatory {

    private String name_convocatory, description;
    private int id_convocatory;
    private boolean state;
    private Date open_time, closet_time, publicacion_time;

    public Convocatory(int id_convocatory, String name_convocatory, boolean state, Date open_time, Date closet_time, Date publicacion_time, String description) {
        this.name_convocatory = name_convocatory;
        this.id_convocatory = id_convocatory;
        this.state = state;
        this.open_time = open_time;
        this.closet_time = closet_time;
        this.publicacion_time = publicacion_time;
        this.description = description;
    }

    public Convocatory(String name_convocatory, boolean state, Date open_time, Date closet_time, Date publicacion_time, String description) {
        this.name_convocatory = name_convocatory;
        this.id_convocatory = id_convocatory;
        this.state = state;
        this.open_time = open_time;
        this.closet_time = closet_time;
        this.publicacion_time = publicacion_time;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int isState() {
        int salida = 0;
        if (state) {
            salida = 1;
        }
        return salida;
    }

    public Date getPublicacion_time() {
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

    public Date getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Date open_time) {
        this.open_time = open_time;
    }

    public Date getCloset_time() {
        return closet_time;
    }

    public void setCloset_time(Date closet_time) {
        this.closet_time = closet_time;
    }

}
