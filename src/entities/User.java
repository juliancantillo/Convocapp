package entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Universidad del Valle Desarrollo de Software
 *
 * @author kahmos
 */
public class User implements Serializable {

    private Integer id, active;
    private String identification, username, password, email, firstname, lastname, address, phone, cellphone;
    private Timestamp create_time, update_time;

    public User(Integer id, Integer active, String identification, String username, String password, String email, String firstname, String lastname, String address, String phone, String cellphone, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.active = active;
        this.identification = identification;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.cellphone = cellphone;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public User(Integer id, Integer active, String identification, String username, String password, String email, String firstname, String lastname, String address, String phone, String cellphone) {
        /*Funcion creada para agregar los usurios a la base datos problema con las fechas*/
        this.id = id;
        this.active = active;
        this.identification = identification;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.cellphone = cellphone;

    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active == 1;
    }

    public int getActive() {
        /*Este metodo retorna el estado del usurio en valor numerico para realizar la insertcion en la 
         base de datos*/
        return active;
    }

    public void setActive(boolean active) {
        this.active = active ? 1 : 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Timestamp getCreateTime() {
        return create_time;
    }

    public Timestamp getUpdateTime() {
        return update_time;
    }

    @Override
    public String toString() {
        return String.format("%s %s [ %s ]", firstname, lastname, email);
    }

}
