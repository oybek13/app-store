package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.entity.Client;
import uz.team.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResultDto add(@RequestBody Client client){
        return clientService.addService(client);
    }

    @GetMapping
    public List<Client> get(){
        return clientService.getAllService();
    }

    @GetMapping("/{id}")
    public Client getOne(@PathVariable Integer id){
        return clientService.getOneService(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody Client client){
        return clientService.updateService(id, client);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return clientService.deleteService(id);
    }
}
