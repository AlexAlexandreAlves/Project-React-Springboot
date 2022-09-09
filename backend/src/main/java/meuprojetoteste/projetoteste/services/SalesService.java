package meuprojetoteste.projetoteste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuprojetoteste.projetoteste.entities.Sales;
import meuprojetoteste.projetoteste.repositories.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	public List<Sales> findSales() {
		return repository.findAll();
		
	}
	
}
