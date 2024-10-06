package me.ibrahim.composepractice.dashboard_intro_ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun IntroScreen() {
    val context = LocalContext.current
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val (img, img2, logo, today, text) = createRefs()

        Image(painter = painterResource(id = R.drawable.top_tight),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(img) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                })


        Image(painter = painterResource(id = R.drawable.bottom_left),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(img2) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })


        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(40.dp)
                .constrainAs(logo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(img.bottom)
                }
        )


        Text(
            text = "Elevate your\nLearning Experience",
            fontSize = 26.sp, fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(text) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(logo.bottom)
                }
        )

        Image(painter = painterResource(id = R.drawable.today), contentDescription = "today",
            modifier = Modifier
                .padding(top = 0.dp)
                .size(120.dp)
                .clickable {
                    val intent = Intent(context, DashboardActivity::class.java)
                    context.startActivity(intent)
                }
                .constrainAs(today) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(text.bottom)
                })
    }
}