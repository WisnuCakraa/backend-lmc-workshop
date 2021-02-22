package com.nunu.lmc.Service;

import com.nunu.lmc.Constants;
import com.nunu.lmc.Entity.Customer;
import com.nunu.lmc.Entity.ErrorException;
import com.nunu.lmc.Repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public  CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> getAllCustomerEmail(Integer pageNumber) {
        Pageable page = PageRequest.of(pageNumber - 1, 10, Sort.by("email").ascending()); //FE would send page start 1, but here would start 0

        return customerRepository.findAll(page);
    }

    public void addNewCustomerEmail(Customer customer) {

        //check email exist
        Optional<Customer> email = customerRepository.findByEmail(customer.getEmail());

        //only save if email doesnt exist
        if(!email.isPresent()){
            customerRepository.save(customer);
        }

    }

    public void deleteCustomerEmail(Integer customerId) {
        Boolean exist = customerRepository.existsById(customerId);
        ErrorException error = new ErrorException(Constants.ID_NOT_EXIST_ERROR_CODE, "Category ID doesnt exist");

        if(!exist) {
            throw new IllegalStateException(error.getFullErrorMessage());
        }

        customerRepository.deleteById(customerId);
    }

}
