package cl.fala.product.sample.model.dto;

import cl.fala.product.sample.annotations.BrandAndNameValidation;
import cl.fala.product.sample.annotations.PriceValidation;
import cl.fala.product.sample.annotations.SkuValidation;
import org.hibernate.validator.constraints.URL;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;

/**
 * @author: David Toro Salamanca.
 * Description: POJO de producto.
 * */
public class ProductDTO {

    @SkuValidation(message = "El valor de SKU no es correcto.")
    private String sku;

    @BrandAndNameValidation(message = "Valor no correcto para nombre o marca.")
    private String name;

    @BrandAndNameValidation(message = "Valor no correcto para nombre o marca.")
    private String brand;

    @NotBlank(message = "El valor tamaño no puede estar vacio")
    private String size;

    @PriceValidation(message = "Valor de precio no es correcto.")
    private double price;

    @URL(message = "Valor entregado no corresponde a una URL")
    private String principalImg;

    private HashMap<String, String> otherImages;

    public ProductDTO() {
    }

    public ProductDTO(String sku, String name, String brand, String size, double price, String principalImg, HashMap<String, String> otherImages) {
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

    public HashMap<String, String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(HashMap<String, String> otherImages) {
        this.otherImages = otherImages;
    }
}
