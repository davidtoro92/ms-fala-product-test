package cl.fala.product.sample.service.impl;

import cl.fala.product.sample.exception.CustomProductExistMatterException;
import cl.fala.product.sample.model.dto.ProductDTO;
import cl.fala.product.sample.repository.ProductRepository;
import cl.fala.product.sample.service.ProductService;
import cl.fala.product.sample.util.ProductUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cl.fala.product.sample.util.ProductUtil.PRODUCT_DOES_NOT_EXISTS_ERROR;
import static cl.fala.product.sample.util.ProductUtil.PRODUCT_EXISTS_ERROR;

/**
 * @author: David Toro Salamanca.
 * Description: Clase service con logica de negocio para CRUD.
 * */
@Service
public class ProductServiceImpl implements ProductService {

    private Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductUtil utl;

    @Override
    public ProductDTO saveProduct(ProductDTO product) {
        log.info(String.format("ProductServiceImpl.saveProduct - SKU: %s", product.getSku()));
        if(!productRepo.existsById(product.getSku())) {
            productRepo.save(utl.wrappProduct(product));

            log.info(String.format("ProductServiceImpl.saveProduct SUCCESS - SKU: %s", product.getSku()));
            return product;
        } else {
            log.error(String.format("ProductServiceImpl.saveProduct ERROR - SKU: %s", product.getSku()));
            throw new CustomProductExistMatterException(PRODUCT_EXISTS_ERROR);
        }
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) {
        log.error(String.format("ProductServiceImpl.updateProduct - SKU: %s", product.getSku()));
        if(productRepo.existsById(product.getSku())) {
            productRepo.save(utl.wrappProduct(product));
            log.error(String.format("ProductServiceImpl.updateProduct SUCCESS - SKU: %s", product.getSku()));
            return product;
        } else {
            log.error(String.format("ProductServiceImpl.updateProduct ERROR - SKU: %s", product.getSku()));
            throw new CustomProductExistMatterException(PRODUCT_DOES_NOT_EXISTS_ERROR);
        }
    }

    @Override
    public ProductDTO getProduct(String sku) {
        return utl.unwrappProduct(productRepo.getById(sku));
    }

    @Override
    public List<ProductDTO> getProducts() {
        return utl.unwrappProducts(productRepo.findAll());
    }

    @Override
    public void deleteProduct(String sku) {
        log.error(String.format("ProductServiceImpl.deleteProduct INIT - SKU: %s", sku));
        if(productRepo.existsById(sku)) {
            productRepo.deleteById(sku);
            log.error(String.format("ProductServiceImpl.deleteProduct SUCCESS - SKU: %s", sku));
        } else {
            log.error(String.format("ProductServiceImpl.deleteProduct ERROR - SKU: %s no existe producto", sku));
            throw new CustomProductExistMatterException(PRODUCT_DOES_NOT_EXISTS_ERROR);
        }
    }

}
