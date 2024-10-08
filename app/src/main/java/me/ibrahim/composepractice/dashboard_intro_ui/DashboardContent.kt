package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
        Spacer(modifier = Modifier.height(15.dp))

        ConstraintLayout {
            val (developing, designing, aiAndMl, explore) = createRefs()

            FeatureBoxUI(
                modifier = Modifier
                    .padding(end = 5.dp)
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
                    .padding(start = 5.dp)
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
                    .padding(end = 5.dp, top = 10.dp)
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(aiAndMl) {
                        top.linkTo(developing.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(explore.start)
                    },
                bgColor = Color(0xFFE91E63),
                title = "AI and ML",
                painter = painterResource(id = R.drawable.btn_3)
            )

            FeatureBoxUI(
                modifier = Modifier
                    .padding(start = 5.dp, top = 10.dp)
                    .fillMaxSize(fraction = 0.5f)
                    .constrainAs(explore) {
                        top.linkTo(designing.bottom)
                        start.linkTo(aiAndMl.end)
                        end.linkTo(parent.end)
                    },
                bgColor = Color(0xFF3F51B5),
                title = "Explore",
                painter = painterResource(id = R.drawable.btn_4)
            )

        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Popular Courses",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "See all",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(120.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xfffbe6dd),
                    shape = RoundedCornerShape(25.dp)
                )
                .background(
                    brush = Brush.horizontalGradient(colors = listOf(Color.White, Color(0xfffbe6dd))),
                    shape = RoundedCornerShape(12)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Advanced certification\nprogram in AI",
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Image(painter = painterResource(id = R.drawable.ai), contentDescription = null)
            }
        }
    }
}


