package com.example.SubmissionForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    // Create a new customer (POST)
    public Customers addCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    // Retrieve all customers (GET)
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Retrieve a customer by ID (GET)
    public Optional<Customers> getCustomerById(Integer cid) {
        return customerRepository.findById(cid);
    }

    // Update an existing customer (PUT)
    public Customers updateCustomer(Integer cid, Customers customerDetails) {
        Optional<Customers> customerOptional = customerRepository.findById(cid);
        if (customerOptional.isPresent()) {
            Customers customer = customerOptional.get();
            customer.setCname(customerDetails.getCname());
            customer.setCmail(customerDetails.getCmail());
            return customerRepository.save(customer);
        }
        return null;
    }

    // Delete a customer by ID (DELETE)
    public void deleteCustomer(Integer cid) {
        customerRepository.deleteById(cid);
    }
}
