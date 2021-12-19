package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.team.dto.ProductDto;
import uz.team.dto.ResultDto;
import uz.team.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResultDto add(@RequestBody ProductDto productDto){
        ResultDto resultDto = productService.addProduct(productDto);
        return resultDto;
    }
}
