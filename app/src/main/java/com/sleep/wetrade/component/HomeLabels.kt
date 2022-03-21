package com.sleep.wetrade.component

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

val labels = listOf("Week", "ETFs", "Stocks", "Funds", "ETFs1", "Stocks1", "Funds1")

@Composable
fun Labels() {
    Row(
        Modifier
            .height(40.dp)
            .fillMaxWidth()
            .horizontalScroll(state = rememberScrollState())
    ) {
        val context = LocalContext.current
        labels.forEachIndexed { index, s ->
            if (index == 0) {
                Spacer(modifier = Modifier.size(16.dp))
            } else {
                Spacer(modifier = Modifier.size(8.dp))
            }
            label(label = s, onClick = {
                Toast.makeText(context, "Click $s", Toast.LENGTH_SHORT).show()
            }, rightIcon = if (index == 0) {
                {
                    Icon(
                        imageVector = Icons.Outlined.ExpandMore,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .size(15.dp)
                            .padding(start = 3.dp)
                    )
                }
            } else null)
            if (index == labels.size - 1) {
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun label(label: String, onClick: () -> Unit, rightIcon: (@Composable () -> Unit)? = null) {
    Row(
        Modifier
            .fillMaxHeight()
            .border(1.dp, color = Color.White, shape = CircleShape)
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = label, style = MaterialTheme.typography.body1, color = Color.White)
        rightIcon?.invoke()
    }
}