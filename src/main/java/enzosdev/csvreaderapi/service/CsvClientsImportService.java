package enzosdev.csvreaderapi.service;

import com.opencsv.bean.CsvToBeanBuilder;
import enzosdev.csvreaderapi.dto.ClientsDTO;
import enzosdev.csvreaderapi.entity.Clients;
import enzosdev.csvreaderapi.mapper.ClientsMapper;
import enzosdev.csvreaderapi.repository.ClientsRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvClientsImportService {

    private static final int BATCH_SIZE = 30000;
    private final ClientsRepository clientsRepository;
    private final ClientsMapper clientsMapper;


    public CsvClientsImportService(ClientsRepository clientsRepository, ClientsMapper clientsMapper) {
        this.clientsRepository = clientsRepository;
        this.clientsMapper = clientsMapper;
    }


    public int ImportClientsCsv(InputStream inputStream){
        List<Clients> batch = new ArrayList<>();

        int total = 0;

        try(Reader reader = new InputStreamReader(inputStream)){
            var csvToBean = new CsvToBeanBuilder<ClientsDTO>(reader)
                    .withType(ClientsDTO.class)
                    .build();

            for (ClientsDTO dto : csvToBean){
                Clients clients = clientsMapper.toEntity(dto);
                batch.add(clients);

                if(batch.size() == BATCH_SIZE){
                    clientsRepository.saveAll(batch);
                    total += batch.size();
                    batch.clear();
                }

            }

            if (!batch.isEmpty()){
                clientsRepository.saveAll(batch);
                total+= batch.size();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return total;
    }
}
