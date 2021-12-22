package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.InputDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Input;
import uz.team.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;

    @PostMapping
    public ResultDto add(@RequestBody InputDto inputDto){
        return inputService.addService(inputDto);
    }

    @GetMapping
    public List<Input> getAll(){
        return inputService.getAll();
    }

    @GetMapping("/{id}")
    public Input getOne(@PathVariable Integer id){
        return inputService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.updateService(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return inputService.deleteService(id);
    }
}
