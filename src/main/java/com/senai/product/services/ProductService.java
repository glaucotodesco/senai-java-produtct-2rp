package com.senai.product.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.senai.product.dtos.ProductRequest;
import com.senai.product.dtos.ProductResponse;
import com.senai.product.entities.Product;
import com.senai.product.mappers.ProductMapper;
import com.senai.product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> findAll() {
         return repository.findAll()
                         .stream()
                         .map(ProductMapper::toDTO)
                         .toList();
    }

     public ProductResponse findById(Long id) {
        Product p = repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException());
        return ProductMapper.toDTO(p);                 
    }

     public void deleteById(Long id)
    {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
           throw new EntityNotFoundException("Produto não cadastrado");
    }

    public ProductResponse save(ProductRequest product)
    {
        Product p = repository.save(ProductMapper.toEntity(product));
        return ProductMapper.toDTO(p);
    }

    public void update(ProductRequest product, Long id)
    {
        Product p  = repository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));

        p.setDescription(product.description());                                
        p.setName(product.name());
        p.setPrice(product.price());

        repository.save(p);


    }
}
