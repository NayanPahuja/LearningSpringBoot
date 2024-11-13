package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/full")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @GetMapping("/email/{domain}")
    public List<Customer> getCustomerByEmail(@PathVariable String domain) {
        return customerService.getCustomerByDomain(domain);
    }
}
