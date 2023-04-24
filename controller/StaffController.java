package com.hospitalStaff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospitalStaff.entity.HospitalStaff;
import com.hospitalStaff.service.StaffService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
	List<HospitalStaff> staff=	service.getAllStaff();
	 m.addAttribute("staff",staff);
		return "index";
	}
	
	//linking add_hospitalStaff html page to index 
	@GetMapping("/add_hospitalStaff")
	public String addHospitalStaffForm()
	{
		return "add_hospitalStaff";
	}
	//url mapping register & using http session servlet concerpt for msg in my browser
	@PostMapping("/register")
	public String staffRegister(@ModelAttribute HospitalStaff h, HttpSession session)
	{
		System.out.println(h);
		
		service.addStaff(h);
		session.setAttribute("msg","Staff added succesfully.....");
		return "redirect:/";
	} 
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m)
	{
		HospitalStaff h=service.getStaffById(id);
		m.addAttribute("staff",h);
		return "edit";
	}
	@GetMapping("/update")
     public String  updateStaff(@ModelAttribute HospitalStaff h ,HttpSession session)
     {
		service.addStaff(h);
		session.setAttribute("msg","staff info updated succesfully.....");
		return "redirect:/";
     }
	@GetMapping("/delete/{id}")
	public String deleteStaff(@PathVariable  int id, HttpSession session)
	{
		service.deleteStaff(id);
		session.setAttribute("msg","staff info deleted succesfully.....");
		return "redirect/";
	}
	
}
