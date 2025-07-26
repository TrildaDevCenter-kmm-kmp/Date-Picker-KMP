package org.waqas028.data_store_kmp

import LocalPlatformContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    CompositionLocalProvider(LocalPlatformContext provides null) {
        App()
    }
}