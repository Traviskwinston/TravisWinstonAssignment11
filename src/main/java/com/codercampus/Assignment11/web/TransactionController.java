package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		
		List<Transaction> transactions = transactionService.findAll();
		
		Transaction transaction = new Transaction();
		
		model.put("transaction", transaction);
		model.put("transactions", transactions);
				
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransaction (@PathVariable Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		if (transaction == null) {
            // Handle case where transaction is not found
            // You could return an error page or redirect to another page
            return "error"; // Change "error" to the appropriate error page
        }
		model.put("transaction", transaction);
		model.put("transactionId", transactionId);
		System.out.println("Right Call");
		return "transactions";
	}
	
}
