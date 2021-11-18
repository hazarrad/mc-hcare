package com.hcare.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcare.dto.PatientsDTO;
import com.hcare.service.PatientsService;

@CrossOrigin(origins = "*")
@RestController
public class PatientController {

	@Autowired
	private PatientsService patientsServices;

	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "hello world";
	}

	@PostMapping(path = "/addPatient")
	public PatientsDTO addPatient(@RequestBody PatientsDTO rdto) {

		return patientsServices.save(rdto);
	}

	@RequestMapping(value = "/findAllPatients", method = RequestMethod.GET)
	public Iterable<PatientsDTO> findAllPatients() {
		return patientsServices.findAll();
	}

	@GetMapping(path = "/deletePatientById")
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

	@GetMapping(path = "/patientLoging")
	public PatientsDTO patientLogin(@RequestParam String email, @RequestParam String password) {
		return patientsServices.findAllByEmailAndPassword(email, password);

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
