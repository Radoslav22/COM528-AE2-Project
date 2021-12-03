/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.oodd.cart.service.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.solent.com504.oodd.cart.model.dto.ShoppingItem;
import org.solent.com504.oodd.cart.model.service.ShoppingService;
import org.solent.com504.oodd.cart.service.ServiceObjectFactory;
import org.solent.com504.oodd.cart.service.spring.test.ServiceTestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author cgallen
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = ServiceTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ShoppingServiceTest {

    @Autowired
    ShoppingService shoppingService = null;

    @Before
    public void before() {
        //shoppingService = ServiceObjectFactory.getShoppingService();

    }

    @Test
    public void test1() {
        assertNotNull(shoppingService);
        
        List<ShoppingItem> availableItems = shoppingService.getAvailableItems();
        assertFalse(availableItems.isEmpty());
        
        ShoppingItem item = availableItems.get(0);
        shoppingService.changeStock(item.getName(), 1000);
        
        ShoppingItem item2 = shoppingService.getItemByName(item.getName());
        assertEquals(new Integer(1000) ,item2.getStock());
        
    }
}
