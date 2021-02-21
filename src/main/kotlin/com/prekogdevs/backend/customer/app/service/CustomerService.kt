package com.prekogdevs.backend.customer.app.service

import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getCustomers(): MutableIterable<Customer> =
            customerRepository.findAll()


    fun addCustomer(customer: Customer) =
            customerRepository.save(customer)


    fun deleteCustomer(id: Long) =
            customerRepository.findCustomerById(id)


}
