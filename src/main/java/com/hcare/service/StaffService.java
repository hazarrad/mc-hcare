package com.hcare.service;

import com.hcare.dto.staffDTO;

public interface StaffService extends GenericService<staffDTO, Long> {

	staffDTO findAllByEmailAndPassword(String email, String password);

}
