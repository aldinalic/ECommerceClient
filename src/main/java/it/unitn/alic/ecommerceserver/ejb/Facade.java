package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

public interface Facade {
    CustomerEntity getCustomer(int id);
}