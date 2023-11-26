package com.lbdemo.navigations

sealed class Screen(val route: String) {
    object DetailsScreen: Screen("details_screen")
}