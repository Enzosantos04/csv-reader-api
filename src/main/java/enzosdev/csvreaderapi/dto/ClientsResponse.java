package enzosdev.csvreaderapi.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String livre1;
    private String chave;
    private String livre3;
    private String livre5;
    private String livre7;
    private String fone1;
    private String fone2;
    private String fone3;
    private String fone4;
    private String fone5;
    private String fone6;
    private String fone7;
    private String fone8;
    private String fone9;
    private String fone10;
    private String status;
    private Date createAt;
}
