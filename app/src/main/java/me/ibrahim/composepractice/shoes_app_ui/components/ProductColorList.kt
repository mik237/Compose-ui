package me.ibrahim.composepractice.shoes_app_ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.ibrahim.composepractice.shoes_app_ui.models.Product

@Composable
fun ProductColorList(product: Product, selectedColor: Color, onClick: (Color) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
            .padding(horizontal = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductColorCircle(
            color = Color.Red,
            selected = selectedColor == Color.Red,
            onClick = onClick
        )

        ProductColorCircle(
            color = Color.Yellow,
            selected = selectedColor == Color.Yellow,
            onClick = onClick
        )

        ProductColorCircle(
            color = Color.Green,
            selected = selectedColor == Color.Green, onClick = onClick
        )

        ProductColorCircle(
            color = Color.Blue,
            selected = selectedColor == Color.Blue, onClick = onClick
        )

        ProductColorCircle(
            color = Color.Magenta,
            selected = selectedColor == Color.Magenta, onClick = onClick
        )
    }
}