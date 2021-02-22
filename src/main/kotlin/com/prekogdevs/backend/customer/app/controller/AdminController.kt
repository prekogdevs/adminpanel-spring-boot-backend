package com.prekogdevs.backend.customer.app.controller

import com.prekogdevs.backend.customer.app.model.Admin
import com.prekogdevs.backend.customer.app.service.AdminService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("admin")
class AdminController(private val adminService: AdminService) {
    @GetMapping("/all")
    fun getAdmins(): MutableIterable<Admin> {
        return adminService.getAdmins()
    }

    @PostMapping("/login")
    fun login(@RequestBody admin: Admin): Boolean? {
        return adminService.login(admin)
    }
}