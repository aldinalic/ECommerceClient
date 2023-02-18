package it.unitn.alic.ecommerceserver.entities;

import java.io.Serializable;
import java.util.Objects;

public class CustomerEntity implements Serializable {

    private int id;
    private String username;
    private String password;
    private String email;
    private String address;

    private boolean loggedIn;

    public CustomerEntity() {
    }
    public CustomerEntity(String username, String password, String email, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customer = (CustomerEntity) o;
        return id == customer.id && username.equals(customer.username) && password.equals(customer.password) && email.equals(customer.email) && address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, address);
    }
}