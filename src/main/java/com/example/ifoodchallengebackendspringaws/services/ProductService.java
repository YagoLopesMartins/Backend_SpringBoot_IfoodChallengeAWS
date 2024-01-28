package com.example.ifoodchallengebackendspringaws.services;

import com.example.ifoodchallengebackendspringaws.domain.category.exceptions.CategoryNotFoundException;
import com.example.ifoodchallengebackendspringaws.domain.product.Product;
import com.example.ifoodchallengebackendspringaws.domain.product.ProductDTO;
import com.example.ifoodchallengebackendspringaws.domain.product.exceptions.ProductNotFoundException;
import com.example.ifoodchallengebackendspringaws.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final CategoryService categoryService;
    private final ProductRepository repository;
    //private final AwsSnsService snsService;

    public ProductService(CategoryService categoryService, ProductRepository productRepository /*, AwsSnsService snsService*/){
        this.categoryService = categoryService;
        this.repository = productRepository;
       // this.snsService = snsService;
    }

    public Product insert(ProductDTO productData){
        this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);

        this.repository.save(newProduct);

        //this.snsService.publish(new MessageDTO(newProduct.toString()));

        return newProduct;
    }

    public Product update(String id, ProductDTO productData){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());
       // if(!(productData.categoryId() == null)) product.setCategory(productData.categoryId());

        this.repository.save(product);

       // this.snsService.publish(new MessageDTO(product.toString()));

        return product;
    }

    public void delete(String id){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(product);
    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }
}