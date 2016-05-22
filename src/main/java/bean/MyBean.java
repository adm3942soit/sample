/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Collection;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Oxana
 */
@Stateless
public class MyBean {
@PersistenceContext(unitName="WebApplicationPU")
private EntityManager em;
    public int addNumbers(int numberA, int numberB) {
        return numberA + numberB;
    }
@PermitAll
public int verify() {
    String result = null;
    Query q = em.createNamedQuery("Messages.findAll");
    Collection entities = q.getResultList();
    int s = entities.size();
    for (Object o : entities) {
        Messages se = (Messages)o;
        System.out.println("Found: " + se.getData());
    }

    return s;
}

@PermitAll
public void insert(int num) {
    for (int i = 1; i <= num; i++) {
        System.out.println("Inserting # " + i);
        Messages e = new Messages(i);
        em.persist(e);
    }
}     
}
