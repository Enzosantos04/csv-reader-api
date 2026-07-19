package enzosdev.csvreaderapi.controller;

import enzosdev.csvreaderapi.service.CsvProductsImport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/import-csv")
@RestController
public class ImportCSV {

    private final CsvProductsImport csvProductsImport;

    public ImportCSV(CsvProductsImport csvProductsImport) {
        this.csvProductsImport = csvProductsImport;
    }

    @PostMapping
    public ResponseEntity<String> importCSV(@RequestParam("file") MultipartFile file) throws Exception {
        int total = csvProductsImport.importCsv(file.getInputStream());
        return ResponseEntity.ok("Importados " + total + " produtos com sucesso.");
    }
}
