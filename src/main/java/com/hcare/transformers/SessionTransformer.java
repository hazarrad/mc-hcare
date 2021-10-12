package com.hcare.transformers;

import com.hcare.dto.SessionsDTO;
import com.hcare.models.Sessions;

public class SessionTransformer extends Transformer<Sessions, SessionsDTO> {

	@Override
	public Sessions toEntity(SessionsDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Sessions();

	}

	@Override
	public SessionsDTO toDTO(Sessions entity) {
		if (entity == null) {
			return null;
		}
		return new SessionsDTO();
	}

}