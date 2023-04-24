package com.hospitalStaff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalStaff.entity.HospitalStaff;
import com.hospitalStaff.repository.StaffRepo;
@Service
public class StaffService {
	@Autowired
	private StaffRepo repo;
	public void  addStaff(HospitalStaff h)
	{
		repo.save(h);
	}
	public List<HospitalStaff> getAllStaff()
	{
		return repo.findAll();
	}
	public HospitalStaff getStaffById(int id)
	{
		Optional<HospitalStaff> h=repo.findById(id);
		if(h.isPresent())
		{
			return h.get();
		}
		return null;
		
	}
	public void deleteStaff(int id)
	{
		repo.deleteById(id);
	}

}
