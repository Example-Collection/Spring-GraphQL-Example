package com.example.service.order.dto

data class OrdersResponseDto(
    val orders: List<OrderResponseDto> = listOf()
)
