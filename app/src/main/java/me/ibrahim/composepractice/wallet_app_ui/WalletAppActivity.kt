package me.ibrahim.composepractice.wallet_app_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import me.ibrahim.composepractice.ui.theme.ComposePracticeTheme
import me.ibrahim.composepractice.wallet_app_ui.components.ActionsSection
import me.ibrahim.composepractice.wallet_app_ui.components.SpendingSection
import me.ibrahim.composepractice.wallet_app_ui.components.CardSection
import me.ibrahim.composepractice.wallet_app_ui.components.SpendingGraph
import me.ibrahim.composepractice.wallet_app_ui.components.TopBar

class WalletAppActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
                Scaffold(
                    topBar = {
                        TopBar(modifier = Modifier, scrollBehavior = scrollBehavior)
                    }, modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
                ) {
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletAppUI() {
    ComposePracticeTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
        Scaffold(
            topBar = {
                TopBar(modifier = Modifier, scrollBehavior = scrollBehavior)
            }, modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            MainScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(30.dp))
        CardSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(30.dp))
        ActionsSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(30.dp))
        SpendingSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(30.dp))
        SpendingGraph(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}