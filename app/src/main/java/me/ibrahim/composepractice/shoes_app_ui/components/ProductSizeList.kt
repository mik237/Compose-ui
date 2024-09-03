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
import androidx.compose.ui.unit.dp
import me.ibrahim.composepractice.shoes_app_ui.models.Product


@Composable
fun ProductSizeList(product: Product, onChange: (Int) -> Unit) {
    var selectedSize by remember { mutableStateOf(product.size) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
            .padding(horizontal = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductSizeCard(product = product, size = 7, selected = selectedSize == 7) { selectedSize = it }
        ProductSizeCard(product = product, size = 8, selected = selectedSize == 8) { selectedSize = it }
        ProductSizeCard(product = product, size = 9, selected = selectedSize == 9) { selectedSize = it }
        ProductSizeCard(product = product, size = 10, selected = selectedSize == 10) { selectedSize = it }
        ProductSizeCard(product = product, size = 11, selected = selectedSize == 11) { selectedSize = it }
    }
}