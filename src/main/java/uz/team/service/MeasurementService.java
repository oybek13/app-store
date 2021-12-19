package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.MeasurementRepository;
import uz.team.dto.ResultDto;
import uz.team.entity.Measurement;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    /*TODO CREATE*/
    public ResultDto addMeasurementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName){
            return new ResultDto("This measurement type exists!", false);
        }
        measurementRepository.save(measurement);
        return new ResultDto("Measurement successfully saved!", true);
    }

    /*TODO READ*/
    public List<Measurement> getAllMeasurementService(){
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }

    /*TODO READ BY ONE */
    public Measurement getOneMeasurementService(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement measurement = optionalMeasurement.get();
            return measurement;
        }
        return null;
    }

    /*TODO DELETE*/
    public ResultDto deleteMeasurementService(Integer id){
            measurementRepository.deleteById(id);
            return new ResultDto("Measurement successfully deleted!", true);
    }

    /*TODO UPDATE*/
    public ResultDto updateService(Integer id, Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement editingMeasurement = optionalMeasurement.get();
            editingMeasurement.setName(measurement.getName());
            measurementRepository.save(editingMeasurement);
            return new ResultDto("The measurement successfully updated!", true);
        }
        return new ResultDto("Sorry man! It is not ok!", false);
    }


}
