package enzosdev.csvreaderapi.service;

import enzosdev.csvreaderapi.dto.ProductsDTO;
import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.entity.Products;
import enzosdev.csvreaderapi.mapper.ProductsMapper;
import enzosdev.csvreaderapi.repository.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;

    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
    }


    public Page<ProductsResponse> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable)
                .map(productsMapper::toResponse);
    }

    public ProductsResponse findProductById(Long id){
        Optional<Products> products = productsRepository.findById(id);
        return products.map(productsMapper::toResponse)
                .orElseThrow(()->  new RuntimeException("erro"));


    }
}
