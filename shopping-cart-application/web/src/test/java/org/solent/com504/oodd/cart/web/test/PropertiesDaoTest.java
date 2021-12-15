/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Radoslav
 */

package org.solent.com504.oodd.cart.web.test;


import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.oodd.cart.web.PropertiesDao;

public class PropertiesDaoTest {

    public final String TEST_PROPERTIES_FILE = "./target/test/propertiesDaoTest.properties";

    @Before
    public void before() {
        // make sue file doesnt exist
        File propertiesFile = new File(TEST_PROPERTIES_FILE);
        if (propertiesFile.exists()) {
            propertiesFile.delete();
        }
    }

    @Test
    public void testPropertiesDao() {
        PropertiesDao propertiesDao = new PropertiesDao(TEST_PROPERTIES_FILE);

        propertiesDao.setProperty("org.solent.com504.oodd.cart.web.testPropertiesFile", TEST_PROPERTIES_FILE);
        propertiesDao.setProperty("org.solent.com504.oodd.cart.web.username", "testUserName");
        propertiesDao.setProperty("org.solent.com504.oodd.cart.web.password", "testPassword");
        propertiesDao.setProperty("org.solent.com504.oodd.cart.web.url", "http://google.com");

        String url = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.url");
        assertEquals("http://google.com", url);

        // test with different dao (normally there wiill only be one dao for the file)
        PropertiesDao propertiesDao2 = new PropertiesDao(TEST_PROPERTIES_FILE);
        String url2 = propertiesDao2.getProperty("org.solent.com504.oodd.cart.web.url");
        assertEquals("http://google.com", url2);
        
        // note that the file will contain org.solent.ood.simplepropertiesdaowebapp.url=http\://google.com
        // with an extra | escape characters. see discussion here
        // https://stackoverflow.com/questions/21711562/java-properties-class-adding-characters-when-url-is-entered
    }
}

