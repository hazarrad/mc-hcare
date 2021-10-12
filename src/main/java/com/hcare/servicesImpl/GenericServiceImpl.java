package com.hcare.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.hcare.services.GenericService;
import com.hcare.transformers.Transformer;

public class GenericServiceImpl<Entity, DTO, Key> implements GenericService<DTO, Key> {

	@Autowired
	private CrudRepository<Entity, Key> crudeRepository;

	public Transformer<Entity, DTO> t;

	public GenericServiceImpl(Transformer<Entity, DTO> t) {
		this.t = t;
	}

	@Override
	public Iterable<DTO> findAll() {
		return t.toDTOList(crudeRepository.findAll());

	}

	@Override
	public Optional<DTO> findById(Key id) {
		return Optional.of(t.toDTO(crudeRepository.findById(id).get()));
	}

	@Override
	public DTO save(DTO dto) {
		return t.toDTO(crudeRepository.save(t.toEntity(dto)));
	}

	@Override
	public void deleteById(Key id) {
		crudeRepository.deleteById(id);

	}

}