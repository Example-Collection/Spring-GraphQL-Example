package com.example.service.order

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.service.order.dto.OrderResponseDto

interface OrderMutation : GraphQLMutationResolver {
    fun createOrder(customerId: Int, content: String): OrderResponseDto
    fun updateOrder(customerId: Int, orderId: Int, content: String): OrderResponseDto
}