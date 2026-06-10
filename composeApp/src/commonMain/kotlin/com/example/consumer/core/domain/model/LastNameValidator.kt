package com.example.consumer.core.domain.model

class LastNameValidator : Validator {

    private val regex =
        Regex("^[a-zA-Z\\u0621-\\u064A\\u066E-\\u066F\\u0671-\\u06D3 ]+$")
    override fun validate(value: String): ValidationResult {

        val trimmed = value.trim()

        return when {
            trimmed.isEmpty() ->
                ValidationResult(
                    false,
                    "Last name is required"
                )

            !regex.matches(trimmed) ->
                ValidationResult(
                    false,
                    "Only Arabic letters, English letters and spaces are allowed"
                )

            trimmed.length < 2 ->
                ValidationResult(
                    false,
                    "Last name must be at least 2 characters"
                )

            trimmed.length > 50 ->
                ValidationResult(
                    false,
                    "Last name must not exceed 50 characters"
                )


            else ->
                ValidationResult(true)
        }
    }
}