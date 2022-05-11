package com.example.domain.order

import com.example.domain.customer.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Int> {
    fun findByCustomerAndId(customer: Customer, id: Int): Order?
    fun findByCustomer(customer: Customer): List<Order>
}