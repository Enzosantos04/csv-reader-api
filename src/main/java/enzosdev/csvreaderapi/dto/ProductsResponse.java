package enzosdev.csvreaderapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantityStock;
}
