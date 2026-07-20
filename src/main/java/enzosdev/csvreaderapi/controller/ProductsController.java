package enzosdev.csvreaderapi.controller;


import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponse> findProductById(@PathVariable Long id){
        ProductsResponse products = productsService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);

    }
}
