package com.hcare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcare.models.Patients;

@Repository
public interface PatientsRepository extends CrudRepository<Patients, Long> {

}
