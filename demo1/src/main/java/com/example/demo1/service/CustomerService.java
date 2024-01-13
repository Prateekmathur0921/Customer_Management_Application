package com.example.demo1.service;
import com.example.demo1.DAO.CustomerDAO;
import com.example.demo1.Exception.CustomerNotFound;
import com.example.demo1.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    private static int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    public Customer addCustomer(Customer customer){
          return customerDAO.save(customer);
    }
    public List<Customer> getCustomers(){
            return customerDAO.findAll();
    }
    public Customer getCustomer(int customerId){
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFound("Customer With provided ID is not available...");

        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){
            customer.setCustomerId(customerId);
            return customerDAO.save(customer);
    }
    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
}
