package com.example.consumer.core.presentation.components.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.auctionex.expertapps.navigation.utils.guardedClick
import com.auctionex.expertapps.navigation.utils.rememberClickGuard
import com.example.consumer.core.presentation.components.Buttons.LocalizedIconButton
import consumer.composeapp.generated.resources.Res
import consumer.composeapp.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun TransparentToolbar(
    trailingIcon: @Composable (() -> Unit)? = null,
    prefixIcon: @Composable (() -> Unit)? = null,
    title: String? = null,
    navController: NavHostController,
    onBackPressed: (() -> Unit) = { navController.popBackStack() },
    modifier: Modifier = Modifier,
    centerContent: @Composable (() -> Unit)? = null,
) {
    val clickGuard = rememberClickGuard()

    Box(
        modifier = modifier.fillMaxWidth().height(60.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (prefixIcon != null) {
                prefixIcon()
            } else {
                LocalizedIconButton(
                    painter = painterResource(Res.drawable.ic_back),
                    contentDescription = "Back",
                    onClick = clickGuard.guardedClick { onBackPressed() },
                    modifier = Modifier.size(36.dp)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            ) {
                when {
                    centerContent != null -> centerContent()
                    title != null -> {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
                            color = MaterialTheme.colorScheme.onBackground,
                            maxLines = 1
                        )
                    }
                }
            }

            if (trailingIcon != null) {
                trailingIcon()
            } else {
                Spacer(modifier = Modifier.size(36.dp))
            }
        }
    }
}
