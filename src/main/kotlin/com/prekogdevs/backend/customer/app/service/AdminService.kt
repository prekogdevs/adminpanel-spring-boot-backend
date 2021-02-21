package com.prekogdevs.backend.customer.app.service

import com.prekogdevs.backend.customer.app.model.Admin
import com.prekogdevs.backend.customer.app.repository.AdminRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminService(private val adminRepository: AdminRepository) {

    fun getAdmins(): MutableIterable<Admin> {
        return adminRepository.findAll()
    }

    fun login(admin: Admin): Admin? {
        val potentialAdmin = adminRepository.findByUsername(admin.username)
        val passwordEncoder = BCryptPasswordEncoder()
        potentialAdmin?.let {
            return when (passwordEncoder.matches(admin.password, potentialAdmin.password)) {
                true -> potentialAdmin
                false -> null
            }
        }
        return null
    }
}