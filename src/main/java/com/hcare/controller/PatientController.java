package com.hcare.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcare.dto.PatientsDTO;
import com.hcare.services.PatientsServices;

@CrossOrigin(origins = "*")
@RestController
public class PatientController {

	@Autowired
	private PatientsServices patientsServices;

	@PostMapping(path = "/addPatient")
	public PatientsDTO addPatient(@RequestBody PatientsDTO rdto) {

		return patientsServices.save(rdto);
	}

	@GetMapping(path = "/findAll")
	public Iterable<PatientsDTO> findAll() {
		return patientsServices.findAll();
	}

	@GetMapping(path = "/deleteById")
	public String deleteById(@RequestParam Long id) {
		patientsServices.deleteById(id);
		return "Patient has been deleted";
	}

	@PostMapping(path = "/updatePatient")
	public PatientsDTO updatePatient(@RequestBody PatientsDTO dto) {

		PatientsDTO editedPatientsDTO = null;
		Optional<PatientsDTO> optionalPatientsDTO = patientsServices.findById(dto.getId());

		if (optionalPatientsDTO.isPresent()) {
			PatientsDTO PatientsDTOToEdit = optionalPatientsDTO.get();
			editedPatientsDTO = patientsServices.save(PatientsDTOToEdit);
		}

		return editedPatientsDTO;
	}

	@GetMapping(path = "/getPatient")
	public PatientsDTO getPatient(@RequestParam Long id) {
		PatientsDTO PatientsDTOFound = null;
		Optional<PatientsDTO> optionalPatientsDTO = patientsServices.findById(id);

		if (optionalPatientsDTO.isPresent()) {
			PatientsDTOFound = optionalPatientsDTO.get();
		}
		return PatientsDTOFound;
	}
}
