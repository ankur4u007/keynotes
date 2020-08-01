package ank.reactivespring.web.config

import ank.reactivespring.web.handlers.ReactiveHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class WebConfiguration(private val handler: ReactiveHandler) {

    @Bean
    fun routes() = router {
        (accept(MediaType.TEXT_HTML)).nest {
            GET("/", handler::handle)
        }
    }
}