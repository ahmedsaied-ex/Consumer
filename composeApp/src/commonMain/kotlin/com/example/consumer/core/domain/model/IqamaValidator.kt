package com.example.consumer.core.domain.model

class IqamaValidator : Validator {

    override fun validate(value: String): ValidationResult {

        val trimmed = value.trim()

        return when {
            trimmed.isEmpty() ->
                ValidationResult(
                    isValid = false,
                    errorMessage = "ID / Iqama number is required and must be valid"
                )

            !trimmed.all { it.isDigit() } ->
                ValidationResult(
                    isValid = false,
                    errorMessage = "ID / Iqama number must contain numbers only"
                )

            trimmed.length != 10 ->
                ValidationResult(
                    isValid = false,
                    errorMessage = "ID / Iqama number must be exactly 10 digits"
                )

            else ->
                ValidationResult(isValid = true)
        }
    }
}
