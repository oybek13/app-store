package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.OutputDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Output;
import uz.team.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService outputService;

    @PostMapping
    public ResultDto add(@RequestBody OutputDto outputDto){
        return outputService.addOutput(outputDto);
    }

    @GetMapping
    public List<Output> get(){
       return outputService.getAll();
    }

    @GetMapping("/{id}")
    public Output get(@PathVariable Integer id){
        return outputService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody OutputDto outputDto){
       return outputService.updateService(id, outputDto);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return outputService.deleteService(id);
    }
}
