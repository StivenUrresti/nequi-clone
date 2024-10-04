package com.example.nequi_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nequi_clone.screens.MainApp
import com.example.nequi_clone.ui.theme.Nequi_cloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nequi_cloneTheme {
                MainApp()
            }
        }
    }
}