package cl.fala.product.sample.util;

import cl.fala.product.sample.exception.CustomUnwrappException;
import cl.fala.product.sample.model.dto.ProductDTO;
import cl.fala.product.sample.model.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {

    public final static String PRODUCT_DOES_NOT_EXISTS_ERROR = "204-NOT-FOUND";
    public final static String PRODUCT_EXISTS_ERROR = "409-CONFLICT";

    public Product wrappProduct(ProductDTO product) {
        return new Product(
                product.getSku(),
                product.getName(),
                product.getBrand(),
                product.getSize(),
                product.getPrice(),
                product.getPrincipalImg(),
                product.getOtherImages().toString());
    }

    public List<ProductDTO> unwrappProducts(List<Product> products) {
        return products.stream().map(this::unwrappProduct).collect(Collectors.toList());
    }

    public ProductDTO unwrappProduct(Product product) {
        try {
            TypeReference<HashMap<String, String>> typeRef = new TypeReference<>() {
            };
            HashMap<String, String> otherImagesMap = new ObjectMapper().readValue(product.getOtherImages(), typeRef);

            return new ProductDTO(
                    product.getSku(),
                    product.getName(),
                    product.getBrand(),
                    product.getSize(),
                    product.getPrice(),
                    product.getPrincipalImg(),
                    otherImagesMap);
        } catch(JsonProcessingException jsonEx) {
            throw new CustomUnwrappException(jsonEx.getMessage());
        }
    }
}
