package com.blibli.learnspringboot.repository;

import com.blibli.learnspringboot.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>{
}
