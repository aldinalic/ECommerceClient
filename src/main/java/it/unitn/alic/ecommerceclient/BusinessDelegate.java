package it.unitn.alic.ecommerceclient;

import it.unitn.alic.ecommerceserver.ejb.Facade;
import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

public class BusinessDelegate {

    Facade facadeEJB;

    public BusinessDelegate() {
        try {
            String jndiName = "ejb:/ECommerceServer-1.0-SNAPSHOT/FacadeEJB!it.unitn.alic.ecommerceserver.ejb.Facade";
            facadeEJB = (Facade) ServiceLocator.getService(jndiName);
        } catch (Exception e) {
            System.out.println("Encountered an Exception " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public CustomerEntity getCustomer(int id) {
        try {
            CustomerEntity newCustomer = facadeEJB.getCustomer(id);
            System.out.println("Obtained Customer from facade: " + newCustomer.getUsername());
            return newCustomer;
        } catch (Exception e) {
            System.out.println("Error during conversion " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}