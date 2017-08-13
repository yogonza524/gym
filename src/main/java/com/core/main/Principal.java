/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.main;

import com.core.managers.SocioManager;
import com.core.models.Socio;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
@RestController
public class Principal {

    @Autowired SocioManager socioManager;
    
    @RequestMapping("/socio/{id}")
    public Socio socioById(@PathVariable String id) {
        return socioManager.byId("id", id, Socio.class);
    }
    
    @RequestMapping(value = "/socio/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteSocio(@PathVariable String id) {
        return Collections.singletonMap("deleted", socioManager.deleteById(id));
    }
    
    @RequestMapping(value = "/socio", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Key<Socio>> createSocio(@RequestBody Socio socio) {
        return new ResponseEntity(socioManager.add(socio), HttpStatus.CREATED);
    }
    
    @RequestMapping("/socio")
    public List<Socio> all(){
        return socioManager.all();
    }
}
