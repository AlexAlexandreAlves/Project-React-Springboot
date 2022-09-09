package meuprojetoteste.projetoteste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meuprojetoteste.projetoteste.entities.Sales;
import meuprojetoteste.projetoteste.services.SalesService;

@RestController
@RequestMapping(value="/sales")
public class SalesController {
	
	@Autowired
	private SalesService service;
	
	@GetMapping
	public List<Sales> findSales(){
		return service.findSales();
	}
	
}
