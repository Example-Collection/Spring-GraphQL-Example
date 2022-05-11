package com.example.service.customer

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.service.customer.dto.CustomerResponseDto

interface CustomerMutation : GraphQLMutationResolver {
    fun createCustomer(nickname: String, email: String): CustomerResponseDto
}