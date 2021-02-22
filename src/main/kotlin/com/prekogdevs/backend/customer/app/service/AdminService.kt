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

    fun login(admin: Admin): Boolean? {
        val potentialAdmin = adminRepository.findByUsername(admin.username)
        val passwordEncoder = BCryptPasswordEncoder()
        var isSuccessfulLogin : Boolean? = null
        potentialAdmin?.let {
            if(passwordEncoder.matches(admin.password, potentialAdmin.password)) {
                isSuccessfulLogin = true
            }
        }
        return isSuccessfulLogin
    }
}