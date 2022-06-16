package com.selenanguyen.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.selenanguyen.savetravels.models.Expense;
import com.selenanguyen.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService serv;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	// ========== Display ==============
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", serv.getAll());
		
		return "index.jsp";
	}
	
	@GetMapping(value="/expenses/{id}/show")
	public String expenseInfo(@PathVariable("id") Long id, Model model) {
		Expense expense=serv.getOne(id);
		model.addAttribute("expense", expense);
		
		return "showOneExpense.jsp";
	}
	
	
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", serv.getOne(id));
		
		return "editExpense.jsp";
	}
	
	
	// ========== Action ==============
	
	@PostMapping("/expenses/create")
	public String createExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}else {
			serv.save(expense);
			
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping(value="/expenses/{id}/update", method=RequestMethod.PUT)
	public String updateExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "editExpense.jsp";
		}else {
			serv.save(expense);
			
			return "redirect:/expenses";
		}
	}
	

    @DeleteMapping("/expenses/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        serv.delete(id);
        return "redirect:/expenses";
    }


	


}
