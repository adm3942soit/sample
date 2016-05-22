/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 *
 * @author Oxana
 */
public class MyBeanTest{
    static EJBContainer container;
    static MyBean instance;
    public MyBeanTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "glassfish");
        properties.put(EJBContainer.APP_NAME, "sample");
        container = EJBContainer.createEJBContainer();
        try {
            instance = (MyBean) container.getContext().lookup("java:global/main/MyBean");
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    @AfterClass
    public static void tearDownClass() {
        if (container != null) {
            container.close();
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNumbers method, of class MyBean.
     */
    @Test
    public void testAddNumbers() throws Exception {
        System.out.println("addNumbers");
        int numberA = 0;
        int numberB = 0;



        int expResult = 0;
        int result = instance.addNumbers(numberA, numberB);
        assertEquals(expResult, result);

    }

    /**
     * Test of verify method, of class MyBean.
     */
   /* @Test
    public void testVerify() throws Exception {
        System.out.println("verify");


        int expResult = 0;
        int result = instance.verify();
        assertEquals(expResult, result);

    }*/

    /**
     * Test of insert method, of class MyBean.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        int num = 0;


        instance.insert(num);

}
    
}
