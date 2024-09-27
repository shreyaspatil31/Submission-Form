package com.example.SubmissionForm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@Controller
public class FormController {
    @Autowired
    CustomerRepo repo;

    @GetMapping("/customers")
    @ResponseBody
    public List<Customers> getCustomers(){
        return repo.findAll();
    }

    @GetMapping("/customers/{cid}")
    @ResponseBody
    public Optional<Customers> getCustomerById(@PathVariable("cid") int cid){
        return repo.findById(cid);
    }

    @DeleteMapping("/customers/{cid}")
    @ResponseBody
    public String deleteCustomer(@PathVariable("cid") int cid){
        Optional<Customers> customer = repo.findById(cid);
        if (customer.isPresent()) {
            repo.delete(customer.get());
            return "Customer deleted with id: " + cid;
        } else {
            return "Customer not found with id: " + cid;
        }
    }

    // POST request to add a new customer
    @PostMapping(path="/customers", consumes="application/json", produces="application/json")
    @ResponseBody
    public Customers addCustomer(@RequestBody Customers customer){
        return repo.save(customer);
    }

    // PUT request to update a customer using their ID
    @PutMapping(path="/customers/{cid}", consumes="application/json", produces="application/json")
    @ResponseBody
    public Customers updateCustomer(@PathVariable("cid") int cid, @RequestBody Customers customerDetails){
        Optional<Customers> customerOptional = repo.findById(cid);
        if (customerOptional.isPresent()) {
            Customers existingCustomer = customerOptional.get();
            existingCustomer.setCname(customerDetails.getCname());
            existingCustomer.setCmail(customerDetails.getCmail());
            return repo.save(existingCustomer); // Save updated customer
        } else {
            throw new RuntimeException("Customer not found with id: " + cid);
        }
    }
}
