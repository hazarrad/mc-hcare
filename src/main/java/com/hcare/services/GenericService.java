package com.hcare.services;

import java.util.Optional;

public interface GenericService<DTO, Key> {

	void deleteById(Key id);

	Iterable<DTO> findAll();

	Optional<DTO> findById(Key id);

	DTO save(DTO dto);

}