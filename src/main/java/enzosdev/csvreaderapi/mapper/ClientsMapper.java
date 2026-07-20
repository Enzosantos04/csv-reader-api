package enzosdev.csvreaderapi.mapper;

import enzosdev.csvreaderapi.dto.ClientsDTO;
import enzosdev.csvreaderapi.dto.ClientsResponse;
import enzosdev.csvreaderapi.entity.Clients;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ClientsMapper {

    public Clients toEntity(ClientsDTO clientsDTO){
        Clients clients  = new Clients();
        clients.setNome(clientsDTO.getNome());
        clients.setCpf(clientsDTO.getCpf());
        clients.setLivre1(clientsDTO.getLivre1());
        clients.setChave(clientsDTO.getChave());
        clients.setLivre3(clientsDTO.getLivre3());
        clients.setLivre5(clientsDTO.getLivre5());
        clients.setLivre7(clientsDTO.getLivre7());
        clients.setFone1(clientsDTO.getFone1());
        clients.setFone2(clientsDTO.getFone2());
        clients.setFone3(clientsDTO.getFone3());
        clients.setFone4(clientsDTO.getFone4());
        clients.setFone5(clientsDTO.getFone5());
        clients.setFone6(clientsDTO.getFone6());
        clients.setFone7(clientsDTO.getFone7());
        clients.setFone8(clientsDTO.getFone8());
        clients.setFone9(clientsDTO.getFone9());
        clients.setFone10(clientsDTO.getFone10());
        clients.setStatus(clientsDTO.getStatus());
        return clients;
    }


    public ClientsResponse toResponse(Clients clients){
        ClientsResponse clientsResponse = new ClientsResponse();
        clientsResponse.setId(clients.getId());
        clientsResponse.setNome(clients.getNome());
        clientsResponse.setCpf(clients.getCpf());
        clientsResponse.setLivre1(clients.getLivre1());
        clientsResponse.setChave(clients.getChave());
        clientsResponse.setLivre3(clients.getLivre3());
        clientsResponse.setLivre5(clients.getLivre5());
        clientsResponse.setLivre7(clients.getLivre7());
        clientsResponse.setFone1(clients.getFone1());
        clientsResponse.setFone2(clients.getFone2());
        clientsResponse.setFone3(clients.getFone3());
        clientsResponse.setFone4(clients.getFone4());
        clientsResponse.setFone5(clients.getFone5());
        clientsResponse.setFone6(clients.getFone6());
        clientsResponse.setFone7(clients.getFone7());
        clientsResponse.setFone8(clients.getFone8());
        clientsResponse.setFone9(clients.getFone9());
        clientsResponse.setFone10(clients.getFone10());
        clientsResponse.setStatus(clients.getStatus());
        return clientsResponse;
    }
}
