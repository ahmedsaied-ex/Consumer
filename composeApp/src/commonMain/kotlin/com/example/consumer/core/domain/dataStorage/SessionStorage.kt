package com.example.consumer.core.domain.dataStorage

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

interface SessionStorage {
    fun observeAuthInfo(): Flow<Data?>
    suspend fun set(info: Data?)
}

@Serializable
data class Data(
    val token: String,
    val user: UserDto
)


@Serializable
data class UserDto(
    val balance: Double,
    val created_at: String,
    val email: String,
    val firstname: String,
    val id: String,
    val image: String,
    val is_active: Int,
    val is_anonymous: Int,
    val is_profile_completed: Boolean,
    val language: String,
    val lastname: String,
    val phone: String,
    val phone_code: String,
    val role_code: String
)
