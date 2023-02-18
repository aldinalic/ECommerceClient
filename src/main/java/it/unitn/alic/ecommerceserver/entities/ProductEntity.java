package it.unitn.alic.ecommerceserver.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductEntity implements Serializable {

    private int id;
    private String name;
    private String description;
    private String category;
    private int stock;
    private BigDecimal price;

    public ProductEntity() {}

    public ProductEntity(String name, String description, String category, int stock, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return id== product.id && name.equals(product.name) && description.equals(product.description) && category.equals(product.category) && stock == product.stock && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, stock, price);
    }
}
