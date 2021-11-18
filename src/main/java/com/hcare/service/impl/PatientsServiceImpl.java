package com.hcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcare.dto.PatientsDTO;
import com.hcare.model.Patients;
import com.hcare.repository.PatientsRepository;
import com.hcare.service.PatientsService;
import com.hcare.transformers.PatientsTransfomer;
import com.hcare.transformers.Transformer;

@Service
public class PatientsServiceImpl extends GenericServiceImpl<Patients, PatientsDTO, Long> implements PatientsService {

	private static Transformer<Patients, PatientsDTO> t = new PatientsTransfomer();

	public PatientsServiceImpl() {
		super(t);
	}

	@Autowired
	private PatientsRepository patientsRepository;

	@Autowired
	private PatientsService patientsServices;

	@Override
	public PatientsDTO findAllByEmailAndPassword(String email, String password) {
		return t.toDTO(patientsRepository.findAllByEmailAndPassword(email, password));
	}
}