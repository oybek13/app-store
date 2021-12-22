package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.ClientRepository;
import uz.team.dto.ResultDto;
import uz.team.entity.Client;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ResultDto addService(Client client){
        clientRepository.save(client);
        return new ResultDto("Client successfully added!", true);
    }

    public List<Client> getAllService(){
       return clientRepository.findAll();
    }

    public Client getOneService(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            return optionalClient.get();
        }
        return null;
    }

    public ResultDto updateService(Integer id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            Client editingClient = optionalClient.get();
            editingClient.setName(client.getName());
            editingClient.setPhoneNumber(client.getPhoneNumber());
            clientRepository.save(editingClient);

            return new ResultDto("Client successfully updated!" ,true);

        }
        return new ResultDto("Sorry client not updated!", false);
    }

    public ResultDto deleteService(Integer id){
        clientRepository.deleteById(id);
        return new ResultDto("Client successfully deleted!", true);
    }

}
