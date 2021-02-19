package com.prekogdevs.backend.customer.app.controller

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.response.StatusResponseEntity
import com.prekogdevs.backend.customer.app.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(private val customerService: CustomerService) {
    @GetMapping("/all")
    fun getCustomers(): MutableIterable<Customer> {
        return customerService.getCustomers()
    }

    @PostMapping("/register")
    fun addCustomer(@RequestBody customer: Customer): ResponseEntity<StatusResponseEntity<Customer>> {
        val savedItem = customerService.addCustomer(customer)
        return ResponseEntity(StatusResponseEntity(
                true,
                "New customer has been added",
                savedItem
        ), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = customerService.deleteCustomer(id)
        return when {
            item.isPresent -> {
                ResponseEntity(
                        StatusResponseEntity(true, "Customer: ${item.get().name} has been deleted!", true),
                        HttpStatus.OK
                )
            }
            else -> {
                ResponseEntity<StatusResponseEntity<Boolean>>(
                        StatusResponseEntity(false, "Sorry could not find customer with id: $id", false),
                        HttpStatus.NOT_FOUND
                )
            }
        }
    }
}

