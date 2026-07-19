package enzosdev.csvreaderapi.service;

import enzosdev.csvreaderapi.dto.ProductsResponse;
import enzosdev.csvreaderapi.mapper.ProductsMapper;
import enzosdev.csvreaderapi.repository.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
}
