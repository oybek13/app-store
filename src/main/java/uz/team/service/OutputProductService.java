package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.OutputProductRepository;
import uz.team.dao.OutputRepository;
import uz.team.dao.ProductRepository;
import uz.team.dto.OutputProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Output;
import uz.team.entity.OutputProduct;
import uz.team.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    public ResultDto add(OutputProductDto outputProductDto){
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ResultDto("Sorry this product doesn't exist!", false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new ResultDto("Sorry this output doesn't exist!", false);

        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());

        outputProductRepository.save(outputProduct);
        return new ResultDto("OutputProduct successfully added!", true);
    }

    public List<OutputProduct> getAll(){
        return outputProductRepository.findAll();
    }

    public OutputProduct getOne(Integer id){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        return optionalOutputProduct.orElse(null);
    }

    public ResultDto update(Integer id, OutputProductDto outputProductDto){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isPresent()){
            OutputProduct editingOutputProduct = optionalOutputProduct.get();
            editingOutputProduct.setPrice(outputProductDto.getPrice());
            editingOutputProduct.setAmount(outputProductDto.getAmount());

            Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
            if (optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                editingOutputProduct.setProduct(product);
            }

            Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
            if (optionalOutput.isPresent()){
                Output output = optionalOutput.get();
                editingOutputProduct.setOutput(output);
            }

            outputProductRepository.save(editingOutputProduct);
            return new ResultDto("OutputProduct successfully updated!", true);
        }
        return new ResultDto("Not updated ups!", false);
    }

    public ResultDto delete(Integer id){
        outputProductRepository.deleteById(id);
        return new ResultDto("OutputProduct successfully deleted!", true);
    }
}
