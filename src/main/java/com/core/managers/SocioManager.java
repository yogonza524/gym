/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.managers;

import com.core.connectors.DataBase;
import com.core.models.Socio;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
@Service
public class SocioManager extends BaseManager<Socio>{

    @Override
    public List<Socio> all() {
        return DataBase.get().createQuery(Socio.class).asList();
    }

    @Override
    public Socio byKey(Key<Socio> id) {
        return DataBase.get().getByKey(Socio.class, id);
    }

    @Override
    public boolean update(Socio entity, Class<Socio> clazz) {
        List<Field> fields = super.getAllFields(new LinkedList<>(), clazz);
        Query<Socio> query = DataBase.get().createQuery(clazz).field("id").equal(entity.getId());
        UpdateOperations<Socio> up = DataBase.get().createUpdateOperations(clazz);
        
        boolean result = false;
        
        try {
                for(Field f : fields){
                    up.set(f.getName(), f.get(entity));
                }
                
                result = DataBase.get().update(query, up).getUpdatedCount() > 0;
                
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(SocioManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SocioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return result;
    }

    @Override
    public Socio byId(String attributeName, Object value, Class<Socio> clazz) {
        List<Socio> socios = DataBase.get().createQuery(clazz).asList();
        Optional<Socio> res = socios.stream().filter(socio -> socio.getId().toString().equals(value)).findFirst();
        return res != null && res.isPresent() ? res.get() : null;
    }

    @Override
    public Key<Socio> add(Socio entity) {
        return DataBase.get().save(entity);
    }

    @Override
    public boolean delete(Socio entity) {
        return DataBase.get().delete(entity).getN() > 0;
    }

    @Override
    public boolean deleteById(String id) {
        List<Socio> socios = DataBase.get().createQuery(Socio.class).asList();
        Optional<Socio> res = socios.stream().filter(socio -> socio.getId().toString().equals(id)).findFirst();
        
        if (res != null && res.isPresent()) {
            return delete(res.get());
        }
        return false;
    }

}
