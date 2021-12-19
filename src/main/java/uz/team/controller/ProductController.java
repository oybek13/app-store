package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.ProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Product;
import uz.team.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /*TODO Create*/
    @PostMapping
    public ResultDto add(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    /*TODO Get*/
    @GetMapping
    public List<Product> get(){
        return productService.getAllService();
    }

    /*TODO CreateOne*/
    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable Integer id){
        return productService.getOneService(id);
    }

    /*TODO Update*/
    @PutMapping("/{id}")
    public ResultDto update(@PathVariable Integer id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable Integer id){
        return productService.deleteService(id);
    }
}
