package com.hcare.transformers;

import com.hcare.dto.PatientsDTO;
import com.hcare.models.Patients;

public class PatientsTransfomer extends Transformer<Patients, PatientsDTO> {

	@Override
	public Patients toEntity(PatientsDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Patients();

	}

	@Override
	public PatientsDTO toDTO(Patients entity) {
		if (entity == null) {
			return null;
		}
		return new PatientsDTO();
	}

}