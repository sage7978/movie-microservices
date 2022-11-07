package com.satishpatra.moviecatalogservice.resources

import com.satishpatra.moviecatalogservice.models.CatalogItem
import com.satishpatra.moviecatalogservice.models.Movie
import com.satishpatra.moviecatalogservice.models.Rating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var webClientBuilder: WebClient.Builder

    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String): List<CatalogItem> {

        val rt = restTemplate

//        WebClient.Builder

        val ratings = Arrays.asList(
            Rating("1234", 4),
            Rating("5678", 3)
        )



        return ratings.stream().map { rating ->
//            val movie = rt.getForObject("http://localhost:8082/movies/" + rating.movieId, Movie::class.java)

            val movie = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/movies/" + rating.movieId)
                .retrieve()
                .bodyToMono(Movie::class.java)
                .block()

            CatalogItem(movie?.name ?: "Default", "Desc", rating.rating)
        }.collect(Collectors.toList())
    }
}