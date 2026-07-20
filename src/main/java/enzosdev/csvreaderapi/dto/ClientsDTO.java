package enzosdev.csvreaderapi.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDTO {

    private Long id;
    @CsvBindByName(column = "nome")
    private String nome;

    @CsvBindByName(column = "cpf")
    private String cpf;

    @CsvBindByName(column = "livre1")
    private String livre1;

    @CsvBindByName(column = "chave")
    private String chave;

    @CsvBindByName(column = "livre3")
    private String livre3;

    @CsvBindByName(column = "livre5")
    private String livre5;

    @CsvBindByName(column = "livre7")
    private String livre7;

    @CsvBindByName(column = "fone1")
    private String fone1;

    @CsvBindByName(column = "fone2")
    private String fone2;

    @CsvBindByName(column = "fone3")
    private String fone3;

    @CsvBindByName(column = "fone4")
    private String fone4;

    @CsvBindByName(column = "fone5")
    private String fone5;

    @CsvBindByName(column = "fone6")
    private String fone6;

    @CsvBindByName(column = "fone7")
    private String fone7;

    @CsvBindByName(column = "fone8")
    private String fone8;

    @CsvBindByName(column = "fone9")
    private String fone9;

    @CsvBindByName(column = "fone10")
    private String fone10;

    @CsvBindByName(column = "status")
    private String status;

    @CsvBindByName(column = "createAt")
    private Date createAt;
}
