package com.bossabox.api.mapper;

import org.springframework.stereotype.Component;

import com.bossabox.api.dto.ProductRequestDTO;
import com.bossabox.api.dto.ProductResponseDTO;
import com.bossabox.api.model.Product;

@Component
public class ProductMapper {

	public Product toEntity(ProductRequestDTO request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());
		product.setQuantity(request.getQuantity());
		return product;
	}

	public ProductResponseDTO toResponse(Product product) {
		ProductResponseDTO response = new ProductResponseDTO();
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setDescription(product.getDescription());
		response.setQuantity(product.getQuantity());
		return response;
	}

	public void updateEntity(Product product, ProductRequestDTO request) {
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());
		product.setQuantity(request.getQuantity());
	}
}
