package com.example.consumer.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.compose.viewmodel.koinViewModel


data class SubmitFormState(
    val selectedUser: User =User(1, "Koin is working ", "alice@example.com", "Admin") ,

)

class SubmitFormViewModel : ViewModel() {
    private val _state = MutableStateFlow(SubmitFormState())
    val state: StateFlow<SubmitFormState> = _state.asStateFlow()


}


data class User(
    val id: Int,
    val name: String,
    val email: String,
    val role: String,
    val avatarInitials: String = name.take(2).uppercase()
)


@Composable
fun test(viewModel: SubmitFormViewModel = koinViewModel()){
Text(viewModel.state.value.selectedUser.name)
}
