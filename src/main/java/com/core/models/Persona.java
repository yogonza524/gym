/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.models;

import java.util.Comparator;
import java.util.Date;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
public abstract class Persona extends Base implements Comparator<Persona>{
    
    @Property("nombre") private String nombre;
    @Property("apellido") private String apellido;
    @Property("dni") private String dni;
    @Property("domicilio") private String domicilio;
    @Property("tel") private String tel;
    @Property("cel") private String cel;
    @Property("nacimiento") private Date nacimiento;

    public Persona() {
        super();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    
}
