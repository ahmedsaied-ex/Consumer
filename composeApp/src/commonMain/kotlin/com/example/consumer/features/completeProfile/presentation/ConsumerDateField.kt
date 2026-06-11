package com.example.consumer.features.completeProfile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.example.consumer.core.presentation.components.ConsumerTextField
import kotlin.time.Clock

/**
 * A read-only [com.example.consumer.core.presentation.components.ConsumerTextField] that opens a [DatePickerDialog] on tap —
 * same overlay pattern used by [com.example.consumer.core.presentation.components.SearchableCountryDropdown].
 *
 * @param displayState   A [TextFieldState] whose text is the formatted date
 *                       shown inside the field.  The caller formats the date
 *                       (e.g. "12 / 03 / 1995") and writes it here.
 * @param label          Field label, e.g. "Date of Birth".
 * @param dialogOpen     Whether the calendar dialog is currently visible.
 * @param onOpenDialog   Called when the user taps the field.
 * @param onDismiss      Called when the user cancels the dialog.
 * @param onDateSelected Called with the selected date in epoch-millis when
 *                       the user taps "OK".
 * @param maxDateMillis  Latest selectable date (default: today).
 * @param minDateMillis  Earliest selectable date (default: 1 Jan 1900).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsumerDateField(
    displayState: TextFieldState,
    label: String,
    dialogOpen: Boolean,
    onOpenDialog: () -> Unit,
    onDismiss: () -> Unit,
    onDateSelected: (epochMillis: Long) -> Unit,
    modifier: Modifier = Modifier,
    error: String? = null,
    enabled: Boolean = true,
    maxDateMillis: Long = Clock.System.now().toEpochMilliseconds(),
    minDateMillis: Long = -2_208_988_800_000L,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis in minDateMillis..maxDateMillis
            }
        }
    )

    // ── field + invisible overlay (identical to CountryInputField) ────────────
    Box(modifier = modifier) {
        ConsumerTextField(
            state = displayState,
            trailingIcon= trailingIcon,
            enabled = false,          // always read-only; user picks via dialog
            isError = error != null,
            label = { Text(label) },
            supportingText = error?.let { msg ->
                { Text(text = msg, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier
                .fillMaxWidth()
                .alpha(if (enabled) 1f else 0.5f),
        )

        // Overlay captures taps and opens the dialog
        if (enabled) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onOpenDialog,
                    )
            )
        }
    }

    // ── calendar dialog ───────────────────────────────────────────────────────
    if (dialogOpen) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { onDateSelected(it) }
                        onDismiss()
                    },
                    enabled = datePickerState.selectedDateMillis != null,
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            },
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
