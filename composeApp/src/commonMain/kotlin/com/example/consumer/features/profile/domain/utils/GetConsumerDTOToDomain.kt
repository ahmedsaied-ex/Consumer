package com.example.consumer.features.profile.domain.utils

import com.example.consumer.features.profile.domain.models.ConsumerCountryDomain
import com.example.consumer.features.profile.domain.models.ConsumerDomain
import com.example.consumer.features.profile.domain.models.Country
import com.example.consumer.features.profile.domain.models.Gender
import com.example.consumer.features.profile.domain.models.GetConsumerDTO

fun GetConsumerDTO.toDomain(): ConsumerDomain =
    ConsumerDomain(
        canActivate = canActivate ?: false,
        canSuspend = canSuspend ?: false,
        country = country?.toDomain(),
        dateOfBirth = dateOfBirth,
        email = email.orEmpty(),
        firstName = firstName.orEmpty(),
        gender = Gender.fromInt(genderEnum),
        identityNumber = identityNumber,
        joiningDate = joiningDate,
        lastName = lastName.orEmpty(),
        fullName = name.orEmpty(),
        phoneExtension = phoneExtension,
        phoneNumber = phoneNumber.orEmpty(),
        userId = userId.orEmpty(),
        userImage = userImage
    )

fun Country.toDomain(): ConsumerCountryDomain =
    ConsumerCountryDomain(
        countryCode = countryCode.orEmpty(),
        id = id ?: 0,
        name = name.orEmpty()
    )