package com.spiegelberger.jdbcspringbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spiegelberger.jdbcspringbootproject.model.Sale;
import com.spiegelberger.jdbcspringbootproject.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		List<Sale>list= service.list();
		model.addAttribute("sales", list);
		
		return "index";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String addNew(Model theModel) {
		theModel.addAttribute("sale", new Sale());
		return "new_form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("sale")Sale sale) {
		
		service.save(sale);		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showFormForUpdate(Model theModel, @PathVariable("id")int id) {
		
		Sale sale = service.findById(id);
		theModel.addAttribute("sale", sale);
		return "edit_form";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("sale")Sale sale) {
		
		service.update(sale);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")int id) {
		service.delete(id);
		return "redirect:/";
		
	}
	
}
