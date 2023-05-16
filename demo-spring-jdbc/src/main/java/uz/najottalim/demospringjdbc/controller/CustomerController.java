package uz.najottalim.demospringjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.najottalim.demospringjdbc.dao.CustomerDAO;

import java.util.List;

@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/customers/all")
    public List<Customer> getAllCustomers(){

    }
}
