package com.example.consumer.features.profile.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class GetConsumerDTO(
    val canActivate: Boolean?,
    val canSuspend: Boolean?,
    val country: Country?,
    val dateOfBirth: String?,
    val email: String?,
    val firstName: String?,
    val genderEnum: Int?,
    val identityNumber: String?,
    val joiningDate: String?,
    val lastName: String?,
    val name: String?,
    val phoneExtension: String?,
    val phoneNumber: String?,
    val userId: String?,
    val userImage: String?
)