package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.CurrencyRepository;
import uz.team.dao.InputRepository;
import uz.team.dao.SupplierRepository;
import uz.team.dao.WarehouseRepository;
import uz.team.dto.InputDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Currency;
import uz.team.entity.Input;
import uz.team.entity.Supplier;
import uz.team.entity.Warehouse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public ResultDto addService(InputDto inputDto) {

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent()) {
            return new ResultDto("Sorry warehouse is not found!", false);
        }

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent()) {
            return new ResultDto("Sorry Supplier is not found!", false);
        }

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent()) {
            return new ResultDto("Sorry Currency is not found!", false);
        }

        Input input = new Input();
        input.setDate(inputDto.getDate());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(inputDto.getCode());

        inputRepository.save(input);
        return new ResultDto("New input added!", true);
    }

    public List<Input> getAll(){
        return inputRepository.findAll();
    }

    public Input getOne(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        return optionalInput.orElse(null);
    }

    public ResultDto updateService(Integer id, InputDto inputDto){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            Input editingInput = optionalInput.get();
            editingInput.setDate(Timestamp.valueOf(LocalDateTime.now()));

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
            if (optionalWarehouse.isPresent()){
                Warehouse warehouse = optionalWarehouse.get();
                editingInput.setWarehouse(warehouse);
            }

            Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
            if (optionalSupplier.isPresent()){
                Supplier supplier = optionalSupplier.get();
                editingInput.setSupplier(supplier);
            }

            Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
            if (optionalCurrency.isPresent()){
                Currency currency = optionalCurrency.get();
                editingInput.setCurrency(currency);
            }

            editingInput.setFactureNumber(inputDto.getFactureNumber());
            editingInput.setCode(inputDto.getCode());

            inputRepository.save(editingInput);

            return new ResultDto("Input successfully updated!", true);

        }
        return new ResultDto("Ups, not updated!", false);
    }

    public ResultDto deleteService(Integer id){
        inputRepository.deleteById(id);
        return new ResultDto("Input successfully deleted!", true);
    }

}
