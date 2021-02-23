package com.prekogdevs.backend.customer.app.controller

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(private val customerService: CustomerService) {
    @GetMapping("/all")
    fun getCustomers(): MutableIterable<Customer> {
        return customerService.getCustomers()
    }

    @PostMapping("/register")
    fun addCustomer(@RequestBody customer: Customer) =
         customerService.addCustomer(customer)


    @DeleteMapping("/delete/{id}")
    fun deleteCustomer(@PathVariable("id") id: Long) =
        customerService.deleteCustomer(id)

}

