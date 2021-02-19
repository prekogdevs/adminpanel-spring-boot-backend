package com.prekogdevs.backend.customer.app.config

import com.prekogdevs.backend.customer.app.model.Admin
import com.prekogdevs.backend.customer.app.model.Customer
import com.prekogdevs.backend.customer.app.repository.AdminRepository
import com.prekogdevs.backend.customer.app.repository.CustomerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import javax.persistence.PrePersist


/**
 * This class is executed every-time the application starts so we need to delete everything before we add new data.
 */
@Component
class DBHelper(private val customerRepository: CustomerRepository, private val adminRepository: AdminRepository) : CommandLineRunner {

    @PrePersist
    fun deleteAllBeforeSaving() {
        customerRepository.deleteAll()
        adminRepository.deleteAll()
    }

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        val customers = listOf(
                Customer(1, "Kis Elemér", "kiselemer@myaddress.com"),
                Customer(2, "Közepes Elemér", "kozepeselemer@myaddress.com"),
                Customer(3, "Nagy Elemér", "nagyelemer@myaddress.com")
        )
        customerRepository.saveAll(customers)

        // TODO: Register admin form later
        val encrypt = BCryptPasswordEncoder()
        val admin = Admin("admin", encrypt.encode("admin"))
        adminRepository.save(admin)
    }
}