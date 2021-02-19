package com.prekogdevs.backend.customer.app.service

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getCustomers(): MutableIterable<Customer> {
        return customerRepository.findAll()
    }

    fun addCustomer(customer: Customer): ResponseEntity<String> {
        val newCustomer = customerRepository.save(customer)
        return ResponseEntity(
                "Customer with ${newCustomer.name} has been added",
                HttpStatus.OK)
    }

    fun deleteCustomer(id: Long): ResponseEntity<String> {
        return when (val customer = customerRepository.findCustomerById(id)) {
            null -> ResponseEntity(
                    "Customer with ${customer?.name} name not found",
                    HttpStatus.NOT_FOUND)

            else -> ResponseEntity(
                    "Customer with ${customer.name} has been deleted",
                    HttpStatus.OK)

        }
    }
}