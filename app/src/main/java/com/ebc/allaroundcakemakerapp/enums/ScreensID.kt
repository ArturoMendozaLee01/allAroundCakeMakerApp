package com.ebc.allaroundcakemakerapp.enums

import androidx.annotation.StringRes
import com.ebc.allaroundcakemakerapp.R

enum class ScreensId (@StringRes val title: Int) {
    Splash(title = R.string.Splash),
    OnBoarding(title = R.string.OnBoarding)
}