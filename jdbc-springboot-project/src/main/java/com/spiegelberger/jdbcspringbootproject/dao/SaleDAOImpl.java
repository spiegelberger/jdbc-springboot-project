package com.spiegelberger.jdbcspringbootproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.spiegelberger.jdbcspringbootproject.model.Sale;

@Repository
public class SaleDAOImpl implements SaleDAO{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SaleDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Sale> list() {

		String sql ="SELECT * FROM sales";
		List<Sale>list =
				jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
		return list;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM sales WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
		
	}

	@Override
	public void save(Sale sale) {
	
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("sales").usingColumns("item","quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		
		insert.execute(param);
	}

	@Override
	public void update(Sale sale) {
		String query = "UPDATE sales SET item=:item, quantity=:quantity, amount=:amount WHERE id =:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		  NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		    template.update(query, param);       
		}  


	@Override
	public Sale get(int id) {
		String sql= "SELECT * FROM sales WHERE id=?";
		Object[]args = {id};
		Sale sale =jdbcTemplate.queryForObject(sql, args,
				       BeanPropertyRowMapper.newInstance(Sale.class));
		
		return sale;
	}
	
	

}
