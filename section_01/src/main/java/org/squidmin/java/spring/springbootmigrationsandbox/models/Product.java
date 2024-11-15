package org.squidmin.java.spring.springbootmigrationsandbox.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

    @NotNull
    private Long productId;

    @NotNull
    @Size(min = 3, message = "Product name must be at least 3 characters long")
    private String productName;

    // Getters and setters
    public Long getProductId() { return productId; }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
