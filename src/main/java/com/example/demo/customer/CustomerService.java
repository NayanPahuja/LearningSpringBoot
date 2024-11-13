package com.example.demo.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer getCustomerById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            return customer.orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Customer> getAllCustomers() {
        try {
            return customerRepository.findAll();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void updateCustomer(Long id, Customer customer) {
        try {
            Optional<Customer> customerOptional = customerRepository.findById(id);
            if (customerOptional.isPresent()) {
                customer.setId(id);
                customerRepository.save(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Customer> getCustomerByDomain(String domain) {
        try {
            return customerRepository.findCustomerByDomain(domain);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
