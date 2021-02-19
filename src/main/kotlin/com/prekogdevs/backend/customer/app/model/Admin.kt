package com.prekogdevs.backend.customer.app.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Admin(@Id val username : String, val password : String)