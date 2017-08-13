/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.managers.SocioManager;
import com.core.models.Socio;
import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mongodb.morphia.Key;

/**
 *
 * @author Usuario
 */
public class SocioTest {
    
    public SocioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void socioAddTest() {
         SocioManager sm = new SocioManager();
         
         Socio s = new Socio();
         s.setNombre("Gonzalo");
         s.setApellido("Mendoza");
         
         //System.out.println(sm.add(s));
         Gson g = new Gson();
         System.out.println(g.toJson(s));
         
         
     }
}
