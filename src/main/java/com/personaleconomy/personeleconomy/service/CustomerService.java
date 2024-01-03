package com.personaleconomy.personeleconomy.service;

import com.personaleconomy.personeleconomy.entity.Customer;
import com.personaleconomy.personeleconomy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        Customer save = customerRepository.save(customer);
        return save;
    }

    public List<Customer> findAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer getCustomerById(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        return customer;
    }

    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
