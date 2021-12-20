package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.SupplierRepository;
import uz.team.dto.ResultDto;
import uz.team.entity.Supplier;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public ResultDto addService(Supplier supplier){
        supplierRepository.save(supplier);
        return new ResultDto("Supplier successfully saved", true);
    }

    public List<Supplier> getAll(){
        List<Supplier> all = supplierRepository.findAll();
        return all;
    }

    public Supplier getOne(Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()){
            Supplier supplier = optionalSupplier.get();
            return supplier;
        }
        return null;
    }

    public ResultDto updateService(Integer id, Supplier supplier){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()){
            Supplier editingSupplier = optionalSupplier.get();
            editingSupplier.setName(supplier.getName());
            editingSupplier.setPhoneNumber(supplier.getPhoneNumber());
            supplierRepository.save(editingSupplier);

            return new ResultDto("Supplier successfully updated", true);
        }
        return new ResultDto("Not updated!", false);
    }

    public ResultDto deleteService(Integer id){
        supplierRepository.deleteById(id);
        return new ResultDto("Supplier successfully deleted!", true);
    }

}
