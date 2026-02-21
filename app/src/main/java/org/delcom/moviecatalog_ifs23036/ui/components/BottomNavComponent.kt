package org.delcom.moviecatalog_ifs23036.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.delcom.moviecatalog_ifs23036.R
import org.delcom.moviecatalog_ifs23036.helper.Screen
import org.delcom.moviecatalog_ifs23036.theme.Blue40

@Composable
fun BottomNavComponent(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Screen.Home.route, R.drawable.ic_home),
        BottomNavItem("Movies", Screen.Galaxy.route, R.drawable.ic_movies),
        BottomNavItem("Favorites", Screen.SolarSystem.route, R.drawable.ic_favorite)
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.height(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Blue40,
                    selectedTextColor = Blue40,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Blue40.copy(alpha = 0.1f)
                )
            )
        }
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: Int
)