package com.ebc.allaroundcakemakerapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebc.allaroundcakemakerapp.R
import com.ebc.allaroundcakemakerapp.enums.ScreensId
import com.ebc.allaroundcakemakerapp.views.onboarding.cupcakewizzard.OnBoardingScreen
import com.ebc.allaroundcakemakerapp.views.onboarding.cupcakewizzard.SplashScreen

// Nos va ayudar a ver qué componente tenemos en pantalla
@Composable
fun NavManager() {
       val navController = rememberNavController()

       Scaffold(
              topBar = {

              }
       ) {
              NavHost(
                     navController = navController,
                     startDestination = ScreensId.Splash.name,
                     modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
              ) {
                     composable(ScreensId.Splash.name) {
                            SplashScreen(navController = navController)
                     }
                     composable(ScreensId.OnBoarding.name) {
                            OnBoardingScreen(navController = navController )
                     }

                     composable(ScreensId.Home.name) {
                            Text(text = "Home!!!!!!")
                     }

              }
       }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
       currentScreen: ScreensId,
       canNavigateBack: Boolean,
       navigateUp: () -> Unit,
       modifier: Modifier = Modifier
) {
       CenterAlignedTopAppBar(
              title = { Text(stringResource(currentScreen.title)) },
              colors = TopAppBarDefaults.mediumTopAppBarColors(
                     containerColor = MaterialTheme.colorScheme.primaryContainer
              ),
              modifier = modifier,
              navigationIcon = {
                     if (canNavigateBack) {
                            IconButton(onClick = navigateUp) {
                                   Icon(
                                          imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                          contentDescription = stringResource(R.string.back_button)
                                   )
                            }
                     }
              },
       )
}