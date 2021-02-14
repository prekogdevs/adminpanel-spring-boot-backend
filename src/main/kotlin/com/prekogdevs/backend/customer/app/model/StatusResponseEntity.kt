package com.prekogdevs.backend.customer.app.model

data class StatusResponseEntity<T>(val status: Boolean, val message: String, val entity: T?)