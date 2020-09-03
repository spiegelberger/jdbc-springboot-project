package com.spiegelberger.jdbcspringbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiegelberger.jdbcspringbootproject.dao.SaleDAO;
import com.spiegelberger.jdbcspringbootproject.model.Sale;

@Service
public class SaleServiceImpl implements SaleService {
	
	private SaleDAO saleDAO;
	
	@Autowired
	public SaleServiceImpl(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}

	@Override
	public List<Sale> list() {
		return saleDAO.list();
	}

	@Override
	public Sale findById(int id) {
		
		return saleDAO.get(id);
	}

	@Override
	public void save(Sale sale) {
		saleDAO.save(sale);
		
	}

	@Override
	public void update(Sale sale) {
		saleDAO.update(sale);
		
	}

	@Override
	public void delete(int id) {
		saleDAO.delete(id);
		
	}

}
