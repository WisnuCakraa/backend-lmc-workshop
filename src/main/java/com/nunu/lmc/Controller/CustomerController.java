package com.nunu.lmc.Controller;

import com.nunu.lmc.Entity.Customer;
import com.nunu.lmc.Entity.ResponsePaging;
import com.nunu.lmc.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/list-email")
    public ResponsePaging getAllCustomerEmail(
            @RequestHeader("pageNumber") Integer pageNumber
    ) {
        //set data from service
        Page<Customer> page = customerService.getAllCustomerEmail(pageNumber);

        //set response
        ResponsePaging responsePaging = new ResponsePaging();
        responsePaging.setPageSize(page.getSize());
        responsePaging.setCurrentPage(pageNumber);
        responsePaging.setTotalItem(page.getTotalElements());
        responsePaging.setTotalPage(page.getTotalPages());
        responsePaging.setData(page.getContent());

        return responsePaging;
    }

    @PostMapping(path = "/add-email")
    public void subscribeMe(@RequestBody Customer customer) {
        customerService.addNewCustomerEmail(customer);
    }

}
