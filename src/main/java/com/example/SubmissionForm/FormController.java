package com.example.SubmissionForm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
    
    @RequestMapping("/customers")
    @ResponseBody
    public List<Customers> getCustomers(){
    	return repo.findAll();
    }
    
    @RequestMapping("/customers/{cid}")
    @ResponseBody
    public Optional<Customers> getCustomers2(@PathVariable("cid") int cid){
    	return repo.findById(cid);
    }
    
    @DeleteMapping("/customers/{cid}")
    public Optional<Customers> getCustomers3(@PathVariable("cid") int cid){
    	@SuppressWarnings("deprecation")
		Customers cust = repo.getOne(cid);
    	repo.delete(cust);
    	return Optional.ofNullable(cust);
    }
    
    @PutMapping(path="/customers", consumes= {"application/json"})
    public Customers getCustomers4(@RequestBody Customers customers){
    	repo.save(customers);
    	return customers;
    }
}