package com.hospitalStaff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalStaff.entity.HospitalStaff;
@Repository
public interface StaffRepo extends  JpaRepository<HospitalStaff, Integer> {

}
