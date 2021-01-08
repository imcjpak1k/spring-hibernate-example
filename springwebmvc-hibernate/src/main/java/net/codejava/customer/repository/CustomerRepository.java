package net.codejava.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codejava.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query(value = "select c from Customer c "
			+ "where c.name like '%'|| :keyword || '%'"
			+ "or c.email like '%'|| :keyword || '%'"
			+ "or c.address like '%'|| :keyword || '%'"
			+ "")
	public List<Customer> search(@Param("keyword") String keyword) ;
}
