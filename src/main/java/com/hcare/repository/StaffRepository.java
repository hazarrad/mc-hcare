package com.hcare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcare.models.staff;

@Repository
public interface StaffRepository extends CrudRepository<staff, Long> {

}
