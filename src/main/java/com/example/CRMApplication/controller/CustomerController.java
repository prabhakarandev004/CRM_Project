
package com.example.CRMApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRMApplication.model.Customer;
import com.example.CRMApplication.repository.CustomerRepository;

@RestController
@RequestMapping("/CustomerApi")
public class CustomerController {

    @Autowired
    private CustomerRepository custrepo;


    @PostMapping("/save")
    public String createCustomer(@RequestBody Customer crm) {

        custrepo.save(crm);

        return "Successfully Created";
    }

    @GetMapping("/Totalcustomer")
    public List<Customer> getAllCustomer() {

        List<Customer> temps = custrepo.findAll();

        if (temps.isEmpty()) {
            throw new RuntimeException("Customers Not Found");
        }

        return temps;
    }

    @GetMapping("/getcustomer/{customerid}")
    public Customer getCustomer(@PathVariable Long customerid) {

        Optional<Customer> temp = custrepo.findById(customerid);

        if (temp.isEmpty()) {
            throw new RuntimeException("Customer ID Not Found");
        }

        return temp.get();
    }


    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable Long id) {

        if (custrepo.existsById(id)) {

            custrepo.deleteById(id);

            return "Customer Deleted Successfully";

        } else {

            return "Invalid Customer ID";
        }
    }
}
