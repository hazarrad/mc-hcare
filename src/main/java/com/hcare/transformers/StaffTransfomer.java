package com.hcare.transformers;

import com.hcare.dto.StaffDTO;
import com.hcare.model.staff;

public class StaffTransfomer extends Transformer<staff, StaffDTO> {

	@Override
	public staff toEntity(StaffDTO dto) {
		if (dto == null) {
			return null;
		}
		return new staff(dto.getId(),dto.getEmail(),dto.getFirstName(),dto.getSurname(),dto.getDateInscription(),dto.getPassword(),dto.getRole());

	}

	@Override
	public StaffDTO toDTO(staff entity) {
		if (entity == null) {
			return null;
		}
		return new StaffDTO(entity.getId(),entity.getEmail(),entity.getFirstName(),entity.getSurname(),entity.getDateInscription(),entity.getPassword(),entity.getRole());
	}

}