package com.example.consumer.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.Image
import com.example.consumer.features.completeProfile.data.CountryData
import com.example.consumer.features.completeProfile.viewModel.CountryListState
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource
import kotlin.collections.emptyList

// ─────────────────────────────────────────────────────────────────────────────
//  Public entry-point
// ─────────────────────────────────────────────────────────────────────────────

/**
 * A searchable country dropdown that shares the exact look-and-feel of
 * [ConsumerTextField].  The search query is held in a [TextFieldState] so the
 * caller owns it (important for focus / re-composition stability).
 *
 * @param searchState   Caller-owned [TextFieldState] – text inside is the
 *                      live search query while the dropdown is expanded.
 * @param selectedCountry   Currently selected item (null = nothing chosen).
 * @param countriesState    Async state of the countries list.
 * @param expanded          Whether the dropdown list is visible.
 * @param onToggleExpanded  Toggle callback (open ↔ close).
 * @param onCountrySelected Called with the chosen [CountryData].
 * @param onRetry           Called when the user taps retry after an error.
 */
@Composable
fun SearchableCountryDropdown(
    searchState: TextFieldState,
    selectedCountry: CountryData?,
    countriesState: CountryListState,
    expanded: Boolean,
    onToggleExpanded: () -> Unit,
    onCountrySelected: (CountryData) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Country",
    error: String? = null,
    enabled: Boolean = true,
) {
    // Derive the filtered list from the live search text
    val searchQuery = searchState.text.toString()

    val filteredCountries = remember(searchQuery, countriesState) {
        val all = (countriesState as? CountryListState.Success)?.countries ?: return@remember emptyList()
        if (searchQuery.isBlank()) all
        else all.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    // Decide what the text field actually displays
    val displayValue: TextFieldState = if (expanded) {
        searchState   // user is typing a search query
    } else {
        // Show selected country name (read-only); we create a synthetic state
        // so ConsumerTextField still receives a TextFieldState
        rememberTextFieldState(selectedCountry?.let { "${it.flag}  ${it.name}" } ?: "")
    }

    Column(modifier = modifier) {
        // ── text field row ────────────────────────────────────────────────────
        CountryInputField(
            state = displayValue,
            placeholder = placeholder,
            expanded = expanded,
            enabled = enabled,
            isError = error != null,
            supportingText = error?.let { msg -> { Text(text = msg, color = MaterialTheme.colorScheme.error) } },
            onToggleExpanded = onToggleExpanded,
        )

        // ── dropdown list / loading / error ───────────────────────────────────
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
        ) {
            DropdownContent(
                countriesState   = countriesState,
                filteredCountries = filteredCountries,
                searchQuery      = searchQuery,
                selectedCountry  = selectedCountry,
                onCountrySelected = { country ->
                    onCountrySelected(country)
                },
                onRetry = onRetry,
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
//  Input field (ConsumerTextField + overlay + arrow icon)
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun CountryInputField(
    state: TextFieldState,
    placeholder: String,
    expanded: Boolean,
    enabled: Boolean,
    isError: Boolean,
    supportingText: @Composable (() -> Unit)?,
    onToggleExpanded: () -> Unit,
) {
    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "arrow_rotation",
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        ConsumerTextField(
            state = state,
            enabled = enabled,   // Keep enabled to use "unfocused" colors when closed
            isError = isError,
            supportingText = supportingText,
            placeholder = if (!expanded && state.text.isEmpty()) {
                { Text(placeholder) }
            } else null,
            label = { Text(placeholder) },
            trailingIcon = {
                IconButton(
                    onClick = onToggleExpanded,
                    enabled = enabled,
                ) {
                    Image(painter = painterResource( Res.drawable.ic_back),"", )

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusProperties { canFocus = expanded }, // Prevent focus when closed
        )

        // Invisible overlay so tapping the collapsed field opens the dropdown
        // without stealing the cursor into the text field prematurely.
        if (!expanded && enabled) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onToggleExpanded,
                    )
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
//  Dropdown card (handles all three async states)
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun DropdownContent(
    countriesState: CountryListState,
    filteredCountries: List<CountryData>,
    searchQuery: String,
    selectedCountry: CountryData?,
    onCountrySelected: (CountryData) -> Unit,
    onRetry: () -> Unit,
) {
    val density = LocalDensity.current
    val imeBottom = with(density) {
        WindowInsets(0, 0, 0, 0) // replace with WindowInsets.ime if needed
            .getBottom(density).toDp()
    }
    val maxHeight = if (imeBottom > 0.dp) 200.dp else 300.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = maxHeight)
            .padding(top = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        when (countriesState) {
            is CountryListState.Loading -> DropdownLoadingState()
            is CountryListState.Error   -> DropdownErrorState(
                message = countriesState.message,
                onRetry = onRetry,
            )
            is CountryListState.Idle,
            is CountryListState.Success -> {
                if (filteredCountries.isEmpty()) {
                    DropdownEmptyState(searchQuery = searchQuery)
                } else {
                    DropdownCountryList(
                        countries       = filteredCountries,
                        searchQuery     = searchQuery,
                        selectedCountry = selectedCountry,
                        onCountrySelected = onCountrySelected,
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
//  Inner states
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun DropdownLoadingState() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp)
            Text(
                text = "Loading countries…",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun DropdownErrorState(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
        )
        Text(
            text = "Tap to retry",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { onRetry() },
        )
    }
}

@Composable
private fun DropdownEmptyState(searchQuery: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "No countries found",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            if (searchQuery.isNotBlank()) {
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "\"$searchQuery\"",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@Composable
private fun DropdownCountryList(
    countries: List<CountryData>,
    searchQuery: String,
    selectedCountry: CountryData?,
    onCountrySelected: (CountryData) -> Unit,
) {
    val listState = rememberLazyListState()
    val selectedIndex = countries.indexOfFirst { it.id == selectedCountry?.id }

    LaunchedEffect(Unit) {
        if (selectedIndex >= 0) listState.scrollToItem(selectedIndex)
    }

    Column {
        // ── result count header (only while searching) ────────────────────────
        if (searchQuery.isNotBlank()) {
            Text(
                text = "${countries.size} result${if (countries.size != 1) "s" else ""}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            )
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
            )
        }

        LazyColumn(state = listState, modifier = Modifier.fillMaxWidth()) {
            items(countries, key = { it.id }) { country ->
                val isSelected = country.id == selectedCountry?.id

                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Text(
                                text = country.flag,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Text(
                                text = country.name,
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (isSelected) MaterialTheme.colorScheme.primary
                                        else MaterialTheme.colorScheme.onSurface,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        }
                    },
                    modifier = Modifier.background(
                        if (isSelected)
                            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                        else Color.Transparent
                    ),
                    trailingIcon = {
                        if (isSelected) {
                            Image(painter = painterResource( Res.drawable.ic_back),"", )
//                            Icon(
//                                imageVector = Icons.Default.Check,
//                                contentDescription = "Selected",
//                                tint = MaterialTheme.colorScheme.primary,
//                            )
                        }
                    },
                    onClick = { onCountrySelected(country) },
                )

                if (country != countries.last()) {
                    HorizontalDivider(
                        thickness = DividerDefaults.Thickness,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    )
                }
            }
        }
    }
}
