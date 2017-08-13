/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.connectors;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Gonzalo H. Mendoza
 * @email yogonza524@gmail.com
 * 
 */
public class DataBase {

    private static Datastore datastore;
    
    
    private DataBase(){}
    
    public static Datastore get(){
        if (datastore == null) {
            String dbName = "gym";
            MongoClient mongo = new MongoClient();
            Morphia morphia = new Morphia();
           
            datastore = morphia.createDatastore(mongo, dbName);      

            morphia.mapPackage("com.core.models");
        }
        return datastore;
    }
}
