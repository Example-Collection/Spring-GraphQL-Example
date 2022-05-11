package com.example.service.order.impl

import com.example.domain.customer.CustomerRepository
import com.example.domain.order.OrderRepository
import com.example.service.order.dto.OrderResponseDto
import com.example.service.order.dto.OrdersResponseDto
import com.example.service.order.OrderQuery
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors.toList

@Service
class OrderQueryImpl(
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) : OrderQuery {

    @Transactional(readOnly = true)
    override fun findOrdersByCustomer(customerId: Int): OrdersResponseDto {
        val customer = customerRepository.findById(customerId).orElseThrow {
            IllegalArgumentException("Customer not found")
        }
        val orders = orderRepository.findByCustomer(customer)
        return OrdersResponseDto(
            orders.stream().map {
                OrderResponseDto.from(it, customer)
            }.collect(toList()))
    }
}