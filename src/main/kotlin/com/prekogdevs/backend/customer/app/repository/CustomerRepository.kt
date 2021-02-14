package com.prekogdevs.backend.customer.app.repository

import com.prekogdevs.backend.customer.app.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long>