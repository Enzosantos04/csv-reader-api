package enzosdev.csvreaderapi.controller;

import enzosdev.csvreaderapi.repository.ClientsRepository;
import enzosdev.csvreaderapi.service.CsvClientsImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import")
public class ClientsCSVController {

    private final CsvClientsImportService  csvClientsImportService;

    public ClientsCSVController(CsvClientsImportService csvClientsImportService) {
        this.csvClientsImportService = csvClientsImportService;
    }

    @PostMapping
    public ResponseEntity<String> importCSV(@RequestParam("file") MultipartFile file) throws Exception {
        int total = csvClientsImportService.ImportClientsCsv(file.getInputStream());
        return ResponseEntity.ok("Importados " + total + " produtos com sucesso.");
    }

}
