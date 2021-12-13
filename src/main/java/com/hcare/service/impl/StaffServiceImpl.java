package com.hcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcare.dto.StaffDTO;
import com.hcare.model.staff;
import com.hcare.repository.StaffRepository;
import com.hcare.service.StaffService;
import com.hcare.transformers.StaffTransfomer;
import com.hcare.transformers.Transformer;

@Service
public class StaffServiceImpl extends GenericServiceImpl<staff, StaffDTO, Long> implements StaffService {

	private static Transformer<staff, StaffDTO> t = new StaffTransfomer();

	public StaffServiceImpl() {
		super(t);
	}

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffService staffService;

	@Override
	public StaffDTO findAllByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return t.toDTO(staffRepository.findAllByEmailAndPassword(email, password));
	}
}
