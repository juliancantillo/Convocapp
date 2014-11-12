/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mauro
 */
public class Municipios {

    private int idmunicipio;
    private String namemunicipio;

    public Municipios(int idmunicipio, String namemunicipio) {
        this.idmunicipio = idmunicipio;
        this.namemunicipio = namemunicipio;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNamemunicipio() {
        return namemunicipio;
    }

    public void setNamemunicipio(String namemunicipio) {
        this.namemunicipio = namemunicipio;
    }

}
