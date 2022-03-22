package com.sleep.wetrade.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sleep.wetrade.component.PositionList
import com.sleep.wetrade.ui.theme.Gray900

@Composable
fun Positions(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val isSystemInDark = isSystemInDarkTheme()
    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !isSystemInDark)
    }
    Column(
        Modifier
            .background(if (isSystemInDarkTheme()) Gray900 else Color.White)
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Positions",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            style = MaterialTheme.typography.subtitle1,
            color = if (isSystemInDarkTheme()) Color.White else Gray900
        )

        PositionList(
            modifier = Modifier
                .weight(1f)
                .padding(top = 24.dp)
        )
    }
}