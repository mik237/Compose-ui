package me.ibrahim.composepractice.shoes_app_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.composepractice.R
import me.ibrahim.composepractice.shoes_app_ui.models.Product

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {

    var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(160.dp, 250.dp)

    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .alpha(0.2f)
                .background(
                    color = product.color,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable { onClick.invoke() }
                .fillMaxSize()
        )


        IconButton(
            onClick = { isFavorite = isFavorite.not() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = null
            )
        }

        Image(
            painter = painterResource(id = product.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .rotate(-30f)
                .offset(20.dp, (-20).dp),
            alignment = Alignment.CenterEnd
        )

        Text(
            text = "${product.size}",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            fontSize = 120.sp,
            color = product.color.copy(alpha = 0.3f),
            modifier = Modifier
                .align(Alignment.Center)
        )

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
        ) {
            Text(
                text = "Rs ${product.discountedPrice}",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = "Rs ${product.price}",
                style = MaterialTheme.typography.labelSmall,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}


@Preview
@Composable
fun ProductItemPreview(modifier: Modifier = Modifier) {
    ProductItem(
        Product(
            id = 1,
            name = "Shoes Yello",
            color = Color.Magenta,
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s3,
            size = 5
        )
    ) {}
}