/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.managers;

import com.core.connectors.DataBase;
import com.core.models.Socio;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.Key;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
public class SocioManager extends BaseManager<Socio>{

    @Override
    public List<Socio> all() {
        return DataBase.get().createQuery(Socio.class).asList();
    }

    @Override
    public Socio byId(Key<Socio> id) {
        return DataBase.get().createQuery(Socio.class).field("id").equal(id.getId()).get();
    }

    @Override
    public boolean update(Socio entity, Class<Socio> clazz) {
        return true;
    }

    @Override
    public List<Socio> byId(String attributeName, Object value, Class<Socio> clazz) {
        return DataBase.get().createQuery(clazz).field(attributeName).equal(value).asList();
    }

}
