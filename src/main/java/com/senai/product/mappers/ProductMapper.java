package com.senai.product.mappers;

import com.senai.product.dtos.ProductRequest;
import com.senai.product.dtos.ProductResponse;
import com.senai.product.entities.Product;

public class ProductMapper {
    
     public static Product toEntity(ProductRequest request){
            Product p = new Product();
            p.setDescription(request.description());
            p.setName(request.name());
            p.setPrice(request.price());

            return p;
    }


    public static ProductResponse toDTO(Product product)
    {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription()
          
        );
    }
}
