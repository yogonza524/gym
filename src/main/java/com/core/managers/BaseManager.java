/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.managers;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.mongodb.morphia.Key;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
public abstract class BaseManager<T> {

    public abstract List<T> all();
    public abstract T byId(Key<T> id);
    public abstract boolean update(T entity, Class<T> clazz);
    public abstract List<T> byId(String attributeName, Object value, Class<T> clazz);
    
    public List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }
}
