package com.bossabox.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {

	@NotBlank(message = "Nome é obrigatório")
	private String name;

	@NotNull(message = "Preço é obrigatório")
	@Min(value = 0, message = "Preço deve ser maior ou igual a zero")
	private BigDecimal price;

	private String description;

	@NotNull(message = "Quantidade é obrigatória")
	@Min(value = 0, message = "Quantidade deve ser maior ou igual a zero")
	private Integer quantity;
}
