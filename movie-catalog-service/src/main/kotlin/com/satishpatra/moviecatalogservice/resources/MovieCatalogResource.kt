package com.satishpatra.moviecatalogservice.resources

import com.satishpatra.moviecatalogservice.models.CatalogItem
import com.satishpatra.moviecatalogservice.models.Movie
import com.satishpatra.moviecatalogservice.models.Rating
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(10))
        .build()

    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable userId: String): List<CatalogItem> {

        val rt = restTemplate()

        val ratings = Arrays.asList(
            Rating("1234", 4),
            Rating("5678", 3)
        )



        return ratings.stream().map { rating ->
            val movie = rt.getForObject("http://localhost:8082/movies/" + rating.movieId, Movie::class.java)
            CatalogItem(movie?.name ?: "Default", "Desc", rating.rating)
        }.collect(Collectors.toList())
    }
}