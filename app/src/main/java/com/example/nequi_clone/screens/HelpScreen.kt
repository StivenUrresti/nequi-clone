package com.example.nequi_clone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HelpScreen (modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .fillMaxSize()
        , color = Color.White) {
        Column(
            modifier
                .padding(16.dp)) {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Row {
                    Icon( 
                        Icons.Filled.ArrowBack,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = modifier.size(20.dp)
                    )
                    Text(
                        text = "Ayuda",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(text = "chat")
                    Icon(
                        Icons.Outlined.Forum,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = modifier.size(20.dp)
                    )
                }
            }

        }
    }
}


@Preview()
@Composable
fun HelpScreenPreview() {
    HelpScreen()
}