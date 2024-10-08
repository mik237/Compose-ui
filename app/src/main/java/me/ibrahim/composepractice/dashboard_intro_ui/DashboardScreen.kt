package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.ibrahim.composepractice.R

@Preview
@Composable
fun DashboardScreen() {

    Scaffold(
        containerColor = Color.White,
        bottomBar = { BottomNavBar() },
        floatingActionButton = {
            Box {
                FloatingActionButton(
                    modifier = Modifier.offset(y = 50.dp),
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    contentColor = Color.White,
                    containerColor = Color(0xFFFF9800)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.shopping_cart),
                        contentDescription = "fab",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Box(modifier = Modifier.padding(it)) {
            DashboardContent()
        }
    }
}
