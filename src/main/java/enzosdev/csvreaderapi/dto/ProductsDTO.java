package enzosdev.csvreaderapi.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {


    private Long id;
    @CsvBindByName(column = "nome do produto")
    private String name;

    @CsvBindByName(column = "preco")
    private BigDecimal price;

    @CsvBindByName(column = "quantidade")
    private int quantityStock;
}
