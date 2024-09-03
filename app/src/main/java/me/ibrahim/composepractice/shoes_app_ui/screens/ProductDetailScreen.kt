package me.ibrahim.composepractice.shoes_app_ui.screens

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import me.ibrahim.composepractice.R
import me.ibrahim.composepractice.shoes_app_ui.components.ProductColorList
import me.ibrahim.composepractice.shoes_app_ui.components.ProductSizeList
import me.ibrahim.composepractice.shoes_app_ui.models.Product
import me.ibrahim.composepractice.shoes_app_ui.viewmodel.ProductsViewModel


@Composable
fun ProductDetailScreen(
    productId: String,
) {
    val productsViewModel: ProductsViewModel = viewModel()

    val product: Product = productsViewModel.getProduct(productId.toInt())

    var selectedColor by remember { mutableStateOf(product.color) }

    var xOffset by remember { mutableStateOf(800.dp) }
    var yOffset by remember { mutableStateOf(800.dp) }

    var shoeRotateAngle by remember { mutableFloatStateOf(-60f) }
    var shoeScale by remember { mutableFloatStateOf(0.4f) }

    val animationXOffset = animateDpAsState(targetValue = xOffset, label = "", animationSpec = tween(
        durationMillis = 600, easing = FastOutLinearInEasing
    ), finishedListener = {
        Log.d("ProductDetail_", "animationXOffset: $it")
    })

    val animationYOffset = animateDpAsState(targetValue = yOffset, label = "", animationSpec = tween(
        durationMillis = 600, easing = FastOutLinearInEasing
    ), finishedListener = {
        Log.d("ProductDetail_", "animationYOffset: $it")
    })

    val animationShoeAngle = animateFloatAsState(targetValue = shoeRotateAngle, label = "", finishedListener = {
        Log.d("ProductDetail_", "animationShoeAngle: $it")
    })

    val animationShoeScale = animateFloatAsState(targetValue = shoeScale, label = "")

    LaunchedEffect(key1 = true) {
        delay(150)
        xOffset = 100.dp
        yOffset = (-70).dp
        shoeRotateAngle = 0f
        shoeScale = 1f
    }

    Scaffold(
    ) {

        Box(
            modifier = Modifier
                .padding(it)
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .offset(
                        x = animationXOffset.value, y = animationYOffset.value
                    )
                    .align(Alignment.TopEnd)
                    .alpha(0.3f)
                    .size(400.dp)
                    .background(
                        color = selectedColor, shape = CircleShape
                    )
            )

            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(8.dp)
                    .shadow(
                        elevation = 24.dp, shape = CircleShape, spotColor = DefaultShadowColor
                    )
                    .background(color = Color.White, shape = CircleShape)
                    .size(46.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft, contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .matchParentSize()
                    .padding(bottom = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 60.dp)
                        .scale(animationShoeScale.value)
                        .rotate(animationShoeAngle.value)
                        .fillMaxWidth()
                        .wrapContentHeight()
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp)
                ) {
                    Column {
                        Text(
                            text = "Sneaker", style = MaterialTheme.typography.labelSmall.copy(color = Color.Black)
                        )
                        Text(
                            text = product.name, style = MaterialTheme.typography.titleLarge.copy(color = Color.Black)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Rounded.Star, contentDescription = null, tint = Color(0xFFFFDA45), modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "${product.rating}", style = MaterialTheme.typography.labelLarge.copy(color = Color.Black)
                            )
                        }
                    }
                    Text(
                        text = "Rs. ${product.discountedPrice}", fontSize = 30.sp, color = Color.Black, style = MaterialTheme.typography.bodyLarge
                    )
                }

                Text(
                    text = "Size", style = MaterialTheme.typography.labelLarge.copy(color = Color.Black),
                    modifier = Modifier
                        .padding(horizontal = 22.dp)
                        .padding(top = 12.dp)
                )

                ProductSizeList(product) {}

                Text(
                    text = "Colors", style = MaterialTheme.typography.labelLarge.copy(color = Color.Black),
                    modifier = Modifier
                        .padding(horizontal = 22.dp)
                        .padding(top = 16.dp)
                )

                ProductColorList(product, selectedColor) { color ->
                    selectedColor = color
                }

                Text(
                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
                            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
//                            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
//                            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
                            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                    modifier = Modifier
                        .padding(horizontal = 22.dp)
                        .padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                BottomBar()
            }


        }
    }

}

@Composable
fun BottomBar() {
    var isFavorite by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(
                horizontal = 22.dp,
                vertical = 0.dp
            )
    ) {
        IconButton(onClick = { isFavorite = isFavorite.not() }) {
            Icon(
                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = null,
                tint = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = null
            )
            Text(text = "Add to Cart")
        }
    }
}





