package com.hcare.service;

import com.hcare.dto.StaffDTO;

public interface StaffService extends GenericService<StaffDTO, Long> {

	StaffDTO findAllByEmailAndPassword(String email, String password);

}
