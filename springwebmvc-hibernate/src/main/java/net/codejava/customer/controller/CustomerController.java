package net.codejava.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.customer.entity.Customer;
import net.codejava.customer.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		
		List<Customer> list = service.listAll();
		
		for(Customer c : list) {
			System.out.println(c.toString());
		}
		mav.addObject("listCustomer", list);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		model.put("customer", new Customer());
		return "new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer);
		service.save(customer);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCustomerForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		
		Customer customer = service.get(id);
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam long id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String keyword) {
		ModelAndView mav = new ModelAndView("search");
		
		System.out.println(keyword);
		System.out.println(keyword);
		System.out.println(keyword);
		System.out.println(keyword);
		List<Customer> list = service.search(keyword);
		
		mav.addObject("listCustomer", list);
		
		
		return mav;
	}
}
