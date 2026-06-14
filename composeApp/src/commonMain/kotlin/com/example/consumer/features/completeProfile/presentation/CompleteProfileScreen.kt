package com.example.consumer.features.completeProfile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.consumer.core.presentation.components.bars.TransparentToolbar
import com.example.consumer.core.presentation.components.ConsumerTextField
import com.example.consumer.core.presentation.components.CostumeScaffold
import com.example.consumer.core.presentation.components.SearchableCountryDropdown
import com.example.consumer.core.presentation.components.buttons.ButtonsTypes
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.features.completeProfile.domain.Gender
import com.example.consumer.features.completeProfile.viewModel.CompleteProfileViewModel
import consumer.composeapp.generated.resources.ID_Iqama_Number
import consumer.composeapp.generated.resources.LastName
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.female
import consumer.composeapp.generated.resources.firstName
import consumer.composeapp.generated.resources.gender
import consumer.composeapp.generated.resources.ic_drop_down
import consumer.composeapp.generated.resources.male
import consumer.composeapp.generated.resources.save_and_continue
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import kotlin.time.Clock


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
    var iqamaTouched by remember { mutableStateOf(false) }

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
    LaunchedEffect(iqamaState) {
        snapshotFlow { iqamaState.text.toString() }.collect { v ->
            if (iqamaTouched) viewModel.validateIqama(v)
        }
    }
    val dateOfBirthDisplayState = rememberTextFieldState()
    LaunchedEffect(uiState.dateOfBirthDisplay) {
        dateOfBirthDisplayState.edit {
            replace(0, length, uiState.dateOfBirthDisplay)
        }
    }
    val focusManager = LocalFocusManager.current

    ConsumerTheme {
        CostumeScaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            focusManager.clearFocus()
                            viewModel.closeCountryDropdown()
                        })
                    },
            ) {
                TransparentToolbar(
                    title = "أدخل معلوماتك الأساسية",
                    navController = navController

                )


                Column(
                    modifier = Modifier.padding(horizontal = 16.dp).weight(1f)
                        .verticalScroll(rememberScrollState()),
                ) {

                    Spacer(modifier = Modifier.height(28.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        ConsumerTextField(
                            label = { Text(stringResource(Res.string.firstName)) },
                            state = firstNameState,
                            supportingText = if (firstNameTouched && uiState.firstName.error != null) {
                                {
                                    Text(
                                        text = uiState.firstName.error!!,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            } else null,
                            isError = firstNameTouched &&
                                    uiState.firstName.error != null,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
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
                            supportingText = if (lastNameTouched && uiState.lastName.error != null) {
                                {
                                    Text(
                                        text = uiState.lastName.error!!,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            } else null,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        )


                    }
                    Spacer(modifier = Modifier.height(20.dp))

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
                        supportingText = if (iqamaTouched && uiState.iqamaNumber.error != null) {
                            {
                                Text(
                                    text = uiState.iqamaNumber.error!!,
                                    color = MaterialTheme.colorScheme.error,
                                )
                            }
                        } else null,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
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
                    ConsumerDateField(
                        displayState = dateOfBirthDisplayState,
                        label = "Date of Birth  •  تاريخ الميلاد",
                        dialogOpen = uiState.datePickerOpen,
                        onOpenDialog = viewModel::openDatePicker,
                        onDismiss = viewModel::closeDatePicker,
                        onDateSelected = viewModel::onDateSelected,
                        trailingIcon = {
                            Image(painter = painterResource(Res.drawable.ic_drop_down), "")
                        },
                        error = uiState.dateOfBirthError,
                        maxDateMillis = Clock.System.now().toEpochMilliseconds(),
                        modifier = Modifier.fillMaxWidth(),
                        confirmedDateMillis = uiState.dateOfBirthMillis,
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(stringResource(Res.string.gender))
                        GenderCard(
                            text = stringResource(Res.string.male),
                            selected = uiState.selectedGender == Gender.MALE,
                            onClick = { viewModel.selectGender(Gender.MALE) })
                        GenderCard(
                            text = stringResource(Res.string.female),
                            selected = uiState.selectedGender == Gender.FEMALE,
                            onClick = { viewModel.selectGender(Gender.FEMALE) })
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                ConsumerFilledButton(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    text = stringResource(Res.string.save_and_continue),
                    onClick = { },
                    enabled = uiState.isFormValid,

                    type = ButtonsTypes.PRIMARY,
                )
                Spacer(modifier = Modifier.height(16.dp))

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
