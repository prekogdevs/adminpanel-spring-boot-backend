package com.prekogdevs.backend.customer.app.controller

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.model.StatusResponseEntity
import com.prekogdevs.backend.customer.app.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(private val customerRepository: CustomerRepository) {
    @GetMapping("/all")
    fun getCustomers(): MutableIterable<Customer> {
        return customerRepository.findAll()
    }

    @PostMapping("/register")
    fun addCustomer(@RequestBody customer: Customer): ResponseEntity<StatusResponseEntity<Customer>> {
        val savedItem = customerRepository.save(customer)
        return ResponseEntity(StatusResponseEntity(
                true,
                "New customer has been added",
                savedItem
        ), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = customerRepository.findById(id)
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

