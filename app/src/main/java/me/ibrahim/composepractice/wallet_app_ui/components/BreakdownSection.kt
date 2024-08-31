package me.ibrahim.composepractice.wallet_app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsRun
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.composepractice.R
import kotlin.random.Random

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "Spending Breakdown",
        fontFamily = Font(R.font.play).toFontFamily(),
        fontSize = 25.sp,
        color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(modifier = Modifier.height(16.dp))
    SpendingList(modifier = modifier)
}

@Composable
private fun SpendingList(modifier: Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(spendingList) { spending ->
            SpendingItem(spending)
            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .background(color = Color.Red)
            )
        }
    }
}

@Composable
fun SpendingItem(spending: Spending, modifier: Modifier = Modifier) {

    ElevatedCard(
        modifier = modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spending.color.copy(alpha = 0.5f))
                .padding(20.dp)
        ) {
            Icon(
                imageVector = spending.icon,
                contentDescription = spending.name,
                tint = Color.Black.copy(0.8f),
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = spending.name,
                fontSize = 15.sp,
                color = Color.Black.copy(0.7f)
            )
            Text(
                text = spending.amount,
                fontSize = 20.sp,
                fontFamily = Font(R.font.play).toFontFamily(),
                color = Color.Black
            )
        }
    }
}

private val spendingList = listOf(
    Spending(
        name = "Food",
        icon = Icons.Rounded.Restaurant,
        amount = "$123.0",
        color = randomColor()
    ),
    Spending(
        name = "Shopping",
        icon = Icons.Rounded.ShoppingBag,
        amount = "$123.0",
        color = randomColor()
    ),
    Spending(
        name = "Subscriptions",
        icon = Icons.Rounded.Subscriptions,
        amount = "$123.0",
        color = randomColor()
    ),
    Spending(
        name = "Health",
        icon = Icons.AutoMirrored.Rounded.DirectionsRun,
        amount = "$123.0",
        color = randomColor()
    )
)

data class Spending(
    val name: String,
    val icon: ImageVector,
    val amount: String,
    val color: Color
)

fun randomColor(minBrightness: Int = 50): Color {
    val random = Random.Default
    val red = random.nextInt(minBrightness, 256)
    val green = random.nextInt(minBrightness, 256)
    val blue = random.nextInt(minBrightness, 256)
    return Color(red, green, blue)
}


@Preview(showBackground = true)
@Composable
private fun BreakdownSectionPreview() {
    SpendingSection(modifier = Modifier.fillMaxWidth())
}