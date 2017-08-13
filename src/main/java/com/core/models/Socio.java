/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.models;

import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
@Entity("socios")
public class Socio extends Persona{

    @Property("fechaDeIngreso") private Date fechaDeIngreso;

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getApellido().compareTo(o2.getApellido());
    }
}
