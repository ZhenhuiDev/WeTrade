package com.sleep.wetrade.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding
import com.sleep.wetrade.R
import com.sleep.wetrade.component.Labels
import com.sleep.wetrade.component.Tabs
import com.sleep.wetrade.ui.theme.Gray700
import com.sleep.wetrade.ui.theme.Gray900
import com.sleep.wetrade.ui.theme.Green
import com.sleep.wetrade.ui.theme.Yellow

@Composable
fun Home(navController: NavController) {
    Column(
        Modifier
            .systemBarsPadding()
            .fillMaxWidth()
    ) {
        Tabs()
        Text(text = "Balance", Modifier.align(Alignment.CenterHorizontally), style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "$73.589.01",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "+412.35 today",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.subtitle1,
            color = Green
        )
        Spacer(modifier = Modifier.size(32.dp))
        val context = LocalContext.current
        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Yellow, contentColor = Gray900),
            onClick = { Toast.makeText(context, "Click Transact", Toast.LENGTH_SHORT).show() }) {
            Text(text = "TRANSACT")
        }
        Spacer(modifier = Modifier.size(16.dp))
        Labels()
        Image(
            painter = painterResource(id = R.drawable.home_illos),
            contentDescription = "",
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .weight(1f)
            ,
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (isSystemInDarkTheme()) Gray700 else Color.White,
                contentColor = if (isSystemInDarkTheme()) Color.White else Gray900
            ),
            shape = RoundedCornerShape(0.dp),
            onClick = { navController.navigate(Screen.Positions.route) }) {
            Text(
                text = "Positions",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

