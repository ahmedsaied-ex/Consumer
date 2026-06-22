package com.example.consumer.features.profile.domain.models


data class ConsumerDomain(
    val canActivate: Boolean,
    val canSuspend: Boolean,
    val country: ConsumerCountryDomain?,
    val dateOfBirth: String?,
    val email: String,
    val firstName: String,
    val gender: Gender,
    val identityNumber: String?,
    val joiningDate: String?,
    val lastName: String,
    val fullName: String,
    val phoneExtension: String?,
    val phoneNumber: String,
    val userId: String,
    val userImage: String?
)

