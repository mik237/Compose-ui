package me.ibrahim.composepractice.wallet_app_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

@Composable
fun ActionsSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 22.dp)
    ) {
        ActionItem(
            color = Color.Red.copy(alpha = 0.35f),
            icon = Icons.Rounded.ArrowUpward,
            text = "Send"
        )
        ActionItem(
            color = Color.Green.copy(alpha = 0.35f),
            icon = Icons.Rounded.ArrowDownward,
            text = "Receive"
        )
        ActionItem(
            color = Color.Gray.copy(alpha = 0.35f),
            icon = Icons.Outlined.GridView,
            text = "More"
        )
    }
}


@Composable
fun ActionItem(
    modifier: Modifier = Modifier,
    color: Color,
    icon: ImageVector,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = text)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = text,
            fontFamily = Font(R.font.play).toFontFamily(),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}


@Preview
@Composable
private fun ActionsSectionPreview() {
    ActionsSection()
}