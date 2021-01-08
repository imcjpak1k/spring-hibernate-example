package net.codejava.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.customer.entity.Customer;
import net.codejava.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository rep;
	
	public List<Customer> listAll() {
		return (List<Customer>) rep.findAll();
	}
	
	public List<Customer> search(String keyword) {
		return rep.search(keyword);
	}
	
	public void save(Customer customer) {
		rep.save(customer);
	}
	
	public Customer get(long id) {
		Optional<Customer> optional = rep.findById(id);
		return optional.get();
	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
}
