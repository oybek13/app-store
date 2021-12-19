package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.entity.Measurement;
import uz.team.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public ResultDto addMeasurementController(@RequestBody Measurement measurement){
        ResultDto resultDto = measurementService.addMeasurementService(measurement);
        return resultDto;
    }

    @GetMapping
    public List<Measurement> getAllMeasurementController(){
        return measurementService.getAllMeasurementService();
    }

    @GetMapping("/{id}")
    public Measurement getOneMeasurementController(@PathVariable Integer id){
        Measurement measurement = measurementService.getOneMeasurementService(id);
        return measurement;
    }

    @DeleteMapping("/{id}")
    public ResultDto deleteMeasurementController(@PathVariable Integer id){
        return measurementService.deleteMeasurementService(id);
    }

    @PutMapping("/{id}")
    public ResultDto updateController(@PathVariable Integer id, @RequestBody Measurement measurement){
        return measurementService.updateService(id,measurement);
    }
}
