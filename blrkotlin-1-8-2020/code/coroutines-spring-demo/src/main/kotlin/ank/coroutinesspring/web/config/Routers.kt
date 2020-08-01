package ank.coroutinesspring.web.config

import ank.coroutinesspring.web.handlers.CoroutinesHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class WebConfiguration(private val handler: CoroutinesHandler) {

    @Bean
    fun routes() = coRouter {
        (accept(MediaType.TEXT_HTML)).nest {
            GET("/", handler::handle)
        }
    }
}