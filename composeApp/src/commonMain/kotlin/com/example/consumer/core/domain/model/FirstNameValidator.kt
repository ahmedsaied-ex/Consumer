package com.example.consumer.features.profile.domain.validation

import com.example.consumer.core.domain.model.ValidationResult
import com.example.consumer.core.domain.model.Validator


class FirstNameValidator : Validator {

    private val regex =
        Regex("^[\\p{L} ]+$")

    override fun validate(value: String): ValidationResult {

        val trimmed = value.trim()

        return when {
            trimmed.isBlank() ->
                ValidationResult(
                    false,
                    "First name is required."
                )

            trimmed.length < 2 ->
                ValidationResult(
                    false,
                    "First name must be at least 2 characters."
                )

            trimmed.length > 50 ->
                ValidationResult(
                    false,
                    "First name must not exceed 50 characters."
                )

            !regex.matches(trimmed) ->
                ValidationResult(
                    false,
                    "Only Arabic, English letters and spaces are allowed."
                )

            else ->
                ValidationResult(true)
        }
    }
}