package me.ibrahim.composepractice.top_app_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen(modifier: Modifier = Modifier) {

    Scaffold {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
        Scaffold(
            modifier = modifier
                .padding(it)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { TopBar(scrollBehavior = scrollBehavior) },
        ) { padding ->
            ScreenContent(padding)
        }
    }


}


@Composable
fun ScreenContent(padding: PaddingValues) {
    data class ThemeData(
        val text: String,
        val style: TextStyle,
        val fontSize: TextUnit
    )

    val themesData = listOf(
        ThemeData(
            text = "displayLarge",
            style = MaterialTheme.typography.displayLarge,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "displayMedium",
            style = MaterialTheme.typography.displayMedium,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "displaySmall",
            style = MaterialTheme.typography.displaySmall,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "headlineLarge",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "headlineMedium",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "headlineSmall",
            style = MaterialTheme.typography.headlineSmall,
            fontSize = 15.sp
        ),


        ThemeData(
            text = "titleLarge",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "titleMedium",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "titleSmall",
            style = MaterialTheme.typography.titleSmall,
            fontSize = 15.sp
        ),


        ThemeData(
            text = "bodyLarge",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "bodyMedium",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "bodySmall",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "labelLarge",
            style = MaterialTheme.typography.labelLarge,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "labelMedium",
            style = MaterialTheme.typography.labelMedium,
            fontSize = 15.sp
        ),
        ThemeData(
            text = "labelSmall",
            style = MaterialTheme.typography.labelSmall,
            fontSize = 15.sp
        ),
    )

    LazyColumn(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        contentPadding = PaddingValues(top = padding.calculateTopPadding() + 16.dp)
    ) {

        items(themesData) { themeData ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = MaterialTheme.colorScheme.inversePrimary
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = themeData.text,
                    style = themeData.style,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}






