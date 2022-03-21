package com.sleep.wetrade.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sleep.wetrade.R
import com.sleep.wetrade.ui.theme.Gray900
import com.sleep.wetrade.ui.theme.Yellow

@Composable
fun Welcome(navController: NavController) {
    Box(Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
        )
        Text(modifier = Modifier.align(Alignment.Center), text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Thin,
                    fontSize = 40.sp
                )
            ) {
                append("We")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Medium, fontSize = 40.sp)) {
                append("Trade")
            }
        })
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Yellow, contentColor = Gray900),
                onClick = { navController.navigate(Screen.Login.route) }) {
                Text(text = "GET STARTED")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .border(1.dp, Yellow, shape = CircleShape),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent, contentColor = Yellow),
                onClick = { navController.navigate(Screen.Login.route) }) {
                Text(text = "LOG IN")
            }
        }
    }
}