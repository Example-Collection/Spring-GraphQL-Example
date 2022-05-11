package com.example.domain.customer

import com.example.domain.order.Order
import javax.persistence.*

@Entity
@Table(name = "customers")
class Customer(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(nullable = false, name = "customer_id")
    val id: Int? = null,

    @field:Column(nullable = false, name = "nickname")
    val nickname: String,

    @field:Column(nullable = false, name = "email", unique = true)
    val email: String,

    @field:OneToMany(mappedBy = "customer")
    val orders: List<Order> = listOf()
)