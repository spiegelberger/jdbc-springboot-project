package com.spiegelberger.jdbcspringbootproject.service;

import java.util.List;

import com.spiegelberger.jdbcspringbootproject.model.Sale;

public interface SaleService {

	List<Sale>list();
	
	Sale findById(int id);
	
	void save(Sale sale);
	
	void update(Sale sale);
	
	void delete(int id);
	
}
