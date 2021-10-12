package com.hcare.transformers;

import com.hcare.dto.staffDTO;
import com.hcare.models.staff;

public class StaffTransfomer extends Transformer<staff, staffDTO> {

	@Override
	public staff toEntity(staffDTO dto) {
		if (dto == null) {
			return null;
		}
		return new staff();

	}

	@Override
	public staffDTO toDTO(staff entity) {
		if (entity == null) {
			return null;
		}
		return new staffDTO();
	}

}