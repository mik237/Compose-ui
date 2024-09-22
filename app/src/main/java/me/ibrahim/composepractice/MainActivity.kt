package me.ibrahim.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.ibrahim.composepractice.list_detail_pane.ListDetailLayout
import me.ibrahim.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                ListDetailLayout()
//                    TopBarScreen(modifier = Modifier)
//                SideEffects()
//                GravatarProfileSummary()
//                TakePhotoScreen()
            }
        }
    }
}
