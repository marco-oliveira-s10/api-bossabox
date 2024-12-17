package com.bossabox.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bossabox.api.dto.ProductRequestDTO;
import com.bossabox.api.dto.ProductResponseDTO;
import com.bossabox.api.mapper.ProductMapper;
import com.bossabox.api.model.Product;
import com.bossabox.api.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	private final ProductMapper mapper;

	@Transactional(readOnly = true)
	public Page<ProductResponseDTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(mapper::toResponse);
	}

	@Transactional(readOnly = true)
	public ProductResponseDTO findById(Long id) {
		return repository.findById(id).map(mapper::toResponse)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
	}

	@Transactional
	public ProductResponseDTO create(ProductRequestDTO request) {
		Product product = mapper.toEntity(request);
		product = repository.save(product);
		return mapper.toResponse(product);
	}

	@Transactional
	public ProductResponseDTO update(Long id, ProductRequestDTO request) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

		mapper.updateEntity(product, request);
		product = repository.save(product);
		return mapper.toResponse(product);
	}

	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("Produto não encontrado");
		}
		repository.deleteById(id);
	}
}