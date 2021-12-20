package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.CurrencyRepository;
import uz.team.dto.ResultDto;
import uz.team.entity.Currency;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public ResultDto addService(Currency currency){
        currencyRepository.save(currency);
        return new ResultDto("Currency successfully added!", true);
    }

    public Currency getOneService(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()){
            Currency currency = optionalCurrency.get();
            return currency;
        }
        return null;
    }

    public List<Currency> getAllService(){
        return currencyRepository.findAll();
    }

    public ResultDto updateService(Integer id, Currency currency){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()){
            Currency editingCurrency = optionalCurrency.get();
            editingCurrency.setName(currency.getName());
            currencyRepository.save(editingCurrency);

            return new ResultDto("Successfully updated!", true);
        }
        return new ResultDto("Not updated!", false);
    }

    public ResultDto deleteService(Integer id){
        currencyRepository.deleteById(id);
        return new ResultDto("Successfully deleted!", true);
    }
}
