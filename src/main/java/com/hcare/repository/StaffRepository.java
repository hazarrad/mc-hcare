package com.hcare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcare.model.Patients;
import com.hcare.model.staff;

@Repository
public interface StaffRepository extends CrudRepository<staff, Long> {

	staff findAllByEmailAndPassword(String emil, String password);

}
