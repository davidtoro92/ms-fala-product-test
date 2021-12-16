package cl.fala.product.sample.controller;

import cl.fala.product.sample.model.dto.ProductDTO;
import cl.fala.product.sample.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.HashMap;

import static cl.fala.product.sample.util.TestUtil.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductServiceImpl productSvc;

    @Autowired
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = standaloneSetup(productController).build();
    }

    @Test
    void testSaveProductSuccess() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8406270", "500 Zapatilla Urbana Mujer", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        Mockito.when(productSvc.saveProduct(productReq)).thenReturn(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/product")
                        .content(asJsonString(productReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void testUpdateProductSuccess() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8406271", "500 Zapatilla Urbana Hombre", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);
        productReq.setName("500 Zapatilla Urbana Hombre UPDATED");

        Mockito.when(productSvc.updateProduct(productReq)).thenReturn(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/product")
                        .content(asJsonString(productReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void testUpdateProductWithValidationErrorSku() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8406272", "Producto 3", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);
        productReq.setSku("1");

        Mockito.when(productSvc.updateProduct(productReq)).thenReturn(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/product")
                        .content(asJsonString(productReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateProductWithValidationErrorSkuString() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8406279", "Producto 3", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);
        productReq.setSku("ADSADSSADSD");

        Mockito.when(productSvc.updateProduct(productReq)).thenReturn(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/product")
                        .content(asJsonString(productReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateProductWithValidationErrorPrice() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8406273", "Producto 4", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);
        productReq.setPrice(0.5);

        Mockito.when(productSvc.updateProduct(productReq)).thenReturn(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/product")
                        .content(asJsonString(productReq))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void testGetSkuProductSuccess() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-8888888", "500 Zapatilla Urbana Mujer", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/product/FAL-8888888")
        ).andExpect(status().isOk());
    }

    @Test
    void testGetAllProductSuccess() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void testDeleteProductSuccess() throws Exception {

        /*Configura el mock */
        ProductDTO productReq = new ProductDTO("FAL-9000000", "500 Zapatilla Urbana Mujer", "New Balance",
                "37", 42990.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1",
                new HashMap<String, String>());

        productController.saveProduct(productReq);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/product/FAL-9000000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
