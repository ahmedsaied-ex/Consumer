package com.example.consumer.features.completeProfile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.consumer.core.presentation.components.bars.TransparentToolbar
import com.example.consumer.core.presentation.components.ConsumerTextField
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.components.SearchableCountryDropdown
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.features.completeProfile.viewModel.CompleteProfileViewModel
import com.example.consumer.features.onBoarding.presintation.viewModels.OnBoardingViewModel
import consumer.composeapp.generated.resources.ID_Iqama_Number
import consumer.composeapp.generated.resources.LastName
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.firstName
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun CompleteProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: CompleteProfileViewModel = koinViewModel()

) {

    val uiState by viewModel.state.collectAsState()
    val countrySearchState = rememberTextFieldState(initialText = "")

    val firstNameState = rememberTextFieldState(initialText = "")
    val lastNameState = rememberTextFieldState(initialText = "")
    var firstNameFocused by remember { mutableStateOf(false) }
    var lastNameFocused by remember { mutableStateOf(false) }
    var firstNameTouched by remember { mutableStateOf(false) }
    var lastNameTouched by remember { mutableStateOf(false) }
    var iqamaFocused by remember { mutableStateOf(false) }
    val iqamaState = rememberTextFieldState()
    var iqamaTouched     by remember { mutableStateOf(false) }

    LaunchedEffect(firstNameState) {
        snapshotFlow { firstNameState.text.toString() }
            .collect { value ->
                if (firstNameTouched) {
                    viewModel.validateFirstName(value)
                }
            }
    }

    LaunchedEffect(lastNameState) {
        snapshotFlow { lastNameState.text.toString() }
            .collect { value ->
                if (lastNameTouched) {
                    viewModel.validateLastName(value)
                }
            }
    }


    ConsumerTheme {
        CostumeScaffold {
            Column(modifier = Modifier.fillMaxSize()) {
                TransparentToolbar(
                    title = "أدخل معلوماتك الأساسية",
                    navController = navController

                )
                Spacer(modifier = Modifier.height(28.dp))

                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        ConsumerTextField(
                            label = { Text(stringResource(Res.string.firstName)) },
                            state = firstNameState,
                            supportingText = {
                                uiState.firstName.error?.let {
                                    Text(text = it)
                                }
                            },
                            isError = firstNameTouched &&
                                    uiState.firstName.error != null,
                            modifier = Modifier.weight(1f).onFocusChanged { focusState ->
                                if (focusState.isFocused) {
                                    firstNameFocused = true   // user entered the field
                                } else if (firstNameFocused) {
                                    // only runs after the user actually focused then left
                                    firstNameTouched = true
                                    viewModel.validateFirstName(firstNameState.text.toString())
                                }
                            }
                        )
                        ConsumerTextField(
                            label = { Text(stringResource(Res.string.LastName)) },
                            modifier = Modifier.weight(1f).onFocusChanged { focusState ->
                                if (focusState.isFocused) {
                                    lastNameFocused = true
                                } else if (lastNameFocused) {
                                    lastNameTouched = true
                                    viewModel.validateLastName(lastNameState.text.toString())
                                }
                            },
                            isError = lastNameTouched && uiState.lastName.error != null,
                            state = lastNameState,
                            supportingText = {
                                uiState.lastName.error?.let { Text(text = it) }
                            },
                        )


//                        ConsumerTextField(
//                            state = rememberTextFieldState(),
//                            trailingIcon = ,
//                            label =
//                        )
                    }
                    SearchableCountryDropdown(
                        searchState = countrySearchState,
                        selectedCountry = uiState.selectedCountry,
                        countriesState = uiState.countriesState,
                        expanded = uiState.countryDropdownOpen,
                        onToggleExpanded = viewModel::toggleCountryDropdown,
                        onCountrySelected = { country ->
                            viewModel.onCountrySelected(country.id)
                        },
                        onRetry = viewModel::retryLoadCountries,
                        placeholder = "Country",
                        error = uiState.countryError,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    ConsumerTextField(
                        label = { Text(stringResource(Res.string.ID_Iqama_Number)) },
                        state = iqamaState,
                        isError = iqamaTouched && uiState.iqamaNumber.error != null,
                        supportingText = {
                            // Always show character counter + error in the same slot
                            val count = iqamaState.text.length
                            val error = if (iqamaTouched) uiState.iqamaNumber.error else null
                            Text(
                                text = error ?: "$count / 10",
                                color = if (error != null) MaterialTheme.colorScheme.error
                                else MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { fs ->
                                if (fs.isFocused) {
                                    iqamaFocused = true
                                } else if (iqamaFocused) {
                                    iqamaTouched = true
                                    viewModel.validateIqama(iqamaState.text.toString())
                                }
                            },
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun CompleteProfileScreenPreview() {
    ConsumerTheme {
        CompleteProfileScreen()
    }

}