package com.auctionex.expertapps.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.example.consumer.core.utils.currentTimeMillis


private const val DEBOUNCE_MS = 300L

object NavGuard {
    private val lastActionTimePerRoute = mutableMapOf<String, Long>()
    private var globalLastActionTime = 0L
    private var debounceMs = DEBOUNCE_MS

    fun configure(debounceMs: Long = DEBOUNCE_MS) {
        this.debounceMs = debounceMs
    }

    /**
     * Per-route guard: different routes can navigate independently.
     * Only blocks if the SAME route is tapped repeatedly within debounceMs.
     */
    fun canNavigate(routeKey: String): Boolean {
        val now = currentTimeMillis()
        val last = lastActionTimePerRoute[routeKey] ?: 0L
        return if (now - last >= debounceMs) {
            lastActionTimePerRoute[routeKey] = now
            true
        } else false
    }

    /**
     * Global guard (for back/pop actions with no specific route).
     */
    fun canNavigate(): Boolean {
        val now = currentTimeMillis()
        return if (now - globalLastActionTime >= debounceMs) {
            globalLastActionTime = now
            true
        } else false
    }

    fun navigate(routeKey: String, action: () -> Unit) {
        if (canNavigate(routeKey)) action()
    }

    fun navigate(action: () -> Unit) {
        if (canNavigate()) action()
    }

    fun reset() {
        lastActionTimePerRoute.clear()
        globalLastActionTime = 0L
    }
}

// ─── ClickGuard (unchanged) ────────────────────────────────────────────────

class ClickGuard(private val debounceMs: Long = DEBOUNCE_MS) {
    private var lastClickTime = 0L

    fun canClick(): Boolean {
        val now = currentTimeMillis()
        return if (now - lastClickTime >= debounceMs) {
            lastClickTime = now
            true
        } else false
    }
}

@Composable
fun rememberClickGuard(debounceMs: Long = DEBOUNCE_MS): ClickGuard {
    return remember { ClickGuard(debounceMs) }
}

fun ClickGuard.guardedClick(action: () -> Unit): () -> Unit = {
    if (canClick()) action()
}

// ─── NavController extensions ──────────────────────────────────────────────

/**
 * Resolves a stable string key from any route object.
 */
private fun Any.routeKey(): String =
    this::class.qualifiedName ?: this::class.simpleName ?: this.toString()

fun NavController.navigateSafe(
    route: Any,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    NavGuard.navigate(route.routeKey()) {
        try {
            navigate(route, builder)
        } catch (e: Exception) {
            // swallow duplicate navigation exceptions
        }
    }
}

fun NavHostController.navigateTo(route: Any) {
    NavGuard.navigate(route.routeKey()) {
        navigate(route)
    }
}

fun NavHostController.navigateBack() {
    // back has no route, use global guard
    NavGuard.navigate { popBackStack() }
}

fun NavHostController.navigateSafe(
    route: Any,
    builder: NavOptionsBuilder.() -> Unit = {},
) {
    NavGuard.navigate(route.routeKey()) {
        try {
            navigate(route) {
                launchSingleTop = true
                builder()
            }
        } catch (e: Exception) {
            // swallow duplicate navigation exceptions
        }
    }
}

fun NavHostController.navigateToRoot(route: Any) {
    NavGuard.navigate(route.routeKey()) {
        navigate(route) {
            popUpTo(route) { inclusive = true }
        }
    }
}

fun NavHostController.navigateWithoutBack(to: Any, popUpTo: Any) {
    NavGuard.navigate(to.routeKey()) {
        navigate(to) {
            popUpTo(popUpTo) { inclusive = true }
        }
    }
}

fun NavHostController.navigateAndClearStack(to: Any, popUpTo: Any) {
    NavGuard.navigate(to.routeKey()) {
        navigate(to) {
            popUpTo(popUpTo) {
                inclusive = true
                saveState = false
            }
            launchSingleTop = true
            restoreState = false
        }
    }
}
