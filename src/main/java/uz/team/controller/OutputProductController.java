package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.OutputProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.OutputProduct;
import uz.team.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public ResultDto add(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.add(outputProductDto);
    }

    @GetMapping
    public List<OutputProduct> get(){
        return outputProductService.getAll();
    }

    @GetMapping("/{id}")
    public OutputProduct getOne(@PathVariable Integer id){
        return outputProductService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.update(id, outputProductDto);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return outputProductService.delete(id);
    }

}
