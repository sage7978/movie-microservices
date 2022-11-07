package com.satishpatra.moviecatalogservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.time.Duration

@SpringBootApplication
class MovieCatalogServiceApplication

@Bean
fun restTemplate(): RestTemplate = RestTemplateBuilder()
	.setConnectTimeout(Duration.ofSeconds(10))
	.build()

fun main(args: Array<String>) {
	runApplication<MovieCatalogServiceApplication>(*args)
}
