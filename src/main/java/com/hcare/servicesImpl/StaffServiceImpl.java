package com.hcare.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcare.dto.staffDTO;
import com.hcare.models.staff;
import com.hcare.repository.StaffRepository;
import com.hcare.services.StaffService;
import com.hcare.transformers.StaffTransfomer;
import com.hcare.transformers.Transformer;

@Service
public class StaffServiceImpl extends GenericServiceImpl<staff, staffDTO, Long> implements StaffService {

	private static Transformer<staff, staffDTO> t = new StaffTransfomer();

	public StaffServiceImpl() {
		super(t);
	}

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffService staffService;
}
