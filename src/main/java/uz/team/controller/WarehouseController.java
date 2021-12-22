package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.entity.Warehouse;
import uz.team.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public ResultDto add(@RequestBody Warehouse warehouse){
        return warehouseService.addService(warehouse);
    }

    @GetMapping
    public List<Warehouse> get(){
        return warehouseService.getAll();
    }

    @GetMapping("/{id}")
    public Warehouse getOne(@PathVariable Integer id){
        return warehouseService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        return warehouseService.updateService(id, warehouse);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
      return warehouseService.deleteService(id);
    }
}
