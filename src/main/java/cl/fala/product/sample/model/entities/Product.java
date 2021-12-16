package cl.fala.product.sample.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: David Toro Salamanca.
 * Description: Entidad de persistencia Product.
 * */
@Entity
public class Product {

    @Id
    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "principalImg", nullable = false)
    private String principalImg;

    @Column(name = "otherImages", nullable = false)
    private String otherImages;

    public Product() {
    }

    public Product(String sku, String name, String brand, String size, double price, String principalImg, String otherImages) {
        this.sku = sku;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.principalImg = principalImg;
        this.otherImages = otherImages;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPrincipalImg() {
        return principalImg;
    }

    public void setPrincipalImg(String principalImg) {
        this.principalImg = principalImg;
    }

    public String getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(String otherImages) {
        this.otherImages = otherImages;
    }
}
