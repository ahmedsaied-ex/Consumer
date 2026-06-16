package com.example.consumer.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumer.core.presentation.components.buttons.ButtonsTypes
import com.example.consumer.core.presentation.components.buttons.ConsumerFilledButton
import com.example.consumer.core.presentation.foundation.colors.SelectedLanguageItemBackground
import com.example.consumer.core.presentation.foundation.typography.H4
import com.example.consumer.core.presentation.foundation.typography.Subtitle2
import com.example.consumer.core.presentation.theme.ConsumerTheme
import com.example.consumer.core.presentation.theme.extendedColors
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.illu_success
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun SuccessStates(
    modifier: Modifier = Modifier,
    title: String = "تمت حجز الاستشارة بنجاح",
    description: String? = "يُرجى الانتظار حتى يتم تعيين المستشار المتخصص شكراً لصبرك!",
    image: DrawableResource = Res.drawable.illu_success,
    buttonText: String? = "عرض تفاصيل الطلب", onClick: () -> Unit = {}
) {
    ConsumerTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.height(190.dp).width(134.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                title,
                style = H4.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center, color = SelectedLanguageItemBackground
            )
            description?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    description,
                    style = Subtitle2.copy(fontWeight = FontWeight.Normal),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.extendedColors.darkBlue650
                )
            }
            buttonText?.let {
                Spacer(modifier = Modifier.height(20.dp))
                ConsumerFilledButton(
                    text = buttonText,
                    onClick = onClick,
                    type = ButtonsTypes.SECONDARY
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, locale = "ar")
fun SuccessStatesPreview() {
    ConsumerTheme {
        SuccessStates()
    }

}