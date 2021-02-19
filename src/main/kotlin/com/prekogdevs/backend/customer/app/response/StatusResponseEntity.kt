package com.prekogdevs.backend.customer.app.response

data class StatusResponseEntity<T>(val status: Boolean, val message: String, val entity: T?)