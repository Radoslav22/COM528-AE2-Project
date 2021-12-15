/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.com504.oodd.cart.web.test;

import java.io.File;
import org.junit.After;
import org.junit.Test;
import org.solent.com504.oodd.cart.web.PropertiesDao;
import org.solent.com504.oodd.cart.web.WebObjectFactory;

/**
 *
 * @author Radoslav
 */
public class WebObjectFactoryTest {

    @Test
    public void testGetPropertiesDao() {
        PropertiesDao propertiesDao = WebObjectFactory.getPropertiesDao();

    }

    @After
    public void after() {
        // remove properties file after test
        try {
            String TEMP_DIR = System.getProperty("java.io.tmpdir");
            File propertiesFile = new File(TEMP_DIR + "/application.properties");
            System.out.println("deleting test properties file:"+propertiesFile.getAbsolutePath());
            propertiesFile.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

