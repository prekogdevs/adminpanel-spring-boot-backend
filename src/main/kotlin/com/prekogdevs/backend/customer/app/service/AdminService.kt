package com.prekogdevs.backend.customer.app.service

import com.prekogdevs.backend.customer.app.model.Admin
import com.prekogdevs.backend.customer.app.repository.AdminRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminService(private val adminRepository: AdminRepository) {

    fun getAdmins(): MutableIterable<Admin> {
        return adminRepository.findAll()
    }

    fun login(admin: Admin): ResponseEntity<String> {
        val potentialAdmin = adminRepository.findByUsername(admin.username)
        val passwordEncoder = BCryptPasswordEncoder()
        potentialAdmin?.let {
            return when (passwordEncoder.matches(admin.password, potentialAdmin.password)) {
                true -> ResponseEntity("Login was successful", HttpStatus.OK)
                false -> ResponseEntity("Wrong username or password", HttpStatus.UNAUTHORIZED)
            }
        }
        return ResponseEntity("Wrong username or password", HttpStatus.UNAUTHORIZED)
    }
}