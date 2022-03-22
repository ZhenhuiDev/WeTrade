package com.sleep.wetrade.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sleep.wetrade.R
import com.sleep.wetrade.ui.theme.Gray900
import com.sleep.wetrade.ui.theme.Green
import com.sleep.wetrade.ui.theme.Red
import java.text.NumberFormat

data class PositionItemData(
    val value: Float,
    val change: Float,
    val shortName: String,
    val fullName: String,
    @DrawableRes val imageRes: Int
) {
    companion object {
        val format: NumberFormat = NumberFormat.getNumberInstance().apply { maximumFractionDigits = 2 }
    }

    fun formatValue(): String {
        return "$${format.format(value)}"
    }

    fun formatChange(): String {
        return "${if (change >= 0) "+" else ""}${format.format(change)}%"
    }
}

val positionItemDataList = listOf(
    PositionItemData(7918f, -0.54f, "ALK", "Alaska Air Group, Inc.", R.drawable.home_alk),
    PositionItemData(1293f, 4.18f, "BA", "Boeing Co.", R.drawable.home_ba),
    PositionItemData(893.50f, -0.54f, "DAL", "Delta Airlines Inc.", R.drawable.home_dal),
    PositionItemData(12301f, 2.51f, "EXPE", "Expedia Group Inc.", R.drawable.home_exp),
    PositionItemData(12301f, 1.38f, "EADSY", "Airbus SE", R.drawable.home_eadsy),
    PositionItemData(8521f, 1.56f, "JBLU", "Jetblue Airways Corp.", R.drawable.home_jblu),
    PositionItemData(521f, 2.75f, "MAR", "Marriott International Inc.", R.drawable.home_mar),
    PositionItemData(5481f, 0.14f, "CCL", "Carnival Corp.", R.drawable.home_ccl),
    PositionItemData(9184f, 1.69f, "RCL", "Royal Caribbean Cruises", R.drawable.home_rcl),
    PositionItemData(654f, 3.23f, "TRVL", "Travelocity Inc.", R.drawable.home_trvl),
)

@Composable
fun PositionList(modifier: Modifier) {
    Column(modifier = modifier.verticalScroll(state = rememberScrollState())) {
        positionItemDataList.forEach {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = if (isSystemInDarkTheme()) Color.White else Gray900,
            )
            PositionItem(positionItemData = it)
        }
    }
}

@Composable
fun PositionItem(positionItemData: PositionItemData) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.width(64.dp)) {
            Text(
                text = positionItemData.formatValue(),
                style = MaterialTheme.typography.body1,
                color = if (isSystemInDarkTheme()) Color.White else Gray900
            )
            Text(
                text = positionItemData.formatChange(),
                style = MaterialTheme.typography.body1,
                color = if (positionItemData.change >= 0) Green else Red
            )
        }

        Column(Modifier.weight(1f)) {
            Text(
                text = positionItemData.shortName,
                style = MaterialTheme.typography.h3,
                color = if (isSystemInDarkTheme()) Color.White else Gray900
            )
            Text(
                text = positionItemData.fullName,
                style = MaterialTheme.typography.body1,
                color = if (isSystemInDarkTheme()) Color.White else Gray900
            )
        }

        Image(painter = painterResource(id = positionItemData.imageRes), contentDescription = "")
    }
}