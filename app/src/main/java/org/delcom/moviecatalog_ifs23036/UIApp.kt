package org.delcom.moviecatalog_ifs23036.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.delcom.moviecatalog_ifs23036.helper.Screen
import org.delcom.moviecatalog_ifs23036.ui.components.BottomNavComponent
import org.delcom.moviecatalog_ifs23036.ui.components.MovieAppBar
import org.delcom.moviecatalog_ifs23036.ui.screens.*

@Composable
fun UIApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Show bottom navigation only on main screens
    val showBottomNav = when (currentRoute) {
        Screen.Home.route, Screen.Galaxy.route, Screen.SolarSystem.route -> true
        else -> false
    }

    // Show top app bar on detail screen
    val showTopBar = currentRoute?.startsWith("detail") == true

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                BottomNavComponent(navController = navController)
            }
        },
        topBar = {
            if (showTopBar) {
                MovieAppBar(
                    title = "Movie Details",
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Screen.Detail.passId(movieId))
                    }
                )
            }
            composable(Screen.Galaxy.route) {
                GalaxyScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Screen.Detail.passId(movieId))
                    }
                )
            }
            composable(Screen.SolarSystem.route) {
                SolarSystemScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Screen.Detail.passId(movieId))
                    }
                )
            }
            composable(Screen.Detail.route) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
                DetailScreen(
                    movieId = movieId,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}