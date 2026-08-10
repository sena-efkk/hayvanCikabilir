package com.sena.hayvancikabilir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sena.hayvancikabilir.ui.shell.AppShell
import com.sena.hayvancikabilir.ui.theme.HayvanCikabilirTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            HayvanCikabilirTheme {
                AppShell()
            }
        }
    }
}