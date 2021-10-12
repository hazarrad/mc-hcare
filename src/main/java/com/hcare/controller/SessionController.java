package com.hcare.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcare.dto.SessionsDTO;
import com.hcare.services.SessionsService;

@CrossOrigin(origins = "*")
@RestController
public class SessionController {

	@Autowired
	private SessionsService sessionsService;

	@PostMapping(path = "/addSession")
	public SessionsDTO addSession(@RequestBody SessionsDTO rdto) {

		return sessionsService.save(rdto);
	}

	@GetMapping(path = "/findAll")
	public Iterable<SessionsDTO> findAll() {
		return sessionsService.findAll();
	}

	@GetMapping(path = "/deleteSessionById")
	public String deleteById(@RequestParam Long id) {
		sessionsService.deleteById(id);
		return "session has been deleted";
	}

	@PostMapping(path = "/updateSession")
	public SessionsDTO updateSession(@RequestBody SessionsDTO dto) {

		SessionsDTO editedSessionsDTO = null;
		Optional<SessionsDTO> optionalSessionsDTO = sessionsService.findById(dto.getId());

		if (optionalSessionsDTO.isPresent()) {
			SessionsDTO SessionsDTOToEdit = optionalSessionsDTO.get();
			editedSessionsDTO = sessionsService.save(SessionsDTOToEdit);
		}

		return editedSessionsDTO;
	}

	@GetMapping(path = "/getSession")
	public SessionsDTO getSession(@RequestParam Long id) {
		SessionsDTO sessionsDTOFound = null;
		Optional<SessionsDTO> optionalSessionsDTO = sessionsService.findById(id);

		if (optionalSessionsDTO.isPresent()) {
			sessionsDTOFound = optionalSessionsDTO.get();
		}
		return sessionsDTOFound;
	}
}
