package me.ibrahim.composepractice.shoes_app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.composepractice.shoes_app_ui.models.Product

@Composable
fun ProductSizeCard(
    product: Product,
    size: Int,
    selected: Boolean,
    onClick: (Int) -> Unit,
) {

    val bgColor = if (selected) product.color.copy(0.5f) else Color.White
    val borderColor = if (selected) Color.Gray else Color.LightGray
    Text(
        text = "${product.size}",
        modifier = Modifier
            .border(1.dp, color = borderColor, shape = RoundedCornerShape(12.dp))
            .background(color = bgColor, shape = RoundedCornerShape(12.dp))
            .padding(15.dp)
            .clickable { onClick(size) },
        fontSize = 12.sp
    )

}