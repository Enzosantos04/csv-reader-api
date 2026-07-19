package enzosdev.csvreaderapi.controller;


import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.entity.Products;
import enzosdev.csvreaderapi.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping("/products")
    public ResponseEntity<Page<ProductsResponse>> findAll(Pageable pageable) {
        Page<ProductsResponse> products = productsService.findAll(pageable);
        return ResponseEntity.ok(products);

    }
}
