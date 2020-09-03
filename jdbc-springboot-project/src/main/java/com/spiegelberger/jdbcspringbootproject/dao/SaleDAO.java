package com.spiegelberger.jdbcspringbootproject.dao;

import java.util.List;

import com.spiegelberger.jdbcspringbootproject.model.Sale;

public interface SaleDAO {

	List<Sale>list();
	
	void delete(int id);
	
	Sale get(int id);
	
	void save(Sale sale);
	
	void update(Sale sale);
}
