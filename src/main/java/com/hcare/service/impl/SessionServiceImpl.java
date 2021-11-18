package com.hcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcare.dto.SessionsDTO;
import com.hcare.model.Sessions;
import com.hcare.repository.SessionsRepository;
import com.hcare.service.SessionsService;
import com.hcare.transformers.SessionTransformer;
import com.hcare.transformers.Transformer;

@Service
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
