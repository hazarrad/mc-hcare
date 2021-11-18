package com.hcare.transformers;

import com.hcare.dto.PatientsDTO;
import com.hcare.model.Patients;

public class PatientsTransfomer extends Transformer<Patients, PatientsDTO> {

	@Override
	public Patients toEntity(PatientsDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Patients(dto.getId(),dto.getEmail(),dto.getFirstName(),dto.getSurname(),dto.getDateInscription(),dto.getPassword());

	}

	@Override
	public PatientsDTO toDTO(Patients entity) {
		if (entity == null) {
			return null;
		}
		return new PatientsDTO(entity.getId(),entity.getEmail(),entity.getFirstName(),entity.getSurname(),entity.getDateInscription(),entity.getPassword());
	}

}