package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.composepractice.R

@Composable
fun NamedProfile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .wrapContentSize()
                .clip(CircleShape),
            contentScale = ContentScale.Inside,
            painter = painterResource(id = R.drawable.user_1),
            contentDescription = "ProfileImage"
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "Hi, Alex",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}