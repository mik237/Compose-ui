package me.ibrahim.composepractice.dashboard_intro_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF00BCD4))
                    .constrainAs(developing) {
                        start.linkTo(parent.start)
                        end.linkTo(designing.start)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.btn_1),
                        contentDescription = "developing",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Developing",
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.5f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFF9800))
                    .constrainAs(designing) {
                        end.linkTo(parent.end)
                        start.linkTo(developing.end)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.btn_1),
                        contentDescription = "developing",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Developing",
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun NamedProfile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .wrapContentSize()
                .clip(CircleShape),
            contentScale = ContentScale.Inside,
            painter = painterResource(id = R.drawable.user_1),
            contentDescription = "ProfileImage"
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "Hi, Alex",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}