package com.example.consumer.core.domain.model

interface Validator {
    fun validate(value: String): ValidationResult
}