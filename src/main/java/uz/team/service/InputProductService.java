package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.InputProductRepository;
import uz.team.dao.InputRepository;
import uz.team.dao.ProductRepository;
import uz.team.dto.InputProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Input;
import uz.team.entity.InputProduct;
import uz.team.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    public ResultDto addInputProduct(InputProductDto inputProductDto){

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ResultDto("Sorry this product does't exist!", false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent())
            return new ResultDto("Sorry this input does't exist!", false);

        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setAmount(inputProductDto.getPrice());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        inputProductRepository.save(inputProduct);
        return new ResultDto("InputProduct successfully added!", true);
    }

    public List<InputProduct> getAll(){
        return inputProductRepository.findAll();
    }

    public InputProduct getOne(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        return optionalInputProduct.orElse(null);
    }

    public ResultDto update(Integer id, InputProductDto inputProductDto){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            InputProduct editingInputProduct = optionalInputProduct.get();
            editingInputProduct.setExpireDate(inputProductDto.getExpireDate());
            editingInputProduct.setPrice(inputProductDto.getPrice());
            editingInputProduct.setAmount(inputProductDto.getAmount());

            Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
            if (optionalInput.isPresent()){
                Input input = optionalInput.get();
                editingInputProduct.setInput(input);
            }

            Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
            if (optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                editingInputProduct.setProduct(product);

            }

            inputProductRepository.save(editingInputProduct);
            return new ResultDto("InputProduct successfully updated!", true);
        }
        return new ResultDto("Not updated sorry!", false);

    }

    public ResultDto delete(Integer id){
        inputProductRepository.deleteById(id);
        return new ResultDto("Successfully deleted!", true);
    }

}
