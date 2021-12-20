package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ResultDto;
import uz.team.entity.Currency;
import uz.team.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public ResultDto add(@RequestBody Currency currency){
        return currencyService.addService(currency);
    }

    @GetMapping
    public List<Currency> get(){
        return currencyService.getAllService();
    }

    @GetMapping("/{id}")
    public Currency getOne(@PathVariable Integer id){
        return currencyService.getOneService(id);
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.updateService(id, currency);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return currencyService.deleteService(id);
    }
}
