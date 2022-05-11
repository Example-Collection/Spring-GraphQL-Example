package com.example.service.customer.impl

import com.example.domain.customer.CustomerRepository
import com.example.service.customer.CustomerQuery
import com.example.service.customer.dto.CustomerResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerQueryImpl(
    private val customerRepository: CustomerRepository
) : CustomerQuery {

    @Transactional(readOnly = true)
    override fun getCustomerInfo(customerId: Int): CustomerResponseDto {
        val customer = customerRepository.findById(customerId)
        if (customer.isPresent) {
            return CustomerResponseDto.from(customer.get())
        } else throw IllegalArgumentException("Customer not found")
    }
}