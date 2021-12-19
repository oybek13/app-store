package uz.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.team.dao.AttachmentRepository;
import uz.team.dao.CategoryRepository;
import uz.team.dao.MeasurementRepository;
import uz.team.dao.ProductRepository;
import uz.team.dto.ProductDto;
import uz.team.dto.ResultDto;
import uz.team.entity.Attachment;
import uz.team.entity.Category;
import uz.team.entity.Measurement;
import uz.team.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    /*TODO CREATE*/
    public ResultDto addProduct(ProductDto productDto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new ResultDto("This kind of product exists in the following category!", false);


        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new ResultDto("Sorry this kind of category not exist!", false);


        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new ResultDto("Sorry this kind of photo not exist!", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalAttachment.isPresent())
            return new ResultDto("Sorry this kind of measurement not exist!", false);


        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1"); //TODO must generate code
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());

        productRepository.save(product);
        return new ResultDto("Product successfully added!", true);
    }

    /*TODO GET ALL*/
    public List<Product> getAllService(){
        List<Product> all = productRepository.findAll();
        return all;
    }

    /*TODO GET ONE*/
    public Product getOneService(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }
        return null;
    }

    /*TODO UPDATE*/
    public ResultDto updateProduct(Integer id, ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product editingProduct = optionalProduct.get();
            editingProduct.setName(productDto.getName());
            editingProduct.setCode("1");

            Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
            if (optionalCategory.isPresent()){
                Category category = optionalCategory.get();
                editingProduct.setCategory(category);
            }

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
            if (optionalAttachment.isPresent()){
                Attachment attachment = optionalAttachment.get();
                editingProduct.setPhoto(attachment);
            }

            Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
            if (optionalMeasurement.isPresent()){
                Measurement measurement = optionalMeasurement.get();
                editingProduct.setMeasurement(measurement);
            }

            productRepository.save(editingProduct);

            return new ResultDto("Product successfully updated!!!", true);

        }
        return new ResultDto("Not updated! Sorry :( ", false);
    }

    /*TODO DELETE*/
    public ResultDto deleteService(Integer id){
        productRepository.deleteById(id);
        return new ResultDto("Product successfully deleted!", true);
    }
}
