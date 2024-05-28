package com.ebc.allaroundcakemakerapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebc.allaroundcakemakerapp.enums.ScreensId
import com.ebc.allaroundcakemakerapp.views.onboarding.cupcakewizzard.SplashScreen

// Nos va ayudar a ver qué componente tenemos en pantalla
@Composable
fun NavManager() {
       val navController = rememberNavController()

       Scaffold() {
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
                            Text(text = "OnBoarding!!!!!")
                     }

              }
       }
}