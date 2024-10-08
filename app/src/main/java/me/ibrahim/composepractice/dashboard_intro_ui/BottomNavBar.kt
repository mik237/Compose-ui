package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.ibrahim.composepractice.R

@Preview(showBackground = true)
@Composable
fun BottomNavBar() {

    val bottomMenuListItem = prepareBottomMenu()
    var selectedItem by remember { mutableStateOf("Home") }

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Blue.copy(alpha = 0.05f),
    ) {
        bottomMenuListItem.forEachIndexed { index, bottomMenuItem ->
            if (index == 2) {
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { },
                    enabled = false
                )
            }
            NavigationBarItem(selected = selectedItem == bottomMenuItem.label,
                onClick = { selectedItem = bottomMenuItem.label },
                icon = { Icon(painter = bottomMenuItem.icon, contentDescription = "") },
                label = { Text(text = bottomMenuItem.label) })
        }
    }
}

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(
        BottomMenuItem(
            "Home",
            icon = painterResource(id = R.drawable.bottom_btn1)
        )
    )

    bottomMenuItemList.add(
        BottomMenuItem(
            "Profile",
            icon = painterResource(id = R.drawable.bottom_btn2)
        )
    )

    bottomMenuItemList.add(
        BottomMenuItem(
            "Support",
            icon = painterResource(id = R.drawable.bottom_btn3)
        )
    )

    bottomMenuItemList.add(
        BottomMenuItem(
            "Settings",
            icon = painterResource(id = R.drawable.bottom_btn4)
        )
    )
    return bottomMenuItemList
}


data class BottomMenuItem(val label: String, val icon: Painter)