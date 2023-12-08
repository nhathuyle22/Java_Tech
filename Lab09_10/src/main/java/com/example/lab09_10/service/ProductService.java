package com.example.lab09_10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lab09_10.model.Product;
import com.example.lab09_10.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    public Product addProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public void updateProduct(Product product){
        repository.findById(product.getId())
                .ifPresent((prod) -> {
                    prod.setName(product.getName());
                    prod.setCode(product.getCode());
                    prod.setPrice(product.getPrice());
                    prod.setIllustration(product.getIllustration());
                    prod.setDescription(product.getDescription());

                    repository.save(prod);
                });

    }

    public void putProduct(Product newProduct){
        updateProduct(newProduct);
    }

    public Product getProductById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteProduct(long id){
        repository.findById(id).ifPresent(repository::delete);
    }
}
