package com.hcare.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcare.dto.SessionsDTO;
import com.hcare.models.Sessions;
import com.hcare.repository.SessionsRepository;
import com.hcare.services.SessionsService;
import com.hcare.transformers.SessionTransformer;
import com.hcare.transformers.Transformer;

public class SessionServiceImpl extends GenericServiceImpl<Sessions, SessionsDTO, Long> implements SessionsService {

	private static Transformer<Sessions, SessionsDTO> t = new SessionTransformer();

	public SessionServiceImpl() {
		super(t);
	}

	@Autowired
	private SessionsRepository sessionsRepository;

	@Autowired
	private SessionsService sessionsService;
}
