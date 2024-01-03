package com.personaleconomy.personeleconomy.controller;

import com.personaleconomy.personeleconomy.entity.Customer;
import com.personaleconomy.personeleconomy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer addCustomer = customerService.addCustomer(customer);
        ResponseEntity<Customer> customerResponseEntity = new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
        return customerResponseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customerService.findAllCustomer();
        ResponseEntity<List<Customer>> listResponseEntity = new ResponseEntity<>(allCustomer, HttpStatus.OK);
        return listResponseEntity;
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable("id") Long id) {
        Customer customerById = customerService.getCustomerById(id);
        ResponseEntity<Customer> customerResponseEntity = new ResponseEntity<>(customerById, HttpStatus.OK);
        return customerResponseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
