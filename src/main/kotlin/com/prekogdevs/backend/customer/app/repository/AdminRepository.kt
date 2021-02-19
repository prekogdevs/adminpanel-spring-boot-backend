package com.prekogdevs.backend.customer.app.repository

import com.prekogdevs.backend.customer.app.model.Admin
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AdminRepository : CrudRepository<Admin, Long> {
    fun findByUsername(name: String): Admin?
}