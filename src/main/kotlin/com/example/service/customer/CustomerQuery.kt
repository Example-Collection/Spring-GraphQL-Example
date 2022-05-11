package com.example.service.customer

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.service.customer.dto.CustomerResponseDto

interface CustomerQuery : GraphQLQueryResolver {
    fun getCustomerInfo(customerId: Int): CustomerResponseDto
}