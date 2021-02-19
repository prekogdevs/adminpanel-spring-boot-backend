package com.prekogdevs.backend.customer.app.service

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getCustomers(): MutableIterable<Customer> {
        return customerRepository.findAll()
    }

    fun addCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun deleteCustomer(id: Long): Optional<Customer> {
        return customerRepository.findById(id)
    }
}