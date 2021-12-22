package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.WarehouseRepository;
import uz.team.dto.ResultDto;
import uz.team.entity.Warehouse;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    public ResultDto addService(Warehouse warehouse){
        warehouseRepository.save(warehouse);
        return new ResultDto("Warehouse successfully added!", true);
    }

    public List<Warehouse> getAll(){
        return warehouseRepository.findAll();
    }

    public Warehouse getOne(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        return optionalWarehouse.orElse(null);
    }

    public ResultDto updateService(Integer id, Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            Warehouse editingWarehouse = optionalWarehouse.get();
            editingWarehouse.setName(warehouse.getName());

            warehouseRepository.save(editingWarehouse);
            return new ResultDto("Warehouse successfully updated!", true);
        }
        return new ResultDto("Not updated!", false);
    }

    public ResultDto deleteService(Integer id){
        warehouseRepository.deleteById(id);
        return new ResultDto("Successfully deleted!", true);
    }

}
