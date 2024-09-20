package me.ibrahim.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import me.ibrahim.composepractice.take_photo.TakePhotoScreen
import me.ibrahim.composepractice.top_app_bar.TopBarScreen
import me.ibrahim.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
//                    TopBarScreen(modifier = Modifier)
//                SideEffects()
//                GravatarProfileSummary()
//                TakePhotoScreen()
            }
        }
    }
}
