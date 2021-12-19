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
}
