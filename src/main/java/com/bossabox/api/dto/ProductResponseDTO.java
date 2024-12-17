package com.bossabox.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductResponseDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private String description;
	private Integer quantity;
}