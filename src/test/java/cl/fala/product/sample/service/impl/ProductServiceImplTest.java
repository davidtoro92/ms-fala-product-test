package cl.fala.product.sample.service.impl;

import cl.fala.product.sample.model.dto.ProductDTO;
import cl.fala.product.sample.repository.ProductRepository;
import cl.fala.product.sample.exception.CustomProductExistMatterException;
import cl.fala.product.sample.util.ProductUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl svc;

    @Mock
    private ProductRepository productRepo;

    @Mock
    private ProductUtil utlMock;

    private ProductUtil utl = new ProductUtil();

    @Test
    void saveProductSuccess() {
        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-2222221", "500 Zapatilla Urbana Mujer", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        var response = svc.saveProduct(productReq);
        Assert.assertEquals(productReq, response);
    }

    @Test
    void saveProductErrorConflictExists() {
        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-2222221", "500 Zapatilla Urbana Mujer", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        Assert.assertThrows(CustomProductExistMatterException.class, () -> {
            svc.saveProduct(productReq);
        });
    }

}