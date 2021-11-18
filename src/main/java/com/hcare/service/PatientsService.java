package com.hcare.service;

import com.hcare.dto.PatientsDTO;

public interface PatientsService extends GenericService<PatientsDTO, Long> {

	
	PatientsDTO findAllByEmailAndPassword(String email, String password);

}
