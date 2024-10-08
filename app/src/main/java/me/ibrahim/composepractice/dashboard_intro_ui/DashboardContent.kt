package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import me.ibrahim.composepractice.R

@Preview(showBackground = true)
@Composable
fun DashboardContent() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        NamedProfile()

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "What would you like to\nlearn today?",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        ConstraintLayout {
            val (developing, designing, aiAndMl, explore) = createRefs()

            FeatureBoxUI(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(developing) {
                        start.linkTo(parent.start)
                        end.linkTo(designing.start)
                    },
                bgColor = Color(0xFF009688),
                title = "Developing",
                painter = painterResource(id = R.drawable.btn_1)
            )

            FeatureBoxUI(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(designing) {
                        end.linkTo(parent.end)
                        start.linkTo(developing.end)
                    },
                bgColor = Color(0xFFFF9800),
                title = "Designing",
                painter = painterResource(id = R.drawable.btn_2)
            )

            FeatureBoxUI(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(aiAndMl) {
                        top.linkTo(developing.bottom)
                        start.linkTo(parent.start)
                    },
                bgColor = Color(0xFFE91E63),
                title = "AI and ML",
                painter = painterResource(id = R.drawable.btn_3)
            )

            FeatureBoxUI(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(explore) {
                        top.linkTo(designing.bottom)
                        start.linkTo(developing.end)
                        end.linkTo(parent.end)
                    },
                bgColor = Color(0xFF3F51B5),
                title = "Explore",
                painter = painterResource(id = R.drawable.btn_4)
            )

        }
    }
}


