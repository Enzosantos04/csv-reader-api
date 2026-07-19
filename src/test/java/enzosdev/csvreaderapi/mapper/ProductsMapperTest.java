package enzosdev.csvreaderapi.mapper;

import enzosdev.csvreaderapi.dto.ProductsDTO;
import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.entity.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductsMapperTest {

    private final ProductsMapper mapper = new ProductsMapper();

    @Test
    @DisplayName("toEntity should map productsDTO to entity correctly")
    void toEntity() {

        //Arrange
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setName("Product teste");
        productsDTO.setPrice(BigDecimal.valueOf(15));
        productsDTO.setQuantityStock(10);


        //Action
       Products result =  mapper.toEntity(productsDTO);

       //Assertions
       assertNotNull(result);
       assertEquals(productsDTO.getName(), result.getName());
       assertEquals(productsDTO.getPrice(), result.getPrice());
       assertEquals(productsDTO.getQuantityStock(), result.getQuantityStock());
    }

    @Test
    @DisplayName("toResponse should map Products to ProductResponse correctly")

    void toResponse() {

        Products products = new Products();
        products.setName("teste");
        products.setPrice(BigDecimal.valueOf(15));
        products.setQuantityStock(10);


        ProductsResponse productsResponse = mapper.toResponse(products);
        assertNotNull(productsResponse);


        assertNotNull(productsResponse);
        assertEquals(productsResponse.getName(), products.getName());
        assertEquals(productsResponse.getPrice(), products.getPrice());
        assertEquals(productsResponse.getQuantityStock(), products.getQuantityStock());
    }
}