package com.example.service.order.impl

import com.example.domain.customer.CustomerRepository
import com.example.domain.order.Order
import com.example.domain.order.OrderRepository
import com.example.service.order.OrderMutation
import com.example.service.order.dto.OrderResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderMutationImpl(
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) : OrderMutation {

    @Transactional
    override fun createOrder(customerId: Int, content: String): OrderResponseDto {
        val customer = customerRepository.findById(customerId).orElseThrow {
            IllegalArgumentException("Customer not found")
        }
        val order = orderRepository.save(
            Order(customer = customer, content = content))
        return OrderResponseDto.from(order, customer)
    }

    @Transactional
    override fun updateOrder(customerId: Int, orderId: Int, content: String): OrderResponseDto {
        val customer = customerRepository.findById(customerId).orElseThrow {
            IllegalArgumentException("Customer not found")
        }
        val order = orderRepository.findByCustomerAndId(customer, orderId)
        order?.let {
            it.updateContent(content)
            return OrderResponseDto.from(it, customer)
        } ?: throw IllegalArgumentException("Order not found")
    }
}