package com.example.service.customer.dto

import com.example.domain.customer.Customer

data class CustomerResponseDto(
    val id: Int,
    val nickname: String,
    val email: String
) {
    companion object {
        fun from(customer: Customer) = CustomerResponseDto(
            id = customer.id!!,
            nickname = customer.nickname,
            email = customer.email
        )
    }
}