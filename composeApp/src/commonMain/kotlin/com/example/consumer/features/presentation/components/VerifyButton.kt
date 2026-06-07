package com.example.consumer.features.presentation.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.Buttons.ConsumerFilledButton


@Composable
fun VerifyButton(
    otp: String,
//    text: StringResource,
    text: String,
    onVerifyClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean
) {

    ConsumerFilledButton(
//        text = stringResource(text),
        text = text,
        onClick = onVerifyClick,
        enabled = enabled,
        modifier = modifier.padding(horizontal = 16.dp),
    )

}
@Preview(showBackground = true)
@Composable
fun PreviewVerifyButton(

) {
    VerifyButton(
        otp = "",
        text = "تاكيد",
        onVerifyClick = { },
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )


}
