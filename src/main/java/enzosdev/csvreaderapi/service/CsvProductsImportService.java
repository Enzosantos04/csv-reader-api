package enzosdev.csvreaderapi.service;

import com.opencsv.bean.CsvToBeanBuilder;
import enzosdev.csvreaderapi.dto.ProductsDTO;
import enzosdev.csvreaderapi.entity.Products;
import enzosdev.csvreaderapi.mapper.ProductsMapper;
import enzosdev.csvreaderapi.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvProductsImportService {

    private static final int BATCH_SIZE = 500;

    private final ProductsRepository repository;
    private final ProductsMapper mapper;

    public CsvProductsImportService(ProductsRepository repository, ProductsMapper mapper ) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public int importCsv(InputStream inputStream){

        List<Products> batch = new ArrayList<>();
        int total = 0;

        //converte o file vindo do inputstream para reader para o opencsv funcionar
        try(Reader reader = new InputStreamReader(inputStream)){
            //parse do csv mapeia cada linha do csv no ProductsDTO
            var csvToBean = new CsvToBeanBuilder<ProductsDTO>(reader)
                    .withType(ProductsDTO.class)
                    .build();

            //itera cada linha do csv e usa o mapper para transformar o dto em entidade
            for (ProductsDTO dto : csvToBean){
                Products product = mapper.toEntity(dto);
                batch.add(product); //armazena os produtos dentro da lista

                // se o tamanho do batch estiver certo salva no banco e limpa a lista
                if(batch.size() == BATCH_SIZE) {
                   repository.saveAll(batch);
                   total += batch.size();
                   batch.clear();
                }
            }
            //esse if garante q os restos dos dados sejam persistidos
            if (!batch.isEmpty()) {
                repository.saveAll(batch);
                total += batch.size();
                batch.clear();

            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

        return total;
    }


}
