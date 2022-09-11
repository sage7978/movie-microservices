package com.satishpatra.moviecatalogservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieCatalogServiceApplication

fun main(args: Array<String>) {
	runApplication<MovieCatalogServiceApplication>(*args)
}
