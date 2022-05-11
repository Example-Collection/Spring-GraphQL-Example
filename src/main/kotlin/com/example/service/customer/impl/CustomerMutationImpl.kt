package com.example.service.customer.impl

import com.example.domain.customer.Customer
import com.example.domain.customer.CustomerRepository
import com.example.service.customer.CustomerMutation
import com.example.service.customer.dto.CustomerResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerMutation(
    private val customerRepository: CustomerRepository
) : CustomerMutation {

    @Transactional
    override fun createCustomer(nickname: String, email: String): CustomerResponseDto {
        if(customerRepository.existsByEmail(email)) {
            throw IllegalArgumentException("Email already exists")
        }
        val customer = customerRepository.save(Customer(nickname = nickname, email = email))
        return CustomerResponseDto.from(customer)
    }
}