package com.satishpatra.ratingsdataservice.resources

import com.satishpatra.ratingsdataservice.models.Rating
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/ratingsdata")
class RatingsResources {

    @GetMapping("/{movieId}")
    fun getRating(@PathVariable("movieId") movieId: String): Rating{
        return Rating(movieId, 4)
    }
}