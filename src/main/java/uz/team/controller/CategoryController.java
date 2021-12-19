package uz.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.team.dto.CategoryDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Category;
import uz.team.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResultDto add(@RequestBody CategoryDto categoryDto){
        ResultDto resultDto = categoryService.addCategory(categoryDto);
        return resultDto;
    }

    @GetMapping
    public List<Category> get(){
        return categoryService.getService();
    }

    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable Integer id){
        return categoryService.getOneService(id);
    }

    @PutMapping("/{id}")
    public ResultDto updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        ResultDto resultDto = categoryService.updateService(id, categoryDto);
        return resultDto;
    }

    @DeleteMapping("/{id}")
    public ResultDto deleteCategory(@PathVariable Integer id){
        ResultDto resultDto = categoryService.deleteService(id);
        return resultDto;
    }

}
