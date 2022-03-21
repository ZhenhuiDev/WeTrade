package com.sleep.wetrade.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sleep.wetrade.R
import com.sleep.wetrade.ui.theme.Gray900
import com.sleep.wetrade.ui.theme.Yellow

@Composable
fun Login(navController: NavController) {
    val backgroundColor = if (isSystemInDarkTheme()) Gray900 else Color.White
    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor),
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Welcome \nback",
                style = MaterialTheme.typography.h2,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        ) {
            val textColor = if (isSystemInDarkTheme()) Color.White else Gray900
            val email = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }

            Spacer(modifier = Modifier.size(40.dp))

            // email
            WeTradeStyleFieldInput(
                value = email.value,
                onValueChange = { email.value = it },
                textColor = textColor,
                backgroundColor = backgroundColor,
                placeholder = "Email address",
                leadingIcon = Icons.Outlined.Email,
            )

            Spacer(modifier = Modifier.size(8.dp))

            // password
            WeTradeStyleFieldInput(
                value = password.value,
                onValueChange = { password.value = it },
                textColor = textColor,
                backgroundColor = backgroundColor,
                placeholder = "Password",
                leadingIcon = Icons.Outlined.Password,
                visualTransformation = PasswordVisualTransformation('*'),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Yellow, contentColor = Gray900),
                onClick = { navController.navigate(Screen.Home.route) }) {
                Text(text = "LOG IN")
            }
        }
    }
}

@Composable
fun WeTradeStyleFieldInput(
    value: String,
    onValueChange: (String) -> Unit,
    textColor: Color,
    backgroundColor: Color,
    placeholder: String,
    leadingIcon: ImageVector,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    Box(
        Modifier
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(backgroundColor)
            .border(1.dp, textColor, RoundedCornerShape(4.dp))
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            placeholder = { Text(text = placeholder, style = MaterialTheme.typography.body1) },
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "",
                    Modifier
                        .size(23.dp)
                        .offset(5.dp),
                    tint = textColor,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = textColor,
                backgroundColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledLabelColor = Color.Blue,
                cursorColor = textColor,
            ),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            textStyle = MaterialTheme.typography.body1
        )
    }
}