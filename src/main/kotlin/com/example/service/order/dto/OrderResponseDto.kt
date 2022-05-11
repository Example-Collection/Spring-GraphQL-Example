package com.example.service.order.dto

import com.example.domain.customer.Customer
import com.example.domain.order.Order
import com.example.service.customer.dto.CustomerResponseDto
import java.time.format.DateTimeFormatter.ofPattern

data class OrderResponseDto(
    val id: Int,
    val customer: CustomerResponseDto,
    val content: String,
    val createdAt: String,
    val isDelivered: Boolean
) {
    companion object {
        fun from(order: Order, customer: Customer) = OrderResponseDto(
            id = order.id!!,
            customer = CustomerResponseDto.from(customer),
            content = order.content,
            createdAt = ofPattern("yyyy-MM-dd HH:mm:ss").format(order.createdAt),
            isDelivered = order.isDelivered
        )
    }
}
