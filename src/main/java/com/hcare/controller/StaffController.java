package com.hcare.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcare.dto.staffDTO;
import com.hcare.dto.staffDTO;
import com.hcare.services.StaffService;


@CrossOrigin(origins = "*")
@RestController
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping(path = "/addStaff")
	public staffDTO addStaff(@RequestBody staffDTO rdto) {

		return staffService.save(rdto);
	}

	@GetMapping(path = "/findAll")
	public Iterable<staffDTO> findAll() {
		return staffService.findAll();
	}

	@GetMapping(path = "/deleteById")
	public String deleteById(@RequestParam Long id) {
		staffService.deleteById(id);
		return "staff has been deleted";
	}

	@PostMapping(path = "/updateStaff")
	public staffDTO updateStaff(@RequestBody staffDTO dto) {

		staffDTO editedstaffDTO = null;
		Optional<staffDTO> optionalstaffDTO = staffService.findById(dto.getId());

		if (optionalstaffDTO.isPresent()) {
			staffDTO staffDTOToEdit = optionalstaffDTO.get();
			editedstaffDTO = staffService.save(staffDTOToEdit);
		}

		return editedstaffDTO;
	}

	@GetMapping(path = "/getStaff")
	public staffDTO getStaff(@RequestParam Long id) {
		staffDTO staffDTOFound = null;
		Optional<staffDTO> optionalstaffDTO = staffService.findById(id);

		if (optionalstaffDTO.isPresent()) {
			staffDTOFound = optionalstaffDTO.get();
		}
		return staffDTOFound;
	}
}