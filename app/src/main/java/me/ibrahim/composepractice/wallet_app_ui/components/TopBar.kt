package me.ibrahim.composepractice.wallet_app_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.composepractice.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(modifier: Modifier, scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .align(Alignment.CenterStart)
                )

                Text(
                    text = "Wallet",
                    fontFamily = Font(R.font.play).toFontFamily(),
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .align(Alignment.CenterStart)
                )

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .size(50.dp)
                        .align(Alignment.CenterEnd),
                    contentScale = ContentScale.Crop
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}


