package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.entity.Supplier;
import uz.team.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    public ResultDto add(@RequestBody Supplier supplier){
        return supplierService.addService(supplier);
    }

    @GetMapping
    public List<Supplier> get(){
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Supplier getOne(@PathVariable Integer id){
        return supplierService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.updateService(id, supplier);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return supplierService.deleteService(id);
    }
}
