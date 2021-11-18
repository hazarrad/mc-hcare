package com.hcare.transformers;

import com.hcare.dto.staffDTO;
import com.hcare.model.staff;

public class StaffTransfomer extends Transformer<staff, staffDTO> {

	@Override
	public staff toEntity(staffDTO dto) {
		if (dto == null) {
			return null;
		}
		return new staff(dto.getId(),dto.getEmail(),dto.getFirstName(),dto.getSurname(),dto.getDateInscription(),dto.getPassword(),dto.getRole());

	}

	@Override
	public staffDTO toDTO(staff entity) {
		if (entity == null) {
			return null;
		}
		return new staffDTO(entity.getId(),entity.getEmail(),entity.getFirstName(),entity.getSurname(),entity.getDateInscription(),entity.getPassword(),entity.getRole());
	}

}