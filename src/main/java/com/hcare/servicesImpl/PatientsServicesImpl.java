package com.hcare.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcare.dto.PatientsDTO;
import com.hcare.models.Patients;
import com.hcare.repository.PatientsRepository;
import com.hcare.services.PatientsServices;
import com.hcare.transformers.PatientsTransfomer;
import com.hcare.transformers.Transformer;

public class PatientsServicesImpl extends GenericServiceImpl<Patients, PatientsDTO, Long> implements PatientsServices {

	private static Transformer<Patients, PatientsDTO> t = new PatientsTransfomer();

	public PatientsServicesImpl() {
		super(t);
	}

	@Autowired
	private PatientsRepository patientsRepository;

	@Autowired
	private PatientsServices patientsServices;
}