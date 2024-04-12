package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
//	Long transactionId = 1L;
	
	@Autowired
	private TransactionRepository transactionRepo;

//	public Transaction save (Transaction transaction) {
//		if (transaction.getId() == null) {
//			transaction.setId(transactionId++);
//		}
//		return transactionRepo.save(transaction);
//	}
	
	public Transaction findById(Long transactionId) {
		return transactionRepo.findById(transactionId);
	}
	
	public List<Transaction> findAll() {
		transactionRepo.findAll();
		sortByDateAscending();
		return transactionRepo.findAll();
	}
	
	public void sortByDateAscending() {
		Collections.sort(transactionRepo.findAll(), new Comparator<Transaction>() 
							{
								@Override
								public int compare(Transaction date1, Transaction date2) 
								{
									return date1.getDate().compareTo(date2.getDate());
								}
							}
						);
	}
//	
//	public void delete(Long transactionId) {
//		transactionRepo.delete(transactionId);
//	}
//	
//	public void populateData () {
//		transactionRepo.populateData();
//	}

}
