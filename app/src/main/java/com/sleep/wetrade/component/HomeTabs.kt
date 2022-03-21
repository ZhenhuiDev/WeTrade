package com.sleep.wetrade.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

val tabs = listOf("ACCOUNT", "WATCHLIST", "PROFILE")

@Composable
fun Tabs(onItemClick: ((index: Int, tab: String) -> Unit)? = null) {
    var chosenIndex by remember { mutableStateOf(0) }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            Text(
                text = tab,
                Modifier
                    .weight(1f)
                    .alpha(if (chosenIndex == index) 1f else 0.6f)
                    .clickable {
                        chosenIndex = index
                        onItemClick?.invoke(index, tab)
                    }
                    .padding(vertical = 12.dp),
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
            )
        }
    }
}