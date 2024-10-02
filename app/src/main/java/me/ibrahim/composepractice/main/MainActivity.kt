package me.ibrahim.composepractice.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import me.ibrahim.composepractice.list_detail_pane.ListDetailLayout
import me.ibrahim.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Scaffold {
                    MainNavGraph(modifier = Modifier.padding(it))
                }

//                    TopBarScreen(modifier = Modifier)
//                SideEffects()
//                GravatarProfileSummary()
//                TakePhotoScreen()
            }
        }
    }
}
