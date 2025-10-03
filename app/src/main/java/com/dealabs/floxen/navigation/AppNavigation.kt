package com.dealabs.floxen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dealabs.floxen.ui.auth.AuthViewModel
import com.dealabs.floxen.ui.auth.LoginScreen
import com.dealabs.floxen.ui.auth.SignupScreen
import com.dealabs.floxen.ui.dashboard.DashboardScreen
import com.dealabs.floxen.ui.landing.LandingScreen

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Dashboard : Screen("dashboard")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Landing.route
    ) {
        composable(Screen.Landing.route) {
            LandingScreen(
                onLoginClick = { navController.navigate(Screen.Login.route) },
                onSignupClick = { navController.navigate(Screen.Signup.route) }
            )
        }
        
        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = authViewModel,
                onBackClick = { navController.popBackStack() },
                onLoginSuccess = { navController.navigate(Screen.Dashboard.route) }
            )
        }
        
        composable(Screen.Signup.route) {
            SignupScreen(
                viewModel = authViewModel,
                onBackClick = { navController.popBackStack() },
                onSignupSuccess = { navController.navigate(Screen.Dashboard.route) }
            )
        }
        
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                viewModel = authViewModel,
                onLogout = { 
                    navController.popBackStack(Screen.Landing.route, inclusive = false)
                }
            )
        }
    }
}