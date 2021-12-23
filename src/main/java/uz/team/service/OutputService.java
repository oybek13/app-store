package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.ClientRepository;
import uz.team.dao.CurrencyRepository;
import uz.team.dao.OutputRepository;
import uz.team.dao.WarehouseRepository;
import uz.team.dto.OutputDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Client;
import uz.team.entity.Currency;
import uz.team.entity.Output;
import uz.team.entity.Warehouse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ClientRepository clientRepository;

    public ResultDto addOutput(OutputDto outputDto){
        Output output = new Output();

        output.setDate(outputDto.getDate());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(outputDto.getCode());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new ResultDto("Sorry this warehouse is not found!", false);
        }
        output.setWarehouse(optionalWarehouse.get());

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new ResultDto("Sorry this currency is not found!", false);
        }
        output.setCurrency(optionalCurrency.get());

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent()){
            return new ResultDto("Sorry this client is not found!", false);
        }
        output.setClient(optionalClient.get());

        outputRepository.save(output);
        return new ResultDto("Output successfully added!", true);
    }

    public List<Output> getAll(){
        return outputRepository.findAll();
    }

    public Output getOne(Integer id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        return optionalOutput.orElse(null);
    }

    public ResultDto updateService(Integer id, OutputDto outputDto){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()){
            Output editingOutput = optionalOutput.get();
            editingOutput.setDate(Timestamp.valueOf(LocalDateTime.now()));
            editingOutput.setCode(outputDto.getCode());
            editingOutput.setFactureNumber(outputDto.getFactureNumber());

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
            if (optionalWarehouse.isPresent()){
                Warehouse warehouse = optionalWarehouse.get();
                editingOutput.setWarehouse(warehouse);
            }

            Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
            if (optionalCurrency.isPresent()){
                Currency currency = optionalCurrency.get();
                editingOutput.setCurrency(currency);
            }

            Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
            if (optionalClient.isPresent()){
                Client client = optionalClient.get();
                editingOutput.setClient(client);
            }

            outputRepository.save(editingOutput);

            return new ResultDto("Output successfully updated", true);
        }
        return new ResultDto("Sorry not updated", false);
    }

    public ResultDto deleteService(Integer id){
        outputRepository.deleteById(id);
        return new ResultDto("Output successfully deleted!", true);
    }


}
