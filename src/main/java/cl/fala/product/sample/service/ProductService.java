package cl.fala.product.sample.service;

import cl.fala.product.sample.model.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProductService {

    ProductDTO updateProduct(ProductDTO product);

    ProductDTO saveProduct(ProductDTO product);

    ProductDTO getProduct(String id);

    List<ProductDTO> getProducts();

    void deleteProduct(String id);
}
