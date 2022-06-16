package com.selenanguyen.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenanguyen.savetravels.models.Expense;
import com.selenanguyen.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
	//========== Create/Update ============
	public Expense save(Expense s) {
		return expenseRepo.save(s);
	}
	
	//========== Read ============
	public List<Expense> getAll(){
		return expenseRepo.findAll();
	}
	
	public Expense getOne(Long id) {
		Optional<Expense>optExpense=expenseRepo.findById(id);
		
		if(optExpense.isPresent()) {
			return optExpense.get();
		}else {
			return null;
		}
	}
	
	
	//========== Delete ============
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
}
