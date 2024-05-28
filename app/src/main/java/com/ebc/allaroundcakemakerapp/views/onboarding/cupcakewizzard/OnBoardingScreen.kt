package com.ebc.allaroundcakemakerapp.views.onboarding.cupcakewizzard

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ebc.allaroundcakemakerapp.R



@Composable
fun OnBoardingScreen(navController: NavController){
    val pages = getPagesInfo()



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