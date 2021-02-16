package com.prekogdevs.backend.customer.app.model

import javax.persistence.*

@Entity
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",
        var email: String = "",
        @Lob
        val avatar : String = ""
)