package enzosdev.csvreaderapi.mapper;

import enzosdev.csvreaderapi.dto.ProductsDTO;
import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.entity.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

    public Products toEntity(ProductsDTO dto) {
        Products products = new Products();
        products.setName(dto.getName());
        products.setPrice(dto.getPrice());
        products.setQuantityStock(dto.getQuantityStock());
        return products;
    }


    public ProductsResponse toResponse(Products products) {
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.setId(products.getId());
        productsResponse.setName(products.getName());
        productsResponse.setPrice(products.getPrice());
        productsResponse.setQuantityStock(products.getQuantityStock());
        return productsResponse;
    }
}
