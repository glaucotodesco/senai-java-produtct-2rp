package com.senai.product.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
    
    @NotBlank(message = "O nome é obrigatório") 
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    String name,

    @NotBlank(message = "O nome é obrigatório") 
    String description,

    @Min(value = 0, message = "Preço não pode ser negativo")
    Double price
) {
    
}
