package org.delcom.moviecatalog_ifs23036.data

data class Movie(
    val id: Int,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val rating: Double,
    val duration: String,
    val synopsis: String,
    val imageUrl: String,
    val cast: List<String>,
    val isFavorite: Boolean = false
)

data class MovieCategory(
    val name: String,
    val movies: List<Movie>
)

object MoviesData {
    val nowPlayingMovies = listOf(
        Movie(
            id = 1,
            title = "Dune: Part Two",
            year = "2024",
            genre = "Sci-Fi/Adventure",
            director = "Denis Villeneuve",
            rating = 8.9,
            duration = "2h 46m",
            synopsis = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.",
            imageUrl = "https://image.tmdb.org/t/p/w500/dune2.jpg",
            cast = listOf("Timothée Chalamet", "Zendaya", "Rebecca Ferguson")
        ),
        Movie(
            id = 2,
            title = "Oppenheimer",
            year = "2023",
            genre = "Biography/Drama",
            director = "Christopher Nolan",
            rating = 8.5,
            duration = "3h",
            synopsis = "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.",
            imageUrl = "https://image.tmdb.org/t/p/w500/oppenheimer.jpg",
            cast = listOf("Cillian Murphy", "Emily Blunt", "Robert Downey Jr.")
        ),
        Movie(
            id = 3,
            title = "Poor Things",
            year = "2023",
            genre = "Comedy/Drama",
            director = "Yorgos Lanthimos",
            rating = 8.4,
            duration = "2h 21m",
            synopsis = "The incredible tale about the fantastical evolution of Bella Baxter, a young woman brought back to life by the brilliant and unorthodox scientist Dr. Godwin Baxter.",
            imageUrl = "https://image.tmdb.org/t/p/w500/poorthings.jpg",
            cast = listOf("Emma Stone", "Mark Ruffalo", "Willem Dafoe")
        )
    )

    val upcomingMovies = listOf(
        Movie(
            id = 4,
            title = "Deadpool 3",
            year = "2024",
            genre = "Action/Comedy",
            director = "Shawn Levy",
            rating = 0.0,
            duration = "N/A",
            synopsis = "Wolverine is recovering from his injuries when he crosses paths with the loudmouth, Deadpool. They team up to defeat a common enemy.",
            imageUrl = "https://image.tmdb.org/t/p/w500/deadpool3.jpg",
            cast = listOf("Ryan Reynolds", "Hugh Jackman", "Emma Corrin")
        ),
        Movie(
            id = 5,
            title = "Joker: Folie à Deux",
            year = "2024",
            genre = "Crime/Drama",
            director = "Todd Phillips",
            rating = 0.0,
            duration = "N/A",
            synopsis = "Sequel to the 2019 film 'Joker' featuring Arthur Fleck and his romance with Harley Quinn.",
            imageUrl = "https://image.tmdb.org/t/p/w500/joker2.jpg",
            cast = listOf("Joaquin Phoenix", "Lady Gaga", "Zazie Beetz")
        )
    )

    val popularMovies = listOf(
        Movie(
            id = 6,
            title = "The Batman",
            year = "2022",
            genre = "Action/Crime",
            director = "Matt Reeves",
            rating = 7.8,
            duration = "2h 56m",
            synopsis = "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
            imageUrl = "https://image.tmdb.org/t/p/w500/thebatman.jpg",
            cast = listOf("Robert Pattinson", "Zoë Kravitz", "Paul Dano")
        ),
        Movie(
            id = 7,
            title = "Interstellar",
            year = "2014",
            genre = "Sci-Fi/Drama",
            director = "Christopher Nolan",
            rating = 8.6,
            duration = "2h 49m",
            synopsis = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            imageUrl = "https://image.tmdb.org/t/p/w500/interstellar.jpg",
            cast = listOf("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain")
        )
    )

    val allCategories = listOf(
        MovieCategory("Now Playing", nowPlayingMovies),
        MovieCategory("Upcoming", upcomingMovies),
        MovieCategory("Popular", popularMovies)
    )
}