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
import com.hcare.dto.StaffDTO;
import com.hcare.service.StaffService;
import com.hcare.dto.StaffDTO;


@CrossOrigin(origins = "*")
@RestController
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping(path = "/addStaff")
	public StaffDTO addStaff(@RequestBody StaffDTO rdto) {

		return staffService.save(rdto);
	}


	
	@RequestMapping(value = "/findAllStaffs", method = RequestMethod.GET)
	public Iterable<StaffDTO> findAllPatients() {
		return staffService.findAll();
	}

	@GetMapping(path = "/deleteStaffById")
	public String deleteById(@RequestParam Long id) {
		staffService.deleteById(id);
		return "staff has been deleted";
	}

	@PostMapping(path = "/updateStaff")
	public StaffDTO updateStaff(@RequestBody StaffDTO dto) {

		StaffDTO editedStaffDTO = null;
		Optional<StaffDTO> optionalStaffDTO = staffService.findById(dto.getId());

		if (optionalStaffDTO.isPresent()) {
			StaffDTO StaffDTOToEdit = optionalStaffDTO.get();
			editedStaffDTO = staffService.save(StaffDTOToEdit);
		}

		return editedStaffDTO;
	}

	@GetMapping(path = "/staffLogin")
	public StaffDTO staffLogin(@RequestParam String email, @RequestParam String password) {
		return staffService.findAllByEmailAndPassword(email, password);
		
	}

	@GetMapping(path = "/getStaff")
	public StaffDTO getStaff(@RequestParam Long id) {
		StaffDTO StaffDTOFound = null;
		Optional<StaffDTO> optionalStaffDTO = staffService.findById(id);

		if (optionalStaffDTO.isPresent()) {
			StaffDTOFound = optionalStaffDTO.get();
		}
		return StaffDTOFound;
	}
}
