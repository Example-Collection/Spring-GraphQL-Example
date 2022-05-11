package com.example.domain.order

import com.example.domain.customer.Customer
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(nullable = false, name = "order_id")
    val id: Int? = null,

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "customer_id")
    val customer: Customer,

    @field:Column(name = "content", nullable = false)
    var content: String,

    @field:Column(nullable = false, name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @field:Column(nullable = false, name = "is_delivered")
    val isDelivered: Boolean = false
) {
    fun updateContent(content: String) {
        this.content = content
    }
}