package me.ibrahim.composepractice.shoes_app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ProductColorCircle(
    color: Color = Color.Blue,
    selected: Boolean = true,
    onClick: (Color) -> Unit
) {

    val borderColor = if (selected) color else Color.Transparent

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .border(width = 1.dp, color = borderColor, shape = CircleShape)
            .clickable { onClick.invoke(color) },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .size(45.dp)
                .clip(CircleShape)
                .background(color)
        )
    }
}