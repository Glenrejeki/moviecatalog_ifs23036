package org.delcom.moviecatalog_ifs23036.helper

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Galaxy : Screen("galaxy")
    object SolarSystem : Screen("solar_system")
    object Detail : Screen("detail/{movieId}") {
        fun passId(movieId: Int): String = "detail/$movieId"
    }
}

object RouteHelper {
    const val ARG_MOVIE_ID = "movieId"
}