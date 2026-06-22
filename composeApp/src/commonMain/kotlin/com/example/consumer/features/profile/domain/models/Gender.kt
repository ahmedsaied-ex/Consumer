package com.example.consumer.features.profile.domain.models

enum class Gender {
    UNKNOWN, MALE, FEMALE;

    companion object {
        fun fromInt(value: Int?): Gender = when (value) {
            1 -> MALE
            2 -> FEMALE
            else -> UNKNOWN
        }
    }
}