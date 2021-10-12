package com.hcare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcare.models.Sessions;

@Repository
public interface SessionsRepository extends CrudRepository<Sessions, Long> {

}
