package cl.fala.product.sample.controller;

import cl.fala.product.sample.model.dto.ProductDTO;
import cl.fala.product.sample.model.dto.ResponseDTO;
import cl.fala.product.sample.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: David Toro Salamanca.
 * Description: Clase controladora de API Rest de productos.
 * */
@RestController
@RequestMapping("/product")
public class ProductController {

    private Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productSvc;

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo para guardar producto en service.
     * */
    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@Valid @RequestBody ProductDTO productReq) {
        log.info(String.format("ProductController.saveProduct - SKU: %s", productReq.getSku()));
        var svcResponse =  productSvc.saveProduct(productReq);
        return ResponseEntity.ok(svcResponse);
    }

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo para actualizar producto en service.
     * */
    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productReq) {
        log.info(String.format("ProductController.updateProduct - SKU: %s", productReq.getSku()));
        var svcResponse =  productSvc.updateProduct(productReq);
        return ResponseEntity.ok(svcResponse);
    }

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo para obtener producto en service mediante id SKU.
     * */
    @GetMapping(value = "/{sku}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String sku) {
        log.info(String.format("ProductController.getProduct - SKU: %s", sku));
        var svcResponse =  productSvc.getProduct(sku);
        return ResponseEntity.ok(svcResponse);
    }

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo para obtener todos los productos en service.
     * */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        log.info("ProductController.getProducts");
        var svcResponse =  productSvc.getProducts();
        return ResponseEntity.ok(svcResponse);
    }

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo para eliminar producto en service mediante id SKU.
     * */
    @DeleteMapping(value = "/{sku}")
    public ResponseEntity deleteProduct(@PathVariable String sku) {
        log.info(String.format("ProductController.deleteProduct - SKU: %s", sku));
        productSvc.deleteProduct(sku);
        return ResponseEntity.ok(new ResponseDTO(
                String.valueOf(HttpStatus.OK.value()),
                String.format("Producto %s eliminado correctamente.", sku)));
    }
}
