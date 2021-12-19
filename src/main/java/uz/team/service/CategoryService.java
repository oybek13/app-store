package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.CategoryRepository;
import uz.team.dto.CategoryDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public ResultDto addCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent())
                return new ResultDto("This kind of parent category does not exist!", false);
            category.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new ResultDto("Category successfully saved!", true);
    }

    public List<Category> getService() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }

    public Category getOneService(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return category;
        }
        return null;
    }

    public ResultDto updateService(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            return new ResultDto("Sorry this category not found!", false);
        }

        Category editingCategory = optionalCategory.get();
        editingCategory.setName(categoryDto.getName());

        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory1 = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory1.isPresent()) {
                return new ResultDto("Sorry this parentId not found!", false);
            }
            Category category = categoryRepository.save(optionalCategory1.get());
            editingCategory.setParentCategory(category);
        }
        categoryRepository.save(editingCategory);
        return new ResultDto("Category successfully updated!", true);
    }

    public ResultDto deleteService(Integer id) {
        categoryRepository.deleteById(id);
        return new ResultDto("Category successfully deleted!", true);
    }
}
