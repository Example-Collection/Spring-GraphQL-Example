package com.example.service.order

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.service.order.dto.OrdersResponseDto

interface OrderQuery : GraphQLQueryResolver {
    fun findOrdersByCustomer(customerId: Int): OrdersResponseDto
}