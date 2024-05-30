package com.ebc.allaroundcakemakerapp.views.onboarding.cupcakewizzard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ebc.allaroundcakemakerapp.R
import com.ebc.allaroundcakemakerapp.enums.ScreensId


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen (navController: NavController) {
    val pages = getPagesInfo()

    val pagerState = rememberPagerState(
        pageCount = { pages.size },
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalPager(state = pagerState) {

                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(pages[it].image)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                        .padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally)
                    )

                    Text(
                        text = pages[it].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = pages[it].desc,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.displaySmall,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 60.dp)
            ) {
                repeat(pages.size) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .height(10.dp)
                            .width(25.dp)
                            .clip(CircleShape)
                            .background(
                                if (it == pagerState.currentPage) {
                                    Color.Red
                                } else {
                                    Color.Gray
                                }
                            )
                    )
                }
            }

            Box(contentAlignment = Alignment.BottomCenter) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .fillMaxWidth()
                ) {
                    if (pagerState.currentPage == pages.size - 1) {
                        Button(onClick = {
                            navController.navigate(ScreensId.Home.name) {
                                popUpTo(0)
                            }
                        }) {
                            //on mouse over, change the text color to red
                            Text(text = "Entrar", modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .align(Alignment.CenterVertically),
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun getPagesInfo () : ArrayList<PageData> {
    val pages = ArrayList<PageData>()

    pages.add(
        PageData(
            image = R.raw.page1,
            title = stringResource( id = R.string.page1_title),
            desc = stringResource(R.string.page1_message)
        )
    )

    pages.add(
        PageData(
            image = R.raw.page2,
            title = stringResource( id = R.string.page2_title),
            desc = stringResource(R.string.page2_message)
        )
    )

    pages.add(
        PageData(
            image = R.raw.page3,
            title = stringResource( id = R.string.page3_title),
            desc = stringResource(R.string.page3_message)
        )
    )

    return pages
}

data class PageData(
    val image : Int,
    val title : String,
    val desc: String
)