package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.InputProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.InputProduct;
import uz.team.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/input_product")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;

    @PostMapping
    public ResultDto add(@RequestBody InputProductDto inputProductDto){
        return inputProductService.addInputProduct(inputProductDto);
    }

    @GetMapping
    public List<InputProduct> get(){
       return inputProductService.getAll();
    }

    @GetMapping("/{id}")
    public InputProduct getOne(@PathVariable Integer id){
        return inputProductService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductService.update(id, inputProductDto);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return inputProductService.delete(id);
    }

}
