package com.sleep.wetrade.screen

sealed class Screen(val route: String) {
    object Welcome : Screen("Welcome")
    object Login : Screen("Login")
    object Home : Screen("Home")
    object Positions : Screen("Positions")
}