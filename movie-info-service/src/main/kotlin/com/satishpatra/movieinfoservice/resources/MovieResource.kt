package com.satishpatra.movieinfoservice.resources

import com.satishpatra.movieinfoservice.resources.models.Movie
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/movies")
class MovieResource {

    @GetMapping("/{movieId}")
    fun getMovieInfo(@PathVariable movieId: String): Movie{
        return Movie(movieId, "Test Name")
    }
}